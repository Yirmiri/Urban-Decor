package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractStorageDecorBlock;
import net.yirmiri.urban_decor.common.block.entity.StorageApplianceBlockEntity;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.core.init.UDTags;

import java.util.HashMap;
import java.util.Map;

public class WashingMachineBlock extends AbstractStorageDecorBlock {
    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public static final BooleanProperty OPAQUE = BooleanProperty.create("opaque");

    private static final VoxelShape SHAPE_NORTH = Shapes.join(Block.box(1, 0, 1, 15, 12, 15),
            Block.box(1, 12, 13, 15, 16, 15), BooleanOp.OR);
    private static final VoxelShape SHAPE_EAST = Shapes.join(Block.box(1, 0, 1, 15, 12, 15),
            Block.box(1, 12, 1, 3, 16, 15), BooleanOp.OR);
    private static final VoxelShape SHAPE_WEST = Shapes.join(Block.box(1, 0, 1, 15, 12, 15),
            Block.box(13, 12, 1, 15, 16, 15), BooleanOp.OR);
    private static final VoxelShape SHAPE_SOUTH = Shapes.join(Block.box(1, 0, 1, 15, 12, 15),
            Block.box(1, 12, 1, 15, 16, 3), BooleanOp.OR);

    private final Map<BlockPos, Integer> explosionCountdown = new HashMap<>();

    public WashingMachineBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(TRUE_OPEN, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(OPEN, false).setValue(OPAQUE, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public void tick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource random) {
        if (explosionCountdown.containsKey(pos)) {
            if (explosionCountdown.get(pos) > 0) {
                explosionCountdown.put(pos, explosionCountdown.get(pos) - 1);
                serverLevel.scheduleTick(pos, this, 1);
                serverLevel.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.TRIPWIRE_CLICK_ON, SoundSource.BLOCKS, 1.0F, 1.0F);
                serverLevel.addParticle(ParticleTypes.SMOKE, true, pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ() + 0.5D, 0.1D * (Math.random() - 0.5), 0.25D * Math.random(), 0.1D * (Math.random() - 0.5));
            } else {
                serverLevel.explode(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 2.0F, Level.ExplosionInteraction.TNT);
                explosionCountdown.remove(pos);
            }
        }

        BlockEntity blockEntity = serverLevel.getBlockEntity(pos);
        if (blockEntity instanceof StorageApplianceBlockEntity) {
            ((StorageApplianceBlockEntity)blockEntity).tick();
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (stackHand.is(Items.BRICK) && world.hasNeighborSignal(pos)) {
            if (!world.isClientSide) {
                if (!explosionCountdown.containsKey(pos)) {
                    explosionCountdown.put(pos, 3 * 20);
                    world.scheduleTick(pos, this, 1);
                    stackHand.shrink(1);
                }
            }
            return InteractionResult.SUCCESS;
        }

        if (!world.isClientSide && blockEntity instanceof StorageApplianceBlockEntity && !stackHand.is(UDTags.ItemT.TOOLBOXES) && !stackHand.is(Items.BRICK) && !player.isShiftKeyDown()) {
            player.openMenu((StorageApplianceBlockEntity) blockEntity);
            //player.awardStat(UDStats.OPEN_APPLIANCES);
            PiglinAi.angerNearbyPiglins(player, true);
        }

        if (!stackHand.is(UDTags.ItemT.TOOLBOXES) && player.isShiftKeyDown()) {
            world.setBlockAndUpdate(pos, state.cycle(OPEN).cycle(TRUE_OPEN));
            if (state.getValue(OPEN)) {
                world.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            } else if (!state.getValue(OPEN)) {
                world.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
            return InteractionResult.SUCCESS;

        } else if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            world.setBlockAndUpdate(pos, state.cycle(OPAQUE));
            UDUtils.toolboxUsed(world, pos);
            player.displayClientMessage(Component.translatable("toolbox.washing_machine.variant_" + state.getValue(OPAQUE)), true);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, OPAQUE, TRUE_OPEN);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StorageApplianceBlockEntity(pos, state);
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomHoverName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StorageApplianceBlockEntity) {
                ((StorageApplianceBlockEntity)blockEntity).setCustomName(itemStack.getHoverName());
            }
        }
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            explosionCountdown.remove(pos);
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Container) {
                Containers.dropContents(world, pos, (Container)blockEntity);
                world.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, world, pos, newState, moved);
        }
    }
}

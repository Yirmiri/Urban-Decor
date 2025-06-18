package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractStorageDecorBlock;
import net.yirmiri.urban_decor.common.block.entity.StorageApplianceBlockEntity;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.core.init.UDTags;

public class FridgeBlock extends AbstractStorageDecorBlock {
    public static final BooleanProperty FLIPPED = BooleanProperty.create("flipped");
    public static final BooleanProperty TRUE_OPEN = BooleanProperty.create("true_open");
    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 16, 15);

    public FridgeBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(TRUE_OPEN, false).setValue(OPEN, false).setValue(FLIPPED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        state.getValue(FACING);
        return SHAPE;
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            level.setBlockAndUpdate(pos, state.cycle(FLIPPED));
            UDUtils.toolboxUsed(level, pos);
            player.displayClientMessage(Component.translatable("toolbox.fridge.variant_" + state.getValue(FLIPPED)), true);
            return ItemInteractionResult.SUCCESS;
        } else if (player.getMainHandItem().isEmpty() && player.isShiftKeyDown()) {
            level.setBlockAndUpdate(pos, state.cycle(OPEN).cycle(TRUE_OPEN));
            if (state.getValue(OPEN)) {
                playSound(level, pos, state, SoundEvents.CHERRY_WOOD_DOOR_CLOSE);
            } else if (!state.getValue(OPEN)) {
                playSound(level, pos, state, SoundEvents.CHERRY_WOOD_DOOR_OPEN);
            }
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!player.getMainHandItem().getItem().getDefaultInstance().is(UDTags.ItemT.TOOLBOXES)) {
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                if (blockEntity instanceof StorageApplianceBlockEntity && !player.isShiftKeyDown()) {
                    player.openMenu((StorageApplianceBlockEntity) blockEntity);
                    //player.awardStat(UDStats.OPEN_APPLIANCES);
                    PiglinAi.angerNearbyPiglins(player, true);
                }
            }
        }
        return InteractionResult.CONSUME;
    }

    void playSound(Level world, BlockPos pos, BlockState state, SoundEvent soundEvent) {
        Vec3i vec3i = (state.getValue(AbstractStorageDecorBlock.FACING)).getNormal();
        double d = (double)pos.getX() + 0.5 + (double)vec3i.getX() / 2.0;
        double e = (double)pos.getY() + 0.5 + (double)vec3i.getY() / 2.0;
        double f = (double)pos.getZ() + 0.5 + (double)vec3i.getZ() / 2.0;
        world.playSound(null, d, e, f, soundEvent, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, FLIPPED, TRUE_OPEN);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StorageApplianceBlockEntity(pos, state);
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

//    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
//        if (itemStack.hasCustomHoverName()) {
//            BlockEntity blockEntity = world.getBlockEntity(pos);
//            if (blockEntity instanceof StorageApplianceBlockEntity) {
//                ((StorageApplianceBlockEntity)blockEntity).setCustomName(itemStack.getHoverName());
//            }
//        }
//    }

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
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Container) {
                Containers.dropContents(world, pos, (Container)blockEntity);
                world.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, world, pos, newState, moved);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof StorageApplianceBlockEntity) {
            ((StorageApplianceBlockEntity)blockEntity).recheckOpen();
        }
    }
}

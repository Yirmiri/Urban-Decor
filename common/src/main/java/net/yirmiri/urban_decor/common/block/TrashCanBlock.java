package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractMiniStorageDecorBlock;
import net.yirmiri.urban_decor.common.block.entity.MiniStorageApplianceBlockEntity;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.core.init.UDStats;
import net.yirmiri.urban_decor.core.init.UDTags;

public class TrashCanBlock extends AbstractMiniStorageDecorBlock {
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 2);

    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 12, 12);

    private static final VoxelShape SHAPE_THIN_SN = Block.box(3, 0, 5, 13, 12, 11);
    private static final VoxelShape SHAPE_THIN_EW = Block.box(5, 0, 3, 11, 12, 13);

    public TrashCanBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(VARIANT, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        int variant = state.getValue(VARIANT);
        return switch (state.getValue(FACING)) {
            case WEST, EAST -> variant == 2 ? SHAPE_THIN_EW : SHAPE;
            default -> variant == 2 ? SHAPE_THIN_SN : SHAPE;
        };
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (world.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            if (blockEntity instanceof MiniStorageApplianceBlockEntity && !stackHand.is(UDTags.ItemT.TOOLBOXES) && !player.isShiftKeyDown()) {
                player.openMenu((MiniStorageApplianceBlockEntity) blockEntity);
                //player.awardStat(UDStats.OPEN_APPLIANCES);
                PiglinAi.angerNearbyPiglins(player, true);
            }
        }
        if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            world.setBlockAndUpdate(pos, state.cycle(VARIANT));
            UDUtils.toolboxUsed(world, pos);
            player.displayClientMessage(Component.translatable("toolbox.trash_can.variant_" + state.getValue(VARIANT)), true);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT, OPEN, TRUE_OPEN);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MiniStorageApplianceBlockEntity(pos, state);
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomHoverName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MiniStorageApplianceBlockEntity) {
                ((MiniStorageApplianceBlockEntity)blockEntity).setCustomName(itemStack.getHoverName());
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
        if (blockEntity instanceof MiniStorageApplianceBlockEntity) {
            ((MiniStorageApplianceBlockEntity)blockEntity).tick();
        }
    }
}

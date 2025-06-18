package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
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
import net.yirmiri.urban_decor.core.init.UDTags;

public class DishwasherBlock extends AbstractStorageDecorBlock {
    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    private static final VoxelShape SHAPE_NORTH = Shapes.join(Block.box(0, 0, 4, 16, 14, 16),
            Block.box(0, 14, 2, 16, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_WEST = Shapes.join(Block.box(4, 0, 0, 16, 14, 16),
            Block.box(2, 14, 0, 16, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_EAST = Shapes.join(Block.box(0, 0, 0, 12, 14, 16),
            Block.box(0, 14, 0, 14, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_SOUTH = Shapes.join(Block.box(0, 0, 0, 16, 14, 12),
            Block.box(0, 14, 0, 16, 16, 14), BooleanOp.OR);

    public DishwasherBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(TRUE_OPEN, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(OPEN, false));
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
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!player.getMainHandItem().getItem().getDefaultInstance().is(UDTags.ItemT.TOOLBOXES)) {
            if (!level.isClientSide && blockEntity instanceof StorageApplianceBlockEntity && !player.isShiftKeyDown()) {
                player.openMenu((StorageApplianceBlockEntity) blockEntity);
                //player.awardStat(UDStats.OPEN_APPLIANCES);
                PiglinAi.angerNearbyPiglins(player, true);
            }

            if (player.isShiftKeyDown()) {
                level.setBlockAndUpdate(pos, state.cycle(OPEN).cycle(TRUE_OPEN));
                if (state.getValue(OPEN)) {
                    level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                } else if (!state.getValue(OPEN)) {
                    level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, TRUE_OPEN);
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

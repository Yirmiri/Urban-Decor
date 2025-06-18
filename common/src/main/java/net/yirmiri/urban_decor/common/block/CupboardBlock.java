package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractStorageDecorBlock;
import net.yirmiri.urban_decor.common.block.entity.StorageApplianceBlockEntity;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDItems;

public class CupboardBlock extends AbstractStorageDecorBlock {
    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public static final BooleanProperty TRUE_OPEN = BooleanProperty.create("true_open");
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 3);

    private static final VoxelShape SHAPE_NORTH = Shapes.join(Block.box(2, 0, 4, 14, 14, 16), Block.box(0, 14, 2, 16, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_SOUTH = Shapes.join(Block.box(2, 0, 0, 14, 14, 12), Block.box(0, 14, 0, 16, 16, 14), BooleanOp.OR);
    private static final VoxelShape SHAPE_WEST = Shapes.join(Block.box(4, 0, 2, 16, 14, 14), Block.box(2, 14, 0, 16, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_EAST = Shapes.join(Block.box(0, 0, 2, 12, 14, 14), Block.box(0, 14, 0, 14, 16, 16), BooleanOp.OR);

    private static final VoxelShape SHAPE_NORTH_BARE = Shapes.join(Block.box(2, 0, 4, 14, 14, 16), Block.box(2, 14, 4, 14, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_SOUTH_BARE = Shapes.join(Block.box(2, 0, 0, 14, 14, 12), Block.box(2, 14, 0, 14, 16, 12), BooleanOp.OR);
    private static final VoxelShape SHAPE_EAST_BARE = Shapes.join(Block.box(0, 0, 2, 12, 14, 14), Block.box(0, 14, 2, 12, 16, 14), BooleanOp.OR);
    private static final VoxelShape SHAPE_WEST_BARE = Shapes.join(Block.box(4, 0, 2, 16, 14, 14), Block.box(4, 14, 2, 16, 16, 14), BooleanOp.OR);

    private static final VoxelShape SHAPE_FULL_NORTH = Shapes.join(Block.box(0, 0, 4, 16, 14, 16), Block.box(0, 14, 2, 16, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_FULL_SOUTH = Shapes.join(Block.box(0, 0, 0, 16, 14, 12), Block.box(0, 14, 0, 16, 16, 14), BooleanOp.OR);
    private static final VoxelShape SHAPE_FULL_WEST = Shapes.join(Block.box(4, 0, 0, 16, 14, 16), Block.box(2, 14, 0, 16, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_FULL_EAST = Shapes.join(Block.box(0, 0, 0, 12, 14, 16), Block.box(0, 14, 0, 14, 16, 16), BooleanOp.OR);

    private static final VoxelShape SHAPE_FULL_NORTH_BARE = Shapes.join(Block.box(0, 0, 4, 16, 14, 16), Block.box(0, 14, 4, 16, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_FULL_SOUTH_BARE = Shapes.join(Block.box(0, 0, 0, 16, 14, 12), Block.box(0, 14, 0, 16, 16, 12), BooleanOp.OR);
    private static final VoxelShape SHAPE_FULL_WEST_BARE = Shapes.join(Block.box(4, 0, 0, 16, 14, 16), Block.box(4, 14, 0, 16, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_FULL_EAST_BARE = Shapes.join(Block.box(0, 0, 0, 12, 14, 16), Block.box(0, 14, 0, 12, 16, 16), BooleanOp.OR);

    public CupboardBlock(BlockBehaviour.Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(TRUE_OPEN, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(VARIANT, 2).setValue(OPEN, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        int variant = state.getValue(VARIANT);
        boolean fullsize = variant == 0 || variant == 1;
        if (fullsize) {
            return switch (state.getValue(FACING)) {
                case SOUTH -> variant == 1 ? SHAPE_FULL_SOUTH_BARE : SHAPE_FULL_SOUTH;
                case WEST -> variant == 1 ? SHAPE_FULL_WEST_BARE : SHAPE_FULL_WEST;
                case EAST -> variant == 1 ? SHAPE_FULL_EAST_BARE : SHAPE_FULL_EAST;
                default -> variant == 1 ? SHAPE_FULL_NORTH_BARE : SHAPE_FULL_NORTH;
            };
        } else {
            return switch (state.getValue(FACING)) {
                case SOUTH -> variant == 3 ? SHAPE_SOUTH_BARE : SHAPE_SOUTH;
                case WEST -> variant == 3 ? SHAPE_WEST_BARE : SHAPE_WEST;
                case EAST -> variant == 3 ? SHAPE_EAST_BARE : SHAPE_EAST;
                default -> variant == 3 ? SHAPE_NORTH_BARE : SHAPE_NORTH;
            };
        }
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            level.setBlockAndUpdate(pos, state.cycle(VARIANT));
            UDUtils.toolboxUsed(level, pos);
            player.displayClientMessage(Component.translatable("toolbox.cupboard.variant_" + state.getValue(VARIANT)), true);
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
                if (blockEntity instanceof StorageApplianceBlockEntity) {
                    player.openMenu((StorageApplianceBlockEntity) blockEntity);
                    //player.awardStat(UDStats.OPEN_APPLIANCES);
                    PiglinAi.angerNearbyPiglins(player, true);
                }
            }
        }
        return InteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT, OPEN, TRUE_OPEN);
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
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        Containers.dropContentsOnDestroy(state, newState, level, pos);
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof StorageApplianceBlockEntity) {
            ((StorageApplianceBlockEntity)blockEntity).recheckOpen();
        }
    }
}

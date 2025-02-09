package net.yirmiri.urban_decor.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.abstracts.AbstractStorageDecorBlock;
import net.yirmiri.urban_decor.block.entity.StorageApplianceBlockEntity;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.util.UDStats;
import net.yirmiri.urban_decor.util.UDUtils;
import org.jetbrains.annotations.Nullable;

public class CupboardBlock extends AbstractStorageDecorBlock {
    public static final IntProperty VARIANT = IntProperty.of("variant", 0, 3);

    private static final VoxelShape SHAPE_NORTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 0, 4, 14, 14, 16), Block.createCuboidShape(0, 14, 2, 16, 16, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_SOUTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 0, 0, 14, 14, 12), Block.createCuboidShape(0, 14, 0, 16, 16, 14), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_WEST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(4, 0, 2, 16, 14, 14), Block.createCuboidShape(2, 14, 0, 16, 16, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_EAST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 2, 12, 14, 14), Block.createCuboidShape(0, 14, 0, 14, 16, 16), BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_NORTH_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 0, 4, 14, 14, 16), Block.createCuboidShape(2, 14, 4, 14, 16, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_SOUTH_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 0, 0, 14, 14, 12), Block.createCuboidShape(2, 14, 0, 14, 16, 12), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_EAST_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 2, 12, 14, 14), Block.createCuboidShape(0, 14, 2, 12, 16, 14), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_WEST_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(4, 0, 2, 16, 14, 14), Block.createCuboidShape(4, 14, 2, 16, 16, 14), BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_FULL_NORTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 4, 16, 14, 16), Block.createCuboidShape(0, 14, 2, 16, 16, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_FULL_SOUTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 16, 14, 12), Block.createCuboidShape(0, 14, 0, 16, 16, 14), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_FULL_WEST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(4, 0, 0, 16, 14, 16), Block.createCuboidShape(2, 14, 0, 16, 16, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_FULL_EAST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 12, 14, 16), Block.createCuboidShape(0, 14, 0, 14, 16, 16), BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_FULL_NORTH_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 4, 16, 14, 16), Block.createCuboidShape(0, 14, 4, 16, 16, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_FULL_SOUTH_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 16, 14, 12), Block.createCuboidShape(0, 14, 0, 16, 16, 12), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_FULL_WEST_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(4, 0, 0, 16, 14, 16), Block.createCuboidShape(4, 14, 0, 16, 16, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_FULL_EAST_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 12, 14, 16), Block.createCuboidShape(0, 14, 0, 12, 16, 16), BooleanBiFunction.OR);

    public CupboardBlock(AbstractBlock.Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(TRUE_OPEN, false).with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(VARIANT, 2).with(OPEN, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        int variant = state.get(VARIANT);
        boolean fullsize = variant == 0 || variant == 1;
        if (fullsize) {
            return switch (state.get(FACING)) {
                case SOUTH -> variant == 1 ? SHAPE_FULL_SOUTH_BARE : SHAPE_FULL_SOUTH;
                case WEST -> variant == 1 ? SHAPE_FULL_WEST_BARE : SHAPE_FULL_WEST;
                case EAST -> variant == 1 ? SHAPE_FULL_EAST_BARE : SHAPE_FULL_EAST;
                default -> variant == 1 ? SHAPE_FULL_NORTH_BARE : SHAPE_FULL_NORTH;
            };
        } else {
            return switch (state.get(FACING)) {
                case SOUTH -> variant == 3 ? SHAPE_SOUTH_BARE : SHAPE_SOUTH;
                case WEST -> variant == 3 ? SHAPE_WEST_BARE : SHAPE_WEST;
                case EAST -> variant == 3 ? SHAPE_EAST_BARE : SHAPE_EAST;
                default -> variant == 3 ? SHAPE_NORTH_BARE : SHAPE_NORTH;
            };
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            if (blockEntity instanceof StorageApplianceBlockEntity && !stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
                player.openHandledScreen((StorageApplianceBlockEntity)blockEntity);
                player.incrementStat(UDStats.OPEN_APPLIANCES);
                PiglinBrain.onGuardedBlockInteracted(player, true);
            }

            if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
                world.setBlockState(pos, state.cycle(VARIANT));
                UDUtils.toolboxUsed(world, pos);
                player.sendMessage(Text.translatable("toolbox.cupboard.variant_" + state.get(VARIANT)), true);
                return ActionResult.SUCCESS;
            }
            return ActionResult.CONSUME;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT, OPEN, TRUE_OPEN);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StorageApplianceBlockEntity(pos, state);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StorageApplianceBlockEntity) {
                ((StorageApplianceBlockEntity)blockEntity).setCustomName(itemStack.getName());
            }
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Inventory) {
                ItemScatterer.spawn(world, pos, (Inventory)blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof StorageApplianceBlockEntity) {
            ((StorageApplianceBlockEntity)blockEntity).tick();
        }
    }
}

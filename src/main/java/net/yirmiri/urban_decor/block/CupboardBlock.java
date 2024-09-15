package net.yirmiri.urban_decor.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.util.UDUtils;

public class CupboardBlock extends AbstractDecorBlock {
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
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(VARIANT, 0));
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
        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(VARIANT));
            UDUtils.toolboxUsed(world, pos);
            player.sendMessage(Text.translatable("toolbox.cupboard.variant_" + state.get(VARIANT)), true);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT);
    }
}

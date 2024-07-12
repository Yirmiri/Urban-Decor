package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ShowerBlock extends AbstractDecorBlock {
    private static final VoxelShape SHAPE_NORTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(7, 8, 8, 9, 10, 18),
            Block.createCuboidShape(5, 6, 6, 11, 8, 12), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_WEST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 8, 7, 18, 10, 9),
            Block.createCuboidShape(6, 6, 5, 12, 8, 11), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_EAST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(-2, 8, 7, 8, 10, 9),
            Block.createCuboidShape(4, 6, 5, 10, 8, 11), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_SOUTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(7, 8, -2, 9, 10, 8),
            Block.createCuboidShape(5, 6, 4, 11, 8, 10), BooleanBiFunction.OR);

    public ShowerBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return switch (state.get(FACING)) {
            default -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
}

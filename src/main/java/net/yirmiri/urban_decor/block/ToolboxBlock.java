package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ToolboxBlock extends WaterloggableHorizontalFacingBlock {
    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(1, 0, 4, 15, 8, 12);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(4, 0, 1, 12, 8, 15);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(4, 0, 1, 12, 8, 15);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(1, 0, 4, 15, 8, 12);

    public ToolboxBlock(Settings settings) {
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

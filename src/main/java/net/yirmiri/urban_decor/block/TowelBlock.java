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

public class TowelBlock extends AbstractDecorBlock {
    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(0, 0, 2, 16, 0.5, 14);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(2, 0, 0, 14, 0.5, 16);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(2, 0, 0, 14, 0.5, 16);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(0, 0, 2, 16, 0.5, 14);

    public TowelBlock(Settings settings) {
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

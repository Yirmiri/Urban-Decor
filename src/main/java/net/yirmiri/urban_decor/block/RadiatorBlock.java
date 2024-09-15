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

public class RadiatorBlock extends AbstractDecorBlock {
    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(1, 2, 14, 15, 14, 16);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(14, 2, 1, 16, 14, 15);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(0, 2, 1, 2, 14, 15);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(1, 2, 0, 15, 14, 2);

    public RadiatorBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return switch (state.get(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
}

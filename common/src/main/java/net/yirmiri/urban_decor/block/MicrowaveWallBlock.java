package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class MicrowaveWallBlock extends MicrowaveBlock {
    private static final VoxelShape SHAPE_NORTH_WALL = Block.createCuboidShape(2, 6, 9, 14, 14, 16);
    private static final VoxelShape SHAPE_EAST_WALL = Block.createCuboidShape(0, 6, 2, 7, 14, 14);
    private static final VoxelShape SHAPE_WEST_WALL = Block.createCuboidShape(9, 6, 2, 16, 14, 14);
    private static final VoxelShape SHAPE_SOUTH_WALL = Block.createCuboidShape(2, 6, 0, 14, 14, 7);

    public MicrowaveWallBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(TRUE_OPEN, false).with(OPEN, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return switch (state.get(FACING)) {
            case SOUTH -> SHAPE_SOUTH_WALL;
            case WEST -> SHAPE_WEST_WALL;
            case EAST -> SHAPE_EAST_WALL;
            default -> SHAPE_NORTH_WALL;
        };
    }
}
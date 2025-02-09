package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class PictureFrameWallBlock extends PictureFrameBlock {
    private static final VoxelShape SHAPE_NORTH_WALL = Block.createCuboidShape(3, 2, 13.75, 13, 14, 15.75);
    private static final VoxelShape SHAPE_WEST_WALL = Block.createCuboidShape(14, 2, 2.75, 16, 14, 12.75);
    private static final VoxelShape SHAPE_EAST_WALL = Block.createCuboidShape(0, 2, 2.75, 2, 14, 12.75);
    private static final VoxelShape SHAPE_SOUTH_WALL = Block.createCuboidShape(3, 2, -0.25, 13, 14, 1.75);

    public PictureFrameWallBlock(Settings settings) {
        super(settings);
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

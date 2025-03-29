package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PictureFrameWallBlock extends PictureFrameBlock {
    private static final VoxelShape SHAPE_NORTH_WALL = Block.box(3, 2, 13.75, 13, 14, 15.75);
    private static final VoxelShape SHAPE_WEST_WALL = Block.box(14, 2, 2.75, 16, 14, 12.75);
    private static final VoxelShape SHAPE_EAST_WALL = Block.box(0, 2, 2.75, 2, 14, 12.75);
    private static final VoxelShape SHAPE_SOUTH_WALL = Block.box(3, 2, -0.25, 13, 14, 1.75);

    public PictureFrameWallBlock(Properties settings) {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH_WALL;
            case WEST -> SHAPE_WEST_WALL;
            case EAST -> SHAPE_EAST_WALL;
            default -> SHAPE_NORTH_WALL;
        };
    }
}

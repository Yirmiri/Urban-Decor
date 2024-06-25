package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class MicrowaveBlock extends AbstractWaterloggableHorizontalFacingBlock {
    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(2, 0, 8, 14, 8, 15);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(1, 0, 2, 8, 8, 14);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(8, 0, 2, 15, 8, 14);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(2, 0, 1, 14, 8, 8);

    public MicrowaveBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        switch (state.get(FACING)) {
            default:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case WEST:
                return SHAPE_WEST;
            case EAST:
                return SHAPE_EAST;
        }
    }
}

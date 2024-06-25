package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class TrashCanBlock extends AbstractWaterloggableHorizontalFacingBlock {
    private static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 12, 12);

    public TrashCanBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        state.get(FACING);
        return SHAPE;
    }
}

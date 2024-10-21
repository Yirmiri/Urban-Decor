package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class StainlessSteelLanternBlock extends LanternBlock {
    protected static final VoxelShape STANDING_SHAPE = Block.createCuboidShape(5, 0, 5, 11, 8, 11);
    protected static final VoxelShape HANGING_SHAPE = Block.createCuboidShape(5, 4, 5, 11, 12, 11);

    public StainlessSteelLanternBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(HANGING) ? HANGING_SHAPE : STANDING_SHAPE;
    }
}

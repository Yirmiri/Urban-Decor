package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StainlessSteelLanternBlock extends LanternBlock {
    protected static final VoxelShape STANDING_SHAPE = Block.box(5, 0, 5, 11, 8, 11);
    protected static final VoxelShape HANGING_SHAPE = Block.box(5, 4, 5, 11, 12, 11);

    public StainlessSteelLanternBlock(Properties settings) {
        super(settings);
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(HANGING) ? HANGING_SHAPE : STANDING_SHAPE;
    }
}

package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MicrowaveWallBlock extends MicrowaveBlock {
    private static final VoxelShape SHAPE_NORTH_WALL = Block.box(2, 6, 9, 14, 14, 16);
    private static final VoxelShape SHAPE_EAST_WALL = Block.box(0, 6, 2, 7, 14, 14);
    private static final VoxelShape SHAPE_WEST_WALL = Block.box(9, 6, 2, 16, 14, 14);
    private static final VoxelShape SHAPE_SOUTH_WALL = Block.box(2, 6, 0, 14, 14, 7);

    public MicrowaveWallBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(TRUE_OPEN, false).setValue(OPEN, false));
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
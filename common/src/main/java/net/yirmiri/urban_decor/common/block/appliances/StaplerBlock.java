package net.yirmiri.urban_decor.common.block.appliances;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;

import java.util.stream.Stream;

public class StaplerBlock extends AbstractDecorBlock {
    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(6, 0, 6, 12, 1, 10),
            Block.box(6, 3, 6, 12, 5, 10),
            Block.box(4, 0, 6, 6, 5, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.box(6, 0, 6, 10, 1, 12),
            Block.box(6, 3, 6, 10, 5, 12),
            Block.box(6, 0, 4, 10, 5, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.box(6, 0, 4, 10, 1, 10),
            Block.box(6, 3, 4, 10, 5, 10),
            Block.box(6, 0, 10, 10, 5, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.box(4, 0, 6, 10, 1, 10),
            Block.box(4, 3, 6, 10, 5, 10),
            Block.box(10, 0, 6, 12, 5, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public StaplerBlock(Properties settings) {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }
}

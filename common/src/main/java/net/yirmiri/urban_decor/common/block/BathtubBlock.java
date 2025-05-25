package net.yirmiri.urban_decor.common.block;

import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractLongBlock;

import java.util.stream.Stream;

public class BathtubBlock extends AbstractLongBlock {
    private static final VoxelShape BACK_NORTH = Stream.of(Block.box(0, 0, 0, 16, 3, 16), Block.box(0, 3, 0, 2, 16, 16), Block.box(14, 3, 0, 16, 16, 16), Block.box(2, 3, 14, 14, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BACK_EAST = Stream.of(Block.box(0, 0, 0, 16, 3, 16), Block.box(0, 3, 0, 16, 16, 2), Block.box(0, 3, 14, 16, 16, 16), Block.box(0, 3, 2, 2, 16, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BACK_WEST = Stream.of(Block.box(0, 0, 0, 16, 3, 16), Block.box(0, 3, 14, 16, 16, 16), Block.box(0, 3, 0, 16, 16, 2), Block.box(14, 3, 2, 16, 16, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BACK_SOUTH = Stream.of(Block.box(0, 0, 0, 16, 3, 16), Block.box(14, 3, 0, 16, 16, 16), Block.box(0, 3, 0, 2, 16, 16), Block.box(2, 3, 0, 14, 16, 2)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape FRONT_NORTH = Stream.of(Block.box(0, 0, 0, 16, 3, 16), Block.box(0, 3, 0, 2, 16, 16), Block.box(14, 3, 0, 16, 16, 16), Block.box(2, 3, 0, 14, 16, 2)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape FRONT_EAST = Stream.of(Block.box(0, 0, 0, 16, 3, 16), Block.box(0, 3, 0, 16, 16, 2), Block.box(0, 3, 14, 16, 16, 16), Block.box(14, 3, 2, 16, 16, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape FRONT_WEST = Stream.of(Block.box(0, 0, 0, 16, 3, 16), Block.box(0, 3, 14, 16, 16, 16), Block.box(0, 3, 0, 16, 16, 2), Block.box(0, 3, 2, 2, 16, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape FRONT_SOUTH = Stream.of(Block.box(0, 0, 0, 16, 3, 16), Block.box(14, 3, 0, 16, 16, 16), Block.box(0, 3, 0, 2, 16, 16), Block.box(2, 3, 14, 14, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public BathtubBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(PART, BedPart.FOOT));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        BedPart head = BedPart.HEAD;
        if (state.getValue(PART) == head)
            return switch (state.getValue(FACING)) {
                case SOUTH -> FRONT_SOUTH;
                case WEST -> FRONT_WEST;
                case EAST -> FRONT_EAST;
                default -> FRONT_NORTH;
            };
        else return switch (state.getValue(FACING)) {
            case SOUTH -> BACK_SOUTH;
                case WEST -> BACK_WEST;
                case EAST -> BACK_EAST;
            default -> BACK_NORTH;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, PART);
    }
}

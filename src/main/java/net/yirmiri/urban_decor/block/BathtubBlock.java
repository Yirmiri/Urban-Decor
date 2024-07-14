package net.yirmiri.urban_decor.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.BedPart;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class BathtubBlock extends AbstractLongBlock {
    private static final VoxelShape BACK_NORTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 3, 16),
            Block.createCuboidShape(0, 3, 0, 2, 16, 16),
            Block.createCuboidShape(14, 3, 0, 16, 16, 16),
            Block.createCuboidShape(2, 3, 14, 14, 16, 16)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape BACK_EAST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 3, 16),
            Block.createCuboidShape(0, 3, 0, 16, 16, 2),
            Block.createCuboidShape(0, 3, 14, 16, 16, 16),
            Block.createCuboidShape(0, 3, 2, 2, 16, 14)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape BACK_WEST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 3, 16),
            Block.createCuboidShape(0, 3, 14, 16, 16, 16),
            Block.createCuboidShape(0, 3, 0, 16, 16, 2),
            Block.createCuboidShape(14, 3, 2, 16, 16, 14)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape BACK_SOUTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 3, 16),
            Block.createCuboidShape(14, 3, 0, 16, 16, 16),
            Block.createCuboidShape(0, 3, 0, 2, 16, 16),
            Block.createCuboidShape(2, 3, 0, 14, 16, 2)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape FRONT_NORTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 3, 16),
            Block.createCuboidShape(0, 3, 0, 2, 16, 16),
            Block.createCuboidShape(14, 3, 0, 16, 16, 16),
            Block.createCuboidShape(2, 3, 0, 14, 16, 2)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape FRONT_EAST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 3, 16),
            Block.createCuboidShape(0, 3, 0, 16, 16, 2),
            Block.createCuboidShape(0, 3, 14, 16, 16, 16),
            Block.createCuboidShape(14, 3, 2, 16, 16, 14)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape FRONT_WEST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 3, 16),
            Block.createCuboidShape(0, 3, 14, 16, 16, 16),
            Block.createCuboidShape(0, 3, 0, 16, 16, 2),
            Block.createCuboidShape(0, 3, 2, 2, 16, 14)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape FRONT_SOUTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 3, 16),
            Block.createCuboidShape(14, 3, 0, 16, 16, 16),
            Block.createCuboidShape(0, 3, 0, 2, 16, 16),
            Block.createCuboidShape(2, 3, 14, 14, 16, 16)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public BathtubBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(PART, BedPart.FOOT));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        BedPart head = BedPart.HEAD;
        if (state.get(PART) == head)
            return switch (state.get(FACING)) {
                default -> FRONT_NORTH;
                case SOUTH -> FRONT_SOUTH;
                case WEST -> FRONT_WEST;
                case EAST -> FRONT_EAST;
            };
        else return switch (state.get(FACING)) {
                default -> BACK_NORTH;
                case SOUTH -> BACK_SOUTH;
                case WEST -> BACK_WEST;
                case EAST -> BACK_EAST;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, PART);
    }
}

package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BedPart;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.abstracts.AbstractLongBlock;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class PianoBlock extends AbstractLongBlock {
    private static final VoxelShape BACK_NORTH = Stream.of(
            Block.createCuboidShape(0, 0, 12, 16, 16, 16),
            Block.createCuboidShape(8, 0, 0, 16, 10, 12),
            Block.createCuboidShape(3, 10, 0, 11, 14, 12),
            Block.createCuboidShape(11, 10, 0, 16, 16, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape BACK_EAST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 4, 16, 16),
            Block.createCuboidShape(4, 0, 8, 16, 10, 16),
            Block.createCuboidShape(4, 10, 3, 16, 14, 11),
            Block.createCuboidShape(4, 10, 11, 16, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape BACK_WEST = Stream.of(
            Block.createCuboidShape(12, 0, 0, 16, 16, 16),
            Block.createCuboidShape(0, 0, 0, 12, 10, 8),
            Block.createCuboidShape(0, 10, 5, 12, 14, 13),
            Block.createCuboidShape(0, 10, 0, 12, 16, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape BACK_SOUTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 16, 4),
            Block.createCuboidShape(0, 0, 4, 8, 10, 16),
            Block.createCuboidShape(5, 10, 4, 13, 14, 16),
            Block.createCuboidShape(0, 10, 4, 5, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape FRONT_NORTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 16, 4),
            Block.createCuboidShape(8, 0, 4, 16, 10, 16),
            Block.createCuboidShape(3, 10, 4, 11, 14, 16),
            Block.createCuboidShape(11, 10, 4, 16, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape FRONT_EAST = Stream.of(
            Block.createCuboidShape(12, 0, 0, 16, 16, 16),
            Block.createCuboidShape(0, 0, 8, 12, 10, 16),
            Block.createCuboidShape(0, 10, 3, 12, 14, 11),
            Block.createCuboidShape(0, 10, 11, 12, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape FRONT_WEST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 4, 16, 16),
            Block.createCuboidShape(4, 0, 0, 16, 10, 8),
            Block.createCuboidShape(4, 10, 5, 16, 14, 13),
            Block.createCuboidShape(4, 10, 0, 16, 16, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape FRONT_SOUTH = Stream.of(
            Block.createCuboidShape(0, 0, 12, 16, 16, 16),
            Block.createCuboidShape(0, 0, 0, 8, 10, 12),
            Block.createCuboidShape(5, 10, 0, 13, 14, 12),
            Block.createCuboidShape(0, 10, 0, 5, 16, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;


    public PianoBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(PART, BedPart.FOOT));
    }

    @Nullable @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getHorizontalPlayerFacing().getOpposite().rotateClockwise(Direction.Axis.Y);
        BlockPos blockPos = ctx.getBlockPos();
        BlockPos blockPos2 = blockPos.offset(direction);
        World world = ctx.getWorld();
        return world.getBlockState(blockPos2).canReplace(ctx) && world.getWorldBorder().contains(blockPos2) ? this.getDefaultState().with(FACING, direction) : null;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        BedPart head = BedPart.HEAD;
        if (state.get(PART) == head)
            return switch (state.get(FACING)) {
                case SOUTH -> FRONT_SOUTH;
                case WEST -> FRONT_WEST;
                case EAST -> FRONT_EAST;
                default -> FRONT_NORTH;
            };
        else return switch (state.get(FACING)) {
            case SOUTH -> BACK_SOUTH;
            case WEST -> BACK_WEST;
            case EAST -> BACK_EAST;
            default -> BACK_NORTH;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, PART);
    }
}
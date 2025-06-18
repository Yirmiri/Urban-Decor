package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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

public class PianoBlock extends AbstractLongBlock {
    private static final VoxelShape BACK_NORTH = Stream.of(Block.box(0, 0, 12, 16, 16, 16), Block.box(8, 0, 0, 16, 10, 12), Block.box(3, 10, 0, 11, 14, 12), Block.box(11, 10, 0, 16, 16, 12)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BACK_EAST = Stream.of(Block.box(0, 0, 0, 4, 16, 16), Block.box(4, 0, 8, 16, 10, 16), Block.box(4, 10, 3, 16, 14, 11), Block.box(4, 10, 11, 16, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BACK_WEST = Stream.of(Block.box(12, 0, 0, 16, 16, 16), Block.box(0, 0, 0, 12, 10, 8), Block.box(0, 10, 5, 12, 14, 13), Block.box(0, 10, 0, 12, 16, 5)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape BACK_SOUTH = Stream.of(Block.box(0, 0, 0, 16, 16, 4), Block.box(0, 0, 4, 8, 10, 16), Block.box(5, 10, 4, 13, 14, 16), Block.box(0, 10, 4, 5, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape FRONT_NORTH = Stream.of(Block.box(0, 0, 0, 16, 16, 4), Block.box(8, 0, 4, 16, 10, 16), Block.box(3, 10, 4, 11, 14, 16), Block.box(11, 10, 4, 16, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape FRONT_EAST = Stream.of(Block.box(12, 0, 0, 16, 16, 16), Block.box(0, 0, 8, 12, 10, 16), Block.box(0, 10, 3, 12, 14, 11), Block.box(0, 10, 11, 12, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape FRONT_WEST = Stream.of(Block.box(0, 0, 0, 4, 16, 16), Block.box(4, 0, 0, 16, 10, 8), Block.box(4, 10, 5, 16, 14, 13), Block.box(4, 10, 0, 16, 16, 5)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape FRONT_SOUTH = Stream.of(Block.box(0, 0, 12, 16, 16, 16), Block.box(0, 0, 0, 8, 10, 12), Block.box(5, 10, 0, 13, 14, 12), Block.box(0, 10, 0, 5, 16, 12)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;


    public PianoBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(PART, BedPart.FOOT));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction direction = ctx.getHorizontalDirection().getOpposite().getClockWise(Direction.Axis.Y);
        BlockPos blockPos = ctx.getClickedPos();
        BlockPos blockPos2 = blockPos.relative(direction);
        Level world = ctx.getLevel();
        return world.getBlockState(blockPos2).canBeReplaced(ctx) && world.getWorldBorder().isWithinBounds(blockPos2) ? this.defaultBlockState().setValue(FACING, direction) : null;
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
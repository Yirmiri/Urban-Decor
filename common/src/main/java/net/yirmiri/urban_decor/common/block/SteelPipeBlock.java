package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.StateDefinition;

import java.util.Map;

public class SteelPipeBlock extends Block {
    public static final BooleanProperty X = BooleanProperty.create("x");
    public static final BooleanProperty Y = BooleanProperty.create("y");
    public static final BooleanProperty Z = BooleanProperty.create("z");
    public static final Map<Direction.Axis, BooleanProperty> AXIS_TO_PROPERTY = Map.of(Direction.Axis.X, X, Direction.Axis.Y, Y, Direction.Axis.Z, Z);
    private static final VoxelShape SHAPE_Y = Block.box(6.5, 0, 6.5, 9.5, 16, 9.5);
    private static final VoxelShape SHAPE_X = Block.box(0, 6.5, 6.5, 16, 9.5, 9.5);
    private static final VoxelShape SHAPE_Z = Block.box(6.5, 6.5, 0, 9.5, 9.5, 16);

    public SteelPipeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(X, false).setValue(Y, true).setValue(Z, false));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        VoxelShape shape = Shapes.empty();
        if (state.getValue(Y)) shape = Shapes.or(shape, SHAPE_Y);
        if (state.getValue(X)) shape = Shapes.or(shape, SHAPE_X);
        if (state.getValue(Z)) shape = Shapes.or(shape, SHAPE_Z);
        return shape.isEmpty() ? Shapes.block() : shape;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(X, Y, Z);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction.Axis dir = ctx.getClickedFace().getAxis();
        BlockState state = ctx.getLevel().getBlockState(ctx.getClickedPos());
        if (state.is(this)) return state.setValue(AXIS_TO_PROPERTY.get(dir), true);
        return defaultBlockState().setValue(X, dir == Direction.Axis.X).setValue(Y, dir == Direction.Axis.Y).setValue(Z, dir == Direction.Axis.Z);
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.isSecondaryUseActive() && context.getItemInHand().is(this.asItem()) && !state.getValue(AXIS_TO_PROPERTY.get(context.getClickedFace().getAxis()));
    }
}

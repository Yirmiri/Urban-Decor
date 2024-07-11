package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;

public class SinkBlock extends AbstractDecorBlock {
    public static final BooleanProperty BARE = BooleanProperty.of("bare");

    private static final VoxelShape SHAPE_NORTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 0, 4, 14, 12, 16),
            Block.createCuboidShape(0, 12, 1, 16, 14, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_EAST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 2, 12, 12, 14),
            Block.createCuboidShape(0, 12, 0, 15, 14, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_WEST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(4, 0, 2, 16, 12, 14),
            Block.createCuboidShape(1, 12, 0, 16, 14, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_SOUTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 0, 0, 14, 12, 12),
            Block.createCuboidShape(0, 12, 0, 16, 14, 15), BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_NORTH_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 8, 4, 14, 12, 16),
            Block.createCuboidShape(0, 12, 1, 16, 14, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_EAST_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 8, 2, 12, 12, 14),
            Block.createCuboidShape(0, 12, 0, 15, 14, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_WEST_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(4, 8, 2, 16, 12, 14),
            Block.createCuboidShape(1, 12, 0, 16, 14, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_SOUTH_BARE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 8, 0, 14, 12, 12),
            Block.createCuboidShape(0, 12, 0, 16, 14, 15), BooleanBiFunction.OR);

    public SinkBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(BARE, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        boolean bare = state.get(BARE);
        return switch (state.get(FACING)) {
            default -> bare ? SHAPE_NORTH_BARE : SHAPE_NORTH;
            case SOUTH -> bare ? SHAPE_SOUTH_BARE : SHAPE_SOUTH;
            case WEST -> bare ? SHAPE_WEST_BARE : SHAPE_WEST;
            case EAST -> bare ? SHAPE_EAST_BARE : SHAPE_EAST;
        };
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(BARE));
            if (!player.isCreative()) {
                stackHand.damage(1, player, p -> p.sendToolBreakStatus(hand));
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, BARE);
    }
}

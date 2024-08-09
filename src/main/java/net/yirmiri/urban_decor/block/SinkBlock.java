package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.util.UDUtils;

public class SinkBlock extends AbstractDecorBlock {
    public static final IntProperty VARIANT = IntProperty.of("variant", 0, 2);

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

    private static final VoxelShape SHAPE_FULLSIZE = Block.createCuboidShape(0, 0, 0, 16, 14, 16);

    public SinkBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(VARIANT, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        int variant = state.get(VARIANT);
        boolean fullsize = variant == 2;
        if (fullsize) {
            return SHAPE_FULLSIZE;
        } else {
            return switch (state.get(FACING)) {
                default -> variant == 1 ? SHAPE_NORTH_BARE : SHAPE_NORTH;
                case SOUTH -> variant == 1 ? SHAPE_SOUTH_BARE : SHAPE_SOUTH;
                case WEST -> variant == 1 ? SHAPE_WEST_BARE : SHAPE_WEST;
                case EAST -> variant == 1 ? SHAPE_EAST_BARE : SHAPE_EAST;
            };
        }
    }

    @Override
    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(VARIANT));
            UDUtils.ToolboxUsed(world, pos);
            player.sendMessage(Text.translatable("toolbox.sink.variant_" + state.get(VARIANT)), true);
            return ItemActionResult.SUCCESS;
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT);
    }
}

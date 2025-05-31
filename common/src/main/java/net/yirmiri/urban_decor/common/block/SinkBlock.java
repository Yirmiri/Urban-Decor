package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.core.init.UDTags;

import java.util.stream.Stream;

public class SinkBlock extends AbstractDecorBlock {
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 3);
    public static final BooleanProperty ON = BooleanProperty.create("on");

    private static final VoxelShape SHAPE_NORTH = Stream.of(Block.box(2, 0, 4, 14, 2, 16),
            Block.box(2, 2, 4, 14, 10, 16),
            Block.box(2, 10, 4, 14, 14, 16),
            Block.box(0, 14, 12, 16, 16, 16),
            Block.box(0, 14, 1, 16, 16, 4),
            Block.box(0, 14, 4, 3, 16, 12),
            Block.box(13, 14, 4, 16, 16, 12)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST = Stream.of(Block.box(0, 0, 2, 12, 2, 14),
            Block.box(0, 2, 2, 12, 10, 14),
            Block.box(0, 10, 2, 12, 14, 14),
            Block.box(0, 14, 0, 4, 16, 16),
            Block.box(12, 14, 0, 15, 16, 16),
            Block.box(4, 14, 0, 12, 16, 3),
            Block.box(4, 14, 13, 12, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(Block.box(4, 0, 2, 16, 2, 14),
            Block.box(4, 2, 2, 16, 10, 14),
            Block.box(4, 10, 2, 16, 14, 14),
            Block.box(12, 14, 0, 16, 16, 16),
            Block.box(1, 14, 0, 4, 16, 16),
            Block.box(4, 14, 13, 12, 16, 16),
            Block.box(4, 14, 0, 12, 16, 3)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(Block.box(2, 0, 0, 14, 2, 12),
            Block.box(2, 2, 0, 14, 10, 12),
            Block.box(2, 10, 0, 14, 14, 12),
            Block.box(0, 14, 0, 16, 16, 4),
            Block.box(0, 14, 12, 16, 16, 15),
            Block.box(13, 14, 4, 16, 16, 12),
            Block.box(0, 14, 4, 3, 16, 12)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_NORTH_BARE = Stream.of(Block.box(2, 10, 4, 14, 14, 16),
            Block.box(0, 14, 12, 16, 16, 16),
            Block.box(0, 14, 1, 16, 16, 4),
            Block.box(0, 14, 4, 3, 16, 12),
            Block.box(13, 14, 4, 16, 16, 12)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_BARE = Stream.of(Block.box(0, 10, 2, 12, 14, 14),
            Block.box(0, 14, 0, 4, 16, 16),
            Block.box(12, 14, 0, 15, 16, 16),
            Block.box(4, 14, 0, 12, 16, 3),
            Block.box(4, 14, 13, 12, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_WEST_BARE = Stream.of(Block.box(4, 10, 2, 16, 14, 14),
            Block.box(12, 14, 0, 16, 16, 16),
            Block.box(1, 14, 0, 4, 16, 16),
            Block.box(4, 14, 13, 12, 16, 16),
            Block.box(4, 14, 0, 12, 16, 3)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_SOUTH_BARE = Stream.of(Block.box(2, 10, 0, 14, 14, 12),
            Block.box(0, 14, 0, 16, 16, 4),
            Block.box(0, 14, 12, 16, 16, 15),
            Block.box(13, 14, 4, 16, 16, 12),
            Block.box(0, 14, 4, 3, 16, 12)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;

    private static final VoxelShape SHAPE_NORTH_CUPBOARD = Stream.of(Block.box(0, 10, 4, 16, 14, 16),
            Block.box(0, 14, 12, 16, 16, 16),
            Block.box(0, 14, 0, 16, 16, 3),
            Block.box(0, 14, 3, 3, 16, 12),
            Block.box(13, 14, 3, 16, 16, 12),
            Block.box(0, 2, 4, 16, 10, 16),
            Block.box(0, 0, 4, 16, 2, 16),
            Block.box(2, 12, 2, 14, 14, 4)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_SOUTH_CUPBOARD = Stream.of(Block.box(0, 10, 0, 16, 14, 12),
            Block.box(0, 14, 0, 16, 16, 4),
            Block.box(0, 14, 13, 16, 16, 16),
            Block.box(13, 14, 4, 16, 16, 13),
            Block.box(0, 14, 4, 3, 16, 13),
            Block.box(0, 2, 0, 16, 10, 12),
            Block.box(0, 0, 0, 16, 2, 12),
            Block.box(2, 12, 12, 14, 14, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_EAST_CUPBOARD = Stream.of(Block.box(0, 10, 0, 12, 14, 16),
            Block.box(0, 14, 0, 4, 16, 16),
            Block.box(13, 14, 0, 16, 16, 16),
            Block.box(4, 14, 0, 13, 16, 3),
            Block.box(4, 14, 13, 13, 16, 16),
            Block.box(0, 2, 0, 12, 10, 16),
            Block.box(0, 0, 0, 12, 2, 16),
            Block.box(12, 12, 2, 14, 14, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;
    private static final VoxelShape SHAPE_WEST_CUPBOARD = Stream.of(Block.box(4, 10, 0, 16, 14, 16),
            Block.box(12, 14, 0, 16, 16, 16),
            Block.box(0, 14, 0, 3, 16, 16),
            Block.box(3, 14, 13, 12, 16, 16),
            Block.box(3, 14, 0, 12, 16, 3),
            Block.box(4, 2, 0, 16, 10, 16),
            Block.box(4, 0, 0, 16, 2, 16),
            Block.box(2, 12, 2, 4, 14, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;

    private static final VoxelShape SHAPE_FULLSIZE = Block.box(0, 0, 0, 16, 16, 16);

    public SinkBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(ON, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(VARIANT, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        int variant = state.getValue(VARIANT);
        boolean cupboard = variant == 2;
        boolean fullsize = variant == 3;
        boolean bare = variant == 1;
        if (cupboard || fullsize) {
            return switch (state.getValue(FACING)) {
                case SOUTH -> fullsize ? SHAPE_FULLSIZE : SHAPE_SOUTH_CUPBOARD;
                case WEST -> fullsize ? SHAPE_FULLSIZE : SHAPE_WEST_CUPBOARD;
                case EAST -> fullsize ? SHAPE_FULLSIZE : SHAPE_EAST_CUPBOARD;
                default -> fullsize ? SHAPE_FULLSIZE : SHAPE_NORTH_CUPBOARD;
            };
        } else {
            return switch (state.getValue(FACING)) {
                case SOUTH -> bare ? SHAPE_SOUTH_BARE : SHAPE_SOUTH;
                case WEST -> bare ? SHAPE_WEST_BARE : SHAPE_WEST;
                case EAST -> bare ? SHAPE_EAST_BARE : SHAPE_EAST;
                default -> bare ? SHAPE_NORTH_BARE : SHAPE_NORTH;
            };
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            world.setBlockAndUpdate(pos, state.cycle(VARIANT));
            UDUtils.toolboxUsed(world, pos);
            player.displayClientMessage(Component.translatable("toolbox.sink.variant_" + state.getValue(VARIANT)), true);
            return InteractionResult.SUCCESS;
        } if (stackHand.is(Items.GLASS_BOTTLE) && state.getValue(ON) && !world.isClientSide) {
            UDUtils.faucetFillBottle(world, pos, player, hand);
            return InteractionResult.SUCCESS;
//        } else if (stackHand.isEmpty()) {
//            world.setBlockState(pos, state.cycle(ON));
//            world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.8F, 1.0F, false);
//            return ActionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        if (state.getValue(ON)) {
            UDUtils.spawnWaterParticles(1, world, pos, direction);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT, ON);
    }
}

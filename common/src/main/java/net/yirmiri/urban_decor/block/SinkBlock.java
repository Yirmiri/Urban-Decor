package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.util.UDUtils;

import java.util.stream.Stream;

public class SinkBlock extends AbstractDecorBlock {
    public static final IntProperty VARIANT = IntProperty.of("variant", 0, 3);
    public static final BooleanProperty ON = BooleanProperty.of("on");

    private static final VoxelShape SHAPE_NORTH = Stream.of(Block.createCuboidShape(2, 0, 4, 14, 2, 16),
            Block.createCuboidShape(2, 2, 4, 14, 10, 16),
            Block.createCuboidShape(2, 10, 4, 14, 14, 16),
            Block.createCuboidShape(0, 14, 12, 16, 16, 16),
            Block.createCuboidShape(0, 14, 1, 16, 16, 4),
            Block.createCuboidShape(0, 14, 4, 3, 16, 12),
            Block.createCuboidShape(13, 14, 4, 16, 16, 12)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_EAST = Stream.of(Block.createCuboidShape(0, 0, 2, 12, 2, 14),
            Block.createCuboidShape(0, 2, 2, 12, 10, 14),
            Block.createCuboidShape(0, 10, 2, 12, 14, 14),
            Block.createCuboidShape(0, 14, 0, 4, 16, 16),
            Block.createCuboidShape(12, 14, 0, 15, 16, 16),
            Block.createCuboidShape(4, 14, 0, 12, 16, 3),
            Block.createCuboidShape(4, 14, 13, 12, 16, 16)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(Block.createCuboidShape(4, 0, 2, 16, 2, 14),
            Block.createCuboidShape(4, 2, 2, 16, 10, 14),
            Block.createCuboidShape(4, 10, 2, 16, 14, 14),
            Block.createCuboidShape(12, 14, 0, 16, 16, 16),
            Block.createCuboidShape(1, 14, 0, 4, 16, 16),
            Block.createCuboidShape(4, 14, 13, 12, 16, 16),
            Block.createCuboidShape(4, 14, 0, 12, 16, 3)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(Block.createCuboidShape(2, 0, 0, 14, 2, 12),
            Block.createCuboidShape(2, 2, 0, 14, 10, 12),
            Block.createCuboidShape(2, 10, 0, 14, 14, 12),
            Block.createCuboidShape(0, 14, 0, 16, 16, 4),
            Block.createCuboidShape(0, 14, 12, 16, 16, 15),
            Block.createCuboidShape(13, 14, 4, 16, 16, 12),
            Block.createCuboidShape(0, 14, 4, 3, 16, 12)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_NORTH_BARE = Stream.of(Block.createCuboidShape(2, 10, 4, 14, 14, 16),
            Block.createCuboidShape(0, 14, 12, 16, 16, 16),
            Block.createCuboidShape(0, 14, 1, 16, 16, 4),
            Block.createCuboidShape(0, 14, 4, 3, 16, 12),
            Block.createCuboidShape(13, 14, 4, 16, 16, 12)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_EAST_BARE = Stream.of(Block.createCuboidShape(0, 10, 2, 12, 14, 14),
            Block.createCuboidShape(0, 14, 0, 4, 16, 16),
            Block.createCuboidShape(12, 14, 0, 15, 16, 16),
            Block.createCuboidShape(4, 14, 0, 12, 16, 3),
            Block.createCuboidShape(4, 14, 13, 12, 16, 16)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;
    private static final VoxelShape SHAPE_WEST_BARE = Stream.of(Block.createCuboidShape(4, 10, 2, 16, 14, 14),
            Block.createCuboidShape(12, 14, 0, 16, 16, 16),
            Block.createCuboidShape(1, 14, 0, 4, 16, 16),
            Block.createCuboidShape(4, 14, 13, 12, 16, 16),
            Block.createCuboidShape(4, 14, 0, 12, 16, 3)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;
    private static final VoxelShape SHAPE_SOUTH_BARE = Stream.of(Block.createCuboidShape(2, 10, 0, 14, 14, 12),
            Block.createCuboidShape(0, 14, 0, 16, 16, 4),
            Block.createCuboidShape(0, 14, 12, 16, 16, 15),
            Block.createCuboidShape(13, 14, 4, 16, 16, 12),
            Block.createCuboidShape(0, 14, 4, 3, 16, 12)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;

    private static final VoxelShape SHAPE_NORTH_CUPBOARD = Stream.of(Block.createCuboidShape(0, 10, 4, 16, 14, 16),
            Block.createCuboidShape(0, 14, 12, 16, 16, 16),
            Block.createCuboidShape(0, 14, 0, 16, 16, 3),
            Block.createCuboidShape(0, 14, 3, 3, 16, 12),
            Block.createCuboidShape(13, 14, 3, 16, 16, 12),
            Block.createCuboidShape(0, 2, 4, 16, 10, 16),
            Block.createCuboidShape(0, 0, 4, 16, 2, 16),
            Block.createCuboidShape(2, 12, 2, 14, 14, 4)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;
    private static final VoxelShape SHAPE_SOUTH_CUPBOARD = Stream.of(Block.createCuboidShape(0, 10, 0, 16, 14, 12),
            Block.createCuboidShape(0, 14, 0, 16, 16, 4),
            Block.createCuboidShape(0, 14, 13, 16, 16, 16),
            Block.createCuboidShape(13, 14, 4, 16, 16, 13),
            Block.createCuboidShape(0, 14, 4, 3, 16, 13),
            Block.createCuboidShape(0, 2, 0, 16, 10, 12),
            Block.createCuboidShape(0, 0, 0, 16, 2, 12),
            Block.createCuboidShape(2, 12, 12, 14, 14, 14)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;
    private static final VoxelShape SHAPE_EAST_CUPBOARD = Stream.of(Block.createCuboidShape(0, 10, 0, 12, 14, 16),
            Block.createCuboidShape(0, 14, 0, 4, 16, 16),
            Block.createCuboidShape(13, 14, 0, 16, 16, 16),
            Block.createCuboidShape(4, 14, 0, 13, 16, 3),
            Block.createCuboidShape(4, 14, 13, 13, 16, 16),
            Block.createCuboidShape(0, 2, 0, 12, 10, 16),
            Block.createCuboidShape(0, 0, 0, 12, 2, 16),
            Block.createCuboidShape(12, 12, 2, 14, 14, 14)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;
    private static final VoxelShape SHAPE_WEST_CUPBOARD = Stream.of(Block.createCuboidShape(4, 10, 0, 16, 14, 16),
            Block.createCuboidShape(12, 14, 0, 16, 16, 16),
            Block.createCuboidShape(0, 14, 0, 3, 16, 16),
            Block.createCuboidShape(3, 14, 13, 12, 16, 16),
            Block.createCuboidShape(3, 14, 0, 12, 16, 3),
            Block.createCuboidShape(4, 2, 0, 16, 10, 16),
            Block.createCuboidShape(4, 0, 0, 16, 2, 16),
            Block.createCuboidShape(2, 12, 2, 4, 14, 14)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;

    private static final VoxelShape SHAPE_FULLSIZE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);

    public SinkBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(ON, false).with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(VARIANT, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        int variant = state.get(VARIANT);
        boolean cupboard = variant == 2;
        boolean fullsize = variant == 3;
        boolean bare = variant == 1;
        if (cupboard || fullsize) {
            return switch (state.get(FACING)) {
                case SOUTH -> fullsize ? SHAPE_FULLSIZE : SHAPE_SOUTH_CUPBOARD;
                case WEST -> fullsize ? SHAPE_FULLSIZE : SHAPE_WEST_CUPBOARD;
                case EAST -> fullsize ? SHAPE_FULLSIZE : SHAPE_EAST_CUPBOARD;
                default -> fullsize ? SHAPE_FULLSIZE : SHAPE_NORTH_CUPBOARD;
            };
        } else {
            return switch (state.get(FACING)) {
                case SOUTH -> bare ? SHAPE_SOUTH_BARE : SHAPE_SOUTH;
                case WEST -> bare ? SHAPE_WEST_BARE : SHAPE_WEST;
                case EAST -> bare ? SHAPE_EAST_BARE : SHAPE_EAST;
                default -> bare ? SHAPE_NORTH_BARE : SHAPE_NORTH;
            };
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(VARIANT));
            UDUtils.toolboxUsed(world, pos);
            player.sendMessage(Text.translatable("toolbox.sink.variant_" + state.get(VARIANT)), true);
            return ActionResult.SUCCESS;
        } if (stackHand.isOf(Items.GLASS_BOTTLE) && state.get(ON) && !world.isClient) {
            UDUtils.faucetFillBottle(world, pos, player, hand);
            return ActionResult.SUCCESS;
        } //else if (stackHand.isEmpty()) {
            //world.setBlockState(pos, state.cycle(ON));
            //world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.8F, 1.0F, false);
            //return ActionResult.SUCCESS;
        //}
        return ActionResult.PASS;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int variant = state.get(VARIANT);
        boolean bare = variant == 1;
        if (state.get(ON) && bare) {
            UDUtils.spawnWaterParticles(world, new Vec3d(pos.getX() + 0.3F, pos.getY() + 1.0F, pos.getZ() + 0.5F));
        } else if (state.get(ON) && !bare) {
            UDUtils.spawnWaterParticles(world, new Vec3d(pos.getX() + 0.3F, pos.getY() + 1.0F, pos.getZ() + 0.5F));
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT, ON);
    }
}

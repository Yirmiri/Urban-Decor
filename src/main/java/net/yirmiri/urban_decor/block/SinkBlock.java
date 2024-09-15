package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
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
import net.minecraft.world.event.GameEvent;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.util.UDStats;
import net.yirmiri.urban_decor.util.UDUtils;

public class SinkBlock extends AbstractDecorBlock {
    public static final IntProperty VARIANT = IntProperty.of("variant", 0, 2);
    public static final BooleanProperty ON = BooleanProperty.of("on");

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
        setDefaultState(getDefaultState().with(ON, false).with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(VARIANT, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        int variant = state.get(VARIANT);
        boolean fullsize = variant == 2;
        if (fullsize) {
            return SHAPE_FULLSIZE;
        } else {
            return switch (state.get(FACING)) {
                case SOUTH -> variant == 1 ? SHAPE_SOUTH_BARE : SHAPE_SOUTH;
                case WEST -> variant == 1 ? SHAPE_WEST_BARE : SHAPE_WEST;
                case EAST -> variant == 1 ? SHAPE_EAST_BARE : SHAPE_EAST;
                default -> variant == 1 ? SHAPE_NORTH_BARE : SHAPE_NORTH;
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

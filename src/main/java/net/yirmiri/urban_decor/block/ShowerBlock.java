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

public class ShowerBlock extends AbstractDecorBlock {
    public static final BooleanProperty ALT = BooleanProperty.of("alt");
    public static final BooleanProperty ON = BooleanProperty.of("on");

    private static final VoxelShape SHAPE_NORTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(7, 8, 8, 9, 10, 18),
            Block.createCuboidShape(5, 6, 6, 11, 8, 12), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_WEST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 8, 7, 18, 10, 9),
            Block.createCuboidShape(6, 6, 5, 12, 8, 11), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_EAST = VoxelShapes.combineAndSimplify(Block.createCuboidShape(-2, 8, 7, 8, 10, 9),
            Block.createCuboidShape(4, 6, 5, 10, 8, 11), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_SOUTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(7, 8, -2, 9, 10, 8),
            Block.createCuboidShape(5, 6, 4, 11, 8, 10), BooleanBiFunction.OR);

    public ShowerBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(ALT, false).with(ON, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return switch (state.get(FACING)) {
            default -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
        };
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(ALT));
            UDUtils.toolboxUsed(world, pos);
            player.sendMessage(Text.translatable("toolbox.shower.variant_" + state.get(ALT)), true);
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
        if (state.get(ON)) {
            UDUtils.spawnWaterParticles(world, new Vec3d(pos.getX() + 0.5F, pos.getY() + 0.2F, pos.getZ() + 0.5F));
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, ALT, ON);
    }
}

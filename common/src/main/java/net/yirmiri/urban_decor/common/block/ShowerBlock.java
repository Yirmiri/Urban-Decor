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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.common.util.UDUtils;

public class ShowerBlock extends AbstractDecorBlock {
    public static final BooleanProperty ALT = BooleanProperty.create("alt");
    public static final BooleanProperty ON = BooleanProperty.create("on");

    private static final VoxelShape SHAPE_NORTH = Shapes.join(Block.box(7, 8, 8, 9, 10, 18),
            Block.box(5, 6, 6, 11, 8, 12), BooleanOp.OR);
    private static final VoxelShape SHAPE_WEST = Shapes.join(Block.box(8, 8, 7, 18, 10, 9),
            Block.box(6, 6, 5, 12, 8, 11), BooleanOp.OR);
    private static final VoxelShape SHAPE_EAST = Shapes.join(Block.box(-2, 8, 7, 8, 10, 9),
            Block.box(4, 6, 5, 10, 8, 11), BooleanOp.OR);
    private static final VoxelShape SHAPE_SOUTH = Shapes.join(Block.box(7, 8, -2, 9, 10, 8),
            Block.box(5, 6, 4, 11, 8, 10), BooleanOp.OR);

    public ShowerBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(ALT, false).setValue(ON, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockAndUpdate(pos, state.cycle(ALT));
            UDUtils.toolboxUsed(world, pos);
            player.displayClientMessage(Component.translatable("toolbox.shower.variant_" + state.getValue(ALT)), true);
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
        builder.add(FACING, WATERLOGGED, ALT, ON);
    }
}

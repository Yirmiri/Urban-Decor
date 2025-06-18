package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.core.init.UDTags;

public class FaucetBlock extends AbstractDecorBlock {
    public static final BooleanProperty OUTDOOR = BooleanProperty.create("outdoor");
    public static final BooleanProperty ON = BooleanProperty.create("on");

    private static final VoxelShape SHAPE_NORTH = Shapes.join(Block.box(7, 8, 10, 9, 10, 18),
            Block.box(7, 6, 10, 9, 8, 12), BooleanOp.OR);
    private static final VoxelShape SHAPE_WEST = Shapes.join(Block.box(10, 8, 7, 18, 10, 9),
            Block.box(10, 6, 7, 12, 8, 9), BooleanOp.OR);
    private static final VoxelShape SHAPE_EAST = Shapes.join(Block.box(-2, 8, 7, 6, 10, 9),
            Block.box(4, 6, 7, 6, 8, 9), BooleanOp.OR);
    private static final VoxelShape SHAPE_SOUTH = Shapes.join(Block.box(7, 8, -2, 9, 10, 6),
            Block.box(7, 6, 4, 9, 8, 6), BooleanOp.OR);

    public FaucetBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(ON, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(OUTDOOR, false));
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            level.setBlockAndUpdate(pos, state.cycle(OUTDOOR));
            UDUtils.toolboxUsed(level, pos);
            player.displayClientMessage(Component.translatable("toolbox.faucet.variant_" + state.getValue(OUTDOOR)), true);
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        if (state.getValue(ON)) {
            UDUtils.spawnWaterParticles(1, world, pos, direction);
        }
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OUTDOOR, ON);
    }
}

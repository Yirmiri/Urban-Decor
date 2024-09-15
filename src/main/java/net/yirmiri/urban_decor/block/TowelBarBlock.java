package net.yirmiri.urban_decor.block;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
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
import net.minecraft.world.event.GameEvent;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;

import java.util.stream.Stream;

public class TowelBarBlock extends AbstractDecorBlock {
    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.createCuboidShape(0.03, 13.01, 13.99, 1.99, 14.97, 17.95),
            Block.createCuboidShape(0.02, 13.01, 12.03, 15.98, 14.97, 13.99),
            Block.createCuboidShape(14.01, 13.01, 13.99, 15.97, 14.97, 17.95)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.createCuboidShape(14.05, 13.01, 0.03000000000000025, 18.009999999999998, 14.97, 1.9900000000000002),
            Block.createCuboidShape(12.01, 13.01, 0.020000000000000018, 13.97, 14.97, 15.98),
            Block.createCuboidShape(14.05, 13.01, 14.009999999999998, 18.009999999999998, 14.97, 15.969999999999999)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.createCuboidShape(-1.9499999999999993, 13.01, 0.03000000000000025, 2.009999999999998, 14.97, 1.9900000000000002),
            Block.createCuboidShape(2.01, 13.01, 0.020000000000000018, 3.9700000000000006, 14.97, 15.98),
            Block.createCuboidShape(-1.9499999999999993, 13.01, 14.009999999999998, 2.009999999999998, 14.97, 15.969999999999999)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.createCuboidShape(0.03, 13.01, -2.01, 1.99, 14.97, 1.9499999999999993),
            Block.createCuboidShape(0.02, 13.01, 2.0299999999999994, 15.98, 14.97, 3.99),
            Block.createCuboidShape(14.01, 13.01, -2.01, 15.97, 14.97, 1.9499999999999993)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public TowelBarBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return switch (state.get(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        Item item = stackHand.getItem();
        if (stackHand.isIn(UDItemTagProvider.TOWELS)) {
            Block block = Block.getBlockFromItem(item);
            if (block instanceof TowelBlock) {
                if (!player.isCreative()) {
                    stackHand.decrement(1);
                }
                world.playSound(null, pos, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.setBlockState(pos, TowelBarTowelBlock.getTowelColors(block).with(FACING, state.get(FACING)));
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}

package net.yirmiri.urban_decor.block;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
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
import net.yirmiri.urban_decor.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;

import java.util.stream.Stream;

public class TowelBarBlock extends AbstractDecorBlock {
    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.createCuboidShape(0, 14, 14, 2, 16, 16),
            Block.createCuboidShape(14, 14, 14, 16, 16, 16),
            Block.createCuboidShape(0, 14, 12, 16, 16, 14)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.createCuboidShape(14, 14, 14, 16, 16, 16),
            Block.createCuboidShape(14, 14, 0, 16, 16, 2),
            Block.createCuboidShape(12, 14, 0, 14, 16, 16)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.createCuboidShape(0, 14, 0, 2, 16, 2),
            Block.createCuboidShape(0, 14, 14, 2, 16, 16),
            Block.createCuboidShape(2, 14, 0, 4, 16, 16)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.createCuboidShape(14, 14, 0, 16, 16, 2),
            Block.createCuboidShape(0, 14, 0, 2, 16, 2),
            Block.createCuboidShape(0, 14, 2, 16, 16, 4)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

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

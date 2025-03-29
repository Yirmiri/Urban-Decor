package net.yirmiri.urban_decor.common.block;

import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;

import java.util.stream.Stream;

public class TowelBarBlock extends AbstractDecorBlock {
    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(0, 14, 14, 2, 16, 16),
            Block.box(14, 14, 14, 16, 16, 16),
            Block.box(0, 14, 12, 16, 16, 14)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.box(14, 14, 14, 16, 16, 16),
            Block.box(14, 14, 0, 16, 16, 2),
            Block.box(12, 14, 0, 14, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.box(0, 14, 0, 2, 16, 2),
            Block.box(0, 14, 14, 2, 16, 16),
            Block.box(2, 14, 0, 4, 16, 16)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.box(14, 14, 0, 16, 16, 2),
            Block.box(0, 14, 0, 2, 16, 2),
            Block.box(0, 14, 2, 16, 16, 4)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public TowelBarBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false));
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
        Item item = stackHand.getItem();
        if (stackHand.is(UDItemTagProvider.TOWELS)) {
            Block block = Block.byItem(item);
            if (block instanceof TowelBlock) {
                if (!player.isCreative()) {
                    stackHand.shrink(1);
                }
                world.playSound(null, pos, SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.setBlockAndUpdate(pos, TowelBarTowelBlock.getTowelColors(block).setValue(FACING, state.getValue(FACING)));
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}

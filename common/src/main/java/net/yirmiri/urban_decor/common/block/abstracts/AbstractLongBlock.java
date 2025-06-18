package net.yirmiri.urban_decor.common.block.abstracts;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;

public abstract class AbstractLongBlock extends AbstractDecorBlock {
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;

    public AbstractLongBlock(Properties settings) {
        super(settings);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (direction == getDirectionTowardsOtherPart(state.getValue(PART), state.getValue(FACING))) {
            return neighborState.is(this) && neighborState.getValue(PART) != state.getValue(PART) ? state : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    private static Direction getDirectionTowardsOtherPart(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    @Override
    public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (!world.isClientSide && player.isCreative()) {
            BedPart bedPart = state.getValue(PART);
            if (bedPart == BedPart.FOOT) {
                BlockPos blockPos = pos.relative(getDirectionTowardsOtherPart(bedPart, state.getValue(FACING)));
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.is(this) && blockState.getValue(PART) == BedPart.HEAD) {
                    world.setBlock(blockPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL | Block.UPDATE_SUPPRESS_DROPS);
                    world.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, blockPos, Block.getId(blockState));
                }
            }
        }
        return super.playerWillDestroy(world, pos, state, player);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction direction = ctx.getHorizontalDirection();
        BlockPos blockPos = ctx.getClickedPos();
        BlockPos blockPos2 = blockPos.relative(direction);
        Level world = ctx.getLevel();
        return world.getBlockState(blockPos2).canBeReplaced(ctx) && world.getWorldBorder().isWithinBounds(blockPos2) ? this.defaultBlockState().setValue(FACING, direction) : null;
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.setPlacedBy(world, pos, state, placer, itemStack);
        if (!world.isClientSide) {
            BlockPos blockPos = pos.relative(state.getValue(FACING));
            world.setBlock(blockPos, state.setValue(PART, BedPart.HEAD), Block.UPDATE_ALL);
            world.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(world, pos, Block.UPDATE_ALL);
        }
    }

    @Override
    public long getSeed(BlockState state, BlockPos pos) {
        BlockPos blockPos = pos.relative(state.getValue(FACING), state.getValue(PART) == BedPart.HEAD ? 0 : 1);
        return Mth.getSeed(blockPos.getX(), pos.getY(), blockPos.getZ());
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}

package net.yirmiri.urban_decor.common.block;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.yirmiri.urban_decor.core.registry.UDBlocks;

import java.util.Map;

public class TowelBarTowelBlock extends TowelBarBlock {
    private static final Map<Block, TowelBarTowelBlock> TOWELS_TO_BAR = Maps.newHashMap();
    private final Block towel;

    public TowelBarTowelBlock(Block towel, Properties settings) {
        super(settings);
        this.towel = towel;
        TOWELS_TO_BAR.put(towel, this);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(UDBlocks.TOWEL_BAR.get());
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(world, player, pos, state, blockEntity, tool);
        popResource(world, pos, new ItemStack (UDBlocks.TOWEL_BAR.get().asItem()));
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        ItemStack towel = new ItemStack(this.towel);
        if (!player.addItem(towel)) {
            player.drop(towel, false);
        }
        level.setBlock(pos, UDBlocks.TOWEL_BAR.get().defaultBlockState().setValue(FACING, state.getValue(FACING)), Block.UPDATE_ALL);
        return InteractionResult.CONSUME;
    }

    public static BlockState getTowelColors(Block towel) {
        return TOWELS_TO_BAR.get(towel).defaultBlockState();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
}

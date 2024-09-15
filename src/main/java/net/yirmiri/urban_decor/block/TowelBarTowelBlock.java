package net.yirmiri.urban_decor.block;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.registry.UDBlocks;

import java.util.Map;

public class TowelBarTowelBlock extends TowelBarBlock {
    private static final Map<Block, TowelBarTowelBlock> TOWELS_TO_BAR = Maps.newHashMap();
    private final Block towel;

    public TowelBarTowelBlock(Block towel, Settings settings) {
        super(settings);
        this.towel = towel;
        TOWELS_TO_BAR.put(towel, this);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(UDBlocks.TOWEL_BAR);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        ItemStack towel = new ItemStack(this.towel);
        if (!player.isCreative()) {
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, towel);
            } else if (!player.giveItemStack(towel)) {
                player.dropItem(towel, false);
            }

            world.setBlockState(pos, UDBlocks.TOWEL_BAR.getDefaultState().with(FACING, state.get(FACING)), Block.NOTIFY_ALL);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    public static BlockState getTowelColors(Block towel) {
        return TOWELS_TO_BAR.get(towel).getDefaultState();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
}

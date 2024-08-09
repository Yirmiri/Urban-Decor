package net.yirmiri.urban_decor.block;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.yirmiri.urban_decor.registry.RegisterBlocks;

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
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(RegisterBlocks.TOWEL_BAR);
    }

    @Override
    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        ItemStack towel = new ItemStack(this.towel);
        if (!player.isCreative()) {
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, towel);
            } else if (!player.giveItemStack(towel)) {
                player.dropItem(towel, false);
            }

            world.setBlockState(pos, RegisterBlocks.TOWEL_BAR.getDefaultState().with(FACING, state.get(FACING)), Block.NOTIFY_ALL);
            return ItemActionResult.SUCCESS;
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public static BlockState getTowelColors(Block towel) {
        return TOWELS_TO_BAR.get(towel).getDefaultState();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
}

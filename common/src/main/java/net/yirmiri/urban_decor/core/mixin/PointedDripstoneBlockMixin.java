package net.yirmiri.urban_decor.core.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PointedDripstoneBlock.class)
public class PointedDripstoneBlockMixin {

    @Inject(method = "randomTick", at = @At("TAIL"))
    private void urbanDecor$randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        if (random.nextBoolean()) return;
        if (!PointedDripstoneBlock.canDrip(state)) return;

        if (!level.getBlockState(pos.above()).is(Blocks.RAW_IRON_BLOCK)) return;
        if (!level.getFluidState(pos.above(2)).is(FluidTags.LAVA)) return;

        BlockPos tipPos = PointedDripstoneBlockInvoker.invokeFindTip(state, level, pos, Integer.MAX_VALUE, false);

        if (tipPos == null) return;
        BlockPos targetPos = tipPos.below();

        if (!level.getBlockState(targetPos).is(UDBlocks.CHROMITE.get())) return;

        level.setBlock(targetPos, UDBlocks.STAINLESS_STEEL_DEPOSIT.get().defaultBlockState(), 3);
    }
}
package net.yirmiri.urban_decor.core.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PointedDripstoneBlock.class)
public interface PointedDripstoneBlockInvoker {
    
    @Invoker("findTip")
    static BlockPos invokeFindTip(BlockState state, LevelAccessor level, BlockPos pos, int range, boolean allowMerged) {
        throw new AssertionError();
    }
}
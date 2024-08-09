package net.yirmiri.urban_decor.util;

import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UDUtils {

    public static void ToolboxUsed(World world, BlockPos pos) {
        world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 0.5F, 1.0F, false);
    }
}

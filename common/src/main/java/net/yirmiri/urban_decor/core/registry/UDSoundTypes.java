package net.yirmiri.urban_decor.core.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

public class UDSoundTypes {
    public static final SoundType PORCELAIN = new SoundType(1F, 1.8F,
            SoundEvents.METAL_BREAK, SoundEvents.METAL_STEP, SoundEvents.METAL_PLACE,
            SoundEvents.METAL_HIT, SoundEvents.METAL_FALL);

    public static final SoundType STEEL = new SoundType(1F, 1.2F,
            SoundEvents.NETHERITE_BLOCK_BREAK, SoundEvents.NETHERITE_BLOCK_STEP, SoundEvents.NETHERITE_BLOCK_PLACE,
            SoundEvents.NETHERITE_BLOCK_HIT, SoundEvents.NETHERITE_BLOCK_FALL);

    public static final SoundType PLASTIC = new SoundType(1F, 0.75F,
            SoundEvents.SCAFFOLDING_BREAK, SoundEvents.SCAFFOLDING_STEP, SoundEvents.SCAFFOLDING_PLACE,
            SoundEvents.SCAFFOLDING_HIT, SoundEvents.SCAFFOLDING_FALL);
}
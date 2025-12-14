package net.yirmiri.urban_decor.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.yirmiri.urban_decor.common.block.GrandClockBlock;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;
import net.yirmiri.urban_decor.core.registry.UDSounds;

public class GrandBlockEntity extends BlockEntity {
    private long lastChimeTime = -1L;

    public GrandBlockEntity(BlockPos pos, BlockState state) {
        super(UDBlockEntities.GRAND_CLOCK.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, GrandBlockEntity blockEntity) {
        if (!level.isClientSide && level.getGameRules().getBoolean(GameRules.RULE_DAYLIGHT) && level.getBlockState(pos).getValue(GrandClockBlock.HALF) == DoubleBlockHalf.UPPER) {
            long time = level.getDayTime();

            if (time % 40L == 0) {
                level.playSound(null, pos, UDSounds.GRAND_CLOCK_TICK.get(), SoundSource.BLOCKS, 0.05F, 1.0F);
            } else if (time % 40L == 20L) {
                level.playSound(null, pos, UDSounds.GRAND_CLOCK_TOCK.get(), SoundSource.BLOCKS, 0.05F, 1.0F);
            }

            long dayTime = time % 24000L;

            if (blockEntity.lastChimeTime != dayTime) {
                if (dayTime == 6000L) {
                    level.playSound(null, pos, UDSounds.GRAND_CLOCK_CHIME_DAY.get(), SoundSource.BLOCKS, 0.5F, 1.0F);
                    blockEntity.lastChimeTime = dayTime;
                }

                if (dayTime == 18000L) {
                    level.playSound(null, pos, UDSounds.GRAND_CLOCK_CHIME_NIGHT.get(), SoundSource.BLOCKS, 0.5F, 1.0F);
                    blockEntity.lastChimeTime = dayTime;
                }

                if (dayTime == 21000L && level.random.nextInt(66) == 0) {
                    level.playSound(null, pos, UDSounds.GRAND_CLOCK_CHIME_3AM.get(), SoundSource.BLOCKS, 0.5F, 1.0F);
                    blockEntity.lastChimeTime = dayTime;
                }
            }
        }
    }
}

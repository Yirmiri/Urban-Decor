package net.yirmiri.urban_decor.common.block_entity.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.yirmiri.urban_decor.common.block.SpeakerBlock;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;
import net.yirmiri.urban_decor.core.registry.UDSounds;

import java.util.Map;

public class SpeakerBlockEntity extends BlockEntity {
    private int tickCounter = 0;

    private static final Map<Integer, SoundData> SOUND_MAP = Map.of(
            1, new SoundData(UDSounds.SPEAKER_FLUORESCENT.get(), 104, 1.0F)
    );

    public SpeakerBlockEntity(BlockPos pos, BlockState state) {
        super(UDBlockEntities.SPEAKER.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, SpeakerBlockEntity blockEntity) {
        if (level.isClientSide) return;
        blockEntity.tickCounter++;
        SoundData soundData = SOUND_MAP.getOrDefault(state.getValue(SpeakerBlock.SOUND_TYPE), new SoundData(SoundEvents.EMPTY, 20, 1.0F));

        if (blockEntity.tickCounter >= soundData.interval) {
            blockEntity.tickCounter = 0;
            level.playSound(null, pos, soundData.sound, SoundSource.BLOCKS, soundData.volume, 1.0F);
        }
    }

    public void resetTimer() {
        this.tickCounter = 0;
    }

    private record SoundData(SoundEvent sound, int interval, float volume) {
    }
}
package net.yirmiri.urban_decor.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;

public class WallClockBlockEntity extends BlockEntity {
    public WallClockBlockEntity(BlockPos pos, BlockState state) {
        super(UDBlockEntities.WALL_CLOCK.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, WallClockBlockEntity blockEntity) {
        if (!level.isClientSide) { //grand clock instead will play tong every 6 hours at low volume short range and differ in pitch per hour
//            if (level.getDayTime() % 1000L == 0 && level.getGameRules().getBoolean(GameRules.RULE_DAYLIGHT)) {
//                level.playSound(null, pos, SoundEvents.NOTE_BLOCK_BELL.value(), SoundSource.BLOCKS, 0.5F, -1.0F);
//            }
//            else if (level.getDayTime() % 20L == 0) {
//                level.playSound(null, pos, SoundEvents.UI_BUTTON_CLICK.value(), SoundSource.BLOCKS, 0.2F, 1.0F);
//            }
        }
    }
}

package net.yirmiri.urban_decor.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.yirmiri.urban_decor.common.block.ToiletBlock;
import net.yirmiri.urban_decor.datagen.UDBlockTagProvider;

public class ToiletEntity extends Entity {
    public ToiletEntity(EntityType<?> type, Level world) {
        super(type, world);
        setInvulnerable(true);
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if (!passenger.level().isClientSide && getFeetBlockState().is(UDBlockTagProvider.TOILETS)) {
            level().setBlockAndUpdate(blockPosition(), getFeetBlockState().setValue(ToiletBlock.OCCUPIED, false));
            discard();
        } else {
            discard();
        }
    }

    @Override
    protected boolean canAddPassenger(Entity entity) {
        return true;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {

    }
}

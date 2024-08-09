package net.yirmiri.urban_decor.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.block.ToiletBlock;
import net.yirmiri.urban_decor.datagen.UDBlockTagProvider;

public class ToiletEntity extends Entity {
    public ToiletEntity(EntityType<?> type, World world) {
        super(type, world);
        setInvulnerable(true);
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        BlockState state = passenger.getBlockStateAtPos();
        if (!passenger.getWorld().isClient) {
            if (passenger.getBlockStateAtPos().isIn(UDBlockTagProvider.TOILETS)) {
                getWorld().setBlockState(passenger.getBlockPos(), state.with(ToiletBlock.OCCUPIED, false));
                discard();
            } else {
                UrbanDecor.LOGGER.atError().log("Block at passenger's pos is not a porcelain throne (toilet) and therefore cannot set its occupied state to false");
                discard();
            }
        }
    }

    @Override
    protected boolean canAddPassenger(Entity entity) {
        return true;
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }
}

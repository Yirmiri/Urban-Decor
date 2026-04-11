package net.yirmiri.urban_decor.common.entity;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import net.yirmiri.urban_decor.core.init.UDTags;

import java.util.List;

public class SeatEntity extends Entity {
    private static final EntityDataAccessor<Float> ROTATION = SynchedEntityData.defineId(SeatEntity.class, EntityDataSerializers.FLOAT);

    public SeatEntity(EntityType<?> type, Level level) {
        super(type, level);
        setInvulnerable(true);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putFloat("Rotation", getRotation());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        setRotation(compound.getFloat("Rotation"));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(ROTATION, 0.0F);
    }

    public float getRotation() {
        return this.entityData.get(ROTATION);
    }

    public void setRotation(float rotation) {
        this.entityData.set(ROTATION, rotation);
    }

    @Override
    public void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if (!level().isClientSide && getBlockStateOn().is(UDTags.BlockT.SEATS)) {
            level().setBlockAndUpdate(blockPosition(), getBlockStateOn().setValue(BlockStateProperties.OCCUPIED, false));
            discard();
        } else {
            discard();
        }
    }

    @Override
    public void stopRiding() {
        if (!level().isClientSide && getBlockStateOn().is(UDTags.BlockT.SEATS)) {
            level().setBlockAndUpdate(blockPosition(), getBlockStateOn().setValue(BlockStateProperties.OCCUPIED, false));
        }
        super.stopRiding();
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (!level().isClientSide && !(getPassengers() instanceof Player)) {
            removePassenger((Entity) getPassengers());
            return InteractionResult.SUCCESS;
        }
        else return super.interact(player, hand);
    }

    @Override
    protected boolean canAddPassenger(Entity entity) {
        return true;
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity livingEntity) {
        Vec3 vec3 = getCollisionHorizontalEscapeVector(getBbWidth() * Mth.SQRT_OF_TWO, livingEntity.getBbWidth(), livingEntity.getYRot());
        double x = getX() + vec3.x;
        double z = getZ() + vec3.z;
        BlockPos pos = BlockPos.containing(x, getBoundingBox().maxY, z);
        BlockPos posBelow = pos.below();
        if (!level().isWaterAt(posBelow)) {
            List<Vec3> list = Lists.newArrayList();
            if (DismountHelper.isBlockFloorValid(level().getBlockFloorHeight(pos))) {
                list.add(new Vec3(x, (double) pos.getY() + level().getBlockFloorHeight(pos), z));
            }

            double floorHeight = level().getBlockFloorHeight(posBelow);
            if (DismountHelper.isBlockFloorValid(floorHeight)) {
                list.add(new Vec3(x, (double) posBelow.getY() + floorHeight, z));
            }

            while (livingEntity.getDismountPoses().iterator().hasNext()) {
                Pose pose = livingEntity.getDismountPoses().iterator().next();
                for (Vec3 vec31 : list) {
                    if (DismountHelper.canDismountTo(level(), vec31, livingEntity, pose)) {
                        livingEntity.setPose(pose);
                        return vec31;
                    }
                }
            }
        }
        return super.getDismountLocationForPassenger(livingEntity);
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide) {
            if (!getBlockStateOn().is(UDTags.BlockT.SEATS)) {
                remove(RemovalReason.DISCARDED);
            }
        }
    }
}
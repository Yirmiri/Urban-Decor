package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.yirmiri.urban_decor.core.registry.UDSounds;

public class MattressBlock extends Block {
    public MattressBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (fallDistance >= 0.4F) {
            float adjustedFall = fallDistance - 0.4F;
            entity.playSound(UDSounds.MATTRESS_SQUEAK.get(), Math.min(1.0F, 0.2F + (adjustedFall * 0.3F)), 0.9F
                    + entity.level().random.nextFloat() * 0.2F);
        }
        super.fallOn(level, state, pos, entity, fallDistance * 0.5F);
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter level, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(level, entity);
        } else {
            this.bounceUp(entity);
        }
    }

    private void bounceUp(Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.y < (double) 0.0F) {
            double v = entity instanceof LivingEntity ? (double) 1.0F : 0.8;
            entity.setDeltaMovement(vec3.x, -vec3.y * (double) 0.75F * v, vec3.z);
        }
    }
}

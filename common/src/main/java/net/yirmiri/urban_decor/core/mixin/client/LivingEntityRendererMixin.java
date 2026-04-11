package net.yirmiri.urban_decor.core.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.yirmiri.urban_decor.common.entity.SeatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity> {

    @Inject(method = "render*", at = @At("HEAD"))
    private void urbanDecor$render(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight, CallbackInfo ci) {
        if (entity.getVehicle() instanceof SeatEntity seatEntity) {
            poseStack.mulPose(Axis.ZP.rotationDegrees(-seatEntity.getRotation()));
            poseStack.translate(0.0D, -entity.getBbHeight(), 0.0D);
        }
    }

    @Inject(method = "getShadowRadius(Lnet/minecraft/world/entity/Entity;)F", at = @At("HEAD"), cancellable = true)
    private void urbanDecor$getShadowRadius(Entity entity, CallbackInfoReturnable<Float> cir) {
        if (entity.getVehicle() instanceof SeatEntity seatEntity) {
            if (seatEntity.getRotation() != 0) {
                cir.setReturnValue(0.0F);
            }
        }
    }
}
package net.yirmiri.urban_decor.core.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.effect.MobEffects;
import net.yirmiri.urban_decor.common.entity.SeatEntity;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

    @Inject(method = "getProjectionMatrix", at = @At("RETURN"), cancellable = true)
    private void urbanDecor$getProjectionMatrix(double fov, CallbackInfoReturnable<Matrix4f> cir) {
        Minecraft minecraft = Minecraft.getInstance();

        if (minecraft.player != null && minecraft.player.getVehicle() instanceof SeatEntity seatEntity) {
            Matrix4f matrix = new Matrix4f(cir.getReturnValue());
            matrix.rotateZ((float) Math.toRadians(seatEntity.getRotation()));
            cir.setReturnValue(matrix);
        }
    }
}
package net.yirmiri.urban_decor.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.yirmiri.urban_decor.entity.ToiletEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
    @Inject(at = @At("HEAD"), method = "onPlayerCollision", cancellable = true)
    private void urbanDecor$onPlayerCollision(PlayerEntity player, CallbackInfo ci) {
        if (player.getVehicle() instanceof ToiletEntity) {
            ci.cancel();
        }
    }
}

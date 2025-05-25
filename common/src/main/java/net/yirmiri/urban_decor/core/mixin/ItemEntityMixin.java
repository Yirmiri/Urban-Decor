package net.yirmiri.urban_decor.core.mixin;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.yirmiri.urban_decor.common.entity.ToiletEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {

    @Inject(at = @At("HEAD"), method = "playerTouch", cancellable = true)
    private void urbanDecor$playerTouch(Player player, CallbackInfo ci) {
        if (player.getVehicle() instanceof ToiletEntity) {
            ci.cancel();
        }
    }
}

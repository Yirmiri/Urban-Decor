package net.yirmiri.urban_decor.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Environment(EnvType.CLIENT)
@Mixin(Item.class)
public abstract class ItemMixin {

    @Inject(at = @At("HEAD"), method = "appendTooltip")
    private void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        if (stack.isIn(UDItemTagProvider.TOOLBOXABLE)) {
            tooltip.add(Text.translatable("tooltip." + UrbanDecor.MOD_ID + ".toolboxable").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
        }
    }
}

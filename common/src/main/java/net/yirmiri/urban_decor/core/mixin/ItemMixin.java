package net.yirmiri.urban_decor.core.mixin;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.core.init.UDTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Inject(at = @At("HEAD"), method = "appendHoverText")
    private void urbanDecor$appendTooltip(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag context, CallbackInfo ci) {
        if (stack.is(UDTags.ItemT.HAS_TOOLBOX_VARIANTS)) {
            tooltip.add(Component.translatable("tooltip." + UrbanDecor.MOD_ID + ".toolboxable").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }

        if (stack.is(UDTags.ItemT.HAS_WRAPPED_VARIANTS)) {
            tooltip.add(Component.translatable("tooltip." + UrbanDecor.MOD_ID + ".wrappable").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
    }
}

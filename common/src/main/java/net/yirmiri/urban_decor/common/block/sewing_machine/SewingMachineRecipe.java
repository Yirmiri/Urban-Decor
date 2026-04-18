package net.yirmiri.urban_decor.common.block.sewing_machine;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDComponents;
import net.yirmiri.urban_decor.core.registry.UDItems;

public record SewingMachineRecipe(ResourceLocation texture, boolean requiresNeedle) {

    public boolean matches(ItemStack itemA, ItemStack itemB) {
        if (!itemA.is(UDBlocks.DOLL.get().asItem())) return false;

        if (requiresNeedle) {
            if (!itemB.is(UDItems.SEWING_NEEDLE.get())) return false;
            if (!itemB.has(UDComponents.DOLL_TEXTURE.get())) return false;

            var needleTex = itemB.get(UDComponents.DOLL_TEXTURE.get());
            return needleTex != null && needleTex.equals(this.texture);
        }

        return itemB.isEmpty() || itemB.is(UDItems.SEWING_NEEDLE.get());
    }

    public ItemStack assemble(ItemStack itemA, ItemStack itemB) {
        ItemStack stack = new ItemStack(UDBlocks.DOLL.get(), 1);

        if (requiresNeedle && !itemB.isEmpty() && itemB.has(UDComponents.DOLL_TEXTURE.get())) {
            stack.set(UDComponents.DOLL_TEXTURE.get(), itemB.get(UDComponents.DOLL_TEXTURE.get()));
        } else {
            stack.set(UDComponents.DOLL_TEXTURE.get(), texture);
        }
        return stack;
    }
}
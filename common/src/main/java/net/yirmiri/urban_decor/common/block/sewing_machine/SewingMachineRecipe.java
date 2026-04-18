package net.yirmiri.urban_decor.common.block.sewing_machine;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDComponents;
import net.yirmiri.urban_decor.core.registry.UDItems;

public record SewingMachineRecipe(ResourceLocation texture) {

    public boolean matches(ItemStack itemA, ItemStack itemB) {
        return itemA.is(UDBlocks.DOLL.get().asItem()) && (itemB.isEmpty() || itemB.is(UDItems.SEWING_NEEDLE.get()));
    }

    public ItemStack assemble() {
        ItemStack stack = new ItemStack(UDBlocks.DOLL.get(), 1);
        stack.set(UDComponents.DOLL_TEXTURE.get(), texture);
        return stack;
    }
}
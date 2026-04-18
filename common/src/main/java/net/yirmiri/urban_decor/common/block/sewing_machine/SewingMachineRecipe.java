package net.yirmiri.urban_decor.common.block.sewing_machine;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public record SewingMachineRecipe(Ingredient inputA, Ingredient inputB, ItemStack result) {
    public boolean matches(ItemStack a, ItemStack b) {
        return inputA.test(a) && inputB.test(b);
    }

    public ItemStack assemble() {
        return result.copy();
    }
}
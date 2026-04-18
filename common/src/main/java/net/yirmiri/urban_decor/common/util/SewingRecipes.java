package net.yirmiri.urban_decor.common.util;

import net.azurune.runiclib.RunicLib;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.sewing_machine.SewingMachineRecipe;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDComponents;

import java.util.List;

public class SewingRecipes {
    public static final List<SewingMachineRecipe> RECIPES = List.of(
            new SewingMachineRecipe(Ingredient.of(UDBlocks.DOLL.get()), Ingredient.of(ItemStack.EMPTY),
                    new ItemStack(UDBlocks.DOLL.get(), 1)),

            new SewingMachineRecipe(Ingredient.of(UDBlocks.DOLL.get()), Ingredient.of(ItemStack.EMPTY),
                    createCustomDoll(UrbanDecor.MOD_ID, "textures/entity/doll/yirmiri.png"))
    );

    private static ItemStack createCustomDoll(String modid, String path) {
        ItemStack stack = new ItemStack(UDBlocks.DOLL.get(), 1);

        stack.set(UDComponents.DOLL_TEXTURE.get(), RunicLib.customid(modid, path));
        return stack;
    }
}
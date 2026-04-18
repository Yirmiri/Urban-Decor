package net.yirmiri.urban_decor.common.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.azurune.runiclib.RunicLib;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.sewing_machine.SewingMachineRecipe;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDComponents;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class SewingRecipes {
    public static final List<SewingMachineRecipe> RECIPES = new ArrayList<>();

    public static void reload(ResourceManager manager) {
        RECIPES.clear();

        FileToIdConverter converter = new FileToIdConverter("dolls", ".json");

        for (ResourceLocation id : converter.listMatchingResources(manager).keySet()) {
            try {
                Resource resource = manager.getResource(id).orElseThrow();

                try (Reader reader = new InputStreamReader(resource.open())) {
                    JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();

                    ResourceLocation texture = ResourceLocation.parse(json.get("resource_location").getAsString());

                    RECIPES.add(new SewingMachineRecipe(texture));
                }
            } catch (Exception exception) {
                UrbanDecor.LOGGER.error("Failed to load sewing recipe {}", id, exception);
            }
        }
    }
}
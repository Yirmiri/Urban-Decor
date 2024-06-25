package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.registry.RegisterBlocks;
import net.yirmiri.urban_decor.registry.RegisterItems;

import java.util.function.Consumer;

public class UDRecipeProvider extends FabricRecipeProvider {
    public UDRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        createFourForOneRecipe(RegisterBlocks.PORCELAIN_TILES,
                Ingredient.ofItems(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.PORCELAIN_TILES)));

        createStairsRecipe(RegisterBlocks.PORCELAIN_TILE_STAIRS,
                Ingredient.ofItems(RegisterBlocks.PORCELAIN_TILES))
                .criterion(hasItem(RegisterBlocks.PORCELAIN_TILES), conditionsFromItem(RegisterBlocks.PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.PORCELAIN_TILE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.PORCELAIN_TILE_SLAB,
                Ingredient.ofItems(RegisterBlocks.PORCELAIN_TILES))
                .criterion(hasItem(RegisterBlocks.PORCELAIN_TILES), conditionsFromItem(RegisterBlocks.PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.PORCELAIN_TILE_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.PORCELAIN_TILE_STAIRS, RegisterBlocks.PORCELAIN_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.PORCELAIN_TILE_SLAB, RegisterBlocks.PORCELAIN_TILES, 2);
    }

    public static ShapedRecipeJsonBuilder createFourForFourWendysMealRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .input('#', input)
                .pattern("##")
                .pattern("##");
    }

    public static ShapedRecipeJsonBuilder createFourForOneRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1)
                .input('#', input)
                .pattern("##")
                .pattern("##");
    }
}

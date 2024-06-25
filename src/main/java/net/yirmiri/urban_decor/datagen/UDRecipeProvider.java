package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.PORCELAIN, 4)
                .input('#', Items.CLAY_BALL).input('@', Items.FLINT)
                .pattern("@#")
                .pattern("##")
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterItems.PORCELAIN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.STAINLESS_STEEL, 2)
                .input('#', Items.COAL).input('@', Items.IRON_INGOT).input('$', RegisterBlocks.CHROMITE)
                .pattern("#$")
                .pattern("@$")
                .criterion(hasItem(RegisterBlocks.CHROMITE), conditionsFromItem(RegisterBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterItems.STAINLESS_STEEL)));

        createStairsRecipe(RegisterBlocks.CHROMITE_STAIRS,
                Ingredient.ofItems(RegisterBlocks.CHROMITE))
                .criterion(hasItem(RegisterBlocks.CHROMITE), conditionsFromItem(RegisterBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.CHROMITE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.CHROMITE_SLAB,
                Ingredient.ofItems(RegisterBlocks.CHROMITE))
                .criterion(hasItem(RegisterBlocks.CHROMITE), conditionsFromItem(RegisterBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.CHROMITE_SLAB)));

        getWallRecipe(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.CHROMITE_WALL,
                Ingredient.ofItems(RegisterBlocks.CHROMITE))
                .criterion(hasItem(RegisterBlocks.CHROMITE), conditionsFromItem(RegisterBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.CHROMITE_WALL)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.CHROMITE_STAIRS, RegisterBlocks.CHROMITE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.CHROMITE_SLAB, RegisterBlocks.CHROMITE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.CHROMITE_WALL, RegisterBlocks.CHROMITE, 1);

        createFourForFourWendysMealRecipe(RegisterBlocks.POLISHED_CHROMITE,
                Ingredient.ofItems(RegisterBlocks.CHROMITE))
                .criterion(hasItem(RegisterBlocks.CHROMITE), conditionsFromItem(RegisterBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.POLISHED_CHROMITE)));

        createStairsRecipe(RegisterBlocks.POLISHED_CHROMITE_STAIRS,
                Ingredient.ofItems(RegisterBlocks.POLISHED_CHROMITE))
                .criterion(hasItem(RegisterBlocks.POLISHED_CHROMITE), conditionsFromItem(RegisterBlocks.POLISHED_CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.POLISHED_CHROMITE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.POLISHED_CHROMITE_SLAB,
                Ingredient.ofItems(RegisterBlocks.POLISHED_CHROMITE))
                .criterion(hasItem(RegisterBlocks.POLISHED_CHROMITE), conditionsFromItem(RegisterBlocks.POLISHED_CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.POLISHED_CHROMITE_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.POLISHED_CHROMITE_STAIRS, RegisterBlocks.POLISHED_CHROMITE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.POLISHED_CHROMITE_SLAB, RegisterBlocks.POLISHED_CHROMITE, 2);
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

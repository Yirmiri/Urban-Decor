package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
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
        createTwoByTwoRecipe(RegisterBlocks.PORCELAIN_BLOCK, 1,
                Ingredient.ofItems(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.PORCELAIN_BLOCK)));

        createStairsRecipe(RegisterBlocks.PORCELAIN_TILE_STAIRS,
                Ingredient.ofItems(RegisterBlocks.PORCELAIN_TILES))
                .criterion(hasItem(RegisterBlocks.PORCELAIN_TILES), conditionsFromItem(RegisterBlocks.PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.PORCELAIN_TILE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.PORCELAIN_TILE_SLAB,
                Ingredient.ofItems(RegisterBlocks.PORCELAIN_TILES))
                .criterion(hasItem(RegisterBlocks.PORCELAIN_TILES), conditionsFromItem(RegisterBlocks.PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.PORCELAIN_TILE_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.PORCELAIN_TILES, RegisterBlocks.PORCELAIN_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.PORCELAIN_TILE_STAIRS, RegisterBlocks.PORCELAIN_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.PORCELAIN_TILE_SLAB, RegisterBlocks.PORCELAIN_TILES, 2);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.PORCELAIN, 4)
                .input('#', Items.CLAY_BALL).input('@', Items.FLINT)
                .pattern("@#")
                .pattern("##")
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterItems.PORCELAIN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.STAINLESS_STEEL_INGOT, 2)
                .input('#', Items.COAL).input('@', Items.IRON_INGOT).input('$', RegisterBlocks.CHROMITE)
                .pattern("#$")
                .pattern("@$")
                .criterion(hasItem(RegisterBlocks.CHROMITE), conditionsFromItem(RegisterBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterItems.STAINLESS_STEEL_INGOT) + "_from_chromite"));

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

        createTwoByTwoRecipe(RegisterBlocks.DARK_PORCELAIN_BLOCK, 1,
                Ingredient.ofItems(RegisterItems.DARK_PORCELAIN))
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_PORCELAIN_BLOCK)));

        createStairsRecipe(RegisterBlocks.DARK_PORCELAIN_TILE_STAIRS,
                Ingredient.ofItems(RegisterBlocks.DARK_PORCELAIN_TILES))
                .criterion(hasItem(RegisterBlocks.DARK_PORCELAIN_TILES), conditionsFromItem(RegisterBlocks.DARK_PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_PORCELAIN_TILE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.DARK_PORCELAIN_TILE_SLAB,
                Ingredient.ofItems(RegisterBlocks.DARK_PORCELAIN_TILES))
                .criterion(hasItem(RegisterBlocks.DARK_PORCELAIN_TILES), conditionsFromItem(RegisterBlocks.DARK_PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_PORCELAIN_TILE_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.DARK_PORCELAIN_TILES, RegisterBlocks.DARK_PORCELAIN_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.DARK_PORCELAIN_TILE_STAIRS, RegisterBlocks.DARK_PORCELAIN_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.DARK_PORCELAIN_TILE_SLAB, RegisterBlocks.DARK_PORCELAIN_TILES, 2);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.CHECKERED_PORCELAIN_TILES, 1)
                .input('#', RegisterItems.PORCELAIN).input('@', RegisterItems.DARK_PORCELAIN)
                .pattern("@#")
                .pattern("#@")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.CHECKERED_PORCELAIN_TILES)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.CHECKERED_PORCELAIN_TILES, 4)
                .input('#', RegisterBlocks.PORCELAIN_TILES).input('@', RegisterBlocks.DARK_PORCELAIN_TILES)
                .pattern("@#")
                .pattern("#@")
                .criterion(hasItem(RegisterBlocks.PORCELAIN_TILES), conditionsFromItem(RegisterBlocks.PORCELAIN_TILES))
                .criterion(hasItem(RegisterBlocks.DARK_PORCELAIN_TILES), conditionsFromItem(RegisterBlocks.DARK_PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.CHECKERED_PORCELAIN_TILES) + "_from_blocks"));

        createStairsRecipe(RegisterBlocks.CHECKERED_PORCELAIN_TILE_STAIRS,
                Ingredient.ofItems(RegisterBlocks.CHECKERED_PORCELAIN_TILES))
                .criterion(hasItem(RegisterBlocks.CHECKERED_PORCELAIN_TILES), conditionsFromItem(RegisterBlocks.CHECKERED_PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.CHECKERED_PORCELAIN_TILE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.CHECKERED_PORCELAIN_TILE_SLAB,
                Ingredient.ofItems(RegisterBlocks.CHECKERED_PORCELAIN_TILES))
                .criterion(hasItem(RegisterBlocks.CHECKERED_PORCELAIN_TILES), conditionsFromItem(RegisterBlocks.CHECKERED_PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.CHECKERED_PORCELAIN_TILE_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.CHECKERED_PORCELAIN_TILE_STAIRS, RegisterBlocks.CHECKERED_PORCELAIN_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.CHECKERED_PORCELAIN_TILE_SLAB, RegisterBlocks.CHECKERED_PORCELAIN_TILES, 2);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, RegisterItems.STAINLESS_STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.STAINLESS_STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RegisterItems.STEEL_PIPE, 2)
                .input('#', RegisterItems.STAINLESS_STEEL_INGOT)
                .pattern("##")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterItems.STEEL_PIPE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.DARK_PORCELAIN, 2)
                .input('#', RegisterItems.PORCELAIN).input('@', RegisterBlocks.CHROMITE)
                .pattern("@#")
                .pattern("#@")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterBlocks.CHROMITE), conditionsFromItem(RegisterBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterItems.DARK_PORCELAIN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.TOILET, 1)
                .input('#', RegisterItems.PORCELAIN).input('@', RegisterItems.STEEL_PIPE)
                .pattern("#  ")
                .pattern("###")
                .pattern("@@ ")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.TOILET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DARK_TOILET, 1)
                .input('#', RegisterItems.DARK_PORCELAIN).input('@', RegisterItems.STEEL_PIPE)
                .pattern("#  ")
                .pattern("###")
                .pattern("@@ ")
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_TOILET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.FAUCET, 1)
                .input('#', RegisterItems.STEEL_PIPE)
                .pattern("##")
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.FAUCET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.SINK, 1)
                .input('#', RegisterItems.PORCELAIN).input('@', RegisterItems.STEEL_PIPE).input('%', RegisterItems.STAINLESS_STEEL_INGOT)
                .pattern(" @ ")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.SINK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DARK_SINK, 1)
                .input('#', RegisterItems.DARK_PORCELAIN).input('@', RegisterItems.STEEL_PIPE).input('%', RegisterItems.STAINLESS_STEEL_INGOT)
                .pattern(" @ ")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_SINK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.WASHING_MACHINE, 1)
                .input('#', RegisterItems.PORCELAIN).input('@', RegisterItems.STEEL_PIPE).input('%', RegisterItems.STAINLESS_STEEL_INGOT).input('&', UDItemTagProvider.GLASS)
                .pattern("#&#")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.WASHING_MACHINE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DARK_WASHING_MACHINE, 1)
                .input('#', RegisterItems.DARK_PORCELAIN).input('@', RegisterItems.STEEL_PIPE).input('%', RegisterItems.STAINLESS_STEEL_INGOT).input('&', UDItemTagProvider.GLASS)
                .pattern("#&#")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_WASHING_MACHINE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DRYER, 1)
                .input('#', RegisterItems.PORCELAIN).input('@', RegisterItems.STEEL_PIPE).input('%', RegisterItems.STAINLESS_STEEL_INGOT)
                .pattern("###")
                .pattern("% #")
                .pattern("#@#")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DRYER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DARK_DRYER, 1)
                .input('#', RegisterItems.DARK_PORCELAIN).input('@', RegisterItems.STEEL_PIPE).input('%', RegisterItems.STAINLESS_STEEL_INGOT)
                .pattern("###")
                .pattern("% #")
                .pattern("#@#")
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_DRYER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.OVEN, 1)
                .input('#', RegisterItems.PORCELAIN).input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('%', Items.REDSTONE).input('&', Items.SMOKER)
                .pattern("@@@")
                .pattern("#&#")
                .pattern("#%#")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.OVEN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DARK_OVEN, 1)
                .input('#', RegisterItems.DARK_PORCELAIN).input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('%', Items.REDSTONE).input('&', Items.SMOKER)
                .pattern("@@@")
                .pattern("#&#")
                .pattern("#%#")
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_OVEN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.FRIDGE, 1)
                .input('#', RegisterItems.PORCELAIN).input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('%', Items.PACKED_ICE)
                .pattern("@@@")
                .pattern("# #")
                .pattern("#%#")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.FRIDGE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DARK_FRIDGE, 1)
                .input('#', RegisterItems.DARK_PORCELAIN).input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('%', Items.PACKED_ICE)
                .pattern("@@@")
                .pattern("# #")
                .pattern("#%#")
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_FRIDGE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.FREEZER, 1)
                .input('#', RegisterItems.PORCELAIN).input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('%', Items.PACKED_ICE)
                .pattern("##@")
                .pattern("%%@")
                .pattern("##@")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.FREEZER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DARK_FREEZER, 1)
                .input('#', RegisterItems.DARK_PORCELAIN).input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('%', Items.PACKED_ICE)
                .pattern("##@")
                .pattern("%%@")
                .pattern("##@")
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_FREEZER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterItems.TOOLBOX, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT)
                .pattern("@@@")
                .pattern("@ @")
                .pattern("@@@")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterItems.TOOLBOX)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.STOVE, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('#', Items.MAGMA_BLOCK)
                .pattern("@#@")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.STOVE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.TOASTER, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('#', Items.MAGMA_BLOCK).input('!', Items.REDSTONE)
                .pattern("@!@")
                .pattern("@#@")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.TOASTER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.MICROWAVE, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('!', Items.REDSTONE)
                .pattern("@!@")
                .pattern("! !")
                .pattern("@!@")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.MICROWAVE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.TRASH_CAN, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT)
                .pattern("@ @")
                .pattern(" @ ")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.TRASH_CAN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DESK_FAN, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('!', Items.REDSTONE)
                .pattern(" @ ")
                .pattern(" @ ")
                .pattern("@!@")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DESK_FAN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.TURBINE, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('!', Items.REDSTONE)
                .pattern("@@@")
                .pattern(" @ ")
                .pattern("@!@")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.TURBINE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.AIR_CONDITIONER, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('#', RegisterItems.STEEL_PIPE).input('^', Items.PACKED_ICE)
                .pattern("@ @")
                .pattern("###")
                .pattern("@^@")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.AIR_CONDITIONER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.RADIATOR, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('#', RegisterItems.STEEL_PIPE).input('^', Items.MAGMA_BLOCK)
                .pattern(" # ")
                .pattern("###")
                .pattern("@^@")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.RADIATOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.SATELLITE_DISH, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('!', Items.AMETHYST_SHARD)
                .pattern("@ !")
                .pattern(" @ ")
                .pattern("@ @")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.SATELLITE_DISH)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.SHOWER, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT).input('#', RegisterItems.STEEL_PIPE)
                .pattern("@#")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(RegisterItems.STEEL_PIPE), conditionsFromItem(RegisterItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.SHOWER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.TOWEL_BAR, 1)
                .input('@', RegisterItems.STAINLESS_STEEL_INGOT)
                .pattern("@@@")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.TOWEL_BAR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.WHITE.getId()), 1)
                .input('@', Blocks.WHITE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.WHITE_CARPET), conditionsFromItem(Blocks.WHITE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.WHITE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()), 1)
                .input('@', Blocks.LIGHT_GRAY_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.LIGHT_GRAY_CARPET), conditionsFromItem(Blocks.LIGHT_GRAY_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.GRAY.getId()), 1)
                .input('@', Blocks.GRAY_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.GRAY_CARPET), conditionsFromItem(Blocks.GRAY_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.GRAY.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.BLACK.getId()), 1)
                .input('@', Blocks.BLACK_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.BLACK_CARPET), conditionsFromItem(Blocks.BLACK_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.BLACK.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.RED.getId()), 1)
                .input('@', Blocks.RED_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.RED_CARPET), conditionsFromItem(Blocks.RED_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.RED.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.ORANGE.getId()), 1)
                .input('@', Blocks.ORANGE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.ORANGE_CARPET), conditionsFromItem(Blocks.ORANGE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.ORANGE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.YELLOW.getId()), 1)
                .input('@', Blocks.YELLOW_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.YELLOW_CARPET), conditionsFromItem(Blocks.YELLOW_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.YELLOW.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.LIME.getId()), 1)
                .input('@', Blocks.LIME_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.LIME_CARPET), conditionsFromItem(Blocks.LIME_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.LIME.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.GREEN.getId()), 1)
                .input('@', Blocks.GREEN_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.GREEN_CARPET), conditionsFromItem(Blocks.GREEN_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.GREEN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.CYAN.getId()), 1)
                .input('@', Blocks.CYAN_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.CYAN_CARPET), conditionsFromItem(Blocks.CYAN_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.CYAN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()), 1)
                .input('@', Blocks.LIGHT_BLUE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.LIGHT_BLUE_CARPET), conditionsFromItem(Blocks.LIGHT_BLUE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.BLUE.getId()), 1)
                .input('@', Blocks.BLUE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.BLUE_CARPET), conditionsFromItem(Blocks.BLUE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.BLUE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.PURPLE.getId()), 1)
                .input('@', Blocks.PURPLE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.PURPLE_CARPET), conditionsFromItem(Blocks.PURPLE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.PURPLE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.MAGENTA.getId()), 1)
                .input('@', Blocks.MAGENTA_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.MAGENTA_CARPET), conditionsFromItem(Blocks.MAGENTA_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.MAGENTA.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.PINK.getId()), 1)
                .input('@', Blocks.PINK_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.PINK_CARPET), conditionsFromItem(Blocks.PINK_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.PINK.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowels(DyeColor.BROWN.getId()), 1)
                .input('@', Blocks.BROWN_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.BROWN_CARPET), conditionsFromItem(Blocks.BROWN_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowels(DyeColor.BROWN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()), 4)
                .input('@', Blocks.WHITE_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.WHITE_WOOL), conditionsFromItem(Blocks.WHITE_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()), 4)
                .input('@', Blocks.LIGHT_GRAY_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.LIGHT_GRAY_WOOL), conditionsFromItem(Blocks.LIGHT_GRAY_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()), 4)
                .input('@', Blocks.GRAY_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.GRAY_WOOL), conditionsFromItem(Blocks.GRAY_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()), 4)
                .input('@', Blocks.BLACK_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.BLACK_WOOL), conditionsFromItem(Blocks.BLACK_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.RED.getId()), 4)
                .input('@', Blocks.RED_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.RED_WOOL), conditionsFromItem(Blocks.RED_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.RED.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()), 4)
                .input('@', Blocks.ORANGE_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.ORANGE_WOOL), conditionsFromItem(Blocks.ORANGE_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()), 4)
                .input('@', Blocks.YELLOW_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.YELLOW_WOOL), conditionsFromItem(Blocks.YELLOW_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()), 4)
                .input('@', Blocks.LIME_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.LIME_WOOL), conditionsFromItem(Blocks.LIME_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()), 4)
                .input('@', Blocks.GREEN_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.GREEN_WOOL), conditionsFromItem(Blocks.GREEN_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()), 4)
                .input('@', Blocks.CYAN_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.CYAN_WOOL), conditionsFromItem(Blocks.CYAN_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()), 4)
                .input('@', Blocks.LIGHT_BLUE_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.LIGHT_BLUE_WOOL), conditionsFromItem(Blocks.LIGHT_BLUE_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()), 4)
                .input('@', Blocks.BLUE_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.BLUE_WOOL), conditionsFromItem(Blocks.BLUE_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()), 4)
                .input('@', Blocks.PURPLE_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.PURPLE_WOOL), conditionsFromItem(Blocks.PURPLE_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()), 4)
                .input('@', Blocks.MAGENTA_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.MAGENTA_WOOL), conditionsFromItem(Blocks.MAGENTA_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()), 4)
                .input('@', Blocks.PINK_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.PINK_WOOL), conditionsFromItem(Blocks.PINK_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()), 4)
                .input('@', Blocks.BROWN_WOOL)
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(Blocks.BROWN_WOOL), conditionsFromItem(Blocks.BROWN_WOOL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.RIGID_GLASS, 3)
                .input('#', RegisterItems.STAINLESS_STEEL_INGOT).input('@', Items.GLASS_PANE)
                .pattern("#@#")
                .pattern("#@#")
                .pattern("#@#")
                .criterion(hasItem(RegisterItems.STAINLESS_STEEL_INGOT), conditionsFromItem(RegisterItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.RIGID_GLASS)));

        createTwoByTwoRecipe(RegisterBlocks.PORCELAIN_TILES, 4,
                Ingredient.ofItems(RegisterBlocks.PORCELAIN_BLOCK))
                .criterion(hasItem(RegisterBlocks.PORCELAIN_BLOCK), conditionsFromItem(RegisterBlocks.PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.PORCELAIN_TILES)));

        createStairsRecipe(RegisterBlocks.PORCELAIN_STAIRS,
                Ingredient.ofItems(RegisterBlocks.PORCELAIN_BLOCK))
                .criterion(hasItem(RegisterBlocks.PORCELAIN_BLOCK), conditionsFromItem(RegisterBlocks.PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.PORCELAIN_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.PORCELAIN_SLAB,
                Ingredient.ofItems(RegisterBlocks.PORCELAIN_BLOCK))
                .criterion(hasItem(RegisterBlocks.PORCELAIN_BLOCK), conditionsFromItem(RegisterBlocks.PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.PORCELAIN_SLAB)));
        
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.PORCELAIN_STAIRS, RegisterBlocks.PORCELAIN_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.PORCELAIN_SLAB, RegisterBlocks.PORCELAIN_BLOCK, 2);

        createTwoByTwoRecipe(RegisterBlocks.DARK_PORCELAIN_TILES, 4,
                Ingredient.ofItems(RegisterBlocks.DARK_PORCELAIN_BLOCK))
                .criterion(hasItem(RegisterBlocks.DARK_PORCELAIN_BLOCK), conditionsFromItem(RegisterBlocks.DARK_PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_PORCELAIN_TILES)));

        createStairsRecipe(RegisterBlocks.DARK_PORCELAIN_STAIRS,
                Ingredient.ofItems(RegisterBlocks.DARK_PORCELAIN_BLOCK))
                .criterion(hasItem(RegisterBlocks.DARK_PORCELAIN_BLOCK), conditionsFromItem(RegisterBlocks.DARK_PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_PORCELAIN_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.DARK_PORCELAIN_SLAB,
                Ingredient.ofItems(RegisterBlocks.DARK_PORCELAIN_BLOCK))
                .criterion(hasItem(RegisterBlocks.DARK_PORCELAIN_BLOCK), conditionsFromItem(RegisterBlocks.DARK_PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_PORCELAIN_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.DARK_PORCELAIN_STAIRS, RegisterBlocks.DARK_PORCELAIN_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterBlocks.DARK_PORCELAIN_SLAB, RegisterBlocks.DARK_PORCELAIN_BLOCK, 2);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.BATHTUB, 1)
                .input('#', RegisterItems.PORCELAIN).input('@', RegisterBlocks.PORCELAIN_BLOCK)
                .pattern("# #")
                .pattern("# #")
                .pattern("@@@")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.BATHTUB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DARK_BATHTUB, 1)
                .input('#', RegisterItems.DARK_PORCELAIN).input('@', RegisterBlocks.DARK_PORCELAIN_BLOCK)
                .pattern("# #")
                .pattern("# #")
                .pattern("@@@")
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_BATHTUB)));

        for (DyeColor colors : DyeColor.values()) {
            createFromBasePictureFrameRecipe(RegisterBlocks.getDyedPictureFrames(colors.getId()), RegisterBlocks.PICTURE_FRAME, DyeItem.byColor(colors).getColor())
                    .criterion(hasItem(RegisterBlocks.getDyedPictureFrames(colors.getId())), conditionsFromItem(RegisterBlocks.getDyedPictureFrames(colors.getId())))
                    .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedPictureFrames(colors.getId())) + "_from_base"));
        }

        for (DyeColor colors : DyeColor.values()) {
            createPictureFrameRecipe(RegisterBlocks.getDyedPictureFrames(colors.getId()), DyeItem.byColor(colors).getColor())
                    .criterion(hasItem(RegisterBlocks.getDyedPictureFrames(colors.getId())), conditionsFromItem(RegisterBlocks.getDyedPictureFrames(colors.getId())))
                    .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.getDyedPictureFrames(colors.getId()))));
        }

        createBasePictureFrameRecipe(RegisterBlocks.PICTURE_FRAME, Items.PAPER)
                .criterion(hasItem(RegisterBlocks.PICTURE_FRAME), conditionsFromItem(RegisterBlocks.PICTURE_FRAME))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.PICTURE_FRAME)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.CUPBOARD, 1)
                .input('#', RegisterItems.PORCELAIN).input('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(RegisterItems.PORCELAIN), conditionsFromItem(RegisterItems.PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.CUPBOARD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.DARK_CUPBOARD, 1)
                .input('#', RegisterItems.DARK_PORCELAIN).input('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(RegisterItems.DARK_PORCELAIN), conditionsFromItem(RegisterItems.DARK_PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(RegisterBlocks.DARK_CUPBOARD)));
    }
//yes this only exists so i can name it four for four wendys meal... there is no need for this recipe builder
    public static ShapedRecipeJsonBuilder createFourForFourWendysMealRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .input('#', input)
                .pattern("##")
                .pattern("##");
    }

    public static ShapedRecipeJsonBuilder createTwoByTwoRecipe(ItemConvertible output, int count, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, count)
                .input('#', input)
                .pattern("##")
                .pattern("##");
    }

    public static ShapedRecipeJsonBuilder createPictureFrameRecipe(ItemConvertible output, DyeColor color) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
                .input('#', Items.STICK).input('@', DyeItem.byColor(color))
                .pattern("###")
                .pattern("#@#")
                .pattern("###");
    }

    public static ShapedRecipeJsonBuilder createBasePictureFrameRecipe(ItemConvertible output, Item item) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
                .input('#', Items.STICK).input('@', item)
                .pattern("###")
                .pattern("#@#")
                .pattern("###");
    }

    public static ShapelessRecipeJsonBuilder createFromBasePictureFrameRecipe(ItemConvertible output, Block picture, DyeColor color) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
                .input(picture).input(DyeItem.byColor(color));
    }

    public static ShapedRecipeJsonBuilder createTowelBlockRecipe(ItemConvertible output, Block input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 4)
                .input('#', input)
                .pattern("##")
                .pattern("##");
    }
}

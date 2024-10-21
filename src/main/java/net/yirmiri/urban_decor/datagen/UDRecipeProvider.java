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
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.registry.UDBlocks;
import net.yirmiri.urban_decor.registry.UDItems;

import java.util.function.Consumer;

public class UDRecipeProvider extends FabricRecipeProvider {
    public UDRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, UDItems.PORCELAIN, 4)
                .input('#', Items.CLAY_BALL).input('@', Items.FLINT)
                .pattern("@#")
                .pattern("##")
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.PORCELAIN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, UDItems.STAINLESS_STEEL_INGOT, 2)
                .input('#', Items.COAL).input('@', Items.IRON_INGOT).input('$', UDBlocks.CHROMITE)
                .pattern("#$")
                .pattern("@$")
                .criterion(hasItem(UDBlocks.CHROMITE), conditionsFromItem(UDBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.STAINLESS_STEEL_INGOT) + "_from_chromite"));

        createStairsRecipe(UDBlocks.CHROMITE_STAIRS,
                Ingredient.ofItems(UDBlocks.CHROMITE))
                .criterion(hasItem(UDBlocks.CHROMITE), conditionsFromItem(UDBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHROMITE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_SLAB,
                Ingredient.ofItems(UDBlocks.CHROMITE))
                .criterion(hasItem(UDBlocks.CHROMITE), conditionsFromItem(UDBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHROMITE_SLAB)));

        getWallRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_WALL,
                Ingredient.ofItems(UDBlocks.CHROMITE))
                .criterion(hasItem(UDBlocks.CHROMITE), conditionsFromItem(UDBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHROMITE_WALL)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_STAIRS, UDBlocks.CHROMITE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_SLAB, UDBlocks.CHROMITE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_WALL, UDBlocks.CHROMITE, 1);

        createFourForFourWendysMealRecipe(UDBlocks.POLISHED_CHROMITE,
                Ingredient.ofItems(UDBlocks.CHROMITE))
                .criterion(hasItem(UDBlocks.CHROMITE), conditionsFromItem(UDBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.POLISHED_CHROMITE)));

        createStairsRecipe(UDBlocks.POLISHED_CHROMITE_STAIRS,
                Ingredient.ofItems(UDBlocks.POLISHED_CHROMITE))
                .criterion(hasItem(UDBlocks.POLISHED_CHROMITE), conditionsFromItem(UDBlocks.POLISHED_CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.POLISHED_CHROMITE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.POLISHED_CHROMITE_SLAB,
                Ingredient.ofItems(UDBlocks.POLISHED_CHROMITE))
                .criterion(hasItem(UDBlocks.POLISHED_CHROMITE), conditionsFromItem(UDBlocks.POLISHED_CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.POLISHED_CHROMITE_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.POLISHED_CHROMITE_STAIRS, UDBlocks.POLISHED_CHROMITE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.POLISHED_CHROMITE_SLAB, UDBlocks.POLISHED_CHROMITE, 2);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILES, 1)
                .input('#', UDItems.PORCELAIN).input('@', UDItems.DARK_PORCELAIN)
                .pattern("@#")
                .pattern("#@")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILES)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILES, 4)
                .input('#', UDBlocks.PORCELAIN_TILES).input('@', UDBlocks.DARK_PORCELAIN_TILES)
                .pattern("@#")
                .pattern("#@")
                .criterion(hasItem(UDBlocks.PORCELAIN_TILES), conditionsFromItem(UDBlocks.PORCELAIN_TILES))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_TILES), conditionsFromItem(UDBlocks.DARK_PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILES) + "_from_blocks"));

        createStairsRecipe(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS,
                Ingredient.ofItems(UDBlocks.CHECKERED_PORCELAIN_TILES))
                .criterion(hasItem(UDBlocks.CHECKERED_PORCELAIN_TILES), conditionsFromItem(UDBlocks.CHECKERED_PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB,
                Ingredient.ofItems(UDBlocks.CHECKERED_PORCELAIN_TILES))
                .criterion(hasItem(UDBlocks.CHECKERED_PORCELAIN_TILES), conditionsFromItem(UDBlocks.CHECKERED_PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS, UDBlocks.CHECKERED_PORCELAIN_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB, UDBlocks.CHECKERED_PORCELAIN_TILES, 2);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, UDItems.STAINLESS_STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, UDBlocks.STAINLESS_STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, UDItems.STEEL_PIPE, 2)
                .input('#', UDItems.STAINLESS_STEEL_INGOT)
                .pattern("##")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.STEEL_PIPE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, UDItems.DARK_PORCELAIN, 2)
                .input('#', UDItems.PORCELAIN).input('@', UDBlocks.CHROMITE)
                .pattern("@#")
                .pattern("#@")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .criterion(hasItem(UDBlocks.CHROMITE), conditionsFromItem(UDBlocks.CHROMITE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.DARK_PORCELAIN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TOILET, 1)
                .input('#', UDItems.PORCELAIN).input('@', UDItems.STEEL_PIPE)
                .pattern("#  ")
                .pattern("###")
                .pattern("@@ ")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TOILET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_TOILET, 1)
                .input('#', UDItems.DARK_PORCELAIN).input('@', UDItems.STEEL_PIPE)
                .pattern("#  ")
                .pattern("###")
                .pattern("@@ ")
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_TOILET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.FAUCET, 1)
                .input('#', UDItems.STEEL_PIPE)
                .pattern("##")
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.FAUCET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.SINK, 1)
                .input('#', UDItems.PORCELAIN).input('@', UDItems.STEEL_PIPE).input('%', UDItems.STAINLESS_STEEL_INGOT)
                .pattern(" @ ")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.SINK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_SINK, 1)
                .input('#', UDItems.DARK_PORCELAIN).input('@', UDItems.STEEL_PIPE).input('%', UDItems.STAINLESS_STEEL_INGOT)
                .pattern(" @ ")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_SINK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.WASHING_MACHINE, 1)
                .input('#', UDItems.PORCELAIN).input('@', UDItems.STEEL_PIPE).input('%', UDItems.STAINLESS_STEEL_INGOT).input('&', UDItemTagProvider.GLASS)
                .pattern("#&#")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.WASHING_MACHINE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_WASHING_MACHINE, 1)
                .input('#', UDItems.DARK_PORCELAIN).input('@', UDItems.STEEL_PIPE).input('%', UDItems.STAINLESS_STEEL_INGOT).input('&', UDItemTagProvider.GLASS)
                .pattern("#&#")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_WASHING_MACHINE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DRYER, 1)
                .input('#', UDItems.PORCELAIN).input('@', UDItems.STEEL_PIPE).input('%', UDItems.STAINLESS_STEEL_INGOT)
                .pattern("###")
                .pattern("% #")
                .pattern("#@#")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DRYER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_DRYER, 1)
                .input('#', UDItems.DARK_PORCELAIN).input('@', UDItems.STEEL_PIPE).input('%', UDItems.STAINLESS_STEEL_INGOT)
                .pattern("###")
                .pattern("% #")
                .pattern("#@#")
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_DRYER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.OVEN, 1)
                .input('#', UDItems.PORCELAIN).input('@', UDItems.STAINLESS_STEEL_INGOT).input('%', Items.REDSTONE).input('&', Items.SMOKER)
                .pattern("@@@")
                .pattern("#&#")
                .pattern("#%#")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.OVEN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_OVEN, 1)
                .input('#', UDItems.DARK_PORCELAIN).input('@', UDItems.STAINLESS_STEEL_INGOT).input('%', Items.REDSTONE).input('&', Items.SMOKER)
                .pattern("@@@")
                .pattern("#&#")
                .pattern("#%#")
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_OVEN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.FRIDGE, 1)
                .input('#', UDItems.PORCELAIN).input('@', UDItems.STAINLESS_STEEL_INGOT).input('%', Items.PACKED_ICE)
                .pattern("@@@")
                .pattern("# #")
                .pattern("#%#")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.FRIDGE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_FRIDGE, 1)
                .input('#', UDItems.DARK_PORCELAIN).input('@', UDItems.STAINLESS_STEEL_INGOT).input('%', Items.PACKED_ICE)
                .pattern("@@@")
                .pattern("# #")
                .pattern("#%#")
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_FRIDGE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.FREEZER, 1)
                .input('#', UDItems.PORCELAIN).input('@', UDItems.STAINLESS_STEEL_INGOT).input('%', Items.PACKED_ICE)
                .pattern("##@")
                .pattern("%%@")
                .pattern("##@")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.FREEZER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_FREEZER, 1)
                .input('#', UDItems.DARK_PORCELAIN).input('@', UDItems.STAINLESS_STEEL_INGOT).input('%', Items.PACKED_ICE)
                .pattern("##@")
                .pattern("%%@")
                .pattern("##@")
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_FREEZER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDItems.TOOLBOX, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT)
                .pattern("@@@")
                .pattern("@ @")
                .pattern("@@@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.TOOLBOX)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.STOVE, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT).input('#', Items.MAGMA_BLOCK)
                .pattern("@#@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.STOVE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TOASTER, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT).input('#', Items.MAGMA_BLOCK).input('!', Items.REDSTONE)
                .pattern("@!@")
                .pattern("@#@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TOASTER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDItems.MICROWAVE, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT).input('!', Items.REDSTONE)
                .pattern("@!@")
                .pattern("! !")
                .pattern("@!@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.MICROWAVE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TRASH_CAN, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT)
                .pattern("@ @")
                .pattern(" @ ")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TRASH_CAN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DESK_FAN, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT).input('!', Items.REDSTONE)
                .pattern(" @ ")
                .pattern(" @ ")
                .pattern("@!@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DESK_FAN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TURBINE, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT).input('!', Items.REDSTONE)
                .pattern("@@@")
                .pattern(" @ ")
                .pattern("@!@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TURBINE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.AIR_CONDITIONER, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT).input('#', UDItems.STEEL_PIPE).input('^', Items.PACKED_ICE)
                .pattern("@ @")
                .pattern("###")
                .pattern("@^@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.AIR_CONDITIONER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.RADIATOR, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT).input('#', UDItems.STEEL_PIPE).input('^', Items.MAGMA_BLOCK)
                .pattern(" # ")
                .pattern("###")
                .pattern("@^@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.RADIATOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.SHOWER, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT).input('#', UDItems.STEEL_PIPE)
                .pattern("@#")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .criterion(hasItem(UDItems.STEEL_PIPE), conditionsFromItem(UDItems.STEEL_PIPE))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.SHOWER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TOWEL_BAR, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT)
                .pattern("@@@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TOWEL_BAR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.WHITE.getId()), 1)
                .input('@', Blocks.WHITE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.WHITE_CARPET), conditionsFromItem(Blocks.WHITE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()), 1)
                .input('@', Blocks.LIGHT_GRAY_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.LIGHT_GRAY_CARPET), conditionsFromItem(Blocks.LIGHT_GRAY_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.GRAY.getId()), 1)
                .input('@', Blocks.GRAY_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.GRAY_CARPET), conditionsFromItem(Blocks.GRAY_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.BLACK.getId()), 1)
                .input('@', Blocks.BLACK_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.BLACK_CARPET), conditionsFromItem(Blocks.BLACK_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.RED.getId()), 1)
                .input('@', Blocks.RED_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.RED_CARPET), conditionsFromItem(Blocks.RED_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.RED.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()), 1)
                .input('@', Blocks.ORANGE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.ORANGE_CARPET), conditionsFromItem(Blocks.ORANGE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()), 1)
                .input('@', Blocks.YELLOW_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.YELLOW_CARPET), conditionsFromItem(Blocks.YELLOW_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.LIME.getId()), 1)
                .input('@', Blocks.LIME_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.LIME_CARPET), conditionsFromItem(Blocks.LIME_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.LIME.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.GREEN.getId()), 1)
                .input('@', Blocks.GREEN_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.GREEN_CARPET), conditionsFromItem(Blocks.GREEN_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.CYAN.getId()), 1)
                .input('@', Blocks.CYAN_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.CYAN_CARPET), conditionsFromItem(Blocks.CYAN_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()), 1)
                .input('@', Blocks.LIGHT_BLUE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.LIGHT_BLUE_CARPET), conditionsFromItem(Blocks.LIGHT_BLUE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.BLUE.getId()), 1)
                .input('@', Blocks.BLUE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.BLUE_CARPET), conditionsFromItem(Blocks.BLUE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()), 1)
                .input('@', Blocks.PURPLE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.PURPLE_CARPET), conditionsFromItem(Blocks.PURPLE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()), 1)
                .input('@', Blocks.MAGENTA_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.MAGENTA_CARPET), conditionsFromItem(Blocks.MAGENTA_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.PINK.getId()), 1)
                .input('@', Blocks.PINK_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.PINK_CARPET), conditionsFromItem(Blocks.PINK_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.PINK.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.BROWN.getId()), 1)
                .input('@', Blocks.BROWN_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.BROWN_CARPET), conditionsFromItem(Blocks.BROWN_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.WHITE.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.WHITE.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.WHITE.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.GRAY.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.GRAY.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.GRAY.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.BLACK.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.BLACK.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.BLACK.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.RED.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.RED.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.RED.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.RED.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.RED.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.LIME.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.LIME.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.LIME.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.GREEN.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.GREEN.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.GREEN.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.CYAN.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.CYAN.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.CYAN.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.BLUE.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.BLUE.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.BLUE.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.PINK.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.PINK.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.PINK.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.BROWN.getId()))
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.BROWN.getId())), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.BROWN.getId())))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.RIGID_GLASS, 3)
                .input('#', UDItems.STAINLESS_STEEL_INGOT).input('@', Items.GLASS_PANE)
                .pattern("#@#")
                .pattern("#@#")
                .pattern("#@#")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.RIGID_GLASS)));

        for (DyeColor colors : DyeColor.values()) {
            createFromBasePictureFrameRecipe(UDItems.getDyedPictureFrames(colors.getId()), UDItems.PICTURE_FRAME, DyeItem.byColor(colors).getColor())
                    .criterion(hasItem(UDItems.getDyedPictureFrames(colors.getId())), conditionsFromItem(UDItems.getDyedPictureFrames(colors.getId())))
                    .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.getDyedPictureFrames(colors.getId())) + "_from_base"));
        }

        for (DyeColor colors : DyeColor.values()) {
            createPictureFrameRecipe(UDItems.getDyedPictureFrames(colors.getId()), DyeItem.byColor(colors).getColor())
                    .criterion(hasItem(UDItems.getDyedPictureFrames(colors.getId())), conditionsFromItem(UDItems.getDyedPictureFrames(colors.getId())))
                    .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.getDyedPictureFrames(colors.getId()))));
        }

        createBasePictureFrameRecipe(UDItems.PICTURE_FRAME, Items.PAPER)
                .criterion(hasItem(UDItems.PICTURE_FRAME), conditionsFromItem(UDItems.PICTURE_FRAME))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.PICTURE_FRAME)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.CUPBOARD, 1)
                .input('#', UDItems.PORCELAIN).input('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CUPBOARD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_CUPBOARD, 1)
                .input('#', UDItems.DARK_PORCELAIN).input('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_CUPBOARD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.FILING_CABINET, 1)
                .input('#', UDItems.STAINLESS_STEEL_INGOT).input('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.FILING_CABINET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TOILET_PAPER, 1)
                .input('#', Items.STICK).input('@', Items.PAPER)
                .pattern("@@@")
                .pattern("@#@")
                .pattern("@@@")
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TOILET_PAPER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDItems.SATELLITE_DISH, 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT).input('!', Items.AMETHYST_SHARD)
                .pattern("@ !")
                .pattern(" @ ")
                .pattern("@ @")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.SATELLITE_DISH)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.BATHTUB, 1)
                .input('#', UDItems.PORCELAIN).input('@', UDBlocks.PORCELAIN_BLOCK)
                .pattern("# #")
                .pattern("# #")
                .pattern("@@@")
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.BATHTUB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_BATHTUB, 1)
                .input('#', UDItems.DARK_PORCELAIN).input('@', UDBlocks.DARK_PORCELAIN_BLOCK)
                .pattern("# #")
                .pattern("# #")
                .pattern("@@@")
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_BATHTUB)));

        createTwoByTwoRecipe(UDBlocks.PORCELAIN_TILES, 4,
                Ingredient.ofItems(UDBlocks.PORCELAIN_BRICKS))
                .criterion(hasItem(UDBlocks.PORCELAIN_BRICKS), conditionsFromItem(UDBlocks.PORCELAIN_BRICKS))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_TILES)));

        createStairsRecipe(UDBlocks.PORCELAIN_STAIRS,
                Ingredient.ofItems(UDBlocks.PORCELAIN_BLOCK))
                .criterion(hasItem(UDBlocks.PORCELAIN_BLOCK), conditionsFromItem(UDBlocks.PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_SLAB,
                Ingredient.ofItems(UDBlocks.PORCELAIN_BLOCK))
                .criterion(hasItem(UDBlocks.PORCELAIN_BLOCK), conditionsFromItem(UDBlocks.PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_STAIRS, UDBlocks.PORCELAIN_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_SLAB, UDBlocks.PORCELAIN_BLOCK, 2);

        createTwoByTwoRecipe(UDBlocks.DARK_PORCELAIN_TILES, 4,
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BRICKS))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BRICKS), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BRICKS))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_TILES)));

        createStairsRecipe(UDBlocks.DARK_PORCELAIN_STAIRS,
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BLOCK))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BLOCK), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_SLAB,
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BLOCK))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BLOCK), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_STAIRS, UDBlocks.DARK_PORCELAIN_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_SLAB, UDBlocks.DARK_PORCELAIN_BLOCK, 2);

        createTwoByTwoRecipe(UDBlocks.PORCELAIN_BLOCK, 1,
                Ingredient.ofItems(UDItems.PORCELAIN))
                .criterion(hasItem(UDItems.PORCELAIN), conditionsFromItem(UDItems.PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_BLOCK)));

        createStairsRecipe(UDBlocks.PORCELAIN_TILE_STAIRS,
                Ingredient.ofItems(UDBlocks.PORCELAIN_TILES))
                .criterion(hasItem(UDBlocks.PORCELAIN_TILES), conditionsFromItem(UDBlocks.PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_TILE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILE_SLAB,
                Ingredient.ofItems(UDBlocks.PORCELAIN_TILES))
                .criterion(hasItem(UDBlocks.PORCELAIN_TILES), conditionsFromItem(UDBlocks.PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_TILE_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILES, UDBlocks.PORCELAIN_BRICKS, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILE_STAIRS, UDBlocks.PORCELAIN_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILE_SLAB, UDBlocks.PORCELAIN_TILES, 2);

        createTwoByTwoRecipe(UDBlocks.DARK_PORCELAIN_BLOCK, 1,
                Ingredient.ofItems(UDItems.DARK_PORCELAIN))
                .criterion(hasItem(UDItems.DARK_PORCELAIN), conditionsFromItem(UDItems.DARK_PORCELAIN))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_BLOCK)));

        createStairsRecipe(UDBlocks.DARK_PORCELAIN_TILE_STAIRS,
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_TILES))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_TILES), conditionsFromItem(UDBlocks.DARK_PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_TILE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILE_SLAB,
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_TILES))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_TILES), conditionsFromItem(UDBlocks.DARK_PORCELAIN_TILES))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_TILE_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILES, UDBlocks.DARK_PORCELAIN_BRICKS, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILE_STAIRS, UDBlocks.DARK_PORCELAIN_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILE_SLAB, UDBlocks.DARK_PORCELAIN_TILES, 2);

        createTwoByTwoRecipe(UDBlocks.PORCELAIN_BRICKS, 4,
                Ingredient.ofItems(UDBlocks.PORCELAIN_BLOCK))
                .criterion(hasItem(UDBlocks.PORCELAIN_BLOCK), conditionsFromItem(UDBlocks.PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_BRICKS)));

        createStairsRecipe(UDBlocks.PORCELAIN_BRICK_STAIRS,
                Ingredient.ofItems(UDBlocks.PORCELAIN_BRICKS))
                .criterion(hasItem(UDBlocks.PORCELAIN_BRICKS), conditionsFromItem(UDBlocks.PORCELAIN_BRICKS))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_BRICK_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICK_SLAB,
                Ingredient.ofItems(UDBlocks.PORCELAIN_BRICKS))
                .criterion(hasItem(UDBlocks.PORCELAIN_BRICKS), conditionsFromItem(UDBlocks.PORCELAIN_BRICKS))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_BRICK_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICKS, UDBlocks.PORCELAIN_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICK_STAIRS, UDBlocks.PORCELAIN_BRICKS, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICK_SLAB, UDBlocks.PORCELAIN_BRICKS, 2);

        createTwoByTwoRecipe(UDBlocks.DARK_PORCELAIN_BRICKS, 4,
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BLOCK))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BLOCK), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BLOCK))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_BRICKS)));

        createStairsRecipe(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS,
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BRICKS))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BRICKS), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BRICKS))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICK_SLAB,
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BRICKS))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BRICKS), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BRICKS))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_BRICK_SLAB)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICKS, UDBlocks.DARK_PORCELAIN_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICK_STAIRS, UDBlocks.DARK_PORCELAIN_BRICKS, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICK_SLAB, UDBlocks.DARK_PORCELAIN_BRICKS, 2);

        createDoorRecipe(UDBlocks.STAINLESS_STEEL_DOOR, Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT));
        createTrapdoorRecipe(UDBlocks.STAINLESS_STEEL_DOOR, Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT));
        offerStainedGlassPaneRecipe(exporter, UDBlocks.STAINLESS_STEEL_BARS, UDItems.STAINLESS_STEEL_INGOT);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_LANTERN, 1)
                .input('#', UDItems.STAINLESS_STEEL_NUGGET).input('@', Items.TORCH)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_NUGGET), conditionsFromItem(UDItems.STAINLESS_STEEL_NUGGET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.STAINLESS_STEEL_LANTERN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_SOUL_LANTERN, 1)
                .input('#', UDItems.STAINLESS_STEEL_NUGGET).input('@', Items.SOUL_TORCH)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_NUGGET), conditionsFromItem(UDItems.STAINLESS_STEEL_NUGGET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN)));
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

    public static ShapelessRecipeJsonBuilder createFromBasePictureFrameRecipe(ItemConvertible output, Item picture, DyeColor color) {
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

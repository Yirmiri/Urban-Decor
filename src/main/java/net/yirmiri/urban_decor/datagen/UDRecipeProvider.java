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
import net.minecraft.registry.tag.ItemTags;
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, UDItems.PORCELAIN.get(), 8)
                .input('#', Items.CLAY_BALL).input('@', Items.FLINT)
                .pattern("@#")
                .pattern("##")
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.PORCELAIN.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, UDItems.STAINLESS_STEEL_INGOT.get(), 2)
                .input('#', Items.COAL).input('@', Items.IRON_INGOT).input('$', UDBlocks.CHROMITE.get())
                .pattern("#$")
                .pattern("@$")
                .criterion(hasItem(UDBlocks.CHROMITE.get()), conditionsFromItem(UDBlocks.CHROMITE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.STAINLESS_STEEL_INGOT.get()) + "_from_chromite"));

        createStairsRecipe(UDBlocks.CHROMITE_STAIRS.get(),
                Ingredient.ofItems(UDBlocks.CHROMITE.get()))
                .criterion(hasItem(UDBlocks.CHROMITE.get()), conditionsFromItem(UDBlocks.CHROMITE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHROMITE_STAIRS.get())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_SLAB.get(),
                Ingredient.ofItems(UDBlocks.CHROMITE.get()))
                .criterion(hasItem(UDBlocks.CHROMITE.get()), conditionsFromItem(UDBlocks.CHROMITE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHROMITE_SLAB.get())));

        getWallRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_WALL.get(),
                Ingredient.ofItems(UDBlocks.CHROMITE.get()))
                .criterion(hasItem(UDBlocks.CHROMITE.get()), conditionsFromItem(UDBlocks.CHROMITE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHROMITE_WALL.get())));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_STAIRS.get(), UDBlocks.CHROMITE.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_SLAB.get(), UDBlocks.CHROMITE.get(), 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_WALL.get(), UDBlocks.CHROMITE.get(), 1);

        createFourForFourWendysMealRecipe(UDBlocks.POLISHED_CHROMITE.get(),
                Ingredient.ofItems(UDBlocks.CHROMITE.get()))
                .criterion(hasItem(UDBlocks.CHROMITE.get()), conditionsFromItem(UDBlocks.CHROMITE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.POLISHED_CHROMITE.get())));

        createStairsRecipe(UDBlocks.POLISHED_CHROMITE_STAIRS.get(),
                Ingredient.ofItems(UDBlocks.POLISHED_CHROMITE.get()))
                .criterion(hasItem(UDBlocks.POLISHED_CHROMITE.get()), conditionsFromItem(UDBlocks.POLISHED_CHROMITE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.POLISHED_CHROMITE_STAIRS.get())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.POLISHED_CHROMITE_SLAB.get(),
                Ingredient.ofItems(UDBlocks.POLISHED_CHROMITE.get()))
                .criterion(hasItem(UDBlocks.POLISHED_CHROMITE.get()), conditionsFromItem(UDBlocks.POLISHED_CHROMITE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.POLISHED_CHROMITE_SLAB.get())));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.POLISHED_CHROMITE_STAIRS.get(), UDBlocks.POLISHED_CHROMITE.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.POLISHED_CHROMITE_SLAB.get(), UDBlocks.POLISHED_CHROMITE.get(), 2);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILES.get(), 1)
                .input('#', UDItems.PORCELAIN.get()).input('@', UDItems.DARK_PORCELAIN.get())
                .pattern("@#")
                .pattern("#@")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILES.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILES.get(), 4)
                .input('#', UDBlocks.PORCELAIN_TILES.get()).input('@', UDBlocks.DARK_PORCELAIN_TILES.get())
                .pattern("@#")
                .pattern("#@")
                .criterion(hasItem(UDBlocks.PORCELAIN_TILES.get()), conditionsFromItem(UDBlocks.PORCELAIN_TILES.get()))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_TILES.get()), conditionsFromItem(UDBlocks.DARK_PORCELAIN_TILES.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILES.get()) + "_from_blocks"));

        createStairsRecipe(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get(),
                Ingredient.ofItems(UDBlocks.CHECKERED_PORCELAIN_TILES.get()))
                .criterion(hasItem(UDBlocks.CHECKERED_PORCELAIN_TILES.get()), conditionsFromItem(UDBlocks.CHECKERED_PORCELAIN_TILES.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get(),
                Ingredient.ofItems(UDBlocks.CHECKERED_PORCELAIN_TILES.get()))
                .criterion(hasItem(UDBlocks.CHECKERED_PORCELAIN_TILES.get()), conditionsFromItem(UDBlocks.CHECKERED_PORCELAIN_TILES.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get())));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get(), UDBlocks.CHECKERED_PORCELAIN_TILES.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get(), UDBlocks.CHECKERED_PORCELAIN_TILES.get(), 2);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, UDItems.STAINLESS_STEEL_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, UDBlocks.STAINLESS_STEEL_BLOCK.get());

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, UDItems.STEEL_PIPE.get(), 2)
                .input('#', UDItems.STAINLESS_STEEL_INGOT.get()).input('@', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("@")
                .pattern("#")
                .pattern("@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.STEEL_PIPE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, UDItems.DARK_PORCELAIN.get(), 8)
                .input('#', UDItems.PORCELAIN.get()).input('@', UDBlocks.CHROMITE.get())
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDBlocks.CHROMITE.get()), conditionsFromItem(UDBlocks.CHROMITE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.DARK_PORCELAIN.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, UDItems.PORCELAIN.get(), 8)
                .input('#', Items.CLAY_BALL).input('@', Items.QUARTZ)
                .pattern("@#")
                .pattern("#@")
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.PORCELAIN.get()) + "_from_quartz"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TOILET.get(), 1)
                .input('#', UDItems.PORCELAIN.get()).input('@', UDItems.STEEL_PIPE.get())
                .pattern("#  ")
                .pattern("###")
                .pattern("@@ ")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TOILET.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_TOILET.get(), 1)
                .input('#', UDItems.DARK_PORCELAIN.get()).input('@', UDItems.STEEL_PIPE.get())
                .pattern("#  ")
                .pattern("###")
                .pattern("@@ ")
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_TOILET.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.FAUCET.get(), 1)
                .input('#', UDItems.STEEL_PIPE.get())
                .pattern("##")
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.FAUCET.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.SINK.get(), 1)
                .input('#', UDItems.PORCELAIN.get()).input('@', UDItems.STEEL_PIPE.get()).input('%', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern(" @ ")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.SINK.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_SINK.get(), 1)
                .input('#', UDItems.DARK_PORCELAIN.get()).input('@', UDItems.STEEL_PIPE.get()).input('%', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern(" @ ")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_SINK.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.WASHING_MACHINE.get(), 1)
                .input('#', UDItems.PORCELAIN.get()).input('@', UDItems.STEEL_PIPE.get()).input('%', UDItems.STAINLESS_STEEL_INGOT.get()).input('&', Blocks.GLASS)
                .pattern("#&#")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.WASHING_MACHINE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_WASHING_MACHINE.get(), 1)
                .input('#', UDItems.DARK_PORCELAIN.get()).input('@', UDItems.STEEL_PIPE.get()).input('%', UDItems.STAINLESS_STEEL_INGOT.get()).input('&', Blocks.GLASS)
                .pattern("#&#")
                .pattern("#%#")
                .pattern("#@#")
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_WASHING_MACHINE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DRYER.get(), 1)
                .input('#', UDItems.PORCELAIN.get()).input('@', UDItems.STEEL_PIPE.get()).input('%', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("###")
                .pattern("% #")
                .pattern("#@#")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DRYER.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_DRYER.get(), 1)
                .input('#', UDItems.DARK_PORCELAIN.get()).input('@', UDItems.STEEL_PIPE.get()).input('%', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("###")
                .pattern("% #")
                .pattern("#@#")
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_DRYER.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.OVEN.get(), 1)
                .input('#', UDItems.PORCELAIN.get()).input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('%', Items.REDSTONE).input('&', Items.SMOKER)
                .pattern("@@@")
                .pattern("#&#")
                .pattern("#%#")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.OVEN.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_OVEN.get(), 1)
                .input('#', UDItems.DARK_PORCELAIN.get()).input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('%', Items.REDSTONE).input('&', Items.SMOKER)
                .pattern("@@@")
                .pattern("#&#")
                .pattern("#%#")
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_OVEN.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.FRIDGE.get(), 1)
                .input('#', UDItems.PORCELAIN.get()).input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('%', Items.PACKED_ICE)
                .pattern("@@@")
                .pattern("# #")
                .pattern("#%#")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.FRIDGE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_FRIDGE.get(), 1)
                .input('#', UDItems.DARK_PORCELAIN.get()).input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('%', Items.PACKED_ICE)
                .pattern("@@@")
                .pattern("# #")
                .pattern("#%#")
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_FRIDGE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.FREEZER.get(), 1)
                .input('#', UDItems.PORCELAIN.get()).input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('%', Items.PACKED_ICE)
                .pattern("##@")
                .pattern("%%@")
                .pattern("##@")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.FREEZER.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_FREEZER.get(), 1)
                .input('#', UDItems.DARK_PORCELAIN.get()).input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('%', Items.PACKED_ICE)
                .pattern("##@")
                .pattern("%%@")
                .pattern("##@")
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_FREEZER.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDItems.TOOLBOX.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("@@@")
                .pattern("@ @")
                .pattern("@@@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.TOOLBOX.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.STOVE.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('#', Items.MAGMA_BLOCK)
                .pattern("@#@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.STOVE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TOASTER.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('#', Items.MAGMA_BLOCK).input('!', Items.REDSTONE).input('%', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("%!%")
                .pattern("@#@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TOASTER.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDItems.MICROWAVE.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('!', Items.REDSTONE)
                .pattern("@!@")
                .pattern("! !")
                .pattern("@!@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.MICROWAVE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TRASH_CAN.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('#', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("#@#")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TRASH_CAN.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DESK_FAN.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('!', Items.REDSTONE).input('#', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("#!#")
                .pattern(" # ")
                .pattern("#@#")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DESK_FAN.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TURBINE.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('!', Items.REDSTONE).input('#', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("#@#")
                .pattern(" # ")
                .pattern("#!#")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TURBINE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.AIR_CONDITIONER.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('#', UDItems.STEEL_PIPE.get()).input('^', Items.PACKED_ICE)
                .pattern("@ @")
                .pattern("###")
                .pattern("@^@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.AIR_CONDITIONER.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.RADIATOR.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('#', UDItems.STEEL_PIPE.get()).input('^', Items.MAGMA_BLOCK)
                .pattern(" # ")
                .pattern("###")
                .pattern("@^@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.RADIATOR.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.SHOWER.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('#', UDItems.STEEL_PIPE.get())
                .pattern("@#")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .criterion(hasItem(UDItems.STEEL_PIPE.get()), conditionsFromItem(UDItems.STEEL_PIPE.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.SHOWER.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TOWEL_BAR.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_NUGGET.get()).input('#', UDItems.STEEL_PIPE.get())
                .pattern("@#@")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TOWEL_BAR.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get(), 2)
                .input('@', Blocks.WHITE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.WHITE_CARPET), conditionsFromItem(Blocks.WHITE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get(), 2)
                .input('@', Blocks.LIGHT_GRAY_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.LIGHT_GRAY_CARPET), conditionsFromItem(Blocks.LIGHT_GRAY_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get(), 2)
                .input('@', Blocks.GRAY_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.GRAY_CARPET), conditionsFromItem(Blocks.GRAY_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get(), 2)
                .input('@', Blocks.BLACK_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.BLACK_CARPET), conditionsFromItem(Blocks.BLACK_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.RED.getId()).get(), 2)
                .input('@', Blocks.RED_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.RED_CARPET), conditionsFromItem(Blocks.RED_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.RED.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get(), 2)
                .input('@', Blocks.ORANGE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.ORANGE_CARPET), conditionsFromItem(Blocks.ORANGE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get(), 2)
                .input('@', Blocks.YELLOW_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.YELLOW_CARPET), conditionsFromItem(Blocks.YELLOW_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get(), 2)
                .input('@', Blocks.LIME_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.LIME_CARPET), conditionsFromItem(Blocks.LIME_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get(), 2)
                .input('@', Blocks.GREEN_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.GREEN_CARPET), conditionsFromItem(Blocks.GREEN_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get(), 2)
                .input('@', Blocks.CYAN_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.CYAN_CARPET), conditionsFromItem(Blocks.CYAN_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get(), 2)
                .input('@', Blocks.LIGHT_BLUE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.LIGHT_BLUE_CARPET), conditionsFromItem(Blocks.LIGHT_BLUE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get(), 2)
                .input('@', Blocks.BLUE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.BLUE_CARPET), conditionsFromItem(Blocks.BLUE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get(), 2)
                .input('@', Blocks.PURPLE_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.PURPLE_CARPET), conditionsFromItem(Blocks.PURPLE_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get(), 2)
                .input('@', Blocks.MAGENTA_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.MAGENTA_CARPET), conditionsFromItem(Blocks.MAGENTA_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get(), 2)
                .input('@', Blocks.PINK_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.PINK_CARPET), conditionsFromItem(Blocks.PINK_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get(), 2)
                .input('@', Blocks.BROWN_CARPET)
                .pattern("@@")
                .criterion(hasItem(Blocks.BROWN_CARPET), conditionsFromItem(Blocks.BROWN_CARPET))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.RED.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.RED.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.RED.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.RED.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.RED.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()).get(), 4)
                .input('@', UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .criterion(hasItem(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get()), conditionsFromItem(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()).get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.RIGID_GLASS.get(), 3)
                .input('#', UDItems.STAINLESS_STEEL_NUGGET.get()).input('@', Items.GLASS_PANE)
                .pattern("#@#")
                .pattern("#@#")
                .pattern("#@#")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_NUGGET.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_NUGGET.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.RIGID_GLASS.get())));

        for (DyeColor colors : DyeColor.values()) {
            createFromBasePictureFrameRecipe(UDItems.getDyedPictureFrames(colors.getId()).get(), UDItems.PICTURE_FRAME.get(), DyeItem.byColor(colors).getColor())
                    .criterion(hasItem(UDItems.getDyedPictureFrames(colors.getId()).get()), conditionsFromItem(UDItems.getDyedPictureFrames(colors.getId()).get()))
                    .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.getDyedPictureFrames(colors.getId()).get()) + "_from_base"));
        }

        for (DyeColor colors : DyeColor.values()) {
            createPictureFrameRecipe(UDItems.getDyedPictureFrames(colors.getId()).get(), DyeItem.byColor(colors).getColor())
                    .criterion(hasItem(UDItems.getDyedPictureFrames(colors.getId()).get()), conditionsFromItem(UDItems.getDyedPictureFrames(colors.getId()).get()))
                    .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.getDyedPictureFrames(colors.getId()).get())));
        }

        createBasePictureFrameRecipe(UDItems.PICTURE_FRAME.get(), Items.PAPER)
                .criterion(hasItem(UDItems.PICTURE_FRAME.get()), conditionsFromItem(UDItems.PICTURE_FRAME.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.PICTURE_FRAME.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.CUPBOARD.get(), 1)
                .input('#', UDItems.PORCELAIN.get()).input('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CUPBOARD.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_CUPBOARD.get(), 1)
                .input('#', UDItems.DARK_PORCELAIN.get()).input('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_CUPBOARD.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.FILING_CABINET.get(), 1)
                .input('#', UDItems.STAINLESS_STEEL_INGOT.get()).input('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.FILING_CABINET.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.TOILET_PAPER.get(), 1)
                .input('#', Items.STICK).input('@', Items.PAPER)
                .pattern("@@@")
                .pattern("@#@")
                .pattern("@@@")
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.TOILET_PAPER.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDItems.SATELLITE_DISH.get(), 1)
                .input('@', UDItems.STAINLESS_STEEL_INGOT.get()).input('!', Items.AMETHYST_SHARD).input('#', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("# !")
                .pattern(" @ ")
                .pattern("@ #")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.SATELLITE_DISH.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.BATHTUB.get(), 1)
                .input('#', UDItems.PORCELAIN.get()).input('@', UDBlocks.PORCELAIN_BLOCK.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("@@@")
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.BATHTUB.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.DARK_BATHTUB.get(), 1)
                .input('#', UDItems.DARK_PORCELAIN.get()).input('@', UDBlocks.DARK_PORCELAIN_BLOCK.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("@@@")
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_BATHTUB.get())));

        createTwoByTwoRecipe(UDBlocks.PORCELAIN_TILES.get(), 4,
                Ingredient.ofItems(UDBlocks.PORCELAIN_BRICKS.get()))
                .criterion(hasItem(UDBlocks.PORCELAIN_BRICKS.get()), conditionsFromItem(UDBlocks.PORCELAIN_BRICKS.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_TILES.get())));

        createStairsRecipe(UDBlocks.PORCELAIN_STAIRS.get(),
                Ingredient.ofItems(UDBlocks.PORCELAIN_BLOCK.get()))
                .criterion(hasItem(UDBlocks.PORCELAIN_BLOCK.get()), conditionsFromItem(UDBlocks.PORCELAIN_BLOCK.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_STAIRS.get())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_SLAB.get(),
                Ingredient.ofItems(UDBlocks.PORCELAIN_BLOCK.get()))
                .criterion(hasItem(UDBlocks.PORCELAIN_BLOCK.get()), conditionsFromItem(UDBlocks.PORCELAIN_BLOCK.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_SLAB.get())));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_STAIRS.get(), UDBlocks.PORCELAIN_BLOCK.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_SLAB.get(), UDBlocks.PORCELAIN_BLOCK.get(), 2);

        createTwoByTwoRecipe(UDBlocks.DARK_PORCELAIN_TILES.get(), 4,
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BRICKS.get()), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_TILES.get())));

        createStairsRecipe(UDBlocks.DARK_PORCELAIN_STAIRS.get(),
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BLOCK.get()), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_STAIRS.get())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_SLAB.get(),
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BLOCK.get()), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_SLAB.get())));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_STAIRS.get(), UDBlocks.DARK_PORCELAIN_BLOCK.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_SLAB.get(), UDBlocks.DARK_PORCELAIN_BLOCK.get(), 2);

        createTwoByTwoRecipe(UDBlocks.PORCELAIN_BLOCK.get(), 1,
                Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_BLOCK.get())));

        createStairsRecipe(UDBlocks.PORCELAIN_TILE_STAIRS.get(),
                Ingredient.ofItems(UDBlocks.PORCELAIN_TILES.get()))
                .criterion(hasItem(UDBlocks.PORCELAIN_TILES.get()), conditionsFromItem(UDBlocks.PORCELAIN_TILES.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_TILE_STAIRS.get())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILE_SLAB.get(),
                Ingredient.ofItems(UDBlocks.PORCELAIN_TILES.get()))
                .criterion(hasItem(UDBlocks.PORCELAIN_TILES.get()), conditionsFromItem(UDBlocks.PORCELAIN_TILES.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_TILE_SLAB.get())));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILES.get(), UDBlocks.PORCELAIN_BRICKS.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILE_STAIRS.get(), UDBlocks.PORCELAIN_TILES.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILE_SLAB.get(), UDBlocks.PORCELAIN_TILES.get(), 2);

        createTwoByTwoRecipe(UDBlocks.DARK_PORCELAIN_BLOCK.get(), 1,
                Ingredient.ofItems(UDItems.DARK_PORCELAIN.get()))
                .criterion(hasItem(UDItems.DARK_PORCELAIN.get()), conditionsFromItem(UDItems.DARK_PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_BLOCK.get())));

        createStairsRecipe(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get(),
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_TILES.get()))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_TILES.get()), conditionsFromItem(UDBlocks.DARK_PORCELAIN_TILES.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILE_SLAB.get(),
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_TILES.get()))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_TILES.get()), conditionsFromItem(UDBlocks.DARK_PORCELAIN_TILES.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get())));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILES.get(), UDBlocks.DARK_PORCELAIN_BRICKS.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get(), UDBlocks.DARK_PORCELAIN_TILES.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILE_SLAB.get(), UDBlocks.DARK_PORCELAIN_TILES.get(), 2);

        createTwoByTwoRecipe(UDBlocks.PORCELAIN_BRICKS.get(), 4,
                Ingredient.ofItems(UDBlocks.PORCELAIN_BLOCK.get()))
                .criterion(hasItem(UDBlocks.PORCELAIN_BLOCK.get()), conditionsFromItem(UDBlocks.PORCELAIN_BLOCK.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_BRICKS.get())));

        createStairsRecipe(UDBlocks.PORCELAIN_BRICK_STAIRS.get(),
                Ingredient.ofItems(UDBlocks.PORCELAIN_BRICKS.get()))
                .criterion(hasItem(UDBlocks.PORCELAIN_BRICKS.get()), conditionsFromItem(UDBlocks.PORCELAIN_BRICKS.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_BRICK_STAIRS.get())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICK_SLAB.get(),
                Ingredient.ofItems(UDBlocks.PORCELAIN_BRICKS.get()))
                .criterion(hasItem(UDBlocks.PORCELAIN_BRICKS.get()), conditionsFromItem(UDBlocks.PORCELAIN_BRICKS.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.PORCELAIN_BRICK_SLAB.get())));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICKS.get(), UDBlocks.PORCELAIN_BLOCK.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICK_STAIRS.get(), UDBlocks.PORCELAIN_BRICKS.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICK_SLAB.get(), UDBlocks.PORCELAIN_BRICKS.get(), 2);

        createTwoByTwoRecipe(UDBlocks.DARK_PORCELAIN_BRICKS.get(), 4,
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BLOCK.get()), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_BRICKS.get())));

        createStairsRecipe(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get(),
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BRICKS.get()), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get(),
                Ingredient.ofItems(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .criterion(hasItem(UDBlocks.DARK_PORCELAIN_BRICKS.get()), conditionsFromItem(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get())));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICKS.get(), UDBlocks.DARK_PORCELAIN_BLOCK.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get(), UDBlocks.DARK_PORCELAIN_BRICKS.get(), 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get(), UDBlocks.DARK_PORCELAIN_BRICKS.get(), 2);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_LANTERN.get(), 1)
                .input('#', UDItems.STAINLESS_STEEL_NUGGET.get()).input('@', Items.TORCH)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_NUGGET.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_NUGGET.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.STAINLESS_STEEL_LANTERN.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get(), 1)
                .input('#', UDItems.STAINLESS_STEEL_NUGGET.get()).input('@', Items.SOUL_TORCH)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_NUGGET.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_NUGGET.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_DOOR.get(), 3)
                .input('#', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.STAINLESS_STEEL_DOOR.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_TRAPDOOR.get(), 1)
                .input('#', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_BARS.get(), 16)
                .input('#', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.STAINLESS_STEEL_BARS.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, UDBlocks.FLOOR_LAMP.get(), 1)
                .input('#', UDItems.STAINLESS_STEEL_INGOT.get()).input('@', Items.GLOWSTONE)
                .input('!', UDItems.STAINLESS_STEEL_NUGGET.get()).input('%', ItemTags.WOOL)
                .pattern("%@%")
                .pattern(" # ")
                .pattern("!#!")
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.FLOOR_LAMP.get())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, UDItems.STAINLESS_STEEL_INGOT.get(), 1)
                .input(UDItems.STAINLESS_STEEL_NUGGET.get()).input(UDItems.STAINLESS_STEEL_NUGGET.get()).input(UDItems.STAINLESS_STEEL_NUGGET.get())
                .input(UDItems.STAINLESS_STEEL_NUGGET.get()).input(UDItems.STAINLESS_STEEL_NUGGET.get()).input(UDItems.STAINLESS_STEEL_NUGGET.get())
                .input(UDItems.STAINLESS_STEEL_NUGGET.get()).input(UDItems.STAINLESS_STEEL_NUGGET.get()).input(UDItems.STAINLESS_STEEL_NUGGET.get())
                .criterion(hasItem(UDItems.STAINLESS_STEEL_NUGGET.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_NUGGET.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.STAINLESS_STEEL_INGOT.get()) + "_from_nugget"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, UDItems.STAINLESS_STEEL_NUGGET.get(), 1)
                .input(UDItems.STAINLESS_STEEL_INGOT.get())
                .criterion(hasItem(UDItems.STAINLESS_STEEL_INGOT.get()), conditionsFromItem(UDItems.STAINLESS_STEEL_INGOT.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDItems.STAINLESS_STEEL_NUGGET.get()) + "_from_ingot"));

        createPianoRecipe(UDBlocks.OAK_PIANO.get(), Ingredient.ofItems(Items.OAK_PLANKS),
                Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.OAK_PIANO.get())));

        createPianoRecipe(UDBlocks.SPRUCE_PIANO.get(), Ingredient.ofItems(Items.SPRUCE_PLANKS),
                Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.SPRUCE_PIANO.get())));

        createPianoRecipe(UDBlocks.BIRCH_PIANO.get(), Ingredient.ofItems(Items.BIRCH_PLANKS),
                Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.BIRCH_PIANO.get())));

        createPianoRecipe(UDBlocks.JUNGLE_PIANO.get(), Ingredient.ofItems(Items.JUNGLE_PLANKS),
                Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.JUNGLE_PIANO.get())));

        createPianoRecipe(UDBlocks.ACACIA_PIANO.get(), Ingredient.ofItems(Items.ACACIA_PLANKS),
                Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.ACACIA_PIANO.get())));

        createPianoRecipe(UDBlocks.DARK_OAK_PIANO.get(), Ingredient.ofItems(Items.DARK_OAK_PLANKS),
                Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.DARK_OAK_PIANO.get())));

        createPianoRecipe(UDBlocks.MANGROVE_PIANO.get(), Ingredient.ofItems(Items.MANGROVE_PLANKS),
                Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.MANGROVE_PIANO.get())));

        createPianoRecipe(UDBlocks.CHERRY_PIANO.get(), Ingredient.ofItems(Items.CHERRY_PLANKS),
                Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CHERRY_PIANO.get())));

        createPianoRecipe(UDBlocks.BAMBOO_PIANO.get(), Ingredient.ofItems(Items.BAMBOO_PLANKS),
                Ingredient.ofItems(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.BAMBOO_PIANO.get())));

        createPianoRecipe(UDBlocks.CRIMSON_PIANO.get(), Ingredient.ofItems(Items.CRIMSON_PLANKS),
                Ingredient.ofItems(Items.GOLD_INGOT), Ingredient.ofItems(UDItems.PORCELAIN.get()))
             .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.CRIMSON_PIANO.get())));

        createPianoRecipe(UDBlocks.WARPED_PIANO.get(), Ingredient.ofItems(Items.WARPED_PLANKS),
                Ingredient.ofItems(Items.GOLD_INGOT), Ingredient.ofItems(UDItems.PORCELAIN.get()))
                .criterion(hasItem(UDItems.PORCELAIN.get()), conditionsFromItem(UDItems.PORCELAIN.get()))
                .offerTo(exporter, Identifier.of(UrbanDecor.MOD_ID, getRecipeName(UDBlocks.WARPED_PIANO.get())));
    }

    public static ShapelessRecipeJsonBuilder createFromBasePictureFrameRecipe(ItemConvertible output, Item picture, DyeColor color) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
                .input(picture).input(DyeItem.byColor(color));
    }

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

    public static ShapedRecipeJsonBuilder createPianoRecipe(ItemConvertible output, Ingredient planks, Ingredient ingot, Ingredient porcelain) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
                .input('#', planks).input('@', ingot).input('!', porcelain)
                .pattern("#!#")
                .pattern("#@#");
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

    public static ShapedRecipeJsonBuilder createTowelBlockRecipe(ItemConvertible output, Block input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 4)
                .input('#', input)
                .pattern("##")
                .pattern("##");
    }
}
package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDItems;

import java.util.function.Consumer;

public class UDRecipeProvider extends FabricRecipeProvider {
    public UDRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UDItems.PORCELAIN.get(), 8)
                .define('#', Items.CLAY_BALL).define('@', Items.FLINT)
                .pattern("@#")
                .pattern("##")
                .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.PORCELAIN.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UDItems.STAINLESS_STEEL_INGOT.get(), 2)
                .define('#', Items.COAL).define('@', Items.IRON_INGOT).define('$', UDBlocks.CHROMITE.get())
                .pattern("#$")
                .pattern("@$")
                .unlockedBy(getHasName(UDBlocks.CHROMITE.get()), has(UDBlocks.CHROMITE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.STAINLESS_STEEL_INGOT.get()) + "_from_chromite"));

        stairBuilder(UDBlocks.CHROMITE_STAIRS.get(),
                Ingredient.of(UDBlocks.CHROMITE.get()))
                .unlockedBy(getHasName(UDBlocks.CHROMITE.get()), has(UDBlocks.CHROMITE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.CHROMITE_STAIRS.get())));

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_SLAB.get(),
                Ingredient.of(UDBlocks.CHROMITE.get()))
                .unlockedBy(getHasName(UDBlocks.CHROMITE.get()), has(UDBlocks.CHROMITE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.CHROMITE_SLAB.get())));

        wallBuilder(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_WALL.get(),
                Ingredient.of(UDBlocks.CHROMITE.get()))
                .unlockedBy(getHasName(UDBlocks.CHROMITE.get()), has(UDBlocks.CHROMITE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.CHROMITE_WALL.get())));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_STAIRS.get(), UDBlocks.CHROMITE.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_SLAB.get(), UDBlocks.CHROMITE.get(), 2);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHROMITE_WALL.get(), UDBlocks.CHROMITE.get(), 1);

        createFourForFourWendysMealRecipe(UDBlocks.POLISHED_CHROMITE.get(),
                Ingredient.of(UDBlocks.CHROMITE.get()))
                .unlockedBy(getHasName(UDBlocks.CHROMITE.get()), has(UDBlocks.CHROMITE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.POLISHED_CHROMITE.get())));

        stairBuilder(UDBlocks.POLISHED_CHROMITE_STAIRS.get(),
                Ingredient.of(UDBlocks.POLISHED_CHROMITE.get()))
                .unlockedBy(getHasName(UDBlocks.POLISHED_CHROMITE.get()), has(UDBlocks.POLISHED_CHROMITE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.POLISHED_CHROMITE_STAIRS.get())));

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, UDBlocks.POLISHED_CHROMITE_SLAB.get(),
                Ingredient.of(UDBlocks.POLISHED_CHROMITE.get()))
                .unlockedBy(getHasName(UDBlocks.POLISHED_CHROMITE.get()), has(UDBlocks.POLISHED_CHROMITE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.POLISHED_CHROMITE_SLAB.get())));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.POLISHED_CHROMITE_STAIRS.get(), UDBlocks.POLISHED_CHROMITE.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.POLISHED_CHROMITE_SLAB.get(), UDBlocks.POLISHED_CHROMITE.get(), 2);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILES.get(), 1)
                .define('#', UDItems.PORCELAIN.get()).define('@', UDItems.DARK_PORCELAIN.get())
                .pattern("@#")
                .pattern("#@")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILES.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILES.get(), 4)
                .define('#', UDBlocks.PORCELAIN_TILES.get()).define('@', UDBlocks.DARK_PORCELAIN_TILES.get())
                .pattern("@#")
                .pattern("#@")
                .unlockedBy(getHasName(UDBlocks.PORCELAIN_TILES.get()), has(UDBlocks.PORCELAIN_TILES.get()))
                .unlockedBy(getHasName(UDBlocks.DARK_PORCELAIN_TILES.get()), has(UDBlocks.DARK_PORCELAIN_TILES.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILES.get()) + "_from_blocks"));

        stairBuilder(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get(),
                Ingredient.of(UDBlocks.CHECKERED_PORCELAIN_TILES.get()))
                .unlockedBy(getHasName(UDBlocks.CHECKERED_PORCELAIN_TILES.get()), has(UDBlocks.CHECKERED_PORCELAIN_TILES.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get())));

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get(),
                Ingredient.of(UDBlocks.CHECKERED_PORCELAIN_TILES.get()))
                .unlockedBy(getHasName(UDBlocks.CHECKERED_PORCELAIN_TILES.get()), has(UDBlocks.CHECKERED_PORCELAIN_TILES.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get())));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get(), UDBlocks.CHECKERED_PORCELAIN_TILES.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get(), UDBlocks.CHECKERED_PORCELAIN_TILES.get(), 2);

        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, UDItems.STAINLESS_STEEL_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, UDBlocks.STAINLESS_STEEL_BLOCK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, UDItems.STEEL_PIPE.get(), 2)
                .define('#', UDItems.STAINLESS_STEEL_INGOT.get()).define('@', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("@")
                .pattern("#")
                .pattern("@")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.STEEL_PIPE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UDItems.DARK_PORCELAIN.get(), 8)
                .define('#', UDItems.PORCELAIN.get()).define('@', UDBlocks.CHROMITE.get())
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDBlocks.CHROMITE.get()), has(UDBlocks.CHROMITE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.DARK_PORCELAIN.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UDItems.PORCELAIN.get(), 8)
                .define('#', Items.CLAY_BALL).define('@', Items.QUARTZ)
                .pattern("@#")
                .pattern("#@")
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.PORCELAIN.get()) + "_from_quartz"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.TOILET.get(), 1)
                .define('#', UDItems.PORCELAIN.get()).define('@', UDItems.STEEL_PIPE.get())
                .pattern("#  ")
                .pattern("###")
                .pattern("@@ ")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.TOILET.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DARK_TOILET.get(), 1)
                .define('#', UDItems.DARK_PORCELAIN.get()).define('@', UDItems.STEEL_PIPE.get())
                .pattern("#  ")
                .pattern("###")
                .pattern("@@ ")
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_TOILET.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.FAUCET.get(), 1)
                .define('#', UDItems.STEEL_PIPE.get())
                .pattern("##")
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.FAUCET.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.SINK.get(), 1)
                .define('#', UDItems.PORCELAIN.get()).define('@', UDItems.STEEL_PIPE.get()).define('%', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern(" @ ")
                .pattern("#%#")
                .pattern("#@#")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.SINK.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DARK_SINK.get(), 1)
                .define('#', UDItems.DARK_PORCELAIN.get()).define('@', UDItems.STEEL_PIPE.get()).define('%', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern(" @ ")
                .pattern("#%#")
                .pattern("#@#")
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_SINK.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.WASHING_MACHINE.get(), 1)
                .define('#', UDItems.PORCELAIN.get()).define('@', UDItems.STEEL_PIPE.get()).define('%', UDItems.STAINLESS_STEEL_INGOT.get()).define('&', Blocks.GLASS)
                .pattern("#&#")
                .pattern("#%#")
                .pattern("#@#")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.WASHING_MACHINE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DARK_WASHING_MACHINE.get(), 1)
                .define('#', UDItems.DARK_PORCELAIN.get()).define('@', UDItems.STEEL_PIPE.get()).define('%', UDItems.STAINLESS_STEEL_INGOT.get()).define('&', Blocks.GLASS)
                .pattern("#&#")
                .pattern("#%#")
                .pattern("#@#")
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_WASHING_MACHINE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DRYER.get(), 1)
                .define('#', UDItems.PORCELAIN.get()).define('@', UDItems.STEEL_PIPE.get()).define('%', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("###")
                .pattern("% #")
                .pattern("#@#")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DRYER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DARK_DRYER.get(), 1)
                .define('#', UDItems.DARK_PORCELAIN.get()).define('@', UDItems.STEEL_PIPE.get()).define('%', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("###")
                .pattern("% #")
                .pattern("#@#")
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_DRYER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.OVEN.get(), 1)
                .define('#', UDItems.PORCELAIN.get()).define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('%', Items.REDSTONE).define('&', Items.SMOKER)
                .pattern("@@@")
                .pattern("#&#")
                .pattern("#%#")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.OVEN.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DARK_OVEN.get(), 1)
                .define('#', UDItems.DARK_PORCELAIN.get()).define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('%', Items.REDSTONE).define('&', Items.SMOKER)
                .pattern("@@@")
                .pattern("#&#")
                .pattern("#%#")
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_OVEN.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.FRIDGE.get(), 1)
                .define('#', UDItems.PORCELAIN.get()).define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('%', Items.PACKED_ICE)
                .pattern("@@@")
                .pattern("# #")
                .pattern("#%#")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.FRIDGE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DARK_FRIDGE.get(), 1)
                .define('#', UDItems.DARK_PORCELAIN.get()).define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('%', Items.PACKED_ICE)
                .pattern("@@@")
                .pattern("# #")
                .pattern("#%#")
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_FRIDGE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.FREEZER.get(), 1)
                .define('#', UDItems.PORCELAIN.get()).define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('%', Items.PACKED_ICE)
                .pattern("##@")
                .pattern("%%@")
                .pattern("##@")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.FREEZER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DARK_FREEZER.get(), 1)
                .define('#', UDItems.DARK_PORCELAIN.get()).define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('%', Items.PACKED_ICE)
                .pattern("##@")
                .pattern("%%@")
                .pattern("##@")
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_FREEZER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDItems.TOOLBOX.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("@@@")
                .pattern("@ @")
                .pattern("@@@")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.TOOLBOX.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.STOVE.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('#', Items.MAGMA_BLOCK)
                .pattern("@#@")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.STOVE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.TOASTER.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('#', Items.MAGMA_BLOCK).define('!', Items.REDSTONE).define('%', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("%!%")
                .pattern("@#@")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.TOASTER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDItems.MICROWAVE.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('!', Items.REDSTONE)
                .pattern("@!@")
                .pattern("! !")
                .pattern("@!@")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.MICROWAVE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.TRASH_CAN.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('#', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("#@#")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.TRASH_CAN.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DESK_FAN.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('!', Items.REDSTONE).define('#', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("#!#")
                .pattern(" # ")
                .pattern("#@#")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DESK_FAN.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.TURBINE.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('!', Items.REDSTONE).define('#', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("#@#")
                .pattern(" # ")
                .pattern("#!#")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.TURBINE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.AIR_CONDITIONER.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('#', UDItems.STEEL_PIPE.get()).define('^', Items.PACKED_ICE)
                .pattern("@ @")
                .pattern("###")
                .pattern("@^@")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.AIR_CONDITIONER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.RADIATOR.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('#', UDItems.STEEL_PIPE.get()).define('^', Items.MAGMA_BLOCK)
                .pattern(" # ")
                .pattern("###")
                .pattern("@^@")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.RADIATOR.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.SHOWER.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('#', UDItems.STEEL_PIPE.get())
                .pattern("@#")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .unlockedBy(getHasName(UDItems.STEEL_PIPE.get()), has(UDItems.STEEL_PIPE.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.SHOWER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.TOWEL_BAR.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_NUGGET.get()).define('#', UDItems.STEEL_PIPE.get())
                .pattern("@#@")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.TOWEL_BAR.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get(), 2)
                .define('@', Blocks.WHITE_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.WHITE_CARPET), has(Blocks.WHITE_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get(), 2)
                .define('@', Blocks.LIGHT_GRAY_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.LIGHT_GRAY_CARPET), has(Blocks.LIGHT_GRAY_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get(), 2)
                .define('@', Blocks.GRAY_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.GRAY_CARPET), has(Blocks.GRAY_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get(), 2)
                .define('@', Blocks.BLACK_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.BLACK_CARPET), has(Blocks.BLACK_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.RED.getId()).get(), 2)
                .define('@', Blocks.RED_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.RED_CARPET), has(Blocks.RED_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.RED.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get(), 2)
                .define('@', Blocks.ORANGE_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.ORANGE_CARPET), has(Blocks.ORANGE_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get(), 2)
                .define('@', Blocks.YELLOW_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.YELLOW_CARPET), has(Blocks.YELLOW_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get(), 2)
                .define('@', Blocks.LIME_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.LIME_CARPET), has(Blocks.LIME_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get(), 2)
                .define('@', Blocks.GREEN_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.GREEN_CARPET), has(Blocks.GREEN_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get(), 2)
                .define('@', Blocks.CYAN_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.CYAN_CARPET), has(Blocks.CYAN_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get(), 2)
                .define('@', Blocks.LIGHT_BLUE_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.LIGHT_BLUE_CARPET), has(Blocks.LIGHT_BLUE_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get(), 2)
                .define('@', Blocks.BLUE_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.BLUE_CARPET), has(Blocks.BLUE_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get(), 2)
                .define('@', Blocks.PURPLE_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.PURPLE_CARPET), has(Blocks.PURPLE_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get(), 2)
                .define('@', Blocks.MAGENTA_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.MAGENTA_CARPET), has(Blocks.MAGENTA_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get(), 2)
                .define('@', Blocks.PINK_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.PINK_CARPET), has(Blocks.PINK_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get(), 2)
                .define('@', Blocks.BROWN_CARPET)
                .pattern("@@")
                .unlockedBy(getHasName(Blocks.BROWN_CARPET), has(Blocks.BROWN_CARPET))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.RED.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.RED.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.RED.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.RED.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.RED.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()).get(), 4)
                .define('@', UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get())
                .pattern("@@")
                .pattern("@@")
                .unlockedBy(getHasName(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get()), has(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()).get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.RIGID_GLASS.get(), 3)
                .define('#', UDItems.STAINLESS_STEEL_NUGGET.get()).define('@', Items.GLASS_PANE)
                .pattern("#@#")
                .pattern("#@#")
                .pattern("#@#")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_NUGGET.get()), has(UDItems.STAINLESS_STEEL_NUGGET.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.RIGID_GLASS.get())));

        for (DyeColor colors : DyeColor.values()) {
            createFromBasePictureFrameRecipe(UDItems.getDyedPictureFrames(colors.getId()).get(), UDItems.PICTURE_FRAME.get(), DyeItem.byColor(colors).getDyeColor())
                    .unlockedBy(getHasName(UDItems.getDyedPictureFrames(colors.getId()).get()), has(UDItems.getDyedPictureFrames(colors.getId()).get()))
                    .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.getDyedPictureFrames(colors.getId()).get()) + "_from_base"));
        }

        for (DyeColor colors : DyeColor.values()) {
            createPictureFrameRecipe(UDItems.getDyedPictureFrames(colors.getId()).get(), DyeItem.byColor(colors).getDyeColor())
                    .unlockedBy(getHasName(UDItems.getDyedPictureFrames(colors.getId()).get()), has(UDItems.getDyedPictureFrames(colors.getId()).get()))
                    .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.getDyedPictureFrames(colors.getId()).get())));
        }

        createBasePictureFrameRecipe(UDItems.PICTURE_FRAME.get(), Items.PAPER)
                .unlockedBy(getHasName(UDItems.PICTURE_FRAME.get()), has(UDItems.PICTURE_FRAME.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.PICTURE_FRAME.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.CUPBOARD.get(), 1)
                .define('#', UDItems.PORCELAIN.get()).define('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.CUPBOARD.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DARK_CUPBOARD.get(), 1)
                .define('#', UDItems.DARK_PORCELAIN.get()).define('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_CUPBOARD.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.FILING_CABINET.get(), 1)
                .define('#', UDItems.STAINLESS_STEEL_INGOT.get()).define('@', Blocks.CHEST)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.FILING_CABINET.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.TOILET_PAPER.get(), 1)
                .define('#', Items.STICK).define('@', Items.PAPER)
                .pattern("@@@")
                .pattern("@#@")
                .pattern("@@@")
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.TOILET_PAPER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDItems.SATELLITE_DISH.get(), 1)
                .define('@', UDItems.STAINLESS_STEEL_INGOT.get()).define('!', Items.AMETHYST_SHARD).define('#', UDItems.STAINLESS_STEEL_NUGGET.get())
                .pattern("# !")
                .pattern(" @ ")
                .pattern("@ #")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.SATELLITE_DISH.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.BATHTUB.get(), 1)
                .define('#', UDItems.PORCELAIN.get()).define('@', UDBlocks.PORCELAIN_BLOCK.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("@@@")
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.BATHTUB.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.DARK_BATHTUB.get(), 1)
                .define('#', UDItems.DARK_PORCELAIN.get()).define('@', UDBlocks.DARK_PORCELAIN_BLOCK.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("@@@")
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_BATHTUB.get())));

        createTwoByTwoRecipe(UDBlocks.PORCELAIN_TILES.get(), 4,
                Ingredient.of(UDBlocks.PORCELAIN_BRICKS.get()))
                .unlockedBy(getHasName(UDBlocks.PORCELAIN_BRICKS.get()), has(UDBlocks.PORCELAIN_BRICKS.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.PORCELAIN_TILES.get())));

        stairBuilder(UDBlocks.PORCELAIN_STAIRS.get(),
                Ingredient.of(UDBlocks.PORCELAIN_BLOCK.get()))
                .unlockedBy(getHasName(UDBlocks.PORCELAIN_BLOCK.get()), has(UDBlocks.PORCELAIN_BLOCK.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.PORCELAIN_STAIRS.get())));

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_SLAB.get(),
                Ingredient.of(UDBlocks.PORCELAIN_BLOCK.get()))
                .unlockedBy(getHasName(UDBlocks.PORCELAIN_BLOCK.get()), has(UDBlocks.PORCELAIN_BLOCK.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.PORCELAIN_SLAB.get())));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_STAIRS.get(), UDBlocks.PORCELAIN_BLOCK.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_SLAB.get(), UDBlocks.PORCELAIN_BLOCK.get(), 2);

        createTwoByTwoRecipe(UDBlocks.DARK_PORCELAIN_TILES.get(), 4,
                Ingredient.of(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .unlockedBy(getHasName(UDBlocks.DARK_PORCELAIN_BRICKS.get()), has(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_PORCELAIN_TILES.get())));

        stairBuilder(UDBlocks.DARK_PORCELAIN_STAIRS.get(),
                Ingredient.of(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .unlockedBy(getHasName(UDBlocks.DARK_PORCELAIN_BLOCK.get()), has(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_PORCELAIN_STAIRS.get())));

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_SLAB.get(),
                Ingredient.of(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .unlockedBy(getHasName(UDBlocks.DARK_PORCELAIN_BLOCK.get()), has(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_PORCELAIN_SLAB.get())));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_STAIRS.get(), UDBlocks.DARK_PORCELAIN_BLOCK.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_SLAB.get(), UDBlocks.DARK_PORCELAIN_BLOCK.get(), 2);

        createTwoByTwoRecipe(UDBlocks.PORCELAIN_BLOCK.get(), 1,
                Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.PORCELAIN_BLOCK.get())));

        stairBuilder(UDBlocks.PORCELAIN_TILE_STAIRS.get(),
                Ingredient.of(UDBlocks.PORCELAIN_TILES.get()))
                .unlockedBy(getHasName(UDBlocks.PORCELAIN_TILES.get()), has(UDBlocks.PORCELAIN_TILES.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.PORCELAIN_TILE_STAIRS.get())));

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILE_SLAB.get(),
                Ingredient.of(UDBlocks.PORCELAIN_TILES.get()))
                .unlockedBy(getHasName(UDBlocks.PORCELAIN_TILES.get()), has(UDBlocks.PORCELAIN_TILES.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.PORCELAIN_TILE_SLAB.get())));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILES.get(), UDBlocks.PORCELAIN_BRICKS.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILE_STAIRS.get(), UDBlocks.PORCELAIN_TILES.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_TILE_SLAB.get(), UDBlocks.PORCELAIN_TILES.get(), 2);

        createTwoByTwoRecipe(UDBlocks.DARK_PORCELAIN_BLOCK.get(), 1,
                Ingredient.of(UDItems.DARK_PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.DARK_PORCELAIN.get()), has(UDItems.DARK_PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_PORCELAIN_BLOCK.get())));

        stairBuilder(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get(),
                Ingredient.of(UDBlocks.DARK_PORCELAIN_TILES.get()))
                .unlockedBy(getHasName(UDBlocks.DARK_PORCELAIN_TILES.get()), has(UDBlocks.DARK_PORCELAIN_TILES.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get())));

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILE_SLAB.get(),
                Ingredient.of(UDBlocks.DARK_PORCELAIN_TILES.get()))
                .unlockedBy(getHasName(UDBlocks.DARK_PORCELAIN_TILES.get()), has(UDBlocks.DARK_PORCELAIN_TILES.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get())));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILES.get(), UDBlocks.DARK_PORCELAIN_BRICKS.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get(), UDBlocks.DARK_PORCELAIN_TILES.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_TILE_SLAB.get(), UDBlocks.DARK_PORCELAIN_TILES.get(), 2);

        createTwoByTwoRecipe(UDBlocks.PORCELAIN_BRICKS.get(), 4,
                Ingredient.of(UDBlocks.PORCELAIN_BLOCK.get()))
                .unlockedBy(getHasName(UDBlocks.PORCELAIN_BLOCK.get()), has(UDBlocks.PORCELAIN_BLOCK.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.PORCELAIN_BRICKS.get())));

        stairBuilder(UDBlocks.PORCELAIN_BRICK_STAIRS.get(),
                Ingredient.of(UDBlocks.PORCELAIN_BRICKS.get()))
                .unlockedBy(getHasName(UDBlocks.PORCELAIN_BRICKS.get()), has(UDBlocks.PORCELAIN_BRICKS.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.PORCELAIN_BRICK_STAIRS.get())));

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICK_SLAB.get(),
                Ingredient.of(UDBlocks.PORCELAIN_BRICKS.get()))
                .unlockedBy(getHasName(UDBlocks.PORCELAIN_BRICKS.get()), has(UDBlocks.PORCELAIN_BRICKS.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.PORCELAIN_BRICK_SLAB.get())));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICKS.get(), UDBlocks.PORCELAIN_BLOCK.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICK_STAIRS.get(), UDBlocks.PORCELAIN_BRICKS.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.PORCELAIN_BRICK_SLAB.get(), UDBlocks.PORCELAIN_BRICKS.get(), 2);

        createTwoByTwoRecipe(UDBlocks.DARK_PORCELAIN_BRICKS.get(), 4,
                Ingredient.of(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .unlockedBy(getHasName(UDBlocks.DARK_PORCELAIN_BLOCK.get()), has(UDBlocks.DARK_PORCELAIN_BLOCK.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_PORCELAIN_BRICKS.get())));

        stairBuilder(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get(),
                Ingredient.of(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .unlockedBy(getHasName(UDBlocks.DARK_PORCELAIN_BRICKS.get()), has(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get())));

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get(),
                Ingredient.of(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .unlockedBy(getHasName(UDBlocks.DARK_PORCELAIN_BRICKS.get()), has(UDBlocks.DARK_PORCELAIN_BRICKS.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get())));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICKS.get(), UDBlocks.DARK_PORCELAIN_BLOCK.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get(), UDBlocks.DARK_PORCELAIN_BRICKS.get(), 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get(), UDBlocks.DARK_PORCELAIN_BRICKS.get(), 2);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_LANTERN.get(), 1)
                .define('#', UDItems.STAINLESS_STEEL_NUGGET.get()).define('@', Items.TORCH)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_NUGGET.get()), has(UDItems.STAINLESS_STEEL_NUGGET.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.STAINLESS_STEEL_LANTERN.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get(), 1)
                .define('#', UDItems.STAINLESS_STEEL_NUGGET.get()).define('@', Items.SOUL_TORCH)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_NUGGET.get()), has(UDItems.STAINLESS_STEEL_NUGGET.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_DOOR.get(), 3)
                .define('#', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.STAINLESS_STEEL_DOOR.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_TRAPDOOR.get(), 1)
                .define('#', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.STAINLESS_STEEL_BARS.get(), 16)
                .define('#', UDItems.STAINLESS_STEEL_INGOT.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.STAINLESS_STEEL_BARS.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, UDBlocks.FLOOR_LAMP.get(), 1)
                .define('#', UDItems.STAINLESS_STEEL_INGOT.get()).define('@', Items.GLOWSTONE)
                .define('!', UDItems.STAINLESS_STEEL_NUGGET.get()).define('%', ItemTags.WOOL)
                .pattern("%@%")
                .pattern(" # ")
                .pattern("!#!")
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.FLOOR_LAMP.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UDItems.STAINLESS_STEEL_INGOT.get(), 1)
                .requires(UDItems.STAINLESS_STEEL_NUGGET.get()).requires(UDItems.STAINLESS_STEEL_NUGGET.get()).requires(UDItems.STAINLESS_STEEL_NUGGET.get())
                .requires(UDItems.STAINLESS_STEEL_NUGGET.get()).requires(UDItems.STAINLESS_STEEL_NUGGET.get()).requires(UDItems.STAINLESS_STEEL_NUGGET.get())
                .requires(UDItems.STAINLESS_STEEL_NUGGET.get()).requires(UDItems.STAINLESS_STEEL_NUGGET.get()).requires(UDItems.STAINLESS_STEEL_NUGGET.get())
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_NUGGET.get()), has(UDItems.STAINLESS_STEEL_NUGGET.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.STAINLESS_STEEL_INGOT.get()) + "_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UDItems.STAINLESS_STEEL_NUGGET.get(), 1)
                .requires(UDItems.STAINLESS_STEEL_INGOT.get())
                .unlockedBy(getHasName(UDItems.STAINLESS_STEEL_INGOT.get()), has(UDItems.STAINLESS_STEEL_INGOT.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDItems.STAINLESS_STEEL_NUGGET.get()) + "_from_ingot"));

        createPianoRecipe(UDBlocks.OAK_PIANO.get(), Ingredient.of(Items.OAK_PLANKS),
                Ingredient.of(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.OAK_PIANO.get())));

        createPianoRecipe(UDBlocks.SPRUCE_PIANO.get(), Ingredient.of(Items.SPRUCE_PLANKS),
                Ingredient.of(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.SPRUCE_PIANO.get())));

        createPianoRecipe(UDBlocks.BIRCH_PIANO.get(), Ingredient.of(Items.BIRCH_PLANKS),
                Ingredient.of(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.BIRCH_PIANO.get())));

        createPianoRecipe(UDBlocks.JUNGLE_PIANO.get(), Ingredient.of(Items.JUNGLE_PLANKS),
                Ingredient.of(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.JUNGLE_PIANO.get())));

        createPianoRecipe(UDBlocks.ACACIA_PIANO.get(), Ingredient.of(Items.ACACIA_PLANKS),
                Ingredient.of(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.ACACIA_PIANO.get())));

        createPianoRecipe(UDBlocks.DARK_OAK_PIANO.get(), Ingredient.of(Items.DARK_OAK_PLANKS),
                Ingredient.of(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.DARK_OAK_PIANO.get())));

        createPianoRecipe(UDBlocks.MANGROVE_PIANO.get(), Ingredient.of(Items.MANGROVE_PLANKS),
                Ingredient.of(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.MANGROVE_PIANO.get())));

        createPianoRecipe(UDBlocks.CHERRY_PIANO.get(), Ingredient.of(Items.CHERRY_PLANKS),
                Ingredient.of(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.CHERRY_PIANO.get())));

        createPianoRecipe(UDBlocks.BAMBOO_PIANO.get(), Ingredient.of(Items.BAMBOO_PLANKS),
                Ingredient.of(UDItems.STAINLESS_STEEL_INGOT.get()), Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.BAMBOO_PIANO.get())));

        createPianoRecipe(UDBlocks.CRIMSON_PIANO.get(), Ingredient.of(Items.CRIMSON_PLANKS),
                Ingredient.of(Items.GOLD_INGOT), Ingredient.of(UDItems.PORCELAIN.get()))
             .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.CRIMSON_PIANO.get())));

        createPianoRecipe(UDBlocks.WARPED_PIANO.get(), Ingredient.of(Items.WARPED_PLANKS),
                Ingredient.of(Items.GOLD_INGOT), Ingredient.of(UDItems.PORCELAIN.get()))
                .unlockedBy(getHasName(UDItems.PORCELAIN.get()), has(UDItems.PORCELAIN.get()))
                .save(exporter, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, getSimpleRecipeName(UDBlocks.WARPED_PIANO.get())));
    }

    public static ShapelessRecipeBuilder createFromBasePictureFrameRecipe(ItemLike output, Item picture, DyeColor color) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output, 1)
                .requires(picture).requires(DyeItem.byColor(color));
    }

    public static ShapedRecipeBuilder createFourForFourWendysMealRecipe(ItemLike output, Ingredient input) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .define('#', input)
                .pattern("##")
                .pattern("##");
    }

    public static ShapedRecipeBuilder createTwoByTwoRecipe(ItemLike output, int count, Ingredient input) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, count)
                .define('#', input)
                .pattern("##")
                .pattern("##");
    }

    public static ShapedRecipeBuilder createPianoRecipe(ItemLike output, Ingredient planks, Ingredient ingot, Ingredient porcelain) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, output, 1)
                .define('#', planks).define('@', ingot).define('!', porcelain)
                .pattern("#!#")
                .pattern("#@#");
    }

    public static ShapedRecipeBuilder createPictureFrameRecipe(ItemLike output, DyeColor color) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, output, 1)
                .define('#', Items.STICK).define('@', DyeItem.byColor(color))
                .pattern("###")
                .pattern("#@#")
                .pattern("###");
    }

    public static ShapedRecipeBuilder createBasePictureFrameRecipe(ItemLike output, Item item) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, output, 1)
                .define('#', Items.STICK).define('@', item)
                .pattern("###")
                .pattern("#@#")
                .pattern("###");
    }

    public static ShapedRecipeBuilder createTowelBlockRecipe(ItemLike output, Block input) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, output, 4)
                .define('#', input)
                .pattern("##")
                .pattern("##");
    }
}
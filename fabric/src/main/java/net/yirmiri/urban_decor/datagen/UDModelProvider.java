package net.yirmiri.urban_decor.datagen;

import net.azurune.runiclib.RunicLib;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.util.WrapColor;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDItems;

import java.util.*;

public class UDModelProvider extends FabricModelProvider {
    public UDModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        BlockModelGenerators.BlockFamilyProvider porcelainTiles = generator.family(UDBlocks.PORCELAIN_TILES.get());
        porcelainTiles.stairs(UDBlocks.PORCELAIN_TILE_STAIRS.get());
        porcelainTiles.slab(UDBlocks.PORCELAIN_TILE_SLAB.get());

        BlockModelGenerators.BlockFamilyProvider darkPorcelainTiles = generator.family(UDBlocks.DARK_PORCELAIN_TILES.get());
        darkPorcelainTiles.stairs(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get());
        darkPorcelainTiles.slab(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get());

        BlockModelGenerators.BlockFamilyProvider chromite = generator.family(UDBlocks.CHROMITE.get());
        chromite.stairs(UDBlocks.CHROMITE_STAIRS.get());
        chromite.slab(UDBlocks.CHROMITE_SLAB.get());
        chromite.wall(UDBlocks.CHROMITE_WALL.get());

        BlockModelGenerators.BlockFamilyProvider polishedChromite = generator.family(UDBlocks.POLISHED_CHROMITE.get());
        polishedChromite.stairs(UDBlocks.POLISHED_CHROMITE_STAIRS.get());
        polishedChromite.slab(UDBlocks.POLISHED_CHROMITE_SLAB.get());

        BlockModelGenerators.BlockFamilyProvider checkeredPorcelainTiles = generator.family(UDBlocks.CHECKERED_PORCELAIN_TILES.get());
        checkeredPorcelainTiles.stairs(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get());
        checkeredPorcelainTiles.slab(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get());

        generator.family(UDBlocks.STAINLESS_STEEL_BLOCK.get());

        BlockModelGenerators.BlockFamilyProvider porcelain = generator.family(UDBlocks.PORCELAIN_BLOCK.get());
        porcelain.stairs(UDBlocks.PORCELAIN_STAIRS.get());
        porcelain.slab(UDBlocks.PORCELAIN_SLAB.get());

        BlockModelGenerators.BlockFamilyProvider darkPorcelain = generator.family(UDBlocks.DARK_PORCELAIN_BLOCK.get());
        darkPorcelain.stairs(UDBlocks.DARK_PORCELAIN_STAIRS.get());
        darkPorcelain.slab(UDBlocks.DARK_PORCELAIN_SLAB.get());

        BlockModelGenerators.BlockFamilyProvider porcelainBricks = generator.family(UDBlocks.PORCELAIN_BRICKS.get());
        porcelainBricks.stairs(UDBlocks.PORCELAIN_BRICK_STAIRS.get());
        porcelainBricks.slab(UDBlocks.PORCELAIN_BRICK_SLAB.get());

        BlockModelGenerators.BlockFamilyProvider darkPorcelainBricks = generator.family(UDBlocks.DARK_PORCELAIN_BRICKS.get());
        darkPorcelainBricks.stairs(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get());
        darkPorcelainBricks.slab(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get());

        generator.createDoor(UDBlocks.STAINLESS_STEEL_DOOR.get());
        generator.createTrapdoor(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get());
        //registerSteelBars(generator);

        generator.createTrivialCube(UDBlocks.POLYPROPYLENE_BLOCK.get());
        generator.createSimpleFlatItemModel(UDBlocks.STAINLESS_STEEL_LADDER.get());
        generator.createMultiface(UDBlocks.PLASTIC_LIGHTS.get());
        generator.createTrivialCube(UDBlocks.MATTRESS.get());

        //DYED
        for (DyeColor colors : DyeColor.values()) {
            generator.family(UDBlocks.getDyedTowelBlocks(colors.getId()).get());
            generator.createMultiface(UDBlocks.getDyedPlasticLights(colors.getId()).get());
        }

        //WRAPPED
        for (WrapColor colors : WrapColor.values()) {
            generator.createTrivialCube(UDBlocks.getWrappedMattresses(colors.getId()).get());
            BlockModelGenerators.BlockFamilyProvider wrappedPorcelain = generator.family(UDBlocks.getWrappedPorcelainBlocks(colors.getId()).get());
            wrappedPorcelain.stairs(UDBlocks.getWrappedPorcelainStairs(colors.getId()).get());
            wrappedPorcelain.slab(UDBlocks.getWrappedPorcelainSlabs(colors.getId()).get());

            BlockModelGenerators.BlockFamilyProvider wrappedPorcelainBricks = generator.family(UDBlocks.getWrappedPorcelainBricks(colors.getId()).get());
            wrappedPorcelainBricks.stairs(UDBlocks.getWrappedPorcelainBrickStairs(colors.getId()).get());
            wrappedPorcelainBricks.slab(UDBlocks.getWrappedPorcelainBrickSlabs(colors.getId()).get());

            BlockModelGenerators.BlockFamilyProvider wrappedPorcelainTiles = generator.family(UDBlocks.getWrappedPorcelainTiles(colors.getId()).get());
            wrappedPorcelainTiles.stairs(UDBlocks.getWrappedPorcelainTileStairs(colors.getId()).get());
            wrappedPorcelainTiles.slab(UDBlocks.getWrappedPorcelainTileSlabs(colors.getId()).get());

            generateFridges(generator, colors);
            generateFreezers(generator, colors);
            generateDishwashers(generator, colors);
            generateDryers(generator, colors);
            generateCupboards(generator, colors);
            generateOvens(generator, colors);
            generateWashingMachines(generator, colors);
            generateSinks(generator, colors);
            generateToilets(generator, colors);
            generateBathtubs(generator, colors);
            generateBooths(generator, colors);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(UDItems.POLYPROPYLENE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDItems.PORCELAIN.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDItems.STAINLESS_STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.TRASH_CAN.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.MICROWAVE.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.TOASTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDItems.DARK_PORCELAIN.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDItems.TOOLBOX.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.STOVE.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDItems.STEEL_PIPE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.BATHTUB.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.DARK_BATHTUB.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.FAUCET.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.SHOWER.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.DESK_FAN.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDItems.SATELLITE_DISH.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.TOWEL_BAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDItems.STAINLESS_STEEL_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDItems.PICTURE_FRAME.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.STAINLESS_STEEL_LANTERN.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.TOILET_PAPER.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.FLOOR_LAMP.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.OAK_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.SPRUCE_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.BIRCH_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.JUNGLE_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.ACACIA_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.DARK_OAK_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.MANGROVE_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.CHERRY_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.BAMBOO_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.CRIMSON_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.WARPED_PIANO.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.AIR_CONDITIONER.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.RADIATOR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.TURBINE.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.PLASTIC_CHAIR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.OAK_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.SPRUCE_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.BIRCH_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.JUNGLE_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.ACACIA_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.DARK_OAK_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.MANGROVE_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.CHERRY_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.BAMBOO_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.CRIMSON_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.WARPED_CALENDAR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.OAK_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.SPRUCE_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.BIRCH_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.JUNGLE_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.ACACIA_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.DARK_OAK_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.MANGROVE_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.CHERRY_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.BAMBOO_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.CRIMSON_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.WARPED_GRANDFATHER_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.WALL_CLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.OAK_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.SPRUCE_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.BIRCH_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.JUNGLE_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.ACACIA_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.DARK_OAK_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.MANGROVE_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.CHERRY_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.BAMBOO_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.CRIMSON_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.WARPED_BOX.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.PORCELAIN_TABLE.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.STAINLESS_STEEL_CHAIR.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.CASH_REGISTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.DARK_CASH_REGISTER.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.VENDING_MACHINE.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDBlocks.BOOTH.get().asItem(), ModelTemplates.FLAT_ITEM);

        for (DyeColor colors : DyeColor.values()) {
            generator.generateFlatItem(UDBlocks.getDyedTowels(colors.getId()).get().asItem(), ModelTemplates.FLAT_ITEM);
            generator.generateFlatItem(UDItems.getDyedPictureFrames(colors.getId()).get().asItem(), ModelTemplates.FLAT_ITEM);
        }

        for (WrapColor colors : WrapColor.values()) {
            generator.generateFlatItem(UDBlocks.getWrappedPolyanthous(colors.getId()).get().asItem(), ModelTemplates.FLAT_ITEM);
            generator.generateFlatItem(UDItems.getWrappedWraps(colors.getId()).get(), ModelTemplates.FLAT_ITEM);
        }
    }

    //WRAPPED
    private void generateBooths(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/booth"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_mattress")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth_inner"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/booth_inner"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_mattress")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth_outer"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/booth_outer"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_mattress")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth_armrests"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/booth_armrests"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_mattress")
                ));
    }

    private void generateBathtubs(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_bathtub_back"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/bathtub_back"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_bathtub"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_bathtub_front"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/bathtub_front"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_bathtub"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_bathtub_back"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_bathtub_back"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_bathtub"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_bathtub_front"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_bathtub_front"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_bathtub"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }
    
    private void generateToilets(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/toilet"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet_alt"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/toilet_alt"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/toilet_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet_alt_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/toilet_alt_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_toilet"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet_alt"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_toilet_alt"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_toilet_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet_alt_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_toilet_alt_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    private void generateSinks(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/sink"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink_bare"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/sink_bare"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink_cupboard"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/sink_cupboard"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink_fullsize"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/sink_fullsize"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink_large"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/sink_large"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_sink"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink_bare"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_sink_bare"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink_cupboard"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_sink_cupboard"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink_fullsize"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_sink_fullsize"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink_large"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_sink_large"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    private void generateWashingMachines(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/washing_machine"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/washing_machine_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/washing_machine_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/washing_machine_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_washing_machine"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_washing_machine_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_washing_machine_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_washing_machine_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    private void generateOvens(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_opaque_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_opaque_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_open_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_open_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_opaque_open_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_opaque_open_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_opaque_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_opaque_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_open_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_open_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_opaque_open_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_opaque_open_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }
    
    private void generateCupboards(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard_slim"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard_slim"), Map.of(
                        "1", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard_slim_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard_slim_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard_slim"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard_slim"), Map.of(
                        "1", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard_slim_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard_slim_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard_fullsize"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard_fullsize"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard_fullsize_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard_fullsize_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard_fullsize"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard_fullsize"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard_fullsize_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard_fullsize_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    private void generateDishwashers(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dishwasher"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dishwasher"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dishwasher"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dishwasher_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dishwasher_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dishwasher"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dishwasher"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dishwasher"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dishwasher"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dishwasher_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dishwasher_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dishwasher"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    private void generateDryers(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dryer"), Map.of(
                        "1", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dryer_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dryer_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dryer_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dryer"), Map.of(
                        "1", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dryer_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dryer_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dryer_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    private void generateFreezers(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_freezer"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/freezer"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_freezer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_freezer_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/freezer_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_freezer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_freezer"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_freezer"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_freezer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_freezer_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_freezer_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_freezer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    private void generateFridges(BlockModelGenerators generator, WrapColor colors) {
        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/fridge"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge_flipped"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/fridge_flipped"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/fridge_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge_flipped_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/fridge_flipped_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_fridge"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge_flipped"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_fridge_flipped"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_fridge_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge_flipped_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_fridge_flipped_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    private void createParentedModel(BlockModelGenerators generator, ResourceLocation modelName, ResourceLocation parent, Map<String, ResourceLocation> textureMap) {
        Map<String, TextureSlot> keyMap = new HashMap<>();
        List<TextureSlot> keys = new ArrayList<>();

        for (String key : textureMap.keySet()) {
            TextureSlot slot = key.equals("particle") ? TextureSlot.PARTICLE : TextureSlot.create(key);
            keyMap.put(key, slot);
            keys.add(slot);
        }

        TextureMapping textures = new TextureMapping();
        for (Map.Entry<String, ResourceLocation> entry : textureMap.entrySet()) {
            textures.put(keyMap.get(entry.getKey()), entry.getValue());
        }

        new ModelTemplate(Optional.of(parent), Optional.empty(), keys.toArray(new TextureSlot[0])).create(modelName, textures, generator.modelOutput);
    }
}

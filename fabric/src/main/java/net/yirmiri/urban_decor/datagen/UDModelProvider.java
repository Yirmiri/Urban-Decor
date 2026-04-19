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

        generator.createTrivialCube(UDBlocks.STAINLESS_STEEL_DEPOSIT.get());

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

            UDModelAppliances.generateFridges(generator, colors);
            UDModelAppliances.generateFreezers(generator, colors);
            UDModelAppliances.generateDishwashers(generator, colors);
            UDModelAppliances.generateDryers(generator, colors);
            UDModelAppliances.generateCupboards(generator, colors);
            UDModelAppliances.generateOvens(generator, colors);
            UDModelAppliances.generateWashingMachines(generator, colors);
            UDModelAppliances.generateSinks(generator, colors);
            UDModelAppliances.generateToilets(generator, colors);
            UDModelAppliances.generateBathtubs(generator, colors);
            UDModelAppliances.generateBooths(generator, colors);
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
        generator.generateFlatItem(UDBlocks.SEWING_MACHINE.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UDItems.SEWING_NEEDLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(UDBlocks.STAPLER.get().asItem(), ModelTemplates.FLAT_ITEM);

        for (DyeColor colors : DyeColor.values()) {
            generator.generateFlatItem(UDBlocks.getDyedTowels(colors.getId()).get().asItem(), ModelTemplates.FLAT_ITEM);
            generator.generateFlatItem(UDItems.getDyedPictureFrames(colors.getId()).get().asItem(), ModelTemplates.FLAT_ITEM);
        }

        for (WrapColor colors : WrapColor.values()) {
            generator.generateFlatItem(UDBlocks.getWrappedPolyanthous(colors.getId()).get().asItem(), ModelTemplates.FLAT_ITEM);
            generator.generateFlatItem(UDItems.getWrappedWraps(colors.getId()).get(), ModelTemplates.FLAT_ITEM);
        }
    }

    public static void createParentedModel(BlockModelGenerators generator, ResourceLocation modelName, ResourceLocation parent, Map<String, ResourceLocation> textureMap) {
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

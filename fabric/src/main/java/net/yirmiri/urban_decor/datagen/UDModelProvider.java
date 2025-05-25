package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.item.DyeColor;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDItems;

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

        for (DyeColor colors : DyeColor.values()) {
            generator.family(UDBlocks.getDyedTowelBlocks(colors.getId()).get());
        }

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
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
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

        for (DyeColor colors : DyeColor.values()) {
            generator.generateFlatItem(UDBlocks.getDyedTowels(colors.getId()).get().asItem(), ModelTemplates.FLAT_ITEM);
            generator.generateFlatItem(UDItems.getDyedPictureFrames(colors.getId()).get().asItem(), ModelTemplates.FLAT_ITEM);
        }
    }

//    private void registerSteelBars(BlockStateModelGenerator generator) {
//        Identifier identifier = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS.get(), "_post_ends");
//        Identifier identifier2 = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS.get(), "_post");
//        Identifier identifier3 = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS.get(), "_cap");
//        Identifier identifier4 = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS.get(), "_cap_alt");
//        Identifier identifier5 = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS.get(), "_side");
//        Identifier identifier6 = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS.get(), "_side_alt");
//        generator.blockStateCollector.accept(MultipartBlockStateSupplier.create(UDBlocks.STAINLESS_STEEL_BARS.get())
//                .with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
//                .with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false),
//                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier2))
//                .with(When.create().set(Properties.NORTH, true).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false),
//                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier3))
//                .with(When.create().set(Properties.NORTH, false).set(Properties.EAST, true).set(Properties.SOUTH, false).set(Properties.WEST, false),
//                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90))
//                .with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, true).set(Properties.WEST, false),
//                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier4))
//                .with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, true),
//                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R90))
//                .with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5))
//                .with(When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y,
//                        VariantSettings.Rotation.R90)).with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create()
//                        .put(VariantSettings.MODEL, identifier6)).with(When.create().set(Properties.WEST, true), BlockStateVariant.create()
//                        .put(VariantSettings.MODEL, identifier6).put(VariantSettings.Y, VariantSettings.Rotation.R90)).get());
//        generator.registerItemModel(UDBlocks.STAINLESS_STEEL_BARS.get());
//    }
}

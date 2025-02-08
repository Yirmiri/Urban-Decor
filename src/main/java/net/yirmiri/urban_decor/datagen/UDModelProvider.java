package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.registry.UDBlocks;
import net.yirmiri.urban_decor.registry.UDItems;

public class UDModelProvider extends FabricModelProvider {
    public UDModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        BlockStateModelGenerator.BlockTexturePool porcelainTiles = generator.registerCubeAllModelTexturePool(UDBlocks.PORCELAIN_TILES);
        porcelainTiles.stairs(UDBlocks.PORCELAIN_TILE_STAIRS);
        porcelainTiles.slab(UDBlocks.PORCELAIN_TILE_SLAB);

        BlockStateModelGenerator.BlockTexturePool darkPorcelainTiles = generator.registerCubeAllModelTexturePool(UDBlocks.DARK_PORCELAIN_TILES);
        darkPorcelainTiles.stairs(UDBlocks.DARK_PORCELAIN_TILE_STAIRS);
        darkPorcelainTiles.slab(UDBlocks.DARK_PORCELAIN_TILE_SLAB);

        BlockStateModelGenerator.BlockTexturePool chromite = generator.registerCubeAllModelTexturePool(UDBlocks.CHROMITE);
        chromite.stairs(UDBlocks.CHROMITE_STAIRS);
        chromite.slab(UDBlocks.CHROMITE_SLAB);
        chromite.wall(UDBlocks.CHROMITE_WALL);

        BlockStateModelGenerator.BlockTexturePool polishedChromite = generator.registerCubeAllModelTexturePool(UDBlocks.POLISHED_CHROMITE);
        polishedChromite.stairs(UDBlocks.POLISHED_CHROMITE_STAIRS);
        polishedChromite.slab(UDBlocks.POLISHED_CHROMITE_SLAB);

        BlockStateModelGenerator.BlockTexturePool checkeredPorcelainTiles = generator.registerCubeAllModelTexturePool(UDBlocks.CHECKERED_PORCELAIN_TILES);
        checkeredPorcelainTiles.stairs(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS);
        checkeredPorcelainTiles.slab(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB);

        generator.registerCubeAllModelTexturePool(UDBlocks.STAINLESS_STEEL_BLOCK);

        for (DyeColor colors : DyeColor.values()) {
            generator.registerCubeAllModelTexturePool(UDBlocks.getDyedTowelBlocks(colors.getId()));
        }

        BlockStateModelGenerator.BlockTexturePool porcelain = generator.registerCubeAllModelTexturePool(UDBlocks.PORCELAIN_BLOCK);
        porcelain.stairs(UDBlocks.PORCELAIN_STAIRS);
        porcelain.slab(UDBlocks.PORCELAIN_SLAB);

        BlockStateModelGenerator.BlockTexturePool darkPorcelain = generator.registerCubeAllModelTexturePool(UDBlocks.DARK_PORCELAIN_BLOCK);
        darkPorcelain.stairs(UDBlocks.DARK_PORCELAIN_STAIRS);
        darkPorcelain.slab(UDBlocks.DARK_PORCELAIN_SLAB);

        BlockStateModelGenerator.BlockTexturePool porcelainBricks = generator.registerCubeAllModelTexturePool(UDBlocks.PORCELAIN_BRICKS);
        porcelainBricks.stairs(UDBlocks.PORCELAIN_BRICK_STAIRS);
        porcelainBricks.slab(UDBlocks.PORCELAIN_BRICK_SLAB);

        BlockStateModelGenerator.BlockTexturePool darkPorcelainBricks = generator.registerCubeAllModelTexturePool(UDBlocks.DARK_PORCELAIN_BRICKS);
        darkPorcelainBricks.stairs(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS);
        darkPorcelainBricks.slab(UDBlocks.DARK_PORCELAIN_BRICK_SLAB);

        generator.registerDoor(UDBlocks.STAINLESS_STEEL_DOOR);
        registerSteelBars(generator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(UDItems.PORCELAIN, Models.GENERATED);
        generator.register(UDItems.STAINLESS_STEEL_INGOT, Models.GENERATED);
        generator.register(UDBlocks.TRASH_CAN.asItem(), Models.GENERATED);
        generator.register(UDBlocks.MICROWAVE.asItem(), Models.GENERATED);
        generator.register(UDBlocks.TOASTER.asItem(), Models.GENERATED);
        generator.register(UDItems.DARK_PORCELAIN, Models.GENERATED);
        generator.register(UDItems.TOOLBOX, Models.GENERATED);
        generator.register(UDBlocks.STOVE.asItem(), Models.GENERATED);
        generator.register(UDItems.STEEL_PIPE, Models.GENERATED);
        generator.register(UDBlocks.BATHTUB.asItem(), Models.GENERATED);
        generator.register(UDBlocks.DARK_BATHTUB.asItem(), Models.GENERATED);
        generator.register(UDBlocks.FAUCET.asItem(), Models.GENERATED);
        generator.register(UDBlocks.SHOWER.asItem(), Models.GENERATED);
        generator.register(UDBlocks.DESK_FAN.asItem(), Models.GENERATED);
        generator.register(UDItems.SATELLITE_DISH.asItem(), Models.GENERATED);
        generator.register(UDBlocks.TOWEL_BAR.asItem(), Models.GENERATED);
        generator.register(UDItems.STAINLESS_STEEL_NUGGET, Models.GENERATED);
        generator.register(UDItems.PICTURE_FRAME, Models.GENERATED);
        generator.register(UDBlocks.STAINLESS_STEEL_LANTERN.asItem(), Models.GENERATED);
        generator.register(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.asItem(), Models.GENERATED);
        generator.register(UDBlocks.TOILET_PAPER.asItem(), Models.GENERATED);

        for (DyeColor colors : DyeColor.values()) {
            generator.register(UDBlocks.getDyedTowels(colors.getId()).asItem(), Models.GENERATED);
            generator.register(UDItems.getDyedPictureFrames(colors.getId()).asItem(), Models.GENERATED);
        }
    }

    private void registerSteelBars(BlockStateModelGenerator generator) {
        Identifier identifier = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS, "_post_ends");
        Identifier identifier2 = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS, "_post");
        Identifier identifier3 = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS, "_cap");
        Identifier identifier4 = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS, "_cap_alt");
        Identifier identifier5 = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS, "_side");
        Identifier identifier6 = ModelIds.getBlockSubModelId(UDBlocks.STAINLESS_STEEL_BARS, "_side_alt");
        generator.blockStateCollector.accept(MultipartBlockStateSupplier.create(UDBlocks.STAINLESS_STEEL_BARS).with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)).with(When.create().set(Properties.NORTH, true).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)).with(When.create().set(Properties.NORTH, false).set(Properties.EAST, true).set(Properties.SOUTH, false).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, true).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)).with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5)).with(When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier6)).with(When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier6).put(VariantSettings.Y, VariantSettings.Rotation.R90)));
        generator.registerItemModel(UDBlocks.STAINLESS_STEEL_BARS);
    }
}

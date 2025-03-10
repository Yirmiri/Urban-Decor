package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
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
        BlockStateModelGenerator.BlockTexturePool porcelainTiles = generator.registerCubeAllModelTexturePool(UDBlocks.PORCELAIN_TILES.get());
        porcelainTiles.stairs(UDBlocks.PORCELAIN_TILE_STAIRS.get());
        porcelainTiles.slab(UDBlocks.PORCELAIN_TILE_SLAB.get());

        BlockStateModelGenerator.BlockTexturePool darkPorcelainTiles = generator.registerCubeAllModelTexturePool(UDBlocks.DARK_PORCELAIN_TILES.get());
        darkPorcelainTiles.stairs(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get());
        darkPorcelainTiles.slab(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get());

        BlockStateModelGenerator.BlockTexturePool chromite = generator.registerCubeAllModelTexturePool(UDBlocks.CHROMITE.get());
        chromite.stairs(UDBlocks.CHROMITE_STAIRS.get());
        chromite.slab(UDBlocks.CHROMITE_SLAB.get());
        chromite.wall(UDBlocks.CHROMITE_WALL.get());

        BlockStateModelGenerator.BlockTexturePool polishedChromite = generator.registerCubeAllModelTexturePool(UDBlocks.POLISHED_CHROMITE.get());
        polishedChromite.stairs(UDBlocks.POLISHED_CHROMITE_STAIRS.get());
        polishedChromite.slab(UDBlocks.POLISHED_CHROMITE_SLAB.get());

        BlockStateModelGenerator.BlockTexturePool checkeredPorcelainTiles = generator.registerCubeAllModelTexturePool(UDBlocks.CHECKERED_PORCELAIN_TILES.get());
        checkeredPorcelainTiles.stairs(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get());
        checkeredPorcelainTiles.slab(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get());

        generator.registerCubeAllModelTexturePool(UDBlocks.STAINLESS_STEEL_BLOCK.get());

        for (DyeColor colors : DyeColor.values()) {
            generator.registerCubeAllModelTexturePool(UDBlocks.getDyedTowelBlocks(colors.getId()).get());
        }

        BlockStateModelGenerator.BlockTexturePool porcelain = generator.registerCubeAllModelTexturePool(UDBlocks.PORCELAIN_BLOCK.get());
        porcelain.stairs(UDBlocks.PORCELAIN_STAIRS.get());
        porcelain.slab(UDBlocks.PORCELAIN_SLAB.get());

        BlockStateModelGenerator.BlockTexturePool darkPorcelain = generator.registerCubeAllModelTexturePool(UDBlocks.DARK_PORCELAIN_BLOCK.get());
        darkPorcelain.stairs(UDBlocks.DARK_PORCELAIN_STAIRS.get());
        darkPorcelain.slab(UDBlocks.DARK_PORCELAIN_SLAB.get());

        BlockStateModelGenerator.BlockTexturePool porcelainBricks = generator.registerCubeAllModelTexturePool(UDBlocks.PORCELAIN_BRICKS.get());
        porcelainBricks.stairs(UDBlocks.PORCELAIN_BRICK_STAIRS.get());
        porcelainBricks.slab(UDBlocks.PORCELAIN_BRICK_SLAB.get());

        BlockStateModelGenerator.BlockTexturePool darkPorcelainBricks = generator.registerCubeAllModelTexturePool(UDBlocks.DARK_PORCELAIN_BRICKS.get());
        darkPorcelainBricks.stairs(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get());
        darkPorcelainBricks.slab(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get());

        generator.registerDoor(UDBlocks.STAINLESS_STEEL_DOOR.get());
        generator.registerOrientableTrapdoor(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get());
        //registerSteelBars(generator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(UDItems.PORCELAIN.get(), Models.GENERATED);
        generator.register(UDItems.STAINLESS_STEEL_INGOT.get(), Models.GENERATED);
        generator.register(UDBlocks.TRASH_CAN.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.MICROWAVE.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.TOASTER.get().asItem(), Models.GENERATED);
        generator.register(UDItems.DARK_PORCELAIN.get(), Models.GENERATED);
        generator.register(UDItems.TOOLBOX.get(), Models.GENERATED);
        generator.register(UDBlocks.STOVE.get().asItem(), Models.GENERATED);
        generator.register(UDItems.STEEL_PIPE.get(), Models.GENERATED);
        generator.register(UDBlocks.BATHTUB.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.DARK_BATHTUB.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.FAUCET.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.SHOWER.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.DESK_FAN.get().asItem(), Models.GENERATED);
        generator.register(UDItems.SATELLITE_DISH.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.TOWEL_BAR.get().asItem(), Models.GENERATED);
        generator.register(UDItems.STAINLESS_STEEL_NUGGET.get(), Models.GENERATED);
        generator.register(UDItems.PICTURE_FRAME.get(), Models.GENERATED);
        generator.register(UDBlocks.STAINLESS_STEEL_LANTERN.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.TOILET_PAPER.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.FLOOR_LAMP.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.OAK_PIANO.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.SPRUCE_PIANO.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.BIRCH_PIANO.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.JUNGLE_PIANO.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.ACACIA_PIANO.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.DARK_OAK_PIANO.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.MANGROVE_PIANO.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.CHERRY_PIANO.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.BAMBOO_PIANO.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.CRIMSON_PIANO.get().asItem(), Models.GENERATED);
        generator.register(UDBlocks.WARPED_PIANO.get().asItem(), Models.GENERATED);

        for (DyeColor colors : DyeColor.values()) {
            generator.register(UDBlocks.getDyedTowels(colors.getId()).get().asItem(), Models.GENERATED);
            generator.register(UDItems.getDyedPictureFrames(colors.getId()).get().asItem(), Models.GENERATED);
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

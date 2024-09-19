package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.DyeColor;
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

        BlockStateModelGenerator.BlockTexturePool chromite = generator.registerCubeAllModelTexturePool(UDBlocks.CHROMITE);
        chromite.stairs(UDBlocks.CHROMITE_STAIRS);
        chromite.slab(UDBlocks.CHROMITE_SLAB);
        chromite.wall(UDBlocks.CHROMITE_WALL);

        BlockStateModelGenerator.BlockTexturePool polishedChromite = generator.registerCubeAllModelTexturePool(UDBlocks.POLISHED_CHROMITE);
        polishedChromite.stairs(UDBlocks.POLISHED_CHROMITE_STAIRS);
        polishedChromite.slab(UDBlocks.POLISHED_CHROMITE_SLAB);

        BlockStateModelGenerator.BlockTexturePool darkPorcelainTiles = generator.registerCubeAllModelTexturePool(UDBlocks.DARK_PORCELAIN_TILES);
        darkPorcelainTiles.stairs(UDBlocks.DARK_PORCELAIN_TILE_STAIRS);
        darkPorcelainTiles.slab(UDBlocks.DARK_PORCELAIN_TILE_SLAB);

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

        for (DyeColor colors : DyeColor.values()) {
            generator.register(UDBlocks.getDyedTowels(colors.getId()).asItem(), Models.GENERATED);
            generator.register(UDItems.getDyedPictureFrames(colors.getId()).asItem(), Models.GENERATED);
        }
    }
}

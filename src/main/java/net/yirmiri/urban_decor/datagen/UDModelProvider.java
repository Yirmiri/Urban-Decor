package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.util.DyeColor;
import net.yirmiri.urban_decor.registry.RegisterBlocks;
import net.yirmiri.urban_decor.registry.RegisterItems;

public class UDModelProvider extends FabricModelProvider {
    public UDModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        BlockStateModelGenerator.BlockTexturePool porcelainTiles = generator.registerCubeAllModelTexturePool(RegisterBlocks.PORCELAIN_TILES);
        porcelainTiles.stairs(RegisterBlocks.PORCELAIN_TILE_STAIRS);
        porcelainTiles.slab(RegisterBlocks.PORCELAIN_TILE_SLAB);

        BlockStateModelGenerator.BlockTexturePool chromite = generator.registerCubeAllModelTexturePool(RegisterBlocks.CHROMITE);
        chromite.stairs(RegisterBlocks.CHROMITE_STAIRS);
        chromite.slab(RegisterBlocks.CHROMITE_SLAB);
        chromite.wall(RegisterBlocks.CHROMITE_WALL);

        BlockStateModelGenerator.BlockTexturePool polishedChromite = generator.registerCubeAllModelTexturePool(RegisterBlocks.POLISHED_CHROMITE);
        polishedChromite.stairs(RegisterBlocks.POLISHED_CHROMITE_STAIRS);
        polishedChromite.slab(RegisterBlocks.POLISHED_CHROMITE_SLAB);

        BlockStateModelGenerator.BlockTexturePool darkPorcelainTiles = generator.registerCubeAllModelTexturePool(RegisterBlocks.DARK_PORCELAIN_TILES);
        darkPorcelainTiles.stairs(RegisterBlocks.DARK_PORCELAIN_TILE_STAIRS);
        darkPorcelainTiles.slab(RegisterBlocks.DARK_PORCELAIN_TILE_SLAB);

        BlockStateModelGenerator.BlockTexturePool checkeredPorcelainTiles = generator.registerCubeAllModelTexturePool(RegisterBlocks.CHECKERED_PORCELAIN_TILES);
        checkeredPorcelainTiles.stairs(RegisterBlocks.CHECKERED_PORCELAIN_TILE_STAIRS);
        checkeredPorcelainTiles.slab(RegisterBlocks.CHECKERED_PORCELAIN_TILE_SLAB);

        generator.registerCubeAllModelTexturePool(RegisterBlocks.STAINLESS_STEEL_BLOCK);

        for (DyeColor colors : DyeColor.values()) {
            generator.registerCubeAllModelTexturePool(RegisterBlocks.getDyedTowelBlocks(colors.getId()));
        }

        BlockStateModelGenerator.BlockTexturePool porcelain = generator.registerCubeAllModelTexturePool(RegisterBlocks.PORCELAIN_BLOCK);
        porcelain.stairs(RegisterBlocks.PORCELAIN_STAIRS);
        porcelain.slab(RegisterBlocks.PORCELAIN_SLAB);

        BlockStateModelGenerator.BlockTexturePool darkPorcelain = generator.registerCubeAllModelTexturePool(RegisterBlocks.DARK_PORCELAIN_BLOCK);
        darkPorcelain.stairs(RegisterBlocks.DARK_PORCELAIN_STAIRS);
        darkPorcelain.slab(RegisterBlocks.DARK_PORCELAIN_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(RegisterItems.PORCELAIN, Models.GENERATED);
        generator.register(RegisterItems.STAINLESS_STEEL_INGOT, Models.GENERATED);
        generator.register(RegisterBlocks.TRASH_CAN.asItem(), Models.GENERATED);
        generator.register(RegisterBlocks.MICROWAVE.asItem(), Models.GENERATED);
        generator.register(RegisterBlocks.TOASTER.asItem(), Models.GENERATED);
        generator.register(RegisterItems.DARK_PORCELAIN, Models.GENERATED);
        generator.register(RegisterItems.TOOLBOX, Models.GENERATED);
        generator.register(RegisterBlocks.STOVE.asItem(), Models.GENERATED);
        generator.register(RegisterItems.STEEL_PIPE, Models.GENERATED);
        generator.register(RegisterBlocks.BATHTUB.asItem(), Models.GENERATED);
        generator.register(RegisterBlocks.DARK_BATHTUB.asItem(), Models.GENERATED);
        generator.register(RegisterBlocks.FAUCET.asItem(), Models.GENERATED);
        generator.register(RegisterBlocks.SHOWER.asItem(), Models.GENERATED);
        generator.register(RegisterBlocks.DESK_FAN.asItem(), Models.GENERATED);
        generator.register(RegisterBlocks.SATELLITE_DISH.asItem(), Models.GENERATED);
        generator.register(RegisterBlocks.TOWEL_BAR.asItem(), Models.GENERATED);
        generator.register(RegisterItems.STAINLESS_STEEL_NUGGET, Models.GENERATED);

        for (DyeColor colors : DyeColor.values()) {
            generator.register(RegisterBlocks.getDyedTowels(colors.getId()).asItem(), Models.GENERATED);
        }
    }
}

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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RegisterItems.PORCELAIN, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.STAINLESS_STEEL, Models.GENERATED);
        itemModelGenerator.register(RegisterBlocks.TRASH_CAN.asItem(), Models.GENERATED);
        itemModelGenerator.register(RegisterBlocks.MICROWAVE.asItem(), Models.GENERATED);
        itemModelGenerator.register(RegisterBlocks.TOASTER.asItem(), Models.GENERATED);
        itemModelGenerator.register(RegisterItems.DARK_PORCELAIN, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.TOOLBOX, Models.GENERATED);
        itemModelGenerator.register(RegisterBlocks.STOVE.asItem(), Models.GENERATED);
        itemModelGenerator.register(RegisterItems.STEEL_PIPE, Models.GENERATED);

        for (DyeColor colors : DyeColor.values()) {
            itemModelGenerator.register(RegisterBlocks.getDyedTowels(colors.getId()).asItem(), Models.GENERATED);
        }
    }
}

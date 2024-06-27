package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.registry.RegisterBlocks;

import java.util.concurrent.CompletableFuture;

public class UDBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public UDBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(RegisterBlocks.PORCELAIN_TILES)
                .add(RegisterBlocks.PORCELAIN_TILE_STAIRS)
                .add(RegisterBlocks.PORCELAIN_TILE_SLAB)
                .add(RegisterBlocks.MICROWAVE)
                .add(RegisterBlocks.SINK)
                .add(RegisterBlocks.CHROMITE)
                .add(RegisterBlocks.CHROMITE_STAIRS)
                .add(RegisterBlocks.CHROMITE_SLAB)
                .add(RegisterBlocks.CHROMITE_WALL)
                .add(RegisterBlocks.POLISHED_CHROMITE)
                .add(RegisterBlocks.POLISHED_CHROMITE_STAIRS)
                .add(RegisterBlocks.POLISHED_CHROMITE_SLAB)
                .add(RegisterBlocks.TOILET)
                .add(RegisterBlocks.WASHING_MACHINE)
                .add(RegisterBlocks.DRYER)
                .add(RegisterBlocks.TOASTER)
        ;

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(RegisterBlocks.CHROMITE_WALL)
        ;

        getOrCreateTagBuilder(BlockTags.CAMPFIRES)
                .add(RegisterBlocks.TOASTER)
        ;
    }

    private static TagKey<Block> create(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(UrbanDecor.MOD_ID, id));
    }
}

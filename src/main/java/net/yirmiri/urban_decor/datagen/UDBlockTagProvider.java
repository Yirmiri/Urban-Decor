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
        ;
    }

    private static TagKey<Block> create(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(UrbanDecor.MOD_ID, id));
    }
}

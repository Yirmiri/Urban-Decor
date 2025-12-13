package net.yirmiri.urban_decor.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.yirmiri.urban_decor.core.init.UDTags;

import java.util.concurrent.CompletableFuture;

public class UDBiomeTagProvider extends TagsProvider<Biome> {
    public UDBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.BIOME, lookupProvider);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        appendCherryPolyanthous();
        appendDaffodilPolyanthous();
        appendSpringPolyanthous();
        appendMintPolyanthous();
        appendAzurePolyanthous();
        appendRubyPolyanthous();
    }

    private void appendCherryPolyanthous() {
        getOrCreateRawBuilder(UDTags.BiomeT.CHERRY_POLYANTHOUS_GENERATES_IN)
                //.addTag(BiomeTags.IS_JUNGLE.location())
                .add(TagEntry.element(Biomes.JUNGLE.location()))
                .add(TagEntry.element(Biomes.BAMBOO_JUNGLE.location()))
                .add(TagEntry.element(Biomes.SPARSE_JUNGLE.location()))
                .add(TagEntry.element(Biomes.FOREST.location()))
                .add(TagEntry.element(Biomes.WINDSWEPT_FOREST.location()))

                .add(TagEntry.element(Biomes.FLOWER_FOREST.location()))
        ;
    }

    private void appendDaffodilPolyanthous() {
        getOrCreateRawBuilder(UDTags.BiomeT.DAFFODIL_POLYANTHOUS_GENERATES_IN)
                .add(TagEntry.element(Biomes.PLAINS.location()))
                .add(TagEntry.element(Biomes.BIRCH_FOREST.location()))
                .add(TagEntry.element(Biomes.OLD_GROWTH_BIRCH_FOREST.location()))
                .add(TagEntry.element(Biomes.SAVANNA.location()))
                .add(TagEntry.element(Biomes.SAVANNA_PLATEAU.location()))

                .add(TagEntry.element(Biomes.FLOWER_FOREST.location()))
        ;
    }

    private void appendSpringPolyanthous() {
        getOrCreateRawBuilder(UDTags.BiomeT.SPRING_POLYANTHOUS_GENERATES_IN)
                .add(TagEntry.element(Biomes.OLD_GROWTH_BIRCH_FOREST.location()))
                .add(TagEntry.element(Biomes.DARK_FOREST.location()))
                .add(TagEntry.element(Biomes.GROVE.location()))

                .add(TagEntry.element(Biomes.FLOWER_FOREST.location()))
        ;
    }

    private void appendMintPolyanthous() {
        getOrCreateRawBuilder(UDTags.BiomeT.MINT_POLYANTHOUS_GENERATES_IN)
                //.addTag(BiomeTags.IS_TAIGA.location())
                .add(TagEntry.element(Biomes.TAIGA.location()))
                .add(TagEntry.element(Biomes.SNOWY_TAIGA.location()))
                .add(TagEntry.element(Biomes.OLD_GROWTH_PINE_TAIGA.location()))
                .add(TagEntry.element(Biomes.OLD_GROWTH_SPRUCE_TAIGA.location()))
                //.addTag(BiomeTags.IS_MOUNTAIN.location())
                .add(TagEntry.element(Biomes.GROVE.location()))
                .add(TagEntry.element(Biomes.SNOWY_SLOPES.location()))
                .add(TagEntry.element(Biomes.JAGGED_PEAKS.location()))
                .add(TagEntry.element(Biomes.STONY_PEAKS.location()))
                .add(TagEntry.element(Biomes.FROZEN_PEAKS.location()))

                .add(TagEntry.element(Biomes.FLOWER_FOREST.location()))
        ;
    }

    private void appendAzurePolyanthous() {
        getOrCreateRawBuilder(UDTags.BiomeT.AZURE_POLYANTHOUS_GENERATES_IN)
                .add(TagEntry.element(Biomes.JUNGLE.location()))
                .add(TagEntry.element(Biomes.SPARSE_JUNGLE.location()))
                .add(TagEntry.element(Biomes.SNOWY_TAIGA.location()))
                .add(TagEntry.element(Biomes.SNOWY_PLAINS.location()))
                .add(TagEntry.element(Biomes.GROVE.location()))

                .add(TagEntry.element(Biomes.FLOWER_FOREST.location()))
        ;
    }

    private void appendRubyPolyanthous() {
        getOrCreateRawBuilder(UDTags.BiomeT.RUBY_POLYANTHOUS_GENERATES_IN)
                .add(TagEntry.element(Biomes.CHERRY_GROVE.location()))

                .add(TagEntry.element(Biomes.FLOWER_FOREST.location()))
        ;
    }
}

package net.yirmiri.urban_decor.util;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.gen.GenerationStep;
import net.yirmiri.urban_decor.worldgen.UDFeatures;

public class UDRegistries {

    public static void registerRegistries() {
        registerBiomeModifications();
    }

    public static void registerBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), GenerationStep.Feature.UNDERGROUND_ORES, UDFeatures.PlacedFeatures.ORE_CHROMITE);
    }
}

package net.yirmiri.urban_decor.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.yirmiri.urban_decor.common.worldgen.UDFeatures;

public class UDRegistries {
    public static void loadRegistries() {
        loadBiomeModifications();
    }

    public static void loadBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), GenerationStep.Decoration.UNDERGROUND_ORES, UDFeatures.PlacedFeatures.ORE_CHROMITE);
    }
}

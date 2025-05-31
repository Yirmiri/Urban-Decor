package net.yirmiri.urban_decor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.yirmiri.urban_decor.core.init.UDFeatures;

public class FabricUrbanDecor implements ModInitializer {
    
    @Override
    public void onInitialize() {
        UrbanDecor.init();

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), GenerationStep.Decoration.UNDERGROUND_ORES, UDFeatures.PlacedFeatures.ORE_CHROMITE);
    }
}

package net.yirmiri.urban_decor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.yirmiri.urban_decor.common.block.sewing_machine.SewingMachineScreen;
import net.yirmiri.urban_decor.core.init.UDFeatures;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDMenus;

public class FabricUrbanDecor implements ModInitializer {
    
    @Override
    public void onInitialize() {
        UrbanDecor.init();

        //FLOWERS
        BiomeModifications.addFeature(BiomeSelectors.tag(UDTags.BiomeT.CHERRY_POLYANTHOUS_GENERATES_IN),
                GenerationStep.Decoration.VEGETAL_DECORATION, UDFeatures.PlacedFeatures.PATCH_CHERRY_POLYANTHOUS);

        BiomeModifications.addFeature(BiomeSelectors.tag(UDTags.BiomeT.DAFFODIL_POLYANTHOUS_GENERATES_IN),
                GenerationStep.Decoration.VEGETAL_DECORATION, UDFeatures.PlacedFeatures.PATCH_DAFFODIL_POLYANTHOUS);

        BiomeModifications.addFeature(BiomeSelectors.tag(UDTags.BiomeT.SPRING_POLYANTHOUS_GENERATES_IN),
                GenerationStep.Decoration.VEGETAL_DECORATION, UDFeatures.PlacedFeatures.PATCH_SPRING_POLYANTHOUS);

        BiomeModifications.addFeature(BiomeSelectors.tag(UDTags.BiomeT.MINT_POLYANTHOUS_GENERATES_IN),
                GenerationStep.Decoration.VEGETAL_DECORATION, UDFeatures.PlacedFeatures.PATCH_MINT_POLYANTHOUS);

        BiomeModifications.addFeature(BiomeSelectors.tag(UDTags.BiomeT.AZURE_POLYANTHOUS_GENERATES_IN),
                GenerationStep.Decoration.VEGETAL_DECORATION, UDFeatures.PlacedFeatures.PATCH_AZURE_POLYANTHOUS);

        BiomeModifications.addFeature(BiomeSelectors.tag(UDTags.BiomeT.RUBY_POLYANTHOUS_GENERATES_IN),
                GenerationStep.Decoration.VEGETAL_DECORATION, UDFeatures.PlacedFeatures.PATCH_RUBY_POLYANTHOUS);

        //ORES
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Decoration.UNDERGROUND_ORES, UDFeatures.PlacedFeatures.ORE_CHROMITE);
    }
}

package net.yirmiri.urban_decor.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDFeatures {
    public static class ConfiguredFeatures {
        //STONES
        public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CHROMITE = createKey("ore_chromite");

        public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String id) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UrbanDecor.MOD_ID, id));
        }
    }

    public static class PlacedFeatures {
        //STONES
        public static final ResourceKey<PlacedFeature> ORE_CHROMITE = createKey("ore_chromite");

        public static ResourceKey<PlacedFeature> createKey(String id) {
            return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(UrbanDecor.MOD_ID, id));
        }
    }
}

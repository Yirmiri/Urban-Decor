package net.yirmiri.urban_decor.worldgen;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDFeatures {

    public static class ConfiguredFeatures {
        public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_CHROMITE = createKey("ore_chromite");

        public static RegistryKey<ConfiguredFeature<?, ?>> createKey(String id) {
            return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(UrbanDecor.MOD_ID, id));
        }
    }

    public static class PlacedFeatures {
        public static final RegistryKey<PlacedFeature> ORE_CHROMITE = createKey("ore_chromite");

        public static RegistryKey<PlacedFeature> createKey(String id) {
            return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(UrbanDecor.MOD_ID, id));
        }
    }
}

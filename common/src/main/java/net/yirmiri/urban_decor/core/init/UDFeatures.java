package net.yirmiri.urban_decor.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDFeatures {
    public static class ConfiguredFeatures { //unused(?)
        //STONES
        public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CHROMITE = createKey("ore_chromite");

        public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String id) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(UrbanDecor.MOD_ID, id));
        }
    }

    public static class PlacedFeatures {
        //FLOWERS
        public static final ResourceKey<PlacedFeature> PATCH_CHERRY_POLYANTHOUS = createKey("patch_cherry_polyanthous");
        public static final ResourceKey<PlacedFeature> PATCH_DAFFODIL_POLYANTHOUS = createKey("patch_daffodil_polyanthous");
        public static final ResourceKey<PlacedFeature> PATCH_SPRING_POLYANTHOUS = createKey("patch_spring_polyanthous");
        public static final ResourceKey<PlacedFeature> PATCH_MINT_POLYANTHOUS = createKey("patch_mint_polyanthous");
        public static final ResourceKey<PlacedFeature> PATCH_AZURE_POLYANTHOUS = createKey("patch_azure_polyanthous");
        public static final ResourceKey<PlacedFeature> PATCH_RUBY_POLYANTHOUS = createKey("patch_ruby_polyanthous");

        //STONES
        public static final ResourceKey<PlacedFeature> ORE_CHROMITE = createKey("ore_chromite");

        public static ResourceKey<PlacedFeature> createKey(String id) {
            return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(UrbanDecor.MOD_ID, id));
        }
    }
}

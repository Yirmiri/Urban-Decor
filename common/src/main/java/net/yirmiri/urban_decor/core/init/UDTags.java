package net.yirmiri.urban_decor.core.init;

import net.azurune.runiclib.RunicLib;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDTags {
    public static class BlockT {
        public static final TagKey<Block> SEATS = create("seats");
        public static final TagKey<Block> TOILETS = create("toilets");
        public static final TagKey<Block> HAS_TOOLBOX_VARIANTS = create("has_toolbox_variants");
        public static final TagKey<Block> POLYANTHOUS = create("polyanthous");
        public static final TagKey<Block> SMOOTH_STORAGE_SOUND = create("smooth_storage_sound");
        public static final TagKey<Block> HEAVY_STORAGE_SOUND = create("heavy_storage_sound");
        public static final TagKey<Block> MINEABLE_WITH_AXE_AND_PICKAXE = create("mineable_with_axe_and_pickaxe");

        private static TagKey<Block> create(String id) {
            return TagKey.create(Registries.BLOCK, RunicLib.customid(UrbanDecor.MOD_ID, id));
        }
    }

    public static class ItemT {
        public static final TagKey<Item> TOOLBOXES = create("toolboxes");
        public static final TagKey<Item> TOWELS = create("towels");
        public static final TagKey<Item> HAS_TOOLBOX_VARIANTS = create("has_toolbox_variants");
        public static final TagKey<Item> HAS_WRAPPED_VARIANTS = create("has_wrapped_variants");
        public static final TagKey<Item> POLYANTHOUS = create("polyanthous");
        public static final TagKey<Item> PORCELAIN = create("porcelain");

        private static TagKey<Item> create(String id) {
            return TagKey.create(Registries.ITEM, RunicLib.customid(UrbanDecor.MOD_ID, id));
        }
    }

    public static class BiomeT {
        public static final TagKey<Biome> CHERRY_POLYANTHOUS_GENERATES_IN = create("cherry_polyanthous_generates_in");
        public static final TagKey<Biome> DAFFODIL_POLYANTHOUS_GENERATES_IN = create("daffodil_polyanthous_generates_in");
        public static final TagKey<Biome> SPRING_POLYANTHOUS_GENERATES_IN = create("spring_polyanthous_generates_in");
        public static final TagKey<Biome> MINT_POLYANTHOUS_GENERATES_IN = create("mint_polyanthous_generates_in");
        public static final TagKey<Biome> AZURE_POLYANTHOUS_GENERATES_IN = create("azure_polyanthous_generates_in");
        public static final TagKey<Biome> RUBY_POLYANTHOUS_GENERATES_IN = create("ruby_polyanthous_generates_in");

        private static TagKey<Biome> create(String id) {
            return TagKey.create(Registries.BIOME, RunicLib.customid(UrbanDecor.MOD_ID, id));
        }
    }
}

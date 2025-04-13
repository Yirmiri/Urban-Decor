package net.yirmiri.urban_decor.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDTags {
    public static class Items {
        public static final TagKey<Item> FURNISHINGS = create("furnishings");
        public static final TagKey<Item> TOOLBOXES = create("toolboxes");
        public static final TagKey<Item> TOWELS = create("towels");
        public static final TagKey<Item> GLASS = create("glass");
        public static final TagKey<Item> DYES = create("dyes");
        public static final TagKey<Item> TOOLBOXABLE = create("toolboxable");
        public static final TagKey<Item> WRAPPABLE = create("wrappable");

        private static TagKey<Item> create(String id) {
            return TagKey.create(Registries.ITEM, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, id));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> TOILETS = create("toilets");

        private static TagKey<Block> create(String id) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, id));
        }
    }
}

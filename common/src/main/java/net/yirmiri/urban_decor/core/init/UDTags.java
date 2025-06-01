package net.yirmiri.urban_decor.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDTags {
    public static class BlockT {
        public static final TagKey<Block> TOILETS = create("toilets");
        public static final TagKey<Block> HAS_TOOLBOX_VARIANTS = create("has_toolbox_variants");

        private static TagKey<Block> create(String id) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, id));
        }
    }

    public static class ItemT {
        public static final TagKey<Item> TOOLBOXES = create("toolboxes");
        public static final TagKey<Item> TOWELS = create("towels");
        public static final TagKey<Item> HAS_TOOLBOX_VARIANTS = create("has_toolbox_variants");
        public static final TagKey<Item> HAS_WRAPPED_VARIANTS = create("has_wrapped_variants");

        private static TagKey<Item> create(String id) {
            return TagKey.create(Registries.ITEM, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, id));
        }
    }
}

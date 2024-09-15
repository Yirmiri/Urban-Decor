package net.yirmiri.urban_decor.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.item.ToolboxBlockItem;
import net.yirmiri.urban_decor.util.UDProperties;

public class UDItems {
    //INGREDIENTS
    public static final Item PORCELAIN = register("porcelain", new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Item DARK_PORCELAIN = register("dark_porcelain", new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Item STAINLESS_STEEL_INGOT = register("stainless_steel_ingot", new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Item STAINLESS_STEEL_NUGGET = register("stainless_steel_nugget", new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Item STEEL_PIPE = register("steel_pipe", new Item(UDProperties.ItemP.GENERIC_ITEM));

    //MISC
    public static final Item TOOLBOX = register("toolbox", new ToolboxBlockItem(UDBlocks.TOOLBOX, UDProperties.ItemP.TOOLBOX));

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UrbanDecor.MOD_ID, id), item);
    }

    public static void loadItems() {
    }
}

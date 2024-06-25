package net.yirmiri.urban_decor.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.util.UDProperties;

public class RegisterItems {
    //MISC
    public static final Item PORCELAIN = register("porcelain", new Item(UDProperties.ItemP.GENERIC_ITEM));

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UrbanDecor.MOD_ID, id), item);
    }

    public static void registerItems() {
    }
}

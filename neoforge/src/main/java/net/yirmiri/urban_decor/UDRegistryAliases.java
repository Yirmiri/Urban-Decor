package net.yirmiri.urban_decor;

import net.azurune.runiclib.RunicLib;
import net.minecraft.core.registries.BuiltInRegistries;

public class UDRegistryAliases {
    public static void load() {
        blockAlias(UrbanDecor.MOD_ID, "plastic_desk_table", UrbanDecor.MOD_ID, "porcelain_table");
        itemAlias(UrbanDecor.MOD_ID, "plastic_desk_table", UrbanDecor.MOD_ID, "porcelain_table");
    }

    private static void blockAlias(String originalModId, String originalId, String newModId, String newId) {
        BuiltInRegistries.BLOCK.addAlias(RunicLib.customid(originalModId, originalId), RunicLib.customid(newModId, newId));
    }

    private static void itemAlias(String originalModId, String originalId, String newModId, String newId) {
        BuiltInRegistries.ITEM.addAlias(RunicLib.customid(originalModId, originalId), RunicLib.customid(newModId, newId));
    }
}
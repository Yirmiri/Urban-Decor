package net.yirmiri.urban_decor.compat;

import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.compat.excessive_building.EBRegisterBlocks;

public class UDCompatRegistries {
    public static final boolean EXCESSIVE_BUILDING = UrbanDecor.isModLoaded("excessive_building");

    public static void loadCompatRegistries() {
        if (EXCESSIVE_BUILDING) EBRegisterBlocks.EBLoadBlocks();
    }
}

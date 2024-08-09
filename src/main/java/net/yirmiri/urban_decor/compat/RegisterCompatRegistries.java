package net.yirmiri.urban_decor.compat;

import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.compat.excessive_building.EBRegisterBlocks;

public class RegisterCompatRegistries {
    public static final boolean excessive_building;

    public static void loadCompatRegistries() {
        if (excessive_building) EBRegisterBlocks.ebRegisterBlocks();
    }

    static {
        excessive_building = UrbanDecor.isModLoaded("excessive_building");
    }
}

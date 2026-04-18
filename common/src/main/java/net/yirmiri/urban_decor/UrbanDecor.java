package net.yirmiri.urban_decor;

import net.yirmiri.urban_decor.core.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrbanDecor {
    public static final String MOD_ID = "urban_decor";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        UDBlocks.loadBlocks();
        UDItems.loadItems();
        UDComponents.load();
        UDMenus.load();
        UDEntities.loadEntities();
        UDCreativeTabs.loadItemGroups();
        UDSounds.loadSounds();
        UDBlockEntities.loadBlockEntities();
    }
}
//remove toolbox functionality and replace with modern system
//finish sound block
//doll in changelog
//booth shapes
//booth block makes player disappear
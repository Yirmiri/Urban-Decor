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
        UDEntities.loadEntities();
        UDItemGroups.loadItemGroups();
        UDSounds.loadSounds();
        UDBlockEntities.loadBlockEntities();
    }
}
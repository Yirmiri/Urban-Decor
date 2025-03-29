package net.yirmiri.urban_decor;

import net.yirmiri.urban_decor.core.registry.*;
import net.yirmiri.urban_decor.core.init.UDRegistries;
import net.yirmiri.urban_decor.core.init.UDStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrbanDecor {
	public static final String MOD_ID = "urban_decor";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void init() {
		UDBlocks.loadBlocks();
		UDItems.loadItems();
		UDItemGroups.loadItemGroups();
		UDBlockEntities.loadBlockEntities();
		UDSounds.loadSounds();
		UDRegistries.loadRegistries();
		UDEntities.loadEntities();
		UDStats.loadStats();
	}
}
package net.yirmiri.urban_decor;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.yirmiri.urban_decor.compat.UDCompatRegistries;
import net.yirmiri.urban_decor.compat.UDPacks;
import net.yirmiri.urban_decor.registry.*;
import net.yirmiri.urban_decor.util.UDRegistries;
import net.yirmiri.urban_decor.util.UDStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrbanDecor implements ModInitializer {
	public static final String MOD_ID = "urban_decor";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		UDBlocks.loadBlocks();
		UDItems.loadItems();
		UDItemGroups.loadItemGroups();
		UDPacks.loadPacks();
		UDCompatRegistries.loadCompatRegistries();
		UDBlockEntities.loadBlockEntities();
		UDSounds.loadSounds();
		UDRegistries.loadRegistries();
		UDEntities.loadEntities();
		UDStats.loadStats();
	}

	public static boolean isModLoaded(String id) {
		return FabricLoader.getInstance().isModLoaded(id);
	}
}
package net.yirmiri.urban_decor;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.yirmiri.urban_decor.compat.RegisterCompatRegistries;
import net.yirmiri.urban_decor.compat.RegisterPacks;
import net.yirmiri.urban_decor.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrbanDecor implements ModInitializer {
	public static final String MOD_ID = "urban_decor";
	public static final String MOD_NAME = "Urban Decor";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	@Override
	public void onInitialize() {
		RegisterBlocks.registerBlocks();
		RegisterItems.registerItems();
		RegisterItemGroups.registerItemGroups();
		RegisterPacks.registerPacks();
		RegisterCompatRegistries.registerCompatRegistries();
		RegisterBlockEntities.registerBlockEntities();
		RegisterSounds.registerSounds();
	}

	public static boolean isModLoaded(String id) {
		return FabricLoader.getInstance().isModLoaded(id);
	}
}
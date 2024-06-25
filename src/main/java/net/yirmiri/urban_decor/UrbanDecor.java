package net.yirmiri.urban_decor;

import net.fabricmc.api.ModInitializer;

import net.yirmiri.urban_decor.registry.RegisterBlocks;
import net.yirmiri.urban_decor.registry.RegisterItemGroups;
import net.yirmiri.urban_decor.registry.RegisterItems;
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
	}
}
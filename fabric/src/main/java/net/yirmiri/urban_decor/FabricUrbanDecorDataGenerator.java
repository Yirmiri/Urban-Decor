package net.yirmiri.urban_decor;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.yirmiri.urban_decor.datagen.*;

public class FabricUrbanDecorDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(UDLangProvider::new);
		pack.addProvider(UDBlockTagProvider::new);
		pack.addProvider(UDItemTagProvider::new);
		pack.addProvider(UDLootTableProvider::new);
		pack.addProvider(UDModelProvider::new);
		pack.addProvider(UDRecipeProvider::new);
	}
}

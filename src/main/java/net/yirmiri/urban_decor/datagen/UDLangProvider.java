package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.yirmiri.urban_decor.registry.RegisterBlocks;
import net.yirmiri.urban_decor.registry.RegisterItems;

public class UDLangProvider extends FabricLanguageProvider {
    public UDLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        //BLOCKS
        builder.add(RegisterBlocks.PORCELAIN_TILES, "Porcelain Tiles");
        builder.add(RegisterBlocks.PORCELAIN_TILE_STAIRS, "Porcelain Tile Stairs");
        builder.add(RegisterBlocks.PORCELAIN_TILE_SLAB, "Porcelain Tile Slab");
        builder.add(RegisterBlocks.TRASH_CAN, "Trash Can");
        builder.add(RegisterBlocks.MICROWAVE, "Microwave");
        builder.add(RegisterBlocks.SINK, "Sink");

        //ITEMS
        builder.add(RegisterItems.PORCELAIN, "Porcelain");

        //ITEM GROUPS
        builder.add("itemgroup.urban_decor", "Urban Decor");
    }
}

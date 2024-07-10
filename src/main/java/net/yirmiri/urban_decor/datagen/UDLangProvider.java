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
        builder.add(RegisterBlocks.DARK_PORCELAIN_TILES, "Dark Porcelain Tiles");
        builder.add(RegisterBlocks.DARK_PORCELAIN_TILE_STAIRS, "Dark Porcelain Tile Stairs");
        builder.add(RegisterBlocks.DARK_PORCELAIN_TILE_SLAB, "Dark Porcelain Tile Slab");
        builder.add(RegisterBlocks.CHROMITE, "Chromite");
        builder.add(RegisterBlocks.CHROMITE_STAIRS, "Chromite Stairs");
        builder.add(RegisterBlocks.CHROMITE_SLAB, "Chromite Slab");
        builder.add(RegisterBlocks.CHROMITE_WALL, "Chromite Wall");
        builder.add(RegisterBlocks.POLISHED_CHROMITE, "Polished Chromite");
        builder.add(RegisterBlocks.POLISHED_CHROMITE_STAIRS, "Polished Chromite Stairs");
        builder.add(RegisterBlocks.POLISHED_CHROMITE_SLAB, "Polished Chromite Slab");

        //APPLIANCES
        builder.add(RegisterBlocks.TRASH_CAN, "Trash Can");
        builder.add(RegisterBlocks.MICROWAVE, "Microwave");
        builder.add(RegisterBlocks.SINK, "Sink");
        builder.add(RegisterBlocks.TOILET, "Toilet");
        builder.add(RegisterBlocks.WASHING_MACHINE, "Washing Machine");
        builder.add(RegisterBlocks.DRYER, "Dryer");
        builder.add(RegisterBlocks.TOASTER, "Toaster");
        builder.add(RegisterBlocks.AIR_CONDITIONER, "Air Conditioner");

        //ITEMS
        builder.add(RegisterItems.PORCELAIN, "Porcelain");
        builder.add(RegisterItems.STAINLESS_STEEL, "Stainless Steel");
        builder.add(RegisterItems.DARK_PORCELAIN, "Dark Porcelain");

        //ITEM GROUPS
        builder.add("itemgroup.urban_decor", "Urban Decor");
    }
}

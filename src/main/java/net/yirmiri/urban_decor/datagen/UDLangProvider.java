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
        builder.add(RegisterBlocks.CHECKERED_PORCELAIN_TILES, "Checkered Porcelain Tiles");
        builder.add(RegisterBlocks.CHECKERED_PORCELAIN_TILE_STAIRS, "Checkered Porcelain Tile Stairs");
        builder.add(RegisterBlocks.CHECKERED_PORCELAIN_TILE_SLAB, "Checkered Porcelain Tile Slab");
        builder.add(RegisterBlocks.CHROMITE, "Chromite");
        builder.add(RegisterBlocks.CHROMITE_STAIRS, "Chromite Stairs");
        builder.add(RegisterBlocks.CHROMITE_SLAB, "Chromite Slab");
        builder.add(RegisterBlocks.CHROMITE_WALL, "Chromite Wall");
        builder.add(RegisterBlocks.POLISHED_CHROMITE, "Polished Chromite");
        builder.add(RegisterBlocks.POLISHED_CHROMITE_STAIRS, "Polished Chromite Stairs");
        builder.add(RegisterBlocks.POLISHED_CHROMITE_SLAB, "Polished Chromite Slab");
        builder.add(RegisterBlocks.STAINLESS_STEEL_BLOCK, "Block of Stainless Steel");

        //APPLIANCES
        builder.add(RegisterBlocks.TRASH_CAN, "Trash Can");
        builder.add(RegisterBlocks.MICROWAVE, "Microwave");
        builder.add(RegisterBlocks.SINK, "Sink");
        builder.add(RegisterBlocks.TOILET, "Toilet");
        builder.add(RegisterBlocks.WASHING_MACHINE, "Washing Machine");
        builder.add(RegisterBlocks.DRYER, "Dryer");
        builder.add(RegisterBlocks.TOASTER, "Toaster");
        builder.add(RegisterBlocks.AIR_CONDITIONER, "Air Conditioner");
        builder.add(RegisterBlocks.DESK_FAN, "Desk Fan");
        builder.add(RegisterBlocks.FAUCET, "Faucet");
        builder.add(RegisterBlocks.OVEN, "Oven");
        builder.add(RegisterBlocks.RADIATOR, "Radiator");
        builder.add(RegisterBlocks.STOVE, "Stove");
        builder.add(RegisterBlocks.FRIDGE, "Fridge");
        builder.add(RegisterBlocks.FREEZER, "Freezer");

        //ITEMS
        builder.add(RegisterItems.PORCELAIN, "Porcelain");
        builder.add(RegisterItems.STAINLESS_STEEL, "Stainless Steel");
        builder.add(RegisterItems.DARK_PORCELAIN, "Dark Porcelain");
        builder.add(RegisterItems.TOOLBOX, "Toolbox");

        //ITEM GROUPS
        builder.add("itemgroup.urban_decor", "Urban Decor");

        //TOOLTIPS
        builder.add("item.urban_decor.toolbox.use", "When Used on Blocks:");
        builder.add("item.urban_decor.toolbox.desc", "Changes The State of Some Blocks");
    }
}

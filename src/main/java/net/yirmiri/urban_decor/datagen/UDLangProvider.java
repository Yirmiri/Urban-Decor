package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.util.DyeColor;
import net.yirmiri.urban_decor.registry.UDBlocks;
import net.yirmiri.urban_decor.registry.UDEntities;
import net.yirmiri.urban_decor.registry.UDItems;
import net.yirmiri.urban_decor.util.UDStats;
import org.apache.commons.lang3.StringUtils;

public class UDLangProvider extends FabricLanguageProvider {
    public UDLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        for (DyeColor colors : DyeColor.values()) {
            String dyeString = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colors.getName(),
                    "_", " "), "gray", "Gray"), "blue", "Blue"));

            builder.add(UDBlocks.getDyedTowels(colors.getId()), dyeString + " Towel");
            builder.add(UDBlocks.getDyedTowelBarTowels(colors.getId()), dyeString + " Towel Bar");
            builder.add(UDBlocks.getDyedTowelBlocks(colors.getId()), dyeString + " Towel Block");
            builder.add(UDBlocks.getDyedPictureFrames(colors.getId()), dyeString + " Picture Frame");
        }

        //BLOCKS
        builder.add(UDBlocks.PORCELAIN_TILES, "Porcelain Tiles");
        builder.add(UDBlocks.PORCELAIN_TILE_STAIRS, "Porcelain Tile Stairs");
        builder.add(UDBlocks.PORCELAIN_TILE_SLAB, "Porcelain Tile Slab");
        builder.add(UDBlocks.DARK_PORCELAIN_TILES, "Dark Porcelain Tiles");
        builder.add(UDBlocks.DARK_PORCELAIN_TILE_STAIRS, "Dark Porcelain Tile Stairs");
        builder.add(UDBlocks.DARK_PORCELAIN_TILE_SLAB, "Dark Porcelain Tile Slab");
        builder.add(UDBlocks.CHECKERED_PORCELAIN_TILES, "Checkered Porcelain Tiles");
        builder.add(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS, "Checkered Porcelain Tile Stairs");
        builder.add(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB, "Checkered Porcelain Tile Slab");
        builder.add(UDBlocks.CHROMITE, "Chromite");
        builder.add(UDBlocks.CHROMITE_STAIRS, "Chromite Stairs");
        builder.add(UDBlocks.CHROMITE_SLAB, "Chromite Slab");
        builder.add(UDBlocks.CHROMITE_WALL, "Chromite Wall");
        builder.add(UDBlocks.POLISHED_CHROMITE, "Polished Chromite");
        builder.add(UDBlocks.POLISHED_CHROMITE_STAIRS, "Polished Chromite Stairs");
        builder.add(UDBlocks.POLISHED_CHROMITE_SLAB, "Polished Chromite Slab");
        builder.add(UDBlocks.STAINLESS_STEEL_BLOCK, "Block of Stainless Steel");
        builder.add(UDBlocks.PORCELAIN_BLOCK, "Porcelain Block");
        builder.add(UDBlocks.PORCELAIN_STAIRS, "Porcelain Stairs");
        builder.add(UDBlocks.PORCELAIN_SLAB, "Porcelain Slab");
        builder.add(UDBlocks.DARK_PORCELAIN_BLOCK, "Dark Porcelain Block");
        builder.add(UDBlocks.DARK_PORCELAIN_STAIRS, "Dark Porcelain Stairs");
        builder.add(UDBlocks.DARK_PORCELAIN_SLAB, "Dark Porcelain Slab");

        //APPLIANCES
        builder.add(UDBlocks.TRASH_CAN, "Trash Can");
        builder.add(UDBlocks.MICROWAVE, "Microwave");
        builder.add(UDBlocks.SINK, "Sink");
        builder.add(UDBlocks.TOILET, "Toilet");
        builder.add(UDBlocks.WASHING_MACHINE, "Washing Machine");
        builder.add(UDBlocks.DRYER, "Dryer");
        builder.add(UDBlocks.TOASTER, "Toaster");
        builder.add(UDBlocks.AIR_CONDITIONER, "Air Conditioner");
        builder.add(UDBlocks.DESK_FAN, "Desk Fan");
        builder.add(UDBlocks.FAUCET, "Faucet");
        builder.add(UDBlocks.OVEN, "Oven");
        builder.add(UDBlocks.RADIATOR, "Radiator");
        builder.add(UDBlocks.STOVE, "Stove");
        builder.add(UDBlocks.FRIDGE, "Fridge");
        builder.add(UDBlocks.FREEZER, "Freezer");
        builder.add(UDBlocks.TURBINE, "Turbine");
        builder.add(UDBlocks.DARK_SINK, "Dark Sink");
        builder.add(UDBlocks.DARK_TOILET, "Dark Toilet");
        builder.add(UDBlocks.DARK_WASHING_MACHINE, "Dark Washing Machine");
        builder.add(UDBlocks.DARK_DRYER, "Dark Dryer");
        builder.add(UDBlocks.DARK_FRIDGE, "Dark Fridge");
        builder.add(UDBlocks.DARK_FREEZER, "Dark Freezer");
        builder.add(UDBlocks.DARK_OVEN, "Dark Oven");
        builder.add(UDBlocks.TOWEL_BAR, "Towel Bar");
        builder.add(UDBlocks.SATELLITE_DISH, "Satellite Dish");
        builder.add(UDBlocks.SHOWER, "Shower");
        builder.add(UDBlocks.BATHTUB, "Bathtub");
        builder.add(UDBlocks.DARK_BATHTUB, "Dark Bathtub");
        builder.add(UDBlocks.RIGID_GLASS, "Rigid Glass");
        builder.add(UDBlocks.PICTURE_FRAME, "Picture Frame");
        builder.add(UDBlocks.CUPBOARD, "Cupboard");
        builder.add(UDBlocks.DARK_CUPBOARD, "Dark Cupboard");

        //ITEMS
        builder.add(UDItems.PORCELAIN, "Porcelain");
        builder.add(UDItems.STAINLESS_STEEL_INGOT, "Stainless Steel Ingot");
        builder.add(UDItems.DARK_PORCELAIN, "Dark Porcelain");
        builder.add(UDItems.TOOLBOX, "Toolbox");
        builder.add(UDItems.STEEL_PIPE, "Steel Pipe");
        builder.add(UDItems.STAINLESS_STEEL_NUGGET, "Stainless Steel Nugget");

        //STATS
        builder.add(UDStats.TIMES_SAT, "Times Sat Down");

        //ENTITIES
        builder.add(UDEntities.TOILET, "Toilet");

        //ITEM GROUPS
        builder.add("itemgroup.urban_decor", "Urban Decor");

        //TOOLTIPS
        builder.add("item.urban_decor.toolbox.use", "When Used on Blocks:");
        builder.add("item.urban_decor.toolbox.desc", "Can Change Variants of Specific Blocks");
        builder.add("tooltip.urban_decor.toolboxable", "Has toolbox variants");

        //TOOLBOX
        builder.add("toolbox.dryer.variant_true", "Variant: Transparent");
        builder.add("toolbox.dryer.variant_false", "Variant: Opaque");
        builder.add("toolbox.faucet.variant_true", "Variant: Indoor");
        builder.add("toolbox.faucet.variant_false", "Variant: Outdoor");
        builder.add("toolbox.fridge.variant_true", "Variant: Default");
        builder.add("toolbox.fridge.variant_false", "Variant: Flipped");
        builder.add("toolbox.oven.variant_true", "Variant: Transparent");
        builder.add("toolbox.oven.variant_false", "Variant: Opaque");
        builder.add("toolbox.satellite_dish.variant_true", "Variant: Grounded");
        builder.add("toolbox.satellite_dish.variant_false", "Variant: Wall Mounted");
        builder.add("toolbox.shower.variant_true", "Variant: Flat");
        builder.add("toolbox.shower.variant_false", "Variant: Cylindrical");
        builder.add("toolbox.sink.variant_2", "Variant: Slim");
        builder.add("toolbox.sink.variant_0", "Variant: Bare");
        builder.add("toolbox.sink.variant_1", "Variant: Fullsize");
        builder.add("toolbox.toilet.variant_true", "Variant: Tank");
        builder.add("toolbox.toilet.variant_false", "Variant: Commercial");
        builder.add("toolbox.trash_can.variant_2", "Variant: Mesh");
        builder.add("toolbox.trash_can.variant_0", "Variant: Solid");
        builder.add("toolbox.trash_can.variant_1", "Variant: Rectangular");
        builder.add("toolbox.washing_machine.variant_true", "Variant: Transparent");
        builder.add("toolbox.washing_machine.variant_false", "Variant: Opaque");
        builder.add("toolbox.microwave.variant_true", "Variant: Grounded");
        builder.add("toolbox.microwave.variant_false", "Variant: Wall Mounted");
        builder.add("toolbox.picture_frame.variant_true", "Variant: Grounded");
        builder.add("toolbox.picture_frame.variant_false", "Variant: Wall Mounted");
        builder.add("toolbox.cupboard.variant_3", "Variant: Fullsize");
        builder.add("toolbox.cupboard.variant_0", "Variant: Fullsize Topless");
        builder.add("toolbox.cupboard.variant_1", "Variant: Slim");
        builder.add("toolbox.cupboard.variant_2", "Variant: Slim Topless");

        //DAMAGE
        builder.add("death.attack.urban_decor.toaster", "%1$s likes to play with toasters in the tub");
        builder.add("death.attack.urban_decor.toaster.player", "%2$s toasted %1$s into a delightful breakfast");

        //SUBTITLES
        builder.add("subtitles.block.generic.activate", "Button clicks");
        builder.add("subtitles.block.appliance.open", "Appliance opens");
        builder.add("subtitles.block.appliance.close", "Appliance closes");
        builder.add("subtitles.block.toolbox.use", "Toolbox used");
        builder.add("subtitles.block.faucet.use", "Faucet turns");
        builder.add("subtitles.block.toilet.use", "Toilet flushes");
        builder.add("subtitles.block.fan.loop", "Fan spins");
        builder.add("subtitles.block.water.loop", "Water pitter patters");
        builder.add("subtitles.block.microwave.loop", "Microwave hums");
        builder.add("subtitles.block.microwave.finish", "Microwave beeps");
        builder.add("subtitles.block.satellite_dish.activate", "Satellite dish sequences");
    }
}

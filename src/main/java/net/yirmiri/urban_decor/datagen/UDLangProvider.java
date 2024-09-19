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
            builder.add(UDItems.getDyedPictureFrames(colors.getId()), dyeString + " Picture Frame");
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
        builder.add(UDBlocks.PORCELAIN_BRICKS, "Porcelain Bricks");
        builder.add(UDBlocks.PORCELAIN_BRICK_STAIRS, "Porcelain Brick Stairs");
        builder.add(UDBlocks.PORCELAIN_BRICK_SLAB, "Porcelain Brick Slab");
        builder.add(UDBlocks.DARK_PORCELAIN_BRICKS, "Dark Porcelain Bricks");
        builder.add(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS, "Dark Porcelain Brick Stairs");
        builder.add(UDBlocks.DARK_PORCELAIN_BRICK_SLAB, "Dark Porcelain Brick Slab");
        builder.add(UDBlocks.STAINLESS_STEEL_DOOR, "Stainless Steel Door");
        builder.add(UDBlocks.STAINLESS_STEEL_TRAPDOOR, "Stainless Steel Trapdoor");
        builder.add(UDBlocks.STAINLESS_STEEL_LANTERN, "Stainless Steel Lantern");
        builder.add(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN, "Stainless Steel Soul Lantern");
        builder.add(UDBlocks.STAINLESS_STEEL_BARS, "Stainless Steel Bars");

        //APPLIANCES
        builder.add(UDBlocks.TRASH_CAN, "Trash Can");
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
        builder.add(UDBlocks.SHOWER, "Shower");
        builder.add(UDBlocks.BATHTUB, "Bathtub");
        builder.add(UDBlocks.DARK_BATHTUB, "Dark Bathtub");
        builder.add(UDBlocks.RIGID_GLASS, "Rigid Glass");
        builder.add(UDBlocks.PICTURE_FRAME, "Picture Frame");
        builder.add(UDBlocks.CUPBOARD, "Cupboard");
        builder.add(UDBlocks.DARK_CUPBOARD, "Dark Cupboard");
        builder.add(UDBlocks.FILING_CABINET, "Filing Cabinet");

        //ITEMS
        builder.add(UDItems.PORCELAIN, "Porcelain");
        builder.add(UDItems.STAINLESS_STEEL_INGOT, "Stainless Steel Ingot");
        builder.add(UDItems.DARK_PORCELAIN, "Dark Porcelain");
        builder.add(UDItems.TOOLBOX, "Toolbox");
        builder.add(UDItems.STEEL_PIPE, "Steel Pipe");
        builder.add(UDItems.STAINLESS_STEEL_NUGGET, "Stainless Steel Nugget");
        builder.add(UDItems.MICROWAVE, "Microwave");
        builder.add(UDItems.SATELLITE_DISH, "Satellite Dish");

        //CONTAINERS
        builder.add("container.urban_decor.generic", "Storage Appliance");
        builder.add("container.urban_decor.furnace", "Smelting Appliance");
        builder.add("container.urban_decor.smoker", "Cooking Appliance");
        builder.add("container.urban_decor.blast_furnace", "Blasting Appliance");
        builder.add("container.urban_decor.trash", "§4Destroy Items");

        //STATS
        builder.add(UDStats.TIMES_SAT, "Times Sat Down");
        builder.add(UDStats.OPEN_APPLIANCES, "Appliances Opened");
        builder.add(UDStats.USE_FAUCET, "Faucets Used");

        //ENTITIES
        builder.add(UDEntities.TOILET, "Toilet");

        //ITEM GROUPS
        builder.add("itemgroup.urban_decor", "Urban Decor");

        //TOOLTIPS
        builder.add("item.urban_decor.toolbox.use", "When Used on Blocks:");
        builder.add("item.urban_decor.toolbox.desc", "Can Change Variants of Specific Blocks");
        builder.add("tooltip.urban_decor.toolboxable", "Has toolbox variants");
        builder.add("tooltip.urban_decor.wrappable", "Can be wrapped");

        //TOOLBOX
        builder.add("toolbox.dryer.variant_true", "Variant: Transparent");
        builder.add("toolbox.dryer.variant_false", "Variant: Opaque");
        builder.add("toolbox.faucet.variant_true", "Variant: Indoor");
        builder.add("toolbox.faucet.variant_false", "Variant: Outdoor");
        builder.add("toolbox.fridge.variant_true", "Variant: Facing Right");
        builder.add("toolbox.fridge.variant_false", "Variant: Facing Left");
        builder.add("toolbox.oven.variant_true", "Variant: Transparent");
        builder.add("toolbox.oven.variant_false", "Variant: Opaque");
        builder.add("toolbox.shower.variant_true", "Variant: Flat");
        builder.add("toolbox.shower.variant_false", "Variant: Cylindrical");
        builder.add("toolbox.sink.variant_2", "Variant: Slim");
        builder.add("toolbox.sink.variant_0", "Variant: Bare");
        builder.add("toolbox.sink.variant_1", "Variant: Large");
        builder.add("toolbox.sink.variant_3", "Variant: Fullsize");
        builder.add("toolbox.toilet.variant_true", "Variant: Tank");
        builder.add("toolbox.toilet.variant_false", "Variant: Commercial");
        builder.add("toolbox.trash_can.variant_2", "Variant: Mesh");
        builder.add("toolbox.trash_can.variant_0", "Variant: Solid");
        builder.add("toolbox.trash_can.variant_1", "Variant: Rectangular");
        builder.add("toolbox.washing_machine.variant_true", "Variant: Transparent");
        builder.add("toolbox.washing_machine.variant_false", "Variant: Opaque");
        builder.add("toolbox.cupboard.variant_3", "Variant: Fullsize");
        builder.add("toolbox.cupboard.variant_0", "Variant: Fullsize Topless");
        builder.add("toolbox.cupboard.variant_1", "Variant: Slim");
        builder.add("toolbox.cupboard.variant_2", "Variant: Slim Topless");
        builder.add("toolbox.filing_cabinet.variant_true", "Variant: Fullsize");
        builder.add("toolbox.filing_cabinet.variant_false", "Variant: Compact");
        builder.add("toolbox.radiator.variant_true", "Variant: Vertical");
        builder.add("toolbox.radiator.variant_false", "Variant: Horizontal");
        builder.add("toolbox.toilet_paper.variant_0", "Variant: Commercial");
        builder.add("toolbox.toilet_paper.variant_1", "Variant: Urban");
        builder.add("toolbox.steel_door.variant_true", "Variant: Unlocked");
        builder.add("toolbox.steel_door.variant_false", "Variant: Locked");

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

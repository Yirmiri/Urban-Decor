package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.util.DyeColor;
import net.yirmiri.urban_decor.registry.RegisterBlocks;
import net.yirmiri.urban_decor.registry.RegisterEntities;
import net.yirmiri.urban_decor.registry.RegisterItems;
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

            builder.add(RegisterBlocks.getDyedTowels(colors.getId()), dyeString + " Towel");
            builder.add(RegisterBlocks.getDyedTowelBarTowels(colors.getId()), dyeString + " Towel Bar");
            builder.add(RegisterBlocks.getDyedTowelBlocks(colors.getId()), dyeString + " Towel Block");
        }

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
        builder.add(RegisterBlocks.PORCELAIN_BLOCK, "Porcelain Block");
        builder.add(RegisterBlocks.PORCELAIN_STAIRS, "Porcelain Stairs");
        builder.add(RegisterBlocks.PORCELAIN_SLAB, "Porcelain Slab");
        builder.add(RegisterBlocks.DARK_PORCELAIN_BLOCK, "Dark Porcelain Block");
        builder.add(RegisterBlocks.DARK_PORCELAIN_STAIRS, "Dark Porcelain Stairs");
        builder.add(RegisterBlocks.DARK_PORCELAIN_SLAB, "Dark Porcelain Slab");

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
        builder.add(RegisterBlocks.TURBINE, "Turbine");
        builder.add(RegisterBlocks.DARK_SINK, "Dark Sink");
        builder.add(RegisterBlocks.DARK_TOILET, "Dark Toilet");
        builder.add(RegisterBlocks.DARK_WASHING_MACHINE, "Dark Washing Machine");
        builder.add(RegisterBlocks.DARK_DRYER, "Dark Dryer");
        builder.add(RegisterBlocks.DARK_FRIDGE, "Dark Fridge");
        builder.add(RegisterBlocks.DARK_FREEZER, "Dark Freezer");
        builder.add(RegisterBlocks.DARK_OVEN, "Dark Oven");
        builder.add(RegisterBlocks.TOWEL_BAR, "Towel Bar");
        builder.add(RegisterBlocks.SATELLITE_DISH, "Satellite Dish");
        builder.add(RegisterBlocks.SHOWER, "Shower");
        builder.add(RegisterBlocks.BATHTUB, "Bathtub");
        builder.add(RegisterBlocks.DARK_BATHTUB, "Dark Bathtub");
        builder.add(RegisterBlocks.RIGID_GLASS, "Rigid Glass");

        //ITEMS
        builder.add(RegisterItems.PORCELAIN, "Porcelain");
        builder.add(RegisterItems.STAINLESS_STEEL_INGOT, "Stainless Steel Ingot");
        builder.add(RegisterItems.DARK_PORCELAIN, "Dark Porcelain");
        builder.add(RegisterItems.TOOLBOX, "Toolbox");
        builder.add(RegisterItems.STEEL_PIPE, "Steel Pipe");
        builder.add(RegisterItems.STAINLESS_STEEL_NUGGET, "Stainless Steel Nugget");

        //STATS
        builder.add(UDStats.TIMES_SAT, "Times Sat Down");

        //ENTITIES
        builder.add(RegisterEntities.TOILET, "Toilet");

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
        builder.add("toolbox.sink.variant_2", "Variant: Default");
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

        //DAMAGE
        builder.add("death.attack.urban_decor.toaster", "%1$s likes to play with toasters in the tub");
        builder.add("death.attack.urban_decor.toaster.player", "%2$s toasted %1$s into a delight");

        //SUBTITLES
        builder.add("subtitles.block.fridge.open", "Fridge opens");
    }
}

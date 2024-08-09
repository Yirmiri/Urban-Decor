package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.DyeColor;
import net.yirmiri.urban_decor.registry.RegisterBlocks;
import net.yirmiri.urban_decor.registry.RegisterEntities;
import net.yirmiri.urban_decor.registry.RegisterItems;
import net.yirmiri.urban_decor.util.UDStats;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.CompletableFuture;

public class UDLangProvider extends FabricLanguageProvider {
    public UDLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
        super(dataGenerator, "en_us", lookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup lookup, TranslationBuilder build) {
        for (DyeColor colors : DyeColor.values()) {
            String dyeString = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colors.getName(),
                    "_", " "), "gray", "Gray"), "blue", "Blue"));

            build.add(RegisterBlocks.getDyedTowels(colors.getId()), dyeString + " Towel");
            build.add(RegisterBlocks.getDyedTowelBarTowels(colors.getId()), dyeString + " Towel Bar");
            build.add(RegisterBlocks.getDyedTowelBlocks(colors.getId()), dyeString + " Towel Block");
        }

        //BLOCKS
        build.add(RegisterBlocks.PORCELAIN_TILES, "Porcelain Tiles");
        build.add(RegisterBlocks.PORCELAIN_TILE_STAIRS, "Porcelain Tile Stairs");
        build.add(RegisterBlocks.PORCELAIN_TILE_SLAB, "Porcelain Tile Slab");
        build.add(RegisterBlocks.DARK_PORCELAIN_TILES, "Dark Porcelain Tiles");
        build.add(RegisterBlocks.DARK_PORCELAIN_TILE_STAIRS, "Dark Porcelain Tile Stairs");
        build.add(RegisterBlocks.DARK_PORCELAIN_TILE_SLAB, "Dark Porcelain Tile Slab");
        build.add(RegisterBlocks.CHECKERED_PORCELAIN_TILES, "Checkered Porcelain Tiles");
        build.add(RegisterBlocks.CHECKERED_PORCELAIN_TILE_STAIRS, "Checkered Porcelain Tile Stairs");
        build.add(RegisterBlocks.CHECKERED_PORCELAIN_TILE_SLAB, "Checkered Porcelain Tile Slab");
        build.add(RegisterBlocks.CHROMITE, "Chromite");
        build.add(RegisterBlocks.CHROMITE_STAIRS, "Chromite Stairs");
        build.add(RegisterBlocks.CHROMITE_SLAB, "Chromite Slab");
        build.add(RegisterBlocks.CHROMITE_WALL, "Chromite Wall");
        build.add(RegisterBlocks.POLISHED_CHROMITE, "Polished Chromite");
        build.add(RegisterBlocks.POLISHED_CHROMITE_STAIRS, "Polished Chromite Stairs");
        build.add(RegisterBlocks.POLISHED_CHROMITE_SLAB, "Polished Chromite Slab");
        build.add(RegisterBlocks.STAINLESS_STEEL_BLOCK, "Block of Stainless Steel");

        //APPLIANCES
        build.add(RegisterBlocks.TRASH_CAN, "Trash Can");
        build.add(RegisterBlocks.MICROWAVE, "Microwave");
        build.add(RegisterBlocks.SINK, "Sink");
        build.add(RegisterBlocks.TOILET, "Toilet");
        build.add(RegisterBlocks.WASHING_MACHINE, "Washing Machine");
        build.add(RegisterBlocks.DRYER, "Dryer");
        build.add(RegisterBlocks.TOASTER, "Toaster");
        build.add(RegisterBlocks.AIR_CONDITIONER, "Air Conditioner");
        build.add(RegisterBlocks.DESK_FAN, "Desk Fan");
        build.add(RegisterBlocks.FAUCET, "Faucet");
        build.add(RegisterBlocks.OVEN, "Oven");
        build.add(RegisterBlocks.RADIATOR, "Radiator");
        build.add(RegisterBlocks.STOVE, "Stove");
        build.add(RegisterBlocks.FRIDGE, "Fridge");
        build.add(RegisterBlocks.FREEZER, "Freezer");
        build.add(RegisterBlocks.TURBINE, "Turbine");
        build.add(RegisterBlocks.DARK_SINK, "Dark Sink");
        build.add(RegisterBlocks.DARK_TOILET, "Dark Toilet");
        build.add(RegisterBlocks.DARK_WASHING_MACHINE, "Dark Washing Machine");
        build.add(RegisterBlocks.DARK_DRYER, "Dark Dryer");
        build.add(RegisterBlocks.DARK_FRIDGE, "Dark Fridge");
        build.add(RegisterBlocks.DARK_FREEZER, "Dark Freezer");
        build.add(RegisterBlocks.DARK_OVEN, "Dark Oven");
        build.add(RegisterBlocks.TOWEL_BAR, "Towel Bar");
        build.add(RegisterBlocks.SATELLITE_DISH, "Satellite Dish");
        build.add(RegisterBlocks.SHOWER, "Shower");
        build.add(RegisterBlocks.BATHTUB, "Bathtub");
        build.add(RegisterBlocks.DARK_BATHTUB, "Dark Bathtub");
        build.add(RegisterBlocks.RIGID_GLASS, "Rigid Glass");

        //ITEMS
        build.add(RegisterItems.PORCELAIN, "Porcelain");
        build.add(RegisterItems.STAINLESS_STEEL, "Stainless Steel");
        build.add(RegisterItems.DARK_PORCELAIN, "Dark Porcelain");
        build.add(RegisterItems.TOOLBOX, "Toolbox");
        build.add(RegisterItems.STEEL_PIPE, "Steel Pipe");

        //STATS
        build.add(UDStats.TIMES_SAT, "Times Sat Down");

        //ENTITIES
        build.add(RegisterEntities.TOILET, "Toilet");

        //ITEM GROUPS
        build.add("itemgroup.urban_decor", "Urban Decor");

        //TOOLTIPS
        build.add("item.urban_decor.toolbox.use", "When Used on Blocks:");
        build.add("item.urban_decor.toolbox.desc", "Changes the State of Some Blocks");

        //TOOLBOX
        build.add("toolbox.dryer.variant_true", "Variant: Transparent");
        build.add("toolbox.dryer.variant_false", "Variant: Opaque");
        build.add("toolbox.faucet.variant_true", "Variant: Indoor");
        build.add("toolbox.faucet.variant_false", "Variant: Outdoor");
        build.add("toolbox.fridge.variant_true", "Variant: Default");
        build.add("toolbox.fridge.variant_false", "Variant: Flipped");
        build.add("toolbox.oven.variant_true", "Variant: Transparent");
        build.add("toolbox.oven.variant_false", "Variant: Opaque");
        build.add("toolbox.satellite_dish.variant_true", "Variant: Grounded");
        build.add("toolbox.satellite_dish.variant_false", "Variant: Wall Mounted");
        build.add("toolbox.shower.variant_true", "Variant: Flat");
        build.add("toolbox.shower.variant_false", "Variant: Cylindrical");
        build.add("toolbox.sink.variant_2", "Variant: Default");
        build.add("toolbox.sink.variant_0", "Variant: Bare");
        build.add("toolbox.sink.variant_1", "Variant: Fullsize");
        build.add("toolbox.toilet.variant_true", "Variant: Tank");
        build.add("toolbox.toilet.variant_false", "Variant: Commercial");
        build.add("toolbox.trash_can.variant_2", "Variant: Mesh");
        build.add("toolbox.trash_can.variant_0", "Variant: Solid");
        build.add("toolbox.trash_can.variant_1", "Variant: Rectangular");
        build.add("toolbox.washing_machine.variant_true", "Variant: Transparent");
        build.add("toolbox.washing_machine.variant_false", "Variant: Opaque");
        build.add("toolbox.microwave.variant_true", "Variant: Grounded");
        build.add("toolbox.microwave.variant_false", "Variant: Wall Mounted");

        //DAMAGE
        build.add("death.attack.urban_decor.toaster", "%1$s likes to play with toasters in the tub");
        build.add("death.attack.urban_decor.toaster.player", "%2$s toasted %1$s into a delight");

        //SUBTITLES
        build.add("subtitles.block.fridge.open", "Fridge opens");
    }
}

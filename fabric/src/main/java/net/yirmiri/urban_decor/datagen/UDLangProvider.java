package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.world.item.DyeColor;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDEntities;
import net.yirmiri.urban_decor.core.registry.UDItems;
import org.apache.commons.lang3.StringUtils;

public class UDLangProvider extends FabricLanguageProvider {
    public static final String ID = "minecraft.";
    public static final String MOD_ID = "urban_decor.";
    public static final String YT_ID = "yapping_tooltips.";

    public UDLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder build) {
        for (DyeColor colors : DyeColor.values()) {
            String dyeString = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colors.getName(),
                    "_", " "), "gray", "Gray"), "blue", "Blue"));

            build.add(UDBlocks.getDyedTowels(colors.getId()).get(), dyeString + " Towel");
            build.add(UDBlocks.getDyedTowelBarTowels(colors.getId()).get(), dyeString + " Towel Bar");
            build.add(UDBlocks.getDyedTowelBlocks(colors.getId()).get(), dyeString + " Towel Block");
            build.add(UDItems.getDyedPictureFrames(colors.getId()).get(), dyeString + " Picture Frame");
        }

        //BLOCKS
        build.add(UDBlocks.PORCELAIN_TILES.get(), "Porcelain Tiles");
        build.add(UDBlocks.PORCELAIN_TILE_STAIRS.get(), "Porcelain Tile Stairs");
        build.add(UDBlocks.PORCELAIN_TILE_SLAB.get(), "Porcelain Tile Slab");
        build.add(UDBlocks.DARK_PORCELAIN_TILES.get(), "Dark Porcelain Tiles");
        build.add(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get(), "Dark Porcelain Tile Stairs");
        build.add(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get(), "Dark Porcelain Tile Slab");
        build.add(UDBlocks.CHECKERED_PORCELAIN_TILES.get(), "Checkered Porcelain Tiles");
        build.add(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get(), "Checkered Porcelain Tile Stairs");
        build.add(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get(), "Checkered Porcelain Tile Slab");
        build.add(UDBlocks.CHROMITE.get(), "Chromite");
        build.add(UDBlocks.CHROMITE_STAIRS.get(), "Chromite Stairs");
        build.add(UDBlocks.CHROMITE_SLAB.get(), "Chromite Slab");
        build.add(UDBlocks.CHROMITE_WALL.get(), "Chromite Wall");
        build.add(UDBlocks.POLISHED_CHROMITE.get(), "Polished Chromite");
        build.add(UDBlocks.POLISHED_CHROMITE_STAIRS.get(), "Polished Chromite Stairs");
        build.add(UDBlocks.POLISHED_CHROMITE_SLAB.get(), "Polished Chromite Slab");
        build.add(UDBlocks.STAINLESS_STEEL_BLOCK.get(), "Block of Stainless Steel");
        build.add(UDBlocks.PORCELAIN_BLOCK.get(), "Porcelain Block");
        build.add(UDBlocks.PORCELAIN_STAIRS.get(), "Porcelain Stairs");
        build.add(UDBlocks.PORCELAIN_SLAB.get(), "Porcelain Slab");
        build.add(UDBlocks.DARK_PORCELAIN_BLOCK.get(), "Dark Porcelain Block");
        build.add(UDBlocks.DARK_PORCELAIN_STAIRS.get(), "Dark Porcelain Stairs");
        build.add(UDBlocks.DARK_PORCELAIN_SLAB.get(), "Dark Porcelain Slab");
        build.add(UDBlocks.PORCELAIN_BRICKS.get(), "Porcelain Bricks");
        build.add(UDBlocks.PORCELAIN_BRICK_STAIRS.get(), "Porcelain Brick Stairs");
        build.add(UDBlocks.PORCELAIN_BRICK_SLAB.get(), "Porcelain Brick Slab");
        build.add(UDBlocks.DARK_PORCELAIN_BRICKS.get(), "Dark Porcelain Bricks");
        build.add(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get(), "Dark Porcelain Brick Stairs");
        build.add(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get(), "Dark Porcelain Brick Slab");
        build.add(UDBlocks.STAINLESS_STEEL_DOOR.get(), "Stainless Steel Door");
        build.add(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get(), "Stainless Steel Trapdoor");
        build.add(UDBlocks.STAINLESS_STEEL_LANTERN.get(), "Stainless Steel Lantern");
        build.add(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get(), "Stainless Steel Soul Lantern");
        build.add(UDBlocks.STAINLESS_STEEL_BARS.get(), "Stainless Steel Bars");

        //APPLIANCES
        build.add(UDBlocks.TRASH_CAN.get(), "Trash Can");
        build.add(UDBlocks.SINK.get(), "Sink");
        build.add(UDBlocks.TOILET.get(), "Toilet");
        build.add(UDBlocks.WASHING_MACHINE.get(), "Washing Machine");
        build.add(UDBlocks.DRYER.get(), "Dryer");
        build.add(UDBlocks.TOASTER.get(), "Toaster");
        build.add(UDBlocks.AIR_CONDITIONER.get(), "Air Conditioner");
        build.add(UDBlocks.DESK_FAN.get(), "Desk Fan");
        build.add(UDBlocks.FAUCET.get(), "Faucet");
        build.add(UDBlocks.OVEN.get(), "Oven");
        build.add(UDBlocks.RADIATOR.get(), "Radiator");
        build.add(UDBlocks.STOVE.get(), "Stove");
        build.add(UDBlocks.FRIDGE.get(), "Fridge");
        build.add(UDBlocks.FREEZER.get(), "Freezer");
        build.add(UDBlocks.TURBINE.get(), "Turbine");
        build.add(UDBlocks.DARK_SINK.get(), "Dark Sink");
        build.add(UDBlocks.DARK_TOILET.get(), "Dark Toilet");
        build.add(UDBlocks.DARK_WASHING_MACHINE.get(), "Dark Washing Machine");
        build.add(UDBlocks.DARK_DRYER.get(), "Dark Dryer");
        build.add(UDBlocks.DARK_FRIDGE.get(), "Dark Fridge");
        build.add(UDBlocks.DARK_FREEZER.get(), "Dark Freezer");
        build.add(UDBlocks.DARK_OVEN.get(), "Dark Oven");
        build.add(UDBlocks.TOWEL_BAR.get(), "Towel Bar");
        build.add(UDBlocks.SHOWER.get(), "Shower");
        build.add(UDBlocks.BATHTUB.get(), "Bathtub");
        build.add(UDBlocks.DARK_BATHTUB.get(), "Dark Bathtub");
        build.add(UDBlocks.RIGID_GLASS.get(), "Rigid Glass");
        build.add(UDBlocks.PICTURE_FRAME.get(), "Picture Frame");
        build.add(UDBlocks.WALL_PICTURE_FRAME.get(), "Picture Frame");
        build.add(UDBlocks.CUPBOARD.get(), "Cupboard");
        build.add(UDBlocks.DARK_CUPBOARD.get(), "Dark Cupboard");
        build.add(UDBlocks.FILING_CABINET.get(), "Filing Cabinet");
        build.add(UDBlocks.TOILET_PAPER.get(), "Toilet Paper");
        build.add(UDBlocks.FLOOR_LAMP.get(), "Floor Lamp");
        build.add(UDBlocks.OAK_PIANO.get(), "Oak Piano");
        build.add(UDBlocks.SPRUCE_PIANO.get(), "Spruce Piano");
        build.add(UDBlocks.BIRCH_PIANO.get(), "Birch Piano");
        build.add(UDBlocks.JUNGLE_PIANO.get(), "Jungle Piano");
        build.add(UDBlocks.ACACIA_PIANO.get(), "Acacia Piano");
        build.add(UDBlocks.DARK_OAK_PIANO.get(), "Dark Oak Piano");
        build.add(UDBlocks.MANGROVE_PIANO.get(), "Mangrove Piano");
        build.add(UDBlocks.CHERRY_PIANO.get(), "Cherry Piano");
        build.add(UDBlocks.BAMBOO_PIANO.get(), "Bamboo Piano");
        build.add(UDBlocks.CRIMSON_PIANO.get(), "Crimson Piano");
        build.add(UDBlocks.WARPED_PIANO.get(), "Warped Piano");
        build.add(UDBlocks.DISHWASHER.get(), "Dishwasher");
        build.add(UDBlocks.DARK_DISHWASHER.get(), "Dark Dishwasher");

        //ITEMS
        build.add(UDItems.PORCELAIN.get(), "Porcelain");
        build.add(UDItems.STAINLESS_STEEL_INGOT.get(), "Stainless Steel Ingot");
        build.add(UDItems.DARK_PORCELAIN.get(), "Dark Porcelain");
        build.add(UDItems.TOOLBOX.get(), "Toolbox");
        build.add(UDItems.STEEL_PIPE.get(), "Steel Pipe");
        build.add(UDItems.STAINLESS_STEEL_NUGGET.get(), "Stainless Steel Nugget");
        build.add(UDItems.MICROWAVE.get(), "Microwave");
        build.add(UDItems.SATELLITE_DISH.get(), "Satellite Dish");

        //CONTAINERS
        build.add("container.urban_decor.generic", "Storage Appliance");
        build.add("container.urban_decor.furnace", "Smelting Appliance");
        build.add("container.urban_decor.smoker", "Cooking Appliance");
        build.add("container.urban_decor.blast_furnace", "Blasting Appliance");
        build.add("container.urban_decor.trash", "§4Destroy Items");

        //STATS
        build.add("stat.urban_decor.times_sat", "Sat on Appliances");
        build.add("stat.urban_decor.open_appliances", "Appliances Opened");

        //ENTITIES
        build.add(UDEntities.TOILET.get(), "Toilet");

        //ITEM GROUPS
        build.add("itemgroup.urban_decor", "Urban Decor");

        //TOOLTIPS
        build.add("item.urban_decor.toolbox.use", "When used on blocks:");
        build.add("item.urban_decor.toolbox.desc", "Can Change Variants of Specific Blocks");
        build.add("tooltip.urban_decor.toolboxable", "Has toolbox variants");
        build.add("tooltip.urban_decor.wrappable", "Can be wrapped");

        //TOOLBOX
        build.add("toolbox.dryer.variant_true", "Variant: Transparent");
        build.add("toolbox.dryer.variant_false", "Variant: Opaque");
        build.add("toolbox.faucet.variant_true", "Variant: Indoor");
        build.add("toolbox.faucet.variant_false", "Variant: Outdoor");
        build.add("toolbox.fridge.variant_true", "Variant: Facing Right");
        build.add("toolbox.fridge.variant_false", "Variant: Facing Left");
        build.add("toolbox.oven.variant_true", "Variant: Transparent");
        build.add("toolbox.oven.variant_false", "Variant: Opaque");
        build.add("toolbox.shower.variant_true", "Variant: Flat");
        build.add("toolbox.shower.variant_false", "Variant: Cylindrical");
        build.add("toolbox.sink.variant_0", "Variant: Bare");
        build.add("toolbox.sink.variant_1", "Variant: Cupboard");
        build.add("toolbox.sink.variant_2", "Variant: Fullsize");
        build.add("toolbox.sink.variant_3", "Variant: Slim");
        build.add("toolbox.toilet.variant_true", "Variant: Tank");
        build.add("toolbox.toilet.variant_false", "Variant: Commercial");
        build.add("toolbox.trash_can.variant_2", "Variant: Mesh");
        build.add("toolbox.trash_can.variant_0", "Variant: Solid");
        build.add("toolbox.trash_can.variant_1", "Variant: Rectangular");
        build.add("toolbox.washing_machine.variant_true", "Variant: Transparent");
        build.add("toolbox.washing_machine.variant_false", "Variant: Opaque");
        build.add("toolbox.cupboard.variant_3", "Variant: Fullsize");
        build.add("toolbox.cupboard.variant_0", "Variant: Fullsize Topless");
        build.add("toolbox.cupboard.variant_1", "Variant: Slim");
        build.add("toolbox.cupboard.variant_2", "Variant: Slim Topless");
        build.add("toolbox.filing_cabinet.variant_true", "Variant: Fullsize");
        build.add("toolbox.filing_cabinet.variant_false", "Variant: Compact");
        build.add("toolbox.radiator.variant_true", "Variant: Vertical");
        build.add("toolbox.radiator.variant_false", "Variant: Horizontal");
        build.add("toolbox.toilet_paper.variant_0", "Variant: Commercial");
        build.add("toolbox.toilet_paper.variant_1", "Variant: Urban");
        build.add("toolbox.steel_door.variant_true", "Variant: Unlocked");
        build.add("toolbox.steel_door.variant_false", "Variant: Locked");
        build.add("toolbox.turbine.variant_0", "Variant: Non-Vented");
        build.add("toolbox.turbine.variant_1", "Variant: Vent");
        build.add("toolbox.floor_lamp.variant_true", "Variant: Free");
        build.add("toolbox.floor_lamp.variant_false", "Variant: Shade");

        //DAMAGE
        build.add("death.attack.urban_decor.toaster", "%1$s likes to play with hot toasters");
        build.add("death.attack.urban_decor.toaster.player", "%2$s toasted %1$s into a delight!");
        build.add("death.attack.urban_decor.wet_toaster", "%1$s likes to play with toasters in the water");
        build.add("death.attack.urban_decor.wet_toaster.player", "%2$s electrocuted %1$s with a toaster in the water");

        //SUBTITLES
        build.add("subtitles.block.generic.activate", "Button clicks");
        build.add("subtitles.block.appliance.open", "Appliance opens");
        build.add("subtitles.block.appliance.close", "Appliance closes");
        build.add("subtitles.block.toolbox.use", "Toolbox used");
        build.add("subtitles.block.faucet.use", "Faucet turns");
        build.add("subtitles.block.toilet.use", "Toilet flushes");
        build.add("subtitles.block.fan.loop", "Fan spins");
        build.add("subtitles.block.water.loop", "Water pitter patters");
        build.add("subtitles.block.microwave.loop", "Microwave hums");
        build.add("subtitles.block.microwave.finish", "Microwave beeps");
        build.add("subtitles.block.satellite_dish.activate", "Satellite dish sequences");
        build.add("subtitles.block.wrap.use", "Appliance wrapped");

        //YAPPING TOOLTIPS COMPAT
        build.add(YT_ID + "item." + MOD_ID + "porcelain.desc", "A mixture of clay and flint, used commonly in appliances");
        build.add(YT_ID + "item." + MOD_ID + "dark_porcelain.desc", "A mixture of clay and flint, used commonly in appliances");
        build.add(YT_ID + "item." + MOD_ID + "stainless_steel_ingot.desc", "A mixture of coal and iron, used commonly in appliances");
        build.add(YT_ID + "item." + MOD_ID + "stainless_steel_nugget.desc", "A piece of a stainless steel ingot");
        build.add(YT_ID + "item." + MOD_ID + "steel_pipe.desc", "A steel pipe that can be placed, used commonly in appliances");
        build.add(YT_ID + "block." + MOD_ID + "porcelain_block.desc", "A smooth block constructed from porcelain");
        build.add(YT_ID + "block." + MOD_ID + "porcelain_stairs.desc", "Smooth stairs constructed from porcelain");
        build.add(YT_ID + "block." + MOD_ID + "porcelain_slab.desc", "Smooth slabs constructed from porcelain");
        build.add(YT_ID + "block." + MOD_ID + "porcelain_bricks.desc", "Porcelain compacted into bricks");
        build.add(YT_ID + "block." + MOD_ID + "porcelain_brick_stairs.desc", "Smooth stairs constructed from porcelain bricks");
        build.add(YT_ID + "block." + MOD_ID + "porcelain_brick_slab.desc", "Smooth slabs constructed from porcelain bricks");
        build.add(YT_ID + "block." + MOD_ID + "porcelain_tiles.desc", "Porcelain compacted into tiles");
        build.add(YT_ID + "block." + MOD_ID + "porcelain_tile_stairs.desc", "Smooth stairs constructed from porcelain tiles");
        build.add(YT_ID + "block." + MOD_ID + "porcelain_tile_slab.desc", "Smooth slabs constructed from porcelain tiles");
        build.add(YT_ID + "block." + MOD_ID + "dark_porcelain_block.desc", "A smooth block constructed from dark porcelain");
        build.add(YT_ID + "block." + MOD_ID + "dark_porcelain_stairs.desc", "Smooth stairs constructed from dark porcelain");
        build.add(YT_ID + "block." + MOD_ID + "dark_porcelain_slab.desc", "Smooth slabs constructed from dark porcelain");
        build.add(YT_ID + "block." + MOD_ID + "dark_porcelain_bricks.desc", "Dark porcelain compacted into bricks");
        build.add(YT_ID + "block." + MOD_ID + "dark_porcelain_brick_stairs.desc", "Smooth stairs constructed from dark porcelain bricks");
        build.add(YT_ID + "block." + MOD_ID + "dark_porcelain_brick_slab.desc", "Smooth slabs constructed from dark porcelain bricks");
        build.add(YT_ID + "block." + MOD_ID + "dark_porcelain_tiles.desc", "Dark porcelain compacted into tiles");
        build.add(YT_ID + "block." + MOD_ID + "dark_porcelain_tile_stairs.desc", "Smooth stairs constructed from dark porcelain tiles");
        build.add(YT_ID + "block." + MOD_ID + "dark_porcelain_tile_slab.desc", "Smooth slabs constructed from dark porcelain tiles");
        build.add(YT_ID + "block." + MOD_ID + "checkered_porcelain_tiles.desc", "Light and dark porcelain compacted into tiles");
        build.add(YT_ID + "block." + MOD_ID + "checkered_porcelain_tile_stairs.desc", "Smooth stairs constructed from checkered porcelain tiles");
        build.add(YT_ID + "block." + MOD_ID + "checkered_porcelain_tile_slab.desc", "Smooth slabs constructed from checkered porcelain tiles");
        build.add(YT_ID + "block." + MOD_ID + "chromite.desc", "Used to make steel tougher and more resistant, found in clusters throughout the Overworld");
        build.add(YT_ID + "block." + MOD_ID + "chromite_stairs.desc", "Rough stairs constructed from chromite");
        build.add(YT_ID + "block." + MOD_ID + "chromite_slab.desc", "Rough slabs constructed from chromite");
        build.add(YT_ID + "block." + MOD_ID + "polished_chromite.desc", "A block of chromite that has been polished");
        build.add(YT_ID + "block." + MOD_ID + "polished_chromite_stairs.desc", "Smooth stairs constructed from polished chromite");
        build.add(YT_ID + "block." + MOD_ID + "polished_chromite_slab.desc", "Smooth slabs constructed from polished chromite");
        build.add(YT_ID + "block." + MOD_ID + "stainless_steel_block.desc", "A metal block constructed from a collection of stainless steel");
        build.add(YT_ID + "block." + MOD_ID + "stainless_steel_door.desc", "This would be strange for a home.");
        build.add(YT_ID + "block." + MOD_ID + "stainless_steel_trapdoor.desc", "Actually extremely great at it's job");
        build.add(YT_ID + "block." + MOD_ID + "stainless_steel_lantern.desc", "A simple source of light");
        build.add(YT_ID + "block." + MOD_ID + "stainless_steel_soul_lantern.desc", "Souls keep the flame ablaze");
        build.add(YT_ID + "block." + MOD_ID + "stainless_steel_bars.desc", "Keeps the criminals out.");
        build.add(YT_ID + "block." + MOD_ID + "rigid_glass.desc", "A reinforced piece of glass that can be placed at the edge of a block");

        build.add(YT_ID + "block." + MOD_ID + "toolbox.desc", "Ah man, you cut the knob!");
        build.add(YT_ID + "block." + MOD_ID + "filing_cabinet.desc", "Back to my crappy 9 to 5...");
        build.add(YT_ID + "block." + MOD_ID + "cupboard.desc", "Not to be confused with a cabinet");
        build.add(YT_ID + "block." + MOD_ID + "dark_cupboard.desc", "Not to be confused with a cabinet");
        build.add(YT_ID + "block." + MOD_ID + "sink.desc", "Let that sink in!");
        build.add(YT_ID + "block." + MOD_ID + "dark_sink.desc", "Let that sink in!");
        build.add(YT_ID + "block." + MOD_ID + "toilet.desc", "A throne of porcelain only to be sat on by the most magnificent");
        build.add(YT_ID + "block." + MOD_ID + "dark_toilet.desc", "A throne of porcelain only to be sat on by the most magnificent");
        build.add(YT_ID + "block." + MOD_ID + "bathtub.desc", "Cold or warm baths?");
        build.add(YT_ID + "block." + MOD_ID + "dark_bathtub.desc", "Warm or cold baths?");
        build.add(YT_ID + "block." + MOD_ID + "washing_machine.desc", "We are not responsible for discoloration of washed fabrics");
        build.add(YT_ID + "block." + MOD_ID + "dark_washing_machine.desc", "We are not responsible for discoloration of washed fabrics");
        build.add(YT_ID + "block." + MOD_ID + "dryer.desc", "We are not responsible for discoloration of dried fabrics");
        build.add(YT_ID + "block." + MOD_ID + "dark_dryer.desc", "We are not responsible for discoloration of dried fabrics");
        build.add(YT_ID + "block." + MOD_ID + "fridge.desc", "Perfect storage for midnight snacks!");
        build.add(YT_ID + "block." + MOD_ID + "dark_fridge.desc", "Perfect storage for midnight snacks!");
        build.add(YT_ID + "block." + MOD_ID + "freezer.desc", "Chill out with the jokes this isn't a joke mod");
        build.add(YT_ID + "block." + MOD_ID + "dark_freezer.desc", "Chill out with the jokes this isn't a joke mod");
        build.add(YT_ID + "block." + MOD_ID + "oven.desc", "All Aperture technologies remain safely operational up to 4000 degrees kelvin");
        build.add(YT_ID + "block." + MOD_ID + "dark_oven.desc", "All Aperture technologies remain safely operational up to 4000 degrees kelvin");
        build.add(YT_ID + "block." + MOD_ID + "stove.desc", "Not actually used to heat anything...");
        build.add(YT_ID + "block." + MOD_ID + "toaster.desc", "Works 6x more effectively in water");
        build.add(YT_ID + "item." + MOD_ID + "microwave.desc", "My god what are you doing!");
        build.add(YT_ID + "block." + MOD_ID + "shower.desc", "Yes, the shower water is drinkable...");
        build.add(YT_ID + "block." + MOD_ID + "faucet.desc", "Not recommended to drink from... that doesn't mean you can't");
        build.add(YT_ID + "block." + MOD_ID + "trash_can.desc", "Oh hi thanks for checking in, I'm still a piece of garbage");
        build.add(YT_ID + "block." + MOD_ID + "desk_fan.desc", "Fun Fact: The fan in the original game Five Night's at Freddy's is just a GIF");
        build.add(YT_ID + "item." + MOD_ID + "satellite_dish.desc", "Pending Transmission... \"╎ᒲ!¡ᒷリ↸in⊣\"");
        build.add(YT_ID + "block." + MOD_ID + "turbine.desc", "I won't lie I ran out of things to write at the point of this one");
        build.add(YT_ID + "block." + MOD_ID + "air_conditioner.desc", "Cold to the touch...");
        build.add(YT_ID + "block." + MOD_ID + "radiator.desc", "Hot to the touch...");
        build.add(YT_ID + "block." + MOD_ID + "towel_bar.desc", "Can be used to hang towels on");
        build.add(YT_ID + "block." + MOD_ID + "floor_lamp.desc", "A tall lamp that can illuminate the surrounding area");
        build.add(YT_ID + "block." + MOD_ID + "oak_piano.desc", "A wooden instrument constructed from oak planks");
        build.add(YT_ID + "block." + MOD_ID + "spruce_piano.desc", "A wooden instrument constructed from spruce planks");
        build.add(YT_ID + "block." + MOD_ID + "birch_piano.desc", "A wooden instrument constructed from birch planks");
        build.add(YT_ID + "block." + MOD_ID + "jungle_piano.desc", "A wooden instrument constructed from jungle planks");
        build.add(YT_ID + "block." + MOD_ID + "acacia_piano.desc", "A wooden instrument constructed from acacia planks");
        build.add(YT_ID + "block." + MOD_ID + "dark_oak_piano.desc", "A wooden instrument constructed from dark oak planks");
        build.add(YT_ID + "block." + MOD_ID + "mangrove_piano.desc", "A wooden instrument constructed from mangrove planks");
        build.add(YT_ID + "block." + MOD_ID + "cherry_piano.desc", "A wooden instrument constructed from cherry planks");
        build.add(YT_ID + "block." + MOD_ID + "bamboo_piano.desc", "A wooden instrument constructed from bamboo planks");
        build.add(YT_ID + "block." + MOD_ID + "crimson_piano.desc", "A wooden instrument constructed from crimson planks");
        build.add(YT_ID + "block." + MOD_ID + "warped_piano.desc", "A wooden instrument constructed from warped planks");
        build.add(YT_ID + "block." + MOD_ID + "dishwasher.desc", "A dishwasher but with what dishes to wash?");
        build.add(YT_ID + "block." + MOD_ID + "dark_dishwasher.desc", "A dishwasher but with what dishes to wash?");

        for (DyeColor colors : DyeColor.values()) {
            String dyeString = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colors.getName(),
                    "_", " "), "gray", "Gray"), "blue", "Blue"));

            build.add(YT_ID + "block." + MOD_ID + UDBlocks.getDyedTowelBlocks(colors.getId()) + ".desc", "You would think you would use towels to make these but you don't");
            build.add(YT_ID + "block." + MOD_ID + UDBlocks.getDyedTowels(colors.getId()) + ".desc", "Tellio totally had a fun time making the models for this :)");
            build.add(YT_ID + "block." + MOD_ID + UDBlocks.getDyedPictureBlocks(colors.getId()) + ".desc", "A small picture dyed " + dyeString + ", used to cozy up a home!");
        }
    }
}

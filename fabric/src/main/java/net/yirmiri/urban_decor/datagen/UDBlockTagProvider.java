package net.yirmiri.urban_decor.datagen;

import net.azurune.runiclib.RunicLib;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.util.WrapColor;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDBlocks;

import java.util.concurrent.CompletableFuture;

public class UDBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public UDBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
        super(output, future);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(UDTags.BlockT.MINEABLE_WITH_AXE_AND_PICKAXE)
                .add(UDBlocks.POLYPROPYLENE_BLOCK.get())
                .add(UDBlocks.PLASTIC_CHAIR.get())
                .add(UDBlocks.WALL_CLOCK.get())
                .add(UDBlocks.SEWING_MACHINE.get())
                .add(UDBlocks.FOLDABLE_SIGN.get())
                .add(UDBlocks.STAPLER.get())
        ;

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(UDTags.BlockT.MINEABLE_WITH_AXE_AND_PICKAXE)
                .add(UDBlocks.PORCELAIN_TABLE.get())
                .add(UDBlocks.STAINLESS_STEEL_CHAIR.get())
                .add(UDBlocks.DARK_PORCELAIN_BLOCK.get())
                .add(UDBlocks.DARK_PORCELAIN_STAIRS.get())
                .add(UDBlocks.DARK_PORCELAIN_SLAB.get())
                .add(UDBlocks.PORCELAIN_BLOCK.get())
                .add(UDBlocks.PORCELAIN_STAIRS.get())
                .add(UDBlocks.PORCELAIN_SLAB.get())
                .add(UDBlocks.PORCELAIN_TILES.get())
                .add(UDBlocks.PORCELAIN_TILE_STAIRS.get())
                .add(UDBlocks.PORCELAIN_TILE_SLAB.get())
                .add(UDBlocks.DARK_PORCELAIN_TILES.get())
                .add(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get())
                .add(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get())
                .add(UDBlocks.CHECKERED_PORCELAIN_TILES.get())
                .add(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get())
                .add(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get())
                .add(UDBlocks.MICROWAVE.get())
                .add(UDBlocks.SINK.get())
                .add(UDBlocks.STAINLESS_STEEL_DEPOSIT.get())
                .add(UDBlocks.CHROMITE.get())
                .add(UDBlocks.CHROMITE_STAIRS.get())
                .add(UDBlocks.CHROMITE_SLAB.get())
                .add(UDBlocks.CHROMITE_WALL.get())
                .add(UDBlocks.POLISHED_CHROMITE.get())
                .add(UDBlocks.POLISHED_CHROMITE_STAIRS.get())
                .add(UDBlocks.POLISHED_CHROMITE_SLAB.get())
                .add(UDBlocks.TOILET.get())
                .add(UDBlocks.WASHING_MACHINE.get())
                .add(UDBlocks.DRYER.get())
                .add(UDBlocks.TOASTER.get())
                .add(UDBlocks.AIR_CONDITIONER.get())
                .add(UDBlocks.DESK_FAN.get())
                .add(UDBlocks.TOOLBOX.get())
                .add(UDBlocks.FAUCET.get())
                .add(UDBlocks.STAINLESS_STEEL_BLOCK.get())
                .add(UDBlocks.OVEN.get())
                .add(UDBlocks.RADIATOR.get())
                .add(UDBlocks.STOVE.get())
                .add(UDBlocks.FRIDGE.get())
                .add(UDBlocks.FREEZER.get())
                .add(UDBlocks.TURBINE.get())
                .add(UDBlocks.DARK_DRYER.get())
                .add(UDBlocks.DARK_FRIDGE.get())
                .add(UDBlocks.DARK_FREEZER.get())
                .add(UDBlocks.DARK_SINK.get())
                .add(UDBlocks.DARK_TOILET.get())
                .add(UDBlocks.DARK_WASHING_MACHINE.get())
                .add(UDBlocks.DARK_OVEN.get())
                .add(UDBlocks.TOWEL_BAR.get())
                .add(UDBlocks.SATELLITE_DISH.get())
                .add(UDBlocks.SHOWER.get())
                .add(UDBlocks.BATHTUB.get())
                .add(UDBlocks.DARK_BATHTUB.get())
                .add(UDBlocks.RIGID_GLASS.get())
                .add(UDBlocks.CUPBOARD.get())
                .add(UDBlocks.DARK_CUPBOARD.get())
                .add(UDBlocks.FILING_CABINET.get())
                .add(UDBlocks.WALL_MICROWAVE.get())
                .add(UDBlocks.WALL_SATELLITE_DISH.get())
                .add(UDBlocks.PORCELAIN_BRICKS.get())
                .add(UDBlocks.PORCELAIN_BRICK_STAIRS.get())
                .add(UDBlocks.PORCELAIN_BRICK_SLAB.get())
                .add(UDBlocks.DARK_PORCELAIN_BRICKS.get())
                .add(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get())
                .add(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get())
                .add(UDBlocks.STEEL_PIPE.get())
                .add(UDBlocks.STAINLESS_STEEL_DOOR.get())
                .add(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get())
                .add(UDBlocks.STAINLESS_STEEL_LANTERN.get())
                .add(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get())
                .add(UDBlocks.STAINLESS_STEEL_BARS.get())
                .add(UDBlocks.STAINLESS_STEEL_FENCE.get())
                .add(UDBlocks.FLOOR_LAMP.get())
                .add(UDBlocks.DISHWASHER.get())
                .add(UDBlocks.DARK_DISHWASHER.get())
                .add(UDBlocks.STAINLESS_STEEL_LADDER.get())
                .add(UDBlocks.CASH_REGISTER.get())
                .add(UDBlocks.DARK_CASH_REGISTER.get())
                .add(UDBlocks.VENDING_MACHINE.get())
        ;

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .addTag(UDTags.BlockT.MINEABLE_WITH_AXE_AND_PICKAXE)
                .add(UDBlocks.BOOTH.get())

                .add(UDBlocks.OAK_BOX.get())
                .add(UDBlocks.SPRUCE_BOX.get())
                .add(UDBlocks.BIRCH_BOX.get())
                .add(UDBlocks.JUNGLE_BOX.get())
                .add(UDBlocks.ACACIA_BOX.get())
                .add(UDBlocks.DARK_OAK_BOX.get())
                .add(UDBlocks.MANGROVE_BOX.get())
                .add(UDBlocks.CHERRY_BOX.get())
                .add(UDBlocks.BAMBOO_BOX.get())
                .add(UDBlocks.CRIMSON_BOX.get())
                .add(UDBlocks.WARPED_BOX.get())
                
                .add(UDBlocks.OAK_GRANDFATHER_CLOCK.get())
                .add(UDBlocks.SPRUCE_GRANDFATHER_CLOCK.get())
                .add(UDBlocks.BIRCH_GRANDFATHER_CLOCK.get())
                .add(UDBlocks.JUNGLE_GRANDFATHER_CLOCK.get())
                .add(UDBlocks.ACACIA_GRANDFATHER_CLOCK.get())
                .add(UDBlocks.DARK_OAK_GRANDFATHER_CLOCK.get())
                .add(UDBlocks.MANGROVE_GRANDFATHER_CLOCK.get())
                .add(UDBlocks.CHERRY_GRANDFATHER_CLOCK.get())
                .add(UDBlocks.BAMBOO_GRANDFATHER_CLOCK.get())
                .add(UDBlocks.CRIMSON_GRANDFATHER_CLOCK.get())
                .add(UDBlocks.WARPED_GRANDFATHER_CLOCK.get())
                
                .add(UDBlocks.OAK_PIANO.get())
                .add(UDBlocks.SPRUCE_PIANO.get())
                .add(UDBlocks.BIRCH_PIANO.get())
                .add(UDBlocks.JUNGLE_PIANO.get())
                .add(UDBlocks.ACACIA_PIANO.get())
                .add(UDBlocks.DARK_OAK_PIANO.get())
                .add(UDBlocks.MANGROVE_PIANO.get())
                .add(UDBlocks.CHERRY_PIANO.get())
                .add(UDBlocks.BAMBOO_PIANO.get())
                .add(UDBlocks.CRIMSON_PIANO.get())
                .add(UDBlocks.WARPED_PIANO.get())

                .add(UDBlocks.OAK_CALENDAR.get())
                .add(UDBlocks.SPRUCE_CALENDAR.get())
                .add(UDBlocks.BIRCH_CALENDAR.get())
                .add(UDBlocks.JUNGLE_CALENDAR.get())
                .add(UDBlocks.ACACIA_CALENDAR.get())
                .add(UDBlocks.DARK_OAK_CALENDAR.get())
                .add(UDBlocks.MANGROVE_CALENDAR.get())
                .add(UDBlocks.CHERRY_CALENDAR.get())
                .add(UDBlocks.BAMBOO_CALENDAR.get())
                .add(UDBlocks.CRIMSON_CALENDAR.get())
                .add(UDBlocks.WARPED_CALENDAR.get())
        ;

        getOrCreateTagBuilder(UDTags.BlockT.SEATS)
                .addTag(UDTags.BlockT.TOILETS)
                .add(UDBlocks.PLASTIC_CHAIR.get())
                .add(UDBlocks.STAINLESS_STEEL_CHAIR.get())
                .add(UDBlocks.PORCELAIN_TABLE.get())
                .add(UDBlocks.BOOTH.get())
        ;

        getOrCreateTagBuilder(UDTags.BlockT.TOILETS)
                .add(UDBlocks.TOILET.get())
                .add(UDBlocks.DARK_TOILET.get())
        ;

        getOrCreateTagBuilder(UDTags.BlockT.HEAVY_STORAGE_SOUND)
                .add(UDBlocks.DRYER.get())
                .add(UDBlocks.DARK_DRYER.get())
                .add(UDBlocks.FILING_CABINET.get())
                .add(UDBlocks.MICROWAVE.get())
                .add(UDBlocks.WALL_MICROWAVE.get())
                .add(UDBlocks.OVEN.get())
                .add(UDBlocks.DARK_OVEN.get())
                .add(UDBlocks.TOOLBOX.get())
                .add(UDBlocks.WASHING_MACHINE.get())
                .add(UDBlocks.DARK_WASHING_MACHINE.get())
        ;

        getOrCreateTagBuilder(UDTags.BlockT.SMOOTH_STORAGE_SOUND)
                .add(UDBlocks.CUPBOARD.get())
                .add(UDBlocks.DISHWASHER.get())
                .add(UDBlocks.DARK_CUPBOARD.get())
                .add(UDBlocks.DARK_DISHWASHER.get())
                .add(UDBlocks.FREEZER.get())
                .add(UDBlocks.DARK_FREEZER.get())
                .add(UDBlocks.FRIDGE.get())
                .add(UDBlocks.DARK_FRIDGE.get())
        ;

        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(UDBlocks.STAINLESS_STEEL_LADDER.get())
        ;

            getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_red_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_orange_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_yellow_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_lime_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_green_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_cyan_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_light_blue_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_blue_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_purple_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_magenta_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_pink_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_black_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_brown_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_white_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_gray_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_light_gray_towel"))

                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_coral_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_umber_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_canary_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_wasabi_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_sacramento_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_sky_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_blurple_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_lavender_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_sangria_towel"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "towel_bar_rose_towel"))
                    ;

        for (WrapColor colors : WrapColor.values()) {
            getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(UDBlocks.getWrappedPorcelainBlocks(colors.getId()).get())
                    .add(UDBlocks.getWrappedPorcelainStairs(colors.getId()).get())
                    .add(UDBlocks.getWrappedPorcelainSlabs(colors.getId()).get())
                    .add(UDBlocks.getWrappedPorcelainBricks(colors.getId()).get())
                    .add(UDBlocks.getWrappedPorcelainBrickStairs(colors.getId()).get())
                    .add(UDBlocks.getWrappedPorcelainBrickSlabs(colors.getId()).get())
                    .add(UDBlocks.getWrappedPorcelainTiles(colors.getId()).get())
                    .add(UDBlocks.getWrappedPorcelainTileStairs(colors.getId()).get())
                    .add(UDBlocks.getWrappedPorcelainTileSlabs(colors.getId()).get())
            ;
        }

        for (WrapColor colors : WrapColor.values()) {
            getOrCreateTagBuilder(UDTags.BlockT.POLYANTHOUS).add(UDBlocks.getWrappedPolyanthous(colors.getId()).get());
        }

        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .addTag(UDTags.BlockT.POLYANTHOUS)
        ;

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(UDBlocks.CHROMITE_WALL.get())
        ;

        getOrCreateTagBuilder(BlockTags.CAMPFIRES)
                .add(UDBlocks.TOASTER.get())
        ;

        getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
                .add(UDBlocks.PLASTIC_LIGHTS.get())
        ;

            getOrCreateTagBuilder(BlockTags.WOOL)
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "red_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "orange_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "yellow_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "lime_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "green_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "cyan_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "light_blue_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "blue_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "purple_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "magenta_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "pink_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "black_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "brown_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "white_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "gray_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "light_gray_towel_block"))

                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "coral_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "umber_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "canary_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "wasabi_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "sacramento_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "sky_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "blurple_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "lavender_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "sangria_towel_block"))
                    .addOptional(RunicLib.customid(UrbanDecor.MOD_ID, "rose_towel_block"))
            ;
    }
}

package net.yirmiri.urban_decor.core.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDItemGroups {
    public static CreativeModeTab URBAN_DECOR = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, "urban_decor"), FabricItemGroup.builder()
                    .icon(() -> new ItemStack(UDItems.TOOLBOX.get())).title(Component.translatable("itemgroup.urban_decor")).displayItems((ctx, entries) -> {
                entries.accept(UDItems.PORCELAIN.get());
                entries.accept(UDItems.DARK_PORCELAIN.get());
                entries.accept(UDItems.STAINLESS_STEEL_INGOT.get());
                entries.accept(UDItems.STAINLESS_STEEL_NUGGET.get());
                entries.accept(UDItems.STEEL_PIPE.get());

                entries.accept(UDBlocks.PORCELAIN_BLOCK.get());
                entries.accept(UDBlocks.PORCELAIN_STAIRS.get());
                entries.accept(UDBlocks.PORCELAIN_SLAB.get());

                entries.accept(UDBlocks.PORCELAIN_BRICKS.get());
                entries.accept(UDBlocks.PORCELAIN_BRICK_STAIRS.get());
                entries.accept(UDBlocks.PORCELAIN_BRICK_SLAB.get());

                entries.accept(UDBlocks.PORCELAIN_TILES.get());
                entries.accept(UDBlocks.PORCELAIN_TILE_STAIRS.get());
                entries.accept(UDBlocks.PORCELAIN_TILE_SLAB.get());

                entries.accept(UDBlocks.DARK_PORCELAIN_BLOCK.get());
                entries.accept(UDBlocks.DARK_PORCELAIN_STAIRS.get());
                entries.accept(UDBlocks.DARK_PORCELAIN_SLAB.get());

                entries.accept(UDBlocks.DARK_PORCELAIN_BRICKS.get());
                entries.accept(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get());
                entries.accept(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get());

                entries.accept(UDBlocks.DARK_PORCELAIN_TILES.get());
                entries.accept(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get());
                entries.accept(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get());

                entries.accept(UDBlocks.CHECKERED_PORCELAIN_TILES.get());
                entries.accept(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get());
                entries.accept(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get());

                entries.accept(UDBlocks.CHROMITE.get());
                entries.accept(UDBlocks.CHROMITE_STAIRS.get());
                entries.accept(UDBlocks.CHROMITE_SLAB.get());
                entries.accept(UDBlocks.CHROMITE_WALL.get());

                entries.accept(UDBlocks.POLISHED_CHROMITE.get());
                entries.accept(UDBlocks.POLISHED_CHROMITE_STAIRS.get());
                entries.accept(UDBlocks.POLISHED_CHROMITE_SLAB.get());

                entries.accept(UDBlocks.STAINLESS_STEEL_BLOCK.get());
                entries.accept(UDBlocks.STAINLESS_STEEL_DOOR.get());
                entries.accept(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get());
                entries.accept(UDBlocks.STAINLESS_STEEL_LANTERN.get());
                entries.accept(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get());
                entries.accept(UDBlocks.STAINLESS_STEEL_BARS.get());

                entries.accept(UDBlocks.RIGID_GLASS.get());

                entries.accept(UDItems.TOOLBOX.get());

                entries.accept(UDBlocks.FILING_CABINET.get());
                entries.accept(UDBlocks.CUPBOARD.get());
                entries.accept(UDBlocks.DARK_CUPBOARD.get());
                entries.accept(UDBlocks.SINK.get());
                entries.accept(UDBlocks.DARK_SINK.get());
                entries.accept(UDBlocks.TOILET.get());
                entries.accept(UDBlocks.DARK_TOILET.get());
                entries.accept(UDBlocks.TOILET_PAPER.get());
                entries.accept(UDBlocks.BATHTUB.get());
                entries.accept(UDBlocks.DARK_BATHTUB.get());
                entries.accept(UDBlocks.WASHING_MACHINE.get());
                entries.accept(UDBlocks.DARK_WASHING_MACHINE.get());
                entries.accept(UDBlocks.DRYER.get());
                entries.accept(UDBlocks.DARK_DRYER.get());
                entries.accept(UDBlocks.FRIDGE.get());
                entries.accept(UDBlocks.DARK_FRIDGE.get());
                entries.accept(UDBlocks.FREEZER.get());
                entries.accept(UDBlocks.DARK_FREEZER.get());
                entries.accept(UDBlocks.OVEN.get());
                entries.accept(UDBlocks.DARK_OVEN.get());
                entries.accept(UDBlocks.STOVE.get());
                entries.accept(UDBlocks.TOASTER.get());
                entries.accept(UDItems.MICROWAVE.get());
                entries.accept(UDBlocks.SHOWER.get());
                entries.accept(UDBlocks.FAUCET.get());
                entries.accept(UDBlocks.TRASH_CAN.get());
                entries.accept(UDBlocks.DESK_FAN.get());
                entries.accept(UDBlocks.FLOOR_LAMP.get());
                entries.accept(UDBlocks.OAK_PIANO.get());
                entries.accept(UDBlocks.SPRUCE_PIANO.get());
                entries.accept(UDBlocks.BIRCH_PIANO.get());
                entries.accept(UDBlocks.JUNGLE_PIANO.get());
                entries.accept(UDBlocks.ACACIA_PIANO.get());
                entries.accept(UDBlocks.DARK_OAK_PIANO.get());
                entries.accept(UDBlocks.MANGROVE_PIANO.get());
                entries.accept(UDBlocks.CHERRY_PIANO.get());
                entries.accept(UDBlocks.BAMBOO_PIANO.get());
                entries.accept(UDBlocks.CRIMSON_PIANO.get());
                entries.accept(UDBlocks.WARPED_PIANO.get());
                entries.accept(UDItems.SATELLITE_DISH.get());
                entries.accept(UDBlocks.TURBINE.get());
                entries.accept(UDBlocks.AIR_CONDITIONER.get());
                entries.accept(UDBlocks.RADIATOR.get());

                entries.accept(UDBlocks.TOWEL_BAR.get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.RED.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()).get());
                entries.accept(UDBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()).get());
                
                entries.accept(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.RED.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get());
                entries.accept(UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get());

                entries.accept(UDItems.PICTURE_FRAME.get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.WHITE.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.LIGHT_GRAY.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.GRAY.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.BLACK.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.BROWN.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.RED.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.ORANGE.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.YELLOW.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.LIME.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.GREEN.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.CYAN.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.LIGHT_BLUE.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.BLUE.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.PURPLE.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.MAGENTA.getId()).get());
                entries.accept(UDItems.getDyedPictureFrames(DyeColor.PINK.getId()).get());
            }).build());

    public static void loadItemGroups() {
    }
}

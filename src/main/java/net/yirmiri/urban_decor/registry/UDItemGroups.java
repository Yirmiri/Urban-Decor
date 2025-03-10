package net.yirmiri.urban_decor.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.compat.UDCompatRegistries;
import net.yirmiri.urban_decor.compat.excessive_building.EBRegisterBlocks;

public class UDItemGroups {
    public static ItemGroup URBAN_DECOR = Registry.register(Registries.ITEM_GROUP, Identifier.of(UrbanDecor.MOD_ID, "urban_decor"), FabricItemGroup.builder()
                    .icon(() -> new ItemStack(UDItems.TOOLBOX.get())).displayName(Text.translatable("itemgroup.urban_decor")).entries((ctx, entries) -> {
                entries.add(UDItems.PORCELAIN.get());
                entries.add(UDItems.DARK_PORCELAIN.get());
                entries.add(UDItems.STAINLESS_STEEL_INGOT.get());
                entries.add(UDItems.STAINLESS_STEEL_NUGGET.get());
                entries.add(UDItems.STEEL_PIPE.get());

                entries.add(UDBlocks.PORCELAIN_BLOCK.get());
                entries.add(UDBlocks.PORCELAIN_STAIRS.get());
                entries.add(UDBlocks.PORCELAIN_SLAB.get());

                entries.add(UDBlocks.PORCELAIN_BRICKS.get());
                entries.add(UDBlocks.PORCELAIN_BRICK_STAIRS.get());
                entries.add(UDBlocks.PORCELAIN_BRICK_SLAB.get());

                entries.add(UDBlocks.PORCELAIN_TILES.get());
                entries.add(UDBlocks.PORCELAIN_TILE_STAIRS.get());
                entries.add(UDBlocks.PORCELAIN_TILE_SLAB.get());

                entries.add(UDBlocks.DARK_PORCELAIN_BLOCK.get());
                entries.add(UDBlocks.DARK_PORCELAIN_STAIRS.get());
                entries.add(UDBlocks.DARK_PORCELAIN_SLAB.get());

                entries.add(UDBlocks.DARK_PORCELAIN_BRICKS.get());
                entries.add(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get());
                entries.add(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get());

                entries.add(UDBlocks.DARK_PORCELAIN_TILES.get());
                entries.add(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get());
                entries.add(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get());

                entries.add(UDBlocks.CHECKERED_PORCELAIN_TILES.get());
                entries.add(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get());
                entries.add(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get());

                entries.add(UDBlocks.CHROMITE.get());
                entries.add(UDBlocks.CHROMITE_STAIRS.get());
                entries.add(UDBlocks.CHROMITE_SLAB.get());
                entries.add(UDBlocks.CHROMITE_WALL.get());

                entries.add(UDBlocks.POLISHED_CHROMITE.get());
                entries.add(UDBlocks.POLISHED_CHROMITE_STAIRS.get());
                entries.add(UDBlocks.POLISHED_CHROMITE_SLAB.get());

                entries.add(UDBlocks.STAINLESS_STEEL_BLOCK.get());
                entries.add(UDBlocks.STAINLESS_STEEL_DOOR.get());
                entries.add(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get());
                entries.add(UDBlocks.STAINLESS_STEEL_LANTERN.get());
                entries.add(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get());
                entries.add(UDBlocks.STAINLESS_STEEL_BARS.get());

                entries.add(UDBlocks.RIGID_GLASS.get());

                entries.add(UDItems.TOOLBOX.get());

                entries.add(UDBlocks.FILING_CABINET.get());
                entries.add(UDBlocks.CUPBOARD.get());
                entries.add(UDBlocks.DARK_CUPBOARD.get());
                entries.add(UDBlocks.SINK.get());
                entries.add(UDBlocks.DARK_SINK.get());
                entries.add(UDBlocks.TOILET.get());
                entries.add(UDBlocks.DARK_TOILET.get());
                entries.add(UDBlocks.TOILET_PAPER.get());
                entries.add(UDBlocks.BATHTUB.get());
                entries.add(UDBlocks.DARK_BATHTUB.get());
                entries.add(UDBlocks.WASHING_MACHINE.get());
                entries.add(UDBlocks.DARK_WASHING_MACHINE.get());
                entries.add(UDBlocks.DRYER.get());
                entries.add(UDBlocks.DARK_DRYER.get());
                entries.add(UDBlocks.FRIDGE.get());
                entries.add(UDBlocks.DARK_FRIDGE.get());
                entries.add(UDBlocks.FREEZER.get());
                entries.add(UDBlocks.DARK_FREEZER.get());
                entries.add(UDBlocks.OVEN.get());
                entries.add(UDBlocks.DARK_OVEN.get());
                entries.add(UDBlocks.STOVE.get());
                entries.add(UDBlocks.TOASTER.get());
                entries.add(UDItems.MICROWAVE.get());
                entries.add(UDBlocks.SHOWER.get());
                entries.add(UDBlocks.FAUCET.get());
                entries.add(UDBlocks.TRASH_CAN.get());
                entries.add(UDBlocks.DESK_FAN.get());
                entries.add(UDBlocks.FLOOR_LAMP.get());
                entries.add(UDBlocks.OAK_PIANO.get());
                entries.add(UDBlocks.SPRUCE_PIANO.get());
                entries.add(UDBlocks.BIRCH_PIANO.get());
                entries.add(UDBlocks.JUNGLE_PIANO.get());
                entries.add(UDBlocks.ACACIA_PIANO.get());
                entries.add(UDBlocks.DARK_OAK_PIANO.get());
                entries.add(UDBlocks.MANGROVE_PIANO.get());
                entries.add(UDBlocks.CHERRY_PIANO.get());
                entries.add(UDBlocks.BAMBOO_PIANO.get());
                entries.add(UDBlocks.CRIMSON_PIANO.get());
                entries.add(UDBlocks.WARPED_PIANO.get());
                entries.add(UDItems.SATELLITE_DISH.get());
                entries.add(UDBlocks.TURBINE.get());
                entries.add(UDBlocks.AIR_CONDITIONER.get());
                entries.add(UDBlocks.RADIATOR.get());

                entries.add(UDBlocks.TOWEL_BAR.get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.RED.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()).get());
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()).get());
                
                entries.add(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.RED.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get());
                entries.add(UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get());

                entries.add(UDItems.PICTURE_FRAME.get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.WHITE.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.LIGHT_GRAY.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.GRAY.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.BLACK.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.BROWN.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.RED.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.ORANGE.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.YELLOW.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.LIME.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.GREEN.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.CYAN.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.LIGHT_BLUE.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.BLUE.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.PURPLE.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.MAGENTA.getId()).get());
                entries.add(UDItems.getDyedPictureFrames(DyeColor.PINK.getId()).get());

                if (UDCompatRegistries.EXCESSIVE_BUILDING) {
                    entries.add(EBRegisterBlocks.PORCELAIN_TILE_VERTICAL_STAIRS.get());
                    entries.add(EBRegisterBlocks.DARK_PORCELAIN_TILE_VERTICAL_STAIRS.get());
                    entries.add(EBRegisterBlocks.CHECKERED_PORCELAIN_TILE_VERTICAL_STAIRS.get());
                    entries.add(EBRegisterBlocks.CHROMITE_VERTICAL_STAIRS.get());
                    entries.add(EBRegisterBlocks.POLISHED_CHROMITE_VERTICAL_STAIRS.get());
                }
            }).build());

    public static void loadItemGroups() {
    }
}

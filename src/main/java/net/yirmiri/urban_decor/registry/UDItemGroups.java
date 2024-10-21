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
                    .icon(() -> new ItemStack(UDItems.TOOLBOX)).displayName(Text.translatable("itemgroup.urban_decor")).entries((ctx, entries) -> {
                entries.add(UDItems.PORCELAIN);
                entries.add(UDItems.DARK_PORCELAIN);
                entries.add(UDItems.STAINLESS_STEEL_INGOT);
                entries.add(UDItems.STAINLESS_STEEL_NUGGET);
                entries.add(UDItems.STEEL_PIPE);

                entries.add(UDBlocks.PORCELAIN_BLOCK);
                entries.add(UDBlocks.PORCELAIN_STAIRS);
                entries.add(UDBlocks.PORCELAIN_SLAB);

                entries.add(UDBlocks.PORCELAIN_BRICKS);
                entries.add(UDBlocks.PORCELAIN_BRICK_STAIRS);
                entries.add(UDBlocks.PORCELAIN_BRICK_SLAB);

                entries.add(UDBlocks.PORCELAIN_TILES);
                entries.add(UDBlocks.PORCELAIN_TILE_STAIRS);
                entries.add(UDBlocks.PORCELAIN_TILE_SLAB);

                entries.add(UDBlocks.DARK_PORCELAIN_BLOCK);
                entries.add(UDBlocks.DARK_PORCELAIN_STAIRS);
                entries.add(UDBlocks.DARK_PORCELAIN_SLAB);

                entries.add(UDBlocks.DARK_PORCELAIN_BRICKS);
                entries.add(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS);
                entries.add(UDBlocks.DARK_PORCELAIN_BRICK_SLAB);

                entries.add(UDBlocks.DARK_PORCELAIN_TILES);
                entries.add(UDBlocks.DARK_PORCELAIN_TILE_STAIRS);
                entries.add(UDBlocks.DARK_PORCELAIN_TILE_SLAB);

                entries.add(UDBlocks.CHECKERED_PORCELAIN_TILES);
                entries.add(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS);
                entries.add(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB);

                entries.add(UDBlocks.CHROMITE);
                entries.add(UDBlocks.CHROMITE_STAIRS);
                entries.add(UDBlocks.CHROMITE_SLAB);
                entries.add(UDBlocks.CHROMITE_WALL);

                entries.add(UDBlocks.POLISHED_CHROMITE);
                entries.add(UDBlocks.POLISHED_CHROMITE_STAIRS);
                entries.add(UDBlocks.POLISHED_CHROMITE_SLAB);

                entries.add(UDBlocks.STAINLESS_STEEL_BLOCK);
                entries.add(UDBlocks.STAINLESS_STEEL_DOOR);
                entries.add(UDBlocks.STAINLESS_STEEL_TRAPDOOR);
                entries.add(UDBlocks.STAINLESS_STEEL_LANTERN);
                entries.add(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN);
                entries.add(UDBlocks.STAINLESS_STEEL_BARS);

                entries.add(UDBlocks.RIGID_GLASS);

                entries.add(UDItems.TOOLBOX);

                entries.add(UDBlocks.FILING_CABINET);
                entries.add(UDBlocks.CUPBOARD);
                entries.add(UDBlocks.DARK_CUPBOARD);
                entries.add(UDBlocks.SINK);
                entries.add(UDBlocks.DARK_SINK);
                entries.add(UDBlocks.TOILET);
                entries.add(UDBlocks.DARK_TOILET);
                entries.add(UDBlocks.BATHTUB);
                entries.add(UDBlocks.DARK_BATHTUB);
                entries.add(UDBlocks.WASHING_MACHINE);
                entries.add(UDBlocks.DARK_WASHING_MACHINE);
                entries.add(UDBlocks.DRYER);
                entries.add(UDBlocks.DARK_DRYER);
                entries.add(UDBlocks.FRIDGE);
                entries.add(UDBlocks.DARK_FRIDGE);
                entries.add(UDBlocks.FREEZER);
                entries.add(UDBlocks.DARK_FREEZER);
                entries.add(UDBlocks.OVEN);
                entries.add(UDBlocks.DARK_OVEN);
                entries.add(UDBlocks.STOVE);
                entries.add(UDBlocks.TOASTER);
                entries.add(UDItems.MICROWAVE);
                entries.add(UDBlocks.SHOWER);
                entries.add(UDBlocks.FAUCET);
                entries.add(UDBlocks.TRASH_CAN);
                entries.add(UDBlocks.DESK_FAN);
                entries.add(UDItems.SATELLITE_DISH);
                entries.add(UDBlocks.TURBINE);
                entries.add(UDBlocks.AIR_CONDITIONER);
                entries.add(UDBlocks.RADIATOR);

                entries.add(UDBlocks.TOWEL_BAR);
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.RED.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()));
                entries.add(UDBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()));
                
                entries.add(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.RED.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.LIME.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()));
                entries.add(UDBlocks.getDyedTowels(DyeColor.PINK.getId()));

                entries.add(UDItems.PICTURE_FRAME);
                entries.add(UDItems.getDyedPictureFrames(DyeColor.WHITE.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.LIGHT_GRAY.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.GRAY.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.BLACK.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.BROWN.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.RED.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.ORANGE.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.YELLOW.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.LIME.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.GREEN.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.CYAN.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.LIGHT_BLUE.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.BLUE.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.PURPLE.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.MAGENTA.getId()));
                entries.add(UDItems.getDyedPictureFrames(DyeColor.PINK.getId()));

                if (UDCompatRegistries.EXCESSIVE_BUILDING) {
                    entries.add(EBRegisterBlocks.PORCELAIN_TILE_VERTICAL_STAIRS);
                    entries.add(EBRegisterBlocks.DARK_PORCELAIN_TILE_VERTICAL_STAIRS);
                    entries.add(EBRegisterBlocks.CHECKERED_PORCELAIN_TILE_VERTICAL_STAIRS);
                    entries.add(EBRegisterBlocks.CHROMITE_VERTICAL_STAIRS);
                    entries.add(EBRegisterBlocks.POLISHED_CHROMITE_VERTICAL_STAIRS);
                }
            }).build());

    public static void loadItemGroups() {
    }
}

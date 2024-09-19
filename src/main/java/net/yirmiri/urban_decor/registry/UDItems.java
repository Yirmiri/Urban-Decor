package net.yirmiri.urban_decor.registry;

import net.minecraft.item.Item;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.item.ToolboxBlockItem;
import net.yirmiri.urban_decor.util.UDProperties;

import java.util.HashMap;

public class UDItems {
    //INGREDIENTS
    public static final Item PORCELAIN = register("porcelain", new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Item DARK_PORCELAIN = register("dark_porcelain", new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Item STAINLESS_STEEL_INGOT = register("stainless_steel_ingot", new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Item STAINLESS_STEEL_NUGGET = register("stainless_steel_nugget", new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Item STEEL_PIPE = register("steel_pipe", new Item(UDProperties.ItemP.GENERIC_ITEM));

    //BLOCK ITEMS
    public static final Item TOOLBOX = register("toolbox", new ToolboxBlockItem(UDBlocks.TOOLBOX, UDProperties.ItemP.TOOLBOX));
    public static final Item MICROWAVE = register("microwave", new VerticallyAttachableBlockItem(UDBlocks.MICROWAVE, UDBlocks.WALL_MICROWAVE, UDProperties.ItemP.GENERIC_ITEM, Direction.DOWN));
    public static final Item SATELLITE_DISH = register("satellite_dish", new VerticallyAttachableBlockItem(UDBlocks.SATELLITE_DISH, UDBlocks.WALL_SATELLITE_DISH, UDProperties.ItemP.GENERIC_ITEM, Direction.DOWN));

    //DYED ITEMS
    public static final HashMap<DyeColor, Item> DYED_PICTURE_FRAMES = new HashMap<>();

    public static final Item PICTURE_FRAME = register("picture_frame", new VerticallyAttachableBlockItem(UDBlocks.PICTURE_FRAME, UDBlocks.WALL_PICTURE_FRAME, UDProperties.ItemP.GENERIC_ITEM, Direction.DOWN));

    static {
        for (DyeColor colors : DyeColor.values()) {
            DYED_PICTURE_FRAMES.put(colors, register(colors + "_picture_frame", new VerticallyAttachableBlockItem(
                    UDBlocks.getDyedPictureBlocks(colors.getId()), UDBlocks.getDyedWallPictureBlocks(colors.getId()), UDProperties.ItemP.GENERIC_ITEM, Direction.DOWN)));
        }
    }

    public static Item getDyedPictureFrames(int colors){
        return DYED_PICTURE_FRAMES.get(DyeColor.byId(colors));
    }

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UrbanDecor.MOD_ID, id), item);
    }

    public static void loadItems() {
    }
}

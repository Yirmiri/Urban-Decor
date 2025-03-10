package net.yirmiri.urban_decor.registry;

import net.azurune.tipsylib.platform.Services;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.item.ToolboxBlockItem;
import net.yirmiri.urban_decor.util.UDProperties;

import java.util.HashMap;
import java.util.function.Supplier;

public class UDItems {
    //INGREDIENTS
    public static final Supplier<Item> PORCELAIN = register("porcelain", () -> new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Supplier<Item> DARK_PORCELAIN = register("dark_porcelain", () -> new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Supplier<Item> STAINLESS_STEEL_INGOT = register("stainless_steel_ingot", () -> new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Supplier<Item> STAINLESS_STEEL_NUGGET = register("stainless_steel_nugget", () -> new Item(UDProperties.ItemP.GENERIC_ITEM));
    public static final Supplier<Item> STEEL_PIPE = register("steel_pipe", () -> new BlockItem(UDBlocks.STEEL_PIPE.get(), UDProperties.ItemP.GENERIC_ITEM));

    //BLOCK ITEMS
    public static final Supplier<Item> TOOLBOX = register("toolbox", () -> new ToolboxBlockItem(UDBlocks.TOOLBOX.get(), UDProperties.ItemP.TOOLBOX));
    public static final Supplier<Item> MICROWAVE = register("microwave", () -> new VerticallyAttachableBlockItem(UDBlocks.MICROWAVE.get(), UDBlocks.WALL_MICROWAVE.get(), UDProperties.ItemP.GENERIC_ITEM, Direction.DOWN));
    public static final Supplier<Item> SATELLITE_DISH = register("satellite_dish", () -> new VerticallyAttachableBlockItem(UDBlocks.SATELLITE_DISH.get(), UDBlocks.WALL_SATELLITE_DISH.get(), UDProperties.ItemP.GENERIC_ITEM, Direction.DOWN));

    //DYED ITEMS
    public static final HashMap<DyeColor, Supplier<Item>> DYED_PICTURE_FRAMES = new HashMap<>();

    public static final Supplier<Item> PICTURE_FRAME = register("picture_frame", () -> new VerticallyAttachableBlockItem(UDBlocks.PICTURE_FRAME.get(), UDBlocks.WALL_PICTURE_FRAME.get(), UDProperties.ItemP.GENERIC_ITEM, Direction.DOWN));

    static {
        for (DyeColor colors : DyeColor.values()) {
            DYED_PICTURE_FRAMES.put(colors, register(colors + "_picture_frame", () -> new VerticallyAttachableBlockItem(
                    UDBlocks.getDyedPictureBlocks(colors.getId()).get(), UDBlocks.getDyedWallPictureBlocks(colors.getId()).get(), UDProperties.ItemP.GENERIC_ITEM, Direction.DOWN)));
        }
    }

    public static Supplier<Item> getDyedPictureFrames(int colors){
        return DYED_PICTURE_FRAMES.get(DyeColor.byId(colors));
    }

    public static Supplier<Item> register(String id, Supplier<Item> supplier) {
        return Services.REGISTRY.registerItem(UrbanDecor.MOD_ID, id, supplier);
    }

    public static void loadItems() {
    }
}

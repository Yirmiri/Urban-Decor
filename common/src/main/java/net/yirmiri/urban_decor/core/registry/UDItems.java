package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.core.platform.RLServices;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.item.ToolboxBlockItem;
import net.yirmiri.urban_decor.common.item.WrapItem;
import net.yirmiri.urban_decor.common.util.UDProperties;
import net.yirmiri.urban_decor.common.util.WrapColor;

import java.util.HashMap;
import java.util.function.Supplier;

public class UDItems {
    //MISC
    public static final Supplier<Item> SEWING_NEEDLE = register("sewing_needle", () -> new Item(UDProperties.ItemP.GENERIC_UC_1));

    //INGREDIENTS
    public static final Supplier<Item> PORCELAIN = register("porcelain", () -> new Item(UDProperties.ItemP.GENERIC));
    public static final Supplier<Item> DARK_PORCELAIN = register("dark_porcelain", () -> new Item(UDProperties.ItemP.GENERIC));
    public static final Supplier<Item> STAINLESS_STEEL_INGOT = register("stainless_steel_ingot", () -> new Item(UDProperties.ItemP.GENERIC));
    public static final Supplier<Item> STAINLESS_STEEL_NUGGET = register("stainless_steel_nugget", () -> new Item(UDProperties.ItemP.GENERIC));
    public static final Supplier<Item> STEEL_PIPE = register("steel_pipe", () -> new BlockItem(UDBlocks.STEEL_PIPE.get(), UDProperties.ItemP.GENERIC));
    public static final Supplier<Item> POLYPROPYLENE = register("polypropylene", () -> new Item(UDProperties.ItemP.GENERIC));

    //BLOCK ITEMS
    public static final Supplier<Item> TOOLBOX = register("toolbox", () -> new ToolboxBlockItem(UDBlocks.TOOLBOX.get(), UDProperties.ItemP.GENERIC_1));
    public static final Supplier<Item> MICROWAVE = register("microwave", () -> new StandingAndWallBlockItem(UDBlocks.MICROWAVE.get(), UDBlocks.WALL_MICROWAVE.get(), UDProperties.ItemP.GENERIC, Direction.DOWN));
    public static final Supplier<Item> SATELLITE_DISH = register("satellite_dish", () -> new StandingAndWallBlockItem(UDBlocks.SATELLITE_DISH.get(), UDBlocks.WALL_SATELLITE_DISH.get(), UDProperties.ItemP.GENERIC, Direction.DOWN));

    //WRAPPED
    public static final HashMap<WrapColor, Supplier<Item>> WRAPPED_WRAPS = new HashMap<>();

    static {
        for (WrapColor colors : WrapColor.values()) {
            WRAPPED_WRAPS.put(colors, register(colors + "_wrap", () -> new WrapItem(UDProperties.ItemP.GENERIC, colors)));
        }
    }

    public static Supplier<Item> getWrappedWraps(int colors){
        return WRAPPED_WRAPS.get(WrapColor.byId(colors));
    }

    //DYED ITEMS
    public static final HashMap<DyeColor, Supplier<Item>> DYED_PICTURE_FRAMES = new HashMap<>();

    public static final Supplier<Item> PICTURE_FRAME = register("picture_frame", () -> new StandingAndWallBlockItem(UDBlocks.PICTURE_FRAME.get(), UDBlocks.WALL_PICTURE_FRAME.get(), UDProperties.ItemP.GENERIC, Direction.DOWN));

    static {
        for (DyeColor colors : DyeColor.values()) {
            DYED_PICTURE_FRAMES.put(colors, register(colors + "_picture_frame", () -> new StandingAndWallBlockItem(
                    UDBlocks.getDyedPictureBlocks(colors.getId()).get(), UDBlocks.getDyedWallPictureBlocks(colors.getId()).get(), UDProperties.ItemP.GENERIC, Direction.DOWN)));
        }
    }

    public static Supplier<Item> getDyedPictureFrames(int colors){
        return DYED_PICTURE_FRAMES.get(DyeColor.byId(colors));
    }

    public static Supplier<Item> register(String id, Supplier<Item> supplier) {
        return RLServices.REGISTRY.registerItem(UrbanDecor.MOD_ID, id, supplier);
    }

    public static void loadItems() {
    }
}

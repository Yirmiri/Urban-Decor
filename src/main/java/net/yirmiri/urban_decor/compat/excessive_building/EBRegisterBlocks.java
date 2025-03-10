package net.yirmiri.urban_decor.compat.excessive_building;

import net.minecraft.block.Block;
import net.yirmiri.urban_decor.registry.UDBlocks;
import net.yirmiri.urban_decor.util.UDProperties;

import java.util.function.Supplier;

public class EBRegisterBlocks {

    //VERTICAL STAIRS
    public static final Supplier<Block> PORCELAIN_TILE_VERTICAL_STAIRS = UDBlocks.register("porcelain_tile_vertical_stairs", () -> new ExcessiveBuildingVerticalStairs(UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> CHROMITE_VERTICAL_STAIRS = UDBlocks.register("chromite_vertical_stairs", () -> new ExcessiveBuildingVerticalStairs(UDProperties.BlockP.CHROMITE), true);
    public static final Supplier<Block> POLISHED_CHROMITE_VERTICAL_STAIRS = UDBlocks.register("polished_chromite_vertical_stairs", () -> new ExcessiveBuildingVerticalStairs(UDProperties.BlockP.POLISHED_CHROMITE), true);
    public static final Supplier<Block> DARK_PORCELAIN_TILE_VERTICAL_STAIRS = UDBlocks.register("dark_porcelain_tile_vertical_stairs", () -> new ExcessiveBuildingVerticalStairs(UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Supplier<Block> CHECKERED_PORCELAIN_TILE_VERTICAL_STAIRS = UDBlocks.register("checkered_porcelain_tile_vertical_stairs", () -> new ExcessiveBuildingVerticalStairs(UDProperties.BlockP.PORCELAIN), true);

    public static void EBLoadBlocks() {
    }
}

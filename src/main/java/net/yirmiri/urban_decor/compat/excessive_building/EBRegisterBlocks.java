package net.yirmiri.urban_decor.compat.excessive_building;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.util.UDProperties;

public class EBRegisterBlocks {

    //VERTICAL STAIRS
    public static final Block PORCELAIN_TILE_VERTICAL_STAIRS = register("porcelain_tile_vertical_stairs", new ExcessiveBuildingVerticalStairs(UDProperties.BlockP.PORCELAIN), true);
    public static final Block CHROMITE_VERTICAL_STAIRS = register("chromite_vertical_stairs", new ExcessiveBuildingVerticalStairs(UDProperties.BlockP.CHROMITE), true);
    public static final Block POLISHED_CHROMITE_VERTICAL_STAIRS = register("polished_chromite_vertical_stairs", new ExcessiveBuildingVerticalStairs(UDProperties.BlockP.POLISHED_CHROMITE), true);
    public static final Block DARK_PORCELAIN_TILE_VERTICAL_STAIRS = register("dark_porcelain_tile_vertical_stairs", new ExcessiveBuildingVerticalStairs(UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Block CHECKERED_PORCELAIN_TILE_VERTICAL_STAIRS = register("checkered_porcelain_tile_vertical_stairs", new ExcessiveBuildingVerticalStairs(UDProperties.BlockP.PORCELAIN), true);

    private static Block register(String id, Block block, boolean registerItem) {
        if (registerItem) {
            registerBlockItem(id, block);
        }
        return Registry.register(Registries.BLOCK, Identifier.of(UrbanDecor.MOD_ID, id), block);
    }

    private static Item registerBlockItem(String id, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(UrbanDecor.MOD_ID, id), new BlockItem(block, new Item.Settings()));
    }

    public static void ebRegisterBlocks() {
    }
}

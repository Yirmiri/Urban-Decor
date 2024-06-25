package net.yirmiri.urban_decor.registry;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.block.MicrowaveBlock;
import net.yirmiri.urban_decor.block.SinkBlock;
import net.yirmiri.urban_decor.block.TrashCanBlock;
import net.yirmiri.urban_decor.util.UDProperties;

public class RegisterBlocks {

    //BLOCKS
    public static final Block PORCELAIN_TILES = register("porcelain_tiles", new Block(UDProperties.BlockP.PORCELAIN), true);
    public static final Block PORCELAIN_TILE_STAIRS = register("porcelain_tile_stairs", new StairsBlock(PORCELAIN_TILES.getDefaultState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Block PORCELAIN_TILE_SLAB = register("porcelain_tile_slab", new SlabBlock(UDProperties.BlockP.PORCELAIN), true);

    //DECOR
    public static final Block TRASH_CAN = register("trash_can", new TrashCanBlock(UDProperties.BlockP.TRASH_CAN), true);
    public static final Block MICROWAVE = register("microwave", new MicrowaveBlock(UDProperties.BlockP.MICROWAVE), true);
    public static final Block SINK = register("sink", new SinkBlock(UDProperties.BlockP.SINK), true);

    private static Block register(String id, Block block, boolean registerItem) {
        if (registerItem) {
            registerBlockItem(id, block);
        }
        return Registry.register(Registries.BLOCK, Identifier.of(UrbanDecor.MOD_ID, id), block);
    }

    private static Item registerBlockItem(String id, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(UrbanDecor.MOD_ID, id), new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
    }
}

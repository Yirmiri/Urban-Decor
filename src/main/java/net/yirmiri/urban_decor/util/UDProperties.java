package net.yirmiri.urban_decor.util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

public class UDProperties {
    public static class BlockP {
        //BLOCKS
        public static final Block.Settings PORCELAIN = FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings CHROMITE = FabricBlockSettings.copyOf(Blocks.GRANITE).mapColor(MapColor.GRAY);
        public static final Block.Settings POLISHED_CHROMITE = FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE).mapColor(MapColor.GRAY);

        //DECOR
        public static final Block.Settings TRASH_CAN = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.LANTERN).pistonBehavior(PistonBehavior.BLOCK);
        public static final Block.Settings MICROWAVE = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(1.0F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.LANTERN).pistonBehavior(PistonBehavior.BLOCK);
        public static final Block.Settings SINK = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
    }

    public static class ItemP {
        //MISC
        public static final Item.Settings GENERIC_ITEM = new Item.Settings();
    }
}

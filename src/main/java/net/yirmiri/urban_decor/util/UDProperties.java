package net.yirmiri.urban_decor.util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.yirmiri.urban_decor.registry.UDItems;

import java.util.function.ToIntFunction;

public class UDProperties {
    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> (Boolean)state.get(Properties.LIT) ? litLevel : 0;
    }

    public static class BlockP {
        //BLOCKS
        public static final Block.Settings PORCELAIN = FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings DARK_PORCELAIN = FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.BLACK).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings CHROMITE = FabricBlockSettings.copyOf(Blocks.GRANITE).mapColor(MapColor.TERRACOTTA_CYAN);
        public static final Block.Settings POLISHED_CHROMITE = FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE).mapColor(MapColor.TERRACOTTA_CYAN);
        public static final Block.Settings RIGID_GLASS = FabricBlockSettings.copyOf(Blocks.GLASS).hardness(0.8F).resistance(0.8F);
        public static final Block.Settings STAINLESS_STEEL = FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.COPPER);
        public static final Block.Settings STEEL_LANTERN = FabricBlockSettings.copyOf(Blocks.LANTERN).sounds(BlockSoundGroup.COPPER);
        public static final Block.Settings STEEL_SOUL_LANTERN = FabricBlockSettings.copyOf(Blocks.SOUL_LANTERN).sounds(BlockSoundGroup.COPPER);
        public static final Block.Settings STEEL_PIPE = FabricBlockSettings.copyOf(Blocks.CHAIN).sounds(BlockSoundGroup.COPPER);
        public static final Block.Settings STEEL_BARS = FabricBlockSettings.copyOf(Blocks.IRON_BARS).sounds(BlockSoundGroup.COPPER);
        public static final Block.Settings STEEL_DOOR = FabricBlockSettings.copyOf(Blocks.IRON_DOOR).sounds(BlockSoundGroup.COPPER);
        public static final Block.Settings STEEL_TRAPDOOR = FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR).sounds(BlockSoundGroup.COPPER);

        //DECOR
        public static final Block.Settings TRASH_CAN = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.LANTERN);
        public static final Block.Settings MICROWAVE = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.8F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.LANTERN);
        public static final Block.Settings SINK = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings TOILET = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings WASHING_MACHINE = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings DRYER = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings TOASTER = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.LANTERN).pistonBehavior(PistonBehavior.BLOCK);
        public static final Block.Settings DESK_FAN = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.LANTERN);
        public static final Block.Settings OVEN = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings STOVE = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.LANTERN);
        public static final Block.Settings FRIDGE = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings FREEZER = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings BATHTUB = FabricBlockSettings.copyOf(Blocks.STONE).strength(2.0F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings PICTURE_FRAME = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).noCollision().strength(0.3F).sounds(BlockSoundGroup.WOOD);
        public static final Block.Settings CUPBOARD = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.CALCITE).requiresTool();
        public static final Block.Settings FILING_CABINET = FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(3.0F).sounds(BlockSoundGroup.COPPER);
        public static final Block.Settings TOILET_PAPER = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.LANTERN);
        public static final Block.Settings FLOOR_LAMP = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).luminance(createLightLevelFromLitBlockState(15)).breakInstantly().mapColor(MapColor.GRAY).sounds(BlockSoundGroup.LANTERN);
        public static final Block.Settings PIANO = FabricBlockSettings.copyOf(Blocks.OAK_PLANKS);
        public static final Block.Settings NETHER_PIANO = FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS);
        public static final Block.Settings CHERRY_PIANO = FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS);
        public static final Block.Settings BAMBOO_PIANO = FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS);

        //MISC APPLIANCES
        public static final Block.Settings AIR_CONDITIONER = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.LANTERN).requiresTool();
        public static final Block.Settings TOOLBOX = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.RED).sounds(BlockSoundGroup.LANTERN);
        public static final Block.Settings FAUCET = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.COPPER);
        public static final Block.Settings RADIATOR = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.WHITE).sounds(BlockSoundGroup.COPPER).requiresTool();
        public static final Block.Settings TURBINE = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.COPPER);
        public static final Block.Settings TOWEL_BAR = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.COPPER);
        public static final Block.Settings SATELLITE_DISH = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.COPPER).collidable(false);
        public static final Block.Settings SHOWER = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.COPPER);
    }

    public static class ItemP {
        //MISC
        public static final Item.Settings GENERIC_ITEM = new Item.Settings();
        public static final Item.Settings TOOLBOX = new Item.Settings().maxCount(1);
    }
}

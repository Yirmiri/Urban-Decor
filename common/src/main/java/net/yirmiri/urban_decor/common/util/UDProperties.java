package net.yirmiri.urban_decor.common.util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.ToIntFunction;

public class UDProperties {
    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> (Boolean)state.getValue(BlockStateProperties.LIT) ? litLevel : 0;
    }

    public static class BlockP {
        //BLOCKS
        public static final Block.Settings PORCELAIN = FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings DARK_PORCELAIN = FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.COLOR_BLACK).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings CHROMITE = FabricBlockSettings.copyOf(Blocks.GRANITE).mapColor(MapColor.TERRACOTTA_CYAN);
        public static final Block.Settings POLISHED_CHROMITE = FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE).mapColor(MapColor.TERRACOTTA_CYAN);
        public static final Block.Settings RIGID_GLASS = FabricBlockSettings.copyOf(Blocks.GLASS).destroyTime(0.8F).explosionResistance(0.8F);
        public static final Block.Settings STAINLESS_STEEL = FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sound(SoundType.COPPER);
        public static final Block.Settings STEEL_LANTERN = FabricBlockSettings.copyOf(Blocks.LANTERN).sound(SoundType.COPPER);
        public static final Block.Settings STEEL_SOUL_LANTERN = FabricBlockSettings.copyOf(Blocks.SOUL_LANTERN).sound(SoundType.COPPER);
        public static final Block.Settings STEEL_PIPE = FabricBlockSettings.copyOf(Blocks.CHAIN).sound(SoundType.COPPER);
        public static final Block.Settings STEEL_BARS = FabricBlockSettings.copyOf(Blocks.IRON_BARS).sound(SoundType.COPPER);
        public static final Block.Settings STEEL_DOOR = FabricBlockSettings.copyOf(Blocks.IRON_DOOR).sound(SoundType.COPPER);
        public static final Block.Settings STEEL_TRAPDOOR = FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR).sound(SoundType.COPPER);

        //DECOR
        public static final Block.Settings TRASH_CAN = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final Block.Settings MICROWAVE = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.8F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final Block.Settings SINK = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings TOILET = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings WASHING_MACHINE = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings DRYER = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings TOASTER = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN).pushReaction(PushReaction.BLOCK);
        public static final Block.Settings DESK_FAN = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final Block.Settings OVEN = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings STOVE = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final Block.Settings FRIDGE = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings FREEZER = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings BATHTUB = FabricBlockSettings.copyOf(Blocks.STONE).strength(2.0F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings PICTURE_FRAME = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).noCollission().strength(0.3F).sound(SoundType.WOOD);
        public static final Block.Settings CUPBOARD = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final Block.Settings FILING_CABINET = FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(3.0F).sound(SoundType.COPPER);
        public static final Block.Settings TOILET_PAPER = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final Block.Settings FLOOR_LAMP = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).lightLevel(createLightLevelFromLitBlockState(15)).instabreak().mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final Block.Settings PIANO = FabricBlockSettings.copyOf(Blocks.OAK_PLANKS);
        public static final Block.Settings NETHER_PIANO = FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS);
        public static final Block.Settings CHERRY_PIANO = FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS);
        public static final Block.Settings BAMBOO_PIANO = FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS);

        //MISC APPLIANCES
        public static final Block.Settings AIR_CONDITIONER = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN).requiresCorrectToolForDrops();
        public static final Block.Settings TOOLBOX = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.COLOR_RED).sound(SoundType.LANTERN);
        public static final Block.Settings FAUCET = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.COPPER);
        public static final Block.Settings RADIATOR = FabricBlockSettings.copyOf(Blocks.STONE).strength(1.0F).mapColor(MapColor.SNOW).sound(SoundType.COPPER).requiresCorrectToolForDrops();
        public static final Block.Settings TURBINE = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.COPPER);
        public static final Block.Settings TOWEL_BAR = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.COPPER);
        public static final Block.Settings SATELLITE_DISH = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.COPPER).collidable(false);
        public static final Block.Settings SHOWER = FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.COPPER);
    }

    public static class ItemP {
        //MISC
        public static final Item.Properties GENERIC_ITEM = new Item.Properties();
        public static final Item.Properties TOOLBOX = new Item.Properties().stacksTo(1);
    }
}

package net.yirmiri.urban_decor.common.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
        public static final BlockBehaviour.Properties PORCELAIN = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties DARK_PORCELAIN = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.COLOR_BLACK).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties CHROMITE = BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE).mapColor(MapColor.TERRACOTTA_CYAN);
        public static final BlockBehaviour.Properties POLISHED_CHROMITE = BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE).mapColor(MapColor.TERRACOTTA_CYAN);
        public static final BlockBehaviour.Properties RIGID_GLASS = BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).destroyTime(0.8F).explosionResistance(0.8F);
        public static final BlockBehaviour.Properties STAINLESS_STEEL = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.COPPER);
        public static final BlockBehaviour.Properties STEEL_LANTERN = BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).sound(SoundType.COPPER);
        public static final BlockBehaviour.Properties STEEL_SOUL_LANTERN = BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_LANTERN).sound(SoundType.COPPER);
        public static final BlockBehaviour.Properties STEEL_PIPE = BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN).sound(SoundType.COPPER);
        public static final BlockBehaviour.Properties STEEL_BARS = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS).sound(SoundType.COPPER);
        public static final BlockBehaviour.Properties STEEL_DOOR = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).sound(SoundType.COPPER);
        public static final BlockBehaviour.Properties STEEL_TRAPDOOR = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR).sound(SoundType.COPPER);

        //DECOR
        public static final BlockBehaviour.Properties TRASH_CAN = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final BlockBehaviour.Properties MICROWAVE = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.8F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final BlockBehaviour.Properties SINK = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.0F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties TOILET = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.0F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties WASHING_MACHINE = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties DRYER = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties TOASTER = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN).pushReaction(PushReaction.BLOCK);
        public static final BlockBehaviour.Properties DESK_FAN = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final BlockBehaviour.Properties OVEN = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties STOVE = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final BlockBehaviour.Properties FRIDGE = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties FREEZER = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties BATHTUB = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(2.0F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties PICTURE_FRAME = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).noCollission().strength(0.3F).sound(SoundType.WOOD);
        public static final BlockBehaviour.Properties CUPBOARD = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.0F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties FILING_CABINET = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(3.0F).sound(SoundType.COPPER);
        public static final BlockBehaviour.Properties TOILET_PAPER = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final BlockBehaviour.Properties FLOOR_LAMP = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).lightLevel(createLightLevelFromLitBlockState(15)).instabreak().mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN);
        public static final BlockBehaviour.Properties PIANO = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
        public static final BlockBehaviour.Properties NETHER_PIANO = BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS);
        public static final BlockBehaviour.Properties CHERRY_PIANO = BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS);
        public static final BlockBehaviour.Properties BAMBOO_PIANO = BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS);
        public static final BlockBehaviour.Properties DISHWASHER = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.5F).mapColor(MapColor.SNOW).sound(SoundType.CALCITE).requiresCorrectToolForDrops();

        //MISC APPLIANCES
        public static final BlockBehaviour.Properties AIR_CONDITIONER = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.0F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties TOOLBOX = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.COLOR_RED).sound(SoundType.LANTERN);
        public static final BlockBehaviour.Properties FAUCET = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.COPPER);
        public static final BlockBehaviour.Properties RADIATOR = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.0F).mapColor(MapColor.SNOW).sound(SoundType.COPPER).requiresCorrectToolForDrops();
        public static final BlockBehaviour.Properties TURBINE = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.COPPER);
        public static final BlockBehaviour.Properties TOWEL_BAR = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.COPPER);
        public static final BlockBehaviour.Properties SATELLITE_DISH = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.5F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.COPPER).noCollission();
        public static final BlockBehaviour.Properties SHOWER = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.3F).mapColor(MapColor.COLOR_GRAY).sound(SoundType.COPPER);
    }

    public static class ItemP {
        //MISC
        public static final Item.Properties GENERIC_ITEM = new Item.Properties();
        public static final Item.Properties TOOLBOX = new Item.Properties().stacksTo(1);
    }
}

package net.yirmiri.urban_decor.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.block.*;
import net.yirmiri.urban_decor.util.UDProperties;

import java.util.HashMap;

public class UDBlocks {

    //BLOCKS
    public static final Block PORCELAIN_BLOCK = register("porcelain_block", new Block(UDProperties.BlockP.PORCELAIN), true);
    public static final Block PORCELAIN_STAIRS = register("porcelain_stairs", new StairsBlock(PORCELAIN_BLOCK.getDefaultState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Block PORCELAIN_SLAB = register("porcelain_slab", new SlabBlock(UDProperties.BlockP.PORCELAIN), true);

    public static final Block DARK_PORCELAIN_BLOCK = register("dark_porcelain_block", new Block(UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Block DARK_PORCELAIN_STAIRS = register("dark_porcelain_stairs", new StairsBlock(DARK_PORCELAIN_BLOCK.getDefaultState(), UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Block DARK_PORCELAIN_SLAB = register("dark_porcelain_slab", new SlabBlock(UDProperties.BlockP.DARK_PORCELAIN), true);

    public static final Block PORCELAIN_TILES = register("porcelain_tiles", new Block(UDProperties.BlockP.PORCELAIN), true);
    public static final Block PORCELAIN_TILE_STAIRS = register("porcelain_tile_stairs", new StairsBlock(PORCELAIN_TILES.getDefaultState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Block PORCELAIN_TILE_SLAB = register("porcelain_tile_slab", new SlabBlock(UDProperties.BlockP.PORCELAIN), true);

    public static final Block DARK_PORCELAIN_TILES = register("dark_porcelain_tiles", new Block(UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Block DARK_PORCELAIN_TILE_STAIRS = register("dark_porcelain_tile_stairs", new StairsBlock(DARK_PORCELAIN_TILES.getDefaultState(), UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Block DARK_PORCELAIN_TILE_SLAB = register("dark_porcelain_tile_slab", new SlabBlock(UDProperties.BlockP.DARK_PORCELAIN), true);

    public static final Block CHECKERED_PORCELAIN_TILES = register("checkered_porcelain_tiles", new Block(UDProperties.BlockP.PORCELAIN), true);
    public static final Block CHECKERED_PORCELAIN_TILE_STAIRS = register("checkered_porcelain_tile_stairs", new StairsBlock(CHECKERED_PORCELAIN_TILES.getDefaultState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Block CHECKERED_PORCELAIN_TILE_SLAB = register("checkered_porcelain_tile_slab", new SlabBlock(UDProperties.BlockP.PORCELAIN), true);

    public static final Block CHROMITE = register("chromite", new Block(UDProperties.BlockP.CHROMITE), true);
    public static final Block CHROMITE_STAIRS = register("chromite_stairs", new StairsBlock(CHROMITE.getDefaultState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Block CHROMITE_SLAB = register("chromite_slab", new SlabBlock(UDProperties.BlockP.CHROMITE), true);
    public static final Block CHROMITE_WALL = register("chromite_wall", new WallBlock(UDProperties.BlockP.CHROMITE), true);

    public static final Block POLISHED_CHROMITE = register("polished_chromite", new Block(UDProperties.BlockP.POLISHED_CHROMITE), true);
    public static final Block POLISHED_CHROMITE_STAIRS = register("polished_chromite_stairs", new StairsBlock(POLISHED_CHROMITE.getDefaultState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Block POLISHED_CHROMITE_SLAB = register("polished_chromite_slab", new SlabBlock(UDProperties.BlockP.POLISHED_CHROMITE), true);

    public static final Block STAINLESS_STEEL_BLOCK = register("stainless_steel_block", new Block(UDProperties.BlockP.STAINLESS_STEEL), true);
    public static final Block RIGID_GLASS = register("rigid_glass", new RigidGlassBlock(UDProperties.BlockP.RIGID_GLASS), true);

    //DECOR
    public static final Block TRASH_CAN = register("trash_can", new TrashCanBlock(UDProperties.BlockP.TRASH_CAN), true);
    public static final Block MICROWAVE = register("microwave", new MicrowaveBlock(UDProperties.BlockP.MICROWAVE), true);
    public static final Block SINK = register("sink", new SinkBlock(UDProperties.BlockP.SINK), true);
    public static final Block TOILET = register("toilet", new ToiletBlock(UDProperties.BlockP.TOILET), true);
    public static final Block WASHING_MACHINE = register("washing_machine", new WashingMachineBlock(UDProperties.BlockP.WASHING_MACHINE), true);
    public static final Block DRYER = register("dryer", new DryerBlock(UDProperties.BlockP.DRYER), true);
    public static final Block TOASTER = register("toaster", new ToasterBlock(false, 1, UDProperties.BlockP.TOASTER), true);
    public static final Block DESK_FAN = register("desk_fan", new DeskFanBlock(UDProperties.BlockP.DESK_FAN), true);
    public static final Block OVEN = register("oven", new OvenBlock(UDProperties.BlockP.OVEN), true);
    public static final Block STOVE = register("stove", new StoveBlock(UDProperties.BlockP.STOVE), true);
    public static final Block FRIDGE = register("fridge", new FridgeBlock(UDProperties.BlockP.FRIDGE), true);
    public static final Block FREEZER = register("freezer", new FreezerBlock(UDProperties.BlockP.FREEZER), true);
    public static final Block DARK_OVEN = register("dark_oven", new OvenBlock(UDProperties.BlockP.OVEN), true);
    public static final Block DARK_FRIDGE = register("dark_fridge", new FridgeBlock(UDProperties.BlockP.FRIDGE), true);
    public static final Block DARK_FREEZER = register("dark_freezer", new FreezerBlock(UDProperties.BlockP.FREEZER), true);
    public static final Block DARK_SINK = register("dark_sink", new SinkBlock(UDProperties.BlockP.SINK), true);
    public static final Block DARK_TOILET = register("dark_toilet", new ToiletBlock(UDProperties.BlockP.TOILET), true);
    public static final Block DARK_WASHING_MACHINE = register("dark_washing_machine", new WashingMachineBlock(UDProperties.BlockP.WASHING_MACHINE), true);
    public static final Block DARK_DRYER = register("dark_dryer", new DryerBlock(UDProperties.BlockP.DRYER), true);
    public static final Block BATHTUB = register("bathtub", new BathtubBlock(UDProperties.BlockP.BATHTUB), true);
    public static final Block DARK_BATHTUB = register("dark_bathtub", new BathtubBlock(UDProperties.BlockP.BATHTUB), true);
    public static final Block CUPBOARD = register("cupboard", new CupboardBlock(UDProperties.BlockP.CUPBOARD), true);
    public static final Block DARK_CUPBOARD = register("dark_cupboard", new CupboardBlock(UDProperties.BlockP.CUPBOARD), true);
    public static final Block FILING_CABINET = register("filing_cabinet", new FilingCabinetBlock(UDProperties.BlockP.FILING_CABINET), true);

    //MISC APPLIANCES
    public static final Block TOOLBOX = register("toolbox", new ToolboxBlock(UDProperties.BlockP.TOOLBOX), false);
    public static final Block AIR_CONDITIONER = register("air_conditioner", new AirConditionerBlock(UDProperties.BlockP.AIR_CONDITIONER), true);
    public static final Block FAUCET = register("faucet", new FaucetBlock(UDProperties.BlockP.FAUCET), true);
    public static final Block RADIATOR = register("radiator", new RadiatorBlock(UDProperties.BlockP.RADIATOR), true);
    public static final Block TURBINE = register("turbine", new TurbineBlock(UDProperties.BlockP.TURBINE), true);
    public static final Block TOWEL_BAR = register("towel_bar", new TowelBarBlock(UDProperties.BlockP.TOWEL_BAR), true);
    public static final Block SATELLITE_DISH = register("satellite_dish", new SatelliteDishBlock(UDProperties.BlockP.SATELLITE_DISH), true);
    public static final Block SHOWER = register("shower", new ShowerBlock(UDProperties.BlockP.SHOWER), true);

    //DYED BLOCKS
    public static final HashMap<DyeColor, Block> DYED_TOWELS = new HashMap<>();
    public static final HashMap<DyeColor, Block> DYED_TOWEL_BARS = new HashMap<>();
    public static final HashMap<DyeColor, Block> DYED_TOWEL_BLOCKS = new HashMap<>();
    public static final HashMap<DyeColor, Block> DYED_PICTURE_FRAMES = new HashMap<>();
    public static final Block PICTURE_FRAME = register("picture_frame", new PictureFrameBlock(UDProperties.BlockP.PICTURE_FRAME), true);

    static {
        for (DyeColor colors : DyeColor.values()) {
            DYED_TOWELS.put(colors, register(colors + "_towel", new TowelBlock(
                    FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).mapColor(colors)), true));

            DYED_TOWEL_BARS.put(colors, register("towel_bar_" + colors + "_towel", new TowelBarTowelBlock(UDBlocks.getDyedTowels(colors.getId()),
                    UDProperties.BlockP.TOWEL_BAR), false));

            DYED_TOWEL_BLOCKS.put(colors, register(colors + "_towel_block", new Block(
                    FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(colors)), true));

            DYED_PICTURE_FRAMES.put(colors, register(colors + "_picture_frame", new PictureFrameBlock(
                    UDProperties.BlockP.PICTURE_FRAME.mapColor(colors)), true));
        }
    }

    public static Block getDyedTowels(int colors){
        return DYED_TOWELS.get(DyeColor.byId(colors));
    }

    public static Block getDyedTowelBarTowels(int colors){
        return DYED_TOWEL_BARS.get(DyeColor.byId(colors));
    }

    public static Block getDyedTowelBlocks(int colors){
        return DYED_TOWEL_BLOCKS.get(DyeColor.byId(colors));
    }

    public static Block getDyedPictureFrames(int colors){
        return DYED_PICTURE_FRAMES.get(DyeColor.byId(colors));
    }

    private static Block register(String id, Block block, boolean registerItem) {
        if (registerItem) {
            registerBlockItem(id, block);
        }
        return Registry.register(Registries.BLOCK, Identifier.of(UrbanDecor.MOD_ID, id), block);
    }

    private static Item registerBlockItem(String id, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(UrbanDecor.MOD_ID, id), new BlockItem(block, new Item.Settings()));
    }

    public static void loadBlocks() {
    }
}

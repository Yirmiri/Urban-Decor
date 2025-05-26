package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.common.publicized.PublicDoorBlock;
import net.azurune.runiclib.common.publicized.PublicIronBarsBlock;
import net.azurune.runiclib.common.publicized.PublicStairBlock;
import net.azurune.runiclib.common.publicized.PublicTrapdoorBlock;
import net.azurune.runiclib.core.platform.Services;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.*;
import net.yirmiri.urban_decor.common.util.UDProperties;

import java.util.HashMap;
import java.util.function.Supplier;

public class UDBlocks {

    //BLOCKS
    public static final Supplier<Block> PORCELAIN_BLOCK = register("porcelain_block", () -> new Block(UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> PORCELAIN_STAIRS = register("porcelain_stairs", () -> new PublicStairBlock(PORCELAIN_BLOCK.get().defaultBlockState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> PORCELAIN_SLAB = register("porcelain_slab", () -> new SlabBlock(UDProperties.BlockP.PORCELAIN), true);

    public static final Supplier<Block> DARK_PORCELAIN_BLOCK = register("dark_porcelain_block", () -> new Block(UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Supplier<Block> DARK_PORCELAIN_STAIRS = register("dark_porcelain_stairs", () -> new PublicStairBlock(DARK_PORCELAIN_BLOCK.get().defaultBlockState(), UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Supplier<Block> DARK_PORCELAIN_SLAB = register("dark_porcelain_slab", () -> new SlabBlock(UDProperties.BlockP.DARK_PORCELAIN), true);

    public static final Supplier<Block> PORCELAIN_BRICKS = register("porcelain_bricks", () -> new Block(UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> PORCELAIN_BRICK_STAIRS = register("porcelain_brick_stairs", () -> new PublicStairBlock(PORCELAIN_BRICKS.get().defaultBlockState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> PORCELAIN_BRICK_SLAB = register("porcelain_brick_slab", () -> new SlabBlock(UDProperties.BlockP.PORCELAIN), true);

    public static final Supplier<Block> DARK_PORCELAIN_BRICKS = register("dark_porcelain_bricks", () -> new Block(UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Supplier<Block> DARK_PORCELAIN_BRICK_STAIRS = register("dark_porcelain_brick_stairs", () -> new PublicStairBlock(DARK_PORCELAIN_BRICKS.get().defaultBlockState(), UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Supplier<Block> DARK_PORCELAIN_BRICK_SLAB = register("dark_porcelain_brick_slab", () -> new SlabBlock(UDProperties.BlockP.DARK_PORCELAIN), true);

    public static final Supplier<Block> PORCELAIN_TILES = register("porcelain_tiles", () -> new Block(UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> PORCELAIN_TILE_STAIRS = register("porcelain_tile_stairs", () -> new PublicStairBlock(PORCELAIN_TILES.get().defaultBlockState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> PORCELAIN_TILE_SLAB = register("porcelain_tile_slab", () -> new SlabBlock(UDProperties.BlockP.PORCELAIN), true);

    public static final Supplier<Block> DARK_PORCELAIN_TILES = register("dark_porcelain_tiles", () -> new Block(UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Supplier<Block> DARK_PORCELAIN_TILE_STAIRS = register("dark_porcelain_tile_stairs", () -> new PublicStairBlock(DARK_PORCELAIN_TILES.get().defaultBlockState(), UDProperties.BlockP.DARK_PORCELAIN), true);
    public static final Supplier<Block> DARK_PORCELAIN_TILE_SLAB = register("dark_porcelain_tile_slab", () -> new SlabBlock(UDProperties.BlockP.DARK_PORCELAIN), true);

    public static final Supplier<Block> CHECKERED_PORCELAIN_TILES = register("checkered_porcelain_tiles", () -> new Block(UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> CHECKERED_PORCELAIN_TILE_STAIRS = register("checkered_porcelain_tile_stairs", () -> new PublicStairBlock(CHECKERED_PORCELAIN_TILES.get().defaultBlockState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> CHECKERED_PORCELAIN_TILE_SLAB = register("checkered_porcelain_tile_slab", () -> new SlabBlock(UDProperties.BlockP.PORCELAIN), true);

    public static final Supplier<Block> CHROMITE = register("chromite", () -> new Block(UDProperties.BlockP.CHROMITE), true);
    public static final Supplier<Block> CHROMITE_STAIRS = register("chromite_stairs", () -> new PublicStairBlock(CHROMITE.get().defaultBlockState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> CHROMITE_SLAB = register("chromite_slab", () -> new SlabBlock(UDProperties.BlockP.CHROMITE), true);
    public static final Supplier<Block> CHROMITE_WALL = register("chromite_wall", () -> new WallBlock(UDProperties.BlockP.CHROMITE), true);

    public static final Supplier<Block> POLISHED_CHROMITE = register("polished_chromite", () -> new Block(UDProperties.BlockP.POLISHED_CHROMITE), true);
    public static final Supplier<Block> POLISHED_CHROMITE_STAIRS = register("polished_chromite_stairs", () -> new PublicStairBlock(POLISHED_CHROMITE.get().defaultBlockState(), UDProperties.BlockP.PORCELAIN), true);
    public static final Supplier<Block> POLISHED_CHROMITE_SLAB = register("polished_chromite_slab", () -> new SlabBlock(UDProperties.BlockP.POLISHED_CHROMITE), true);

    public static final Supplier<Block> RIGID_GLASS = register("rigid_glass", () -> new RigidGlassBlock(UDProperties.BlockP.RIGID_GLASS), true);
    public static final Supplier<Block> STEEL_PIPE = register("steel_pipe", () -> new ChainBlock(UDProperties.BlockP.STEEL_PIPE), false);

    public static final Supplier<Block> STAINLESS_STEEL_BLOCK = register("stainless_steel_block", () -> new Block(UDProperties.BlockP.STAINLESS_STEEL), true);
    public static final Supplier<Block> STAINLESS_STEEL_BARS = register("stainless_steel_bars", () -> new PublicIronBarsBlock(UDProperties.BlockP.STEEL_BARS), true);
    public static final Supplier<Block> STAINLESS_STEEL_LANTERN = register("stainless_steel_lantern", () -> new StainlessSteelLanternBlock(UDProperties.BlockP.STEEL_LANTERN), true);
    public static final Supplier<Block> STAINLESS_STEEL_SOUL_LANTERN = register("stainless_steel_soul_lantern", () -> new StainlessSteelLanternBlock(UDProperties.BlockP.STEEL_SOUL_LANTERN), true);
    public static final Supplier<Block> STAINLESS_STEEL_DOOR = register("stainless_steel_door", () -> new PublicDoorBlock(UDProperties.BlockP.STEEL_DOOR, BlockSetType.STONE), true);
    public static final Supplier<Block> STAINLESS_STEEL_TRAPDOOR = register("stainless_steel_trapdoor", () -> new PublicTrapdoorBlock(UDProperties.BlockP.STEEL_TRAPDOOR, BlockSetType.STONE), true);
//TODO: steel door and trapdoor locking
    //DECOR
    public static final Supplier<Block> TRASH_CAN = register("trash_can", () -> new TrashCanBlock(UDProperties.BlockP.TRASH_CAN), true);
    public static final Supplier<Block> SINK = register("sink", () -> new SinkBlock(UDProperties.BlockP.SINK), true);
    public static final Supplier<Block> TOILET = register("toilet", () -> new ToiletBlock(UDProperties.BlockP.TOILET), true);
    public static final Supplier<Block> WASHING_MACHINE = register("washing_machine", () -> new WashingMachineBlock(UDProperties.BlockP.WASHING_MACHINE), true);
    public static final Supplier<Block> DRYER = register("dryer", () -> new DryerBlock(UDProperties.BlockP.DRYER), true);
    public static final Supplier<Block> TOASTER = register("toaster", () -> new ToasterBlock(false, 1, UDProperties.BlockP.TOASTER), true);
    public static final Supplier<Block> DESK_FAN = register("desk_fan", () -> new DeskFanBlock(UDProperties.BlockP.DESK_FAN), true);
    public static final Supplier<Block> OVEN = register("oven", () -> new OvenBlock(UDProperties.BlockP.OVEN), true);
    public static final Supplier<Block> STOVE = register("stove", () -> new StoveBlock(UDProperties.BlockP.STOVE), true);
    public static final Supplier<Block> FRIDGE = register("fridge", () -> new FridgeBlock(UDProperties.BlockP.FRIDGE), true);
    public static final Supplier<Block> FREEZER = register("freezer", () -> new FreezerBlock(UDProperties.BlockP.FREEZER), true);
    public static final Supplier<Block> DARK_OVEN = register("dark_oven", () -> new OvenBlock(UDProperties.BlockP.OVEN), true);
    public static final Supplier<Block> DARK_FRIDGE = register("dark_fridge", () -> new FridgeBlock(UDProperties.BlockP.FRIDGE), true);
    public static final Supplier<Block> DARK_FREEZER = register("dark_freezer", () -> new FreezerBlock(UDProperties.BlockP.FREEZER), true);
    public static final Supplier<Block> DARK_SINK = register("dark_sink", () -> new SinkBlock(UDProperties.BlockP.SINK), true);
    public static final Supplier<Block> DARK_TOILET = register("dark_toilet", () -> new ToiletBlock(UDProperties.BlockP.TOILET), true);
    public static final Supplier<Block> DARK_WASHING_MACHINE = register("dark_washing_machine", () -> new WashingMachineBlock(UDProperties.BlockP.WASHING_MACHINE), true);
    public static final Supplier<Block> DARK_DRYER = register("dark_dryer", () -> new DryerBlock(UDProperties.BlockP.DRYER), true);
    public static final Supplier<Block> BATHTUB = register("bathtub", () -> new BathtubBlock(UDProperties.BlockP.BATHTUB), true);
    public static final Supplier<Block> DARK_BATHTUB = register("dark_bathtub", () -> new BathtubBlock(UDProperties.BlockP.BATHTUB), true);
    public static final Supplier<Block> CUPBOARD = register("cupboard", () -> new CupboardBlock(UDProperties.BlockP.CUPBOARD), true);
    public static final Supplier<Block> DARK_CUPBOARD = register("dark_cupboard", () -> new CupboardBlock(UDProperties.BlockP.CUPBOARD), true);
    public static final Supplier<Block> FILING_CABINET = register("filing_cabinet", () -> new FilingCabinetBlock(UDProperties.BlockP.FILING_CABINET), true);
    public static final Supplier<Block> TOILET_PAPER = register("toilet_paper", () -> new ToiletPaperBlock(UDProperties.BlockP.TOILET_PAPER), true);
    public static final Supplier<Block> MICROWAVE = register("microwave", () -> new MicrowaveBlock(UDProperties.BlockP.MICROWAVE), false);
    public static final Supplier<Block> WALL_MICROWAVE = register("wall_microwave", () -> new MicrowaveWallBlock(UDProperties.BlockP.MICROWAVE), false);
    public static final Supplier<Block> FLOOR_LAMP = register("floor_lamp", () -> new FloorLampBlock(UDProperties.BlockP.FLOOR_LAMP), true);
    public static final Supplier<Block> OAK_PIANO = register("oak_piano", () -> new PianoBlock(UDProperties.BlockP.PIANO), true);
    public static final Supplier<Block> SPRUCE_PIANO = register("spruce_piano", () -> new PianoBlock(UDProperties.BlockP.PIANO), true);
    public static final Supplier<Block> BIRCH_PIANO = register("birch_piano", () -> new PianoBlock(UDProperties.BlockP.PIANO), true);
    public static final Supplier<Block> JUNGLE_PIANO = register("jungle_piano", () -> new PianoBlock(UDProperties.BlockP.PIANO), true);
    public static final Supplier<Block> ACACIA_PIANO = register("acacia_piano", () -> new PianoBlock(UDProperties.BlockP.PIANO), true);
    public static final Supplier<Block> DARK_OAK_PIANO = register("dark_oak_piano", () -> new PianoBlock(UDProperties.BlockP.PIANO), true);
    public static final Supplier<Block> MANGROVE_PIANO = register("mangrove_piano", () -> new PianoBlock(UDProperties.BlockP.PIANO), true);
    public static final Supplier<Block> CHERRY_PIANO = register("cherry_piano", () -> new PianoBlock(UDProperties.BlockP.CHERRY_PIANO), true);
    public static final Supplier<Block> BAMBOO_PIANO = register("bamboo_piano", () -> new PianoBlock(UDProperties.BlockP.BAMBOO_PIANO), true);
    public static final Supplier<Block> CRIMSON_PIANO = register("crimson_piano", () -> new PianoBlock(UDProperties.BlockP.NETHER_PIANO), true);
    public static final Supplier<Block> WARPED_PIANO = register("warped_piano", () -> new PianoBlock(UDProperties.BlockP.NETHER_PIANO), true);

    //MISC APPLIANCES
    public static final Supplier<Block> TOOLBOX = register("toolbox", () -> new ToolboxBlock(UDProperties.BlockP.TOOLBOX), false);
    public static final Supplier<Block> AIR_CONDITIONER = register("air_conditioner", () -> new AirConditionerBlock(UDProperties.BlockP.AIR_CONDITIONER), true);
    public static final Supplier<Block> FAUCET = register("faucet", () -> new FaucetBlock(UDProperties.BlockP.FAUCET), true);
    public static final Supplier<Block> RADIATOR = register("radiator", () -> new RadiatorBlock(UDProperties.BlockP.RADIATOR), true);
    public static final Supplier<Block> TURBINE = register("turbine", () -> new TurbineBlock(UDProperties.BlockP.TURBINE), true);
    public static final Supplier<Block> TOWEL_BAR = register("towel_bar", () -> new TowelBarBlock(UDProperties.BlockP.TOWEL_BAR), true);
    public static final Supplier<Block> SHOWER = register("shower", () -> new ShowerBlock(UDProperties.BlockP.SHOWER), true);
    public static final Supplier<Block> SATELLITE_DISH = register("satellite_dish", () -> new SatelliteDishBlock(UDProperties.BlockP.SATELLITE_DISH), false);
    public static final Supplier<Block> WALL_SATELLITE_DISH = register("wall_satellite_dish", () -> new SatelliteDishBlock(UDProperties.BlockP.SATELLITE_DISH), false);

    //DYED BLOCKS
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TOWELS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TOWEL_BARS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TOWEL_BLOCKS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_PICTURE_FRAMES = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_WALL_PICTURE_FRAMES = new HashMap<>();

    public static final Supplier<Block> PICTURE_FRAME = register("picture_frame", () -> new PictureFrameBlock(UDProperties.BlockP.PICTURE_FRAME), false);
    public static final Supplier<Block> WALL_PICTURE_FRAME = register("wall_picture_frame", () -> new PictureFrameWallBlock(UDProperties.BlockP.PICTURE_FRAME), false);

    static {
        for (DyeColor colors : DyeColor.values()) {
            DYED_TOWELS.put(colors, register(colors + "_towel", () -> new TowelBlock(
                    BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(colors)), true));

            DYED_TOWEL_BARS.put(colors, register("towel_bar_" + colors + "_towel", () -> new TowelBarTowelBlock(
                    UDBlocks.getDyedTowels(colors.getId()).get(), UDProperties.BlockP.TOWEL_BAR), false));

            DYED_TOWEL_BLOCKS.put(colors, register(colors + "_towel_block", () -> new Block(
                    BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(colors)), true));

            DYED_PICTURE_FRAMES.put(colors, register(colors + "_picture_frame", () -> new PictureFrameBlock(
                    UDProperties.BlockP.PICTURE_FRAME.mapColor(colors)), false));

            DYED_WALL_PICTURE_FRAMES.put(colors, register(colors + "_wall_picture_frame", () -> new PictureFrameWallBlock(
                    UDProperties.BlockP.PICTURE_FRAME.mapColor(colors)), false));
        }
    }

    public static Supplier<Block> getDyedTowels(int colors){
        return DYED_TOWELS.get(DyeColor.byId(colors));
    }

    public static Supplier<Block> getDyedTowelBarTowels(int colors){
        return DYED_TOWEL_BARS.get(DyeColor.byId(colors));
    }

    public static Supplier<Block> getDyedTowelBlocks(int colors){
        return DYED_TOWEL_BLOCKS.get(DyeColor.byId(colors));
    }

    public static Supplier<Block> getDyedPictureBlocks(int colors){
        return DYED_PICTURE_FRAMES.get(DyeColor.byId(colors));
    }

    public static Supplier<Block> getDyedWallPictureBlocks(int colors){
        return DYED_WALL_PICTURE_FRAMES.get(DyeColor.byId(colors));
    }

    public static Supplier<Block> register(String id, Supplier<Block> supplier, boolean hasItem) {
        return Services.REGISTRY.registerBlock(UrbanDecor.MOD_ID, id, supplier, hasItem);
    }

    public static void loadBlocks() {
    }
}

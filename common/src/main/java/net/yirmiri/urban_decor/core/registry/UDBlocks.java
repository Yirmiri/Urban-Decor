package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.common.publicized.*;
import net.azurune.runiclib.core.platform.RLServices;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.StainlessSteelLanternBlock;
import net.yirmiri.urban_decor.common.block.appliances.*;
import net.yirmiri.urban_decor.common.block.unfinished_appliances.*;
import net.yirmiri.urban_decor.common.util.UDProperties;
import net.yirmiri.urban_decor.common.util.WrapColor;

import java.util.HashMap;
import java.util.function.Supplier;

public class UDBlocks {
    //BLOCKS
    public static final Supplier<Block> POLYPROPYLENE_BLOCK = register("polypropylene_block", () -> new Block(UDProperties.BlockP.PLASTIC), true);

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
    public static final Supplier<Block> CHROMITE_STAIRS = register("chromite_stairs", () -> new PublicStairBlock(CHROMITE.get().defaultBlockState(), UDProperties.BlockP.CHROMITE), true);
    public static final Supplier<Block> CHROMITE_SLAB = register("chromite_slab", () -> new SlabBlock(UDProperties.BlockP.CHROMITE), true);
    public static final Supplier<Block> CHROMITE_WALL = register("chromite_wall", () -> new WallBlock(UDProperties.BlockP.CHROMITE), true);

    public static final Supplier<Block> POLISHED_CHROMITE = register("polished_chromite", () -> new Block(UDProperties.BlockP.POLISHED_CHROMITE), true);
    public static final Supplier<Block> POLISHED_CHROMITE_STAIRS = register("polished_chromite_stairs", () -> new PublicStairBlock(POLISHED_CHROMITE.get().defaultBlockState(), UDProperties.BlockP.POLISHED_CHROMITE), true);
    public static final Supplier<Block> POLISHED_CHROMITE_SLAB = register("polished_chromite_slab", () -> new SlabBlock(UDProperties.BlockP.POLISHED_CHROMITE), true);

    //STAINLESS STEEL
    public static final Supplier<Block> STAINLESS_STEEL_BLOCK = register("stainless_steel_block", () -> new Block(UDProperties.BlockP.STAINLESS_STEEL), true);
    public static final Supplier<Block> STAINLESS_STEEL_BARS = register("stainless_steel_bars", () -> new PublicIronBarsBlock(UDProperties.BlockP.STEEL_BARS), true);
    public static final Supplier<Block> STAINLESS_STEEL_FENCE = register("stainless_steel_fence", () -> new PublicIronBarsBlock(UDProperties.BlockP.STEEL_FENCE), true);
    public static final Supplier<Block> STAINLESS_STEEL_LANTERN = register("stainless_steel_lantern", () -> new StainlessSteelLanternBlock(UDProperties.BlockP.STEEL_LANTERN), true);
    public static final Supplier<Block> STAINLESS_STEEL_SOUL_LANTERN = register("stainless_steel_soul_lantern", () -> new StainlessSteelLanternBlock(UDProperties.BlockP.STEEL_SOUL_LANTERN), true);
    public static final Supplier<Block> STAINLESS_STEEL_DOOR = register("stainless_steel_door", () -> new PublicDoorBlock(BlockSetType.STONE, UDProperties.BlockP.STEEL_DOOR), true);
    public static final Supplier<Block> STAINLESS_STEEL_TRAPDOOR = register("stainless_steel_trapdoor", () -> new PublicTrapdoorBlock(BlockSetType.STONE, UDProperties.BlockP.STEEL_TRAPDOOR), true);
    public static final Supplier<Block> STAINLESS_STEEL_LADDER = register("stainless_steel_ladder", () -> new PublicLadderBlock(UDProperties.BlockP.STEEL_LADDER), true);
    public static final Supplier<Block> RIGID_GLASS = register("rigid_glass", () -> new RigidGlassBlock(UDProperties.BlockP.RIGID_GLASS), true);
    public static final Supplier<Block> STEEL_PIPE = register("steel_pipe", () -> new SteelPipeBlock(UDProperties.BlockP.STEEL_PIPE), false);

    //DECOR
    public static final Supplier<Block> TRASH_CAN = register("trash_can", () -> new TrashCanBlock(UDProperties.BlockP.TRASH_CAN), true);
    public static final Supplier<Block> SINK = register("sink", () -> new SinkBlock(UDProperties.BlockP.SINK), true);
    public static final Supplier<Block> TOILET = register("toilet", () -> new ToiletBlock(UDProperties.BlockP.TOILET), true);
    public static final Supplier<Block> WASHING_MACHINE = register("washing_machine", () -> new WashingMachineBlock(UDProperties.BlockP.WASHING_MACHINE), true);
    public static final Supplier<Block> DRYER = register("dryer", () -> new DryerBlock(UDProperties.BlockP.DRYER), true);
    public static final Supplier<Block> TOASTER = register("toaster", () -> new ToasterBlock(UDProperties.BlockP.TOASTER), true);
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
    public static final Supplier<Block> DISHWASHER = register("dishwasher", () -> new DishwasherBlock(UDProperties.BlockP.DISHWASHER), true);
    public static final Supplier<Block> DARK_DISHWASHER = register("dark_dishwasher", () -> new DishwasherBlock(UDProperties.BlockP.DISHWASHER), true);
    public static final Supplier<Block> CASH_REGISTER = register("cash_register", () -> new CashRegisterBlock(UDProperties.BlockP.CASH_REGISTER), true);
    public static final Supplier<Block> DARK_CASH_REGISTER = register("dark_cash_register", () -> new CashRegisterBlock(UDProperties.BlockP.CASH_REGISTER), true);
    public static final Supplier<Block> VENDING_MACHINE = register("vending_machine", () -> new VendingMachineBlock(UDProperties.BlockP.VENDING), true);
    public static final Supplier<Block> PORCELAIN_TABLE = register("porcelain_table", () -> new PorcelainTableBlock(UDProperties.BlockP.PORCELAIN_TABLE), true);
    public static final Supplier<Block> WALL_CLOCK = register("wall_clock", () -> new WallClockBlock(UDProperties.BlockP.WALL_CLOCK), true);
    public static final Supplier<Block> PLASTIC_CHAIR = register("plastic_chair", () -> new PlasticChairBlock(UDProperties.BlockP.PLASTIC_CHAIR), true);

    //WOODEN
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
    
    public static final Supplier<Block> OAK_CALENDAR = register("oak_calendar", () -> new CalendarBlock(UDProperties.BlockP.CALENDAR), true);
    public static final Supplier<Block> SPRUCE_CALENDAR = register("spruce_calendar", () -> new CalendarBlock(UDProperties.BlockP.CALENDAR), true);
    public static final Supplier<Block> BIRCH_CALENDAR = register("birch_calendar", () -> new CalendarBlock(UDProperties.BlockP.CALENDAR), true);
    public static final Supplier<Block> JUNGLE_CALENDAR = register("jungle_calendar", () -> new CalendarBlock(UDProperties.BlockP.CALENDAR), true);
    public static final Supplier<Block> ACACIA_CALENDAR = register("acacia_calendar", () -> new CalendarBlock(UDProperties.BlockP.CALENDAR), true);
    public static final Supplier<Block> DARK_OAK_CALENDAR = register("dark_oak_calendar", () -> new CalendarBlock(UDProperties.BlockP.CALENDAR), true);
    public static final Supplier<Block> MANGROVE_CALENDAR = register("mangrove_calendar", () -> new CalendarBlock(UDProperties.BlockP.CALENDAR), true);
    public static final Supplier<Block> CHERRY_CALENDAR = register("cherry_calendar", () -> new CalendarBlock(UDProperties.BlockP.CHERRY_CALENDAR), true);
    public static final Supplier<Block> BAMBOO_CALENDAR = register("bamboo_calendar", () -> new CalendarBlock(UDProperties.BlockP.BAMBOO_CALENDAR), true);
    public static final Supplier<Block> CRIMSON_CALENDAR = register("crimson_calendar", () -> new CalendarBlock(UDProperties.BlockP.NETHER_CALENDAR), true);
    public static final Supplier<Block> WARPED_CALENDAR = register("warped_calendar", () -> new CalendarBlock(UDProperties.BlockP.NETHER_CALENDAR), true);

    public static final Supplier<Block> OAK_GRANDFATHER_CLOCK = register("oak_grandfather_clock", () -> new GrandClockBlock(BlockSetType.OAK, UDProperties.BlockP.GRAND_CLOCK), true);
    public static final Supplier<Block> SPRUCE_GRANDFATHER_CLOCK = register("spruce_grandfather_clock", () -> new GrandClockBlock(BlockSetType.SPRUCE, UDProperties.BlockP.GRAND_CLOCK), true);
    public static final Supplier<Block> BIRCH_GRANDFATHER_CLOCK = register("birch_grandfather_clock", () -> new GrandClockBlock(BlockSetType.BIRCH, UDProperties.BlockP.GRAND_CLOCK), true);
    public static final Supplier<Block> JUNGLE_GRANDFATHER_CLOCK = register("jungle_grandfather_clock", () -> new GrandClockBlock(BlockSetType.JUNGLE, UDProperties.BlockP.GRAND_CLOCK), true);
    public static final Supplier<Block> ACACIA_GRANDFATHER_CLOCK = register("acacia_grandfather_clock", () -> new GrandClockBlock(BlockSetType.ACACIA, UDProperties.BlockP.GRAND_CLOCK), true);
    public static final Supplier<Block> DARK_OAK_GRANDFATHER_CLOCK = register("dark_oak_grandfather_clock", () -> new GrandClockBlock(BlockSetType.DARK_OAK, UDProperties.BlockP.GRAND_CLOCK), true);
    public static final Supplier<Block> MANGROVE_GRANDFATHER_CLOCK = register("mangrove_grandfather_clock", () -> new GrandClockBlock(BlockSetType.MANGROVE, UDProperties.BlockP.GRAND_CLOCK), true);
    public static final Supplier<Block> CHERRY_GRANDFATHER_CLOCK = register("cherry_grandfather_clock", () -> new GrandClockBlock(BlockSetType.CHERRY, UDProperties.BlockP.CHERRY_GRAND_CLOCK), true);
    public static final Supplier<Block> BAMBOO_GRANDFATHER_CLOCK = register("bamboo_grandfather_clock", () -> new GrandClockBlock(BlockSetType.BAMBOO, UDProperties.BlockP.BAMBOO_GRAND_CLOCK), true);
    public static final Supplier<Block> CRIMSON_GRANDFATHER_CLOCK = register("crimson_grandfather_clock", () -> new GrandClockBlock(BlockSetType.CRIMSON, UDProperties.BlockP.NETHER_GRAND_CLOCK), true);
    public static final Supplier<Block> WARPED_GRANDFATHER_CLOCK = register("warped_grandfather_clock", () -> new GrandClockBlock(BlockSetType.WARPED, UDProperties.BlockP.NETHER_GRAND_CLOCK), true);

    public static final Supplier<Block> OAK_BOX = register("oak_box", () -> new BoxBlock(UDProperties.BlockP.OAK_PLANKS), true);
    public static final Supplier<Block> SPRUCE_BOX = register("spruce_box", () -> new BoxBlock(UDProperties.BlockP.OAK_PLANKS), true);
    public static final Supplier<Block> BIRCH_BOX = register("birch_box", () -> new BoxBlock(UDProperties.BlockP.OAK_PLANKS), true);
    public static final Supplier<Block> JUNGLE_BOX = register("jungle_box", () -> new BoxBlock(UDProperties.BlockP.OAK_PLANKS), true);
    public static final Supplier<Block> ACACIA_BOX = register("acacia_box", () -> new BoxBlock(UDProperties.BlockP.OAK_PLANKS), true);
    public static final Supplier<Block> DARK_OAK_BOX = register("dark_oak_box", () -> new BoxBlock(UDProperties.BlockP.OAK_PLANKS), true);
    public static final Supplier<Block> MANGROVE_BOX = register("mangrove_box", () -> new BoxBlock(UDProperties.BlockP.OAK_PLANKS), true);
    public static final Supplier<Block> CHERRY_BOX = register("cherry_box", () -> new BoxBlock(UDProperties.BlockP.CHERRY_PLANKS), true);
    public static final Supplier<Block> BAMBOO_BOX = register("bamboo_box", () -> new BoxBlock(UDProperties.BlockP.BAMBOO_PLANKS), true);
    public static final Supplier<Block> CRIMSON_BOX = register("crimson_box", () -> new BoxBlock(UDProperties.BlockP.CRIMSON_PLANKS), true);
    public static final Supplier<Block> WARPED_BOX = register("warped_box", () -> new BoxBlock(UDProperties.BlockP.CRIMSON_PLANKS), true);

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
    public static final Supplier<Block> STAINLESS_STEEL_CHAIR = register("stainless_steel_chair", () -> new StainlessSteelChairBlock(UDProperties.BlockP.STAINLESS_STEEL_CHAIR), true);

    //WRAPPED
    public static final HashMap<WrapColor, Supplier<Block>> WRAPPED_POLYANTHOUS = new HashMap<>();

    static {
        for (WrapColor colors : WrapColor.values()) {
            WRAPPED_POLYANTHOUS.put(colors, register(colors + "_polyanthous", () -> new TallFlowerBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).mapColor(colors.getMapColor())), true));
        }
    }

    public static Supplier<Block> getWrappedPolyanthous(int colors){
        return WRAPPED_POLYANTHOUS.get(WrapColor.byId(colors));
    }

    //DYED BLOCKS
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TOWELS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TOWEL_BARS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TOWEL_BLOCKS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_PICTURE_FRAMES = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_WALL_PICTURE_FRAMES = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_PLASTIC_LIGHTS = new HashMap<>();

    //UNDYED VARIANTS
    public static final Supplier<Block> PICTURE_FRAME = register("picture_frame", () -> new PictureFrameBlock(UDProperties.BlockP.PICTURE_FRAME), false);
    public static final Supplier<Block> WALL_PICTURE_FRAME = register("wall_picture_frame", () -> new PictureFrameWallBlock(UDProperties.BlockP.PICTURE_FRAME), false);
    public static final Supplier<Block> PLASTIC_LIGHTS = register("plastic_lights", () -> new PlasticLightsBlock(UDProperties.BlockP.PLASTIC_LIGHTS), true);

    static {
        for (DyeColor colors : DyeColor.values()) {
            DYED_TOWELS.put(colors, register(colors + "_towel", () -> new TowelBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET).mapColor(colors)), true));

            DYED_TOWEL_BARS.put(colors, register("towel_bar_" + colors + "_towel", () -> new TowelBarTowelBlock(
                    UDBlocks.getDyedTowels(colors.getId()).get(), UDProperties.BlockP.TOWEL_BAR), false));

            DYED_TOWEL_BLOCKS.put(colors, register(colors + "_towel_block", () -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(colors)), true));

            DYED_PICTURE_FRAMES.put(colors, register(colors + "_picture_frame", () -> new PictureFrameBlock(
                    UDProperties.BlockP.PICTURE_FRAME.mapColor(colors)), false));

            DYED_WALL_PICTURE_FRAMES.put(colors, register(colors + "_wall_picture_frame", () -> new PictureFrameWallBlock(
                    UDProperties.BlockP.PICTURE_FRAME.mapColor(colors)), false));

            if (colors != DyeColor.BLACK) {
                DYED_PLASTIC_LIGHTS.put(colors, register(colors + "_plastic_lights", () -> new PlasticLightsBlock(
                        UDProperties.BlockP.PLASTIC_LIGHTS.mapColor(colors)), true));
            } else {
                DYED_PLASTIC_LIGHTS.put(colors, register(colors + "_plastic_lights", () -> new PlasticLightsBlock(
                        UDProperties.BlockP.DARK_PLASTIC_LIGHTS.mapColor(colors)), true));
            }
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

    public static Supplier<Block> getDyedPlasticLights(int colors){
        return DYED_PLASTIC_LIGHTS.get(DyeColor.byId(colors));
    }

    public static Supplier<Block> register(String id, Supplier<Block> supplier, boolean hasItem) {
        return RLServices.REGISTRY.registerBlock(UrbanDecor.MOD_ID, id, supplier, hasItem);
    }

    public static void loadBlocks() {
    }
}

package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.core.platform.RLServices;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.util.WrapColor;

import java.util.function.Supplier;

public class UDCreativeTabs {
    public static final Supplier<CreativeModeTab> URBAN_DECOR = RLServices.REGISTRY.registerCreativeModeTab(
            UrbanDecor.MOD_ID, "urban_decor", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .title(Component.translatable("itemgroup.urban_decor"))
                    .icon(() -> new ItemStack(UDItems.TOOLBOX.get()))
                    .displayItems((displayParameters, entry) -> {
                        entry.accept(UDItems.PORCELAIN.get());
                        entry.accept(UDItems.DARK_PORCELAIN.get());
                        entry.accept(UDItems.POLYPROPYLENE.get());
                        entry.accept(UDItems.STAINLESS_STEEL_INGOT.get());
                        entry.accept(UDItems.STAINLESS_STEEL_NUGGET.get());
                        entry.accept(UDItems.STEEL_PIPE.get());

                        entry.accept(UDBlocks.PORCELAIN_BLOCK.get());
                        entry.accept(UDBlocks.PORCELAIN_STAIRS.get());
                        entry.accept(UDBlocks.PORCELAIN_SLAB.get());

                        entry.accept(UDBlocks.PORCELAIN_BRICKS.get());
                        entry.accept(UDBlocks.PORCELAIN_BRICK_STAIRS.get());
                        entry.accept(UDBlocks.PORCELAIN_BRICK_SLAB.get());

                        entry.accept(UDBlocks.PORCELAIN_TILES.get());
                        entry.accept(UDBlocks.PORCELAIN_TILE_STAIRS.get());
                        entry.accept(UDBlocks.PORCELAIN_TILE_SLAB.get());

                        entry.accept(UDBlocks.DARK_PORCELAIN_BLOCK.get());
                        entry.accept(UDBlocks.DARK_PORCELAIN_STAIRS.get());
                        entry.accept(UDBlocks.DARK_PORCELAIN_SLAB.get());

                        entry.accept(UDBlocks.DARK_PORCELAIN_BRICKS.get());
                        entry.accept(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get());
                        entry.accept(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get());

                        entry.accept(UDBlocks.DARK_PORCELAIN_TILES.get());
                        entry.accept(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get());
                        entry.accept(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get());

                        entry.accept(UDBlocks.CHECKERED_PORCELAIN_TILES.get());
                        entry.accept(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get());
                        entry.accept(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get());

                        entry.accept(UDBlocks.POLYPROPYLENE_BLOCK.get());

                        entry.accept(UDBlocks.CHROMITE.get());
                        entry.accept(UDBlocks.CHROMITE_STAIRS.get());
                        entry.accept(UDBlocks.CHROMITE_SLAB.get());
                        entry.accept(UDBlocks.CHROMITE_WALL.get());

                        entry.accept(UDBlocks.POLISHED_CHROMITE.get());
                        entry.accept(UDBlocks.POLISHED_CHROMITE_STAIRS.get());
                        entry.accept(UDBlocks.POLISHED_CHROMITE_SLAB.get());

                        entry.accept(UDBlocks.STAINLESS_STEEL_BLOCK.get());
                        entry.accept(UDBlocks.STAINLESS_STEEL_DOOR.get());
                        entry.accept(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get());
                        entry.accept(UDBlocks.STAINLESS_STEEL_LANTERN.get());
                        entry.accept(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get());
                        entry.accept(UDBlocks.STAINLESS_STEEL_BARS.get());
                        entry.accept(UDBlocks.STAINLESS_STEEL_FENCE.get());
                        entry.accept(UDBlocks.STAINLESS_STEEL_LADDER.get());

                        entry.accept(UDBlocks.RIGID_GLASS.get());

                        entry.accept(UDItems.TOOLBOX.get());

                        entry.accept(UDBlocks.FILING_CABINET.get());
                        entry.accept(UDBlocks.CUPBOARD.get());
                        entry.accept(UDBlocks.DARK_CUPBOARD.get());
                        entry.accept(UDBlocks.SINK.get());
                        entry.accept(UDBlocks.DARK_SINK.get());
                        entry.accept(UDBlocks.TOILET.get());
                        entry.accept(UDBlocks.DARK_TOILET.get());
                        entry.accept(UDBlocks.TOILET_PAPER.get());
                        entry.accept(UDBlocks.BATHTUB.get());
                        entry.accept(UDBlocks.DARK_BATHTUB.get());
                        entry.accept(UDBlocks.WASHING_MACHINE.get());
                        entry.accept(UDBlocks.DARK_WASHING_MACHINE.get());
                        entry.accept(UDBlocks.DRYER.get());
                        entry.accept(UDBlocks.DARK_DRYER.get());
                        entry.accept(UDBlocks.FRIDGE.get());
                        entry.accept(UDBlocks.DARK_FRIDGE.get());
                        entry.accept(UDBlocks.FREEZER.get());
                        entry.accept(UDBlocks.DARK_FREEZER.get());
                        entry.accept(UDBlocks.DISHWASHER.get());
                        entry.accept(UDBlocks.DARK_DISHWASHER.get());
                        entry.accept(UDBlocks.OVEN.get());
                        entry.accept(UDBlocks.DARK_OVEN.get());
                        entry.accept(UDBlocks.STOVE.get());
                        entry.accept(UDBlocks.TOASTER.get());
                        entry.accept(UDItems.MICROWAVE.get());
                        entry.accept(UDBlocks.SHOWER.get());
                        entry.accept(UDBlocks.FAUCET.get());
                        entry.accept(UDBlocks.TRASH_CAN.get());
                        entry.accept(UDBlocks.DESK_FAN.get());
                        entry.accept(UDBlocks.FLOOR_LAMP.get());
                        entry.accept(UDBlocks.VENDING_MACHINE.get());
                        entry.accept(UDBlocks.CASH_REGISTER.get());
                        entry.accept(UDBlocks.DARK_CASH_REGISTER.get());

                        entry.accept(UDBlocks.PLASTIC_CHAIR.get());
                        entry.accept(UDBlocks.STAINLESS_STEEL_CHAIR.get());
                        entry.accept(UDBlocks.PORCELAIN_TABLE.get());

                        entry.accept(UDBlocks.BOOTH.get());

                        entry.accept(UDBlocks.WALL_CLOCK.get());
                        entry.accept(UDBlocks.OAK_GRANDFATHER_CLOCK.get());
                        entry.accept(UDBlocks.SPRUCE_GRANDFATHER_CLOCK.get());
                        entry.accept(UDBlocks.BIRCH_GRANDFATHER_CLOCK.get());
                        entry.accept(UDBlocks.JUNGLE_GRANDFATHER_CLOCK.get());
                        entry.accept(UDBlocks.ACACIA_GRANDFATHER_CLOCK.get());
                        entry.accept(UDBlocks.DARK_OAK_GRANDFATHER_CLOCK.get());
                        entry.accept(UDBlocks.MANGROVE_GRANDFATHER_CLOCK.get());
                        entry.accept(UDBlocks.CHERRY_GRANDFATHER_CLOCK.get());
                        entry.accept(UDBlocks.BAMBOO_GRANDFATHER_CLOCK.get());
                        entry.accept(UDBlocks.CRIMSON_GRANDFATHER_CLOCK.get());
                        entry.accept(UDBlocks.WARPED_GRANDFATHER_CLOCK.get());

                        entry.accept(UDBlocks.OAK_PIANO.get());
                        entry.accept(UDBlocks.SPRUCE_PIANO.get());
                        entry.accept(UDBlocks.BIRCH_PIANO.get());
                        entry.accept(UDBlocks.JUNGLE_PIANO.get());
                        entry.accept(UDBlocks.ACACIA_PIANO.get());
                        entry.accept(UDBlocks.DARK_OAK_PIANO.get());
                        entry.accept(UDBlocks.MANGROVE_PIANO.get());
                        entry.accept(UDBlocks.CHERRY_PIANO.get());
                        entry.accept(UDBlocks.BAMBOO_PIANO.get());
                        entry.accept(UDBlocks.CRIMSON_PIANO.get());
                        entry.accept(UDBlocks.WARPED_PIANO.get());

                        entry.accept(UDBlocks.OAK_BOX.get());
                        entry.accept(UDBlocks.SPRUCE_BOX.get());
                        entry.accept(UDBlocks.BIRCH_BOX.get());
                        entry.accept(UDBlocks.JUNGLE_BOX.get());
                        entry.accept(UDBlocks.ACACIA_BOX.get());
                        entry.accept(UDBlocks.DARK_OAK_BOX.get());
                        entry.accept(UDBlocks.MANGROVE_BOX.get());
                        entry.accept(UDBlocks.CHERRY_BOX.get());
                        entry.accept(UDBlocks.BAMBOO_BOX.get());
                        entry.accept(UDBlocks.CRIMSON_BOX.get());
                        entry.accept(UDBlocks.WARPED_BOX.get());

                        entry.accept(UDBlocks.OAK_CALENDAR.get());
                        entry.accept(UDBlocks.SPRUCE_CALENDAR.get());
                        entry.accept(UDBlocks.BIRCH_CALENDAR.get());
                        entry.accept(UDBlocks.JUNGLE_CALENDAR.get());
                        entry.accept(UDBlocks.ACACIA_CALENDAR.get());
                        entry.accept(UDBlocks.DARK_OAK_CALENDAR.get());
                        entry.accept(UDBlocks.MANGROVE_CALENDAR.get());
                        entry.accept(UDBlocks.CHERRY_CALENDAR.get());
                        entry.accept(UDBlocks.BAMBOO_CALENDAR.get());
                        entry.accept(UDBlocks.CRIMSON_CALENDAR.get());
                        entry.accept(UDBlocks.WARPED_CALENDAR.get());

                        entry.accept(UDItems.SATELLITE_DISH.get());
                        entry.accept(UDBlocks.TURBINE.get());
                        entry.accept(UDBlocks.AIR_CONDITIONER.get());
                        entry.accept(UDBlocks.RADIATOR.get());

                        //WRAPPED
                        entry.accept(UDItems.getWrappedWraps(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDItems.getWrappedWraps(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDItems.getWrappedWraps(WrapColor.SPRING.getId()).get());
                        entry.accept(UDItems.getWrappedWraps(WrapColor.MINT.getId()).get());
                        entry.accept(UDItems.getWrappedWraps(WrapColor.AZURE.getId()).get());
                        entry.accept(UDItems.getWrappedWraps(WrapColor.RUBY.getId()).get());

                        entry.accept(UDBlocks.getWrappedPolyanthous(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPolyanthous(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDBlocks.getWrappedPolyanthous(WrapColor.SPRING.getId()).get());
                        entry.accept(UDBlocks.getWrappedPolyanthous(WrapColor.MINT.getId()).get());
                        entry.accept(UDBlocks.getWrappedPolyanthous(WrapColor.AZURE.getId()).get());
                        entry.accept(UDBlocks.getWrappedPolyanthous(WrapColor.RUBY.getId()).get());

                        entry.accept(UDBlocks.MATTRESS.get());
                        entry.accept(UDBlocks.getWrappedMattresses(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDBlocks.getWrappedMattresses(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDBlocks.getWrappedMattresses(WrapColor.SPRING.getId()).get());
                        entry.accept(UDBlocks.getWrappedMattresses(WrapColor.MINT.getId()).get());
                        entry.accept(UDBlocks.getWrappedMattresses(WrapColor.AZURE.getId()).get());
                        entry.accept(UDBlocks.getWrappedMattresses(WrapColor.RUBY.getId()).get());

                        entry.accept(UDBlocks.getWrappedPorcelainBlocks(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainStairs(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainSlabs(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBricks(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickStairs(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickSlabs(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTiles(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileStairs(WrapColor.CHERRY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileSlabs(WrapColor.CHERRY.getId()).get());

                        entry.accept(UDBlocks.getWrappedPorcelainBlocks(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainStairs(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainSlabs(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBricks(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickStairs(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickSlabs(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTiles(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileStairs(WrapColor.DAFFODIL.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileSlabs(WrapColor.DAFFODIL.getId()).get());

                        entry.accept(UDBlocks.getWrappedPorcelainBlocks(WrapColor.SPRING.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainStairs(WrapColor.SPRING.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainSlabs(WrapColor.SPRING.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBricks(WrapColor.SPRING.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickStairs(WrapColor.SPRING.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickSlabs(WrapColor.SPRING.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTiles(WrapColor.SPRING.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileStairs(WrapColor.SPRING.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileSlabs(WrapColor.SPRING.getId()).get());

                        entry.accept(UDBlocks.getWrappedPorcelainBlocks(WrapColor.MINT.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainStairs(WrapColor.MINT.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainSlabs(WrapColor.MINT.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBricks(WrapColor.MINT.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickStairs(WrapColor.MINT.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickSlabs(WrapColor.MINT.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTiles(WrapColor.MINT.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileStairs(WrapColor.MINT.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileSlabs(WrapColor.MINT.getId()).get());

                        entry.accept(UDBlocks.getWrappedPorcelainBlocks(WrapColor.AZURE.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainStairs(WrapColor.AZURE.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainSlabs(WrapColor.AZURE.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBricks(WrapColor.AZURE.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickStairs(WrapColor.AZURE.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickSlabs(WrapColor.AZURE.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTiles(WrapColor.AZURE.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileStairs(WrapColor.AZURE.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileSlabs(WrapColor.AZURE.getId()).get());

                        entry.accept(UDBlocks.getWrappedPorcelainBlocks(WrapColor.RUBY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainStairs(WrapColor.RUBY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainSlabs(WrapColor.RUBY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBricks(WrapColor.RUBY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickStairs(WrapColor.RUBY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainBrickSlabs(WrapColor.RUBY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTiles(WrapColor.RUBY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileStairs(WrapColor.RUBY.getId()).get());
                        entry.accept(UDBlocks.getWrappedPorcelainTileSlabs(WrapColor.RUBY.getId()).get());

                        //DYED
                        entry.accept(UDBlocks.TOWEL_BAR.get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.WHITE.getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_GRAY.getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.GRAY.getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.BLACK.getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.BROWN.getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.RED.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.valueOf("DD_CORAL").getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.valueOf("DD_UMBER").getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.ORANGE.getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.YELLOW.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.valueOf("DD_CANARY").getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.valueOf("DD_WASABI").getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.LIME.getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.GREEN.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.valueOf("DD_SACRAMENTO").getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.CYAN.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.valueOf("DD_SKY").getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.LIGHT_BLUE.getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.BLUE.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.valueOf("DD_BLURPLE").getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.PURPLE.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.valueOf("DD_LAVENDER").getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.MAGENTA.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.valueOf("DD_SANGRIA").getId()).get());
                        entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.PINK.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowelBlocks(DyeColor.valueOf("DD_ROSE").getId()).get());

                        entry.accept(UDBlocks.getDyedTowels(DyeColor.WHITE.getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.LIGHT_GRAY.getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.GRAY.getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.BLACK.getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.BROWN.getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.RED.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowels(DyeColor.valueOf("DD_CORAL").getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowels(DyeColor.valueOf("DD_UMBER").getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.ORANGE.getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.YELLOW.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowels(DyeColor.valueOf("DD_CANARY").getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowels(DyeColor.valueOf("DD_WASABI").getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.LIME.getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.GREEN.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowels(DyeColor.valueOf("DD_SACRAMENTO").getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.CYAN.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowels(DyeColor.valueOf("DD_SKY").getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.LIGHT_BLUE.getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.BLUE.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowels(DyeColor.valueOf("DD_BLURPLE").getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.PURPLE.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowels(DyeColor.valueOf("DD_LAVENDER").getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.MAGENTA.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowels(DyeColor.valueOf("DD_SANGRIA").getId()).get());
                        entry.accept(UDBlocks.getDyedTowels(DyeColor.PINK.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedTowels(DyeColor.valueOf("DD_ROSE").getId()).get());


                        entry.accept(UDItems.PICTURE_FRAME.get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.WHITE.getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.LIGHT_GRAY.getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.GRAY.getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.BLACK.getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.BROWN.getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.RED.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDItems.getDyedPictureFrames(DyeColor.valueOf("DD_CORAL").getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDItems.getDyedPictureFrames(DyeColor.valueOf("DD_UMBER").getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.ORANGE.getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.YELLOW.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDItems.getDyedPictureFrames(DyeColor.valueOf("DD_CANARY").getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDItems.getDyedPictureFrames(DyeColor.valueOf("DD_WASABI").getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.LIME.getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.GREEN.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDItems.getDyedPictureFrames(DyeColor.valueOf("DD_SACRAMENTO").getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.CYAN.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDItems.getDyedPictureFrames(DyeColor.valueOf("DD_SKY").getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.LIGHT_BLUE.getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.BLUE.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDItems.getDyedPictureFrames(DyeColor.valueOf("DD_BLURPLE").getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.PURPLE.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDItems.getDyedPictureFrames(DyeColor.valueOf("DD_LAVENDER").getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.MAGENTA.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDItems.getDyedPictureFrames(DyeColor.valueOf("DD_SANGRIA").getId()).get());
                        entry.accept(UDItems.getDyedPictureFrames(DyeColor.PINK.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDItems.getDyedPictureFrames(DyeColor.valueOf("DD_ROSE").getId()).get());


                        entry.accept(UDBlocks.PLASTIC_LIGHTS.get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.WHITE.getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.LIGHT_GRAY.getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.GRAY.getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.BLACK.getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.BROWN.getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.RED.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.valueOf("DD_CORAL").getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.valueOf("DD_UMBER").getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.ORANGE.getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.YELLOW.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.valueOf("DD_CANARY").getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.valueOf("DD_WASABI").getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.LIME.getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.GREEN.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.valueOf("DD_SACRAMENTO").getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.CYAN.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.valueOf("DD_SKY").getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.LIGHT_BLUE.getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.BLUE.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.valueOf("DD_BLURPLE").getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.PURPLE.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.valueOf("DD_LAVENDER").getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.MAGENTA.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.valueOf("DD_SANGRIA").getId()).get());
                        entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.PINK.getId()).get());
                        if (RLServices.PLATFORM.isModLoaded("delicate_dyes")) entry.accept(UDBlocks.getDyedPlasticLights(DyeColor.valueOf("DD_ROSE").getId()).get());

            }).build());

    public static void loadItemGroups() {
    }
}

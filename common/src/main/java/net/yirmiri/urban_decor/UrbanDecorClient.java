package net.yirmiri.urban_decor;

import net.azurune.runiclib.core.platform.Services;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.yirmiri.urban_decor.common.util.WrapColor;
import net.yirmiri.urban_decor.core.registry.UDBlocks;

public class UrbanDecorClient {
    
    public static void init() {
        //COLORED
        for (WrapColor colors : WrapColor.values()) {
            Services.loadClient().registerBlockRenderType(UDBlocks.getWrappedPolyanthous(colors.getId()).get(), RenderType.cutout());
        }

        for (DyeColor colors : DyeColor.values()) {
            Services.loadClient().registerBlockRenderType(UDBlocks.getDyedTowels(colors.getId()).get(), RenderType.cutout());
            Services.loadClient().registerBlockRenderType(UDBlocks.getDyedTowelBarTowels(colors.getId()).get(), RenderType.cutout());
            Services.loadClient().registerBlockRenderType(UDBlocks.getDyedPictureBlocks(colors.getId()).get(), RenderType.cutout());
            Services.loadClient().registerBlockRenderType(UDBlocks.getDyedWallPictureBlocks(colors.getId()).get(), RenderType.cutout());
        }

        //CUTOUT
        Services.loadClient().registerBlockRenderType(UDBlocks.TRASH_CAN.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.TOOLBOX.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.STOVE.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.TOILET.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.DARK_TOILET.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.FAUCET.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.RIGID_GLASS.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.PICTURE_FRAME.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.WALL_PICTURE_FRAME.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.PLASTIC_CHAIR.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.STAINLESS_STEEL_LADDER.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.OAK_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.SPRUCE_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.BIRCH_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.JUNGLE_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.ACACIA_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.DARK_OAK_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.MANGROVE_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.CHERRY_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.BAMBOO_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.CRIMSON_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.WARPED_GRANDFATHER_CLOCK.get(), RenderType.cutout());
        Services.loadClient().registerBlockRenderType(UDBlocks.PLASTIC_DESK_TABLE.get(), RenderType.cutout());

        //CUTOUT MIPPED
        Services.loadClient().registerBlockRenderType(UDBlocks.RADIATOR.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.SATELLITE_DISH.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.WALL_SATELLITE_DISH.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.FILING_CABINET.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.AIR_CONDITIONER.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.DESK_FAN.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.STAINLESS_STEEL_BARS.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.OAK_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.SPRUCE_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.BIRCH_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.JUNGLE_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.ACACIA_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.DARK_OAK_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.MANGROVE_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.CHERRY_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.BAMBOO_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.CRIMSON_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.WARPED_PIANO.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.FLOOR_LAMP.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.DISHWASHER.get(), RenderType.cutoutMipped());
        Services.loadClient().registerBlockRenderType(UDBlocks.DARK_DISHWASHER.get(), RenderType.cutoutMipped());

        //TRANSLUCENT
        Services.loadClient().registerBlockRenderType(UDBlocks.OVEN.get(), RenderType.translucent());
        Services.loadClient().registerBlockRenderType(UDBlocks.DARK_OVEN.get(), RenderType.translucent());
        Services.loadClient().registerBlockRenderType(UDBlocks.DARK_WASHING_MACHINE.get(), RenderType.translucent());
        Services.loadClient().registerBlockRenderType(UDBlocks.DARK_DRYER.get(), RenderType.translucent());
        Services.loadClient().registerBlockRenderType(UDBlocks.WASHING_MACHINE.get(), RenderType.translucent());
        Services.loadClient().registerBlockRenderType(UDBlocks.DRYER.get(), RenderType.translucent());
    }
}

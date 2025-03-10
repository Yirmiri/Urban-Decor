package net.yirmiri.urban_decor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.DyeColor;
import net.yirmiri.urban_decor.registry.UDBlocks;
import net.yirmiri.urban_decor.registry.UDEntities;
import net.yirmiri.urban_decor.entity.renderer.InvisibleEntityRenderer;

@Environment(EnvType.CLIENT)
public class UrbanDecorClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlocks();
        registerEntities();
    }

    private void registerBlocks() {
        //CUTOUT
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TRASH_CAN.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TOOLBOX.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.STOVE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TOILET.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_TOILET.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.FAUCET.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.RIGID_GLASS.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.PICTURE_FRAME.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WALL_PICTURE_FRAME.get(), RenderLayer.getCutout());

        //CUTOUT MIPPED
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.RADIATOR.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.SATELLITE_DISH.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WALL_SATELLITE_DISH.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.FILING_CABINET.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.AIR_CONDITIONER.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DESK_FAN.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.STAINLESS_STEEL_BARS.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.OAK_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.SPRUCE_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.BIRCH_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.JUNGLE_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.ACACIA_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_OAK_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.MANGROVE_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.CHERRY_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.BAMBOO_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.CRIMSON_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WARPED_PIANO.get(), RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.FLOOR_LAMP.get(), RenderLayer.getCutoutMipped());

        //TRANSLUCENT
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.OVEN.get(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_OVEN.get(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_WASHING_MACHINE.get(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_DRYER.get(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WASHING_MACHINE.get(), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DRYER.get(), RenderLayer.getTranslucent());

        for (DyeColor colors : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedTowels(colors.getId()).get(), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedTowelBarTowels(colors.getId()).get(), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedPictureBlocks(colors.getId()).get(), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedWallPictureBlocks(colors.getId()).get(), RenderLayer.getCutout());
        }
    }

    private void registerEntities() {
        EntityRendererRegistry.register(UDEntities.TOILET, InvisibleEntityRenderer::new);
    }
}

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
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TRASH_CAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TOOLBOX, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.STOVE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TOILET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_TOILET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.FAUCET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.RIGID_GLASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.PICTURE_FRAME, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WALL_PICTURE_FRAME, RenderLayer.getCutout());

        //CUTOUT MIPPED
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.RADIATOR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.SATELLITE_DISH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WALL_SATELLITE_DISH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.FILING_CABINET, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.AIR_CONDITIONER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DESK_FAN, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.STAINLESS_STEEL_BARS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.OAK_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.SPRUCE_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.BIRCH_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.JUNGLE_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.ACACIA_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_OAK_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.MANGROVE_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.CHERRY_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.BAMBOO_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.CRIMSON_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WARPED_PIANO, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.FLOOR_LAMP, RenderLayer.getCutoutMipped());

        //TRANSLUCENT
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.OVEN, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_OVEN, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_WASHING_MACHINE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_DRYER, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WASHING_MACHINE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DRYER, RenderLayer.getTranslucent());

        for (DyeColor colors : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedTowels(colors.getId()), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedTowelBarTowels(colors.getId()), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedPictureBlocks(colors.getId()), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedWallPictureBlocks(colors.getId()), RenderLayer.getCutout());
        }
    }

    private void registerEntities() {
        EntityRendererRegistry.register(UDEntities.TOILET, InvisibleEntityRenderer::new);
    }
}

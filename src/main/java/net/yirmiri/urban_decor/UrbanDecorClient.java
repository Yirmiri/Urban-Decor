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
        //CUTOUT
        addDyedCutouts();
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TRASH_CAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TOOLBOX, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.STOVE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TOILET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_TOILET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.FAUCET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.RIGID_GLASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.PICTURE_FRAME, RenderLayer.getCutout());

        //CUTOUT MIPPED
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.AIR_CONDITIONER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DESK_FAN, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.OVEN, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.RADIATOR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_OVEN, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.SATELLITE_DISH, RenderLayer.getCutoutMipped());

        //TRANSLUCENT
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_WASHING_MACHINE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_DRYER, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.MICROWAVE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WASHING_MACHINE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DRYER, RenderLayer.getTranslucent());

        //ENTITY
        EntityRendererRegistry.register(UDEntities.TOILET, InvisibleEntityRenderer::new);
    }

    private void addDyedCutouts() {
        for (DyeColor colors : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedTowels(colors.getId()), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedTowelBarTowels(colors.getId()), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedPictureFrames(colors.getId()), RenderLayer.getCutout());
        }
    }
}

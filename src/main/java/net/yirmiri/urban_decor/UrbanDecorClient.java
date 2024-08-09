package net.yirmiri.urban_decor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.DyeColor;
import net.yirmiri.urban_decor.registry.RegisterBlocks;
import net.yirmiri.urban_decor.registry.RegisterEntities;
import net.yirmiri.urban_decor.entity.renderer.InvisibleEntityRenderer;

@Environment(EnvType.CLIENT)
public class UrbanDecorClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //CUTOUT
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.TRASH_CAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.MICROWAVE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.WASHING_MACHINE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DRYER, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.AIR_CONDITIONER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.TOOLBOX, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DESK_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.OVEN, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.RADIATOR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.STOVE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DARK_WASHING_MACHINE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DARK_OVEN, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DARK_DRYER, RenderLayer.getTranslucent());
        addTowelRenderLayer();
        addTowelBarTowelRenderLayer();
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.SATELLITE_DISH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.TOILET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DARK_TOILET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.FAUCET, RenderLayer.getCutout());

        //ENTITY
        EntityRendererRegistry.register(RegisterEntities.TOILET, InvisibleEntityRenderer::new);
    }

    private void addTowelRenderLayer() {
        for (DyeColor colors : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.getDyedTowels(colors.getId()), RenderLayer.getCutout());
        }
    }

    private void addTowelBarTowelRenderLayer() {
        for (DyeColor colors : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.getDyedTowelBarTowels(colors.getId()), RenderLayer.getCutout());
        }
    }
}

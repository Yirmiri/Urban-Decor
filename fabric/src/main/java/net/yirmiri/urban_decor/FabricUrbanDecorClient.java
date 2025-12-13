package net.yirmiri.urban_decor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.yirmiri.urban_decor.core.registry.UDEntities;
import net.yirmiri.urban_decor.common.entity.renderer.InvisibleEntityRenderer;

@Environment(EnvType.CLIENT)
public class FabricUrbanDecorClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UrbanDecorClient.init();
        EntityRendererRegistry.register(UDEntities.SEAT.get(), InvisibleEntityRenderer::new);
    }
}

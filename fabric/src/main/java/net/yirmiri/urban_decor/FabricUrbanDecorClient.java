package net.yirmiri.urban_decor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.yirmiri.urban_decor.common.block.entity.GrandClockModel;
import net.yirmiri.urban_decor.common.block.entity.GrandClockRenderer;
import net.yirmiri.urban_decor.common.block.entity.WallClockModel;
import net.yirmiri.urban_decor.common.block.entity.WallClockRenderer;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;
import net.yirmiri.urban_decor.core.registry.UDEntities;
import net.yirmiri.urban_decor.common.entity.renderer.InvisibleEntityRenderer;

@Environment(EnvType.CLIENT)
public class FabricUrbanDecorClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UrbanDecorClient.init();
        EntityRendererRegistry.register(UDEntities.SEAT.get(), InvisibleEntityRenderer::new);

        BlockEntityRendererRegistry.register(UDBlockEntities.WALL_CLOCK.get(), WallClockRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(WallClockModel.LAYER_LOCATION, WallClockModel::createBodyLayer);

        BlockEntityRendererRegistry.register(UDBlockEntities.GRAND_CLOCK.get(), GrandClockRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(GrandClockModel.LAYER_LOCATION, GrandClockModel::createBodyLayer);
    }
}

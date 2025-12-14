package net.yirmiri.urban_decor;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.yirmiri.urban_decor.common.block.entity.GrandClockModel;
import net.yirmiri.urban_decor.common.block.entity.GrandClockRenderer;
import net.yirmiri.urban_decor.common.block.entity.WallClockModel;
import net.yirmiri.urban_decor.common.block.entity.WallClockRenderer;
import net.yirmiri.urban_decor.common.entity.renderer.InvisibleEntityRenderer;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;
import net.yirmiri.urban_decor.core.registry.UDEntities;

@Mod(UrbanDecor.MOD_ID)
public class NeoForgeUrbanDecor {

    public NeoForgeUrbanDecor(IEventBus eventBus) {
        UrbanDecor.init();

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::registerEntityRenderer);
        eventBus.addListener(this::registerRenderers);
        eventBus.addListener(this::registerLayers);
    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
        UrbanDecorClient.init();
    }

    @SubscribeEvent
    public void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(UDEntities.SEAT.get(), InvisibleEntityRenderer::new);
    }

    @SubscribeEvent
    public void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(UDBlockEntities.WALL_CLOCK.get(), WallClockRenderer::new);
        event.registerBlockEntityRenderer(UDBlockEntities.GRAND_CLOCK.get(), GrandClockRenderer::new);
    }

    @SubscribeEvent
    public void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WallClockModel.LAYER_LOCATION, WallClockModel::createBodyLayer);
        event.registerLayerDefinition(GrandClockModel.LAYER_LOCATION, GrandClockModel::createBodyLayer);
    }
}
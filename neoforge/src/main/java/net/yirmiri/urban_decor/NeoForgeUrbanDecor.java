package net.yirmiri.urban_decor;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.yirmiri.urban_decor.common.entity.renderer.InvisibleEntityRenderer;
import net.yirmiri.urban_decor.core.registry.UDEntities;

@Mod(UrbanDecor.MOD_ID)
public class NeoForgeUrbanDecor {

    public NeoForgeUrbanDecor(IEventBus eventBus) {
        UrbanDecor.init();

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::registerEntityRenderer);
    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
        UrbanDecorClient.init();
    }

    @SubscribeEvent
    public void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(UDEntities.SEAT.get(), InvisibleEntityRenderer::new);
    }
}
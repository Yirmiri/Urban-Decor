package net.yirmiri.urban_decor;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.yirmiri.urban_decor.common.block.sewing_machine.SewingMachineScreen;
import net.yirmiri.urban_decor.common.block_entity.model.*;
import net.yirmiri.urban_decor.common.block_entity.model.doll.*;
import net.yirmiri.urban_decor.common.block_entity.renderer.DollRenderer;
import net.yirmiri.urban_decor.common.block_entity.renderer.GrandClockRenderer;
import net.yirmiri.urban_decor.common.block_entity.renderer.StainlessSteelChairRenderer;
import net.yirmiri.urban_decor.common.block_entity.renderer.WallClockRenderer;
import net.yirmiri.urban_decor.common.entity.renderer.InvisibleEntityRenderer;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;
import net.yirmiri.urban_decor.core.registry.UDEntities;
import net.yirmiri.urban_decor.core.registry.UDMenus;

@Mod(UrbanDecor.MOD_ID)
public class NeoForgeUrbanDecor {

    public NeoForgeUrbanDecor(IEventBus eventBus) {
        UrbanDecor.init();
        UDRegistryAliases.load();

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
        event.registerBlockEntityRenderer(UDBlockEntities.STAINLESS_STEEL_CHAIR.get(), StainlessSteelChairRenderer::new);
        event.registerBlockEntityRenderer(UDBlockEntities.DOLL.get(), DollRenderer::new);
    }

    @SubscribeEvent
    public void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WallClockModel.LAYER_LOCATION, WallClockModel::createBodyLayer);
        event.registerLayerDefinition(GrandClockModel.LAYER_LOCATION, GrandClockModel::createBodyLayer);
        event.registerLayerDefinition(StainlessSteelChairModel.LAYER_LOCATION, StainlessSteelChairModel::createBodyLayer);
        event.registerLayerDefinition(DollModel.LAYER_LOCATION, DollModel::createBodyLayer);
        event.registerLayerDefinition(DollSlouchingModel.LAYER_LOCATION, DollSlouchingModel::createBodyLayer);
        event.registerLayerDefinition(DollHangingModel.LAYER_LOCATION, DollHangingModel::createBodyLayer);
        event.registerLayerDefinition(DollStandingModel.LAYER_LOCATION, DollStandingModel::createBodyLayer);
        event.registerLayerDefinition(DollLeaningModel.LAYER_LOCATION, DollLeaningModel::createBodyLayer);
        event.registerLayerDefinition(DollCrawlingModel.LAYER_LOCATION, DollCrawlingModel::createBodyLayer);
        event.registerLayerDefinition(DollLayingModel.LAYER_LOCATION, DollLayingModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterScreens(RegisterMenuScreensEvent event) {
        event.register(UDMenus.SEWING_MACHINE.get(), SewingMachineScreen::new);
    }
}
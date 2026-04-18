package net.yirmiri.urban_decor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.yirmiri.urban_decor.common.block.sewing_machine.SewingMachineScreen;
import net.yirmiri.urban_decor.common.block_entity.model.*;
import net.yirmiri.urban_decor.common.block_entity.model.doll.*;
import net.yirmiri.urban_decor.common.block_entity.renderer.DollRenderer;
import net.yirmiri.urban_decor.common.block_entity.renderer.GrandClockRenderer;
import net.yirmiri.urban_decor.common.block_entity.renderer.StainlessSteelChairRenderer;
import net.yirmiri.urban_decor.common.block_entity.renderer.WallClockRenderer;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;
import net.yirmiri.urban_decor.core.registry.UDEntities;
import net.yirmiri.urban_decor.common.entity.renderer.InvisibleEntityRenderer;
import net.yirmiri.urban_decor.core.registry.UDMenus;

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

        BlockEntityRendererRegistry.register(UDBlockEntities.STAINLESS_STEEL_CHAIR.get(), StainlessSteelChairRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(StainlessSteelChairModel.LAYER_LOCATION, StainlessSteelChairModel::createBodyLayer);

        BlockEntityRendererRegistry.register(UDBlockEntities.DOLL.get(), DollRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(DollModel.LAYER_LOCATION, DollModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(DollSlouchingModel.LAYER_LOCATION, DollSlouchingModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(DollHangingModel.LAYER_LOCATION, DollHangingModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(DollStandingModel.LAYER_LOCATION, DollStandingModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(DollLeaningModel.LAYER_LOCATION, DollLeaningModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(DollCrawlingModel.LAYER_LOCATION, DollCrawlingModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(DollLayingModel.LAYER_LOCATION, DollLayingModel::createBodyLayer);

        MenuScreens.register(UDMenus.SEWING_MACHINE.get(), SewingMachineScreen::new);
    }
}
package net.yirmiri.urban_decor;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.neoforged.bus.api.IEventBus;
import net.yirmiri.urban_decor.common.entity.renderer.InvisibleEntityRenderer;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
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
        //CUTOUT
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.TRASH_CAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.TOOLBOX.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.STOVE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.TOILET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.DARK_TOILET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.FAUCET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.RIGID_GLASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.PICTURE_FRAME.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.WALL_PICTURE_FRAME.get(), RenderType.cutout());

        //CUTOUT MIPPED
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.RADIATOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.SATELLITE_DISH.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.WALL_SATELLITE_DISH.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.FILING_CABINET.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.AIR_CONDITIONER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.DESK_FAN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.STAINLESS_STEEL_BARS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.OAK_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.SPRUCE_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.BIRCH_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.JUNGLE_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.ACACIA_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.DARK_OAK_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.MANGROVE_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.CHERRY_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.BAMBOO_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.CRIMSON_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.WARPED_PIANO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.FLOOR_LAMP.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.DISHWASHER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.DARK_DISHWASHER.get(), RenderType.cutoutMipped());

        //TRANSLUCENT
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.OVEN.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.DARK_OVEN.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.DARK_WASHING_MACHINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.DARK_DRYER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.WASHING_MACHINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(UDBlocks.DRYER.get(), RenderType.translucent());

        for (DyeColor colors : DyeColor.values()) {
            ItemBlockRenderTypes.setRenderLayer(UDBlocks.getDyedTowels(colors.getId()).get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(UDBlocks.getDyedTowelBarTowels(colors.getId()).get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(UDBlocks.getDyedPictureBlocks(colors.getId()).get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(UDBlocks.getDyedWallPictureBlocks(colors.getId()).get(), RenderType.cutout());
        }
    }

    @SubscribeEvent
    public void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(UDEntities.TOILET.get(), InvisibleEntityRenderer::new);
    }
}
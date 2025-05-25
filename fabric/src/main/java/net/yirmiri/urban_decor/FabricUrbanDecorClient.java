package net.yirmiri.urban_decor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDEntities;
import net.yirmiri.urban_decor.common.entity.renderer.InvisibleEntityRenderer;

@Environment(EnvType.CLIENT)
public class FabricUrbanDecorClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlocks();
        registerEntities();
    }

    private void registerBlocks() {
        //CUTOUT
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TRASH_CAN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TOOLBOX.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.STOVE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.TOILET.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_TOILET.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.FAUCET.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.RIGID_GLASS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.PICTURE_FRAME.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WALL_PICTURE_FRAME.get(), RenderType.cutout());

        //CUTOUT MIPPED
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.RADIATOR.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.SATELLITE_DISH.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WALL_SATELLITE_DISH.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.FILING_CABINET.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.AIR_CONDITIONER.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DESK_FAN.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.STAINLESS_STEEL_BARS.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.OAK_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.SPRUCE_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.BIRCH_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.JUNGLE_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.ACACIA_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_OAK_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.MANGROVE_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.CHERRY_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.BAMBOO_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.CRIMSON_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WARPED_PIANO.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.FLOOR_LAMP.get(), RenderType.cutoutMipped());

        //TRANSLUCENT
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.OVEN.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_OVEN.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_WASHING_MACHINE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DARK_DRYER.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.WASHING_MACHINE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.DRYER.get(), RenderType.translucent());

        for (DyeColor colors : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedTowels(colors.getId()).get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedTowelBarTowels(colors.getId()).get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedPictureBlocks(colors.getId()).get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(UDBlocks.getDyedWallPictureBlocks(colors.getId()).get(), RenderType.cutout());
        }
    }

    private void registerEntities() {
        EntityRendererRegistry.register(UDEntities.TOILET.get(), InvisibleEntityRenderer::new);
    }
}

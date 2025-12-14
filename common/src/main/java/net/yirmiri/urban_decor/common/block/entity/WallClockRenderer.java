package net.yirmiri.urban_decor.common.block.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.azurune.runiclib.RunicLib;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.WallClockBlock;

public class WallClockRenderer implements BlockEntityRenderer<WallClockBlockEntity> {
    private final WallClockModel<Entity> model;

    public WallClockRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new WallClockModel<>(ctx.bakeLayer(WallClockModel.LAYER_LOCATION));
    }

    @Override
    public void render(WallClockBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        poseStack.pushPose();

        poseStack.translate(0.5D, -1.8125D, 0.5D);

        switch (blockEntity.getBlockState().getValue(WallClockBlock.FACING)) {
            case NORTH -> poseStack.mulPose(Axis.YP.rotationDegrees(180F));
            case EAST -> poseStack.mulPose(Axis.YP.rotationDegrees(90F));
            case WEST -> poseStack.mulPose(Axis.YP.rotationDegrees(-90F));
            case SOUTH -> poseStack.mulPose(Axis.YP.rotationDegrees(0F));
        }

        model.setupAnim(null, 0, 0, blockEntity.getLevel().getDayTime(), 0, 0);
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(getTexture())), light, overlay, 0xFFFFFFFF);

        poseStack.popPose();
    }

    private ResourceLocation getTexture() {
        return RunicLib.customid(UrbanDecor.MOD_ID, "textures/block/wall_clock.png");
    }
}

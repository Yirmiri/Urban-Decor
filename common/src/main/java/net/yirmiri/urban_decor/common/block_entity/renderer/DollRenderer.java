package net.yirmiri.urban_decor.common.block_entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.azurune.runiclib.RunicLib;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.appliances.DollBlock;
import net.yirmiri.urban_decor.common.block_entity.entity.DollBlockEntity;
import net.yirmiri.urban_decor.common.block_entity.model.doll.*;

public class DollRenderer implements BlockEntityRenderer<DollBlockEntity> {
    private final DollModel<Entity> model;
    private final DollSlouchingModel<Entity> modelSlouching;
    private final DollLeaningModel<Entity> modelLeaning;
    private final DollStandingModel<Entity> modelStanding;
    private final DollHangingModel<Entity> modelHanging;
    private final DollLayingModel<Entity> modelLaying;
    private final DollCrawlingModel<Entity> modelCrawling;
    private final DollBizarreModel<Entity> modelBizarre;

    public DollRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new DollModel<>(ctx.bakeLayer(DollModel.LAYER_LOCATION));
        this.modelSlouching = new DollSlouchingModel<>(ctx.bakeLayer(DollSlouchingModel.LAYER_LOCATION));
        this.modelLeaning = new DollLeaningModel<>(ctx.bakeLayer(DollLeaningModel.LAYER_LOCATION));
        this.modelStanding = new DollStandingModel<>(ctx.bakeLayer(DollStandingModel.LAYER_LOCATION));
        this.modelHanging = new DollHangingModel<>(ctx.bakeLayer(DollHangingModel.LAYER_LOCATION));
        this.modelLaying = new DollLayingModel<>(ctx.bakeLayer(DollLayingModel.LAYER_LOCATION));
        this.modelCrawling = new DollCrawlingModel<>(ctx.bakeLayer(DollCrawlingModel.LAYER_LOCATION));
        this.modelBizarre = new DollBizarreModel<>(ctx.bakeLayer(DollBizarreModel.LAYER_LOCATION));
    }

    @Override
    public void render(DollBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        poseStack.pushPose();

        poseStack.translate(0.5D, 1.5D, 0.5D);
        poseStack.mulPose(Axis.YP.rotationDegrees(-RotationSegment.convertToDegrees(blockEntity.getBlockState().getValue(DollBlock.ROTATION))));
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));

        ResourceLocation texture = blockEntity.getTexture();
        if (texture == null) {
            texture = RunicLib.customid(UrbanDecor.MOD_ID, "textures/entity/doll/doll.png");
        }

        int variant = blockEntity.getVariant();

        if (variant == 0) model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityTranslucent(texture)), light, overlay, 0xFFFFFFFF);
        if (variant == 1) modelSlouching.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityTranslucent(texture)), light, overlay, 0xFFFFFFFF);
        if (variant == 2) modelLeaning.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityTranslucent(texture)), light, overlay, 0xFFFFFFFF);
        if (variant == 3) modelStanding.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityTranslucent(texture)), light, overlay, 0xFFFFFFFF);
        if (variant == 4) modelHanging.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityTranslucent(texture)), light, overlay, 0xFFFFFFFF);
        if (variant == 5) modelLaying.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityTranslucent(texture)), light, overlay, 0xFFFFFFFF);
        if (variant == 6) modelCrawling.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityTranslucent(texture)), light, overlay, 0xFFFFFFFF);
        if (variant == 7) modelBizarre.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityTranslucent(texture)), light, overlay, 0xFFFFFFFF);

        poseStack.popPose();
    }
}

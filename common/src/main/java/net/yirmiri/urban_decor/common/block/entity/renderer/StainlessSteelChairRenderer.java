package net.yirmiri.urban_decor.common.block.entity.renderer;

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
import net.yirmiri.urban_decor.common.block.StainlessSteelChairBlock;
import net.yirmiri.urban_decor.common.block.entity.StainlessSteelChairBlockEntity;
import net.yirmiri.urban_decor.common.block.entity.model.StainlessSteelChairModel;

public class StainlessSteelChairRenderer implements BlockEntityRenderer<StainlessSteelChairBlockEntity> {
    private final StainlessSteelChairModel<Entity> model;

    public StainlessSteelChairRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new StainlessSteelChairModel<>(ctx.bakeLayer(StainlessSteelChairModel.LAYER_LOCATION));
    }

    @Override
    public void render(StainlessSteelChairBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        poseStack.pushPose();

        poseStack.translate(0.5D, 1.5D, 0.5D);
        poseStack.mulPose(Axis.YP.rotationDegrees(-RotationSegment.convertToDegrees(blockEntity.getBlockState().getValue(StainlessSteelChairBlock.ROTATION))));
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));

        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(getTexture())), light, overlay, 0xFFFFFFFF);

        poseStack.popPose();
    }

    private ResourceLocation getTexture() {
        return RunicLib.customid(UrbanDecor.MOD_ID, "textures/entity/stainless_steel_chair.png");
    }
}

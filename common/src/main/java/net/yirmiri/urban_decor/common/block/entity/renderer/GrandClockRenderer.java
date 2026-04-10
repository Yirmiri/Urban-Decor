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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.appliances.GrandClockBlock;
import net.yirmiri.urban_decor.common.block.entity.GrandBlockEntity;
import net.yirmiri.urban_decor.common.block.entity.model.GrandClockModel;

public class GrandClockRenderer implements BlockEntityRenderer<GrandBlockEntity> {
    private final GrandClockModel<Entity> model;

    public GrandClockRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new GrandClockModel<>(ctx.bakeLayer(GrandClockModel.LAYER_LOCATION));
    }

    @Override
    public void render(GrandBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        BlockState state = blockEntity.getBlockState();
        if (!(state.getBlock() instanceof GrandClockBlock)) return;
        if (state.getValue(GrandClockBlock.HALF) == DoubleBlockHalf.UPPER) return;

        poseStack.pushPose();

        poseStack.translate(0.5D, 0.0D, 0.5D);

        switch (state.getValue(GrandClockBlock.FACING)) {
            case NORTH -> poseStack.mulPose(Axis.YP.rotationDegrees(180F));
            case EAST -> poseStack.mulPose(Axis.YP.rotationDegrees(90F));
            case WEST -> poseStack.mulPose(Axis.YP.rotationDegrees(-90F));
            case SOUTH -> poseStack.mulPose(Axis.YP.rotationDegrees(0F));
        }

        poseStack.translate(0.0D, 1.5D, 0.0D);

        model.setupAnim(null, 0, 0, blockEntity.getLevel().getDayTime(), 0, 0);
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(getTexture(blockEntity))), light, overlay, 0xFFFFFFFF);

        poseStack.popPose();
    }

    private ResourceLocation getTexture(GrandBlockEntity blockEntity) {
        return RunicLib.customid(UrbanDecor.MOD_ID, "textures/entity/grand_clock/" +
                GrandClockBlock.getType(blockEntity.getBlockState().getBlock()).name().toLowerCase() + "_grandfather_clock.png");
    }
}


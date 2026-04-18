package net.yirmiri.urban_decor.common.block_entity.model.doll;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.azurune.runiclib.RunicLib;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.yirmiri.urban_decor.UrbanDecor;

public class DollLayingModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(RunicLib.customid(UrbanDecor.MOD_ID, "doll_laying"), "main");
    private final ModelPart body;
    private final ModelPart head;

    public DollLayingModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -6.0F, -3.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.01F))
                .texOffs(30, 12).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 24.0F, -3.8F, -1.5708F, 0.0F, 0.0F));

        PartDefinition tail_r1 = body.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, -0.2F, 0.0F, 1.5708F, 0.1309F));

        PartDefinition rightleg_r1 = body.addOrReplaceChild("rightleg_r1", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.1F, 0.0F, 0.0873F, 0.3491F));

        PartDefinition leftleg_r1 = body.addOrReplaceChild("leftleg_r1", CubeListBuilder.create().texOffs(8, 21).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.1F, 0.0F, -0.0873F, -0.3491F));

        PartDefinition rightarm_r1 = body.addOrReplaceChild("rightarm_r1", CubeListBuilder.create().texOffs(22, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.2F, -1.1F, 0.0F, 0.1309F, 0.4363F));

        PartDefinition leftarm_r1 = body.addOrReplaceChild("leftarm_r1", CubeListBuilder.create().texOffs(14, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.2F, -1.1F, 0.0F, -0.1309F, -0.4363F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.2F))
                .texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0).addBox(-1.5F, -9.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -2.3F, 0.2182F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        body.render(poseStack, vertexConsumer, light, overlay, color);
    }
}
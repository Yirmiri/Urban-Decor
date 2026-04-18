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

public class DollBizarreModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(RunicLib.customid(UrbanDecor.MOD_ID, "doll_bizarre"), "main");
    private final ModelPart body;
    private final ModelPart body2;
    private final ModelPart head;

    public DollBizarreModel(ModelPart root) {
        this.body = root.getChild("body");
        this.body2 = this.body.getChild("body2");
        this.head = this.body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -0.9163F, 0.0F));

        PartDefinition rightleg_r1 = body.addOrReplaceChild("rightleg_r1", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, -4.7F, 1.1F, 0.0F, 0.3927F, 0.0873F));

        PartDefinition leftleg_r1 = body.addOrReplaceChild("leftleg_r1", CubeListBuilder.create().texOffs(8, 21).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, -4.7F, 1.1F, 0.0F, -0.3491F, -0.1309F));

        PartDefinition rightarm_r1 = body.addOrReplaceChild("rightarm_r1", CubeListBuilder.create().texOffs(22, 12).addBox(-2.3977F, -2.7772F, -6.2242F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.25F, -4.9684F, 2.1058F, -0.6006F, -0.0059F, 1.3798F));

        PartDefinition leftarm_r1 = body.addOrReplaceChild("leftarm_r1", CubeListBuilder.create().texOffs(14, 12).addBox(1.3563F, -2.6734F, -5.9988F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.4684F, 5.8558F, 0.1018F, -0.1625F, -0.1316F));

        PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(30, 12).addBox(-2.0F, 0.8704F, -1.732F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.1415F, -0.3892F, -0.054F));

        PartDefinition body_r1 = body2.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -2.6998F, -6.5396F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.5316F, 4.8558F, -0.0436F, 0.0F, 0.0F));

        PartDefinition tail_r1 = body2.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(24, 0).addBox(3.5843F, -2.6695F, 0.252F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5316F, 4.8558F, -0.1745F, 1.5272F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 0).addBox(-3.3987F, -17.4612F, -2.7433F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.2F))
                .texOffs(0, 0).addBox(-3.3987F, -17.4612F, -2.7433F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0).addBox(-1.8987F, -20.4612F, -1.2433F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 1.75F, 3.0F, 0.3416F, 0.4829F, 0.3218F));

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
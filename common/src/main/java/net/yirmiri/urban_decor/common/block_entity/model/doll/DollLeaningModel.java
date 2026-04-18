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

public class DollLeaningModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(RunicLib.customid(UrbanDecor.MOD_ID, "doll_leaning"), "main");
    private final ModelPart body;
    private final ModelPart body2;
    private final ModelPart head;

    public DollLeaningModel(ModelPart root) {
        this.body = root.getChild("body");
        this.body2 = this.body.getChild("body2");
        this.head = this.body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 21.0F, 4.9F, -0.3054F, 0.0F, 0.0F));

        PartDefinition rightleg_r1 = body.addOrReplaceChild("rightleg_r1", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.4F, -0.5F, -1.2419F, 0.3736F, 0.1239F));

        PartDefinition leftleg_r1 = body.addOrReplaceChild("leftleg_r1", CubeListBuilder.create().texOffs(8, 21).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.4F, -0.5F, -1.2515F, -0.2909F, -0.0945F));

        PartDefinition rightarm_r1 = body.addOrReplaceChild("rightarm_r1", CubeListBuilder.create().texOffs(22, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, -1.2F, 0.0F, 0.4588F, 0.4696F, 0.3328F));

        PartDefinition leftarm_r1 = body.addOrReplaceChild("leftarm_r1", CubeListBuilder.create().texOffs(14, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.2F, 0.0F, 0.3517F, -0.0014F, -0.1388F));

        PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -6.0F, -1.5F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.01F))
                .texOffs(30, 12).addBox(-2.0F, -3.0F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition tail_r1 = body2.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.5F, 0.4002F, 1.3393F, 0.1867F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.2F))
                .texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0).addBox(-1.5F, -9.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.5F, -0.9F, 0.2559F, 0.056F, -0.211F));

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
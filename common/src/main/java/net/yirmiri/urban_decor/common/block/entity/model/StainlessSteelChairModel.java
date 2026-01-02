package net.yirmiri.urban_decor.common.block.entity.model;

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

public class StainlessSteelChairModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(RunicLib.customid(UrbanDecor.MOD_ID, "stainless_steel_chair"), "main");
    private final ModelPart all;
    private final ModelPart frontleg;
    private final ModelPart backleg;

    public StainlessSteelChairModel(ModelPart root) {
        this.all = root.getChild("all");
        this.frontleg = root.getChild("frontleg");
        this.backleg = root.getChild("backleg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition frontleg = partdefinition.addOrReplaceChild("frontleg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = frontleg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 20).addBox(-4.0F, -4.0F, -0.5F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 2.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r2 = frontleg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 10).addBox(-5.0F, -17.0F, 0.0F, 10.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition backleg = partdefinition.addOrReplaceChild("backleg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r3 = backleg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(20, 10).addBox(-5.0F, -10.0F, 0.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.65F, 0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, int i2) {
        all.render(poseStack, vertexConsumer, i, i1, i2);
        frontleg.render(poseStack, vertexConsumer, i, i1, i2);
        backleg.render(poseStack, vertexConsumer, i, i1, i2);
    }
}

package net.yirmiri.urban_decor.common.block.entity;

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

public class WallClockModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(RunicLib.customid(UrbanDecor.MOD_ID, "wall_clock"), "main");
    private final ModelPart root;
    private final ModelPart hour_hand;
    private final ModelPart minute_hand;

    public WallClockModel(ModelPart root) {
        this.root = root.getChild("root");
        this.hour_hand = this.root.getChild("hour_hand");
        this.minute_hand = this.root.getChild("minute_hand");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -18.0F, 6.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition minute_hand = root.addOrReplaceChild("minute_hand", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5F, -3.5F, -0.85F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 6.75F));

        PartDefinition hour_hand = root.addOrReplaceChild("hour_hand", CubeListBuilder.create().texOffs(0, 13).addBox(-0.5F, -2.5F, -0.9F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 6.75F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float time = ageInTicks % 24000.0F;

        this.hour_hand.zRot = (((time / 1000.0F) + 6.0F) % 12.0F / 12.0F) * ((float) Math.PI * 2F);
        this.minute_hand.zRot = ((time % 1000.0F) / 1000.0F) * ((float) Math.PI * 2F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, int i2) {
        root.render(poseStack, vertexConsumer, i, i1, i2);
    }
}

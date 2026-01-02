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

public class GrandClockModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(RunicLib.customid(UrbanDecor.MOD_ID, "grand_clock"), "main");
    private final ModelPart root;
    private final ModelPart hour_hand;
    private final ModelPart minute_hand;
    private final ModelPart bottom;
    private final ModelPart top;

    public GrandClockModel(ModelPart root) {
        this.root = root.getChild("root");
        this.hour_hand = this.root.getChild("hour_hand");
        this.minute_hand = this.root.getChild("minute_hand");
        this.bottom = this.root.getChild("bottom");
        this.top = this.root.getChild("top");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.rotation((float) Math.PI, 0.0F, 0.0F));

        root.addOrReplaceChild("hour_hand", CubeListBuilder.create().texOffs(36, 24).addBox(-0.5F, -2.5F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -0.2F));

        root.addOrReplaceChild("minute_hand", CubeListBuilder.create().texOffs(36, 20).addBox(-0.5F, -3.5F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -0.1F));

        root.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 50).addBox(-6.0F, 0.0F, -4.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-11.0F, 4.0F, -4.0F, 16.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(0.0F, -10.0F, -4.0F, 2.0F, 14.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).mirror().addBox(-8.0F, -10.0F, -4.0F, 2.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(32, 42).addBox(-11.0F, -2.0F, -2.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 42).addBox(-11.0F, -2.0F, 2.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 42).mirror().addBox(2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(32, 42).mirror().addBox(2.0F, -2.0F, 2.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(40, 20).addBox(-6.0F, -10.0F, 2.0F, 6.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 42).addBox(-6.0F, -10.0F, -1.0F, 6.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, 4.0F));

        root.addOrReplaceChild("top", CubeListBuilder.create().texOffs(48, 0).addBox(-6.0F, -2.0F, 2.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 28).addBox(0.0F, -2.0F, -4.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(20, 28).mirror().addBox(-8.0F, -2.0F, -4.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).addBox(-8.0F, -12.0F, -4.0F, 10.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(42, 52).addBox(-6.0F, -2.0F, -1.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 10).addBox(-5.0F, -14.0F, -4.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(32, 48).addBox(-8.0F, -16.0F, -3.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 48).addBox(-8.0F, -16.0F, 3.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(40, 36).addBox(1.0F, -16.0F, -4.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(40, 36).addBox(-7.0F, -16.0F, -4.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(32, 52).addBox(1.0F, -14.0F, 0.0F, 5.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 52).mirror().addBox(-12.0F, -14.0F, 0.0F, 5.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 4.0F, 4.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //  float time = ageInTicks % 24000.0F;
        float time = (float) Math.floor(ageInTicks / 20.0F) * 20.0F;

        this.hour_hand.zRot = (((time / 1000.0F) + 6.0F) % 12.0F / 12.0F) * ((float) Math.PI * 2F);
        //this.minute_hand.zRot = ((time % 1000.0F) / 1000.0F) * ((float) Math.PI * 2F);
        this.minute_hand.zRot = ((time % 1000.0F) / 1000.0F) * ((float) Math.PI * 2F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, int i2) {
        root.render(poseStack, vertexConsumer, i, i1, i2);
    }
}

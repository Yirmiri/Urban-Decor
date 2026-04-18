package net.yirmiri.urban_decor.core.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.azurune.runiclib.RunicLib;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.appliances.DollBlock;
import net.yirmiri.urban_decor.common.block_entity.model.doll.DollModel;
import net.yirmiri.urban_decor.core.registry.UDComponents;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntityWithoutLevelRenderer.class)
public abstract class BlockEntityWithoutLevelRendererMixin {
    @Final @Shadow private EntityModelSet entityModelSet;
    @Unique private DollModel<Entity> urbanDecor$dollModel;

    @Inject(method = "onResourceManagerReload", at = @At("TAIL"))
    private void urbanDecor$initModel(ResourceManager resourceManager, CallbackInfo ci) {
        urbanDecor$dollModel = new DollModel<>(this.entityModelSet.bakeLayer(DollModel.LAYER_LOCATION));
    }

    @Inject(method = "renderByItem", at = @At("HEAD"), cancellable = true)
    private void urbanDecor$renderDoll(ItemStack stack, ItemDisplayContext ctx, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, CallbackInfo ci) {
        if (!(stack.getItem() instanceof BlockItem blockItem)) return;
        if (!(blockItem.getBlock() instanceof DollBlock)) return;

        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5D, 0.5D);
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));

        ResourceLocation texture = stack.get(UDComponents.DOLL_TEXTURE.get());
        if (texture == null) {
            texture = RunicLib.customid(UrbanDecor.MOD_ID, "textures/entity/doll/doll.png");
        }

        VertexConsumer consumer = buffer.getBuffer(RenderType.entityTranslucent(texture));
        urbanDecor$dollModel.renderToBuffer(poseStack, consumer, packedLight, packedOverlay, 0xFFFFFFFF);

        poseStack.popPose();
        ci.cancel();
    }
}

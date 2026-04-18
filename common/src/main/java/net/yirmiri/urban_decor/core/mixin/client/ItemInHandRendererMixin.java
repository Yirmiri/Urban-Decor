package net.yirmiri.urban_decor.core.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandRenderer.class)
public abstract class ItemInHandRendererMixin {

    @Shadow
    protected abstract void renderPlayerArm(PoseStack poseStack, MultiBufferSource buffer, int packedLight, float equippedProgress, float swingProgress, HumanoidArm arm);

    @Inject(method = "renderArmWithItem", at = @At("TAIL"))
    private void urbanDecor$renderArmWithItem(AbstractClientPlayer player, float partialTicks, float pitch, InteractionHand hand, float swingProgress, ItemStack stack, float equippedProgress, PoseStack poseStack, MultiBufferSource buffer, int packedLight, CallbackInfo ci) {
        if (!stack.is(UDBlocks.DOLL.get().asItem())) {
            return;
        }

        poseStack.pushPose();
        poseStack.translate(0.0F, 0.0F, -0.1F);

        this.renderPlayerArm(poseStack, buffer, packedLight, equippedProgress, swingProgress, (hand == InteractionHand.MAIN_HAND)
                ? player.getMainArm() : player.getMainArm().getOpposite());
        poseStack.popPose();
    }
}
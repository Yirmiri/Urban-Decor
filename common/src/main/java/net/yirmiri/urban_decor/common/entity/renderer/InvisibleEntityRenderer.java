package net.yirmiri.urban_decor.common.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.yirmiri.urban_decor.UrbanDecor;

@Environment(EnvType.CLIENT)
public class InvisibleEntityRenderer extends EntityRenderer<Entity> {
    public InvisibleEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(net.minecraft.world.entity.Entity entity) {
        return ResourceLocation.tryBuild(UrbanDecor.MOD_ID, "textures/literally_nothing");
    }
}

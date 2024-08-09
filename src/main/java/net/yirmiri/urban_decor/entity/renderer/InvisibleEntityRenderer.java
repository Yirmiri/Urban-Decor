package net.yirmiri.urban_decor.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;

@Environment(EnvType.CLIENT)
public class InvisibleEntityRenderer extends EntityRenderer<Entity> {
    public InvisibleEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(net.minecraft.entity.Entity entity) {
        return Identifier.of(UrbanDecor.MOD_ID, "textures/literally_nothing");
    }
}

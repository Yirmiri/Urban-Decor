package net.yirmiri.urban_decor.misc;

import net.azurune.runiclib.RunicLib;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.sewing_machine.SewingRecipeReloadListener;

public class FabricSewingRecipeReloadListener extends SewingRecipeReloadListener implements IdentifiableResourceReloadListener {
    private static final ResourceLocation ID = RunicLib.customid(UrbanDecor.MOD_ID, "dolls");

    @Override
    public ResourceLocation getFabricId() {
        return ID;
    }
}

package net.yirmiri.urban_decor.common.block.sewing_machine;

import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.yirmiri.urban_decor.common.util.SewingRecipes;

public class SewingRecipeReloadListener extends SimplePreparableReloadListener<Void> {

    @Override
    protected Void prepare(ResourceManager resourceManager, ProfilerFiller profiler) {
        return null;
    }

    @Override
    protected void apply(Void object, ResourceManager resourceManager, ProfilerFiller profiler) {
        SewingRecipes.reload(resourceManager);
    }
}
//Thanks to @TheArtyrian (GitHub), for letting me use their mixin

package net.yirmiri.urban_decor.core.mixin;

import com.google.common.collect.Lists;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SplashManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.yirmiri.urban_decor.UrbanDecor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Mixin(SplashManager.class)
public abstract class SplashManagerMixin {

    @Unique
    private final List<String> moddedTexts = Lists.newArrayList();

    @Unique
    private static final ResourceLocation MODDED_SPLASHES = ResourceLocation.fromNamespaceAndPath(UrbanDecor.MOD_ID, "texts/splashes.txt");

    @ModifyReturnValue(method = "prepare(Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)Ljava/util/List;", at = @At("RETURN"))
    protected List<String> urbanDecor$addSplashes(List<String> original, @Local(argsOnly = true) ResourceManager resourceManager, @Local(argsOnly = true) ProfilerFiller profiler) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Minecraft.getInstance().getResourceManager().open(MODDED_SPLASHES),
                StandardCharsets.UTF_8))) {
            List<String> customSplashes = reader.lines()
                    .map(String::trim)
                    .filter(s -> s.hashCode() != 125780783) // Exclude "missingno"
                    .collect(Collectors.toList());
            original.addAll(customSplashes);
            return original;
        } catch (IOException e) {
            // Optionally log the error
            return original;
        }
    }

    @Inject(method = "apply(Ljava/util/List;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("TAIL"))
    protected void urbanDecor$applyNewSplashes(List<String> list, ResourceManager resourceManager, ProfilerFiller profiler, CallbackInfo ci) {
        this.moddedTexts.addAll(list);
    }
}
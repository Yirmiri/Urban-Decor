package net.yirmiri.urban_decor.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDDamageTypes {
    public static final ResourceKey<DamageType> TOASTER = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, "toaster"));
    public static final ResourceKey<DamageType> WET_TOASTER = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, "wet_toaster"));

    public static DamageSource of(Level world, ResourceKey<DamageType> key) {
        return new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key));
    }
}

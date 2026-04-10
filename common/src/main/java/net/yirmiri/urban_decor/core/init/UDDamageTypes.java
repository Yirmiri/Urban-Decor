package net.yirmiri.urban_decor.core.init;

import net.azurune.runiclib.RunicLib;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDDamageTypes {
    public static final ResourceKey<DamageType> TOASTER = ResourceKey.create(Registries.DAMAGE_TYPE, RunicLib.customid(UrbanDecor.MOD_ID, "toaster"));
    public static final ResourceKey<DamageType> WET_TOASTER = ResourceKey.create(Registries.DAMAGE_TYPE, RunicLib.customid(UrbanDecor.MOD_ID, "wet_toaster"));

    public static DamageSource create(Level world, ResourceKey<DamageType> key) {
        return new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key));
    }
}

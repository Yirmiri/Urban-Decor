package net.yirmiri.urban_decor.init;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDDamageTypes {
    public static final RegistryKey<DamageType> TOASTER = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(UrbanDecor.MOD_ID, "toaster"));
    public static final RegistryKey<DamageType> WET_TOASTER = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(UrbanDecor.MOD_ID, "wet_toaster"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}

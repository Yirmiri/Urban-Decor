package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.RunicLib;
import net.azurune.runiclib.core.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.yirmiri.urban_decor.UrbanDecor;

import java.util.function.Supplier;

public class UDSounds {
    public static final Supplier<SoundEvent> APPLIANCE_OPEN = register("block.appliance.open");
    public static final Supplier<SoundEvent> SATELITE_RECIEVE_SIGNAL = register("block.satellite.receive_signal");
    public static final Supplier<SoundEvent> SATELITE_RECIEVE_SIGNAL_RARE = register("block.satellite.receive_signal_rare");

    private static Supplier<SoundEvent> register(String id) {
        return Services.REGISTRY.register(BuiltInRegistries.SOUND_EVENT, UrbanDecor.MOD_ID, id, () -> SoundEvent.createVariableRangeEvent(RunicLib.customid(UrbanDecor.MOD_ID, id)));
    }

    public static void loadSounds() {
    }
}

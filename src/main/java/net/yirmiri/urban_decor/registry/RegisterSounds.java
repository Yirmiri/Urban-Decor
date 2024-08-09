package net.yirmiri.urban_decor.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;

public class RegisterSounds {
    //OPEN
    public static final SoundEvent FRIDGE_OPEN = register("block.fridge.open");

    private static SoundEvent register(String id) {
        return Registry.register(Registries.SOUND_EVENT, Identifier.of(UrbanDecor.MOD_ID, id), SoundEvent.of(Identifier.of(UrbanDecor.MOD_ID, id)));
    }

    public static void loadSounds() {
    }
}

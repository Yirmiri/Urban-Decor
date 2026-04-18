package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.RunicLib;
import net.azurune.runiclib.core.platform.RLServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.yirmiri.urban_decor.UrbanDecor;

import java.util.function.Supplier;

public class UDSounds {
    //APPLIANCE
    public static final Supplier<SoundEvent> GENERIC_APPLIANCE_OPEN = register("block.appliance.open");
    public static final Supplier<SoundEvent> FAUCET_TURN = register("block.faucet.turn");
    public static final Supplier<SoundEvent> SMOOTH_OPEN = register("block.smooth.open");
    public static final Supplier<SoundEvent> SMOOTH_CLOSE = register("block.smooth.close");
    public static final Supplier<SoundEvent> METALLIC_OPEN = register("block.metallic.open");
    public static final Supplier<SoundEvent> METALLIC_CLOSE = register("block.metallic.close");

    //ITEM
    public static final Supplier<SoundEvent> WRAP_USE = register("item.wrap.use");
    public static final Supplier<SoundEvent> SEW = register("item.sew.use");

    //SPEAKER
    public static final Supplier<SoundEvent> SPEAKER_FLUORESCENT = register("block.speaker.fluorescent");

    //GRAND CLOCK
    public static final Supplier<SoundEvent> GRAND_CLOCK_TICK = register("block.grand_clock.tick");
    public static final Supplier<SoundEvent> GRAND_CLOCK_TOCK = register("block.grand_clock.tock");
    public static final Supplier<SoundEvent> GRAND_CLOCK_CHIME_DAY = register("block.grand_clock.chime_day");
    public static final Supplier<SoundEvent> GRAND_CLOCK_CHIME_NIGHT = register("block.grand_clock.chime_night");
    public static final Supplier<SoundEvent> GRAND_CLOCK_CHIME_3AM = register("block.grand_clock.chime_3am");

    //SATELLITE DISH
    public static final Supplier<SoundEvent> SATELITE_RECIEVE_SIGNAL = register("block.satellite.receive_signal");
    public static final Supplier<SoundEvent> SATELITE_RECIEVE_SIGNAL_RARE = register("block.satellite.receive_signal_rare");

    private static Supplier<SoundEvent> register(String id) {
        return RLServices.REGISTRY.register(BuiltInRegistries.SOUND_EVENT, UrbanDecor.MOD_ID, id, () -> SoundEvent.createVariableRangeEvent(RunicLib.customid(UrbanDecor.MOD_ID, id)));
    }

    public static void loadSounds() {
    }
}

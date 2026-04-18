package net.yirmiri.urban_decor;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.yirmiri.urban_decor.common.block.sewing_machine.SewingRecipeReloadListener;

@EventBusSubscriber(modid = UrbanDecor.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class NeoForgeEvents {

    @SubscribeEvent
    public static void onAddReloadListeners(AddReloadListenerEvent event) {
        event.addListener(new SewingRecipeReloadListener());
    }
}
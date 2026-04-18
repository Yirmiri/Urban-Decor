package net.yirmiri.urban_decor;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.yirmiri.urban_decor.common.block.sewing_machine.SewingMachineScreen;
import net.yirmiri.urban_decor.core.registry.UDMenus;

@EventBusSubscriber(modid = UrbanDecor.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NeoForgeUrbanDecorEvents {

    @SubscribeEvent
    public static void onRegisterScreens(RegisterMenuScreensEvent event) {
        event.register(UDMenus.SEWING_MACHINE.get(), SewingMachineScreen::new);
    }
}

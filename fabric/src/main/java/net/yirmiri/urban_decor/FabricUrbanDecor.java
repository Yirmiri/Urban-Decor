package net.yirmiri.urban_decor;

import net.fabricmc.api.ModInitializer;
import net.yirmiri.urban_decor.init.UDRegistries;

public class FabricUrbanDecor implements ModInitializer {
    
    @Override
    public void onInitialize() {
        UrbanDecor.init();

        UDRegistries.loadRegistries();
    }
}

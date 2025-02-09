package net.yirmiri.urban_decor.compat;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;

import java.util.Optional;

public class UDPacks {
    private static void registerBuiltinResourcePack(ModContainer container, String id) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                Identifier.of(UrbanDecor.MOD_ID, id + "_resource_pack"), container, Text.translatable("pack." + UrbanDecor.MOD_ID + "." + id + "_compat"), ResourcePackActivationType.ALWAYS_ENABLED
        );
    }

    private static void registerBuiltinDataPack(ModContainer container, String id) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                Identifier.of(UrbanDecor.MOD_ID, id + "_data_pack"), container, Text.translatable("pack." + UrbanDecor.MOD_ID + "." + id + "_compat"), ResourcePackActivationType.ALWAYS_ENABLED
        );
    }

    public static void loadPacks() {
        Optional<ModContainer> container = FabricLoader.getInstance().getModContainer(UrbanDecor.MOD_ID);
        if (container.isPresent()) {
            if (UrbanDecor.isModLoaded("excessive_building")) {
                registerBuiltinResourcePack(container.get(), "excessive_building");
                registerBuiltinDataPack(container.get(), "excessive_building");
            }
        }
    }
}

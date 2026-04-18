package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.core.platform.RLServices;
import net.azurune.runiclib.core.platform.services.RLRegistryHelper;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import java.util.function.Supplier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.sewing_machine.SewingMachineMenu;

public class UDMenus {
    public static final Supplier<MenuType<SewingMachineMenu>> SEWING_MACHINE = register("sewing_machine", SewingMachineMenu::new);

    private static <T extends AbstractContainerMenu> Supplier<MenuType<T>> register(String id, RLRegistryHelper.MenuSupplier<T> factory) {
        return RLServices.REGISTRY.registerMenu(UrbanDecor.MOD_ID, id, factory);
    }

    public static void load() {
    }
}
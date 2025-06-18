package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.core.platform.Services;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.entity.*;

import java.util.function.Supplier;

public class UDBlockEntities {
    public static final Supplier<BlockEntityType<ToasterBlockEntity>> TOASTER = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "toaster", () -> Services.REGISTRY.createBlockEntity(ToasterBlockEntity::new,
                    UDBlocks.TOASTER.get()));

    public static final Supplier<BlockEntityType<StorageApplianceBlockEntity>> STORAGE_APPLIANCE = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "storage_appliance", () -> Services.REGISTRY.createBlockEntity(StorageApplianceBlockEntity::new,
                    UDBlocks.CUPBOARD.get(), UDBlocks.DARK_CUPBOARD.get(), UDBlocks.FRIDGE.get(), UDBlocks.DARK_FRIDGE.get(), UDBlocks.FILING_CABINET.get(),
                    UDBlocks.FREEZER.get(), UDBlocks.DARK_FREEZER.get(), UDBlocks.WASHING_MACHINE.get(), UDBlocks.DARK_WASHING_MACHINE.get(),
                    UDBlocks.DRYER.get(), UDBlocks.DARK_DRYER.get(), UDBlocks.TOOLBOX.get(), UDBlocks.DISHWASHER.get(), UDBlocks.DARK_DISHWASHER.get()));

    public static final Supplier<BlockEntityType<FurnaceDecorBlockEntity>> FURNACE_DECOR = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "furnace_decor", () -> Services.REGISTRY.createBlockEntity(FurnaceDecorBlockEntity::new,
                    UDBlocks.MICROWAVE.get(), UDBlocks.WALL_MICROWAVE.get()));

    public static final Supplier<BlockEntityType<SmokerDecorBlockEntity>> SMOKER_DECOR = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "smoker_decor", () -> Services.REGISTRY.createBlockEntity(SmokerDecorBlockEntity::new,
                    UDBlocks.OVEN.get(), UDBlocks.DARK_OVEN.get()));

    public static final Supplier<BlockEntityType<DestroyStorageApplianceBlockEntity>> DESTROY_STORAGE_APPLIANCE = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "destroy_storage_appliance", () -> Services.REGISTRY.createBlockEntity(DestroyStorageApplianceBlockEntity::new,
                    UDBlocks.TRASH_CAN.get()));


    public static void loadBlockEntities() {
    }
}

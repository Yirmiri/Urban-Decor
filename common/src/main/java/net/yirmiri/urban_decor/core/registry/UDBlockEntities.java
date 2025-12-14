package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.core.platform.Services;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.entity.*;

import java.util.function.Supplier;

public class UDBlockEntities {
    public static final Supplier<BlockEntityType<ToasterBlockEntity>> TOASTER = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "toaster", () -> Services.REGISTRY.createBlockEntity(ToasterBlockEntity::new,
                    UDBlocks.TOASTER.get()
            ));

    public static final Supplier<BlockEntityType<StorageDecorBlockEntity>> STORAGE_APPLIANCE = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "storage_appliance", () -> Services.REGISTRY.createBlockEntity(StorageDecorBlockEntity::new,
                    UDBlocks.CUPBOARD.get(), UDBlocks.DARK_CUPBOARD.get(), UDBlocks.FRIDGE.get(), UDBlocks.DARK_FRIDGE.get(), UDBlocks.FILING_CABINET.get(),
                    UDBlocks.FREEZER.get(), UDBlocks.DARK_FREEZER.get(), UDBlocks.WASHING_MACHINE.get(), UDBlocks.DARK_WASHING_MACHINE.get(),
                    UDBlocks.DRYER.get(), UDBlocks.DARK_DRYER.get(), UDBlocks.TOOLBOX.get(), UDBlocks.DISHWASHER.get(), UDBlocks.DARK_DISHWASHER.get(),
                    UDBlocks.OAK_BOX.get(), UDBlocks.SPRUCE_BOX.get(), UDBlocks.BIRCH_BOX.get(), UDBlocks.JUNGLE_BOX.get(),
                    UDBlocks.ACACIA_BOX.get(), UDBlocks.DARK_OAK_BOX.get(), UDBlocks.MANGROVE_BOX.get(), UDBlocks.CHERRY_BOX.get(),
                    UDBlocks.BAMBOO_BOX.get(), UDBlocks.CRIMSON_BOX.get(), UDBlocks.WARPED_BOX.get()
            ));

    public static final Supplier<BlockEntityType<FurnaceDecorBlockEntity>> FURNACE_DECOR = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "furnace_decor", () -> Services.REGISTRY.createBlockEntity(FurnaceDecorBlockEntity::new,
                    UDBlocks.MICROWAVE.get(), UDBlocks.WALL_MICROWAVE.get()
            ));

    public static final Supplier<BlockEntityType<SmokerDecorBlockEntity>> SMOKER_DECOR = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "smoker_decor", () -> Services.REGISTRY.createBlockEntity(SmokerDecorBlockEntity::new,
                    UDBlocks.OVEN.get(), UDBlocks.DARK_OVEN.get()
            ));

    public static final Supplier<BlockEntityType<DestroyStorageApplianceBlockEntity>> DESTROY_STORAGE_APPLIANCE = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "destroy_storage_appliance", () -> Services.REGISTRY.createBlockEntity(DestroyStorageApplianceBlockEntity::new,
                    UDBlocks.TRASH_CAN.get()
            ));

    public static final Supplier<BlockEntityType<WallClockBlockEntity>> WALL_CLOCK = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "wall_clock", () -> Services.REGISTRY.createBlockEntity(WallClockBlockEntity::new,
                    UDBlocks.WALL_CLOCK.get()
            ));

    public static final Supplier<BlockEntityType<GrandBlockEntity>> GRAND_CLOCK = Services.REGISTRY.registerBlockEntityType(
            UrbanDecor.MOD_ID, "grand_clock", () -> Services.REGISTRY.createBlockEntity(GrandBlockEntity::new,
                    UDBlocks.OAK_GRANDFATHER_CLOCK.get(), UDBlocks.SPRUCE_GRANDFATHER_CLOCK.get(),
                    UDBlocks.BIRCH_GRANDFATHER_CLOCK.get(), UDBlocks.JUNGLE_GRANDFATHER_CLOCK.get(),
                    UDBlocks.ACACIA_GRANDFATHER_CLOCK.get(), UDBlocks.DARK_OAK_GRANDFATHER_CLOCK.get(),
                    UDBlocks.MANGROVE_GRANDFATHER_CLOCK.get(), UDBlocks.CHERRY_GRANDFATHER_CLOCK.get(),
                    UDBlocks.CRIMSON_GRANDFATHER_CLOCK.get(), UDBlocks.WARPED_GRANDFATHER_CLOCK.get(),
                    UDBlocks.BAMBOO_GRANDFATHER_CLOCK.get()
            ));

    public static void loadBlockEntities() {
    }
}

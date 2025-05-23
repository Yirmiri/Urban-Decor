package net.yirmiri.urban_decor.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.block.entity.*;

public class UDBlockEntities {
    public static final BlockEntityType<ToasterBlockEntity> TOASTER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "toaster"), FabricBlockEntityTypeBuilder.create(ToasterBlockEntity::new,
                    UDBlocks.TOASTER.get()).build());

    public static final BlockEntityType<StorageApplianceBlockEntity> STORAGE_APPLIANCE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "storage_appliance"), FabricBlockEntityTypeBuilder.create(StorageApplianceBlockEntity::new,
                    UDBlocks.CUPBOARD.get(), UDBlocks.DARK_CUPBOARD.get(), UDBlocks.FRIDGE.get(), UDBlocks.DARK_FRIDGE.get(), UDBlocks.FILING_CABINET.get(),
                    UDBlocks.FREEZER.get(), UDBlocks.DARK_FREEZER.get(), UDBlocks.WASHING_MACHINE.get(), UDBlocks.DARK_WASHING_MACHINE.get(), UDBlocks.DRYER.get(),
                    UDBlocks.DARK_DRYER.get(), UDBlocks.TOOLBOX.get()).build());

    public static final BlockEntityType<FurnaceDecorBlockEntity> FURNACE_DECOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "furnace_decor"), FabricBlockEntityTypeBuilder.create(FurnaceDecorBlockEntity::new,
                    UDBlocks.MICROWAVE.get(), UDBlocks.WALL_MICROWAVE.get()).build());

    public static final BlockEntityType<SmokerDecorBlockEntity> SMOKER_DECOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "smoker_decor"), FabricBlockEntityTypeBuilder.create(SmokerDecorBlockEntity::new,
                    UDBlocks.OVEN.get(), UDBlocks.DARK_OVEN.get()).build());

    public static final BlockEntityType<MiniStorageApplianceBlockEntity> MINI_STORAGE_APPLIANCE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "mini_storage_appliance"), FabricBlockEntityTypeBuilder.create(MiniStorageApplianceBlockEntity::new,
                    UDBlocks.TRASH_CAN.get()).build());

    public static void loadBlockEntities() {
    }
}

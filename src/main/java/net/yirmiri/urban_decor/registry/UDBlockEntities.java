package net.yirmiri.urban_decor.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.block.entity.ToasterBlockEntity;
import net.yirmiri.urban_decor.block.entity.StorageApplianceBlockEntity;

public class UDBlockEntities {
    public static final BlockEntityType<ToasterBlockEntity> TOASTER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "toaster"), FabricBlockEntityTypeBuilder.create(ToasterBlockEntity::new, UDBlocks.TOASTER).build());

    public static final BlockEntityType<StorageApplianceBlockEntity> STORAGE_APPLIANCE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "storage_appliance"), FabricBlockEntityTypeBuilder.create(StorageApplianceBlockEntity::new,
                    UDBlocks.CUPBOARD, UDBlocks.DARK_CUPBOARD, UDBlocks.FRIDGE, UDBlocks.DARK_FRIDGE, UDBlocks.FREEZER, UDBlocks.DARK_FREEZER).build());

    public static void loadBlockEntities() {
    }
}

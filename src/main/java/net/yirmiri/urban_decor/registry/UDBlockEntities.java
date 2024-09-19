package net.yirmiri.urban_decor.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.block.entity.FurnaceDecorBlockEntity;
import net.yirmiri.urban_decor.block.entity.SmokerDecorBlockEntity;
import net.yirmiri.urban_decor.block.entity.ToasterBlockEntity;
import net.yirmiri.urban_decor.block.entity.StorageApplianceBlockEntity;

public class UDBlockEntities {
    public static final BlockEntityType<ToasterBlockEntity> TOASTER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "toaster"), FabricBlockEntityTypeBuilder.create(ToasterBlockEntity::new,
                    UDBlocks.TOASTER).build());

    public static final BlockEntityType<StorageApplianceBlockEntity> STORAGE_APPLIANCE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "storage_appliance"), FabricBlockEntityTypeBuilder.create(StorageApplianceBlockEntity::new,
                    UDBlocks.CUPBOARD, UDBlocks.DARK_CUPBOARD, UDBlocks.FRIDGE, UDBlocks.DARK_FRIDGE, UDBlocks.FILING_CABINET, UDBlocks.FREEZER,
                    UDBlocks.DARK_FREEZER, UDBlocks.TOOLBOX).build());

    public static final BlockEntityType<FurnaceDecorBlockEntity> FURNACE_DECOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "furnace_decor"), FabricBlockEntityTypeBuilder.create(FurnaceDecorBlockEntity::new,
                    UDBlocks.MICROWAVE, UDBlocks.WALL_MICROWAVE).build());

    public static final BlockEntityType<SmokerDecorBlockEntity> SMOKER_DECOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UrbanDecor.MOD_ID, "smoker_decor"), FabricBlockEntityTypeBuilder.create(SmokerDecorBlockEntity::new,
                    UDBlocks.OVEN, UDBlocks.DARK_OVEN).build());

    public static void loadBlockEntities() {
    }
}

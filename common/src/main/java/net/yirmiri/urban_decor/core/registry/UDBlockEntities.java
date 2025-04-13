package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.core.platform.Services;
import net.azurune.runiclib.core.platform.services.RLRegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.block.entity.*;

import java.util.function.Supplier;

public class UDBlockEntities {
//    public static final BlockEntityType<ToasterBlockEntity> TOASTER = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
//            ResourceLocation.tryBuild(UrbanDecor.MOD_ID, "toaster"), FabricBlockEntityTypeBuilder.create(ToasterBlockEntity::new,
//                    UDBlocks.TOASTER.get()).build());
//
//    public static final BlockEntityType<StorageApplianceBlockEntity> STORAGE_APPLIANCE = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
//            ResourceLocation.tryBuild(UrbanDecor.MOD_ID, "storage_appliance"), FabricBlockEntityTypeBuilder.create(StorageApplianceBlockEntity::new,
//                    UDBlocks.CUPBOARD.get(), UDBlocks.DARK_CUPBOARD.get(), UDBlocks.FRIDGE.get(), UDBlocks.DARK_FRIDGE.get(), UDBlocks.FILING_CABINET.get(),
//                    UDBlocks.FREEZER.get(), UDBlocks.DARK_FREEZER.get(), UDBlocks.WASHING_MACHINE.get(), UDBlocks.DARK_WASHING_MACHINE.get(), UDBlocks.DRYER.get(),
//                    UDBlocks.DARK_DRYER.get(), UDBlocks.TOOLBOX.get()).build());
//
//    public static final BlockEntityType<FurnaceDecorBlockEntity> FURNACE_DECOR = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
//            ResourceLocation.tryBuild(UrbanDecor.MOD_ID, "furnace_decor"), FabricBlockEntityTypeBuilder.create(FurnaceDecorBlockEntity::new,
//                    UDBlocks.MICROWAVE.get(), UDBlocks.WALL_MICROWAVE.get()).build());
//
//    public static final BlockEntityType<SmokerDecorBlockEntity> SMOKER_DECOR = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
//            ResourceLocation.tryBuild(UrbanDecor.MOD_ID, "smoker_decor"), FabricBlockEntityTypeBuilder.create(SmokerDecorBlockEntity::new,
//                    UDBlocks.OVEN.get(), UDBlocks.DARK_OVEN.get()).build());
//
//        public static final Supplier<BlockEntityType<MiniStorageApplianceBlockEntity>> MINI_STORAGE_APPLIANCE = register(
//            ResourceLocation.tryBuild(UrbanDecor.MOD_ID, "mini_storage_appliance"), BlockEntityType.Builder.of(MiniStorageApplianceBlockEntity::new,
//                    UDBlocks.TRASH_CAN.get())
//                        .build(UrbanDecor.MOD_ID, "mini_storage_appliance"));

    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> register(String id, Supplier<BlockEntityType<T>> supplier, RLRegistryHelper.BlockEntitySupplier<T> builder, Supplier<Block>... blocks) {
        return Services.REGISTRY.registerBlockEntityType(UrbanDecor.MOD_ID, id, supplier, builder, blocks);
    }

    public static void loadBlockEntities() {
    }
}

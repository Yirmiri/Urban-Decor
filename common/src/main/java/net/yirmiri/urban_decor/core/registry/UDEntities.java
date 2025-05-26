package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.core.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Block;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.entity.ToiletEntity;

import java.util.function.Supplier;

public class UDEntities {
    //MISC
    public static final Supplier<EntityType<ToiletEntity>> TOILET = register("toilet", () -> EntityType.Builder.of(ToiletEntity::new, MobCategory.MISC)
                    .noSummon().clientTrackingRange(4).sized(0.5F, 0.1F).build(UrbanDecor.MOD_ID + ":" + "toilet"));

    private static <T extends EntityType<?>> Supplier<T> register(String id, Supplier<T> supplier) {
        return Services.REGISTRY.registerEntityType(UrbanDecor.MOD_ID, id, supplier);
    }

    public static void loadEntities() {
    }
}

package net.yirmiri.urban_decor.core.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.entity.ToiletEntity;

public class UDEntities {

    public static final EntityType<ToiletEntity> TOILET = register("toilet", EntityType.Builder.of(ToiletEntity::new, MobCategory.MISC)
            .noSummon().sized(0.5F, 0.1F).build("toilet"));

    private static <T extends Entity, E extends EntityType<T>> EntityType<T> register(String id, E entity) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, id), entity);
    }

    public static void loadEntities() {
    }
}

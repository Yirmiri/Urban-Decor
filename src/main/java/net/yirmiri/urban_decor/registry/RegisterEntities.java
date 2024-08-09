package net.yirmiri.urban_decor.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.entity.ToiletEntity;

public class RegisterEntities {

    public static final EntityType<ToiletEntity> TOILET = register("toilet", EntityType.Builder.create(ToiletEntity::new, SpawnGroup.MISC)
            .disableSummon().setDimensions(0.5F, 0.1F).build("toilet"));

    private static <T extends Entity, E extends EntityType<T>> EntityType<T> register(String id, E entity) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(UrbanDecor.MOD_ID, id), entity);
    }

    public static void loadEntities() {
    }
}

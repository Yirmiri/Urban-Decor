package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.core.platform.Services;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.entity.SeatEntity;

import java.util.function.Supplier;

public class UDEntities {
    //MISC
    public static final Supplier<EntityType<SeatEntity>> SEAT = register("seat", () -> EntityType.Builder.of(SeatEntity::new, MobCategory.MISC)
                    .noSummon().clientTrackingRange(4).sized(0.5F, 0.1F).build(UrbanDecor.MOD_ID + ":" + "seat"));

    private static <T extends EntityType<?>> Supplier<T> register(String id, Supplier<T> supplier) {
        return Services.REGISTRY.registerEntityType(UrbanDecor.MOD_ID, id, supplier);
    }

    public static void loadEntities() {
    }
}

package net.yirmiri.urban_decor.core.registry;

import net.azurune.runiclib.core.platform.RLServices;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.ResourceLocation;
import net.yirmiri.urban_decor.UrbanDecor;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class UDComponents {
    public static final Supplier<DataComponentType<ResourceLocation>> DOLL_TEXTURE = registerComponent("doll_texture", builder ->
            builder.persistent(ResourceLocation.CODEC).networkSynchronized(ResourceLocation.STREAM_CODEC));

    private static <T> Supplier<DataComponentType<T>> registerComponent(String id, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return RLServices.REGISTRY.registerComponentType(UrbanDecor.MOD_ID, id, builder);
    }

    public static void load() {
    }
}
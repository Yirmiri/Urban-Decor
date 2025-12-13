package net.yirmiri.urban_decor.common.util;

import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.material.MapColor;

import java.util.function.IntFunction;

public enum WrapColor implements StringRepresentable {
    CHERRY(0, "cherry", MapColor.COLOR_RED),
    DAFFODIL(1, "daffodil", MapColor.COLOR_YELLOW),
    SPRING(2, "spring", MapColor.COLOR_LIGHT_GREEN),
    MINT(3, "mint", MapColor.WARPED_WART_BLOCK),
    AZURE(4, "azure", MapColor.COLOR_BLUE),
    RUBY(5, "ruby", MapColor.COLOR_PINK);

    private static final IntFunction<WrapColor> BY_ID = ByIdMap.continuous(WrapColor::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final StringRepresentable.EnumCodec<WrapColor> CODEC = StringRepresentable.fromEnum(WrapColor::values);
    private final int id;
    private final String name;
    private final MapColor color;

    WrapColor(int j, String string2, MapColor color) {
        this.id = j;
        this.name = string2;
        this.color = color;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }

    public MapColor getMapColor() {
        return this.color;
    }

    public static WrapColor byId(int i) {
        return BY_ID.apply(i);
    }
}

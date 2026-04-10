package net.yirmiri.urban_decor.common.block.enums;

import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

public enum WrapType implements StringRepresentable {
    CHERRY(0, "cherry"),
    DAFFODIL(1, "daffodil"),
    SPRING(2, "spring"),
    MINT(3, "mint"),
    AZURE(4, "azure"),
    RUBY(5, "ruby"),
    NONE(6, "none")
    ;

    private static final IntFunction<WrapType> BY_ID = ByIdMap.continuous(WrapType::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    private final int id;
    private final String name;

    WrapType(int j, String name) {
        this.id = j;
        this.name = name;
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

    public static WrapType byId(int i) {
        return BY_ID.apply(i);
    }
}


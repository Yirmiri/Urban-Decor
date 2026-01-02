package net.yirmiri.urban_decor.common.block.enums;

import net.minecraft.util.StringRepresentable;

public enum ConnectionType implements StringRepresentable {
    SINGLE("single"),
    MIDDLE("middle"),
    LEFT("left"),
    RIGHT("right"),
    TOP("top"),
    BOTTOM("bottom")
    ;

    private final String id;

    ConnectionType(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public String getSerializedName() {
        return this.id;
    }
}

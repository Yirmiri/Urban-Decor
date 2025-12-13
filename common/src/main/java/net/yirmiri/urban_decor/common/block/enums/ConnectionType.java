package net.yirmiri.urban_decor.common.block.enums;

import net.minecraft.util.StringRepresentable;

public enum ConnectionType implements StringRepresentable {
    SINGLE("single"),
    TOP("top"),
    MIDDLE("middle"),
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

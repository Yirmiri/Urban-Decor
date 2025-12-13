package net.yirmiri.urban_decor.common.item;

import net.minecraft.world.item.Item;
import net.yirmiri.urban_decor.common.util.WrapColor;

public class WrapItem extends Item {
    private WrapColor wrapColor;

    public WrapItem(Properties properties, WrapColor wrapColor) {
        super(properties);
        this.wrapColor = wrapColor;
    }
}

package net.yirmiri.urban_decor.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;

public class StainlessSteelChairBlockEntity extends BlockEntity {
    public StainlessSteelChairBlockEntity(BlockPos pos, BlockState state) {
        super(UDBlockEntities.STAINLESS_STEEL_CHAIR.get(), pos, state);
    }
}

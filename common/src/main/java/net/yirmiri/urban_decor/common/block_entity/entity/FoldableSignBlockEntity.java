package net.yirmiri.urban_decor.common.block_entity.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;

public class FoldableSignBlockEntity extends BlockEntity {
    public FoldableSignBlockEntity(BlockPos pos, BlockState state) {
        super(UDBlockEntities.FOLDABLE_SIGN.get(), pos, state);
    }
}

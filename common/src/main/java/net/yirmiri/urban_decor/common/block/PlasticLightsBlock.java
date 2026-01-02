package net.yirmiri.urban_decor.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockState;

public class PlasticLightsBlock extends MultifaceBlock {
    public static final MapCodec<PlasticLightsBlock> CODEC = simpleCodec(PlasticLightsBlock::new);

    public PlasticLightsBlock(Properties properties) {
        super(properties);
    }

//    @Override
//    protected boolean isFaceSupported(Direction face) {
//        return face != Direction.UP && face != Direction.DOWN;
//    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return false;
    }

    @Override
    protected MapCodec<? extends MultifaceBlock> codec() {
        return CODEC;
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }
}

package net.yirmiri.urban_decor.common.block.appliances;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;

public class PlasticLightsBlock extends MultifaceBlock {
    public static final MapCodec<PlasticLightsBlock> CODEC = simpleCodec(PlasticLightsBlock::new);

    public PlasticLightsBlock(Properties properties) {
        super(properties);
    }

//    @Override
//    protected boolean isFaceSupported(Direction face) {
//        return face != Direction.UP && face != Direction.DOWN;
//    }

//    @Override
//    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
//        return false;
//    }

    @Override
    protected MapCodec<? extends MultifaceBlock> codec() {
        return CODEC;
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }
}

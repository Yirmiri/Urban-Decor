package net.yirmiri.urban_decor.common.block.appliances;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.core.registry.UDSounds;

public class SatelliteDishBlock extends AbstractDecorBlock {
    public static final BooleanProperty SIGNAL = BooleanProperty.create("signal");
    
    private static final VoxelShape SHAPE = Shapes.join(Block.box(1, 0, 1, 15, 13, 15),
            Block.box(1, 13, 1, 15, 16, 15), BooleanOp.OR);

    public SatelliteDishBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(SIGNAL, false));
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.getValue(SIGNAL) && level.dimension() != Level.NETHER) {
            if (random.nextInt(300) == 0) {
                level.playSound(null, pos, UDSounds.SATELITE_RECIEVE_SIGNAL.get(), SoundSource.BLOCKS, 0.7F, 1.0F);
                level.setBlock(pos, state.setValue(SIGNAL, true), 3);
                level.scheduleTick(pos, this, 400);
            }

            if (random.nextInt(1000) == 0) {
                level.playSound(null, pos, UDSounds.SATELITE_RECIEVE_SIGNAL_RARE.get(), SoundSource.BLOCKS, 0.6F, 1.0F);
                level.setBlock(pos, state.setValue(SIGNAL, true), 3);
                level.scheduleTick(pos, this, 400);
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(SIGNAL)) {
            level.setBlock(pos, state.setValue(SIGNAL, false), 3);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        state.getValue(FACING);
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, SIGNAL);
    }
}

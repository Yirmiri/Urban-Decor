package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;

public class DeskFanBlock extends AbstractDecorBlock {
    public static final BooleanProperty ON = BooleanProperty.create("on");

    private static final VoxelShape SHAPE = Block.box(5, 0, 5, 11, 12, 11);

    public DeskFanBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(ON, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        state.getValue(FACING);
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.isEmpty()) {
            world.setBlockAndUpdate(pos, state.cycle(ON));
            world.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON, SoundSource.BLOCKS, 0.8F, 1.0F, false);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, ON);
    }
}

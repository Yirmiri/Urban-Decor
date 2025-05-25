package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.common.util.UDUtils;
import org.jetbrains.annotations.Nullable;

public class TurbineBlock extends AbstractDecorBlock {
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 1);
    public static final BooleanProperty ON = BooleanProperty.create("on");

    private static final VoxelShape SHAPE = Shapes.join(Block.box(6, 0, 6, 10, 2, 10),
            Block.box(4, 2, 4, 12, 8, 12), BooleanOp.OR);

    public TurbineBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(ON, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        state.getValue(FACING);
        return SHAPE;
    }

    @Nullable @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(ON, Boolean.valueOf(ctx.getLevel().hasNeighborSignal(ctx.getClickedPos())));
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClientSide) {
            boolean bl = state.getValue(ON);
            if (bl != world.hasNeighborSignal(pos)) {
                if (bl) {
                    world.scheduleTick(pos, this, 4);
                } else {
                    world.setBlock(pos, state.cycle(ON), Block.UPDATE_CLIENTS);
                }
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockAndUpdate(pos, state.cycle(VARIANT));
            UDUtils.toolboxUsed(world, pos);
            player.displayClientMessage(Component.translatable("toolbox.turbine.variant_" + state.getValue(VARIANT)), true);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (state.getValue(ON) && !world.hasNeighborSignal(pos)) {
            world.setBlock(pos, state.cycle(ON), Block.UPDATE_CLIENTS);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, ON, VARIANT);
    }
}

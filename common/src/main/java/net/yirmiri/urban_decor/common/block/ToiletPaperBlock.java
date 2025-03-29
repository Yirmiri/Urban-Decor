package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.common.util.UDUtils;

public class ToiletPaperBlock extends AbstractDecorBlock {
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 1);

    private static final VoxelShape SHAPE_NORTH = Block.box(4, 6, 10, 12, 11, 15);
    private static final VoxelShape SHAPE_WEST = Block.box(10, 6, 4, 15, 11, 12);
    private static final VoxelShape SHAPE_EAST = Block.box(1, 6, 4, 6, 11, 12);
    private static final VoxelShape SHAPE_SOUTH = Block.box(4, 6, 1, 12, 11, 6);

    private static final VoxelShape SHAPE_COMMERCIAL_NORTH = Block.box(2, 4, 13, 14, 12, 16);
    private static final VoxelShape SHAPE_COMMERCIAL_WEST = Block.box(13, 4, 2, 16, 12, 14);
    private static final VoxelShape SHAPE_COMMERCIAL_EAST = Block.box(0, 4, 2, 3, 12, 14);
    private static final VoxelShape SHAPE_COMMERCIAL_SOUTH = Block.box(2, 4, 0, 14, 12, 3);

    public ToiletPaperBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(VARIANT, 0).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockAndUpdate(pos, state.cycle(VARIANT));
            UDUtils.toolboxUsed(world, pos);
            player.displayClientMessage(Component.translatable("toolbox.toilet_paper.variant_" + state.getValue(VARIANT)), true);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        int variant = state.getValue(VARIANT);
        boolean commercial = variant == 1;
        return switch (state.getValue(FACING)) {
            case SOUTH -> commercial ? SHAPE_COMMERCIAL_SOUTH : SHAPE_SOUTH;
            case WEST -> commercial ? SHAPE_COMMERCIAL_WEST : SHAPE_WEST;
            case EAST -> commercial ? SHAPE_COMMERCIAL_EAST : SHAPE_EAST;
            default -> commercial ? SHAPE_COMMERCIAL_NORTH : SHAPE_NORTH;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT);
    }
}

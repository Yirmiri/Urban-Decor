package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.core.init.UDTags;

public class RadiatorBlock extends AbstractDecorBlock {
    public static final BooleanProperty VERTICAL = BooleanProperty.create("vertical");

    private static final VoxelShape SHAPE_NORTH = Block.box(1, 2, 14, 15, 14, 16);
    private static final VoxelShape SHAPE_WEST = Block.box(14, 2, 1, 16, 14, 15);
    private static final VoxelShape SHAPE_EAST = Block.box(0, 2, 1, 2, 14, 15);
    private static final VoxelShape SHAPE_SOUTH = Block.box(1, 2, 0, 15, 14, 2);

    public RadiatorBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(VERTICAL, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (stackHand.is(UDTags.ItemT.TOOLBOXES)) {
            level.setBlockAndUpdate(pos, state.cycle(VERTICAL));
            UDUtils.toolboxUsed(level, pos);
            player.displayClientMessage(Component.translatable("toolbox.radiator.variant_" + state.getValue(VERTICAL)), true);
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VERTICAL);
    }
}

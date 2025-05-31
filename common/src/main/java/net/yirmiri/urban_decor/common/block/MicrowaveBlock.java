package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractFurnaceDecorBlock;
import net.yirmiri.urban_decor.core.init.UDTags;

public class MicrowaveBlock extends AbstractFurnaceDecorBlock {
    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    private static final VoxelShape SHAPE_NORTH = Block.box(2, 0, 5, 14, 8, 12);
    private static final VoxelShape SHAPE_EAST = Block.box(4, 0, 2, 11, 8, 14);
    private static final VoxelShape SHAPE_WEST = Block.box(5, 0, 2, 12, 8, 14);
    private static final VoxelShape SHAPE_SOUTH = Block.box(2, 0, 4, 14, 8, 11);

    public MicrowaveBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(TRUE_OPEN, false).setValue(OPEN, false));
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
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (!stackHand.is(UDTags.ItemT.TOOLBOXES) && !world.isClientSide && !player.isShiftKeyDown()) {
            this.openContainer(world, pos, player);
            return InteractionResult.SUCCESS;
        }
        if (!stackHand.is(UDTags.ItemT.TOOLBOXES) && player.isShiftKeyDown()) {
            world.setBlockAndUpdate(pos, state.cycle(OPEN).cycle(TRUE_OPEN));
            if (state.getValue(OPEN)) {
                world.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            } else if (!state.getValue(OPEN)) {
                world.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, LIT, TRUE_OPEN);
    }
}

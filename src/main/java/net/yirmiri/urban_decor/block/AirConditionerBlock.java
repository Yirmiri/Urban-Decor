package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.abstracts.AbstractDecorBlock;

public class AirConditionerBlock extends AbstractDecorBlock {
    public static final BooleanProperty ON = BooleanProperty.of("on");

    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(2, 0, 4, 14, 10, 16);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(0, 0, 2, 12, 10, 14);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(4, 0, 2, 16, 10, 14);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(2, 0, 0, 14, 10, 12);

    public AirConditionerBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(ON, false).with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false));//.with(VARIANT, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return switch (state.get(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        if (stackHand.isEmpty()) {
            world.setBlockState(pos, state.cycle(ON));
            world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.8F, 1.0F, false);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, ON);
    }
}

package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class AirConditionerBlock extends AbstractDecorBlock {
    public static final BooleanProperty ON = BooleanProperty.of("on");

    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(2, 0, 4, 14, 10, 16);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(0, 0, 2, 12, 10, 14);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(4, 0, 2, 16, 10, 14);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(2, 0, 0, 14, 10, 12);

    public AirConditionerBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(ON, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return switch (state.get(FACING)) {
            default -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
        };
    }

//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if (player.getMainHandStack().isEmpty()) {
//            world.setBlockState(pos, state.cycle(ON));
//            world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
//            return ActionResult.SUCCESS;
//        }
//        return ActionResult.PASS;
//    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, ON);
    }
}

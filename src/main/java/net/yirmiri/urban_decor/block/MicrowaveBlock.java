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
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.block.abstracts.AbstractFurnaceDecorBlock;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.util.UDUtils;

public class MicrowaveBlock extends AbstractFurnaceDecorBlock {
    public static final BooleanProperty OPEN = BooleanProperty.of("open");
    public static final BooleanProperty WALL = BooleanProperty.of("wall");

    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(2, 0, 5, 14, 8, 12);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(4, 0, 2, 11, 8, 14);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(5, 0, 2, 12, 8, 14);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(2, 0, 4, 14, 8, 11);

    private static final VoxelShape SHAPE_NORTH_WALL = Block.createCuboidShape(2, 6, 9, 14, 14, 16);
    private static final VoxelShape SHAPE_EAST_WALL = Block.createCuboidShape(0, 6, 2, 7, 14, 14);
    private static final VoxelShape SHAPE_WEST_WALL = Block.createCuboidShape(9, 6, 2, 16, 14, 14);
    private static final VoxelShape SHAPE_SOUTH_WALL = Block.createCuboidShape(2, 6, 0, 14, 14, 7);

    public MicrowaveBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(TRUE_OPEN, false).with(OPEN, false).with(WALL, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        boolean wall = state.get(WALL);
        return switch (state.get(FACING)) {
            case SOUTH -> wall ? SHAPE_SOUTH_WALL : SHAPE_SOUTH;
            case WEST -> wall ? SHAPE_WEST_WALL : SHAPE_WEST;
            case EAST -> wall ? SHAPE_EAST_WALL : SHAPE_EAST;
            default -> wall ? SHAPE_NORTH_WALL : SHAPE_NORTH;
        };
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        if (!world.isClient && !player.isSneaking()) {
            this.openScreen(world, pos, player);
            return ActionResult.SUCCESS;
        }
        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(WALL));
            UDUtils.toolboxUsed(world, pos);
            player.sendMessage(Text.translatable("toolbox.microwave.variant_" + state.get(WALL)), true);
            return ActionResult.SUCCESS;

        } else if (player.getMainHandStack().isEmpty() && player.isSneaking()) {
            world.setBlockState(pos, state.cycle(OPEN).cycle(TRUE_OPEN));
            if (state.get(OPEN)) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CHERRY_WOOD_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            } else if (!state.get(OPEN)) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CHERRY_WOOD_DOOR_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, WALL, LIT, TRUE_OPEN);
    }
}

package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
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
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.util.UDUtils;

public class ToiletPaperBlock extends AbstractDecorBlock {
    public static final IntProperty VARIANT = IntProperty.of("variant", 0, 1);

    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(4, 7, 11, 12, 12, 16);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(11, 7, 5, 16, 12, 13);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(0, 7, 5, 5, 12, 13);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(4, 7, 0, 12, 12, 5);

    private static final VoxelShape SHAPE_COMMERCIAL_NORTH = Block.createCuboidShape(2, 4, 13, 14, 12, 16);
    private static final VoxelShape SHAPE_COMMERCIAL_WEST = Block.createCuboidShape(13, 4, 2, 16, 12, 14);
    private static final VoxelShape SHAPE_COMMERCIAL_EAST = Block.createCuboidShape(0, 4, 2, 3, 12, 14);
    private static final VoxelShape SHAPE_COMMERCIAL_SOUTH = Block.createCuboidShape(2, 4, 0, 14, 12, 3);

    public ToiletPaperBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(VARIANT, 0).with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(VARIANT));
            UDUtils.toolboxUsed(world, pos);
            player.sendMessage(Text.translatable("toolbox.toilet_paper.variant_" + state.get(VARIANT)), true);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        int variant = state.get(VARIANT);
        boolean commercial = variant == 1;
        return switch (state.get(FACING)) {
            case SOUTH -> commercial ? SHAPE_COMMERCIAL_SOUTH : SHAPE_SOUTH;
            case WEST -> commercial ? SHAPE_COMMERCIAL_WEST : SHAPE_WEST;
            case EAST -> commercial ? SHAPE_COMMERCIAL_EAST : SHAPE_EAST;
            default -> commercial ? SHAPE_COMMERCIAL_NORTH : SHAPE_NORTH;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, VARIANT);
    }
}

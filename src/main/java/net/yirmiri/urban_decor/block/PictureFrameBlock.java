package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
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
import net.minecraft.world.event.GameEvent;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.util.UDUtils;

public class PictureFrameBlock extends AbstractDecorBlock {
    public static final BooleanProperty WALL = BooleanProperty.of("wall");

    private static final VoxelShape SHAPE = Block.createCuboidShape(5, 0, 5, 11, 6, 11);

    private static final VoxelShape SHAPE_NORTH_WALL = Block.createCuboidShape(3, 2, 13.75, 13, 14, 15.75);
    private static final VoxelShape SHAPE_EAST_WALL = Block.createCuboidShape(14, 2, 2.75, 16, 14, 12.75);
    private static final VoxelShape SHAPE_WEST_WALL = Block.createCuboidShape(0, 2, 2.75, 2, 14, 12.75);
    private static final VoxelShape SHAPE_SOUTH_WALL = Block.createCuboidShape(3, 2, -0.25, 13, 14, 1.75);

    public PictureFrameBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(WALL, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        boolean wall = state.get(WALL);
        return switch (state.get(FACING)) {
            default -> wall ? SHAPE_NORTH_WALL : SHAPE;
            case SOUTH -> wall ? SHAPE_SOUTH_WALL : SHAPE;
            case WEST -> wall ? SHAPE_WEST_WALL : SHAPE;
            case EAST -> wall ? SHAPE_EAST_WALL : SHAPE;
        };
    }

//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        ItemStack stackHand = player.getStackInHand(hand);
//        Item item = stackHand.getItem();
//        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
//            world.setBlockState(pos, state.cycle(WALL));
//            UDUtils.ToolboxUsed(world, pos);
//            player.sendMessage(Text.translatable("toolbox.picture_frame.variant_" + state.get(WALL)), true);
//            return ActionResult.SUCCESS;
//
//        } else if (player.getMainHandStack().isIn(UDItemTagProvider.DYES)) {
//            if (item instanceof DyeItem) {
//                if (!player.isCreative()) {
//                    stackHand.decrement(1);
//                }
//                world.playSound(null, pos, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
//                world.setBlockState(pos, TowelBarTowelBlock.getTowelColors(item).with(FACING, state.get(FACING)));
//                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
//                player.incrementStat(Stats.USED.getOrCreateStat(item));
//                return ActionResult.SUCCESS;
//            }
//            return ActionResult.SUCCESS;
//        }
//        return ActionResult.PASS;
//    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, WALL);
    }
}

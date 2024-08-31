package net.yirmiri.urban_decor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.entity.ToiletEntity;
import net.yirmiri.urban_decor.registry.RegisterEntities;
import net.yirmiri.urban_decor.util.UDStats;
import net.yirmiri.urban_decor.util.UDUtils;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
public class ToiletBlock extends AbstractDecorBlock {
    public static final BooleanProperty OCCUPIED = Properties.OCCUPIED;
    public static final BooleanProperty OPEN = BooleanProperty.of("open");
    public static final BooleanProperty ALT = BooleanProperty.of("alt");

    private static final VoxelShape SHAPE_NORTH = Stream.of(Block.createCuboidShape(3, 0, 5, 13, 5, 14), Block.createCuboidShape(3, 5, 2, 13, 7, 12), Block.createCuboidShape(3, 5, 12, 13, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_EAST = Stream.of(Block.createCuboidShape(2, 0, 3, 11, 5, 13), Block.createCuboidShape(4, 5, 3, 14, 7, 13), Block.createCuboidShape(0, 5, 3, 4, 16, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(Block.createCuboidShape(5, 0, 3, 14, 5, 13), Block.createCuboidShape(2, 5, 3, 12, 7, 13), Block.createCuboidShape(12, 5, 3, 16, 16, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(Block.createCuboidShape(3, 0, 2, 13, 5, 11), Block.createCuboidShape(3, 5, 4, 13, 7, 14), Block.createCuboidShape(3, 5, 0, 13, 16, 4)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_NORTH_ALT = Stream.of(Block.createCuboidShape(5, 0, 5, 11, 5, 14), Block.createCuboidShape(3, 5, 0, 13, 7, 10), Block.createCuboidShape(5, 5, 10, 11, 8, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_WEST_ALT = Stream.of(Block.createCuboidShape(5, 0, 5, 14, 5, 11), Block.createCuboidShape(0, 5, 3, 10, 7, 13), Block.createCuboidShape(10, 5, 5, 14, 8, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_EAST_ALT = Stream.of(Block.createCuboidShape(2, 0, 5, 11, 5, 11), Block.createCuboidShape(6, 5, 3, 16, 7, 13), Block.createCuboidShape(2, 5, 5, 6, 8, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_ALT = Stream.of(Block.createCuboidShape(5, 0, 2, 11, 5, 11), Block.createCuboidShape(3, 5, 6, 13, 7, 16), Block.createCuboidShape(5, 5, 2, 11, 8, 6)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public ToiletBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(OCCUPIED, false).with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false).with(OPEN, false).with(ALT, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        boolean alt = state.get(ALT);
        return switch (state.get(FACING)) {
            default -> alt ? SHAPE_NORTH_ALT : SHAPE_NORTH;
            case SOUTH -> alt ? SHAPE_SOUTH_ALT : SHAPE_SOUTH;
            case WEST -> alt ? SHAPE_WEST_ALT : SHAPE_WEST;
            case EAST -> alt ? SHAPE_EAST_ALT : SHAPE_EAST;
        };
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        if (player.getMainHandStack().isEmpty()) {
            if (player.isSneaking()) {
                world.setBlockState(pos, state.cycle(OPEN));
                if (state.get(OPEN)) {
                    world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CHERRY_WOOD_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
                } else if (!state.get(OPEN)) {
                    world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CHERRY_WOOD_DOOR_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
                }
            }
//            else if (!player.isSneaking() && !state.get(OCCUPIED) && !world.isClient) {
//                ToiletEntity toiletEntity = RegisterEntities.TOILET.create(world);
//                toiletEntity.setPos(pos.getX() + 0.5D, pos.getY() + 0.15D, pos.getZ() + 0.5D);
//                world.spawnEntity(toiletEntity);
//                world.setBlockState(pos, state.with(OCCUPIED, true));
//                player.startRiding(toiletEntity);
//                player.incrementStat(UDStats.TIMES_SAT);
//            }
            return ActionResult.SUCCESS;
        } else if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(ALT));
            UDUtils.ToolboxUsed(world, pos);
            player.sendMessage(Text.translatable("toolbox.toilet.variant_" + state.get(ALT)), true);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, ALT, OCCUPIED);
    }
}

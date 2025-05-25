package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractDecorBlock;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.common.entity.ToiletEntity;
import net.yirmiri.urban_decor.core.registry.UDEntities;
import net.yirmiri.urban_decor.core.init.UDStats;
import net.yirmiri.urban_decor.common.util.UDUtils;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
public class ToiletBlock extends AbstractDecorBlock {
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public static final BooleanProperty ALT = BooleanProperty.create("alt");

    private static final VoxelShape SHAPE_NORTH = Stream.of(Block.box(3, 0, 5, 13, 5, 14), Block.box(3, 5, 2, 13, 7, 12), Block.box(3, 5, 12, 13, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST = Stream.of(Block.box(2, 0, 3, 11, 5, 13), Block.box(4, 5, 3, 14, 7, 13), Block.box(0, 5, 3, 4, 16, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(Block.box(5, 0, 3, 14, 5, 13), Block.box(2, 5, 3, 12, 7, 13), Block.box(12, 5, 3, 16, 16, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(Block.box(3, 0, 2, 13, 5, 11), Block.box(3, 5, 4, 13, 7, 14), Block.box(3, 5, 0, 13, 16, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_NORTH_ALT = Stream.of(Block.box(5, 0, 5, 11, 5, 14), Block.box(3, 5, 0, 13, 7, 10), Block.box(5, 5, 10, 11, 8, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST_ALT = Stream.of(Block.box(5, 0, 5, 14, 5, 11), Block.box(0, 5, 3, 10, 7, 13), Block.box(10, 5, 5, 14, 8, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_ALT = Stream.of(Block.box(2, 0, 5, 11, 5, 11), Block.box(6, 5, 3, 16, 7, 13), Block.box(2, 5, 5, 6, 8, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_ALT = Stream.of(Block.box(5, 0, 2, 11, 5, 11), Block.box(3, 5, 6, 13, 7, 16), Block.box(5, 5, 2, 11, 8, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public ToiletBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(OCCUPIED, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(OPEN, false).setValue(ALT, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        boolean alt = state.getValue(ALT);
        return switch (state.getValue(FACING)) {
            case SOUTH -> alt ? SHAPE_SOUTH_ALT : SHAPE_SOUTH;
            case WEST -> alt ? SHAPE_WEST_ALT : SHAPE_WEST;
            case EAST -> alt ? SHAPE_EAST_ALT : SHAPE_EAST;
            default -> alt ? SHAPE_NORTH_ALT : SHAPE_NORTH;
        };
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (player.getMainHandItem().isEmpty()) {
            if (player.isShiftKeyDown()) {
                world.setBlockAndUpdate(pos, state.cycle(OPEN));
                if (state.getValue(OPEN)) {
                    world.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                } else if (!state.getValue(OPEN)) {
                    world.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                }
            }
            else if (!player.isShiftKeyDown() && !state.getValue(OCCUPIED) && !world.isClientSide) {
                ToiletEntity toiletEntity = UDEntities.TOILET.create(world);
                toiletEntity.setPosRaw(pos.getX() + 0.5D, pos.getY() + 0.15D, pos.getZ() + 0.5D);
                world.addFreshEntity(toiletEntity);
                world.setBlockAndUpdate(pos, state.setValue(OCCUPIED, true));
                player.startRiding(toiletEntity);
                player.awardStat(UDStats.TIMES_SAT);
            }
            return InteractionResult.SUCCESS;
        } else if (stackHand.is(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockAndUpdate(pos, state.cycle(ALT));
            UDUtils.toolboxUsed(world, pos);
            player.displayClientMessage(Component.translatable("toolbox.toilet.variant_" + state.getValue(ALT)), true);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, ALT, OCCUPIED);
    }
}

package net.yirmiri.urban_decor.common.block.appliances;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.enums.WrapType;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.common.util.WrapColor;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDItems;

import java.util.stream.Stream;

public class BoothBlock extends StairBlock {
    public static final EnumProperty<WrapType> WRAP_TYPE = EnumProperty.create("wrap_type", WrapType.class);
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;

    public BoothBlock(BlockState blockState, Properties properties) {
        super(blockState, properties);
        registerDefaultState(defaultBlockState()
                .setValue(WRAP_TYPE, WrapType.NONE)
                .setValue(WATERLOGGED, false)
                .setValue(OCCUPIED, false)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        if (state.getValue(HALF) == Half.BOTTOM) {
            if (state.getValue(SHAPE) == StairsShape.STRAIGHT) {
                return switch (state.getValue(FACING)) {
                    case SOUTH -> SHAPE_WEST;
                    case WEST -> SHAPE_SOUTH;
                    case EAST -> SHAPE_NORTH;
                    default -> SHAPE_EAST;
                };
            }
            else if (state.getValue(SHAPE) == StairsShape.INNER_LEFT) {
                return switch (state.getValue(FACING)) {
                    case SOUTH -> SHAPE_NORTH_INNER;
                    case WEST -> SHAPE_WEST_INNER;
                    case EAST -> SHAPE_EAST_INNER;
                    default -> SHAPE_SOUTH_INNER;
                };
            }
            else if (state.getValue(SHAPE) == StairsShape.OUTER_LEFT) {
                return switch (state.getValue(FACING)) {
                    case SOUTH -> SHAPE_NORTH_OUTER;
                    case WEST -> SHAPE_WEST_OUTER;
                    case EAST -> SHAPE_EAST_OUTER;
                    default -> SHAPE_SOUTH_OUTER;
                };
            }
            else if (state.getValue(SHAPE) == StairsShape.INNER_RIGHT) {
                return switch (state.getValue(FACING)) {
                    case SOUTH -> SHAPE_WEST_INNER;
                    case WEST -> SHAPE_SOUTH_INNER;
                    case EAST -> SHAPE_NORTH_INNER;
                    default -> SHAPE_EAST_INNER;
                };
            }
            else if (state.getValue(SHAPE) == StairsShape.OUTER_RIGHT) {
                return switch (state.getValue(FACING)) {
                    case SOUTH -> SHAPE_WEST_OUTER;
                    case WEST -> SHAPE_SOUTH_OUTER;
                    case EAST -> SHAPE_NORTH_OUTER;
                    default -> SHAPE_EAST_OUTER;
                };
            }
        } else {
            if (state.getValue(SHAPE) == StairsShape.STRAIGHT) {
                return switch (state.getValue(FACING)) {
                    case SOUTH -> SHAPE_WEST_UP;
                    case WEST -> SHAPE_SOUTH_UP;
                    case EAST -> SHAPE_NORTH_UP;
                    default -> SHAPE_EAST_UP;
                };
            }
            else if (state.getValue(SHAPE) == StairsShape.INNER_RIGHT) {
                return switch (state.getValue(FACING)) {
                    case SOUTH -> SHAPE_NORTH_INNER_UP;
                    case WEST -> SHAPE_WEST_INNER_UP;
                    case EAST -> SHAPE_EAST_INNER_UP;
                    default -> SHAPE_SOUTH_INNER_UP;
                };
            }
            else if (state.getValue(SHAPE) == StairsShape.OUTER_RIGHT) {
                return switch (state.getValue(FACING)) {
                    case SOUTH -> SHAPE_NORTH_OUTER_UP;
                    case WEST -> SHAPE_WEST_OUTER_UP;
                    case EAST -> SHAPE_EAST_OUTER_UP;
                    default -> SHAPE_SOUTH_OUTER_UP;
                };
            }
            else if (state.getValue(SHAPE) == StairsShape.INNER_LEFT) {
                return switch (state.getValue(FACING)) {
                    case SOUTH -> SHAPE_EAST_INNER_UP;
                    case WEST -> SHAPE_NORTH_INNER_UP;
                    case EAST -> SHAPE_SOUTH_INNER_UP;
                    default -> SHAPE_WEST_INNER_UP;
                };
            }
            else if (state.getValue(SHAPE) == StairsShape.OUTER_LEFT) {
                return switch (state.getValue(FACING)) {
                    case SOUTH -> SHAPE_EAST_OUTER_UP;
                    case WEST -> SHAPE_NORTH_OUTER_UP;
                    case EAST -> SHAPE_SOUTH_OUTER_UP;
                    default -> SHAPE_WEST_OUTER_UP;
                };
            }
        }
        return SHAPE_EAST;
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stackHand = player.getItemInHand(hand);
        if (state.getValue(WRAP_TYPE) == WrapType.NONE && stackHand.is(UDTags.ItemT.WRAPS)) {
            for (WrapColor color : WrapColor.values()) {
                if (stackHand.is(UDItems.getWrappedWraps(color.getId()).get())) {
                    level.setBlockAndUpdate(pos, state.setValue(WRAP_TYPE, WrapType.valueOf(color.name())));
                    UDUtils.wrapUsed(level, pos);
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (UDUtils.canSitOn(state, pos, level, player)) {
            if (state.getValue(HALF) == Half.TOP) {
                UDUtils.createSeat(0.01D, state, level, pos, player, hitResult, 180);
                return InteractionResult.SUCCESS;
            }
            UDUtils.createSeat(0.4D, state, level, pos, player, hitResult);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(WRAP_TYPE, OCCUPIED);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        super.fallOn(level, state, pos, entity, fallDistance * 0.25F);
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter level, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(level, entity);
        } else {
            this.bounceUp(entity);
        }
    }

    private void bounceUp(Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.y < (double) 0.0F) {
            double v = entity instanceof LivingEntity ? (double) 1.0F : 0.8;
            entity.setDeltaMovement(vec3.x, -vec3.y * (double) 0.66F * v, vec3.z);
        }
    }

    //DEFAULT
    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.box(4, 0, 0, 16, 4, 16),
            Block.box(14, 18, 0, 16, 20, 16),
            Block.box(12, 4, 0, 16, 18, 16),
            Block.box(2, 4, 0, 12, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.box(0, 0, 0, 12, 4, 16),
            Block.box(0, 18, 0, 2, 20, 16),
            Block.box(0, 4, 0, 4, 18, 16),
            Block.box(4, 4, 0, 14, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.box(0, 0, 4, 16, 4, 16),
            Block.box(0, 18, 14, 16, 20, 16),
            Block.box(0, 4, 12, 16, 18, 16),
            Block.box(0, 4, 2, 16, 8, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.box(0, 0, 0, 16, 4, 12),
            Block.box(0, 18, 0, 16, 20, 2),
            Block.box(0, 4, 0, 16, 18, 4),
            Block.box(0, 4, 4, 16, 8, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //INNER
    private static final VoxelShape SHAPE_NORTH_INNER = Stream.of(
            Block.box(4, 0, 0, 16, 4, 12),
            Block.box(14, 18, 0, 16, 20, 16),
            Block.box(12, 4, 0, 16, 18, 12),
            Block.box(2, 4, 0, 12, 8, 12),
            Block.box(0, 0, 12, 16, 18, 16),
            Block.box(0, 18, 14, 14, 20, 16),
            Block.box(0, 0, 4, 4, 4, 12),
            Block.box(0, 4, 2, 2, 8, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_INNER = Stream.of(
            Block.box(0, 0, 4, 12, 4, 16),
            Block.box(0, 18, 0, 2, 20, 16),
            Block.box(0, 4, 4, 4, 18, 16),
            Block.box(4, 4, 4, 14, 8, 16),
            Block.box(0, 0, 0, 16, 18, 4),
            Block.box(2, 18, 0, 16, 20, 2),
            Block.box(12, 0, 4, 16, 4, 12),
            Block.box(14, 4, 4, 16, 8, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST_INNER = Stream.of(
            Block.box(4, 0, 4, 16, 4, 16),
            Block.box(0, 18, 14, 16, 20, 16),
            Block.box(4, 4, 12, 16, 18, 16),
            Block.box(4, 4, 2, 16, 8, 12),
            Block.box(0, 0, 0, 4, 18, 16),
            Block.box(0, 18, 0, 2, 20, 14),
            Block.box(4, 0, 0, 12, 4, 4),
            Block.box(4, 4, 0, 14, 8, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_INNER = Stream.of(
            Block.box(0, 0, 0, 12, 4, 12),
            Block.box(0, 18, 0, 16, 20, 2),
            Block.box(0, 4, 0, 12, 18, 4),
            Block.box(0, 4, 4, 12, 8, 14),
            Block.box(12, 0, 0, 16, 18, 16),
            Block.box(14, 18, 2, 16, 20, 16),
            Block.box(4, 0, 12, 12, 4, 16),
            Block.box(2, 4, 14, 12, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //OUTER
    private static final VoxelShape SHAPE_NORTH_OUTER = Stream.of(
            Block.box(4, 0, 4, 16, 4, 16),
            Block.box(14, 18, 14, 16, 20, 16),
            Block.box(12, 4, 12, 16, 18, 16),
            Block.box(2, 4, 2, 12, 8, 16),
            Block.box(12, 4, 2, 16, 8, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_OUTER = Stream.of(
            Block.box(0, 0, 0, 12, 4, 12),
            Block.box(0, 18, 0, 2, 20, 2),
            Block.box(0, 4, 0, 4, 18, 4),
            Block.box(4, 4, 0, 14, 8, 14),
            Block.box(0, 4, 4, 4, 8, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST_OUTER = Stream.of(
            Block.box(0, 0, 4, 12, 4, 16),
            Block.box(0, 18, 14, 2, 20, 16),
            Block.box(0, 4, 12, 4, 18, 16),
            Block.box(0, 4, 2, 14, 8, 12),
            Block.box(4, 4, 12, 14, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_OUTER = Stream.of(
            Block.box(4, 0, 0, 16, 4, 12),
            Block.box(14, 18, 0, 16, 20, 2),
            Block.box(12, 4, 0, 16, 18, 4),
            Block.box(2, 4, 4, 16, 8, 14),
            Block.box(2, 4, 0, 12, 8, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //UPSIDE DOWN
    private static final VoxelShape SHAPE_NORTH_UP = Stream.of(
            Block.box(4, 12, 0, 16, 16, 16),
            Block.box(14, -4, 0, 16, -2, 16),
            Block.box(12, -2, 0, 16, 12, 16),
            Block.box(2, 8, 0, 12, 12, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_SOUTH_UP = Stream.of(
            Block.box(0, 12, 0, 12, 16, 16),
            Block.box(0, -4, 0, 2, -2, 16),
            Block.box(0, -2, 0, 4, 12, 16),
            Block.box(4, 8, 0, 14, 12, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_WEST_UP = Stream.of(
            Block.box(0, 12, 4, 16, 16, 16),
            Block.box(0, -4, 14, 16, -2, 16),
            Block.box(0, -2, 12, 16, 12, 16),
            Block.box(0, 8, 2, 16, 12, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_EAST_UP = Stream.of(
            Block.box(0, 12, 0, 16, 16, 12),
            Block.box(0, -4, 0, 16, -2, 2),
            Block.box(0, -2, 0, 16, 12, 4),
            Block.box(0, 8, 4, 16, 12, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //INNER UPSIDE DOWN
    private static final VoxelShape SHAPE_NORTH_INNER_UP = Stream.of(
            Block.box(0, 12, 0, 12, 16, 12),
            Block.box(0, -4, 0, 2, -2, 16),
            Block.box(0, -2, 0, 4, 12, 12),
            Block.box(4, 8, 0, 14, 12, 12),
            Block.box(0, -2, 12, 16, 16, 16),
            Block.box(2, -4, 14, 16, -2, 16),
            Block.box(12, 12, 4, 16, 16, 12),
            Block.box(14, 8, 2, 16, 12, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_INNER_UP = Stream.of(
            Block.box(4, 12, 4, 16, 16, 16),
            Block.box(14, -4, 0, 16, -2, 16),
            Block.box(12, -2, 4, 16, 12, 16),
            Block.box(2, 8, 4, 12, 12, 16),
            Block.box(0, -2, 0, 16, 16, 4),
            Block.box(0, -4, 0, 14, -2, 2),
            Block.box(0, 12, 4, 4, 16, 12),
            Block.box(0, 8, 4, 2, 12, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST_INNER_UP = Stream.of(
            Block.box(4, 12, 0, 16, 16, 12),
            Block.box(0, -4, 0, 16, -2, 2),
            Block.box(4, -2, 0, 16, 12, 4),
            Block.box(4, 8, 4, 16, 12, 14),
            Block.box(0, -2, 0, 4, 16, 16),
            Block.box(0, -4, 2, 2, -2, 16),
            Block.box(4, 12, 12, 12, 16, 16),
            Block.box(4, 8, 14, 14, 12, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_INNER_UP = Stream.of(
            Block.box(0, 12, 4, 12, 16, 16),
            Block.box(0, -4, 14, 16, -2, 16),
            Block.box(0, -2, 12, 12, 12, 16),
            Block.box(0, 8, 2, 12, 12, 12),
            Block.box(12, -2, 0, 16, 16, 16),
            Block.box(14, -4, 0, 16, -2, 14),
            Block.box(4, 12, 0, 12, 16, 4),
            Block.box(2, 8, 0, 12, 12, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //OUTER UPSIDE DOWN
    private static final VoxelShape SHAPE_NORTH_OUTER_UP = Stream.of(
            Block.box(0, 12, 4, 12, 16, 16),
            Block.box(0, -4, 14, 2, -2, 16),
            Block.box(0, -2, 12, 4, 12, 16),
            Block.box(4, 8, 2, 14, 12, 16),
            Block.box(0, 8, 2, 4, 12, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_OUTER_UP = Stream.of(
            Block.box(4, 12, 0, 16, 16, 12),
            Block.box(14, -4, 0, 16, -2, 2),
            Block.box(12, -2, 0, 16, 12, 4),
            Block.box(2, 8, 0, 12, 12, 14),
            Block.box(12, 8, 4, 16, 12, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST_OUTER_UP = Stream.of(
            Block.box(0, 12, 0, 12, 16, 12),
            Block.box(0, -4, 0, 2, -2, 2),
            Block.box(0, -2, 0, 4, 12, 4),
            Block.box(0, 8, 4, 14, 12, 14),
            Block.box(4, 8, 0, 14, 12, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_OUTER_UP = Stream.of(
            Block.box(4, 12, 4, 16, 16, 16),
            Block.box(14, -4, 14, 16, -2, 16),
            Block.box(12, -2, 12, 16, 12, 16),
            Block.box(2, 8, 2, 16, 12, 12),
            Block.box(2, 8, 12, 12, 12, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
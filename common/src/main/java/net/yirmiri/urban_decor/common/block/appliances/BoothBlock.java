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

public class BoothBlock extends StairBlock {
    public static final EnumProperty<WrapType> WRAP_TYPE = EnumProperty.create("wrap_type", WrapType.class);
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;

    private static final VoxelShape SHAPE_NORTH = Shapes.join(Block.box(2, 0, 4, 14, 14, 16),
            Block.box(0, 14, 2, 16, 16, 16), BooleanOp.OR);

    private static final VoxelShape SHAPE_SOUTH = Shapes.join(Block.box(2, 0, 0, 14, 14, 12),
            Block.box(0, 14, 0, 16, 16, 14), BooleanOp.OR);

    private static final VoxelShape SHAPE_WEST = Shapes.join(Block.box(4, 0, 2, 16, 14, 14),
            Block.box(2, 14, 0, 16, 16, 16), BooleanOp.OR);

    private static final VoxelShape SHAPE_EAST = Shapes.join(Block.box(0, 0, 2, 12, 14, 14),
            Block.box(0, 14, 0, 14, 16, 16), BooleanOp.OR);

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
        //        return switch (state.getValue(FACING)) {
        //            case SOUTH -> SHAPE_SOUTH;
        //            case WEST -> SHAPE_WEST;
        //            case EAST -> SHAPE_EAST;
        //            default -> SHAPE_NORTH;
        //        };
        return Block.box(4, 0, 4, 12, 8, 12);
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
}
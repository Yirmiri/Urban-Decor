package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.entity.ToasterBlockEntity;
import net.yirmiri.urban_decor.core.init.UDDamageTypes;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;

import java.util.Optional;

public class ToasterBlock extends CampfireBlock implements SimpleWaterloggedBlock {
    private static final VoxelShape SHAPE_NORTH = Block.box(3, 0, 7, 13, 6, 12);
    private static final VoxelShape SHAPE_EAST = Block.box(4, 0, 3, 9, 6, 13);
    private static final VoxelShape SHAPE_WEST = Block.box(7, 0, 3, 12, 6, 13);
    private static final VoxelShape SHAPE_SOUTH = Block.box(3, 0, 4, 13, 6, 9);

    private final int fireDamage;

    public ToasterBlock(boolean emitsParticles, int fireDamage, Properties settings) {
        super(emitsParticles, fireDamage, settings);
        this.fireDamage = fireDamage;
        this.registerDefaultState(defaultBlockState().setValue(LIT, false).setValue(SIGNAL_FIRE, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false));
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
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            if (state.getValue(WATERLOGGED) && state.getValue(LIT)) {
                entity.hurt(UDDamageTypes.of(entity.level(), UDDamageTypes.WET_TOASTER), 10);
            }

            if (!state.getValue(WATERLOGGED) && state.getValue(LIT) && !livingEntity.isSteppingCarefully()) {
                entity.hurt(UDDamageTypes.of(entity.level(), UDDamageTypes.TOASTER), 2);
            }
        }
        super.stepOn(world, pos, state, entity);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ToasterBlockEntity) {
                Containers.dropContents(world, pos, ((ToasterBlockEntity)blockEntity).getItems());
            }
            super.onRemove(state, world, pos, newState, moved);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        LevelAccessor worldAccess = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        boolean bl = worldAccess.getFluidState(blockPos).getType() == Fluids.WATER;
        return defaultBlockState().setValue(WATERLOGGED, bl).setValue(LIT, false).setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof ToasterBlockEntity toasterBlockEntity) {
            ItemStack itemStack = player.getItemInHand(hand);
            Optional<RecipeHolder<CampfireCookingRecipe>> optional = toasterBlockEntity.getCookableRecipe(itemStack);

            if (optional.isPresent() && state.getValue(LIT)) {
                if (!level.isClientSide && toasterBlockEntity.placeFood(player, itemStack, ((CampfireCookingRecipe) ((RecipeHolder) optional.get()).value()).getCookingTime()))
                    return ItemInteractionResult.CONSUME;
            }
        }
        return ItemInteractionResult.CONSUME;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (player.getMainHandItem().isEmpty()) {
            level.setBlockAndUpdate(pos, state.cycle(LIT));
            level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON, SoundSource.BLOCKS, 0.8F, 1.0F, false);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, LIT, SIGNAL_FIRE);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ToasterBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        if (world.isClientSide) {
            return state.getValue(LIT) ? createTickerHelper(type, UDBlockEntities.TOASTER.get(), ToasterBlockEntity::clientTick) : null;
        } else {
            return state.getValue(LIT)
                    ? createTickerHelper(type, UDBlockEntities.TOASTER.get(), ToasterBlockEntity::litServerTick)
                    : createTickerHelper(type, UDBlockEntities.TOASTER.get(), ToasterBlockEntity::unlitServerTick);
        }
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {

    }
}

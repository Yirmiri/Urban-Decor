package net.yirmiri.urban_decor.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.entity.ToasterBlockEntity;
import net.yirmiri.urban_decor.registry.RegisterBlockEntities;
import net.yirmiri.urban_decor.registry.RegisterDamageTypes;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ToasterBlock extends CampfireBlock implements Waterloggable {
    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(3, 0, 7, 13, 6, 12);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(4, 0, 3, 9, 6, 13);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(7, 0, 3, 12, 6, 13);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(3, 0, 4, 13, 6, 9);

    private final int fireDamage;

    public ToasterBlock(boolean emitsParticles, int fireDamage, Settings settings) {
        super(emitsParticles, fireDamage, settings);
        this.fireDamage = fireDamage;
        setDefaultState(getDefaultState().with(LIT, false).with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, false));
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

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (state.get(WATERLOGGED)) {
            entity.damage(RegisterDamageTypes.of(entity.getWorld(), RegisterDamageTypes.TOASTER), 10);
        }
        if (!entity.bypassesSteppingEffects() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
            entity.damage(world.getDamageSources().hotFloor(), fireDamage);
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ToasterBlockEntity) {
                ItemScatterer.spawn(world, pos, ((ToasterBlockEntity)blockEntity).getItemsBeingCooked());
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof ToasterBlockEntity toasterBlockEntity) {
            ItemStack itemStack = player.getStackInHand(hand);
            Optional<CampfireCookingRecipe> optional = toasterBlockEntity.getRecipeFor(itemStack);

            if (optional.isPresent() && state.get(LIT)) {
                if (!world.isClient && toasterBlockEntity.addItem(player, player.getAbilities().creativeMode ? itemStack.copy() : itemStack, (optional.get()).getCookTime()))
                    world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 0.5F, 1.0F, false);
                return ActionResult.CONSUME;

            } else if (player.getMainHandStack().isEmpty()) {
                world.setBlockState(pos, state.cycle(LIT));
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.8F, 1.0F, false);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, LIT, SIGNAL_FIRE);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ToasterBlockEntity(pos, state);
    }

    @Nullable @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient) {
            return state.get(LIT) ? checkType(type, RegisterBlockEntities.TOASTER, ToasterBlockEntity::clientTick) : null;
        } else {
            return state.get(LIT)
                    ? checkType(type, RegisterBlockEntities.TOASTER, ToasterBlockEntity::litServerTick)
                    : checkType(type, RegisterBlockEntities.TOASTER, ToasterBlockEntity::unlitServerTick);
        }
    }
}

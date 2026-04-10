package net.yirmiri.urban_decor.common.block.appliances;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractStorageDecorBlock;
import net.yirmiri.urban_decor.common.block.entity.StorageDecorBlockEntity;
import net.yirmiri.urban_decor.common.block.enums.WrapType;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.common.util.WrapColor;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDItems;
import net.yirmiri.urban_decor.core.registry.UDSounds;

public class DishwasherBlock extends AbstractStorageDecorBlock {
    public static final EnumProperty<WrapType> WRAP_TYPE = EnumProperty.create("wrap_type", WrapType.class);
    private static final VoxelShape SHAPE_NORTH = Shapes.join(Block.box(0, 0, 4, 16, 14, 16),
            Block.box(0, 14, 2, 16, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_WEST = Shapes.join(Block.box(4, 0, 0, 16, 14, 16),
            Block.box(2, 14, 0, 16, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_EAST = Shapes.join(Block.box(0, 0, 0, 12, 14, 16),
            Block.box(0, 14, 0, 14, 16, 16), BooleanOp.OR);
    private static final VoxelShape SHAPE_SOUTH = Shapes.join(Block.box(0, 0, 0, 16, 14, 12),
            Block.box(0, 14, 0, 16, 16, 14), BooleanOp.OR);

    public DishwasherBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState()
                .setValue(WRAP_TYPE, WrapType.NONE)
        );
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
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!player.getMainHandItem().getItem().getDefaultInstance().is(UDTags.ItemT.TOOLBOXES)) {
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                if (blockEntity instanceof StorageDecorBlockEntity && !player.isShiftKeyDown()) {
                    player.openMenu((StorageDecorBlockEntity) blockEntity);
                    //player.awardStat(UDStats.OPEN_APPLIANCES);
                    PiglinAi.angerNearbyPiglins(player, true);
                }

                if (player.isShiftKeyDown()) {
                    level.setBlockAndUpdate(pos, state.cycle(OPEN).cycle(TRUE_OPEN));
                    if (state.getValue(OPEN)) {
                        UDUtils.playSound(level, pos, state, UDSounds.METALLIC_CLOSE.get());
                    } else if (!state.getValue(OPEN)) {
                        UDUtils.playSound(level, pos, state, UDSounds.METALLIC_OPEN.get());
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OPEN, TRUE_OPEN, WRAP_TYPE);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StorageDecorBlockEntity(pos, state);
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

//    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
//        if (itemStack.hasCustomHoverName()) {
//            BlockEntity blockEntity = world.getBlockEntity(pos);
//            if (blockEntity instanceof StorageApplianceBlockEntity) {
//                ((StorageApplianceBlockEntity)blockEntity).setCustomName(itemStack.getHoverName());
//            }
//        }
//    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Container) {
                Containers.dropContents(world, pos, (Container)blockEntity);
                world.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, world, pos, newState, moved);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof StorageDecorBlockEntity) {
            ((StorageDecorBlockEntity)blockEntity).recheckOpen();
        }
    }
}

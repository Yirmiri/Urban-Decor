package net.yirmiri.urban_decor.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractStorageDecorBlock;
import net.yirmiri.urban_decor.common.block.entity.StorageDecorBlockEntity;
import net.yirmiri.urban_decor.common.block.enums.WrapType;
import net.yirmiri.urban_decor.common.util.UDUtils;
import net.yirmiri.urban_decor.common.util.WrapColor;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDItems;
import net.yirmiri.urban_decor.core.registry.UDSounds;

public class BoxBlock extends AbstractStorageDecorBlock {
    public static final EnumProperty<WrapType> WRAP_TYPE = EnumProperty.create("wrap_type", WrapType.class);

    public BoxBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .setValue(WRAP_TYPE, WrapType.NONE)
                .setValue(WATERLOGGED, false)
                .setValue(OPEN, false)
                .setValue(TRUE_OPEN, false));
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

                if (player.getMainHandItem().isEmpty() && player.isShiftKeyDown()) {
                    level.setBlockAndUpdate(pos, state.cycle(OPEN).cycle(TRUE_OPEN));
                    if (state.getValue(OPEN)) {
                        playSound(level, pos, state, UDSounds.GENERIC_APPLIANCE_OPEN.get());
                    } else if (!state.getValue(OPEN)) {
                        playSound(level, pos, state, UDSounds.GENERIC_APPLIANCE_OPEN.get());
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.CONSUME;
    }

    void playSound(Level world, BlockPos pos, BlockState state, SoundEvent soundEvent) {
        Vec3i vec3i = (state.getValue(AbstractStorageDecorBlock.FACING)).getNormal();
        double d = (double)pos.getX() + 0.5 + (double)vec3i.getX() / 2.0;
        double e = (double)pos.getY() + 0.5 + (double)vec3i.getY() / 2.0;
        double f = (double)pos.getZ() + 0.5 + (double)vec3i.getZ() / 2.0;
        world.playSound(null, d, e, f, soundEvent, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
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

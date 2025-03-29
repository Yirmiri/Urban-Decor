package net.yirmiri.urban_decor.common.block;

import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class StainlessSteelDoorBlock extends DoorBlock {
    public static final BooleanProperty LOCKED = BooleanProperty.create("locked");
    private final BlockSetType blockSetType;

    public StainlessSteelDoorBlock(Properties settings, BlockSetType blockSetType) {
        super(settings, blockSetType);
        this.blockSetType = blockSetType;
        this.registerDefaultState((((((this.stateDefinition.any()).setValue(BlockStateProperties.LOCKED, false).setValue(FACING, Direction.NORTH)).setValue(OPEN, false)).setValue(HINGE, DoorHingeSide.LEFT)).setValue(POWERED, false)).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getItemInHand(hand);
//        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
//            if (state.get(HALF) == DoubleBlockHalf.LOWER && world.getBlockState(pos.up()).isOf(this)) {
//                world.setBlockState(pos.up(), this.getDefaultState().cycle(LOCKED).with(FACING, state.get(FACING)).with(HALF, DoubleBlockHalf.UPPER).with(OPEN, state.get(OPEN)).with(HINGE, state.get(HINGE)), 0);
//            }
//            else if (state.get(HALF) == DoubleBlockHalf.UPPER && world.getBlockState(pos.down()).isOf(this)) {
//                world.setBlockState(pos.down(), this.getDefaultState().cycle(LOCKED).with(FACING, state.get(FACING)).with(HALF, DoubleBlockHalf.LOWER).with(OPEN, state.get(OPEN)).with(HINGE, state.get(HINGE)), 0);
//            }
//
//            UDUtils.toolboxUsed(world, pos);
//            player.sendMessage(Text.translatable("toolbox.steel_door.variant_" + state.get(LOCKED)), true);
//            return ActionResult.SUCCESS;
//        }
        if (!this.blockSetType.canOpenByHand() || state.getValue(LOCKED)) {
            return InteractionResult.PASS;
        } else {
            state = state.cycle(OPEN);
            world.setBlock(pos, state, 10);
            playSound(player, world, pos, state.getValue(OPEN));
            world.gameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            return InteractionResult.sidedSuccess(world.isClientSide);
        }
    }

//    @Override
//    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
//        boolean locked = world.getBlockState(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN)).isOf(this) && world.getBlockState(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN)).get(LOCKED);
//        boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
//        if (!this.getDefaultState().isOf(sourceBlock) && bl != state.get(POWERED)) {
//            if (bl != state.get(OPEN)) {
//                this.playOpenCloseSound(null, world, pos, bl);
//                world.emitGameEvent(null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
//            }
//            world.setBlockState(pos, state.with(POWERED, bl).with(OPEN, bl).with(LOCKED, locked), 2);
//        }
//    }

    private void playSound(@Nullable Entity entity, Level world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? SoundEvents.IRON_DOOR_OPEN : SoundEvents.IRON_DOOR_CLOSE, SoundSource.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF, FACING, OPEN, HINGE, POWERED, LOCKED);
    }
}

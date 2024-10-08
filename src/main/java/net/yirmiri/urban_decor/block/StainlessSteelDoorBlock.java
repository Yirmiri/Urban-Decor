package net.yirmiri.urban_decor.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.yirmiri.urban_decor.datagen.UDItemTagProvider;
import net.yirmiri.urban_decor.util.UDUtils;
import org.jetbrains.annotations.Nullable;

public class StainlessSteelDoorBlock extends DoorBlock {
    public static final BooleanProperty LOCKED = BooleanProperty.of("locked");
    private final BlockSetType blockSetType;

    public StainlessSteelDoorBlock(Settings settings, BlockSetType blockSetType) {
        super(settings, blockSetType);
        this.blockSetType = blockSetType;
        this.setDefaultState((((((this.stateManager.getDefaultState()).with(Properties.LOCKED, false).with(FACING, Direction.NORTH)).with(OPEN, false)).with(HINGE, DoorHinge.LEFT)).with(POWERED, false)).with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stackHand = player.getStackInHand(hand);
        if (stackHand.isIn(UDItemTagProvider.TOOLBOXES)) {
            world.setBlockState(pos, state.cycle(LOCKED));
            UDUtils.toolboxUsed(world, pos);
            player.sendMessage(Text.translatable("toolbox.steel_door.variant_" + state.get(LOCKED)), true);
            return ActionResult.SUCCESS;
        }
        if (!this.blockSetType.canOpenByHand() || state.get(LOCKED)) {
            return ActionResult.PASS;
        } else {
            state = state.cycle(OPEN);
            world.setBlockState(pos, state, 10);
            playOpenCloseSound(player, world, pos, state.get(OPEN));
            world.emitGameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            return ActionResult.success(world.isClient);
        }
    }

    private void playOpenCloseSound(@Nullable Entity entity, World world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? SoundEvents.BLOCK_IRON_DOOR_OPEN : SoundEvents.BLOCK_IRON_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HALF, FACING, OPEN, HINGE, POWERED, LOCKED);
    }
}

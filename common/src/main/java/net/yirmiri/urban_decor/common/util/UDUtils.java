package net.yirmiri.urban_decor.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.yirmiri.urban_decor.common.entity.SeatEntity;
import net.yirmiri.urban_decor.core.registry.UDEntities;
import net.yirmiri.urban_decor.core.registry.UDSounds;

public class UDUtils {

    public static void toolboxUsed(Level level, BlockPos pos) {
        level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 0.5F, 1.0F, false);
    }

    public static void wrapUsed(Level level, BlockPos pos) {
        level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), UDSounds.WRAP_USE.get(), SoundSource.BLOCKS, 1.2F, 1.0F, false);
    }

    public static boolean canSitOn(BlockState state, BlockPos pos, Level level, Player player) {
        return !level.isClientSide && !state.getValue(BlockStateProperties.OCCUPIED) && !player.isCrouching() && !level.getBlockState(pos.above()).isSuffocating(level, pos)
                && !player.isPassenger() && player.getMainHandItem().getItem().getDefaultInstance().isEmpty();
    }

    public static void createSeat(double yPos, BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        SeatEntity seatEntity = UDEntities.SEAT.get().create(level);
        seatEntity.setPosRaw(pos.getX() + 0.5D, pos.getY() + yPos, pos.getZ() + 0.5D);
        level.addFreshEntity(seatEntity);
        level.setBlockAndUpdate(pos, state.setValue(BlockStateProperties.OCCUPIED, true));

        for (Animal living : level.getEntitiesOfClass(Animal.class, player.getBoundingBox().inflate(7.0D))) {
            if (living.isLeashed() && living.getLeashHolder() == player) {
                living.dropLeash(true, true);
                living.startRiding(seatEntity, true);
                return;
            }
        }
        player.startRiding(seatEntity);
    }

    public static void createPlayerOnlySeat(double yPos, BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        SeatEntity seatEntity = UDEntities.SEAT.get().create(level);
        seatEntity.setPosRaw(pos.getX() + 0.5D, pos.getY() + yPos, pos.getZ() + 0.5D);
        level.addFreshEntity(seatEntity);
        level.setBlockAndUpdate(pos, state.setValue(BlockStateProperties.OCCUPIED, true));
        player.startRiding(seatEntity);
    }

    public static void fillWaterBottle(Level level, BlockPos pos, Player player, InteractionHand hand) {
        ItemStack stackHand = player.getItemInHand(hand);
        turnBottleIntoItem(stackHand, player, PotionContents.createItemStack(Items.POTION, Potions.WATER), hand);
        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
    }

    public static ItemStack turnBottleIntoItem(ItemStack bottleStack, Player player, ItemStack filledBottleStack, InteractionHand hand) {
        player.awardStat(Stats.ITEM_USED.get(player.getItemInHand(hand).getItem()));
        return ItemUtils.createFilledResult(bottleStack, player, filledBottleStack);
    }
}

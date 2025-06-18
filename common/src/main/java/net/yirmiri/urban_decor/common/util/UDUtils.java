package net.yirmiri.urban_decor.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class UDUtils {

    public static void toolboxUsed(Level world, BlockPos pos) {
        world.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 0.5F, 1.0F, false);
    }

    public static void spawnWaterParticles(int count, Level world, BlockPos blockPos, Direction direction) {
        Vec3 spawnPos = new Vec3(blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5).add(new Vec3(0, 0, -0.5));
        Vec3 velocity = new Vec3(direction.getStepX(), direction.getStepY(), direction.getStepZ()).normalize().scale(0.1);

        if (world instanceof ServerLevel serverWorld) {
            serverWorld.sendParticles(ParticleTypes.DRIPPING_WATER, spawnPos.x, spawnPos.y, spawnPos.z, count, 0.0, 0.0, 0.0, velocity.x);
        }
    }

    public static void faucetFillBottle(Level world, BlockPos pos, Player player, InteractionHand hand) {
        ItemStack stackHand = player.getItemInHand(hand);
        Item item = stackHand.getItem();
        //player.setItemInHand(hand, ItemUtils.createFilledResult(stackHand, player, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)));
        //player.incrementStat(UDStats.USE_FAUCET);
        player.awardStat(Stats.ITEM_USED.get(item));
        world.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
        world.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
    }
}

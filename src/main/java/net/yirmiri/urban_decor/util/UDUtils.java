package net.yirmiri.urban_decor.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class UDUtils {

    public static void toolboxUsed(World world, BlockPos pos) {
        world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 0.5F, 1.0F, false);
    }

    public static void spawnWaterParticles(int count, World world, BlockPos blockPos, Direction direction) {
        Vec3d spawnPos = new Vec3d(blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5).add(new Vec3d(0, 0, -0.5));
        Vec3d velocity = new Vec3d(direction.getOffsetX(), direction.getOffsetY(), direction.getOffsetZ()).normalize().multiply(0.1);

        if (world instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ParticleTypes.DRIPPING_WATER, spawnPos.x, spawnPos.y, spawnPos.z, count, 0.0, 0.0, 0.0, velocity.x);
        }
    }

    public static void faucetFillBottle(World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ItemStack stackHand = player.getStackInHand(hand);
        Item item = stackHand.getItem();
        player.setStackInHand(hand, ItemUsage.exchangeStack(stackHand, player, PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER)));
        //player.incrementStat(UDStats.USE_FAUCET);
        player.incrementStat(Stats.USED.getOrCreateStat(item));
        world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
        world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
    }
}

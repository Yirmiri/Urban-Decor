package net.yirmiri.urban_decor.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class UDUtils {

    public static void toolboxUsed(World world, BlockPos pos) {
        world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 0.5F, 1.0F, false);
    }

    public static void spawnWaterParticles(World world, Vec3d vec3d) {
        world.addParticle(ParticleTypes.FALLING_WATER, vec3d.x, vec3d.y, vec3d.z, 0.0, 0.4, 0.0);
        world.addParticle(ParticleTypes.FALLING_WATER, vec3d.x, vec3d.y, vec3d.z, 0.0, 0.4, 0.0);
        world.addParticle(ParticleTypes.FALLING_WATER, vec3d.x, vec3d.y, vec3d.z, 0.0, 0.4, 0.0);
        world.playSound(vec3d.x + 0.5, vec3d.y + 0.5, vec3d.z + 0.5, SoundEvents.WEATHER_RAIN, SoundCategory.BLOCKS, 0.05F, 1.0F, false);
    }

    public static void faucetFillBottle(World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ItemStack stackHand = player.getStackInHand(hand);
        Item item = stackHand.getItem();
        player.setStackInHand(hand, ItemUsage.exchangeStack(stackHand, player, PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER)));
        player.incrementStat(UDStats.USE_FAUCET);
        player.incrementStat(Stats.USED.getOrCreateStat(item));
        world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
        world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
    }
}

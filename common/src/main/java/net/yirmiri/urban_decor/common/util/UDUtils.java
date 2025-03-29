package net.yirmiri.urban_decor.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class UDUtils {

    public static void toolboxUsed(Level world, BlockPos pos) {
        world.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 0.5F, 1.0F, false);
    }

    public static void spawnWaterParticles(Level world, Vec3 vec3d) {
        world.addParticle(ParticleTypes.FALLING_WATER, vec3d.x, vec3d.y, vec3d.z, 0.0, 0.4, 0.0);
        world.addParticle(ParticleTypes.FALLING_WATER, vec3d.x, vec3d.y, vec3d.z, 0.0, 0.4, 0.0);
        world.addParticle(ParticleTypes.FALLING_WATER, vec3d.x, vec3d.y, vec3d.z, 0.0, 0.4, 0.0);
        world.playLocalSound(vec3d.x + 0.5, vec3d.y + 0.5, vec3d.z + 0.5, SoundEvents.WEATHER_RAIN, SoundSource.BLOCKS, 0.05F, 1.0F, false);
    }

    public static void faucetFillBottle(Level world, BlockPos pos, Player player, InteractionHand hand) {
        ItemStack stackHand = player.getItemInHand(hand);
        Item item = stackHand.getItem();
        player.setItemInHand(hand, ItemUtils.createFilledResult(stackHand, player, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)));
        //player.incrementStat(UDStats.USE_FAUCET);
        player.awardStat(Stats.ITEM_USED.get(item));
        world.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
        world.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
    }
}

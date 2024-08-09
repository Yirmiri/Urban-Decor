package net.yirmiri.urban_decor.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.util.Clearable;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.yirmiri.urban_decor.block.ToasterBlock;
import net.yirmiri.urban_decor.registry.RegisterBlockEntities;
import org.jetbrains.annotations.Nullable;

public class ToasterBlockEntity extends CampfireBlockEntity implements Clearable {
    private final DefaultedList<ItemStack> itemsBeingCooked;
    private final int[] cookingTimes;
    private final int[] cookingTotalTimes;
    private final RecipeManager.MatchGetter<SingleStackRecipeInput, CampfireCookingRecipe> matchGetter;

    public ToasterBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
        this.itemsBeingCooked = DefaultedList.ofSize(2, ItemStack.EMPTY);
        this.cookingTimes = new int[2];
        this.cookingTotalTimes = new int[2];
        this.matchGetter = RecipeManager.createCachedMatchGetter(RecipeType.CAMPFIRE_COOKING);
    }

    @Override
    public BlockEntityType<?> getType() {
        return RegisterBlockEntities.TOASTER;
    }

    public static void litServerTick(World world, BlockPos pos, BlockState state, ToasterBlockEntity toaster) {
        boolean bl = false;

        for(int i = 0; i < toaster.itemsBeingCooked.size(); ++i) {
            ItemStack itemStack = toaster.itemsBeingCooked.get(i);
            if (!itemStack.isEmpty()) {
                bl = true;
                int var10002 = toaster.cookingTimes[i]++;
                if (toaster.cookingTimes[i] >= toaster.cookingTotalTimes[i]) {
                    SingleStackRecipeInput singleStackRecipeInput = new SingleStackRecipeInput(itemStack);
                    ItemStack itemStack2 = toaster.matchGetter.getFirstMatch(singleStackRecipeInput, world).map((recipe) -> {
                        return (recipe.value()).craft(singleStackRecipeInput, world.getRegistryManager());
                    }).orElse(itemStack);
                    if (itemStack2.isItemEnabled(world.getEnabledFeatures())) {
                        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), itemStack2);
                        toaster.itemsBeingCooked.set(i, ItemStack.EMPTY);
                        world.updateListeners(pos, state, state, 3);
                        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));
                    }
                }
            }
        }

        if (bl) {
            markDirty(world, pos, state);
        }
    }

    public DefaultedList<ItemStack> getItemsBeingCooked() {
        return this.itemsBeingCooked;
    }

    public static void unlitServerTick(World world, BlockPos pos, BlockState state, ToasterBlockEntity toaster) {
        boolean bl = false;

        for (int i = 0; i < toaster.itemsBeingCooked.size(); i++) {
            if (toaster.cookingTimes[i] > 0) {
                bl = true;
                toaster.cookingTimes[i] = MathHelper.clamp(toaster.cookingTimes[i] - 2, 0, toaster.cookingTotalTimes[i]);
            }
        }

        if (bl) {
            markDirty(world, pos, state);
        }
    }

    public boolean addItem(@Nullable LivingEntity user, ItemStack stack, int cookTime) {
        for(int i = 0; i < this.itemsBeingCooked.size(); ++i) {
            ItemStack itemStack = this.itemsBeingCooked.get(i);
            if (itemStack.isEmpty()) {
                this.cookingTotalTimes[i] = cookTime;
                this.cookingTimes[i] = 0;
                this.itemsBeingCooked.set(i, stack.splitUnlessCreative(1, user));
                this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(user, this.getCachedState()));
                this.updateListeners();
                return true;
            }
        }
        return false;
    }

    private void updateListeners() {
        markDirty();
        getWorld().updateListeners(getPos(), getCachedState(), getCachedState(), Block.NOTIFY_ALL);
    }

    public static void clientTick(World world, BlockPos pos, BlockState state, ToasterBlockEntity toaster) {

    }
}

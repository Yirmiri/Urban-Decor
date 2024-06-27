package net.yirmiri.urban_decor.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
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
    private final DefaultedList<ItemStack> itemsBeingCooked = DefaultedList.ofSize(2, ItemStack.EMPTY);
    private final int[] cookingTimes = new int[2];
    private final int[] cookingTotalTimes = new int[2];
    private final RecipeManager.MatchGetter<Inventory, CampfireCookingRecipe> matchGetter = RecipeManager.createCachedMatchGetter(RecipeType.CAMPFIRE_COOKING);

    public ToasterBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return RegisterBlockEntities.TOASTER;
    }

    public static void litServerTick(World world, BlockPos pos, BlockState state, ToasterBlockEntity toaster) {
        boolean bl = false;

        for (int i = 0; i < toaster.itemsBeingCooked.size(); i++) {
            ItemStack itemStack = toaster.itemsBeingCooked.get(i);
            if (!itemStack.isEmpty()) {
                bl = true;
                toaster.cookingTimes[i]++;
                if (toaster.cookingTimes[i] >= toaster.cookingTotalTimes[i]) {
                    Inventory inventory = new SimpleInventory(itemStack);
                    ItemStack itemStack2 = toaster.matchGetter
                            .getFirstMatch(inventory, world)
                            .map(recipe -> recipe.craft(inventory, world.getRegistryManager()))
                            .orElse(itemStack);
                    if (itemStack2.isItemEnabled(world.getEnabledFeatures())) {
                        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), itemStack2);
                        toaster.itemsBeingCooked.set(i, ItemStack.EMPTY);
                        world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
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

    public boolean addItem(@Nullable Entity user, ItemStack stack, int cookTime) {
        for (int i = 0; i < itemsBeingCooked.size(); i++) {
            ItemStack itemStack = itemsBeingCooked.get(i);
            if (itemStack.isEmpty()) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 0.5F, 1.0F, false);
                cookingTotalTimes[i] = cookTime;
                cookingTimes[i] = 0;
                itemsBeingCooked.set(i, stack.split(1));
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, getPos(), GameEvent.Emitter.of(user, getCachedState()));
                updateListeners();
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
        Random random = world.random;
        int i = (state.get(ToasterBlock.FACING)).getHorizontal();
        for (int j = 0; j < toaster.itemsBeingCooked.size(); j++) {
            if (!toaster.itemsBeingCooked.get(j).isEmpty() && random.nextFloat() < 0.2F) {
                Direction direction = Direction.fromHorizontal(Math.floorMod(j + i, 4));
                float f = 0.3125F;
                double d = pos.getX() + 0.5 - (direction.getOffsetX() * 0.3125F) + (direction.rotateYClockwise().getOffsetX() * 0.3125F);
                double e = pos.getY() + 0.5;
                double g = pos.getZ() + 0.5 - (direction.getOffsetZ() * 0.3125F) + (direction.rotateYClockwise().getOffsetZ() * 0.3125F);
            }
        }
    }
}

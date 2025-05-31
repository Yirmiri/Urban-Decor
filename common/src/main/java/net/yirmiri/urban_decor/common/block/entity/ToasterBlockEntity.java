package net.yirmiri.urban_decor.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Clearable;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.yirmiri.urban_decor.common.block.ToasterBlock;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;

public class ToasterBlockEntity extends CampfireBlockEntity implements Clearable {
    private final NonNullList<ItemStack> itemsBeingCooked = NonNullList.withSize(2, ItemStack.EMPTY);
    private final int[] cookingTimes = new int[2];
    private final int[] cookingTotalTimes = new int[2];
    private final RecipeManager.CachedCheck<Container, CampfireCookingRecipe> matchGetter = RecipeManager.createCheck(RecipeType.CAMPFIRE_COOKING);

    public ToasterBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return UDBlockEntities.TOASTER.get();
    }

    public static void litServerTick(Level world, BlockPos pos, BlockState state, ToasterBlockEntity toaster) {
        boolean bl = false;

        for (int i = 0; i < toaster.itemsBeingCooked.size(); i++) {
            ItemStack itemStack = toaster.itemsBeingCooked.get(i);
            if (!itemStack.isEmpty()) {
                bl = true;
                toaster.cookingTimes[i]++;
                if (toaster.cookingTimes[i] >= toaster.cookingTotalTimes[i]) {
                    Container inventory = new SimpleContainer(itemStack);
                    ItemStack itemStack2 = toaster.matchGetter
                            .getRecipeFor(inventory, world)
                            .map(recipe -> recipe.assemble(inventory, world.registryAccess()))
                            .orElse(itemStack);
                    if (itemStack2.isItemEnabled(world.enabledFeatures())) {
                        Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), itemStack2);
                        toaster.itemsBeingCooked.set(i, ItemStack.EMPTY);
                        world.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
                        world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
                    }
                }
            }
        }

        if (bl) {
            setChanged(world, pos, state);
        }
    }

    public NonNullList<ItemStack> getItems() {
        return this.itemsBeingCooked;
    }

    public static void unlitServerTick(Level world, BlockPos pos, BlockState state, ToasterBlockEntity toaster) {
        boolean bl = false;

        for (int i = 0; i < toaster.itemsBeingCooked.size(); i++) {
            if (toaster.cookingTimes[i] > 0) {
                bl = true;
                toaster.cookingTimes[i] = Mth.clamp(toaster.cookingTimes[i] - 2, 0, toaster.cookingTotalTimes[i]);
            }
        }

        if (bl) {
            setChanged(world, pos, state);
        }
    }

    public boolean placeFood(Entity user, ItemStack stack, int cookTime) {
        for (int i = 0; i < itemsBeingCooked.size(); i++) {
            ItemStack itemStack = itemsBeingCooked.get(i);
            if (itemStack.isEmpty()) {
                cookingTotalTimes[i] = cookTime;
                cookingTimes[i] = 0;
                itemsBeingCooked.set(i, stack.split(1));
                level.gameEvent(GameEvent.BLOCK_CHANGE, getBlockPos(), GameEvent.Context.of(user, getBlockState()));
                markUpdated();
                return true;
            }
            if (user != null) {
                user.playSound(SoundEvents.ITEM_FRAME_ADD_ITEM, 1.0F, 1.0F);
            }
        }
        return false;
    }

    private void markUpdated() {
        setChanged();
        getLevel().sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    public static void clientTick(Level world, BlockPos pos, BlockState state, ToasterBlockEntity toaster) {
        RandomSource random = world.random;
        int i = (state.getValue(ToasterBlock.FACING)).get2DDataValue();
        for (int j = 0; j < toaster.itemsBeingCooked.size(); j++) {
            if (!toaster.itemsBeingCooked.get(j).isEmpty() && random.nextFloat() < 0.2F) {
                Direction direction = Direction.from2DDataValue(Math.floorMod(j + i, 4));
                float f = 0.3125F;
                double d = pos.getX() + 0.5 - (direction.getStepX() * 0.3125F) + (direction.getClockWise().getStepX() * 0.3125F);
                double e = pos.getY() + 0.5;
                double g = pos.getZ() + 0.5 - (direction.getStepZ() * 0.3125F) + (direction.getClockWise().getStepZ() * 0.3125F);
            }
        }
    }
}

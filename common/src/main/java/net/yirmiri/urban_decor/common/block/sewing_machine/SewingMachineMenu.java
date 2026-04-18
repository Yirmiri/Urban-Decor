package net.yirmiri.urban_decor.common.block.sewing_machine;

import com.google.common.collect.Lists;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDItems;
import net.yirmiri.urban_decor.core.registry.UDMenus;
import net.yirmiri.urban_decor.core.registry.UDSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class SewingMachineMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipe = DataSlot.standalone();
    private final List<SewingMachineRecipe> availableRecipes = Lists.newArrayList();

    private ItemStack lastA = ItemStack.EMPTY;
    private ItemStack lastB = ItemStack.EMPTY;

    public final Container container;
    public final ResultContainer resultContainer = new ResultContainer();

    public final Slot inputA;
    public final Slot inputB;
    public final Slot resultSlot;

    public long lastSoundTime;

    public SewingMachineMenu(int id, Inventory playerInv) {
        this(id, playerInv, ContainerLevelAccess.NULL);
    }

    public SewingMachineMenu(int id, Inventory playerInv, ContainerLevelAccess access) {
        super(UDMenus.SEWING_MACHINE.get(), id);

        this.container = new SimpleContainer(2) {
            @Override
            public void setChanged() {
                super.setChanged();
                slotsChanged(this);
            }
        };
        this.access = access;

        inputA = this.addSlot(new Slot(container, 0, 18, 21));
        inputB = this.addSlot(new Slot(container, 1, 18, 47));

        resultSlot = this.addSlot(new Slot(resultContainer, 2, 143, 33) {

            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());

                inputA.remove(1);
                //inputB.remove(1); //no need to since needles stay now

                setupResult();

                access.execute((level, pos) -> {
                    long l = level.getGameTime();
                    if (SewingMachineMenu.this.lastSoundTime != l) {
                        level.playSound(null, pos, UDSounds.SEW.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                        SewingMachineMenu.this.lastSoundTime = l;
                    }
                });
                super.onTake(player, stack);
            }
        });
        addPlayerInventory(playerInv);
        addDataSlot(selectedRecipe);
    }

    private void addPlayerInventory(Inventory inv) {
        for (int r = 0; r < 3; ++r) {
            for (int c = 0; c < 9; ++c) {
                addSlot(new Slot(inv, c + r * 9 + 9, 8 + c * 18, 84 + r * 18));
            }

            for (int c = 0; c < 9; ++c) {
                addSlot(new Slot(inv, c, 8 + c * 18, 142));
            }
        }
    }

    public void slotsChanged(Container container) {
        ItemStack stackA = inputA.getItem();
        ItemStack stackB = inputB.getItem();

        if (!ItemStack.isSameItemSameComponents(stackA, lastA) || !ItemStack.isSameItemSameComponents(stackB, lastB)) {
            lastA = stackA.copy();
            lastB = stackB.copy();
            rebuildRecipeList();
        }
    }

    private void rebuildRecipeList() {
        availableRecipes.clear();
        selectedRecipe.set(-1);
        resultSlot.set(ItemStack.EMPTY);

        if (!lastA.isEmpty() && (lastB.isEmpty() || lastB.is(UDItems.SEWING_NEEDLE.get()))) {
            for (SewingMachineRecipe recipe : SewingRecipes.RECIPES) {
                if (recipe.matches(lastA, lastB)) {
                    availableRecipes.add(recipe);
                }
            }
        }
    }

    public void setupResult() {
        int index = selectedRecipe.get();

        if (index >= 0 && index < availableRecipes.size()) {

            SewingMachineRecipe recipe = availableRecipes.get(index);
            ItemStack result = recipe.assemble();

            resultContainer.setItem(2, result);
            resultSlot.set(result);
        } else {
            resultSlot.set(ItemStack.EMPTY);
        }
        broadcastChanges();
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
//        if (!player.level().isClientSide) {
//            this.clearContainer(player, this.container);
//        }

        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> this.clearContainer(player, this.container));
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (id >= 0 && id < availableRecipes.size()) {
            selectedRecipe.set(id);
            setupResult();
        }
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack slotItem = slot.getItem();
            itemStack = slotItem.copy();

            if (index == 2) {
                if (!this.moveItemStackTo(slotItem, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(slotItem, itemStack);
            }
            else if (index >= 3) {
                if (!this.moveItemStackTo(slotItem, 0, 2, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else {
                if (!this.moveItemStackTo(slotItem, 3, 39, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (slotItem.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (slotItem.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, slotItem);
        }
        return itemStack;
    }

    @Override
    public boolean stillValid(Player player) {
        //return true;
        return stillValid(this.access, player, UDBlocks.SEWING_MACHINE.get());
    }

    public int getRecipeCount() {
        return availableRecipes.size();
    }

    public int getSelectedRecipeIndex() {
        return selectedRecipe.get();
    }

    public ItemStack getRecipeResult(int index) {
        return availableRecipes.get(index).assemble();
    }

    public boolean hasInputs() {
        return !inputA.getItem().isEmpty() && (inputB.getItem().isEmpty() || inputB.getItem().is(UDItems.SEWING_NEEDLE.get()));
    }
}
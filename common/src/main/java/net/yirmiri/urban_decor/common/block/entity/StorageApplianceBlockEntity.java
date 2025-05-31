package net.yirmiri.urban_decor.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractStorageDecorBlock;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;
import net.yirmiri.urban_decor.core.registry.UDSounds;

public class StorageApplianceBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> inventory;
    private final ContainerOpenersCounter stateManager;

    public StorageApplianceBlockEntity(BlockPos pos, BlockState state) {
        super(UDBlockEntities.STORAGE_APPLIANCE.get(), pos, state);
        inventory = NonNullList.withSize(27, ItemStack.EMPTY);
        stateManager = new ContainerOpenersCounter() {
            protected void onOpen(Level world, BlockPos pos, BlockState state) {
                playSound(state, UDSounds.APPLIANCE_OPEN.get());
                setOpen(state, true);
            }

            protected void onClose(Level world, BlockPos pos, BlockState state) {
                playSound(state, UDSounds.APPLIANCE_OPEN.get()); //todo: close sound
                if (AbstractStorageDecorBlock.isTrulyOpen(state)) {
                    setOpen(state, true);
                } else if (!AbstractStorageDecorBlock.isTrulyOpen(state)) {
                    setOpen(state, false);
                }
            }

            protected void openerCountChanged(Level world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
            }

            protected boolean isOwnContainer(Player player) {
                if (player.containerMenu instanceof ChestMenu) {
                    Container inventory = ((ChestMenu)player.containerMenu).getContainer();
                    return inventory == StorageApplianceBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    void setOpen(BlockState state, boolean open) {
        level.setBlock(getBlockPos(), state.setValue(AbstractStorageDecorBlock.OPEN, open), 3);
    }

    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        if (!trySaveLootTable(nbt)) {
            ContainerHelper.saveAllItems(nbt, inventory);
        }

    }

    public void load(CompoundTag nbt) {
        super.load(nbt);
        inventory = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        if (!tryLoadLootTable(nbt)) {
            ContainerHelper.loadAllItems(nbt, inventory);
        }
    }

    public int getContainerSize() {
        return 27;
    }

    protected NonNullList<ItemStack> getItems() {
        return inventory;
    }

    protected void setItems(NonNullList<ItemStack> list) {
        inventory = list;
    }

    protected Component getDefaultName() {
        return Component.translatable("container.urban_decor.generic");
    }

    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return ChestMenu.threeRows(syncId, playerInventory, this);
    }

    public void startOpen(Player player) {
        if (!remove && !player.isSpectator()) {
            stateManager.incrementOpeners(player, getLevel(), getBlockPos(), getBlockState());
        }
    }

    public void stopOpen(Player player) {
        if (!remove && !player.isSpectator()) {
            stateManager.decrementOpeners(player, getLevel(), getBlockPos(), getBlockState());
        }
    }

    public void tick() {
        if (!remove) {
            stateManager.recheckOpeners(getLevel(), getBlockPos(), getBlockState());
        }
    }

    void playSound(BlockState state, SoundEvent soundEvent) {
        Vec3i vec3i = (state.getValue(AbstractStorageDecorBlock.FACING)).getNormal();
        double d = (double)worldPosition.getX() + 0.5 + (double)vec3i.getX() / 2.0;
        double e = (double)worldPosition.getY() + 0.5 + (double)vec3i.getY() / 2.0;
        double f = (double)worldPosition.getZ() + 0.5 + (double)vec3i.getZ() / 2.0;
        level.playSound(null, d, e, f, soundEvent, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
    }
}

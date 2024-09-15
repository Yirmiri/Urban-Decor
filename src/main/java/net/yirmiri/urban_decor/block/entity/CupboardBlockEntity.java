package net.yirmiri.urban_decor.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.CupboardBlock;
import net.yirmiri.urban_decor.registry.UDBlockEntities;
import net.yirmiri.urban_decor.registry.UDSounds;

public class CupboardBlockEntity extends LootableContainerBlockEntity {
    private DefaultedList<ItemStack> inventory;
    private final ViewerCountManager stateManager;

    public CupboardBlockEntity(BlockPos pos, BlockState state) {
        super(UDBlockEntities.CUPBOARD, pos, state);
        inventory = DefaultedList.ofSize(27, ItemStack.EMPTY);
        stateManager = new ViewerCountManager() {
            protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
                playSound(state, UDSounds.APPLIANCE_OPEN);
                setOpen(state, true);
            }

            protected void onContainerClose(World world, BlockPos pos, BlockState state) {
                playSound(state, UDSounds.APPLIANCE_OPEN); //todo: close sound
                setOpen(state, false);
            }

            protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
            }

            protected boolean isPlayerViewing(PlayerEntity player) {
                if (player.currentScreenHandler instanceof GenericContainerScreenHandler) {
                    Inventory inventory = ((GenericContainerScreenHandler)player.currentScreenHandler).getInventory();
                    return inventory == CupboardBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (!serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, inventory);
        }

    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        inventory = DefaultedList.ofSize(size(), ItemStack.EMPTY);
        if (!deserializeLootTable(nbt)) {
            Inventories.readNbt(nbt, inventory);
        }

    }

    public int size() {
        return 27;
    }

    protected DefaultedList<ItemStack> getInvStackList() {
        return inventory;
    }

    protected void setInvStackList(DefaultedList<ItemStack> list) {
        inventory = list;
    }

    protected Text getContainerName() {
        return Text.translatable("container.urban_decor.cupboard");
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, this);
    }

    public void onOpen(PlayerEntity player) {
        if (!removed && !player.isSpectator()) {
            stateManager.openContainer(player, getWorld(), getPos(), getCachedState());
        }

    }

    public void onClose(PlayerEntity player) {
        if (!removed && !player.isSpectator()) {
            stateManager.closeContainer(player, getWorld(), getPos(), getCachedState());
        }

    }

    public void tick() {
        if (!removed) {
            stateManager.updateViewerCount(getWorld(), getPos(), getCachedState());
        }
    }

    void setOpen(BlockState state, boolean open) {
        world.setBlockState(getPos(), state.with(CupboardBlock.OPEN, open), 3);
    }

    void playSound(BlockState state, SoundEvent soundEvent) {
        Vec3i vec3i = (state.get(CupboardBlock.FACING)).getVector();
        double d = (double)pos.getX() + 0.5 + (double)vec3i.getX() / 2.0;
        double e = (double)pos.getY() + 0.5 + (double)vec3i.getY() / 2.0;
        double f = (double)pos.getZ() + 0.5 + (double)vec3i.getZ() / 2.0;
        world.playSound(null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
    }
}

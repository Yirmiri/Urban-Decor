package net.yirmiri.urban_decor.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractSmokerDecorBlock;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;
import net.yirmiri.urban_decor.core.registry.UDSounds;

public class SmokerDecorBlockEntity extends AbstractFurnaceBlockEntity {
    private final ContainerOpenersCounter stateManager;

    public SmokerDecorBlockEntity(BlockPos pos, BlockState state) {
        super(UDBlockEntities.SMOKER_DECOR.get(), pos, state, RecipeType.SMOKING);
        stateManager = new ContainerOpenersCounter() {
            @Override
            protected void onOpen(Level world, BlockPos pos, BlockState state) {
                playSound(state, UDSounds.APPLIANCE_OPEN.get());
                setOpen(state, true);
            }

            @Override
            protected void onClose(Level world, BlockPos pos, BlockState state) {
                playSound(state, UDSounds.APPLIANCE_OPEN.get()); //todo: close sound
                if (AbstractSmokerDecorBlock.isTrulyOpen(state)) {
                    setOpen(state, true);
                } else if (!AbstractSmokerDecorBlock.isTrulyOpen(state)) {
                    setOpen(state, false);
                }
            }

            @Override
            protected void openerCountChanged(Level world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
            }

            @Override
            protected boolean isOwnContainer(Player player) {
                if (player.containerMenu instanceof ChestMenu) {
                    Container inventory = ((ChestMenu)player.containerMenu).getContainer();
                    return inventory == SmokerDecorBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    protected Component getDefaultName() {
        return Component.translatable("container.urban_decor.smoker");
    }

    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return new FurnaceMenu(syncId, playerInventory, this, this.dataAccess);
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

    void setOpen(BlockState state, boolean open) {
        level.setBlock(getBlockPos(), state.setValue(AbstractSmokerDecorBlock.OPEN, open), 3);
    }

    void playSound(BlockState state, SoundEvent soundEvent) {
        Vec3i vec3i = (state.getValue(AbstractSmokerDecorBlock.FACING)).getNormal();
        double d = (double)worldPosition.getX() + 0.5 + (double)vec3i.getX() / 2.0;
        double e = (double)worldPosition.getY() + 0.5 + (double)vec3i.getY() / 2.0;
        double f = (double)worldPosition.getZ() + 0.5 + (double)vec3i.getZ() / 2.0;
        level.playSound(null, d, e, f, soundEvent, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
    }
}

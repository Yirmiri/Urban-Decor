package net.yirmiri.urban_decor.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.yirmiri.urban_decor.block.abstracts.AbstractSmokerDecorBlock;
import net.yirmiri.urban_decor.registry.UDBlockEntities;
import net.yirmiri.urban_decor.registry.UDSounds;

public class SmokerDecorBlockEntity extends AbstractFurnaceBlockEntity {
    private final ViewerCountManager stateManager;

    public SmokerDecorBlockEntity(BlockPos pos, BlockState state) {
        super(UDBlockEntities.SMOKER_DECOR, pos, state, RecipeType.SMOKING);
        stateManager = new ViewerCountManager() {
            @Override
            protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
                playSound(state, UDSounds.APPLIANCE_OPEN);
                setOpen(state, true);
            }

            @Override
            protected void onContainerClose(World world, BlockPos pos, BlockState state) {
                playSound(state, UDSounds.APPLIANCE_OPEN); //todo: close sound
                if (AbstractSmokerDecorBlock.isTrulyOpen(state)) {
                    setOpen(state, true);
                } else if (!AbstractSmokerDecorBlock.isTrulyOpen(state)) {
                    setOpen(state, false);
                }
            }

            @Override
            protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
            }

            @Override
            protected boolean isPlayerViewing(PlayerEntity player) {
                if (player.currentScreenHandler instanceof GenericContainerScreenHandler) {
                    Inventory inventory = ((GenericContainerScreenHandler)player.currentScreenHandler).getInventory();
                    return inventory == SmokerDecorBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    protected Text getContainerName() {
        return Text.translatable("container.urban_decor.smoker");
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new FurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
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

    void setOpen(BlockState state, boolean open) {
        world.setBlockState(getPos(), state.with(AbstractSmokerDecorBlock.OPEN, open), 3);
    }

    void playSound(BlockState state, SoundEvent soundEvent) {
        Vec3i vec3i = (state.get(AbstractSmokerDecorBlock.FACING)).getVector();
        double d = (double)pos.getX() + 0.5 + (double)vec3i.getX() / 2.0;
        double e = (double)pos.getY() + 0.5 + (double)vec3i.getY() / 2.0;
        double f = (double)pos.getZ() + 0.5 + (double)vec3i.getZ() / 2.0;
        world.playSound(null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
    }
}

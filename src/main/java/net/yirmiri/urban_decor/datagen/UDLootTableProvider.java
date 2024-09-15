package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.enums.BedPart;
import net.minecraft.loot.LootTable;
import net.minecraft.util.DyeColor;
import net.yirmiri.urban_decor.block.AbstractLongBlock;
import net.yirmiri.urban_decor.registry.RegisterBlocks;
import net.yirmiri.urban_decor.registry.RegisterItems;

public class UDLootTableProvider extends FabricBlockLootTableProvider {
    public UDLootTableProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        addDrop(RegisterBlocks.PORCELAIN_TILES);
        addDrop(RegisterBlocks.PORCELAIN_TILE_STAIRS);
        addDrop(RegisterBlocks.PORCELAIN_TILE_SLAB, slabDrops(RegisterBlocks.PORCELAIN_TILE_SLAB));
        addDrop(RegisterBlocks.TRASH_CAN);
        addDrop(RegisterBlocks.MICROWAVE);
        addDrop(RegisterBlocks.SINK);
        addDrop(RegisterBlocks.CHROMITE);
        addDrop(RegisterBlocks.CHROMITE_STAIRS);
        addDrop(RegisterBlocks.CHROMITE_SLAB, slabDrops(RegisterBlocks.CHROMITE_SLAB));
        addDrop(RegisterBlocks.CHROMITE_WALL);
        addDrop(RegisterBlocks.POLISHED_CHROMITE);
        addDrop(RegisterBlocks.POLISHED_CHROMITE_STAIRS);
        addDrop(RegisterBlocks.POLISHED_CHROMITE_SLAB, slabDrops(RegisterBlocks.POLISHED_CHROMITE_SLAB));
        addDrop(RegisterBlocks.WASHING_MACHINE);
        addDrop(RegisterBlocks.DRYER);
        addDrop(RegisterBlocks.TOASTER);
        addDrop(RegisterBlocks.AIR_CONDITIONER);
        addDrop(RegisterBlocks.DARK_PORCELAIN_TILES);
        addDrop(RegisterBlocks.DARK_PORCELAIN_TILE_STAIRS);
        addDrop(RegisterBlocks.DARK_PORCELAIN_TILE_SLAB, slabDrops(RegisterBlocks.PORCELAIN_TILE_SLAB));
        addDrop(RegisterBlocks.DESK_FAN);
        addDrop(RegisterBlocks.TOOLBOX, RegisterItems.TOOLBOX);
        addDrop(RegisterBlocks.FAUCET);
        addDrop(RegisterBlocks.CHECKERED_PORCELAIN_TILES);
        addDrop(RegisterBlocks.CHECKERED_PORCELAIN_TILE_STAIRS);
        addDrop(RegisterBlocks.CHECKERED_PORCELAIN_TILE_SLAB, slabDrops(RegisterBlocks.PORCELAIN_TILE_SLAB));
        addDrop(RegisterBlocks.STAINLESS_STEEL_BLOCK);
        addDrop(RegisterBlocks.OVEN);
        addDrop(RegisterBlocks.RADIATOR);
        addDrop(RegisterBlocks.STOVE);
        addDrop(RegisterBlocks.FRIDGE);
        addDrop(RegisterBlocks.FREEZER);
        addDrop(RegisterBlocks.TURBINE);
        addDrop(RegisterBlocks.TOILET);
        addDrop(RegisterBlocks.DARK_TOILET);
        addDrop(RegisterBlocks.DARK_FRIDGE);
        addDrop(RegisterBlocks.DARK_FREEZER);
        addDrop(RegisterBlocks.DARK_OVEN);
        addDrop(RegisterBlocks.DARK_WASHING_MACHINE);
        addDrop(RegisterBlocks.DARK_DRYER);
        addDrop(RegisterBlocks.DARK_SINK);
        addDyedTowelsDrops();
        addDrop(RegisterBlocks.TOWEL_BAR);
        addTowelBarTowelDrops();
        addDrop(RegisterBlocks.SATELLITE_DISH);
        addDrop(RegisterBlocks.SHOWER);
        addDrop(RegisterBlocks.BATHTUB, longBlockDrops(RegisterBlocks.BATHTUB));
        addDrop(RegisterBlocks.DARK_BATHTUB, longBlockDrops(RegisterBlocks.DARK_BATHTUB));
        addDyedTowelBlockDrops();
        addDrop(RegisterBlocks.RIGID_GLASS);
        addDrop(RegisterBlocks.PORCELAIN_BLOCK);
        addDrop(RegisterBlocks.PORCELAIN_STAIRS);
        addDrop(RegisterBlocks.PORCELAIN_SLAB, slabDrops(RegisterBlocks.PORCELAIN_SLAB));
        addDrop(RegisterBlocks.DARK_PORCELAIN_BLOCK);
        addDrop(RegisterBlocks.DARK_PORCELAIN_STAIRS);
        addDrop(RegisterBlocks.DARK_PORCELAIN_SLAB, slabDrops(RegisterBlocks.DARK_PORCELAIN_SLAB));
        addDyedPictureFrameDrops();
        addDrop(RegisterBlocks.PICTURE_FRAME);
        addDrop(RegisterBlocks.CUPBOARD);
        addDrop(RegisterBlocks.DARK_CUPBOARD);
    }

    private void addDyedTowelBlockDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(RegisterBlocks.getDyedTowelBlocks(colors.getId()));
        }
    }

    private void addDyedTowelsDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(RegisterBlocks.getDyedTowels(colors.getId()));
        }
    }

    private void addTowelBarTowelDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(RegisterBlocks.getDyedTowels(colors.getId()));
            addDrop(RegisterBlocks.TOWEL_BAR);
        }
    }

    private void addDyedPictureFrameDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(RegisterBlocks.getDyedPictureFrames(colors.getId()));
        }
    }

    public LootTable.Builder longBlockDrops(Block block) {
        return this.dropsWithProperty(block, AbstractLongBlock.PART, BedPart.HEAD);
    }
}
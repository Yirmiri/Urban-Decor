package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.enums.BedPart;
import net.minecraft.loot.LootTable;
import net.minecraft.util.DyeColor;
import net.yirmiri.urban_decor.block.AbstractLongBlock;
import net.yirmiri.urban_decor.registry.UDBlocks;
import net.yirmiri.urban_decor.registry.UDItems;

public class UDLootTableProvider extends FabricBlockLootTableProvider {
    public UDLootTableProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        addDrop(UDBlocks.PORCELAIN_TILES);
        addDrop(UDBlocks.PORCELAIN_TILE_STAIRS);
        addDrop(UDBlocks.PORCELAIN_TILE_SLAB, slabDrops(UDBlocks.PORCELAIN_TILE_SLAB));
        addDrop(UDBlocks.TRASH_CAN);
        addDrop(UDBlocks.MICROWAVE);
        addDrop(UDBlocks.SINK);
        addDrop(UDBlocks.CHROMITE);
        addDrop(UDBlocks.CHROMITE_STAIRS);
        addDrop(UDBlocks.CHROMITE_SLAB, slabDrops(UDBlocks.CHROMITE_SLAB));
        addDrop(UDBlocks.CHROMITE_WALL);
        addDrop(UDBlocks.POLISHED_CHROMITE);
        addDrop(UDBlocks.POLISHED_CHROMITE_STAIRS);
        addDrop(UDBlocks.POLISHED_CHROMITE_SLAB, slabDrops(UDBlocks.POLISHED_CHROMITE_SLAB));
        addDrop(UDBlocks.WASHING_MACHINE);
        addDrop(UDBlocks.DRYER);
        addDrop(UDBlocks.TOASTER);
        addDrop(UDBlocks.AIR_CONDITIONER);
        addDrop(UDBlocks.DARK_PORCELAIN_TILES);
        addDrop(UDBlocks.DARK_PORCELAIN_TILE_STAIRS);
        addDrop(UDBlocks.DARK_PORCELAIN_TILE_SLAB, slabDrops(UDBlocks.PORCELAIN_TILE_SLAB));
        addDrop(UDBlocks.DESK_FAN);
        addDrop(UDBlocks.TOOLBOX, UDItems.TOOLBOX);
        addDrop(UDBlocks.FAUCET);
        addDrop(UDBlocks.CHECKERED_PORCELAIN_TILES);
        addDrop(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS);
        addDrop(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB, slabDrops(UDBlocks.PORCELAIN_TILE_SLAB));
        addDrop(UDBlocks.STAINLESS_STEEL_BLOCK);
        addDrop(UDBlocks.OVEN);
        addDrop(UDBlocks.RADIATOR);
        addDrop(UDBlocks.STOVE);
        addDrop(UDBlocks.FRIDGE);
        addDrop(UDBlocks.FREEZER);
        addDrop(UDBlocks.TURBINE);
        addDrop(UDBlocks.TOILET);
        addDrop(UDBlocks.DARK_TOILET);
        addDrop(UDBlocks.DARK_FRIDGE);
        addDrop(UDBlocks.DARK_FREEZER);
        addDrop(UDBlocks.DARK_OVEN);
        addDrop(UDBlocks.DARK_WASHING_MACHINE);
        addDrop(UDBlocks.DARK_DRYER);
        addDrop(UDBlocks.DARK_SINK);
        addDyedTowelsDrops();
        addDrop(UDBlocks.TOWEL_BAR);
        addTowelBarTowelDrops();
        addDrop(UDBlocks.SATELLITE_DISH);
        addDrop(UDBlocks.SHOWER);
        addDrop(UDBlocks.BATHTUB, longBlockDrops(UDBlocks.BATHTUB));
        addDrop(UDBlocks.DARK_BATHTUB, longBlockDrops(UDBlocks.DARK_BATHTUB));
        addDyedTowelBlockDrops();
        addDrop(UDBlocks.RIGID_GLASS);
        addDrop(UDBlocks.PORCELAIN_BLOCK);
        addDrop(UDBlocks.PORCELAIN_STAIRS);
        addDrop(UDBlocks.PORCELAIN_SLAB, slabDrops(UDBlocks.PORCELAIN_SLAB));
        addDrop(UDBlocks.DARK_PORCELAIN_BLOCK);
        addDrop(UDBlocks.DARK_PORCELAIN_STAIRS);
        addDrop(UDBlocks.DARK_PORCELAIN_SLAB, slabDrops(UDBlocks.DARK_PORCELAIN_SLAB));
        addDyedPictureFrameDrops();
        addDrop(UDBlocks.PICTURE_FRAME);
        addDrop(UDBlocks.CUPBOARD);
        addDrop(UDBlocks.DARK_CUPBOARD);
        addDrop(UDBlocks.FILING_CABINET);
    }

    private void addDyedTowelBlockDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedTowelBlocks(colors.getId()));
        }
    }

    private void addDyedTowelsDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedTowels(colors.getId()));
        }
    }

    private void addTowelBarTowelDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedTowels(colors.getId()));
            addDrop(UDBlocks.TOWEL_BAR);
        }
    }

    private void addDyedPictureFrameDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedPictureFrames(colors.getId()));
        }
    }

    public LootTable.Builder longBlockDrops(Block block) {
        return this.dropsWithProperty(block, AbstractLongBlock.PART, BedPart.HEAD);
    }
}
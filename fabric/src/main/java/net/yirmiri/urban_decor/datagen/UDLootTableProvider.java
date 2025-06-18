package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootTable;
import net.yirmiri.urban_decor.common.block.FloorLampBlock;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractLongBlock;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDItems;

import java.util.concurrent.CompletableFuture;

public class UDLootTableProvider extends FabricBlockLootTableProvider {
    public UDLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(UDBlocks.PORCELAIN_TILES.get());
        dropSelf(UDBlocks.PORCELAIN_TILE_STAIRS.get());
        add(UDBlocks.PORCELAIN_TILE_SLAB.get(), createSlabItemTable(UDBlocks.PORCELAIN_TILE_SLAB.get()));
        dropSelf(UDBlocks.DARK_PORCELAIN_TILES.get());
        dropSelf(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get());
        add(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get(), createSlabItemTable(UDBlocks.PORCELAIN_TILE_SLAB.get()));
        dropSelf(UDBlocks.TRASH_CAN.get());
        dropOther(UDBlocks.MICROWAVE.get(), UDItems.MICROWAVE.get());
        dropOther(UDBlocks.WALL_MICROWAVE.get(), UDItems.MICROWAVE.get());
        dropSelf(UDBlocks.SINK.get());
        dropSelf(UDBlocks.CHROMITE.get());
        dropSelf(UDBlocks.CHROMITE_STAIRS.get());
        add(UDBlocks.CHROMITE_SLAB.get(), createSlabItemTable(UDBlocks.CHROMITE_SLAB.get()));
        dropSelf(UDBlocks.CHROMITE_WALL.get());
        dropSelf(UDBlocks.POLISHED_CHROMITE.get());
        dropSelf(UDBlocks.POLISHED_CHROMITE_STAIRS.get());
        add(UDBlocks.POLISHED_CHROMITE_SLAB.get(), createSlabItemTable(UDBlocks.POLISHED_CHROMITE_SLAB.get()));
        dropSelf(UDBlocks.WASHING_MACHINE.get());
        dropSelf(UDBlocks.DRYER.get());
        dropSelf(UDBlocks.TOASTER.get());
        dropSelf(UDBlocks.AIR_CONDITIONER.get());
        dropSelf(UDBlocks.DESK_FAN.get());
        dropOther(UDBlocks.TOOLBOX.get(), UDItems.TOOLBOX.get());
        dropSelf(UDBlocks.FAUCET.get());
        dropSelf(UDBlocks.CHECKERED_PORCELAIN_TILES.get());
        dropSelf(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get());
        add(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get(), createSlabItemTable(UDBlocks.PORCELAIN_TILE_SLAB.get()));
        dropSelf(UDBlocks.STAINLESS_STEEL_BLOCK.get());
        dropSelf(UDBlocks.OVEN.get());
        dropSelf(UDBlocks.RADIATOR.get());
        dropSelf(UDBlocks.STOVE.get());
        dropSelf(UDBlocks.FRIDGE.get());
        dropSelf(UDBlocks.FREEZER.get());
        dropSelf(UDBlocks.TURBINE.get());
        dropSelf(UDBlocks.TOILET.get());
        dropSelf(UDBlocks.DARK_TOILET.get());
        dropSelf(UDBlocks.DARK_FRIDGE.get());
        dropSelf(UDBlocks.DARK_FREEZER.get());
        dropSelf(UDBlocks.DARK_OVEN.get());
        dropSelf(UDBlocks.DARK_WASHING_MACHINE.get());
        dropSelf(UDBlocks.DARK_DRYER.get());
        dropSelf(UDBlocks.DARK_SINK.get());
        addDyedTowelsDrops();
        dropSelf(UDBlocks.TOWEL_BAR.get());
        dropSelf(UDBlocks.SHOWER.get());
        add(UDBlocks.BATHTUB.get(), longBlockDrops(UDBlocks.BATHTUB.get()));
        add(UDBlocks.DARK_BATHTUB.get(), longBlockDrops(UDBlocks.DARK_BATHTUB.get()));
        addDyedTowelBlockDrops();
        dropSelf(UDBlocks.RIGID_GLASS.get());
        dropSelf(UDBlocks.PORCELAIN_BLOCK.get());
        dropSelf(UDBlocks.PORCELAIN_STAIRS.get());
        add(UDBlocks.PORCELAIN_SLAB.get(), createSlabItemTable(UDBlocks.PORCELAIN_SLAB.get()));
        dropSelf(UDBlocks.DARK_PORCELAIN_BLOCK.get());
        dropSelf(UDBlocks.DARK_PORCELAIN_STAIRS.get());
        add(UDBlocks.DARK_PORCELAIN_SLAB.get(), createSlabItemTable(UDBlocks.DARK_PORCELAIN_SLAB.get()));
        addDyedPictureFrameDrops();
        dropSelf(UDBlocks.PICTURE_FRAME.get());
        dropSelf(UDBlocks.CUPBOARD.get());
        dropSelf(UDBlocks.DARK_CUPBOARD.get());
        dropSelf(UDBlocks.FILING_CABINET.get());
        dropSelf(UDBlocks.TOILET_PAPER.get());
        dropOther(UDBlocks.SATELLITE_DISH.get(), UDItems.SATELLITE_DISH.get());
        dropOther(UDBlocks.WALL_SATELLITE_DISH.get(), UDItems.SATELLITE_DISH.get());
        addDyedWallPictureFrameDrops();
        dropSelf(UDBlocks.PORCELAIN_BRICKS.get());
        dropSelf(UDBlocks.PORCELAIN_BRICK_STAIRS.get());
        add(UDBlocks.PORCELAIN_BRICK_SLAB.get(), createSlabItemTable(UDBlocks.PORCELAIN_BRICK_SLAB.get()));
        dropSelf(UDBlocks.DARK_PORCELAIN_BRICKS.get());
        dropSelf(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get());
        add(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get(), createSlabItemTable(UDBlocks.PORCELAIN_BRICK_SLAB.get()));
        dropOther(UDBlocks.STEEL_PIPE.get(), UDItems.STEEL_PIPE.get());
        add(UDBlocks.STAINLESS_STEEL_DOOR.get(), createDoorTable(UDBlocks.STAINLESS_STEEL_DOOR.get()));
        dropSelf(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get());
        dropSelf(UDBlocks.STAINLESS_STEEL_LANTERN.get());
        dropSelf(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get());
        dropSelf(UDBlocks.STAINLESS_STEEL_BARS.get());
        addTowelBarTowelDrops();
        add(UDBlocks.FLOOR_LAMP.get(), floorLampDrops(UDBlocks.FLOOR_LAMP.get()));
        dropSelf(UDBlocks.WALL_PICTURE_FRAME.get());
        add(UDBlocks.OAK_PIANO.get(), longBlockDrops(UDBlocks.OAK_PIANO.get()));
        add(UDBlocks.SPRUCE_PIANO.get(), longBlockDrops(UDBlocks.SPRUCE_PIANO.get()));
        add(UDBlocks.BIRCH_PIANO.get(), longBlockDrops(UDBlocks.BIRCH_PIANO.get()));
        add(UDBlocks.JUNGLE_PIANO.get(), longBlockDrops(UDBlocks.JUNGLE_PIANO.get()));
        add(UDBlocks.ACACIA_PIANO.get(), longBlockDrops(UDBlocks.ACACIA_PIANO.get()));
        add(UDBlocks.DARK_OAK_PIANO.get(), longBlockDrops(UDBlocks.DARK_OAK_PIANO.get()));
        add(UDBlocks.MANGROVE_PIANO.get(), longBlockDrops(UDBlocks.MANGROVE_PIANO.get()));
        add(UDBlocks.CHERRY_PIANO.get(), longBlockDrops(UDBlocks.CHERRY_PIANO.get()));
        add(UDBlocks.BAMBOO_PIANO.get(), longBlockDrops(UDBlocks.BAMBOO_PIANO.get()));
        add(UDBlocks.CRIMSON_PIANO.get(), longBlockDrops(UDBlocks.CRIMSON_PIANO.get()));
        add(UDBlocks.WARPED_PIANO.get(), longBlockDrops(UDBlocks.WARPED_PIANO.get()));
        dropSelf(UDBlocks.DISHWASHER.get());
        dropSelf(UDBlocks.DARK_DISHWASHER.get());
    }

    public LootTable.Builder floorLampDrops(Block block) {
        return this.createSinglePropConditionTable(block, FloorLampBlock.HALF, DoubleBlockHalf.LOWER);
    }

    private void addDyedTowelBlockDrops() {
        for (DyeColor colors : DyeColor.values()) {
            dropSelf(UDBlocks.getDyedTowelBlocks(colors.getId()).get());
        }
    }

    private void addDyedTowelsDrops() {
        for (DyeColor colors : DyeColor.values()) {
            dropSelf(UDBlocks.getDyedTowels(colors.getId()).get());
        }
    }

    private void addTowelBarTowelDrops() {
        for (DyeColor colors : DyeColor.values()) {
            dropOther(UDBlocks.getDyedTowelBarTowels(colors.getId()).get(), UDBlocks.getDyedTowels(colors.getId()).get());
            dropSelf(UDBlocks.TOWEL_BAR.get());
        }
    }

    private void addDyedPictureFrameDrops() {
        for (DyeColor colors : DyeColor.values()) {
            dropOther(UDBlocks.getDyedPictureBlocks(colors.getId()).get(), UDItems.getDyedPictureFrames(colors.getId()).get());
        }
    }

    private void addDyedWallPictureFrameDrops() {
        for (DyeColor colors : DyeColor.values()) {
            dropOther(UDBlocks.getDyedWallPictureBlocks(colors.getId()).get(), UDItems.getDyedPictureFrames(colors.getId()).get());
        }
    }

    public LootTable.Builder longBlockDrops(Block block) {
        return this.createSinglePropConditionTable(block, AbstractLongBlock.PART, BedPart.HEAD);
    }
}
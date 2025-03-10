package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.enums.BedPart;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.loot.LootTable;
import net.minecraft.util.DyeColor;
import net.yirmiri.urban_decor.block.FloorLampBlock;
import net.yirmiri.urban_decor.block.abstracts.AbstractLongBlock;
import net.yirmiri.urban_decor.registry.UDBlocks;
import net.yirmiri.urban_decor.registry.UDItems;

public class UDLootTableProvider extends FabricBlockLootTableProvider {
    public UDLootTableProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        addDrop(UDBlocks.PORCELAIN_TILES.get());
        addDrop(UDBlocks.PORCELAIN_TILE_STAIRS.get());
        addDrop(UDBlocks.PORCELAIN_TILE_SLAB.get(), slabDrops(UDBlocks.PORCELAIN_TILE_SLAB.get()));
        addDrop(UDBlocks.DARK_PORCELAIN_TILES.get());
        addDrop(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get());
        addDrop(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get(), slabDrops(UDBlocks.PORCELAIN_TILE_SLAB.get()));
        addDrop(UDBlocks.TRASH_CAN.get());
        addDrop(UDBlocks.MICROWAVE.get(), UDItems.MICROWAVE.get());
        addDrop(UDBlocks.WALL_MICROWAVE.get(), UDItems.MICROWAVE.get());
        addDrop(UDBlocks.SINK.get());
        addDrop(UDBlocks.CHROMITE.get());
        addDrop(UDBlocks.CHROMITE_STAIRS.get());
        addDrop(UDBlocks.CHROMITE_SLAB.get(), slabDrops(UDBlocks.CHROMITE_SLAB.get()));
        addDrop(UDBlocks.CHROMITE_WALL.get());
        addDrop(UDBlocks.POLISHED_CHROMITE.get());
        addDrop(UDBlocks.POLISHED_CHROMITE_STAIRS.get());
        addDrop(UDBlocks.POLISHED_CHROMITE_SLAB.get(), slabDrops(UDBlocks.POLISHED_CHROMITE_SLAB.get()));
        addDrop(UDBlocks.WASHING_MACHINE.get());
        addDrop(UDBlocks.DRYER.get());
        addDrop(UDBlocks.TOASTER.get());
        addDrop(UDBlocks.AIR_CONDITIONER.get());
        addDrop(UDBlocks.DESK_FAN.get());
        addDrop(UDBlocks.TOOLBOX.get(), UDItems.TOOLBOX.get());
        addDrop(UDBlocks.FAUCET.get());
        addDrop(UDBlocks.CHECKERED_PORCELAIN_TILES.get());
        addDrop(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get());
        addDrop(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get(), slabDrops(UDBlocks.PORCELAIN_TILE_SLAB.get()));
        addDrop(UDBlocks.STAINLESS_STEEL_BLOCK.get());
        addDrop(UDBlocks.OVEN.get());
        addDrop(UDBlocks.RADIATOR.get());
        addDrop(UDBlocks.STOVE.get());
        addDrop(UDBlocks.FRIDGE.get());
        addDrop(UDBlocks.FREEZER.get());
        addDrop(UDBlocks.TURBINE.get());
        addDrop(UDBlocks.TOILET.get());
        addDrop(UDBlocks.DARK_TOILET.get());
        addDrop(UDBlocks.DARK_FRIDGE.get());
        addDrop(UDBlocks.DARK_FREEZER.get());
        addDrop(UDBlocks.DARK_OVEN.get());
        addDrop(UDBlocks.DARK_WASHING_MACHINE.get());
        addDrop(UDBlocks.DARK_DRYER.get());
        addDrop(UDBlocks.DARK_SINK.get());
        addDyedTowelsDrops();
        addDrop(UDBlocks.TOWEL_BAR.get());
        addDrop(UDBlocks.SHOWER.get());
        addDrop(UDBlocks.BATHTUB.get(), longBlockDrops(UDBlocks.BATHTUB.get()));
        addDrop(UDBlocks.DARK_BATHTUB.get(), longBlockDrops(UDBlocks.DARK_BATHTUB.get()));
        addDyedTowelBlockDrops();
        addDrop(UDBlocks.RIGID_GLASS.get());
        addDrop(UDBlocks.PORCELAIN_BLOCK.get());
        addDrop(UDBlocks.PORCELAIN_STAIRS.get());
        addDrop(UDBlocks.PORCELAIN_SLAB.get(), slabDrops(UDBlocks.PORCELAIN_SLAB.get()));
        addDrop(UDBlocks.DARK_PORCELAIN_BLOCK.get());
        addDrop(UDBlocks.DARK_PORCELAIN_STAIRS.get());
        addDrop(UDBlocks.DARK_PORCELAIN_SLAB.get(), slabDrops(UDBlocks.DARK_PORCELAIN_SLAB.get()));
        addDyedPictureFrameDrops();
        addDrop(UDBlocks.PICTURE_FRAME.get());
        addDrop(UDBlocks.CUPBOARD.get());
        addDrop(UDBlocks.DARK_CUPBOARD.get());
        addDrop(UDBlocks.FILING_CABINET.get());
        addDrop(UDBlocks.TOILET_PAPER.get());
        addDrop(UDBlocks.SATELLITE_DISH.get(), UDItems.SATELLITE_DISH.get());
        addDrop(UDBlocks.WALL_SATELLITE_DISH.get(), UDItems.SATELLITE_DISH.get());
        addDyedWallPictureFrameDrops();
        addDrop(UDBlocks.PORCELAIN_BRICKS.get());
        addDrop(UDBlocks.PORCELAIN_BRICK_STAIRS.get());
        addDrop(UDBlocks.PORCELAIN_BRICK_SLAB.get(), slabDrops(UDBlocks.PORCELAIN_BRICK_SLAB.get()));
        addDrop(UDBlocks.DARK_PORCELAIN_BRICKS.get());
        addDrop(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get());
        addDrop(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get(), slabDrops(UDBlocks.PORCELAIN_BRICK_SLAB.get()));
        addDrop(UDBlocks.STEEL_PIPE.get(), UDItems.STEEL_PIPE.get());
        addDrop(UDBlocks.STAINLESS_STEEL_DOOR.get(), doorDrops(UDBlocks.STAINLESS_STEEL_DOOR.get()));
        addDrop(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get());
        addDrop(UDBlocks.STAINLESS_STEEL_LANTERN.get());
        addDrop(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get());
        addDrop(UDBlocks.STAINLESS_STEEL_BARS.get());
        addTowelBarTowelDrops();
        addDrop(UDBlocks.FLOOR_LAMP.get(), floorLampDrops(UDBlocks.FLOOR_LAMP.get()));
        addDrop(UDBlocks.WALL_PICTURE_FRAME.get());
        addDrop(UDBlocks.OAK_PIANO.get(), longBlockDrops(UDBlocks.OAK_PIANO.get()));
        addDrop(UDBlocks.SPRUCE_PIANO.get(), longBlockDrops(UDBlocks.SPRUCE_PIANO.get()));
        addDrop(UDBlocks.BIRCH_PIANO.get(), longBlockDrops(UDBlocks.BIRCH_PIANO.get()));
        addDrop(UDBlocks.JUNGLE_PIANO.get(), longBlockDrops(UDBlocks.JUNGLE_PIANO.get()));
        addDrop(UDBlocks.ACACIA_PIANO.get(), longBlockDrops(UDBlocks.ACACIA_PIANO.get()));
        addDrop(UDBlocks.DARK_OAK_PIANO.get(), longBlockDrops(UDBlocks.DARK_OAK_PIANO.get()));
        addDrop(UDBlocks.MANGROVE_PIANO.get(), longBlockDrops(UDBlocks.MANGROVE_PIANO.get()));
        addDrop(UDBlocks.CHERRY_PIANO.get(), longBlockDrops(UDBlocks.CHERRY_PIANO.get()));
        addDrop(UDBlocks.BAMBOO_PIANO.get(), longBlockDrops(UDBlocks.BAMBOO_PIANO.get()));
        addDrop(UDBlocks.CRIMSON_PIANO.get(), longBlockDrops(UDBlocks.CRIMSON_PIANO.get()));
        addDrop(UDBlocks.WARPED_PIANO.get(), longBlockDrops(UDBlocks.WARPED_PIANO.get()));
    }

    public LootTable.Builder floorLampDrops(Block block) {
        return this.dropsWithProperty(block, FloorLampBlock.HALF, DoubleBlockHalf.LOWER);
    }

    private void addDyedTowelBlockDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedTowelBlocks(colors.getId()).get());
        }
    }

    private void addDyedTowelsDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedTowels(colors.getId()).get());
        }
    }

    private void addTowelBarTowelDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedTowelBarTowels(colors.getId()).get(), UDBlocks.getDyedTowels(colors.getId()).get());
            addDrop(UDBlocks.TOWEL_BAR.get());
        }
    }

    private void addDyedPictureFrameDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedPictureBlocks(colors.getId()).get(), UDItems.getDyedPictureFrames(colors.getId()).get());
        }
    }

    private void addDyedWallPictureFrameDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedWallPictureBlocks(colors.getId()).get(), UDItems.getDyedPictureFrames(colors.getId()).get());
        }
    }

    public LootTable.Builder longBlockDrops(Block block) {
        return this.dropsWithProperty(block, AbstractLongBlock.PART, BedPart.HEAD);
    }
}
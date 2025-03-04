package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.BedPart;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
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
        addDrop(UDBlocks.PORCELAIN_TILES);
        addDrop(UDBlocks.PORCELAIN_TILE_STAIRS);
        addDrop(UDBlocks.PORCELAIN_TILE_SLAB, slabDrops(UDBlocks.PORCELAIN_TILE_SLAB));
        addDrop(UDBlocks.DARK_PORCELAIN_TILES);
        addDrop(UDBlocks.DARK_PORCELAIN_TILE_STAIRS);
        addDrop(UDBlocks.DARK_PORCELAIN_TILE_SLAB, slabDrops(UDBlocks.PORCELAIN_TILE_SLAB));
        addDrop(UDBlocks.TRASH_CAN);
        addDrop(UDBlocks.MICROWAVE, UDItems.MICROWAVE);
        addDrop(UDBlocks.WALL_MICROWAVE, UDItems.MICROWAVE);
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
        addDrop(UDBlocks.TOILET_PAPER);
        addDrop(UDBlocks.SATELLITE_DISH, UDItems.SATELLITE_DISH);
        addDrop(UDBlocks.WALL_SATELLITE_DISH, UDItems.SATELLITE_DISH);
        addDyedWallPictureFrameDrops();
        addDrop(UDBlocks.PORCELAIN_BRICKS);
        addDrop(UDBlocks.PORCELAIN_BRICK_STAIRS);
        addDrop(UDBlocks.PORCELAIN_BRICK_SLAB, slabDrops(UDBlocks.PORCELAIN_BRICK_SLAB));
        addDrop(UDBlocks.DARK_PORCELAIN_BRICKS);
        addDrop(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS);
        addDrop(UDBlocks.DARK_PORCELAIN_BRICK_SLAB, slabDrops(UDBlocks.PORCELAIN_BRICK_SLAB));
        addDrop(UDBlocks.STEEL_PIPE, UDItems.STEEL_PIPE);
        addDrop(UDBlocks.STAINLESS_STEEL_DOOR, doorDrops(UDBlocks.STAINLESS_STEEL_DOOR));
        addDrop(UDBlocks.STAINLESS_STEEL_TRAPDOOR);
        addDrop(UDBlocks.STAINLESS_STEEL_LANTERN);
        addDrop(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN);
        addDrop(UDBlocks.STAINLESS_STEEL_BARS);
        addTowelBarTowelDrops();
        addDrop(UDBlocks.FLOOR_LAMP, floorLampDrops(UDBlocks.FLOOR_LAMP));
        addDrop(UDBlocks.WALL_PICTURE_FRAME);
        addDrop(UDBlocks.OAK_PIANO, longBlockDrops(UDBlocks.OAK_PIANO));
        addDrop(UDBlocks.SPRUCE_PIANO, longBlockDrops(UDBlocks.SPRUCE_PIANO));
        addDrop(UDBlocks.BIRCH_PIANO, longBlockDrops(UDBlocks.BIRCH_PIANO));
        addDrop(UDBlocks.JUNGLE_PIANO, longBlockDrops(UDBlocks.JUNGLE_PIANO));
        addDrop(UDBlocks.ACACIA_PIANO, longBlockDrops(UDBlocks.ACACIA_PIANO));
        addDrop(UDBlocks.DARK_OAK_PIANO, longBlockDrops(UDBlocks.DARK_OAK_PIANO));
        addDrop(UDBlocks.MANGROVE_PIANO, longBlockDrops(UDBlocks.MANGROVE_PIANO));
        addDrop(UDBlocks.CHERRY_PIANO, longBlockDrops(UDBlocks.CHERRY_PIANO));
        addDrop(UDBlocks.BAMBOO_PIANO, longBlockDrops(UDBlocks.BAMBOO_PIANO));
        addDrop(UDBlocks.CRIMSON_PIANO, longBlockDrops(UDBlocks.CRIMSON_PIANO));
        addDrop(UDBlocks.WARPED_PIANO, longBlockDrops(UDBlocks.WARPED_PIANO));
    }

    public LootTable.Builder floorLampDrops(Block block) {
        return this.dropsWithProperty(block, FloorLampBlock.HALF, DoubleBlockHalf.LOWER);
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
            addDrop(UDBlocks.getDyedTowelBarTowels(colors.getId()), UDBlocks.getDyedTowels(colors.getId()));
            addDrop(UDBlocks.TOWEL_BAR);
        }
    }

    private void addDyedPictureFrameDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedPictureBlocks(colors.getId()), UDItems.getDyedPictureFrames(colors.getId()));
        }
    }

    private void addDyedWallPictureFrameDrops() {
        for (DyeColor colors : DyeColor.values()) {
            addDrop(UDBlocks.getDyedWallPictureBlocks(colors.getId()), UDItems.getDyedPictureFrames(colors.getId()));
        }
    }

    public LootTable.Builder longBlockDrops(Block block) {
        return this.dropsWithProperty(block, AbstractLongBlock.PART, BedPart.HEAD);
    }
}
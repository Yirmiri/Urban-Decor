package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.*;
import net.minecraft.block.enums.BedPart;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.DyeColor;
import net.yirmiri.urban_decor.block.AbstractLongBlock;
import net.yirmiri.urban_decor.block.TowelBarTowelBlock;
import net.yirmiri.urban_decor.registry.RegisterBlocks;
import net.yirmiri.urban_decor.registry.RegisterItems;

import java.util.concurrent.CompletableFuture;

public class UDLootTableProvider extends FabricBlockLootTableProvider {
    public UDLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
        super(output, lookup);
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
        addDrop(RegisterBlocks.SATELLITE_DISH);
        addDrop(RegisterBlocks.SHOWER);
        addDrop(RegisterBlocks.BATHTUB, longBlockDrops(RegisterBlocks.BATHTUB));
        addDrop(RegisterBlocks.DARK_BATHTUB, longBlockDrops(RegisterBlocks.DARK_BATHTUB));
        addDyedTowelBlockDrops();
        addDrop(RegisterBlocks.RIGID_GLASS);
        //addDyedTowelBarTowelDrops();
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

//    private void addDyedTowelBarTowelDrops() {
//        for (DyeColor colors : DyeColor.values()) {
//            addTowelBarTowelDrops(RegisterBlocks.getDyedTowels(colors.getId()));
//        }
//    }

//    public void addTowelBarTowelDrops(Block block) {
//        addDrop(block, (towelBar) -> towelBarTowelDrops(((TowelBarTowelBlock)towelBar).getContent()));
//    }

    public final LootTable.Builder towelBarTowelDrops(ItemConvertible drop) {
        return LootTable.builder().pool(addSurvivesExplosionCondition(RegisterBlocks.TOWEL_BAR, LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                .with(ItemEntry.builder(RegisterBlocks.TOWEL_BAR)))).pool(addSurvivesExplosionCondition(drop, LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(drop))));
    }

    public LootTable.Builder longBlockDrops(Block block) {
        return dropsWithProperty(block, AbstractLongBlock.PART, BedPart.HEAD);
    }
}
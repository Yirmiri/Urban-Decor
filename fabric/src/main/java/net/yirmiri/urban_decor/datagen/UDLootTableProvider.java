package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.yirmiri.urban_decor.common.block.appliances.FloorLampBlock;
import net.yirmiri.urban_decor.common.block.abstracts.AbstractLongBlock;
import net.yirmiri.urban_decor.common.util.WrapColor;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDItems;

import java.util.concurrent.CompletableFuture;

public class UDLootTableProvider extends FabricBlockLootTableProvider {
    public UDLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(UDBlocks.STAPLER.get());
        dropSelf(UDBlocks.FOLDABLE_SIGN.get());
        dropSelf(UDBlocks.MATTRESS.get());
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
        dropSelf(UDBlocks.TOWEL_BAR.get());
        dropSelf(UDBlocks.SHOWER.get());
        add(UDBlocks.BATHTUB.get(), longBlockDrops(UDBlocks.BATHTUB.get()));
        add(UDBlocks.DARK_BATHTUB.get(), longBlockDrops(UDBlocks.DARK_BATHTUB.get()));
        dropSelf(UDBlocks.RIGID_GLASS.get());
        dropSelf(UDBlocks.PORCELAIN_BLOCK.get());
        dropSelf(UDBlocks.PORCELAIN_STAIRS.get());
        add(UDBlocks.PORCELAIN_SLAB.get(), createSlabItemTable(UDBlocks.PORCELAIN_SLAB.get()));
        dropSelf(UDBlocks.DARK_PORCELAIN_BLOCK.get());
        dropSelf(UDBlocks.DARK_PORCELAIN_STAIRS.get());
        add(UDBlocks.DARK_PORCELAIN_SLAB.get(), createSlabItemTable(UDBlocks.DARK_PORCELAIN_SLAB.get()));
        dropSelf(UDBlocks.PICTURE_FRAME.get());
        dropSelf(UDBlocks.CUPBOARD.get());
        dropSelf(UDBlocks.DARK_CUPBOARD.get());
        dropSelf(UDBlocks.FILING_CABINET.get());
        dropSelf(UDBlocks.TOILET_PAPER.get());
        dropOther(UDBlocks.SATELLITE_DISH.get(), UDItems.SATELLITE_DISH.get());
        dropOther(UDBlocks.WALL_SATELLITE_DISH.get(), UDItems.SATELLITE_DISH.get());
        dropSelf(UDBlocks.PORCELAIN_BRICKS.get());
        dropSelf(UDBlocks.PORCELAIN_BRICK_STAIRS.get());
        add(UDBlocks.PORCELAIN_BRICK_SLAB.get(), createSlabItemTable(UDBlocks.PORCELAIN_BRICK_SLAB.get()));
        dropSelf(UDBlocks.DARK_PORCELAIN_BRICKS.get());
        dropSelf(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get());
        add(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get(), createSlabItemTable(UDBlocks.PORCELAIN_BRICK_SLAB.get()));
        add(UDBlocks.STAINLESS_STEEL_DOOR.get(), createDoorTable(UDBlocks.STAINLESS_STEEL_DOOR.get()));
        dropSelf(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get());
        dropSelf(UDBlocks.STAINLESS_STEEL_LANTERN.get());
        dropSelf(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get());
        dropSelf(UDBlocks.STAINLESS_STEEL_BARS.get());
        dropSelf(UDBlocks.STAINLESS_STEEL_FENCE.get());
        add(UDBlocks.FLOOR_LAMP.get(), tallDrops(UDBlocks.FLOOR_LAMP.get()));
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
        dropSelf(UDBlocks.PLASTIC_CHAIR.get());
        dropSelf(UDBlocks.OAK_CALENDAR.get());
        dropSelf(UDBlocks.SPRUCE_CALENDAR.get());
        dropSelf(UDBlocks.BIRCH_CALENDAR.get());
        dropSelf(UDBlocks.JUNGLE_CALENDAR.get());
        dropSelf(UDBlocks.ACACIA_CALENDAR.get());
        dropSelf(UDBlocks.DARK_OAK_CALENDAR.get());
        dropSelf(UDBlocks.MANGROVE_CALENDAR.get());
        dropSelf(UDBlocks.CHERRY_CALENDAR.get());
        dropSelf(UDBlocks.BAMBOO_CALENDAR.get());
        dropSelf(UDBlocks.CRIMSON_CALENDAR.get());
        dropSelf(UDBlocks.WARPED_CALENDAR.get());
        dropSelf(UDBlocks.STAINLESS_STEEL_LADDER.get());
        add(UDBlocks.OAK_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.OAK_GRANDFATHER_CLOCK.get()));
        add(UDBlocks.SPRUCE_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.SPRUCE_GRANDFATHER_CLOCK.get()));
        add(UDBlocks.BIRCH_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.BIRCH_GRANDFATHER_CLOCK.get()));
        add(UDBlocks.JUNGLE_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.JUNGLE_GRANDFATHER_CLOCK.get()));
        add(UDBlocks.ACACIA_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.ACACIA_GRANDFATHER_CLOCK.get()));
        add(UDBlocks.DARK_OAK_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.DARK_OAK_GRANDFATHER_CLOCK.get()));
        add(UDBlocks.MANGROVE_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.MANGROVE_GRANDFATHER_CLOCK.get()));
        add(UDBlocks.CHERRY_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.CHERRY_GRANDFATHER_CLOCK.get()));
        add(UDBlocks.BAMBOO_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.BAMBOO_GRANDFATHER_CLOCK.get()));
        add(UDBlocks.CRIMSON_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.CRIMSON_GRANDFATHER_CLOCK.get()));
        add(UDBlocks.WARPED_GRANDFATHER_CLOCK.get(), createDoorTable(UDBlocks.WARPED_GRANDFATHER_CLOCK.get()));
        dropSelf(UDBlocks.WALL_CLOCK.get());
        dropSelf(UDBlocks.OAK_BOX.get());
        dropSelf(UDBlocks.SPRUCE_BOX.get());
        dropSelf(UDBlocks.BIRCH_BOX.get());
        dropSelf(UDBlocks.JUNGLE_BOX.get());
        dropSelf(UDBlocks.ACACIA_BOX.get());
        dropSelf(UDBlocks.DARK_OAK_BOX.get());
        dropSelf(UDBlocks.MANGROVE_BOX.get());
        dropSelf(UDBlocks.CHERRY_BOX.get());
        dropSelf(UDBlocks.BAMBOO_BOX.get());
        dropSelf(UDBlocks.CRIMSON_BOX.get());
        dropSelf(UDBlocks.WARPED_BOX.get());
        dropSelf(UDBlocks.PORCELAIN_TABLE.get());
        dropSelf(UDBlocks.STAINLESS_STEEL_CHAIR.get());
        add(UDBlocks.PLASTIC_LIGHTS.get(), this::createCoolerMultifaceDrops);
        dropSelf(UDBlocks.CASH_REGISTER.get());
        dropSelf(UDBlocks.DARK_CASH_REGISTER.get());
        add(UDBlocks.VENDING_MACHINE.get(), tallDrops(UDBlocks.VENDING_MACHINE.get()));
        dropSelf(UDBlocks.SPEAKER.get());
        add(UDBlocks.STAINLESS_STEEL_DEPOSIT.get(), builder -> createSilkTouchDispatchTable(builder, applyExplosionDecay(builder,
                LootItem.lootTableItem(UDItems.STAINLESS_STEEL_NUGGET.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F))))));
        dropSelf(UDBlocks.DOLL.get());
        dropSelf(UDBlocks.SEWING_MACHINE.get());

        addDyedDrops();
        addWrappedDrops();
    }

    public LootTable.Builder tallDrops(Block block) {
        return this.createSinglePropConditionTable(block, FloorLampBlock.HALF, DoubleBlockHalf.LOWER);
    }

    private void addWrappedDrops() {
        for (WrapColor colors : WrapColor.values()) {
            add(UDBlocks.getWrappedPolyanthous(colors.getId()).get(), (b) -> createSinglePropConditionTable(b, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(UDBlocks.getWrappedMattresses(colors.getId()).get());

            dropSelf(UDBlocks.getWrappedPorcelainBlocks(colors.getId()).get());
            dropSelf(UDBlocks.getWrappedPorcelainStairs(colors.getId()).get());
            add(UDBlocks.getWrappedPorcelainSlabs(colors.getId()).get(), createSlabItemTable(UDBlocks.getWrappedPorcelainSlabs(colors.getId()).get()));

            dropSelf(UDBlocks.getWrappedPorcelainBricks(colors.getId()).get());
            dropSelf(UDBlocks.getWrappedPorcelainBrickStairs(colors.getId()).get());
            add(UDBlocks.getWrappedPorcelainBrickSlabs(colors.getId()).get(), createSlabItemTable(UDBlocks.getWrappedPorcelainBrickSlabs(colors.getId()).get()));

            dropSelf(UDBlocks.getWrappedPorcelainTiles(colors.getId()).get());
            dropSelf(UDBlocks.getWrappedPorcelainTileStairs(colors.getId()).get());
            add(UDBlocks.getWrappedPorcelainTileSlabs(colors.getId()).get(), createSlabItemTable(UDBlocks.getWrappedPorcelainTileSlabs(colors.getId()).get()));
        }
    }

    private void addDyedDrops() {
        for (DyeColor colors : DyeColor.values()) {
            dropSelf(UDBlocks.getDyedTowelBlocks(colors.getId()).get());
            dropSelf(UDBlocks.getDyedTowels(colors.getId()).get());
            dropOther(UDBlocks.getDyedTowelBarTowels(colors.getId()).get(), UDBlocks.getDyedTowels(colors.getId()).get());
            dropOther(UDBlocks.getDyedPictureBlocks(colors.getId()).get(), UDItems.getDyedPictureFrames(colors.getId()).get());
            dropOther(UDBlocks.getDyedWallPictureBlocks(colors.getId()).get(), UDItems.getDyedPictureFrames(colors.getId()).get());
            add(UDBlocks.getDyedPlasticLights(colors.getId()).get(), this::createCoolerMultifaceDrops);
        }
    }

    public LootTable.Builder longBlockDrops(Block block) {
        return this.createSinglePropConditionTable(block, AbstractLongBlock.PART, BedPart.HEAD);
    }

    public LootTable.Builder createCoolerMultifaceDrops(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add((LootPoolEntryContainer.Builder) this.applyExplosionDecay(block, ((LootPoolSingletonContainer.Builder)((LootPoolSingletonContainer.Builder) LootItem.lootTableItem(block)).apply(Direction.values(), (direction) -> SetItemCountFunction.setCount(ConstantValue.exactly(1.0F), true).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(MultifaceBlock.getFaceProperty((Direction) direction), true))))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(-1.0F), true)))));
    }
}
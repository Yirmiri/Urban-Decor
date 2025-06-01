package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDBlocks;

import java.util.concurrent.CompletableFuture;

public class UDBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public UDBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
        super(output, future);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(UDTags.BlockT.HAS_TOOLBOX_VARIANTS)
                .add(UDBlocks.TRASH_CAN.get())
                .add(UDBlocks.SINK.get())
                .add(UDBlocks.TOILET.get())
                .add(UDBlocks.WASHING_MACHINE.get())
                .add(UDBlocks.DRYER.get())
                .add(UDBlocks.OVEN.get())
                .add(UDBlocks.FRIDGE.get())
                .add(UDBlocks.FREEZER.get())
                .add(UDBlocks.DARK_DRYER.get())
                .add(UDBlocks.DARK_OVEN.get())
                .add(UDBlocks.DARK_SINK.get())
                .add(UDBlocks.DARK_FRIDGE.get())
                .add(UDBlocks.DARK_FREEZER.get())
                .add(UDBlocks.DARK_TOILET.get())
                .add(UDBlocks.DARK_WASHING_MACHINE.get())
                .add(UDBlocks.SHOWER.get())
                .add(UDBlocks.FAUCET.get())
                .add(UDBlocks.CUPBOARD.get())
                .add(UDBlocks.DARK_CUPBOARD.get())
                .add(UDBlocks.FILING_CABINET.get())
                .add(UDBlocks.RADIATOR.get())
                .add(UDBlocks.TOILET_PAPER.get())
                .add(UDBlocks.FLOOR_LAMP.get())
                .add(UDBlocks.TURBINE.get())
        ;
        
        getOrCreateTagBuilder(UDTags.BlockT.TOILETS)
                .add(UDBlocks.TOILET.get())
                .add(UDBlocks.DARK_TOILET.get())
        ;

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(UDBlocks.OAK_PIANO.get())
                .add(UDBlocks.SPRUCE_PIANO.get())
                .add(UDBlocks.BIRCH_PIANO.get())
                .add(UDBlocks.JUNGLE_PIANO.get())
                .add(UDBlocks.ACACIA_PIANO.get())
                .add(UDBlocks.DARK_OAK_PIANO.get())
                .add(UDBlocks.MANGROVE_PIANO.get())
                .add(UDBlocks.CHERRY_PIANO.get())
                .add(UDBlocks.BAMBOO_PIANO.get())
                .add(UDBlocks.CRIMSON_PIANO.get())
                .add(UDBlocks.WARPED_PIANO.get())
        ;

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(UDBlocks.DARK_PORCELAIN_BLOCK.get())
                .add(UDBlocks.DARK_PORCELAIN_STAIRS.get())
                .add(UDBlocks.DARK_PORCELAIN_SLAB.get())
                .add(UDBlocks.PORCELAIN_BLOCK.get())
                .add(UDBlocks.PORCELAIN_STAIRS.get())
                .add(UDBlocks.PORCELAIN_SLAB.get())
                .add(UDBlocks.PORCELAIN_TILES.get())
                .add(UDBlocks.PORCELAIN_TILE_STAIRS.get())
                .add(UDBlocks.PORCELAIN_TILE_SLAB.get())
                .add(UDBlocks.DARK_PORCELAIN_TILES.get())
                .add(UDBlocks.DARK_PORCELAIN_TILE_STAIRS.get())
                .add(UDBlocks.DARK_PORCELAIN_TILE_SLAB.get())
                .add(UDBlocks.CHECKERED_PORCELAIN_TILES.get())
                .add(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS.get())
                .add(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB.get())
                .add(UDBlocks.MICROWAVE.get())
                .add(UDBlocks.SINK.get())
                .add(UDBlocks.CHROMITE.get())
                .add(UDBlocks.CHROMITE_STAIRS.get())
                .add(UDBlocks.CHROMITE_SLAB.get())
                .add(UDBlocks.CHROMITE_WALL.get())
                .add(UDBlocks.POLISHED_CHROMITE.get())
                .add(UDBlocks.POLISHED_CHROMITE_STAIRS.get())
                .add(UDBlocks.POLISHED_CHROMITE_SLAB.get())
                .add(UDBlocks.TOILET.get())
                .add(UDBlocks.WASHING_MACHINE.get())
                .add(UDBlocks.DRYER.get())
                .add(UDBlocks.TOASTER.get())
                .add(UDBlocks.AIR_CONDITIONER.get())
                .add(UDBlocks.DESK_FAN.get())
                .add(UDBlocks.TOOLBOX.get())
                .add(UDBlocks.FAUCET.get())
                .add(UDBlocks.STAINLESS_STEEL_BLOCK.get())
                .add(UDBlocks.OVEN.get())
                .add(UDBlocks.RADIATOR.get())
                .add(UDBlocks.STOVE.get())
                .add(UDBlocks.FRIDGE.get())
                .add(UDBlocks.FREEZER.get())
                .add(UDBlocks.TURBINE.get())
                .add(UDBlocks.DARK_DRYER.get())
                .add(UDBlocks.DARK_FRIDGE.get())
                .add(UDBlocks.DARK_FREEZER.get())
                .add(UDBlocks.DARK_SINK.get())
                .add(UDBlocks.DARK_TOILET.get())
                .add(UDBlocks.DARK_WASHING_MACHINE.get())
                .add(UDBlocks.DARK_OVEN.get())
                .add(UDBlocks.TOWEL_BAR.get())
                .add(UDBlocks.SATELLITE_DISH.get())
                .add(UDBlocks.SHOWER.get())
                .add(UDBlocks.BATHTUB.get())
                .add(UDBlocks.DARK_BATHTUB.get())
                .add(UDBlocks.RIGID_GLASS.get())
                .add(UDBlocks.CUPBOARD.get())
                .add(UDBlocks.DARK_CUPBOARD.get())
                .add(UDBlocks.FILING_CABINET.get())
                .add(UDBlocks.WALL_MICROWAVE.get())
                .add(UDBlocks.WALL_SATELLITE_DISH.get())
                .add(UDBlocks.PORCELAIN_BRICKS.get())
                .add(UDBlocks.PORCELAIN_BRICK_STAIRS.get())
                .add(UDBlocks.PORCELAIN_BRICK_SLAB.get())
                .add(UDBlocks.DARK_PORCELAIN_BRICKS.get())
                .add(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS.get())
                .add(UDBlocks.DARK_PORCELAIN_BRICK_SLAB.get())
                .add(UDBlocks.STEEL_PIPE.get())
                .add(UDBlocks.STAINLESS_STEEL_DOOR.get())
                .add(UDBlocks.STAINLESS_STEEL_TRAPDOOR.get())
                .add(UDBlocks.STAINLESS_STEEL_LANTERN.get())
                .add(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN.get())
                .add(UDBlocks.STAINLESS_STEEL_BARS.get())
                .add(UDBlocks.FLOOR_LAMP.get())
                .add(UDBlocks.DISHWASHER.get())
                .add(UDBlocks.DARK_DISHWASHER.get())
        ;

        for (DyeColor colors : DyeColor.values()) {
            getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(UDBlocks.getDyedTowelBarTowels(colors.getId()).get());
        }

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(UDBlocks.CHROMITE_WALL.get())
        ;

        getOrCreateTagBuilder(BlockTags.CAMPFIRES)
                .add(UDBlocks.TOASTER.get())
        ;

        for (DyeColor colors : DyeColor.values()) {
            getOrCreateTagBuilder(BlockTags.WOOL).add(UDBlocks.getDyedTowelBlocks(colors.getId()).get());
        }
    }
}

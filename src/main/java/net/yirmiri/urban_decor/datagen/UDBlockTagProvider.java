package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.registry.UDBlocks;

import java.util.concurrent.CompletableFuture;

public class UDBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public static final TagKey<Block> TOILETS = create("toilets");

    public UDBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(TOILETS)
                .add(UDBlocks.TOILET)
                .add(UDBlocks.DARK_TOILET)
        ;

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(UDBlocks.DARK_PORCELAIN_BLOCK)
                .add(UDBlocks.DARK_PORCELAIN_STAIRS)
                .add(UDBlocks.DARK_PORCELAIN_SLAB)
                .add(UDBlocks.PORCELAIN_BLOCK)
                .add(UDBlocks.PORCELAIN_STAIRS)
                .add(UDBlocks.PORCELAIN_SLAB)
                .add(UDBlocks.PORCELAIN_TILES)
                .add(UDBlocks.PORCELAIN_TILE_STAIRS)
                .add(UDBlocks.PORCELAIN_TILE_SLAB)
                .add(UDBlocks.DARK_PORCELAIN_TILES)
                .add(UDBlocks.DARK_PORCELAIN_TILE_STAIRS)
                .add(UDBlocks.DARK_PORCELAIN_TILE_SLAB)
                .add(UDBlocks.CHECKERED_PORCELAIN_TILES)
                .add(UDBlocks.CHECKERED_PORCELAIN_TILE_STAIRS)
                .add(UDBlocks.CHECKERED_PORCELAIN_TILE_SLAB)
                .add(UDBlocks.MICROWAVE)
                .add(UDBlocks.SINK)
                .add(UDBlocks.CHROMITE)
                .add(UDBlocks.CHROMITE_STAIRS)
                .add(UDBlocks.CHROMITE_SLAB)
                .add(UDBlocks.CHROMITE_WALL)
                .add(UDBlocks.POLISHED_CHROMITE)
                .add(UDBlocks.POLISHED_CHROMITE_STAIRS)
                .add(UDBlocks.POLISHED_CHROMITE_SLAB)
                .add(UDBlocks.TOILET)
                .add(UDBlocks.WASHING_MACHINE)
                .add(UDBlocks.DRYER)
                .add(UDBlocks.TOASTER)
                .add(UDBlocks.AIR_CONDITIONER)
                .add(UDBlocks.DESK_FAN)
                .add(UDBlocks.TOOLBOX)
                .add(UDBlocks.FAUCET)
                .add(UDBlocks.STAINLESS_STEEL_BLOCK)
                .add(UDBlocks.OVEN)
                .add(UDBlocks.RADIATOR)
                .add(UDBlocks.STOVE)
                .add(UDBlocks.FRIDGE)
                .add(UDBlocks.FREEZER)
                .add(UDBlocks.TURBINE)
                .add(UDBlocks.DARK_DRYER)
                .add(UDBlocks.DARK_FRIDGE)
                .add(UDBlocks.DARK_FREEZER)
                .add(UDBlocks.DARK_SINK)
                .add(UDBlocks.DARK_TOILET)
                .add(UDBlocks.DARK_WASHING_MACHINE)
                .add(UDBlocks.DARK_OVEN)
                .add(UDBlocks.TOWEL_BAR)
                .add(UDBlocks.SATELLITE_DISH)
                .add(UDBlocks.SHOWER)
                .add(UDBlocks.BATHTUB)
                .add(UDBlocks.DARK_BATHTUB)
                .add(UDBlocks.RIGID_GLASS)
                .add(UDBlocks.CUPBOARD)
                .add(UDBlocks.DARK_CUPBOARD)
                .add(UDBlocks.FILING_CABINET)
                .add(UDBlocks.WALL_MICROWAVE)
                .add(UDBlocks.WALL_SATELLITE_DISH)
                .add(UDBlocks.PORCELAIN_BRICKS)
                .add(UDBlocks.PORCELAIN_BRICK_STAIRS)
                .add(UDBlocks.PORCELAIN_BRICK_SLAB)
                .add(UDBlocks.DARK_PORCELAIN_BRICKS)
                .add(UDBlocks.DARK_PORCELAIN_BRICK_STAIRS)
                .add(UDBlocks.DARK_PORCELAIN_BRICK_SLAB)
                .add(UDBlocks.STEEL_PIPE)
                .add(UDBlocks.STAINLESS_STEEL_DOOR)
                .add(UDBlocks.STAINLESS_STEEL_DOOR_LOCKED)
                .add(UDBlocks.STAINLESS_STEEL_TRAPDOOR)
                .add(UDBlocks.STAINLESS_STEEL_LANTERN)
                .add(UDBlocks.STAINLESS_STEEL_SOUL_LANTERN)
                .add(UDBlocks.STAINLESS_STEEL_BARS)
        ;

        for (DyeColor colors : DyeColor.values()) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(UDBlocks.getDyedTowelBarTowels(colors.getId()));
        }

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(UDBlocks.CHROMITE_WALL)
        ;

        getOrCreateTagBuilder(BlockTags.CAMPFIRES)
                .add(UDBlocks.TOASTER)
        ;

        for (DyeColor colors : DyeColor.values()) {
            getOrCreateTagBuilder(BlockTags.WOOL).add(UDBlocks.getDyedTowelBlocks(colors.getId()));
        }
    }

    private static TagKey<Block> create(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(UrbanDecor.MOD_ID, id));
    }
}

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
import net.yirmiri.urban_decor.registry.RegisterBlocks;

import java.util.concurrent.CompletableFuture;

public class UDBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public static final TagKey<Block> TOILETS = create("toilets");

    public UDBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(TOILETS)
                .add(RegisterBlocks.TOILET)
                .add(RegisterBlocks.DARK_TOILET)
        ;

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(RegisterBlocks.PORCELAIN_TILES)
                .add(RegisterBlocks.PORCELAIN_TILE_STAIRS)
                .add(RegisterBlocks.PORCELAIN_TILE_SLAB)
                .add(RegisterBlocks.MICROWAVE)
                .add(RegisterBlocks.SINK)
                .add(RegisterBlocks.CHROMITE)
                .add(RegisterBlocks.CHROMITE_STAIRS)
                .add(RegisterBlocks.CHROMITE_SLAB)
                .add(RegisterBlocks.CHROMITE_WALL)
                .add(RegisterBlocks.POLISHED_CHROMITE)
                .add(RegisterBlocks.POLISHED_CHROMITE_STAIRS)
                .add(RegisterBlocks.POLISHED_CHROMITE_SLAB)
                .add(RegisterBlocks.TOILET)
                .add(RegisterBlocks.WASHING_MACHINE)
                .add(RegisterBlocks.DRYER)
                .add(RegisterBlocks.TOASTER)
                .add(RegisterBlocks.AIR_CONDITIONER)
                .add(RegisterBlocks.DARK_PORCELAIN_TILES)
                .add(RegisterBlocks.DARK_PORCELAIN_TILE_STAIRS)
                .add(RegisterBlocks.DARK_PORCELAIN_TILE_SLAB)
                .add(RegisterBlocks.DESK_FAN)
                .add(RegisterBlocks.TOOLBOX)
                .add(RegisterBlocks.FAUCET)
                .add(RegisterBlocks.STAINLESS_STEEL_BLOCK)
                .add(RegisterBlocks.CHECKERED_PORCELAIN_TILES)
                .add(RegisterBlocks.CHECKERED_PORCELAIN_TILE_STAIRS)
                .add(RegisterBlocks.CHECKERED_PORCELAIN_TILE_SLAB)
                .add(RegisterBlocks.OVEN)
                .add(RegisterBlocks.RADIATOR)
                .add(RegisterBlocks.STOVE)
                .add(RegisterBlocks.FRIDGE)
                .add(RegisterBlocks.FREEZER)
                .add(RegisterBlocks.TURBINE)
                .add(RegisterBlocks.DARK_DRYER)
                .add(RegisterBlocks.DARK_FRIDGE)
                .add(RegisterBlocks.DARK_FREEZER)
                .add(RegisterBlocks.DARK_SINK)
                .add(RegisterBlocks.DARK_TOILET)
                .add(RegisterBlocks.DARK_WASHING_MACHINE)
                .add(RegisterBlocks.DARK_OVEN)
                .add(RegisterBlocks.TOWEL_BAR)
                .add(RegisterBlocks.SATELLITE_DISH)
                .add(RegisterBlocks.SHOWER)
                .add(RegisterBlocks.BATHTUB)
                .add(RegisterBlocks.DARK_BATHTUB)
                .add(RegisterBlocks.RIGID_GLASS)
        ;

        for (DyeColor colors : DyeColor.values()) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(RegisterBlocks.getDyedTowelBarTowels(colors.getId()));
        }

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(RegisterBlocks.CHROMITE_WALL)
        ;

        getOrCreateTagBuilder(BlockTags.CAMPFIRES)
                .add(RegisterBlocks.TOASTER)
        ;

        for (DyeColor colors : DyeColor.values()) {
            getOrCreateTagBuilder(BlockTags.WOOL).add(RegisterBlocks.getDyedTowelBlocks(colors.getId()));
        }
    }

    private static TagKey<Block> create(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(UrbanDecor.MOD_ID, id));
    }
}

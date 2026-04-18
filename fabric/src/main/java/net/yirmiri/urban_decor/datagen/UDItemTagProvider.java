package net.yirmiri.urban_decor.datagen;

import net.azurune.runiclib.RunicLib;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.yirmiri.urban_decor.common.util.WrapColor;
import net.yirmiri.urban_decor.core.init.UDTags;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDItems;

import java.util.concurrent.CompletableFuture;

public class UDItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public UDItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
        super(output, future);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(UDTags.ItemT.HAS_TOOLBOX_VARIANTS)
                .add(UDBlocks.TRASH_CAN.get().asItem())
                .add(UDBlocks.SINK.get().asItem())
                .add(UDBlocks.TOILET.get().asItem())
                .add(UDBlocks.WASHING_MACHINE.get().asItem())
                .add(UDBlocks.DRYER.get().asItem())
                .add(UDBlocks.OVEN.get().asItem())
                .add(UDBlocks.FRIDGE.get().asItem())
                .add(UDBlocks.FREEZER.get().asItem())
                .add(UDBlocks.DARK_DRYER.get().asItem())
                .add(UDBlocks.DARK_OVEN.get().asItem())
                .add(UDBlocks.DARK_SINK.get().asItem())
                .add(UDBlocks.DARK_FRIDGE.get().asItem())
                .add(UDBlocks.DARK_FREEZER.get().asItem())
                .add(UDBlocks.DARK_TOILET.get().asItem())
                .add(UDBlocks.DARK_WASHING_MACHINE.get().asItem())
                .add(UDBlocks.SHOWER.get().asItem())
                .add(UDBlocks.FAUCET.get().asItem())
                .add(UDBlocks.CUPBOARD.get().asItem())
                .add(UDBlocks.DARK_CUPBOARD.get().asItem())
                .add(UDBlocks.FILING_CABINET.get().asItem())
                .add(UDBlocks.RADIATOR.get().asItem())
                .add(UDBlocks.TOILET_PAPER.get().asItem())
                .add(UDBlocks.FLOOR_LAMP.get().asItem())
                .add(UDBlocks.TURBINE.get().asItem())
                .add(UDBlocks.PORCELAIN_TABLE.get().asItem())
                .add(UDBlocks.BOOTH.get().asItem())
                .add(UDBlocks.SPEAKER.get().asItem())
                .add(UDBlocks.DOLL.get().asItem())
        ;

        getOrCreateTagBuilder(UDTags.ItemT.HAS_WRAPPED_VARIANTS)
                .add(UDBlocks.BOOTH.get().asItem())
                .add(UDBlocks.OAK_BOX.get().asItem())
                .add(UDBlocks.SPRUCE_BOX.get().asItem())
                .add(UDBlocks.BIRCH_BOX.get().asItem())
                .add(UDBlocks.JUNGLE_BOX.get().asItem())
                .add(UDBlocks.ACACIA_BOX.get().asItem())
                .add(UDBlocks.DARK_OAK_BOX.get().asItem())
                .add(UDBlocks.MANGROVE_BOX.get().asItem())
                .add(UDBlocks.CHERRY_BOX.get().asItem())
                .add(UDBlocks.BAMBOO_BOX.get().asItem())
                .add(UDBlocks.CRIMSON_BOX.get().asItem())
                .add(UDBlocks.WARPED_BOX.get().asItem())
                .add(UDBlocks.PORCELAIN_TABLE.get().asItem())
                .add(UDBlocks.CASH_REGISTER.get().asItem())
                .add(UDBlocks.DARK_CASH_REGISTER.get().asItem())
                .add(UDBlocks.FRIDGE.get().asItem())
                .add(UDBlocks.DARK_FRIDGE.get().asItem())
                .add(UDBlocks.CUPBOARD.get().asItem())
                .add(UDBlocks.DARK_CUPBOARD.get().asItem())
                .add(UDBlocks.DISHWASHER.get().asItem())
                .add(UDBlocks.DARK_DISHWASHER.get().asItem())
                .add(UDBlocks.DRYER.get().asItem())
                .add(UDBlocks.DARK_DRYER.get().asItem())
                .add(UDBlocks.FREEZER.get().asItem())
                .add(UDBlocks.DARK_FREEZER.get().asItem())
                .add(UDBlocks.BATHTUB.get().asItem())
                .add(UDBlocks.DARK_BATHTUB.get().asItem())
                .add(UDBlocks.OVEN.get().asItem())
                .add(UDBlocks.DARK_OVEN.get().asItem())
                .add(UDBlocks.SINK.get().asItem())
                .add(UDBlocks.DARK_SINK.get().asItem())
                .add(UDBlocks.TOILET.get().asItem())
                .add(UDBlocks.DARK_TOILET.get().asItem())
                .add(UDBlocks.WASHING_MACHINE.get().asItem())
                .add(UDBlocks.DARK_WASHING_MACHINE.get().asItem())
        ;

        for (WrapColor colors : WrapColor.values()) {
            getOrCreateTagBuilder(UDTags.ItemT.POLYANTHOUS).add(UDBlocks.getWrappedPolyanthous(colors.getId()).get().asItem());
        }

        for (WrapColor colors : WrapColor.values()) {
            getOrCreateTagBuilder(UDTags.ItemT.WRAPS).add(UDItems.getWrappedWraps(colors.getId()).get());
        }

        getOrCreateTagBuilder(UDTags.ItemT.PORCELAIN)
                .add(UDItems.PORCELAIN.get())
                .add(UDItems.DARK_PORCELAIN.get())
        ;

        getOrCreateTagBuilder(ItemTags.TALL_FLOWERS)
                .addTag(UDTags.ItemT.POLYANTHOUS)
        ;

        getOrCreateTagBuilder(UDTags.ItemT.TOOLBOXES)
                .add(UDItems.TOOLBOX.get())
                .addOptional(RunicLib.customid("scprotect", "screwdriver"))
                .addOptional(RunicLib.customid("excessive_building", "mallet"))
        ;

        for (DyeColor colors : DyeColor.values()) {
            getOrCreateTagBuilder(UDTags.ItemT.TOWELS)
                    .add(UDBlocks.getDyedTowels(colors.getId()).get().asItem())
                    .addOptional(RunicLib.customid("excessive_building", "mallet"))
            ;
        }
    }
}

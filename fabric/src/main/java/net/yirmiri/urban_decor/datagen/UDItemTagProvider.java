package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.core.registry.UDBlocks;
import net.yirmiri.urban_decor.core.registry.UDItems;

import java.util.concurrent.CompletableFuture;

public class UDItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> FURNISHINGS = create("furnishings");
    public static final TagKey<Item> TOOLBOXES = create("toolboxes");
    public static final TagKey<Item> TOWELS = create("towels");
    public static final TagKey<Item> TOOLBOXABLE = create("toolboxable");
    public static final TagKey<Item> WRAPPABLE = create("wrappable");

    public UDItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
        super(output, future);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(FURNISHINGS)
                .add(UDBlocks.TRASH_CAN.get().asItem())
                .add(UDItems.MICROWAVE.get())
                .add(UDBlocks.SINK.get().asItem())
                .add(UDBlocks.TOILET.get().asItem())
                .add(UDBlocks.WASHING_MACHINE.get().asItem())
                .add(UDBlocks.DRYER.get().asItem())
                .add(UDBlocks.TOASTER.get().asItem())
                .add(UDBlocks.DESK_FAN.get().asItem())
                .add(UDBlocks.OVEN.get().asItem())
                .add(UDBlocks.STOVE.get().asItem())
                .add(UDBlocks.FRIDGE.get().asItem())
                .add(UDBlocks.FREEZER.get().asItem())
                .add(UDBlocks.DARK_DRYER.get().asItem())
                .add(UDBlocks.DARK_OVEN.get().asItem())
                .add(UDBlocks.DARK_SINK.get().asItem())
                .add(UDBlocks.DARK_FRIDGE.get().asItem())
                .add(UDBlocks.DARK_FREEZER.get().asItem())
                .add(UDBlocks.DARK_TOILET.get().asItem())
                .add(UDBlocks.DARK_WASHING_MACHINE.get().asItem())
                .add(UDBlocks.BATHTUB.get().asItem())
                .add(UDBlocks.DARK_BATHTUB.get().asItem())
                .add(UDBlocks.PICTURE_FRAME.get().asItem())
                .add(UDBlocks.CUPBOARD.get().asItem())
                .add(UDBlocks.DARK_CUPBOARD.get().asItem())
                .add(UDBlocks.FILING_CABINET.get().asItem())
                .add(UDBlocks.FLOOR_LAMP.get().asItem())
        ;

        for (DyeColor colors : DyeColor.values()) {
            tag(FURNISHINGS).add(UDItems.getDyedPictureFrames(colors.getId()).get().asItem());
        }

        tag(TOOLBOXABLE)
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
        ;

        tag(WRAPPABLE)

        ;

            tag(TOOLBOXES)
                .add(UDItems.TOOLBOX.get())
        ;

        for (DyeColor colors : DyeColor.values()) {
            tag(TOWELS).add(UDBlocks.getDyedTowels(colors.getId()).get().asItem());
        }
    }

    private static TagKey<Item> create(String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.tryBuild(UrbanDecor.MOD_ID, id));
    }
}

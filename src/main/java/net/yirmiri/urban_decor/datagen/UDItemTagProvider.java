package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.registry.UDBlocks;
import net.yirmiri.urban_decor.registry.UDItems;

import java.util.concurrent.CompletableFuture;

public class UDItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> FURNISHINGS = create("furnishings");
    public static final TagKey<Item> TOOLBOXES = create("toolboxes");
    public static final TagKey<Item> TOWELS = create("towels");
    public static final TagKey<Item> GLASS = create("glass");
    public static final TagKey<Item> DYES = create("dyes");
    public static final TagKey<Item> TOOLBOXABLE = create("toolboxable");
    public static final TagKey<Item> WRAPPABLE = create("wrappable");

    public UDItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(FURNISHINGS)
                .add(UDBlocks.TRASH_CAN.asItem())
                .add(UDItems.MICROWAVE)
                .add(UDBlocks.SINK.asItem())
                .add(UDBlocks.TOILET.asItem())
                .add(UDBlocks.WASHING_MACHINE.asItem())
                .add(UDBlocks.DRYER.asItem())
                .add(UDBlocks.TOASTER.asItem())
                .add(UDBlocks.DESK_FAN.asItem())
                .add(UDBlocks.OVEN.asItem())
                .add(UDBlocks.STOVE.asItem())
                .add(UDBlocks.FRIDGE.asItem())
                .add(UDBlocks.FREEZER.asItem())
                .add(UDBlocks.DARK_DRYER.asItem())
                .add(UDBlocks.DARK_OVEN.asItem())
                .add(UDBlocks.DARK_SINK.asItem())
                .add(UDBlocks.DARK_FRIDGE.asItem())
                .add(UDBlocks.DARK_FREEZER.asItem())
                .add(UDBlocks.DARK_TOILET.asItem())
                .add(UDBlocks.DARK_WASHING_MACHINE.asItem())
                .add(UDBlocks.BATHTUB.asItem())
                .add(UDBlocks.DARK_BATHTUB.asItem())
                .add(UDBlocks.PICTURE_FRAME.asItem())
                .add(UDBlocks.CUPBOARD.asItem())
                .add(UDBlocks.DARK_CUPBOARD.asItem())
                .add(UDBlocks.FILING_CABINET.asItem())
        ;

        for (DyeColor colors : DyeColor.values()) {
            getOrCreateTagBuilder(FURNISHINGS).add(UDItems.getDyedPictureFrames(colors.getId()).asItem());
        }

        getOrCreateTagBuilder(TOOLBOXABLE)
                .add(UDBlocks.TRASH_CAN.asItem())
                .add(UDBlocks.SINK.asItem())
                .add(UDBlocks.TOILET.asItem())
                .add(UDBlocks.WASHING_MACHINE.asItem())
                .add(UDBlocks.DRYER.asItem())
                .add(UDBlocks.OVEN.asItem())
                .add(UDBlocks.FRIDGE.asItem())
                .add(UDBlocks.FREEZER.asItem())
                .add(UDBlocks.DARK_DRYER.asItem())
                .add(UDBlocks.DARK_OVEN.asItem())
                .add(UDBlocks.DARK_SINK.asItem())
                .add(UDBlocks.DARK_FRIDGE.asItem())
                .add(UDBlocks.DARK_FREEZER.asItem())
                .add(UDBlocks.DARK_TOILET.asItem())
                .add(UDBlocks.DARK_WASHING_MACHINE.asItem())
                .add(UDBlocks.SHOWER.asItem())
                .add(UDBlocks.FAUCET.asItem())
                .add(UDBlocks.CUPBOARD.asItem())
                .add(UDBlocks.DARK_CUPBOARD.asItem())
                .add(UDBlocks.FILING_CABINET.asItem())
                .add(UDBlocks.RADIATOR.asItem())
                .add(UDBlocks.TOILET_PAPER.asItem())
        ;

        getOrCreateTagBuilder(WRAPPABLE)

        ;

        getOrCreateTagBuilder(DYES)
                .add(Items.RED_DYE)
                .add(Items.ORANGE_DYE)
                .add(Items.YELLOW_DYE)
                .add(Items.LIME_DYE)
                .add(Items.GREEN_DYE)
                .add(Items.CYAN_DYE)
                .add(Items.LIGHT_BLUE_DYE)
                .add(Items.BLUE_DYE)
                .add(Items.PURPLE_DYE)
                .add(Items.MAGENTA_DYE)
                .add(Items.PINK_DYE)
                .add(Items.WHITE_DYE)
                .add(Items.LIGHT_GRAY_DYE)
                .add(Items.GRAY_DYE)
                .add(Items.BLACK_DYE)
                .add(Items.BROWN_DYE)
        ;

            getOrCreateTagBuilder(TOOLBOXES)
                .add(UDItems.TOOLBOX)
        ;

        getOrCreateTagBuilder(GLASS)
                .add(Items.GLASS)
                .add(Items.TINTED_GLASS)
                .add(Items.RED_STAINED_GLASS)
                .add(Items.ORANGE_STAINED_GLASS)
                .add(Items.YELLOW_STAINED_GLASS)
                .add(Items.LIME_STAINED_GLASS)
                .add(Items.GREEN_STAINED_GLASS)
                .add(Items.BLUE_STAINED_GLASS)
                .add(Items.CYAN_STAINED_GLASS)
                .add(Items.LIGHT_BLUE_STAINED_GLASS)
                .add(Items.PURPLE_STAINED_GLASS)
                .add(Items.MAGENTA_STAINED_GLASS)
                .add(Items.PINK_STAINED_GLASS)
                .add(Items.WHITE_STAINED_GLASS)
                .add(Items.LIGHT_GRAY_STAINED_GLASS)
                .add(Items.GRAY_STAINED_GLASS)
                .add(Items.BLACK_STAINED_GLASS)
                .add(Items.BROWN_STAINED_GLASS)
        ;

        for (DyeColor colors : DyeColor.values()) {
            getOrCreateTagBuilder(TOWELS).add(UDBlocks.getDyedTowels(colors.getId()).asItem());
        }
    }

    private static TagKey<Item> create(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(UrbanDecor.MOD_ID, id));
    }
}

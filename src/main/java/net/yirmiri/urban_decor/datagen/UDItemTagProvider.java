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
import net.yirmiri.urban_decor.registry.RegisterBlocks;
import net.yirmiri.urban_decor.registry.RegisterItems;

import java.util.concurrent.CompletableFuture;

public class UDItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> FURNISHINGS = create("furnishings");
    public static final TagKey<Item> TOOLBOXES = create("toolboxes");
    public static final TagKey<Item> TOWELS = create("towels");
    public static final TagKey<Item> GLASS = create("glass");

    public UDItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(FURNISHINGS)
                .add(RegisterBlocks.TRASH_CAN.asItem())
                .add(RegisterBlocks.MICROWAVE.asItem())
                .add(RegisterBlocks.SINK.asItem())
                .add(RegisterBlocks.TOILET.asItem())
                .add(RegisterBlocks.WASHING_MACHINE.asItem())
                .add(RegisterBlocks.DRYER.asItem())
                .add(RegisterBlocks.TOASTER.asItem())
                .add(RegisterBlocks.DESK_FAN.asItem())
                .add(RegisterBlocks.OVEN.asItem())
                .add(RegisterBlocks.STOVE.asItem())
                .add(RegisterBlocks.FRIDGE.asItem())
                .add(RegisterBlocks.FREEZER.asItem())
                .add(RegisterBlocks.DARK_DRYER.asItem())
                .add(RegisterBlocks.DARK_OVEN.asItem())
                .add(RegisterBlocks.DARK_SINK.asItem())
                .add(RegisterBlocks.DARK_FRIDGE.asItem())
                .add(RegisterBlocks.DARK_FREEZER.asItem())
                .add(RegisterBlocks.DARK_TOILET.asItem())
                .add(RegisterBlocks.DARK_WASHING_MACHINE.asItem())
        ;

            getOrCreateTagBuilder(TOOLBOXES)
                .add(RegisterItems.TOOLBOX)
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
            getOrCreateTagBuilder(TOWELS).add(RegisterBlocks.getDyedTowels(colors.getId()).asItem());
        }
    }

    private static TagKey<Item> create(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(UrbanDecor.MOD_ID, id));
    }
}

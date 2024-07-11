package net.yirmiri.urban_decor.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.compat.RegisterCompatRegistries;
import net.yirmiri.urban_decor.compat.excessive_building.EBRegisterBlocks;

public class RegisterItemGroups {
    public static ItemGroup URBAN_DECOR = Registry.register(Registries.ITEM_GROUP, Identifier.of(UrbanDecor.MOD_ID, "urban_decor"),
            FabricItemGroup.builder().icon(() -> new ItemStack(RegisterItems.TOOLBOX)).displayName(Text.translatable("itemgroup.urban_decor")).entries((ctx, entries) -> {
                entries.add(RegisterItems.PORCELAIN);
                entries.add(RegisterItems.DARK_PORCELAIN);
                entries.add(RegisterItems.STAINLESS_STEEL);

                entries.add(RegisterBlocks.PORCELAIN_TILES);
                entries.add(RegisterBlocks.PORCELAIN_TILE_STAIRS);
                entries.add(RegisterBlocks.PORCELAIN_TILE_SLAB);

                entries.add(RegisterBlocks.DARK_PORCELAIN_TILES);
                entries.add(RegisterBlocks.DARK_PORCELAIN_TILE_STAIRS);
                entries.add(RegisterBlocks.DARK_PORCELAIN_TILE_SLAB);

                entries.add(RegisterBlocks.CHECKERED_PORCELAIN_TILES);
                entries.add(RegisterBlocks.CHECKERED_PORCELAIN_TILE_STAIRS);
                entries.add(RegisterBlocks.CHECKERED_PORCELAIN_TILE_SLAB);

                entries.add(RegisterBlocks.CHROMITE);
                entries.add(RegisterBlocks.CHROMITE_STAIRS);
                entries.add(RegisterBlocks.CHROMITE_SLAB);
                entries.add(RegisterBlocks.CHROMITE_WALL);

                entries.add(RegisterBlocks.POLISHED_CHROMITE);
                entries.add(RegisterBlocks.POLISHED_CHROMITE_STAIRS);
                entries.add(RegisterBlocks.POLISHED_CHROMITE_SLAB);

                entries.add(RegisterBlocks.STAINLESS_STEEL_BLOCK);

                entries.add(RegisterItems.TOOLBOX);

                entries.add(RegisterBlocks.FAUCET);
                entries.add(RegisterBlocks.SINK);
                entries.add(RegisterBlocks.DARK_SINK);
                entries.add(RegisterBlocks.TOILET);
                entries.add(RegisterBlocks.DARK_TOILET);
                entries.add(RegisterBlocks.WASHING_MACHINE);
                entries.add(RegisterBlocks.DARK_WASHING_MACHINE);
                entries.add(RegisterBlocks.DRYER);
                entries.add(RegisterBlocks.DARK_DRYER);
                entries.add(RegisterBlocks.FRIDGE);
                entries.add(RegisterBlocks.DARK_FRIDGE);
                entries.add(RegisterBlocks.FREEZER);
                entries.add(RegisterBlocks.DARK_FREEZER);
                entries.add(RegisterBlocks.OVEN);
                entries.add(RegisterBlocks.DARK_OVEN);
                entries.add(RegisterBlocks.STOVE);
                entries.add(RegisterBlocks.TOASTER);
                entries.add(RegisterBlocks.MICROWAVE);
                entries.add(RegisterBlocks.TRASH_CAN);
                entries.add(RegisterBlocks.DESK_FAN);

                entries.add(RegisterBlocks.TURBINE);
                entries.add(RegisterBlocks.AIR_CONDITIONER);
                entries.add(RegisterBlocks.RADIATOR);

                if (RegisterCompatRegistries.excessive_building) {
                    entries.add(EBRegisterBlocks.PORCELAIN_TILE_VERTICAL_STAIRS);
                    entries.add(EBRegisterBlocks.DARK_PORCELAIN_TILE_VERTICAL_STAIRS);
                    entries.add(EBRegisterBlocks.CHROMITE_VERTICAL_STAIRS);
                    entries.add(EBRegisterBlocks.POLISHED_CHROMITE_VERTICAL_STAIRS);
                }
            }).build());

    public static void registerItemGroups() {
    }
}

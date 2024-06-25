package net.yirmiri.urban_decor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.yirmiri.urban_decor.registry.RegisterBlocks;

public class UDLootTableProvider extends FabricBlockLootTableProvider {
    public UDLootTableProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        addDrop(RegisterBlocks.PORCELAIN_TILES);
        addDrop(RegisterBlocks.PORCELAIN_TILE_STAIRS);
        addDrop(RegisterBlocks.PORCELAIN_TILE_SLAB);
        addDrop(RegisterBlocks.TRASH_CAN);
        addDrop(RegisterBlocks.MICROWAVE);
        addDrop(RegisterBlocks.SINK);
        addDrop(RegisterBlocks.CHROMITE);
        addDrop(RegisterBlocks.CHROMITE_STAIRS);
        addDrop(RegisterBlocks.CHROMITE_SLAB);
        addDrop(RegisterBlocks.CHROMITE_WALL);
        addDrop(RegisterBlocks.POLISHED_CHROMITE);
        addDrop(RegisterBlocks.POLISHED_CHROMITE_STAIRS);
        addDrop(RegisterBlocks.POLISHED_CHROMITE_SLAB);
    }
}

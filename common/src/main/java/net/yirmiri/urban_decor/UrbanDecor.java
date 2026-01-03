package net.yirmiri.urban_decor;

import net.yirmiri.urban_decor.core.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrbanDecor {
    public static final String MOD_ID = "urban_decor";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        UDBlocks.loadBlocks();
        UDItems.loadItems();
        UDEntities.loadEntities();
        UDCreativeTabs.loadItemGroups();
        UDSounds.loadSounds();
        UDBlockEntities.loadBlockEntities();
    }
}
//TODO Wrapping update
//fix toaster not cooking
//make tags for each appliance type with their black/white/wrapped(?) included
//Fixed some appliances not making any open/close sounds when truly opening them
//more interactions
//grand clock emits signal when making tong sound
//grand clock be weird in nether
//fix only 1 instance of grand clock sound
//config for how many days in a year
//config for grand clock sound

//TODO MISC
//fix satellite sound
//wrapped blocks with state wraps should drop wrap on break
//toaster smoke particles
//microwave cook sound instance
//re-sort creative
//delicate from polyanthous: spring->wasabi mint->sacramento daffodil->canary ruby->rose
//delicate integration

//TODO Technical updates
//datadrive wraps
//datadrive toolbox variants
//make sounds for each block a lot more open
//rewrite/optimize code in the mod
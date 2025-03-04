package net.yirmiri.urban_decor.util;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.yirmiri.urban_decor.UrbanDecor;

public class UDStats {
    public static final Identifier TIMES_SAT = register("times_sat", StatFormatter.DEFAULT);
    public static final Identifier OPEN_APPLIANCES = register("open_appliances", StatFormatter.DEFAULT);
    //public static final Identifier USE_FAUCET = register("use_faucet", StatFormatter.DEFAULT);
    //public static final Identifier APPLIANCES_TOOLBOXED = register("appliances_toolboxed", StatFormatter.DEFAULT);

    private static Identifier register(String id, StatFormatter formatter) {
        Identifier identifier = Identifier.of(UrbanDecor.MOD_ID, id);
        Registry.register(Registries.CUSTOM_STAT, id, identifier);
        Stats.CUSTOM.getOrCreateStat(identifier, formatter);
        return identifier;
    }

    public static void loadStats() {
    }
}

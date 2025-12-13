package net.yirmiri.urban_decor.common.util;

import java.time.LocalDate;
import java.time.Month;

public class UDSeasonalEvents {
    public final boolean IS_APRIL_FOOLS;

    public UDSeasonalEvents() {
        LocalDate localDate = LocalDate.now();
        int day = localDate.getDayOfMonth();
        Month month = localDate.getMonth();

        this.IS_APRIL_FOOLS = month == Month.APRIL && day == 1;
    }

    public boolean isAprilFools() {
        return IS_APRIL_FOOLS;
    }
}

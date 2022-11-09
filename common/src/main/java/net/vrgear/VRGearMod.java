package net.vrgear;

import net.vrgear.common.WCItems;

public class VRGearMod {
    public static final String MOD_ID = "vrgear";
    public static final String MAPPING_ERROR = "A critical issue has occurred within Development. If you are seeing this in your crash report - please report immediately";

    public static void init() {
        WCItems.ITEMS.register();
    }
}

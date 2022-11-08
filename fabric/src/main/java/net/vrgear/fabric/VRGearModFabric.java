package net.vrgear.fabric;

import net.fabricmc.api.ModInitializer;
import net.vrgear.VRGearMod;

public class VRGearModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        VRGearMod.init();
    }
}

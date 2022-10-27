package net.vrmodel.fabric;

import net.fabricmc.api.ModInitializer;
import net.vrmodel.VRModelMod;

public class VRModelModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        VRModelMod.init();
    }
}

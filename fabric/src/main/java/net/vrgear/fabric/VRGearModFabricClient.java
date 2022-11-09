package net.vrgear.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.vrgear.client.models.ModelRegistration;

public class VRGearModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelRegistration.setupModels();
    }
}

package net.vrgear.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.vrgear.client.model.ModelRegistration;

public class VrGearModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelRegistration.setupModels();
    }
}

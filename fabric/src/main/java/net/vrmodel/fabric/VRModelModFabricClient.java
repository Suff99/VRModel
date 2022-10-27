package net.vrmodel.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.vrmodel.client.model.ModelRegistration;

public class VRModelModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelRegistration.setupModels();
    }
}

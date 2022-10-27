package net.vrmodel.client.model.fabric;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.vrmodel.VRModelMod;

import java.util.function.Supplier;

public class ModelRegistrationImpl {


    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definition) {
        EntityModelLayerRegistry.registerModelLayer(location, definition::get);
        return location;
    }

}

package net.vrmodel.client.model;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.vrmodel.VRModelMod;

import java.util.function.Supplier;

public class ModelRegistration {

    public static ModelLayerLocation CONTROLLER, HEADSET;

    public static void setupModels(){
        ResourceLocation modelLocation = new ResourceLocation(VRModelMod.MOD_ID, "models");
        CONTROLLER = register(new ModelLayerLocation(modelLocation, "controller"), VRControllerModel::createBodyLayer);
        HEADSET = register(new ModelLayerLocation(modelLocation, "headset"), VRHeadsetModel::createBodyLayer);
    }

    @ExpectPlatform
    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definition) {
        throw new RuntimeException(VRModelMod.MAPPING_ERROR);
    }


}

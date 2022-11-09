package net.vrgear.client.models;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.vrgear.VRGearMod;

import java.util.function.Supplier;

public class ModelRegistration {

    public static ModelLayerLocation HEADSET;

    public static void setupModels() {
        ResourceLocation modelLocation = new ResourceLocation(VRGearMod.MOD_ID, "models");
        HEADSET = register(new ModelLayerLocation(modelLocation, "headset"), VRHeadsetModel::createBodyLayer);
    }

    @ExpectPlatform
    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definition) {
        throw new RuntimeException(VRGearMod.MAPPING_ERROR);
    }


}

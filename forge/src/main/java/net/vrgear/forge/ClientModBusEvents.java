package net.vrgear.forge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vrgear.VRGearMod;
import net.vrgear.client.model.forge.ModelRegistrationImpl;
import net.vrgear.client.render.layers.RenderLayerVR;

@Mod.EventBusSubscriber(modid = VRGearMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModBusEvents {

    @SubscribeEvent
    public static void event(EntityRenderersEvent.RegisterLayerDefinitions event) {
        ModelRegistrationImpl.registerToGame(event);
    }


    @SubscribeEvent
    public static void renderLayers(EntityRenderersEvent.AddLayers addLayers) {
        addLayers.getSkins().forEach(skin -> {
            LivingEntityRenderer renderer = addLayers.getSkin(skin);
            renderer.addLayer(new RenderLayerVR<>(renderer, Minecraft.getInstance().getEntityModels()));
        });
    }


}

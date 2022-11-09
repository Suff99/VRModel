package net.vrgear.forge;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.vrgear.VRGearMod;
import net.vrgear.client.models.ModelRegistration;
import net.vrgear.forge.data.LangProviderEnglish;

@Mod(VRGearMod.MOD_ID)
public class VRGearModForge {
    public VRGearModForge() {
        VRGearMod.init();
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::clientSetup);
        modBus.addListener(this::onGatherData);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ModelRegistration.setupModels();
    }

    public void onGatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
        generator.addProvider(true, new LangProviderEnglish(generator));
    }

}

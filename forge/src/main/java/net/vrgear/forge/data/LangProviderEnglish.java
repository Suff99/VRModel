package net.vrgear.forge.data;

import net.vrgear.VRGearMod;
import net.vrgear.common.WCItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LangProviderEnglish extends LanguageProvider {

    public LangProviderEnglish(DataGenerator gen) {
        super(gen.getPackOutput(), VRGearMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(WCItems.OCULUS_HEADSET.get(), "Oculus Headset");
        add(WCItems.OCULUS_CONTROLLER.get(), "Oculus Controller");

        add("itemGroup.vrgear.vrgear", "VR Gear");
        add("itemGroup.vrgear", "VR Gear");
    }
}

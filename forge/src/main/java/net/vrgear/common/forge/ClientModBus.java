package net.vrgear.common.forge;

import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vrgear.VRGearMod;
import net.vrgear.common.WCItems;
import net.vrgear.registry.RegistrySupplier;


@Mod.EventBusSubscriber(modid = VRGearMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModBus {


    @SubscribeEvent
    public static void onBuildTabsContent(BuildCreativeModeTabContentsEvent event) {

        if (event.getTab() == WCItems.MAIN_TAB.get()) {
            for (RegistrySupplier<Item> item : WCItems.ITEMS.getEntries()) {
                event.accept(item.get());
            }
        }
    }


}
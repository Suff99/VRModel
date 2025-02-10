package net.vrgear.common.forge;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.vrgear.VRGearMod;
import net.vrgear.common.WCItems;

public class WCItemsImpl {

    private static final CreativeModeTab TAB = CreativeModeTab.builder().title(Component.translatable(VRGearMod.MOD_ID)).icon(() -> new ItemStack(WCItems.OCULUS_HEADSET.get())).build();


    public static CreativeModeTab getCreativeTab() {
        return TAB;
    }

}

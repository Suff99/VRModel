package net.vrgear.common.forge;

import net.vrgear.VRGearMod;
import net.vrgear.common.WCItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class WCItemsImpl {
    public static final CreativeModeTab TAB = new CreativeModeTab(VRGearMod.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(WCItems.OCULUS_HEADSET.get());
        }
    };

    public static CreativeModeTab getCreativeTab() {
        return TAB;
    }

}

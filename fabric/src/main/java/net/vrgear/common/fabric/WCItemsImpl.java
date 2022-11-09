package net.vrgear.common.fabric;

import net.vrgear.VRGearMod;
import net.vrgear.common.WCItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class WCItemsImpl {

    public static final CreativeModeTab TAB = FabricItemGroupBuilder.build(
            new ResourceLocation(VRGearMod.MOD_ID, VRGearMod.MOD_ID),
            () -> new ItemStack(WCItems.OCULUS_HEADSET.get()));

    public static CreativeModeTab getCreativeTab() {
        return TAB;
    }

}

package net.vrgear.common.fabric;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.vrgear.VRGearMod;
import net.vrgear.common.WCItems;
import net.vrgear.registry.RegistrySupplier;

public class WCItemsImpl {

    public static final CreativeModeTab ITEM_GROUP = FabricItemGroup.builder().icon(() -> new ItemStack(WCItems.OCULUS_HEADSET.get())).displayItems((enabledFeatures, entries) -> {
        for (RegistrySupplier<Item> item : WCItems.ITEMS.getEntries()) {
            entries.accept(item.get());
        }
    }).title(Component.translatable(VRGearMod.MOD_ID)).build();

    public static CreativeModeTab getCreativeTab() {
        return ITEM_GROUP;
    }

}

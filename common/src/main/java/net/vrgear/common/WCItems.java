package net.vrgear.common;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.vrgear.VRGearMod;
import net.vrgear.common.items.ClothingItem;
import net.vrgear.registry.DeferredRegistry;
import net.vrgear.registry.RegistrySupplier;

public class WCItems {

    public static final Item.Properties GENERIC_PROPERTIES = new Item.Properties().stacksTo(1);

    public static final DeferredRegistry<CreativeModeTab> TABS = DeferredRegistry.create(VRGearMod.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> MAIN_TAB = TABS.register("main_tab", WCItems::getCreativeTab);


    public static final DeferredRegistry<Item> ITEMS = DeferredRegistry.create(VRGearMod.MOD_ID, Registries.ITEM);
    public static final RegistrySupplier<Item> OCULUS_HEADSET = ITEMS.register("oculus_headset", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> OCULUS_CONTROLLER = ITEMS.register("oculus_controller", () -> new Item(GENERIC_PROPERTIES));

    @ExpectPlatform
    private static CreativeModeTab getCreativeTab() {
        throw new RuntimeException(VRGearMod.MAPPING_ERROR);
    }

}

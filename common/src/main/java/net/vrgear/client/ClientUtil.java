package net.vrgear.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.vrgear.client.models.ModelRegistration;
import net.vrgear.client.models.VRHeadsetModel;
import net.vrgear.common.WCItems;

import java.util.HashMap;

public class ClientUtil {

    public static HashMap<Item, HumanoidModel<?>> ARMOR_MODELS = new HashMap<>();

    public static <T extends LivingEntity> HumanoidModel<?> getArmorModel(ItemStack itemStack, T livingEntity) {
        if (ARMOR_MODELS.containsKey(itemStack.getItem())) {
            return ARMOR_MODELS.get(itemStack.getItem());
        }
        return null;
    }

    public static void clothingModels() {
        if (!ARMOR_MODELS.isEmpty()) return;
        EntityModelSet entityModels = Minecraft.getInstance().getEntityModels();
        if (entityModels == null) return;

        ARMOR_MODELS.put(WCItems.OCULUS_HEADSET.get(), new VRHeadsetModel(entityModels.bakeLayer(ModelRegistration.HEADSET)));
    }


}

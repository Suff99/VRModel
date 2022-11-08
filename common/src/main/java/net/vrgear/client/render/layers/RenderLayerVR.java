package net.vrgear.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.vrgear.VRGearMod;
import net.vrgear.client.model.ModelRegistration;
import net.vrgear.client.model.VRHeadsetModel;

public class RenderLayerVR<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private final VRHeadsetModel headsetModel;
    public static ResourceLocation headsetLocation = new ResourceLocation(VRGearMod.MOD_ID, "textures/models/oculus_headset.png");

    public RenderLayerVR(RenderLayerParent<T, M> renderLayerParent, EntityModelSet entityModelSet) {
        super(renderLayerParent);
        this.headsetModel = new VRHeadsetModel(entityModelSet.bakeLayer(ModelRegistration.HEADSET));

    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T entity, float f, float g, float h, float j, float k, float l) {

        getParentModel().copyPropertiesTo(headsetModel);

        if (getParentModel() instanceof HumanoidModel<?> humanoidModel) {
            poseStack.pushPose();
            humanoidModel.head.translateAndRotate(poseStack);
            headsetModel.head.render(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(headsetLocation)), i, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }
}

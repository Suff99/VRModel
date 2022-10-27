package net.vrmodel.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
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
import net.vrmodel.VRModelMod;
import net.vrmodel.client.model.ModelRegistration;
import net.vrmodel.client.model.VRControllerModel;
import net.vrmodel.client.model.VRHeadsetModel;

import java.util.Optional;

public class RenderLayerVR<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {

    private final VRControllerModel controllerModel;
    private final VRHeadsetModel headsetModel;

    public static ResourceLocation headsetLocation = new ResourceLocation(VRModelMod.MOD_ID, "textures/models/oculus_headset.png"), controllerLocation = new ResourceLocation(VRModelMod.MOD_ID, "textures/models/oculus_controller.png");

    public RenderLayerVR(RenderLayerParent<T, M> renderLayerParent, EntityModelSet entityModelSet) {
        super(renderLayerParent);
        this.controllerModel = new VRControllerModel(entityModelSet.bakeLayer(ModelRegistration.CONTROLLER));
        this.headsetModel = new VRHeadsetModel(entityModelSet.bakeLayer(ModelRegistration.HEADSET));

    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T entity, float f, float g, float h, float j, float k, float l) {

        getParentModel().copyPropertiesTo(headsetModel);
        getParentModel().copyPropertiesTo(controllerModel);

        if (getParentModel() instanceof HumanoidModel<?> humanoidModel) {
            poseStack.pushPose();
            humanoidModel.head.translateAndRotate(poseStack);
            headsetModel.head.render(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(headsetLocation)), i, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();


            poseStack.pushPose();
            humanoidModel.leftArm.translateAndRotate(poseStack);
            poseStack.translate(-0.3, -0.1, 0);
            controllerModel.leftArm.render(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(controllerLocation)), i, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();

            poseStack.pushPose();
            humanoidModel.rightArm.translateAndRotate(poseStack);
            poseStack.translate(0.3, -0.1, 0);
            controllerModel.rightArm.render(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(controllerLocation)), i, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();

        }


    }

    private void renderModel(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, ResourceLocation texture, HumanoidModel humanoidModel, float f, float g, float h) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(texture));
        humanoidModel.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, f, g, h, 1.0F);
    }
}

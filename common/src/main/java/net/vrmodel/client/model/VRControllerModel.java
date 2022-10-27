package net.vrmodel.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class VRControllerModel extends HumanoidModel {
    public VRControllerModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));


        PartDefinition rightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 10).addBox(-1.5F, -1.75F, -1.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -0.75F, -0.75F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 9.75F, -4.25F));

        PartDefinition leftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 10).addBox(-1.5F, -1.75F, -1.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -0.75F, -0.75F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 9.75F, -4.25F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }
}

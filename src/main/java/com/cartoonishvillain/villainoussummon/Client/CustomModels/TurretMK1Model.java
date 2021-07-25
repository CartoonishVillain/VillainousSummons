package com.cartoonishvillain.villainoussummon.Client.CustomModels;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.BaseTurretsMK1;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.animal.AbstractGolem;

public class TurretMK1Model<T extends AbstractGolem> extends EntityModel<BaseTurretsMK1> {
    private static final String HEAD = "head";
    private static final String STAND = "stand";
	private final ModelPart Head;
	private final ModelPart Stand;

	public TurretMK1Model(ModelPart part) {
        super(RenderType::entityCutoutNoCull);
        this.Head = part.getChild(HEAD);
        this.Stand = part.getChild(STAND);
        this.Head.setPos(0, 7, 0);
        this.Stand.setPos(0, 24, 0);
//		texWidth = 64;
//		texHeight = 64;
//
//		Head = new ModelPart(this);
//		Head.setPos(0.0F, 7.0F, 0.0F);
//		Head.texOffs(0, 0).addBox(-7.0F, -14.0F, -7.0F, 14.0F, 14.0F, 14.0F, 0.0F, false);
//
//		Stand = new ModelPart(this);
//		Stand.setPos(0.0F, 24.0F, 0.0F);
//		Stand.texOffs(0, 28).addBox(-7.0F, -1.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
//		Stand.texOffs(0, 43).addBox(-1.0F, -17.0F, -1.0F, 2.0F, 16.0F, 2.0F, 0.0F, false);
	}

	public static LayerDefinition createLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
        .texOffs(0,0)
        .addBox(-7.0F, -14.0F, -7.0F, 14.0F, 14.0F, 14.0F), PartPose.ZERO);
        partDefinition.addOrReplaceChild(STAND, CubeListBuilder.create()
        .texOffs(0, 28).addBox(-7.0F, -1.0F, -7.0F, 14.0F, 1.0F, 14.0F)
        .texOffs(0, 43).addBox(-1.0F, -17.0F, -1.0F, 2.0F, 16.0F, 2.0F), PartPose.ZERO);
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

	@Override
	public void setupAnim(BaseTurretsMK1 p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Stand.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}
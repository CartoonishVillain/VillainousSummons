package com.cartoonishvillain.villainoussummon.Client.CustomModels;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.villainoussummon.Entities.Turrets.TurretMk1;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.GolemEntity;

public class TurretMK1Model<T extends GolemEntity> extends EntityModel<TurretMk1> {
	private final ModelRenderer Head;
	private final ModelRenderer Stand;

	public TurretMK1Model() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 7.0F, 0.0F);
		Head.texOffs(0, 0).addBox(-7.0F, -14.0F, -7.0F, 14.0F, 14.0F, 14.0F, 0.0F, false);

		Stand = new ModelRenderer(this);
		Stand.setPos(0.0F, 24.0F, 0.0F);
		Stand.texOffs(0, 28).addBox(-7.0F, -1.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
		Stand.texOffs(0, 43).addBox(-1.0F, -17.0F, -1.0F, 2.0F, 16.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(TurretMk1 p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Stand.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}
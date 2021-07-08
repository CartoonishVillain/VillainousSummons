package com.cartoonishvillain.villainoussummon.Client.CustomModels;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.BaseTurretsMK3;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.GolemEntity;

public class TurretMk3Model<T extends GolemEntity> extends EntityModel<BaseTurretsMK3> {
	private final ModelRenderer Head;
	private final ModelRenderer Stand;

	public TurretMk3Model() {
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -11.0F, 0.0F);
		Head.texOffs(0, 0).addBox(-10.0F, -20.0F, -10.0F, 20.0F, 20.0F, 20.0F, 0.0F, false);
		Head.texOffs(60, 0).addBox(-4.0F, -21.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);

		Stand = new ModelRenderer(this);
		Stand.setPos(0.0F, 24.0F, 0.0F);
		Stand.texOffs(0, 40).addBox(-10.0F, -5.0F, -10.0F, 20.0F, 5.0F, 20.0F, 0.0F, false);
		Stand.texOffs(0, 65).addBox(-3.0F, -35.0F, -3.0F, 6.0F, 30.0F, 6.0F, 0.0F, false);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(BaseTurretsMK3 p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
		this.Head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
		this.Head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Stand.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}
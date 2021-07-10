package com.cartoonishvillain.villainoussummon.Client.CustomModels;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.horse.HorseEntity;

public class SlimeMountModel<S extends HorseEntity> extends EntityModel<SlimeMount> {
	private final ModelRenderer Slime;

	public SlimeMountModel() {
		texWidth = 64;
		texHeight = 64;

		Slime = new ModelRenderer(this);
		Slime.setPos(0.0F, 24.0F, 0.0F);
		Slime.texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		Slime.texOffs(0, 32).addBox(-7.0F, -15.0F, -7.0F, 14.0F, 14.0F, 14.0F, 0.0F, false);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(SlimeMount p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
		this.Slime.yRot = p_225597_5_ * ((float)Math.PI / 180F);
		this.Slime.xRot = 0;
	}



	@Override
	public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
		Slime.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
	}
}
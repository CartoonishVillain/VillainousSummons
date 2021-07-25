//package com.cartoonishvillain.villainoussummon.Client.CustomModels;// Made with Blockbench 3.9.1
//// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
//// Paste this class into your mod and generate all required imports
//
//
//import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.BaseTurretsMK1;
//import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.BaseTurretsMK2;
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import net.minecraft.client.model.EntityModel;
//import net.minecraft.client.model.geom.ModelPart;
//import net.minecraft.entity.Entity;
//import net.minecraft.world.entity.animal.AbstractGolem;
//
//public class TurretMk2Model<T extends AbstractGolem> extends EntityModel<BaseTurretsMK2> {
//	private final ModelPart Head;
//	private final ModelPart Stand;
//
//	public TurretMk2Model() {
//		texWidth = 128;
//		texHeight = 128;
//
//		Head = new ModelPart(this);
//		Head.setPos(0.0F, 0.0F, 0.0F);
//		Head.texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
//
//		Stand = new ModelPart(this);
//		Stand.setPos(0.0F, 24.0F, 0.0F);
//		Stand.texOffs(0, 32).addBox(-7.0F, -3.0F, -7.0F, 14.0F, 3.0F, 14.0F, 0.0F, false);
//		Stand.texOffs(0, 49).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 21.0F, 4.0F, 0.0F, false);
//	}
//
//	@Override
//	public void setupAnim(BaseTurretsMK2 p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
//		this.Head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
//		this.Head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
//	}
//	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
//		modelRenderer.xRot = x;
//		modelRenderer.yRot = y;
//		modelRenderer.zRot = z;
//	}
//
//	@Override
//	public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
//		Head.render(matrixStack, buffer, packedLight, packedOverlay);
//		Stand.render(matrixStack, buffer, packedLight, packedOverlay);
//	}
//}
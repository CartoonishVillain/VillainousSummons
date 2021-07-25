package com.cartoonishvillain.villainoussummon.Client.CustomModels;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.animal.horse.Horse;

public class SlimeMountModel<S extends Horse> extends EntityModel<SlimeMount> {
	private static final String SLIME = "slime";
	private final ModelPart Slime;


	public SlimeMountModel(ModelPart part) {
		super(RenderType::entityCutoutNoCull);
		this.Slime = part.getChild(SLIME);
		this.Slime.setPos(0, 24, 0);
	}

	public static LayerDefinition createLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		partDefinition.addOrReplaceChild(SLIME, CubeListBuilder.create()
				.texOffs(0,32)
				.addBox(-7.0F, -15.0F, -7.0F, 14.0F, 14.0F, 14.0F), PartPose.ZERO);
		return LayerDefinition.create(meshDefinition, 64, 64);
				//		Slime.setPos(0.0F, 24.0F, 0.0F);
//		Slime.texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
//		Slime.texOffs(0, 32).addBox(-7.0F, -15.0F, -7.0F, 14.0F, 14.0F, 14.0F, 0.0F, false);\
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
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
	public void renderToBuffer(PoseStack p_225598_1_, VertexConsumer p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
		Slime.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
	}
}
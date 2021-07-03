package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;

import com.cartoonishvillain.villainoussummon.Entities.WolfMinion;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderWolfSummon extends WolfRenderer {

    protected static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/wolf/wolf_tame.png");

    public RenderWolfSummon(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_);
    }

    private static final ResourceLocation WOLF_LOCATION = new ResourceLocation("textures/entity/wolf/wolf.png");
    private static final ResourceLocation WOLF_TAME_LOCATION = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
    private static final ResourceLocation WOLF_ANGRY_LOCATION = new ResourceLocation("textures/entity/wolf/wolf_angry.png");


    protected float getBob(WolfMinion p_77044_1_, float p_77044_2_) {
        return p_77044_1_.getTailAngle();
    }

    public void render(WolfMinion p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        if (p_225623_1_.isWet()) {
            float f = p_225623_1_.getWetShade(p_225623_3_);
            this.model.setColor(f, f, f);
        }

        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
        if (p_225623_1_.isWet()) {
            this.model.setColor(1.0F, 1.0F, 1.0F);
        }

    }

    public ResourceLocation getTextureLocation(WolfMinion p_110775_1_) {
        if (p_110775_1_.isTame()) {
            return WOLF_TAME_LOCATION;
        } else {
            return p_110775_1_.isAngry() ? WOLF_ANGRY_LOCATION : WOLF_LOCATION;
        }
    }
}

package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;

import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.util.ResourceLocation;

public class RenderSlimeMount extends MobRenderer<SlimeMount, SlimeModel<SlimeMount>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/slime.png");


    public RenderSlimeMount(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new SlimeModel<>(3), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SlimeMount p_110775_1_) {
        return TEXTURE;
    }
}

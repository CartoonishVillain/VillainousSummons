package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;

import com.cartoonishvillain.villainoussummon.Client.CustomModels.SlimeMountModel;
import com.cartoonishvillain.villainoussummon.Client.RenderManager;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.resources.ResourceLocation;

public class RenderSlimeMount extends MobRenderer<SlimeMount, SlimeMountModel<SlimeMount>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/slime.png");

    public RenderSlimeMount(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new SlimeMountModel<SlimeMount>(Minecraft.getInstance().getEntityModels().bakeLayer(RenderManager.BELT_LAYER)), 0.5f);
    }


//    public RenderSlimeMount(EntityRenderDispatcher p_i50961_1_) {
//        super(p_i50961_1_, new SlimeMountModel<SlimeMount>(Minecraft.getInstance().getEntityModels().bakeLayer(RenderManager.BELT_LAYER)), 0.5f);
//    }

    @Override
    public ResourceLocation getTextureLocation(SlimeMount p_110775_1_) {
        return TEXTURE;
    }
}

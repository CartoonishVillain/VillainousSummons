package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;

import com.cartoonishvillain.villainoussummon.Client.CustomModels.SlimeMountModel;
import com.cartoonishvillain.villainoussummon.Client.RenderManager;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.villainoussummon.Client.RenderManager.SLIMEMOUNT;

public class SlimeMountRenderer extends MobRenderer<SlimeMount, SlimeMountModel<SlimeMount>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/slimemount.png");

    public SlimeMountRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new SlimeMountModel<>(p_174304_.bakeLayer(SLIMEMOUNT)), 1f);
    }


//    public SlimeMountRenderer(EntityRenderDispatcher p_i50961_1_) {
//        super(p_i50961_1_, new SlimeMountModel<>(), 1f);
//
//    }

    @Override
    public ResourceLocation getTextureLocation(SlimeMount p_110775_1_) {
        return TEXTURE;
    }
}

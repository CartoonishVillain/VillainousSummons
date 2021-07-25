package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class TurretArrowRenderer extends ArrowRenderer {

    public TurretArrowRenderer(EntityRendererProvider.Context p_173917_) {
        super(p_173917_);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity p_114482_) {
        return new ResourceLocation("minecraft", "textures/entity/projectiles/arrow.png");
    }
}

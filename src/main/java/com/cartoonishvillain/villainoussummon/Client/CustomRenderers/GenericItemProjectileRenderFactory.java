package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;


import com.cartoonishvillain.villainoussummon.Entities.Projectiles.GenericItemProjectile;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;


public class GenericItemProjectileRenderFactory extends ThrownItemRenderer<GenericItemProjectile> {

    public GenericItemProjectileRenderFactory(EntityRendererProvider.Context p_174416_) {
        super(p_174416_, 0.5f, false);
    }
}


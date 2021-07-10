package com.cartoonishvillain.villainoussummon.Entities.Projectiles;

import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public abstract class GenericItemProjectile extends ProjectileItemEntity {

    public GenericItemProjectile(EntityType<? extends ProjectileItemEntity> p_i50155_1_, World p_i50155_2_) {
        super(p_i50155_1_, p_i50155_2_);
    }

    public GenericItemProjectile(EntityType<? extends ProjectileItemEntity> p_i50156_1_, double p_i50156_2_, double p_i50156_4_, double p_i50156_6_, World p_i50156_8_) {
        super(p_i50156_1_, p_i50156_2_, p_i50156_4_, p_i50156_6_, p_i50156_8_);
    }

    public GenericItemProjectile(EntityType<? extends ProjectileItemEntity> p_i50157_1_, LivingEntity p_i50157_2_, World p_i50157_3_) {
        super(p_i50157_1_, p_i50157_2_, p_i50157_3_);
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}

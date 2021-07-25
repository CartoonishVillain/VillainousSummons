package com.cartoonishvillain.villainoussummon.Entities.Projectiles;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public abstract class GenericItemProjectile extends ThrowableItemProjectile {

    public GenericItemProjectile(EntityType<? extends ThrowableItemProjectile> p_i50155_1_, Level p_i50155_2_) {
        super(p_i50155_1_, p_i50155_2_);
    }

    public GenericItemProjectile(EntityType<? extends ThrowableItemProjectile> p_i50156_1_, double p_i50156_2_, double p_i50156_4_, double p_i50156_6_, Level p_i50156_8_) {
        super(p_i50156_1_, p_i50156_2_, p_i50156_4_, p_i50156_6_, p_i50156_8_);
    }

    public GenericItemProjectile(EntityType<? extends ThrowableItemProjectile> p_i50157_1_, LivingEntity p_i50157_2_, Level p_i50157_3_) {
        super(p_i50157_1_, p_i50157_2_, p_i50157_3_);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}

package com.cartoonishvillain.villainoussummon.Entities.Projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class CannonballProjectile extends GenericItemProjectile {

    public CannonballProjectile(EntityType<? extends ProjectileItemEntity> p_i50155_1_, World p_i50155_2_) {
        super(p_i50155_1_, p_i50155_2_);
    }

    public CannonballProjectile(EntityType<? extends ProjectileItemEntity> p_i50156_1_, double p_i50156_2_, double p_i50156_4_, double p_i50156_6_, World p_i50156_8_) {
        super(p_i50156_1_, p_i50156_2_, p_i50156_4_, p_i50156_6_, p_i50156_8_);
    }

    public CannonballProjectile(EntityType<? extends ProjectileItemEntity> p_i50157_1_, LivingEntity p_i50157_2_, World p_i50157_3_) {
        super(p_i50157_1_, p_i50157_2_, p_i50157_3_);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.SLIME_BALL;
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(Items.SLIME_BALL.getItem());
    }

    @Override
    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        Vector3d vector3d = p_70227_1_.getLocation();
        this.level.explode(this, vector3d.x, vector3d.y, vector3d.z, 3, Explosion.Mode.NONE);
    }
}

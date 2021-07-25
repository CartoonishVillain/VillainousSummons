package com.cartoonishvillain.villainoussummon.Entities.Projectiles;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class CannonballProjectile extends ThrowableItemProjectile {

    public CannonballProjectile(EntityType<? extends ThrowableItemProjectile> p_i50155_1_, Level p_i50155_2_) {
        super(p_i50155_1_, p_i50155_2_);
    }

    public CannonballProjectile(EntityType<? extends ThrowableItemProjectile> p_i50156_1_, double p_i50156_2_, double p_i50156_4_, double p_i50156_6_, Level p_i50156_8_) {
        super(p_i50156_1_, p_i50156_2_, p_i50156_4_, p_i50156_6_, p_i50156_8_);
    }

    public CannonballProjectile(EntityType<? extends ThrowableItemProjectile> p_i50157_1_, LivingEntity p_i50157_2_, Level p_i50157_3_) {
        super(p_i50157_1_, p_i50157_2_, p_i50157_3_);
    }

    @Override
    protected Item getDefaultItem() {
        return Register.CANNONBALL.get();
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(Register.CANNONBALL.get());
    }

    @Override
    protected void onHit(HitResult p_70227_1_) {
        super.onHit(p_70227_1_);
        Vec3 vector3d = p_70227_1_.getLocation();
        this.level.explode(this, vector3d.x, vector3d.y, vector3d.z, 3, Explosion.BlockInteraction.NONE);
        this.remove(false);
    }
}

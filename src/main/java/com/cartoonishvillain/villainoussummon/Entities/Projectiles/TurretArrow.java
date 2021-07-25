package com.cartoonishvillain.villainoussummon.Entities.Projectiles;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class TurretArrow extends Arrow {

    public TurretArrow(Level p_i46758_1_, LivingEntity p_i46758_2_) {
        super(p_i46758_1_, p_i46758_2_);
    }

    public TurretArrow(Level p_i46758_1_, LivingEntity p_i46758_2_, int fireseconds) {
        super(p_i46758_1_, p_i46758_2_);
        this.setSecondsOnFire(fireseconds);

    }

    public TurretArrow(EntityType<? extends Arrow> p_i50172_1_, Level p_i50172_2_) {
        super(p_i50172_1_, p_i50172_2_);
    }

    public TurretArrow(Level p_i46757_1_, double p_i46757_2_, double p_i46757_4_, double p_i46757_6_) {
        super(p_i46757_1_, p_i46757_2_, p_i46757_4_, p_i46757_6_);
    }

    @Override
    protected void onHitEntity(EntityHitResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        p_213868_1_.getEntity().invulnerableTime = 0;
    }

    @Override
    protected void onHitBlock(BlockHitResult p_230299_1_) {
        super.onHitBlock(p_230299_1_);
        this.remove(false);
    }
}

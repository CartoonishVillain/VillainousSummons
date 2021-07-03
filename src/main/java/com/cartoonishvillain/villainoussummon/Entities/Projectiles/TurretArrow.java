package com.cartoonishvillain.villainoussummon.Entities.Projectiles;

import com.cartoonishvillain.villainoussummon.Entities.TurretMk1;
import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class TurretArrow extends ArrowEntity {

    public TurretArrow(World p_i46758_1_, LivingEntity p_i46758_2_) {
        super(p_i46758_1_, p_i46758_2_);
    }

    public TurretArrow(EntityType<? extends ArrowEntity> p_i50172_1_, World p_i50172_2_) {
        super(p_i50172_1_, p_i50172_2_);
    }

    public TurretArrow(World p_i46757_1_, double p_i46757_2_, double p_i46757_4_, double p_i46757_6_) {
        super(p_i46757_1_, p_i46757_2_, p_i46757_4_, p_i46757_6_);
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        p_213868_1_.getEntity().invulnerableTime = 0;
    }

    @Override
    protected void onHitBlock(BlockRayTraceResult p_230299_1_) {
        super.onHitBlock(p_230299_1_);
        this.remove();
    }
}
package com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;

public class FireTurretMk1 extends BaseTurretsMK1 implements RangedAttackMob {
    public FireTurretMk1(EntityType<? extends AbstractGolem> p_i50244_1_, Level p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_, turretTypeMK1.FIRE);
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float p_82196_2_) {
        if(entity != null && entity.isAlive()){
            double distance = this.distanceToSqr(entity);
            double x = entity.getX() - this.getX();
            double y = entity.getY() - this.getEyeY();
            double z = entity.getZ() - this.getZ();
            float f = Mth.sqrt(Mth.sqrt((float) distance)) * 0.6F;
            SmallFireball smallfireballentity = new SmallFireball(this.level, this, x + this.getRandom().nextGaussian() * (double)f, y, z + this.getRandom().nextGaussian() * (double)f);
            smallfireballentity.setPos(this.getX(), this.getEyeY(), this.getZ());
            this.playSound(SoundEvents.FIRECHARGE_USE, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            this.level.addFreshEntity(smallfireballentity);
        }
    }

    public static AttributeSupplier.Builder customAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 40D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }

}

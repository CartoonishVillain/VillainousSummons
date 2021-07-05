package com.cartoonishvillain.villainoussummon.Entities.Turrets;

import com.cartoonishvillain.villainoussummon.Entities.Projectiles.TurretArrow;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class FireTurretMk1 extends BaseTurretsMK1 implements IRangedAttackMob {
    public FireTurretMk1(EntityType<? extends GolemEntity> p_i50244_1_, World p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_, turretTypeMK1.FIRE);
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 10, true, false, ATTACK_PREDICATE));
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float p_82196_2_) {
        if(entity != null && entity.isAlive()){
            double distance = this.distanceToSqr(entity);
            double x = entity.getX() - this.getX();
            double y = entity.getY() - this.getEyeY();
            double z = entity.getZ() - this.getZ();
            float f = MathHelper.sqrt(MathHelper.sqrt(distance)) * 0.6F;
            SmallFireballEntity smallfireballentity = new SmallFireballEntity(this.level, this, x + this.getRandom().nextGaussian() * (double)f, y, z + this.getRandom().nextGaussian() * (double)f);
            smallfireballentity.setPos(this.getX(), this.getEyeY(), this.getZ());
            this.playSound(SoundEvents.FIRECHARGE_USE, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            this.level.addFreshEntity(smallfireballentity);
        }
    }

    public static AttributeModifierMap.MutableAttribute customAttributes(){
        return MobEntity.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 40D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }

}

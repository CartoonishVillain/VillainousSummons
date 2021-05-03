package com.example.examplemod.Entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class BearMinion extends PolarBearEntity {

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D);
    }

    public BearMinion(EntityType<? extends PolarBearEntity> p_i50249_1_, World p_i50249_2_) {
        super(p_i50249_1_, p_i50249_2_);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BearMinion.MeleeAttackGoal());
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, LivingEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        if(tickCount >= 90*20) this.remove();
    }

    /*
    These goals are from mojang using their official mappings.
    I just needed to access them here.
     */

    class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
        public MeleeAttackGoal() {
            super(BearMinion.this, 1.25D, true);
        }

        protected void checkAndPerformAttack(LivingEntity p_190102_1_, double p_190102_2_) {
            double d0 = this.getAttackReachSqr(p_190102_1_);
            if (p_190102_2_ <= d0 && this.isTimeToAttack()) {
                this.resetAttackCooldown();
                this.mob.doHurtTarget(p_190102_1_);
                BearMinion.this.setStanding(false);
            } else if (p_190102_2_ <= d0 * 2.0D) {
                if (this.isTimeToAttack()) {
                    BearMinion.this.setStanding(false);
                    this.resetAttackCooldown();
                }

                if (this.getTicksUntilNextAttack() <= 10) {
                    BearMinion.this.setStanding(true);
                    BearMinion.this.playWarningSound();
                }
            } else {
                this.resetAttackCooldown();
                BearMinion.this.setStanding(false);
            }

        }

        public void stop() {
            BearMinion.this.setStanding(false);
            super.stop();
        }

        protected double getAttackReachSqr(LivingEntity p_179512_1_) {
            return (double)(4.0F + p_179512_1_.getBbWidth());
        }
    }
}

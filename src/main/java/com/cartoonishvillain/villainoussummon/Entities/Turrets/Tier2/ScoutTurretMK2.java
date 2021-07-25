package com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class ScoutTurretMK2 extends BaseTurretsMK2 implements RangedAttackMob {

    public ScoutTurretMK2(EntityType<? extends AbstractGolem> p_i50244_1_, Level p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_, turretTypeMK2.SCOUT);
    }


    public static AttributeSupplier.Builder customAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 50D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }

    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return (entitytype != Register.VEXMINION.get() && !p_213440_0_.isDeadOrDying() && !p_213440_0_.hasEffect(MobEffects.GLOWING));
    };


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 20));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Monster.class, 8, true, false, ATTACK_PREDICATE));
    }

    @Override
    public void push(Entity p_70108_1_) {
        super.push(p_70108_1_);
    }



    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        if(p_82196_1_ != null && p_82196_1_.isAlive() && !p_82196_1_.hasEffect(MobEffects.GLOWING)){
            p_82196_1_.addEffect(new MobEffectInstance(MobEffects.GLOWING, 10*20, 0));
        }else if(p_82196_1_.hasEffect(MobEffects.GLOWING)){
            this.setTarget(null);
        }
    }
}

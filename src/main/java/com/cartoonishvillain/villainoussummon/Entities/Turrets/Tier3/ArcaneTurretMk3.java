package com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
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

public class ArcaneTurretMk3 extends BaseTurretsMK3 implements RangedAttackMob {

    public ArcaneTurretMk3(EntityType<? extends AbstractGolem> p_i50244_1_, Level p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_, turretTypeMK3.ARCANE);
    }
    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return (entitytype != Register.VEXMINION.get() && !p_213440_0_.isDeadOrDying());
    };


    public static AttributeSupplier.Builder customAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 65D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }

    @Override
    public void push(Entity p_70108_1_) {
        super.push(p_70108_1_);
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 85, 85));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Monster.class, 25, true, false, ATTACK_PREDICATE));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource p_180431_1_) {
        return p_180431_1_ == DamageSource.LIGHTNING_BOLT;
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        if(p_82196_1_ != null && p_82196_1_.isAlive()){
            LightningBolt lightningBoltEntity = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
            lightningBoltEntity.setPos(p_82196_1_.getX(), p_82196_1_.getY(), p_82196_1_.getZ());
            p_82196_1_.level.addFreshEntity(lightningBoltEntity);
            this.playSound(SoundEvents.BREWING_STAND_BREW, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4f + 0.8f));

            int potionchecker = random.nextInt(8);
            switch (potionchecker){
                case 2:
                    p_82196_1_.addEffect(new MobEffectInstance(MobEffects.POISON, 20*20, 0));
                    break;
                case 3:
                    p_82196_1_.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120*20, 0));
                    break;
                case 4:
                    if(p_82196_1_.isInvertedHealAndHarm()){p_82196_1_.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));}
                    else p_82196_1_.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));
                    break;
                case 5:
                    p_82196_1_.randomTeleport(16, 16, 16, true);
                    break;
                case 6:
                    p_82196_1_.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 120*20, 0));
                    break;
                case 7:
                    p_82196_1_.addEffect(new MobEffectInstance(MobEffects.HUNGER, 120*20, 0));
                    break;
                default:
                    p_82196_1_.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25*20, 1));
            }

        }
    }
}

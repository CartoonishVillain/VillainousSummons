package com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3;

import com.cartoonishvillain.villainoussummon.Entities.Projectiles.BallistaArrow;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.turretTypeMK1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.BaseTurretsMK2;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ArcaneTurretMk3 extends BaseTurretsMK2 implements IRangedAttackMob {

    public ArcaneTurretMk3(EntityType<? extends GolemEntity> p_i50244_1_, World p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_, turretTypeMK1.ARROW);
    }


    public static AttributeModifierMap.MutableAttribute customAttributes(){
        return MobEntity.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 65D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }

    @Override
    public void push(Entity p_70108_1_) {
        super.push(p_70108_1_);
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 85, 85));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 20, true, false, ATTACK_PREDICATE));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource p_180431_1_) {
        return p_180431_1_ == DamageSource.LIGHTNING_BOLT;
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        if(p_82196_1_ != null && p_82196_1_.isAlive() && !(MathHelper.sqrt(p_82196_1_.distanceTo(this)) < 3)){
            LightningBoltEntity lightningBoltEntity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, this.level);
            lightningBoltEntity.setPos(p_82196_1_.getX(), p_82196_1_.getY(), p_82196_1_.getZ());
            p_82196_1_.level.addFreshEntity(lightningBoltEntity);

            int potionchecker = random.nextInt(8);
            switch (potionchecker){
                case 2:
                    p_82196_1_.addEffect(new EffectInstance(Effects.POISON, 20*20, 0));
                    break;
                case 3:
                    p_82196_1_.addEffect(new EffectInstance(Effects.WEAKNESS, 120*20, 0));
                    break;
                case 4:
                    if(p_82196_1_.isInvertedHealAndHarm()){p_82196_1_.addEffect(new EffectInstance(Effects.HEAL, 1, 0));}
                    else p_82196_1_.addEffect(new EffectInstance(Effects.HARM, 1, 0));
                    break;
                case 5:
                    p_82196_1_.randomTeleport(16, 16, 16, true);
                    break;
                case 6:
                    p_82196_1_.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 120*20, 0));
                    break;
                case 7:
                    p_82196_1_.addEffect(new EffectInstance(Effects.HUNGER, 120*20, 0));
                    break;
                default:
                    p_82196_1_.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 25*20, 1));
            }

        }
    }
}

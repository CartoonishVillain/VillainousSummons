package com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2;

import com.cartoonishvillain.villainoussummon.Entities.Projectiles.TurretArrow;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
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

import java.util.Random;

public class PotionArrowTurretMk2 extends BaseTurretsMK2 implements RangedAttackMob {

    public PotionArrowTurretMk2(EntityType<? extends AbstractGolem> p_i50244_1_, Level p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_, turretTypeMK2.POTIONARROW);
    }


    public static AttributeSupplier.Builder customAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 50D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }

    @Override
    public void push(Entity p_70108_1_) {
        super.push(p_70108_1_);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 40, 40));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Monster.class, 10, true, false, ATTACK_PREDICATE));
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        if(p_82196_1_ != null && p_82196_1_.isAlive()){
        TurretArrow arrowEntity = new TurretArrow(this.level, this);
        Random random = new Random();
        int potionchecker = random.nextInt(6);
        switch (potionchecker){
            case 2:
                arrowEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 25*20, 0));
                break;
            case 3:
                arrowEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 25*20, 0));
                break;
            case 4:
                if(p_82196_1_.isInvertedHealAndHarm()){arrowEntity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));}
                else arrowEntity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));
                break;
            default:
                arrowEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25*20, 1));
        }
        double initheight = p_82196_1_.getEyeY() - 1.1f;
        double x = p_82196_1_.getX() - this.getX();
        double y = initheight - arrowEntity.getY();
        double z = p_82196_1_.getZ() - this.getZ();
        float f = Mth.sqrt((float) (x * x + z * z))*0.2f;
        this.playSound(SoundEvents.SPLASH_POTION_BREAK, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        this.level.addFreshEntity(arrowEntity);
        arrowEntity.shoot(x, y+f, z, 1.6f, 2.0f);}
    }
}

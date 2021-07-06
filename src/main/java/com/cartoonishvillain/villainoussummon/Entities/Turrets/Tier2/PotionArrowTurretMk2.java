package com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2;

import com.cartoonishvillain.villainoussummon.Entities.Projectiles.TurretArrow;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.turretTypeMK1;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class PotionArrowTurretMk2 extends BaseTurretsMK2 implements IRangedAttackMob {

    public PotionArrowTurretMk2(EntityType<? extends GolemEntity> p_i50244_1_, World p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_, turretTypeMK1.ARROW);
    }


    public static AttributeModifierMap.MutableAttribute customAttributes(){
        return MobEntity.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 50D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }

    @Override
    public void push(Entity p_70108_1_) {
        super.push(p_70108_1_);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 40, 40));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 10, true, false, ATTACK_PREDICATE));
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        if(p_82196_1_ != null && p_82196_1_.isAlive()){
        TurretArrow arrowEntity = new TurretArrow(this.level, this);
        Random random = new Random();
        int potionchecker = random.nextInt(6);
        switch (potionchecker){
            case 2:
                arrowEntity.addEffect(new EffectInstance(Effects.POISON, 25*20, 0));
                break;
            case 3:
                arrowEntity.addEffect(new EffectInstance(Effects.WEAKNESS, 25*20, 0));
                break;
            case 4:
                if(p_82196_1_.isInvertedHealAndHarm()){arrowEntity.addEffect(new EffectInstance(Effects.HEAL, 1, 0));}
                else arrowEntity.addEffect(new EffectInstance(Effects.HARM, 1, 0));
                break;
            default:
                arrowEntity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 25*20, 1));
        }
        double initheight = p_82196_1_.getEyeY() - 1.1f;
        double x = p_82196_1_.getX() - this.getX();
        double y = initheight - arrowEntity.getY();
        double z = p_82196_1_.getZ() - this.getZ();
        float f = MathHelper.sqrt(x * x + z * z)*0.2f;
        this.playSound(SoundEvents.DISPENSER_LAUNCH, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        this.level.addFreshEntity(arrowEntity);
        arrowEntity.shoot(x, y+f, z, 1.6f, 2.0f);}
    }
}

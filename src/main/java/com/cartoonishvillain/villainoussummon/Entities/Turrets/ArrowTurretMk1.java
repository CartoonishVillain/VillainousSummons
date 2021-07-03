package com.cartoonishvillain.villainoussummon.Entities.Turrets;

import com.cartoonishvillain.villainoussummon.Entities.Projectiles.TurretArrow;
import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class ArrowTurretMk1 extends BaseTurrets implements IRangedAttackMob {

    public ArrowTurretMk1(EntityType<? extends GolemEntity> p_i50244_1_, World p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_);
    }
    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return (entitytype != Register.VEXMINION.get() && !p_213440_0_.isDeadOrDying() && entitytype instanceof IMob);
    };

    public static AttributeModifierMap.MutableAttribute customAttributes(){
        return MobEntity.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 40D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }



    @Override
    public void tick() {
        super.tick();
        if(this.hasEffect(Effects.POISON)){removeEffect(Effects.POISON);}
        if(this.hasEffect(Effects.WITHER)){removeEffect(Effects.WITHER);}
        if(this.getTarget() != null && !this.getTarget().isAlive()){this.setTarget(null);}
    }

    @Override
    public void push(Entity p_70108_1_) {
        super.push(p_70108_1_);
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MobEntity.class, 10, true, false, (p_213621_0_) -> {return p_213621_0_ instanceof IMob;}));
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        if(p_82196_1_ != null && p_82196_1_.isAlive()){
        TurretArrow arrowEntity = new TurretArrow(this.level, this);
        double initheight = p_82196_1_.getEyeY() - 1.1f;
        double x = p_82196_1_.getX() - this.getX();
        double y = initheight - arrowEntity.getY();
        double z = p_82196_1_.getZ() - this.getZ();
        float f = MathHelper.sqrt(x * x + z * z)*0.2f;
        arrowEntity.shoot(x, y+f, z, 1.6f, 12.0f);
        this.playSound(SoundEvents.DISPENSER_LAUNCH, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        this.level.addFreshEntity(arrowEntity);}

    }
}

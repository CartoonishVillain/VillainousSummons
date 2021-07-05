package com.cartoonishvillain.villainoussummon.Entities.Turrets;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import java.util.function.Predicate;

public abstract class BaseTurretsMK1 extends GolemEntity implements IRangedAttackMob {

    turretTypeMK1 type = null;

    protected BaseTurretsMK1(EntityType<? extends GolemEntity> p_i48569_1_, World p_i48569_2_, turretTypeMK1 type) {
        super(p_i48569_1_, p_i48569_2_);
        this.type = type;
    }


    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return (entitytype != Register.VEXMINION.get() && !p_213440_0_.isDeadOrDying());
    };

    //They strangely could be leashed otherwise..
    @Override
    public boolean canBeLeashed(PlayerEntity p_184652_1_) {
        return false;
    }

    //A bit hacky, but stops turrets from being pushed when they probably shouldn't be.
    @Override
    public boolean isVehicle() {return true;}


    //Made out of stone and iron. Fireproof.
    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 10, true, false, ATTACK_PREDICATE));
    }

    @Override
    public void tick() {
        super.tick();
        if(this.hasEffect(Effects.POISON)){removeEffect(Effects.POISON);}
        if(this.hasEffect(Effects.WITHER)){removeEffect(Effects.WITHER);}
        if(this.getTarget() != null && !this.getTarget().isAlive()){this.setTarget(null);}
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {

    }

    public turretTypeMK1 getTurretType(){
        return type;
    }
}

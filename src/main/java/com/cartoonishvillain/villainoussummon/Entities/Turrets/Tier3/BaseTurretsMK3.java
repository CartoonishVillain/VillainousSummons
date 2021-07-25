package com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3;

import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.turretTypeMK1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.BaseTurretsMK2;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.turretTypeMK2;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.TurretTemplate;
import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public abstract class BaseTurretsMK3 extends TurretTemplate implements RangedAttackMob {

    turretTypeMK3 type = null;

    protected BaseTurretsMK3(EntityType<? extends AbstractGolem> p_i48569_1_, Level p_i48569_2_, turretTypeMK3 type) {
        super(p_i48569_1_, p_i48569_2_);
        this.type = type;
    }


    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return (entitytype != Register.VEXMINION.get() && !p_213440_0_.isDeadOrDying());
    };



    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 12, 12));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Monster.class, 15, true, false, ATTACK_PREDICATE));
    }


    public turretTypeMK3 getTurretType(){
        return type;
    }
}

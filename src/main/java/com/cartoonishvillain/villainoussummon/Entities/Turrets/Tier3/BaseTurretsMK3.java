package com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3;

import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.turretTypeMK1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.BaseTurretsMK2;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.TurretTemplate;
import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.world.World;

import java.util.function.Predicate;

//TODO: Switch to turret template when models are available. This is simply done to make life easier.
public abstract class BaseTurretsMK3 extends BaseTurretsMK2 implements IRangedAttackMob {

    turretTypeMK1 type = null;

    protected BaseTurretsMK3(EntityType<? extends GolemEntity> p_i48569_1_, World p_i48569_2_, turretTypeMK1 type) {
        //TODO: When the above is done, remove type here and uncomment the commeted line below.
        super(p_i48569_1_, p_i48569_2_, type);
        //this.type = type;
    }


    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return (entitytype != Register.VEXMINION.get() && !p_213440_0_.isDeadOrDying());
    };



    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 12, 12));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 15, true, false, ATTACK_PREDICATE));
    }


    public turretTypeMK1 getTurretType(){
        return type;
    }
}

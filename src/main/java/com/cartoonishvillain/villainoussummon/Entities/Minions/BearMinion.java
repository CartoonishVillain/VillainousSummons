package com.cartoonishvillain.villainoussummon.Entities.Minions;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;


import java.util.Set;
import java.util.function.Predicate;

import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

public class BearMinion extends PolarBear {
    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return entitytype != Register.VEXMINION.get() && entitytype != EntityType.CREEPER;
    };

    @Override
    protected int getExperienceReward(Player p_70693_1_) {return 0;}

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D);
    }

    public BearMinion(EntityType<? extends PolarBear> p_i50249_1_, Level p_i50249_2_) {
        super(p_i50249_1_, p_i50249_2_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        Set<WrappedGoal> prioritizedGoals = ObfuscationReflectionHelper.getPrivateValue(GoalSelector.class, this.goalSelector, "f_25345_");
        if(prioritizedGoals != null) {
            for (WrappedGoal prioritizedGoal : prioritizedGoals) {
                this.targetSelector.removeGoal(prioritizedGoal);
            }
        }
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Monster.class, 10, true, false, ATTACK_PREDICATE));

    }

    @Override
    public void tick() {
        super.tick();
        if(tickCount >= 90*20) this.remove(RemovalReason.KILLED);
    }

}

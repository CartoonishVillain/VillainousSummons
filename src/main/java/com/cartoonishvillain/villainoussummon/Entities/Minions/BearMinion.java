package com.cartoonishvillain.villainoussummon.Entities.Minions;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.Set;
import java.util.function.Predicate;

public class BearMinion extends PolarBearEntity {
    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return entitytype != Register.VEXMINION.get() && entitytype != EntityType.CREEPER;
    };

    @Override
    protected int getExperienceReward(PlayerEntity p_70693_1_) {return 0;}

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D);
    }

    public BearMinion(EntityType<? extends PolarBearEntity> p_i50249_1_, World p_i50249_2_) {
        super(p_i50249_1_, p_i50249_2_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        Set<PrioritizedGoal> prioritizedGoals = ObfuscationReflectionHelper.getPrivateValue(GoalSelector.class, this.goalSelector, "field_220892_d");
        if(prioritizedGoals != null) {
            for (PrioritizedGoal prioritizedGoal : prioritizedGoals) {
                this.targetSelector.removeGoal(prioritizedGoal);
            }
        }
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 10, true, false, ATTACK_PREDICATE));

    }

    @Override
    public void tick() {
        super.tick();
        if(tickCount >= 90*20) this.remove();
    }

}

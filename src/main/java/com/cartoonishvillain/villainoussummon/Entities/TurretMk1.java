package com.cartoonishvillain.villainoussummon.Entities;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class TurretMk1 extends GolemEntity implements IRangedAttackMob {
    public TurretMk1(EntityType<? extends GolemEntity> p_i50244_1_, World p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_);
    }
    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return entitytype != Register.VEXMINION.get();
    };

    public static AttributeModifierMap.MutableAttribute customAttributes(){
        return MobEntity.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 20D).add(Attributes.MOVEMENT_SPEED, 0.0d);
    }

    @Override
    public boolean canBeLeashed(PlayerEntity p_184652_1_) {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean canCollideWith(Entity p_241849_1_) {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(Entity p_82167_1_) {
    }

    @Override
    public void push(Entity p_70108_1_) {
        super.push(p_70108_1_);
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10f));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 10, true, false, ATTACK_PREDICATE));
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        ArrowEntity arrowEntity = new ArrowEntity(this.level, this);
        double initheight = p_82196_1_.getEyeY() - 1.1f;
        double x = p_82196_1_.getX() - this.getX();
        double y = initheight - arrowEntity.getY();
        double z = p_82196_1_.getZ() - this.getZ();
        float f = MathHelper.sqrt(x * x + z * z)*0.2f;
        arrowEntity.shoot(x, y+f, z, 1.6f, 12.0f);
        this.playSound(SoundEvents.DISPENSER_LAUNCH, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        this.level.addFreshEntity(arrowEntity);

    }
}

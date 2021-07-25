package com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier4;

import com.cartoonishvillain.villainoussummon.Entities.Projectiles.BallistaArrow;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.BaseTurretsMK3;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.turretTypeMK3;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
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

public class RapidArrowTurretMk4 extends BaseTurretsMK3 implements RangedAttackMob {

    public RapidArrowTurretMk4(EntityType<? extends AbstractGolem> p_i50244_1_, Level p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_, turretTypeMK3.CREATIVE);
    }


    public static AttributeSupplier.Builder customAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 1D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }

    @Override
    public void push(Entity p_70108_1_) {
        super.push(p_70108_1_);
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 1, 1));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Monster.class, 10, true, false, ATTACK_PREDICATE));
    }


    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        if(p_82196_1_ != null && p_82196_1_.isAlive()){
            BallistaArrow arrowEntity = new BallistaArrow(this.level, this);
            double initheight = p_82196_1_.getEyeY() - 1.1f;
            double x = p_82196_1_.getX() - this.getX();
            double y = initheight - arrowEntity.getY();
            double z = p_82196_1_.getZ() - this.getZ();
            float f = Mth.sqrt((float) (x * x + z * z))*0.2f;
            this.playSound(SoundEvents.DISPENSER_LAUNCH, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            this.level.addFreshEntity(arrowEntity);
            arrowEntity.shoot(x, y+f, z, 1.6f, 5);}
    }
}

package com.cartoonishvillain.villainoussummon.Entities.Turrets;

import com.cartoonishvillain.villainoussummon.Entities.Projectiles.SlimeballProjectile;
import com.cartoonishvillain.villainoussummon.Entities.Projectiles.TurretArrow;
import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class SlimeTurretMk1 extends BaseTurretsMK1 implements IRangedAttackMob {

    public SlimeTurretMk1(EntityType<? extends GolemEntity> p_i50244_1_, World p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_, turretTypeMK1.SLIME);
    }


    public static AttributeModifierMap.MutableAttribute customAttributes(){
        return MobEntity.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 40D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }

    @Override
    public void push(Entity p_70108_1_) {
        super.push(p_70108_1_);
    }

    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return (entitytype != Register.VEXMINION.get() && !p_213440_0_.isDeadOrDying() && !p_213440_0_.hasEffect(Effects.MOVEMENT_SLOWDOWN));
    };


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 10, true, false, ATTACK_PREDICATE));
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        if(p_82196_1_ != null && p_82196_1_.isAlive() && !p_82196_1_.hasEffect(Effects.MOVEMENT_SLOWDOWN)){
            SlimeballProjectile projectileItemEntity = new SlimeballProjectile(Register.SLIMEPROJECTILE.get(), this, this.level);
            double initheight = p_82196_1_.getEyeY() - 1.1f;
            double x = p_82196_1_.getX() - this.getX();
            double y = initheight - projectileItemEntity.getY();
            double z = p_82196_1_.getZ() - this.getZ();
            float f = MathHelper.sqrt(x * x + z * z)*0.2f;
            this.playSound(SoundEvents.SLIME_BLOCK_PLACE, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            projectileItemEntity.setPos(this.getX(), this.getEyeY(), this.getZ());
            projectileItemEntity.setOwner(this);
            this.level.addFreshEntity(projectileItemEntity);
            projectileItemEntity.shoot(x, y+f, z, 1.6f, 2);}
        else if(p_82196_1_.hasEffect(Effects.MOVEMENT_SLOWDOWN)){this.setTarget(null);}
    }
}

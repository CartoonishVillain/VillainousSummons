package com.cartoonishvillain.villainoussummon.Entities.Turrets;

import com.cartoonishvillain.villainoussummon.Entities.Projectiles.TurretArrow;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class FireArrowTurretMk1 extends ArrowTurretMk1 implements IRangedAttackMob {
    public FireArrowTurretMk1(EntityType<? extends GolemEntity> p_i50244_1_, World p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_);
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        if(p_82196_1_ != null && p_82196_1_.isAlive()){
            TurretArrow arrowEntity = new TurretArrow(this.level, this, 100);
            double initheight = p_82196_1_.getEyeY() - 1.1f;
            double x = p_82196_1_.getX() - this.getX();
            double y = initheight - arrowEntity.getY();
            double z = p_82196_1_.getZ() - this.getZ();
            float f = MathHelper.sqrt(x * x + z * z)*0.2f;
            arrowEntity.shoot(x, y+f, z, 1.6f, 12.0f);
            this.playSound(SoundEvents.DISPENSER_LAUNCH, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            this.level.addFreshEntity(arrowEntity);}

    }

    public static AttributeModifierMap.MutableAttribute customAttributes(){
        return MobEntity.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 20D).add(Attributes.MAX_HEALTH, 40D).add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.ARMOR, 5);
    }

}

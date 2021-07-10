package com.cartoonishvillain.villainoussummon.Entities.Turrets;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class TurretTemplate extends GolemEntity implements IRangedAttackMob {

    protected TurretTemplate(EntityType<? extends GolemEntity> p_i48569_1_, World p_i48569_2_) {
        super(p_i48569_1_, p_i48569_2_);
    }

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
    protected float getJumpPower() {
        return 0;
    }

    //turrets aren't technically alive despite them being a living entity...
    //as such poison and wither shouldn't really have an effect on them.
    @Override
    public void tick() {
        super.tick();
        if(this.hasEffect(Effects.POISON)){removeEffect(Effects.POISON);}
        if(this.hasEffect(Effects.WITHER)){removeEffect(Effects.WITHER);}
        //this line is just because of some targeting badness with the AI I encountered sometimes. (Would fire at dead targets if nothing else was around to fire at.)
        if(this.getTarget() != null && !this.getTarget().isAlive()){this.setTarget(null);}
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.ANVIL_LAND;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ANVIL_DESTROY;
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {

    }
}

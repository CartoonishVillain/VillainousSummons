package com.cartoonishvillain.villainoussummon.Entities.Turrets;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public abstract class TurretTemplate extends AbstractGolem implements RangedAttackMob {

    protected TurretTemplate(EntityType<? extends AbstractGolem> p_i48569_1_, Level p_i48569_2_) {
        super(p_i48569_1_, p_i48569_2_);
    }

    //They strangely could be leashed otherwise..
    @Override
    public boolean canBeLeashed(Player p_184652_1_) {
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
        if(this.hasEffect(MobEffects.POISON)){removeEffect(MobEffects.POISON);}
        if(this.hasEffect(MobEffects.WITHER)){removeEffect(MobEffects.WITHER);}
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

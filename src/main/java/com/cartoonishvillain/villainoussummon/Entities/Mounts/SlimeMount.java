package com.cartoonishvillain.villainoussummon.Entities.Mounts;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class SlimeMount extends Horse{
    boolean falling = false;
    double prev_y = 0.0f;

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.155D)
                .add(Attributes.JUMP_STRENGTH, 1.55D);
    }


    @Override
    protected void registerGoals() {

    }

    public SlimeMount(EntityType<? extends Horse> type, Level world) {
        super(type, world);
    }



    @Override
    protected void randomizeAttributes() { // cancel
    }

    @Override
    public ItemStack getArmor() {return super.getArmor();}

    @Override
    protected void playGallopSound(SoundType p_190680_1_) {} // no.

    @Override
    public boolean canMate(Animal p_70878_1_) {return false;}

    @Override
    public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {return InteractionResult.PASS;}

    @Override
    public boolean canWearArmor() {return false;}

    @Override
    public InteractionResult fedFood(Player p_241395_1_, ItemStack p_241395_2_) {return  InteractionResult.SUCCESS;}

    @Override
    protected void followMommy() {}

    @Override
    public boolean canEatGrass() {return false;}

    @Override
    public void setEating(boolean p_110227_1_) {this.setFlag(16, false);}

    @Override
    public void makeMad() {}

    @Override
    public boolean canBeControlledByRider() {
        return true;
    }

    @Override
    public boolean isSaddled() {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void onPlayerJump(int p_110206_1_) {
        if (p_110206_1_ < 0) {
            p_110206_1_ = 0;
        }
        this.playerJumpPendingScale = 1.0F;
    }

    @Override
    public boolean canJump() {return true;}

    @Override
    public void openInventory(Player p_110199_1_) {}

    @Override
    public void positionRider(Entity p_184232_1_) {
        if (p_184232_1_ instanceof Mob) {
            Mob mobentity = (Mob)p_184232_1_;
            this.yBodyRot = mobentity.yBodyRot;
        }

//            float f3 = MathHelper.sin(this.yBodyRot * ((float)Math.PI / 180F));
//            float f = MathHelper.cos(this.yBodyRot * ((float)Math.PI / 180F));
//            float f1 = 0.7F;
//            float f2 = 0.15F;
            p_184232_1_.setPos(this.getX(), this.getY()+0.5, this.getZ());
//            p_184232_1_.setPos(this.getX() + (double)(f1 * f3), this.getY() + this.getPassengersRidingOffset() + p_184232_1_.getMyRidingOffset() + (double)f2, this.getZ() - (double)(f1 * f));
            if (p_184232_1_ instanceof LivingEntity) {
                ((LivingEntity)p_184232_1_).yBodyRot = this.yBodyRot;
            }

    }

    @Override
    protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
        return Mth.ceil((p_225508_1_ * 0.5F - 10.5F) * p_225508_2_);}

    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_149533_, AgeableMob p_149534_) {
        return null;
    }

    @Override
    public boolean causeFallDamage(float p_149499_, float p_149500_, DamageSource p_149501_) {
        if (p_149499_ > 1.0F) {
            this.playSound(SoundEvents.SLIME_SQUISH, 0.4F, 1.0F);
        }
        int i = this.calculateFallDamage(p_149499_, p_149500_);
        if (i <= 0) {
            return false;
        } else {
            if (this.isVehicle()) {
                for(Entity entity : this.getIndirectPassengers()) {
                    entity.hurt(DamageSource.FALL, (float)i/2);
                }
            }

            this.playBlockFallSound();
            return true;
        }
    }

    @Override
    protected boolean isImmobile() {return false;}

    @Override
    public float getEatAnim(float p_110258_1_) {return 0;}

    @Override
    public float getStandAnim(float p_110223_1_) {return 0;}

    @Override
    public float getMouthAnim(float p_110201_1_) {return 0;}

    @Override
    protected void removePassenger(Entity p_184225_1_) {
        super.removePassenger(p_184225_1_);
        this.remove(false);
    }

    @Override
    public boolean isInvulnerable() {return true;}

    @Override
    public void tick() {
        super.tick();


        if (tickCount % 100 == 0) {if (this.getControllingPassenger() == null) this.remove(false);}

//        if(!this.level.isClientSide()){
            falling = this.getY() < prev_y;
            prev_y = this.getY();
//    }

        if(this.isVehicle() && !this.onGround && falling){
            ArrayList<Entity> entities = (ArrayList<Entity>) this.level.getEntities(this, new AABB(this.getX()-1, this.getY(), this.getZ()-1, this.getX()+1, this.getY()-1, this.getZ()+1));
            boolean bounceOnEntity = false;
            Entity remove = null;


            for(Entity entity : entities){
                if(entity.equals(this.getControllingPassenger())){remove = entity;}
                else{
                    if(!(entity instanceof Slime || entity instanceof ItemEntity) && entity.isAlive())
                        bounceOnEntity = true;
                }
            }

            if(remove != null) entities.remove(remove);


            if(!level.isClientSide()) {
                for (Entity entity : entities) {
                    if (!(entity instanceof Slime || entity instanceof ItemEntity) && entity.isAlive())
                        entity.hurt(DamageSource.CRAMMING, 4);
                }
            }

            if(this.getControllingPassenger() instanceof Player && bounceOnEntity ) { // && !this.level.isClientSide()
                Vec3 vector3d = getDeltaMovement();
                this.setDeltaMovement(0, 1.5, 0);
                this.fallDistance = 0;
                if(!this.level.isClientSide()){
                    level.playSound(null, getX(), getY(), getZ(), SoundEvents.SLIME_ATTACK, SoundSource.NEUTRAL, 100, 1);
                }
            }
        }
    }

    @Override
    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        if(tickCount % 20 == 0 && !level.isClientSide()){
            level.playSound(null, p_180429_1_, SoundEvents.SLIME_JUMP, SoundSource.NEUTRAL, 100, 1);
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.SLIME_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SLIME_DEATH;
    }

    @Override
    protected SoundEvent getAngrySound() {
        return SoundEvents.SLIME_HURT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SLIME_SQUISH;
    }

    @Override
    protected void playJumpSound() {
        if(!level.isClientSide() && this.onGround){
            level.playSound(null, getX(), getY(), getZ(), SoundEvents.SLIME_JUMP, SoundSource.NEUTRAL, 100, 1);
        }
    }

    // /effect give @e minecraft:instant_health 100 100
}

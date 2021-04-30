package com.example.examplemod.Entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Vector;

public class SlimeMount extends HorseEntity{
    boolean falling = false;
    double prev_y = 0.0f;

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.15D)
                .add(Attributes.JUMP_STRENGTH, 1.55D);
    }


    @Override
    protected void registerGoals() {

    }

    public SlimeMount(EntityType<? extends HorseEntity> type, World world) {
        super(type, world);
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {return null;} // nope


    @Override
    protected void randomizeAttributes() { // cancel
    }

    @Override
    public ItemStack getArmor() {return super.getArmor();}

    @Override
    protected void playGallopSound(SoundType p_190680_1_) {} // no.

    @Override
    public boolean canMate(AnimalEntity p_70878_1_) {return false;}

    @Override
    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {return ActionResultType.PASS;}

    @Override
    public boolean canWearArmor() {return false;}

    @Override
    public ActionResultType fedFood(PlayerEntity p_241395_1_, ItemStack p_241395_2_) {return  ActionResultType.SUCCESS;}

    @Override
    protected void followMommy() {}

    @Override
    public boolean canEatGrass() {return false;}

    @Override
    public void setEating(boolean p_110227_1_) {this.setFlag(16, false);}

    @Override
    public void makeMad() {}

    @Override
    public void travel(Vector3d p_213352_1_) {
        if (this.isAlive()) {
            if (this.isVehicle() && this.canBeControlledByRider()) {
                LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
                this.yRot = livingentity.yRot;
                this.yRotO = this.yRot;
                this.xRot = livingentity.xRot * 0.5F;
                this.setRot(this.yRot, this.xRot);
                this.yBodyRot = this.yRot;
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                    this.gallopSoundCounter = 0;
                }

                if (this.onGround && this.playerJumpPendingScale == 0.0F && this.isStanding()) {
                    f = 0.0F;
                    f1 = 0.0F;
                }

                if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround) {
                    double d0 = this.getCustomJump() * (double)this.playerJumpPendingScale * (double)this.getBlockJumpFactor();
                    double d1;
                    if (this.hasEffect(Effects.JUMP)) {
                        d1 = d0 + (double)((float)(this.getEffect(Effects.JUMP).getAmplifier() + 1) * 0.1F);
                    } else {
                        d1 = d0;
                    }

                    Vector3d vector3d = this.getDeltaMovement();
                    this.setDeltaMovement(vector3d.x, d1, vector3d.z);
                    this.setIsJumping(true);
                    this.hasImpulse = true;
                    net.minecraftforge.common.ForgeHooks.onLivingJump(this);
                    if (f1 > 0.0F) {
                        float f2 = MathHelper.sin(this.yRot * ((float)Math.PI / 180F));
                        float f3 = MathHelper.cos(this.yRot * ((float)Math.PI / 180F));
                        this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double)(0.4F * f3 * this.playerJumpPendingScale)));
                    }

                    this.playerJumpPendingScale = 0.0F;
                }

                this.flyingSpeed = this.getSpeed() * 0.1F;
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vector3d((double)f, p_213352_1_.y, (double)f1));
                } else if (livingentity instanceof PlayerEntity) {
                    this.setDeltaMovement(Vector3d.ZERO);
                }

                if (this.onGround) {
                    this.playerJumpPendingScale = 0.0F;
                    this.setIsJumping(false);
                }

                this.calculateEntityAnimation(this, false);
            } else {
                this.flyingSpeed = 0.02F;
                super.travel(p_213352_1_);
            }
        }
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
    public void openInventory(PlayerEntity p_110199_1_) {}

    @Override
    public void positionRider(Entity p_184232_1_) {
        if (p_184232_1_ instanceof MobEntity) {
            MobEntity mobentity = (MobEntity)p_184232_1_;
            this.yBodyRot = mobentity.yBodyRot;
        }

//            float f3 = MathHelper.sin(this.yBodyRot * ((float)Math.PI / 180F));
//            float f = MathHelper.cos(this.yBodyRot * ((float)Math.PI / 180F));
//            float f1 = 0.7F;
//            float f2 = 0.15F;
            p_184232_1_.setPos(this.getX(), this.getY(), this.getZ());
//            p_184232_1_.setPos(this.getX() + (double)(f1 * f3), this.getY() + this.getPassengersRidingOffset() + p_184232_1_.getMyRidingOffset() + (double)f2, this.getZ() - (double)(f1 * f));
            if (p_184232_1_ instanceof LivingEntity) {
                ((LivingEntity)p_184232_1_).yBodyRot = this.yBodyRot;
            }

    }

    @Override
    protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
        return MathHelper.ceil((p_225508_1_ * 0.5F - 10.5F) * p_225508_2_);}

    @Override
    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        if (p_225503_1_ > 1.0F) {
            this.playSound(SoundEvents.SLIME_SQUISH, 0.4F, 1.0F);
        }
        int i = this.calculateFallDamage(p_225503_1_, p_225503_2_);
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
        this.remove();
    }

    @Override
    public boolean isInvulnerable() {return true;}

    @Override
    public void tick() {
        super.tick();

        if (tickCount % 100 == 0) {if (this.getControllingPassenger() == null) this.remove();}

//        if(!this.level.isClientSide()){
            falling = this.getY() < prev_y;
            prev_y = this.getY();
//    }

        if(this.isVehicle() && !this.onGround && falling){
            ArrayList<Entity> entities = (ArrayList<Entity>) this.level.getEntities(this, new AxisAlignedBB(this.getX()-1, this.getY(), this.getZ()-1, this.getX()+1, this.getY()-1, this.getZ()+1));
            boolean bounceOnEntity = false;
            Entity remove = null;


            for(Entity entity : entities){
                if(entity.equals(this.getControllingPassenger())){remove = entity;}
                else{
                    if(!(entity instanceof SlimeEntity || entity instanceof ItemEntity) && entity.isAlive())
                        bounceOnEntity = true;
                }
            }

            if(remove != null) entities.remove(remove);


            if(!level.isClientSide()) {
                for (Entity entity : entities) {
                    if (!(entity instanceof SlimeEntity || entity instanceof ItemEntity) && entity.isAlive())
                        entity.hurt(DamageSource.CRAMMING, 4);
                }
            }

            if(this.getControllingPassenger() instanceof PlayerEntity && bounceOnEntity) {
                Vector3d vector3d = getDeltaMovement();
                this.setDeltaMovement(0, 1.5, 0);
                this.fallDistance = 0;
                if(!this.level.isClientSide()){
                    level.playSound(null, getX(), getY(), getZ(), SoundEvents.SLIME_ATTACK, SoundCategory.NEUTRAL, 100, 1);
                }
            }
        }
    }

    @Override
    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        if(tickCount % 20 == 0 && !level.isClientSide()){
            level.playSound(null, p_180429_1_, SoundEvents.SLIME_JUMP, SoundCategory.NEUTRAL, 100, 1);
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
            level.playSound(null, getX(), getY(), getZ(), SoundEvents.SLIME_JUMP, SoundCategory.NEUTRAL, 100, 1);
        }
    }

    // /effect give @e minecraft:instant_health 100 100
}

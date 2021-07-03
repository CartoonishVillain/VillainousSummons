package com.cartoonishvillain.villainoussummon.Entities.Minions;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.function.Predicate;

public class VexMinion extends VexEntity {
    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return entitytype != Register.VEXMINION.get() && entitytype != EntityType.CREEPER;
    };

    @Override
    protected boolean shouldDespawnInPeaceful() {return false;}

    public VexMinion(EntityType<? extends VexEntity> p_i50190_1_, World p_i50190_2_) {
        super(p_i50190_1_, p_i50190_2_);
        this.xpReward = 0;
    }


    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 14.0D).add(Attributes.ATTACK_DAMAGE, 4.0D);

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(4, new VexMinion.ChargeAttackGoal());
        this.goalSelector.addGoal(8, new VexMinion.MoveRandomGoal());
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 16, true, false,  ATTACK_PREDICATE));
    }

    @Override
    public void tick() {
        super.tick();
        if(tickCount >= 60*20) this.remove();

    }

    /*
    These goals and functions are from mojang using their official mappings.
    I just needed to access them here.
     */

    class MoveRandomGoal extends Goal {
        public MoveRandomGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return !VexMinion.this.getMoveControl().hasWanted() && VexMinion.this.random.nextInt(7) == 0;
        }

        public boolean canContinueToUse() {
            return false;
        }

        public void tick() {
            BlockPos blockpos = VexMinion.this.getBoundOrigin();
            if (blockpos == null) {
                blockpos = VexMinion.this.blockPosition();
            }

            for(int i = 0; i < 3; ++i) {
                BlockPos blockpos1 = blockpos.offset(VexMinion.this.random.nextInt(15) - 7, VexMinion.this.random.nextInt(11) - 5, VexMinion.this.random.nextInt(15) - 7);
                if (VexMinion.this.level.isEmptyBlock(blockpos1)) {
                    VexMinion.this.moveControl.setWantedPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);
                    if (VexMinion.this.getTarget() == null) {
                        VexMinion.this.getLookControl().setLookAt((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
                    }
                    break;
                }
            }

        }
    }

    class ChargeAttackGoal extends Goal {
        public ChargeAttackGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            if (VexMinion.this.getTarget() != null && !VexMinion.this.getMoveControl().hasWanted() && VexMinion.this.random.nextInt(7) == 0) {
                return VexMinion.this.distanceToSqr(VexMinion.this.getTarget()) > 4.0D;
            } else {
                return false;
            }
        }

        public boolean canContinueToUse() {
            return VexMinion.this.getMoveControl().hasWanted() && VexMinion.this.isCharging() && VexMinion.this.getTarget() != null && VexMinion.this.getTarget().isAlive();
        }

        public void start() {
            LivingEntity livingentity = VexMinion.this.getTarget();
            Vector3d vector3d = livingentity.getEyePosition(1.0F);
            VexMinion.this.moveControl.setWantedPosition(vector3d.x, vector3d.y, vector3d.z, 1.0D);
            VexMinion.this.setIsCharging(true);
            VexMinion.this.playSound(SoundEvents.VEX_CHARGE, 1.0F, 1.0F);
        }

        public void stop() {
            VexMinion.this.setIsCharging(false);
        }

        public void tick() {
            LivingEntity livingentity = VexMinion.this.getTarget();
            if (VexMinion.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                VexMinion.this.doHurtTarget(livingentity);
                VexMinion.this.setIsCharging(false);
            } else {
                double d0 = VexMinion.this.distanceToSqr(livingentity);
                if (d0 < 9.0D) {
                    Vector3d vector3d = livingentity.getEyePosition(1.0F);
                    VexMinion.this.moveControl.setWantedPosition(vector3d.x, vector3d.y, vector3d.z, 1.0D);
                }
            }

        }
    }
}

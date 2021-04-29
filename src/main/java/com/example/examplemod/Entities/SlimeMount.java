package com.example.examplemod.Entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class SlimeMount extends HorseEntity implements IJumpingMount, IRideable {

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 1D)
    }



    public SlimeMount(EntityType<? extends HorseEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void onPlayerJump(int p_110206_1_) {
        double d1 = 10;
        Vector3d vector3d = this.getDeltaMovement();
        this.setDeltaMovement(vector3d.x, d1, vector3d.z);
    }



    @Override
    public boolean canJump() {
        return !getCommandSenderWorld().isClientSide() && this.onGround;
    }

    @Override
    public void handleStartJump(int p_184775_1_) {

    }

    @Override
    public void handleStopJump() {

    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    @Override
    public boolean boost() {
        return false;
    }

    @Override
    public void travelWithInput(Vector3d p_230267_1_) {
        super.travel(p_230267_1_);
    }

    @Override
    public float getSteeringSpeed() {
        return 0;
    }

    @Override
    protected void randomizeAttributes() { // cancel
    }
}

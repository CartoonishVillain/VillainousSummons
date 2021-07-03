package com.cartoonishvillain.villainoussummon.Entities.Turrets;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class BaseTurrets extends GolemEntity {
    protected BaseTurrets(EntityType<? extends GolemEntity> p_i48569_1_, World p_i48569_2_) {
        super(p_i48569_1_, p_i48569_2_);
    }

    //They strangely could be leashed otherwise..
    @Override
    public boolean canBeLeashed(PlayerEntity p_184652_1_) {
        return false;
    }

    //TODO: Check if this is needed, otherwise remove.
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    //TODO: Check if this is needed, otherwise remove.
    @Override
    public boolean canCollideWith(Entity p_241849_1_) {
        return false;
    }

    //TODO: Check if this is needed, otherwise remove.
    @Override
    public boolean isPushable() {
        return false;
    }

    //Allows doPush to run without allowing turrets to be pushed.
    @Override
    public boolean isVehicle() {return true;}

    //Pushes.
    @Override
    protected void doPush(Entity p_82167_1_) {
        this.push(p_82167_1_);
    }

    //Made out of stone and iron. Fireproof.
    @Override
    public boolean fireImmune() {
        return true;
    }
}

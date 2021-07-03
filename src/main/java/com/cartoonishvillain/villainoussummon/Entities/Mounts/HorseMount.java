package com.cartoonishvillain.villainoussummon.Entities.Mounts;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class HorseMount extends HorseEntity{

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 22D)
                .add(Attributes.MOVEMENT_SPEED, 0.225D)
                .add(Attributes.JUMP_STRENGTH, 0.7D);
    }


    @Override
    protected void registerGoals() {

    }

    public HorseMount(EntityType<? extends HorseEntity> type, World world) {super(type, world); this.equipSaddle(SoundCategory.NEUTRAL);}

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {return null;} // nope


    @Override
    protected void randomizeAttributes() { // cancel
    }

    @Override
    public ItemStack getArmor() {return super.getArmor();}

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
    public boolean canJump() {return true;}

    @Override
    public void openInventory(PlayerEntity p_110199_1_) {}

    @Override
    protected boolean isImmobile() {return false;}

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
    }


    // /effect give @e minecraft:instant_health 100 100
}

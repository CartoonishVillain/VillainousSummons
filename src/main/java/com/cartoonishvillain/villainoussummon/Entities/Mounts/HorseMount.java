package com.cartoonishvillain.villainoussummon.Entities.Mounts;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HorseMount extends Horse{

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 22D)
                .add(Attributes.MOVEMENT_SPEED, 0.225D)
                .add(Attributes.JUMP_STRENGTH, 0.7D);
    }


    @Override
    protected void registerGoals() {

    }

    public HorseMount(EntityType<? extends Horse> type, Level world) {super(type, world); this.equipSaddle(SoundSource.NEUTRAL);}

    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_149533_, AgeableMob p_149534_) {
        return null;
    }

    @Override
    protected void randomizeAttributes() { // cancel
    }

    @Override
    public ItemStack getArmor() {return super.getArmor();}

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
    public boolean canJump() {return true;}

    @Override
    public void openInventory(Player p_110199_1_) {}

    @Override
    protected boolean isImmobile() {return false;}

    @Override
    protected void removePassenger(Entity p_184225_1_) {
        super.removePassenger(p_184225_1_);
        this.remove(RemovalReason.KILLED);
    }

    @Override
    public boolean isInvulnerable() {return true;}

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 100 == 0) {if (this.getControllingPassenger() == null) this.remove(RemovalReason.KILLED);}
    }


    // /effect give @e minecraft:instant_health 100 100
}

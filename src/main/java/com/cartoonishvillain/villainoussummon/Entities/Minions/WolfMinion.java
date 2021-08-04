package com.cartoonishvillain.villainoussummon.Entities.Minions;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;

public class WolfMinion extends Wolf {

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 4.0D);

    }

    public WolfMinion(EntityType<? extends Wolf> p_i50240_1_, Level p_i50240_2_) {
        super(p_i50240_1_, p_i50240_2_);
    }

    @Override
    public boolean canBreed() {return false;}

    @Override
    public void tick() {
        super.tick();
        if(tickCount >= 120*20) this.remove(RemovalReason.KILLED);
    }
}

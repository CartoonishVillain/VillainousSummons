package com.example.examplemod.Entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.World;

public class WolfMinion extends WolfEntity {

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 4.0D);

    }

    public WolfMinion(EntityType<? extends WolfEntity> p_i50240_1_, World p_i50240_2_) {
        super(p_i50240_1_, p_i50240_2_);
    }

    @Override
    public boolean canBreed() {return false;}

    @Override
    public void tick() {
        super.tick();
        if(tickCount >= 120*20) this.remove();
    }
}

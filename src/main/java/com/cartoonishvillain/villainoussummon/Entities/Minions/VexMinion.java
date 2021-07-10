package com.cartoonishvillain.villainoussummon.Entities.Minions;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.Predicate;

public class VexMinion extends VexEntity {


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
        super.registerGoals();



    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount >= 60 * 20) this.remove();

    }
}

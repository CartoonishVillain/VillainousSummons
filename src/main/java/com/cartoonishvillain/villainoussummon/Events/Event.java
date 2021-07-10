package com.cartoonishvillain.villainoussummon.Events;

import com.cartoonishvillain.villainoussummon.Entities.Minions.BearMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.VexMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.WolfMinion;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.HorseMount;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.TurretTemplate;
import com.cartoonishvillain.villainoussummon.Register;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;

@Mod.EventBusSubscriber(modid = VillainousSummon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Event {
    @SubscribeEvent
    public static void summonmount(PlayerInteractEvent.RightClickItem event){
        Boolean success = false;
        if(!event.getWorld().isClientSide() && event.getEntityLiving() instanceof PlayerEntity && event.getPlayer() != null){
            if(event.getItemStack().getItem().equals(Register.SLIMESUMMON.get())){
            SlimeMount entity = new SlimeMount(Register.SLIMEMOUNT.get(), event.getWorld());
            entity.setPos(event.getPlayer().position().x, event.getPlayer().position().y, event.getPlayer().position().z);
            entity.setTamed(true);
            event.getWorld().addFreshEntity(entity);
            event.getPlayer().startRiding(entity);
            entity.playSound(SoundEvents.CHICKEN_EGG, 1.0f, 0);
            success = true;
            }
            else if(event.getItemStack().getItem().equals(Register.HORSESUMMON.get())){
                HorseMount entity = new HorseMount(Register.HORSEMOUNT.get(), event.getWorld());
                entity.setPos(event.getPlayer().position().x, event.getPlayer().position().y, event.getPlayer().position().z);
                entity.setTamed(true);
                event.getWorld().addFreshEntity(entity);
                event.getPlayer().startRiding(entity);
                entity.playSound(SoundEvents.CHICKEN_EGG, 1.0f, 0);
                success = true;
            }
            else if(event.getItemStack().getItem().equals(Register.WOLFSUMMON.get())){
                WolfMinion[] entities = new WolfMinion[] {new WolfMinion(Register.WOLFMINION.get(), event.getWorld()), new WolfMinion(Register.WOLFMINION.get(), event.getWorld()), new WolfMinion(Register.WOLFMINION.get(), event.getWorld())};
                for(WolfMinion entity : entities){
                    entity.setPos(event.getPlayer().position().x, event.getPlayer().position().y, event.getPlayer().position().z);
                    entity.tame(event.getPlayer());
                    event.getWorld().addFreshEntity(entity);
                    entity.playSound(SoundEvents.WOLF_HOWL, 1.0f, 1);
                    success = true;
                }
            }else if(event.getItemStack().getItem().equals(Register.VEXSUMMON.get())){
                VexMinion[] entities = new VexMinion[] {new VexMinion(Register.VEXMINION.get(), event.getWorld()), new VexMinion(Register.VEXMINION.get(), event.getWorld()), new VexMinion(Register.VEXMINION.get(), event.getWorld()), new VexMinion(Register.VEXMINION.get(), event.getWorld()), new VexMinion(Register.VEXMINION.get(), event.getWorld())};
                for(VexMinion entity : entities){
                    entity.setPos(event.getPlayer().position().x, event.getPlayer().position().y, event.getPlayer().position().z);
                    event.getWorld().addFreshEntity(entity);
                    success = true;
                }
                entities[1].playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1.0f, 1);

            }else if(event.getItemStack().getItem().equals(Register.BEARSUMMON.get())){
                    BearMinion entity = new BearMinion(Register.BEARMINION.get(), event.getWorld());
                    entity.setPos(event.getPlayer().position().x, event.getPlayer().position().y, event.getPlayer().position().z);
                    event.getWorld().addFreshEntity(entity);
                    success = true;
                entity.playSound(SoundEvents.POLAR_BEAR_WARNING, 1.0f, 1);
            }

            if(success){
                if(!event.getPlayer().isCreative()){
                    ItemStack stack = event.getItemStack();
                    if(stack.hurt(1, new Random(), null)) {
                        stack.shrink(1);
                        event.getWorld().playSound(null, event.getPos(), SoundEvents.ITEM_BREAK, SoundCategory.PLAYERS, 100, 1);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void clearMount(EntityJoinWorldEvent event){
        if(event.getEntity() instanceof PlayerEntity){
            PlayerEntity entity = (PlayerEntity) event.getEntity();
            entity.stopRiding();
        }
    }

    @SubscribeEvent
    public static void clearMount(EntityLeaveWorldEvent event){
        if(event.getEntity() instanceof PlayerEntity){
            PlayerEntity entity = (PlayerEntity) event.getEntity();
            entity.stopRiding();
        }
    }

    @SubscribeEvent
    public static void Resyncer(TickEvent.PlayerTickEvent event){
        PlayerEntity playerEntity = event.player;
        if(playerEntity.tickCount == 10){
            if(playerEntity.getVehicle() instanceof SlimeMount || playerEntity.getVehicle() instanceof HorseMount){
                playerEntity.stopRiding();
            }
        }
    }

    @SubscribeEvent
    public static void TurretTargeter(EntityJoinWorldEvent event){
        Entity sEntity = event.getEntity();
        if(sEntity instanceof MonsterEntity && !VillainousSummon.EXCEMPTFROMMODIFICATION.contains(sEntity.getType())){
            MonsterEntity entity = (MonsterEntity) sEntity;
            entity.targetSelector.addGoal(20, new NearestAttackableTargetGoal<>(entity, TurretTemplate.class, true));
        }
    }

    @SubscribeEvent
    public static void MinionTargetChanger(EntityJoinWorldEvent event){
        Entity sEntity = event.getEntity();
        if(sEntity instanceof VexMinion && !sEntity.level.isClientSide()){
            VexMinion entity = (VexMinion) sEntity;
            Set<PrioritizedGoal> prioritizedGoals = ObfuscationReflectionHelper.getPrivateValue(GoalSelector.class, entity.targetSelector, "field_220892_d");
            ArrayList<Goal> toRemove = new ArrayList<>();
            if(prioritizedGoals != null) {
                for (PrioritizedGoal prioritizedGoal : prioritizedGoals) {
                    toRemove.add(prioritizedGoal.getGoal());
                }
            }
            for(Goal goal : toRemove){
                entity.targetSelector.removeGoal(goal);
            }
            entity.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(entity, MonsterEntity.class, 16, true, false,  ATTACK_PREDICATE));
        }
        else if(sEntity instanceof BearMinion && !sEntity.level.isClientSide()){
            BearMinion entity = (BearMinion) sEntity;
            Set<PrioritizedGoal> prioritizedGoals = ObfuscationReflectionHelper.getPrivateValue(GoalSelector.class, entity.targetSelector, "field_220892_d");
            ArrayList<Goal> toRemove = new ArrayList<>();
            if(prioritizedGoals != null) {
                for (PrioritizedGoal prioritizedGoal : prioritizedGoals) {
                    toRemove.add(prioritizedGoal.getGoal());
                }
            }
            for(Goal goal : toRemove){
                entity.targetSelector.removeGoal(goal);
            }
            entity.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(entity, MonsterEntity.class, 16, true, false,  ATTACK_PREDICATE));
        }
    }

    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return entitytype != Register.VEXMINION.get() && entitytype != EntityType.CREEPER;
    };
}

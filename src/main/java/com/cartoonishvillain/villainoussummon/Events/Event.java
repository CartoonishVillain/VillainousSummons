package com.cartoonishvillain.villainoussummon.Events;

import com.cartoonishvillain.villainoussummon.Entities.Minions.BearMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.VexMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.WolfMinion;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.HorseMount;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.TurretTemplate;
import com.cartoonishvillain.villainoussummon.Register;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;

@Mod.EventBusSubscriber(modid = VillainousSummon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Event {
    @SubscribeEvent
    public static void summonmount(PlayerInteractEvent.RightClickItem event){
        Boolean success = false;
        if(!event.getWorld().isClientSide() && event.getEntityLiving() instanceof Player && event.getPlayer() != null){
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
                        event.getWorld().playSound(null, event.getPos(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 100, 1);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void clearMount(EntityJoinWorldEvent event){
        if(event.getEntity() instanceof Player){
            Player entity = (Player) event.getEntity();
            entity.stopRiding();
        }
    }

    @SubscribeEvent
    public static void clearMount(EntityLeaveWorldEvent event){
        if(event.getEntity() instanceof Player){
            Player entity = (Player) event.getEntity();
            entity.stopRiding();
        }
    }

    @SubscribeEvent
    public static void Resyncer(TickEvent.PlayerTickEvent event){
        Player playerEntity = event.player;
        if(playerEntity.tickCount == 10){
            if(playerEntity.getVehicle() instanceof SlimeMount || playerEntity.getVehicle() instanceof HorseMount){
                if(!playerEntity.isCreative() && !playerEntity.isSpectator()){playerEntity.getAbilities().mayfly = false;}
                playerEntity.stopRiding();
            }
        }
    }

    @SubscribeEvent
    public static void TurretTargeter(EntityJoinWorldEvent event){
        Entity sEntity = event.getEntity();
        if(sEntity instanceof Monster && !VillainousSummon.EXCEMPTFROMMODIFICATION.contains(sEntity.getType())){
            Monster entity = (Monster) sEntity;
            entity.targetSelector.addGoal(20, new NearestAttackableTargetGoal<>(entity, TurretTemplate.class, true));
        }
    }

    @SubscribeEvent
    public static void MinionTargetChanger(EntityJoinWorldEvent event){
        Entity sEntity = event.getEntity();
        if(sEntity instanceof VexMinion && !sEntity.level.isClientSide()){
            VexMinion entity = (VexMinion) sEntity;
            Set<WrappedGoal> prioritizedGoals = ObfuscationReflectionHelper.getPrivateValue(GoalSelector.class, entity.targetSelector, "f_25345_");
            ArrayList<Goal> toRemove = new ArrayList<>();
            if(prioritizedGoals != null) {
                for (WrappedGoal prioritizedGoal : prioritizedGoals) {
                    toRemove.add(prioritizedGoal.getGoal());
                }
            }
            for(Goal goal : toRemove){
                entity.targetSelector.removeGoal(goal);
            }
            entity.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(entity, Monster.class, 16, true, false,  ATTACK_PREDICATE));
        }
        else if(sEntity instanceof BearMinion && !sEntity.level.isClientSide()){
            BearMinion entity = (BearMinion) sEntity;
            Set<WrappedGoal> prioritizedGoals = ObfuscationReflectionHelper.getPrivateValue(GoalSelector.class, entity.targetSelector, "f_25345_");
            ArrayList<Goal> toRemove = new ArrayList<>();
            if(prioritizedGoals != null) {
                for (WrappedGoal prioritizedGoal : prioritizedGoals) {
                    toRemove.add(prioritizedGoal.getGoal());
                }
            }
            for(Goal goal : toRemove){
                entity.targetSelector.removeGoal(goal);
            }
            entity.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(entity, Monster.class, 16, true, false,  ATTACK_PREDICATE));
        }
    }

    public static final Predicate<LivingEntity> ATTACK_PREDICATE = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return entitytype != Register.VEXMINION.get() && entitytype != EntityType.CREEPER;
    };
}

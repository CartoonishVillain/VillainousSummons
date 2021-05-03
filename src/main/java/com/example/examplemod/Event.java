package com.example.examplemod;

import com.example.examplemod.Entities.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Random;

//TODO: On logout, user is desynced with their mount. Fix that :D

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
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
            success = true;
            }
            else if(event.getItemStack().getItem().equals(Register.HORSESUMMON.get())){
                HorseMount entity = new HorseMount(Register.HORSEMOUNT.get(), event.getWorld());
                entity.setPos(event.getPlayer().position().x, event.getPlayer().position().y, event.getPlayer().position().z);
                entity.setTamed(true);
                event.getWorld().addFreshEntity(entity);
                event.getPlayer().startRiding(entity);
                success = true;
            }
            else if(event.getItemStack().getItem().equals(Register.WOLFSUMMON.get())){
                WolfMinion[] entities = new WolfMinion[] {new WolfMinion(Register.WOLFMINION.get(), event.getWorld()), new WolfMinion(Register.WOLFMINION.get(), event.getWorld()), new WolfMinion(Register.WOLFMINION.get(), event.getWorld())};
                for(WolfMinion entity : entities){
                    entity.setPos(event.getPlayer().position().x, event.getPlayer().position().y, event.getPlayer().position().z);
                    entity.tame(event.getPlayer());
                    event.getWorld().addFreshEntity(entity);
                    success = true;
                }
            }else if(event.getItemStack().getItem().equals(Register.VEXSUMMON.get())){
                VexMinion[] entities = new VexMinion[] {new VexMinion(Register.VEXMINION.get(), event.getWorld()), new VexMinion(Register.VEXMINION.get(), event.getWorld()), new VexMinion(Register.VEXMINION.get(), event.getWorld()), new VexMinion(Register.VEXMINION.get(), event.getWorld()), new VexMinion(Register.VEXMINION.get(), event.getWorld())};
                for(VexMinion entity : entities){
                    entity.setPos(event.getPlayer().position().x, event.getPlayer().position().y, event.getPlayer().position().z);
                    event.getWorld().addFreshEntity(entity);
                    success = true;
                }
            }else if(event.getItemStack().getItem().equals(Register.BEARSUMMON.get())){
                    BearMinion entity = new BearMinion(Register.BEARMINION.get(), event.getWorld());
                    entity.setPos(event.getPlayer().position().x, event.getPlayer().position().y, event.getPlayer().position().z);
                    event.getWorld().addFreshEntity(entity);
                    success = true;
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
    public static void test(TickEvent.PlayerTickEvent event){
        PlayerEntity playerEntity = event.player;
        if(playerEntity.tickCount == 10){
            if(playerEntity.getVehicle() instanceof SlimeMount || playerEntity.getVehicle() instanceof HorseMount){
                playerEntity.stopRiding();
            }
        }
    }
}

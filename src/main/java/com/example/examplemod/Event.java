package com.example.examplemod;

import com.example.examplemod.Entities.HorseMount;
import com.example.examplemod.Entities.SlimeMount;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Event {
    @SubscribeEvent
    public static void summonBoat(PlayerInteractEvent.RightClickItem empty){
        if(!empty.getWorld().isClientSide() && empty.getEntityLiving() instanceof PlayerEntity && empty.getPlayer() != null){
            if(empty.getItemStack().getItem().equals(Register.SLIMESUMMON.get())){
            SlimeMount entity = new SlimeMount(Register.SLIMEMOUNT.get(), empty.getWorld());
            entity.setPos(empty.getPlayer().position().x, empty.getPlayer().position().y, empty.getPlayer().position().z);
            entity.setTamed(true);
            empty.getWorld().addFreshEntity(entity);
            empty.getPlayer().startRiding(entity);
                if(!empty.getPlayer().isCreative()){
                    ItemStack stack = empty.getItemStack();
                    if(stack.hurt(1, new Random(), null)) {
                        stack.shrink(1);
                        entity.playSound(SoundEvents.ITEM_BREAK, 100, 1);
                    }
                }
            }
            else if(empty.getItemStack().getItem().equals(Register.HORSESUMMON.get())){
                HorseMount entity = new HorseMount(Register.HORSEMOUNT.get(), empty.getWorld());
                entity.setPos(empty.getPlayer().position().x, empty.getPlayer().position().y, empty.getPlayer().position().z);
                entity.setTamed(true);
                empty.getWorld().addFreshEntity(entity);
                empty.getPlayer().startRiding(entity);
                if(!empty.getPlayer().isCreative()){
                    ItemStack stack = empty.getItemStack();
                    if(stack.hurt(1, new Random(), null)) {
                        stack.shrink(1);
                        entity.playSound(SoundEvents.ITEM_BREAK, 100, 1);
                    }
                }
            }
        }
    }
}

package com.example.examplemod;

import com.example.examplemod.Entities.SlimeMount;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class event {
    @SubscribeEvent
    public static void summonBoat(PlayerInteractEvent.RightClickItem empty){
        if(!empty.getWorld().isClientSide() && empty.getEntityLiving() instanceof PlayerEntity && empty.getPlayer() != null){
//            BoatEntity entity = new BoatEntity(EntityType.BOAT, empty.getWorld());
//            entity.setType(BoatEntity.Type.JUNGLE);
            SlimeMount entity = new SlimeMount(Register.SLIMEMOUNT.get(), empty.getWorld());
            entity.setPos(empty.getPlayer().position().x, empty.getPlayer().position().y, empty.getPlayer().position().z);
            empty.getWorld().addFreshEntity(entity);
            empty.getPlayer().startRiding(entity);
        }
    }
}

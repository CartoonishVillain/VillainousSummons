package com.example.examplemod.Client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Register;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderManager {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            RenderingRegistry.registerEntityRenderingHandler(Register.SLIMEMOUNT.get(), RenderSlimeMount::new);
            RenderingRegistry.registerEntityRenderingHandler(Register.HORSEMOUNT.get(), RenderHorseMount::new);
        }
}

package com.cartoonishvillain.villainoussummon.Client;

import com.cartoonishvillain.villainoussummon.VillainousSummon;
import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = VillainousSummon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderManager {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            RenderingRegistry.registerEntityRenderingHandler(Register.SLIMEMOUNT.get(), RenderSlimeMount::new);
            RenderingRegistry.registerEntityRenderingHandler(Register.HORSEMOUNT.get(), HorseRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(Register.WOLFMINION.get(), WolfRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(Register.VEXMINION.get(), VexRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(Register.BEARMINION.get(), PolarBearRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(Register.TURRETMK1.get(), RenderTurretMK1::new);

        }
}

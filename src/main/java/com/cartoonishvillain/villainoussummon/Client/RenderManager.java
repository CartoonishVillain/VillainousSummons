package com.cartoonishvillain.villainoussummon.Client;

import com.cartoonishvillain.villainoussummon.Client.CustomModels.SlimeMountModel;
import com.cartoonishvillain.villainoussummon.Client.CustomRenderers.*;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fmlclient.registry.RenderingRegistry;

@Mod.EventBusSubscriber(modid = VillainousSummon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderManager {
    public static ModelLayerLocation BELT_LAYER = new ModelLayerLocation( new ResourceLocation("villanoussummons:slimemount"), "slimemount");

    @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
        RenderingRegistry.registerLayerDefinition(BELT_LAYER, SlimeMountModel::createLayer);
            EntityRenderers.register(Register.SLIMEMOUNT.get(), SlimeMountRenderer::new);
            EntityRenderers.register(Register.HORSEMOUNT.get(), HorseRenderer::new);
            EntityRenderers.register(Register.WOLFMINION.get(), WolfRenderer::new);
            EntityRenderers.register(Register.VEXMINION.get(), VexRenderer::new);
            EntityRenderers.register(Register.BEARMINION.get(), PolarBearRenderer::new);
//            EntityRenderers.register(Register.ARROWTURRETMK1.get(), RenderTurretMK1::new);
//            EntityRenderers.register(Register.FIRETURRETMK1.get(), RenderTurretMK1::new);
//            EntityRenderers.register(Register.SLIMETURRETMK1.get(), RenderTurretMK1::new);
//            EntityRenderers.register(Register.ARROWTURRETMK2.get(), RenderTurretMK2::new);
//            EntityRenderers.register(Register.SCOUTTURRETMK2.get(), RenderTurretMK2::new);
//            EntityRenderers.register(Register.FIRETURRETMK2.get(), RenderTurretMK2::new);
//            EntityRenderers.register(Register.FIREARROWTURRETMK2.get(), RenderTurretMK2::new);
//            EntityRenderers.register(Register.POTIONARROWTURRETMK2.get(), RenderTurretMK2::new);
//            EntityRenderers.register(Register.CANNONTURRETMK3.get(), RenderTurretMK3::new);
//            EntityRenderers.register(Register.BALLISTATURRETMK3.get(), RenderTurretMK3::new);
//            EntityRenderers.register(Register.ARCANETURRETMK3.get(), RenderTurretMK3::new);
//            EntityRenderers.register(Register.RAPIDARROWTURRETMK4.get(), RenderTurretMK3::new);
//            EntityRenderers.register(Register.TURRETARROW.get(), TippableArrowRenderer::new);
//            EntityRenderers.register(Register.BALLISTAARROW.get(), TippableArrowRenderer::new);
//            EntityRenderers.register(Register.SLIMEPROJECTILE.get(), new GenericItemProjectileRenderFactory());
//            EntityRenderers.register(Register.INNATECANONBALL.get(), new GenericItemProjectileRenderFactory());
//            EntityRenderers.register(Register.CANNONBALLPROJECTILE.get(), new GenericItemProjectileRenderFactory());
        }
}

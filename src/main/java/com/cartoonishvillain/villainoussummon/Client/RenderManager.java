package com.cartoonishvillain.villainoussummon.Client;

import com.cartoonishvillain.villainoussummon.Client.CustomModels.SlimeMountModel;
import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMK1Model;
import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMk2Model;
import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMk3Model;
import com.cartoonishvillain.villainoussummon.Client.CustomRenderers.*;
import com.cartoonishvillain.villainoussummon.Entities.Projectiles.SlimeballProjectile;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = VillainousSummon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderManager {
    public static ModelLayerLocation SLIMEMOUNT = new ModelLayerLocation( new ResourceLocation("villanoussummons:slimemount"), "slimemount");
    public static ModelLayerLocation TURRETMK1 = new ModelLayerLocation( new ResourceLocation("villanoussummons:turretmk1"), "turretmk1");
    public static ModelLayerLocation TURRETMK2 = new ModelLayerLocation( new ResourceLocation("villanoussummons:turretmk2"), "turretmk2");
    public static ModelLayerLocation TURRETMK3 = new ModelLayerLocation( new ResourceLocation("villanoussummons:turretmk3"), "turretmk3");


    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(SLIMEMOUNT, SlimeMountModel::createLayer);
        event.registerLayerDefinition(TURRETMK1, TurretMK1Model::createLayer);
        event.registerLayerDefinition(TURRETMK2, TurretMk2Model::createLayer);
        event.registerLayerDefinition(TURRETMK3, TurretMk3Model::createLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(Register.SLIMEMOUNT.get(), SlimeMountRenderer::new);
        event.registerEntityRenderer(Register.HORSEMOUNT.get(), HorseRenderer::new);
        event.registerEntityRenderer(Register.WOLFMINION.get(), WolfRenderer::new);
        event.registerEntityRenderer(Register.VEXMINION.get(), VexRenderer::new);
        event.registerEntityRenderer(Register.BEARMINION.get(), PolarBearRenderer::new);
        event.registerEntityRenderer(Register.ARROWTURRETMK1.get(), RenderTurretMK1::new);
        event.registerEntityRenderer(Register.FIRETURRETMK1.get(), RenderTurretMK1::new);
        event.registerEntityRenderer(Register.SLIMETURRETMK1.get(), RenderTurretMK1::new);
        event.registerEntityRenderer(Register.ARROWTURRETMK2.get(), RenderTurretMK2::new);
        event.registerEntityRenderer(Register.SCOUTTURRETMK2.get(), RenderTurretMK2::new);
        event.registerEntityRenderer(Register.FIRETURRETMK2.get(), RenderTurretMK2::new);
        event.registerEntityRenderer(Register.FIREARROWTURRETMK2.get(), RenderTurretMK2::new);
        event.registerEntityRenderer(Register.POTIONARROWTURRETMK2.get(), RenderTurretMK2::new);
        event.registerEntityRenderer(Register.CANNONTURRETMK3.get(), RenderTurretMK3::new);
        event.registerEntityRenderer(Register.BALLISTATURRETMK3.get(), RenderTurretMK3::new);
        event.registerEntityRenderer(Register.ARCANETURRETMK3.get(), RenderTurretMK3::new);
        event.registerEntityRenderer(Register.RAPIDARROWTURRETMK4.get(), RenderTurretMK3::new);
        event.registerEntityRenderer(Register.TURRETARROW.get(), TurretArrowRenderer::new);
        event.registerEntityRenderer(Register.BALLISTAARROW.get(), TippableArrowRenderer::new);
        event.registerEntityRenderer(Register.SLIMEPROJECTILE.get(), (Context) -> {
            return new ThrownItemRenderer<>(Context, 1.0F, false);
        });
        event.registerEntityRenderer(Register.INNATECANONBALL.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Register.CANNONBALLPROJECTILE.get(), ThrownItemRenderer::new);
    }

    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers event){

    }

    @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
//        EntityRenderers.register(Register.SLIMEMOUNT.get(), SlimeMountRenderer::new);
//        EntityRenderers.register(Register.HORSEMOUNT.get(), HorseRenderer::new);
//        EntityRenderers.register(Register.WOLFMINION.get(), WolfRenderer::new);
//        EntityRenderers.register(Register.VEXMINION.get(), VexRenderer::new);
//        EntityRenderers.register(Register.BEARMINION.get(), PolarBearRenderer::new);
//        EntityRenderers.register(Register.FIRETURRETMK1.get(), RenderTurretMK1::new);
//        EntityRenderers.register(Register.SLIMETURRETMK1.get(), RenderTurretMK1::new);
//        EntityRenderers.register(Register.ARROWTURRETMK2.get(), RenderTurretMK2::new);
//        EntityRenderers.register(Register.SCOUTTURRETMK2.get(), RenderTurretMK2::new);
//        EntityRenderers.register(Register.FIRETURRETMK2.get(), RenderTurretMK2::new);
//        EntityRenderers.register(Register.FIREARROWTURRETMK2.get(), RenderTurretMK2::new);
//        EntityRenderers.register(Register.POTIONARROWTURRETMK2.get(), RenderTurretMK2::new);
//        EntityRenderers.register(Register.CANNONTURRETMK3.get(), RenderTurretMK3::new);
//        EntityRenderers.register(Register.BALLISTATURRETMK3.get(), RenderTurretMK3::new);
//        EntityRenderers.register(Register.ARCANETURRETMK3.get(), RenderTurretMK3::new);
//        EntityRenderers.register(Register.RAPIDARROWTURRETMK4.get(), RenderTurretMK3::new);
//        EntityRenderers.register(Register.TURRETARROW.get(), TurretArrowRenderer::new);
//        EntityRenderers.register(Register.BALLISTAARROW.get(), TippableArrowRenderer::new);
//        EntityRenderers.register(Register.SLIMEPROJECTILE.get(), (Context) -> {
//            return new ThrownItemRenderer<>(Context, 1.0F, false);
//        });
//        EntityRenderers.register(Register.INNATECANONBALL.get(), ThrownItemRenderer::new);
//        EntityRenderers.register(Register.CANNONBALLPROJECTILE.get(), ThrownItemRenderer::new);

        }
}

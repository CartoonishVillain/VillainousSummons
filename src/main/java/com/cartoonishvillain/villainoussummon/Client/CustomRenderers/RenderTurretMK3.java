package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;

import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMk2Model;
import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMk3Model;
import com.cartoonishvillain.villainoussummon.Client.RenderManager;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.BaseTurretsMK2;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.turretTypeMK2;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.BaseTurretsMK3;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.turretTypeMK3;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderTurretMK3 extends MobRenderer<BaseTurretsMK3, TurretMk3Model<BaseTurretsMK3>> {

    protected static final ResourceLocation BALLISTA = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/ballistaturretmk3.png");
    protected static final ResourceLocation CANNON = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/cannonturretmk3.png");
    protected static final ResourceLocation ARCANE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/arcaneturretmk3.png");
    protected static final ResourceLocation CREATIVE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/creativeturret.png");

    public RenderTurretMK3(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new TurretMk3Model<>(Minecraft.getInstance().getEntityModels().bakeLayer(RenderManager.TURRETMK3)), 0.5f);
    }


//    public RenderTurretMK3(EntityRenderDispatcher p_i50961_1_) {
//        super(p_i50961_1_, new TurretMk3Model<>(), 0.5f);
//    }

    @Override
    public ResourceLocation getTextureLocation(BaseTurretsMK3 turretMK3) {
        turretTypeMK3 typeMK3 = turretMK3.getTurretType();
        switch (typeMK3){
            case CANNON: return CANNON;
            case ARCANE: return ARCANE;
            case CREATIVE: return CREATIVE;
            default: return BALLISTA;
        }
    }
}

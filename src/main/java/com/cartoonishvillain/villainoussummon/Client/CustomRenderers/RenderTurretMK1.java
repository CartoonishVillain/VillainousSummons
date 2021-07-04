package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;

import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMK1Model;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.BaseTurretsMK1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.FireTurretMk1;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderTurretMK1 extends MobRenderer<BaseTurretsMK1, TurretMK1Model<BaseTurretsMK1>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/arrowturretmk1.png");
    protected static final ResourceLocation FIRETEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/fireturretmk1.png");


    public RenderTurretMK1(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new TurretMK1Model<>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BaseTurretsMK1 p_110775_1_) {
        if(p_110775_1_ instanceof FireTurretMk1) return FIRETEXTURE;
        else return TEXTURE;
    }
}

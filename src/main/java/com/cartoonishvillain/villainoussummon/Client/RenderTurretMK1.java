package com.cartoonishvillain.villainoussummon.Client;

import com.cartoonishvillain.villainoussummon.Entities.TurretMk1;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderTurretMK1 extends MobRenderer<TurretMk1, TurretMK1Model<TurretMk1>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/TurretMk1.png");


    public RenderTurretMK1(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new TurretMK1Model<>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TurretMk1 p_110775_1_) {
        return TEXTURE;
    }
}

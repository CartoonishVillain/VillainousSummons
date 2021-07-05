package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;

import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMK1Model;
import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMk2Model;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.BaseTurretsMK1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.turretTypeMK1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.BaseTurretsMK2;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderTurretMK2 extends MobRenderer<BaseTurretsMK2, TurretMk2Model<BaseTurretsMK2>> {

    protected static final ResourceLocation ARROWTEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/arrowturretmk2.png");


    public RenderTurretMK2(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new TurretMk2Model<>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BaseTurretsMK2 turretMK2) {
        return ARROWTEXTURE;
    }
}

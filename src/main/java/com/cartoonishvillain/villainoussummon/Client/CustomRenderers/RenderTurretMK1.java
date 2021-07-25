package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;

import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMK1Model;
import com.cartoonishvillain.villainoussummon.Client.RenderManager;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.BaseTurretsMK1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.turretTypeMK1;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import static com.cartoonishvillain.villainoussummon.Client.RenderManager.TURRETMK1;

public class RenderTurretMK1 extends MobRenderer<BaseTurretsMK1, TurretMK1Model<BaseTurretsMK1>> {

    protected static final ResourceLocation ARROWTEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/arrowturretmk1.png");
    protected static final ResourceLocation FIRETEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/fireturretmk1.png");
    protected static final ResourceLocation SLIMETEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/slimeturretmk1.png");

    public RenderTurretMK1(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new TurretMK1Model<>(p_174304_.bakeLayer(TURRETMK1)), 0.5f);
    }


//    public RenderTurretMK1(EntityRenderDispatcher p_i50961_1_) {
//        super(p_i50961_1_, new TurretMK1Model<>(), 0.5f);
//    }

    @Override
    public ResourceLocation getTextureLocation(BaseTurretsMK1 turretMK1) {
        turretTypeMK1 typeMK1 = turretMK1.getTurretType();
        switch (typeMK1){
            case FIRE: return FIRETEXTURE;
            case SLIME: return SLIMETEXTURE;
            default: return ARROWTEXTURE;
        }
    }
}

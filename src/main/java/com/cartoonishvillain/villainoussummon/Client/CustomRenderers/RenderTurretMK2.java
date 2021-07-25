package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;

import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMK1Model;
import com.cartoonishvillain.villainoussummon.Client.CustomModels.TurretMk2Model;
import com.cartoonishvillain.villainoussummon.Client.RenderManager;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.BaseTurretsMK1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.turretTypeMK1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.BaseTurretsMK2;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.turretTypeMK2;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import static com.cartoonishvillain.villainoussummon.Client.RenderManager.TURRETMK2;


public class RenderTurretMK2 extends MobRenderer<BaseTurretsMK2, TurretMk2Model<BaseTurretsMK2>> {

    protected static final ResourceLocation ARROWTEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/arrowturretmk2.png");
    protected static final ResourceLocation FIREARROWTEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/firearrowturretmk2.png");
    protected static final ResourceLocation FIRETEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/fireturretmk2.png");
    protected static final ResourceLocation POTIONARROWTEXTURE = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/potionarrowturretmk2.png");
    protected static final ResourceLocation SCOUT = new ResourceLocation(VillainousSummon.MOD_ID, "textures/entity/scoutturretmk2.png");

    public RenderTurretMK2(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new TurretMk2Model<>(p_174304_.bakeLayer(TURRETMK2)), 0.5f);
    }


//    public RenderTurretMK2(EntityRenderDispatcher p_i50961_1_) {
//        super(p_i50961_1_, new TurretMk2Model<>(), 0.5f);
//    }

    @Override
    public ResourceLocation getTextureLocation(BaseTurretsMK2 turretMK2) {
        turretTypeMK2 typeMK2 = turretMK2.getTurretType();
        return switch (typeMK2) {
            case FIRE -> FIRETEXTURE;
            case POTIONARROW -> POTIONARROWTEXTURE;
            case SCOUT -> SCOUT;
            case FIREARROW -> FIREARROWTEXTURE;
            default -> ARROWTEXTURE;
        };
    }
}

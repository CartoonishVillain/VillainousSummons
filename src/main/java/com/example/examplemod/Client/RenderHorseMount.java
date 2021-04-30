package com.example.examplemod.Client;

import com.example.examplemod.Entities.HorseMount;
import com.example.examplemod.Entities.SlimeMount;
import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.entity.passive.horse.CoatColors;
import net.minecraft.util.ResourceLocation;

public class RenderHorseMount extends MobRenderer<HorseMount, HorseModel<HorseMount>>  {

    protected static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/horse/horse_chestnut.png");

    public RenderHorseMount(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new HorseModel<>(0), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(HorseMount p_110775_1_) {
        return TEXTURE;
    }
}

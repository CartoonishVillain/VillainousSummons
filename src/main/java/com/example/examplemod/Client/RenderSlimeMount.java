package com.example.examplemod.Client;

import com.example.examplemod.Entities.SlimeMount;
import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.util.ResourceLocation;

public class RenderSlimeMount extends MobRenderer<SlimeMount, SlimeModel<SlimeMount>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MOD_ID, "textures/entity/slime.png");


    public RenderSlimeMount(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new SlimeModel<>(3), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SlimeMount p_110775_1_) {
        return TEXTURE;
    }
}

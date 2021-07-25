//package com.cartoonishvillain.villainoussummon.Client.CustomRenderers;
//
///*
//MIT License
//
//Copyright (c) 2020 przemykomo
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in all
//copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//SOFTWARE.
// */ //This class is entirely based off of the spooky arms code for rendering these.
//
//import com.cartoonishvillain.villainoussummon.Entities.Projectiles.GenericItemProjectile;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.entity.EntityRenderer;
//import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
//import net.minecraft.client.renderer.entity.ThrownItemRenderer;
//import net.minecraftforge.fml.client.registry.IRenderFactory;
//
//public class GenericItemProjectileRenderFactory implements IRenderFactory<GenericItemProjectile> {
//    @Override
//    public EntityRenderer<? super GenericItemProjectile> createRenderFor(EntityRenderDispatcher manager) {
//        return new ThrownItemRenderer<>(manager, Minecraft.getInstance().getItemRenderer());
//    }
//}

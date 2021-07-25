package com.cartoonishvillain.villainoussummon.Entities.Projectiles;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

import java.util.ArrayList;
import java.util.List;

public class TurretArrow extends AbstractArrow {

    private final List<MobEffectInstance> effects;

    public TurretArrow(Level p_i46758_1_, LivingEntity p_i46758_2_) {
        super(Register.TURRETARROW.get(), p_i46758_2_, p_i46758_1_);
        effects = new ArrayList<>();
    }

    public TurretArrow(Level p_i46758_1_, LivingEntity p_i46758_2_, int fireseconds) {
        super(Register.TURRETARROW.get(), p_i46758_2_, p_i46758_1_);
        this.setSecondsOnFire(fireseconds);
        effects = new ArrayList<>();

    }

    public TurretArrow(EntityType<? extends AbstractArrow> p_i50172_1_, Level p_i50172_2_) {
        super(p_i50172_1_, p_i50172_2_);
        effects = new ArrayList<>();
    }

    public void addEffect(MobEffectInstance effectInstance){
        this.effects.add(effectInstance);
    }

    @Override
    protected void onHitEntity(EntityHitResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        p_213868_1_.getEntity().invulnerableTime = 0;
    }

    @Override
    protected void onHitBlock(BlockHitResult p_230299_1_) {
        super.onHitBlock(p_230299_1_);
        this.remove(false);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(Items.AIR);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


}

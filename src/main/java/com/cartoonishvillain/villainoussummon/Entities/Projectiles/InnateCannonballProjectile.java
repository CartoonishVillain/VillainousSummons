package com.cartoonishvillain.villainoussummon.Entities.Projectiles;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import java.util.Random;

public class InnateCannonballProjectile extends GenericItemProjectile {

    public InnateCannonballProjectile(EntityType<? extends ThrowableItemProjectile> p_i50155_1_, Level p_i50155_2_) {
        super(p_i50155_1_, p_i50155_2_);
    }

    public InnateCannonballProjectile(EntityType<? extends ThrowableItemProjectile> p_i50156_1_, double p_i50156_2_, double p_i50156_4_, double p_i50156_6_, Level p_i50156_8_) {
        super(p_i50156_1_, p_i50156_2_, p_i50156_4_, p_i50156_6_, p_i50156_8_);
    }

    public InnateCannonballProjectile(EntityType<? extends ThrowableItemProjectile> p_i50157_1_, LivingEntity p_i50157_2_, Level p_i50157_3_) {
        super(p_i50157_1_, p_i50157_2_, p_i50157_3_);
    }

    public InnateCannonballProjectile(Level level, Player player) {
        this(Register.INNATECANONBALL.get(), player, level);
    }

    public InnateCannonballProjectile(Level p_82499_1_, double x, double y, double z) {
        this(Register.INNATECANONBALL.get(), x, y, z, p_82499_1_);
    }

    @Override
    protected Item getDefaultItem() {
        return Register.CANNONBALL.get();
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(Register.CANNONBALL.get());
    }

    @Override
    protected void onHitEntity(EntityHitResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);

        if(!this.level.isClientSide()) {
            p_213868_1_.getEntity().hurt(DamageSource.thrown(this, null), 8);
            this.playSound(SoundEvents.ANVIL_LAND, 1f, 0.5f);
        }
        Random random = new Random();
        int savecheck = random.nextInt(21);
        if(savecheck < 15 && !this.level.isClientSide()){
            ItemEntity itemEntity = new ItemEntity(EntityType.ITEM, this.level);
            ItemStack itemStack = new ItemStack(Register.CANNONBALL.get(), 1);
            itemEntity.setItem(itemStack);
            itemEntity.setPos(p_213868_1_.getEntity().getX(), p_213868_1_.getEntity().getY(), p_213868_1_.getEntity().getZ());
            level.addFreshEntity(itemEntity);
        }else if(!this.level.isClientSide()){p_213868_1_.getEntity().playSound(SoundEvents.ANVIL_DESTROY, 1f, 0.5f);}
        this.remove(false);
    }

    @Override
    protected void onHitBlock(BlockHitResult p_230299_1_) {
        super.onHitBlock(p_230299_1_);

        Random random = new Random();
        int savecheck = random.nextInt(21);
        if(savecheck < 10 && !this.level.isClientSide()){
            this.playSound(SoundEvents.ANVIL_LAND, 1f, 0.5f);
            ItemEntity itemEntity = new ItemEntity(EntityType.ITEM, this.level);
            ItemStack itemStack = new ItemStack(Register.CANNONBALL.get(), 1);
            itemEntity.setItem(itemStack);
            itemEntity.setPos(this.getX(), this.getY(), this.getZ());
            level.addFreshEntity(itemEntity);
        } else if(!this.level.isClientSide()){this.playSound(SoundEvents.ANVIL_DESTROY, 1f, 0.5f);}
        this.remove(false);
    }
}

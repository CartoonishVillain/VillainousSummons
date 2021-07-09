package com.cartoonishvillain.villainoussummon.Entities.Projectiles;

import com.cartoonishvillain.villainoussummon.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import org.lwjgl.system.CallbackI;

import java.util.Random;

public class InnateCannonballProjectile extends GenericItemProjectile {

    public InnateCannonballProjectile(EntityType<? extends ProjectileItemEntity> p_i50155_1_, World p_i50155_2_) {
        super(p_i50155_1_, p_i50155_2_);
    }

    public InnateCannonballProjectile(EntityType<? extends ProjectileItemEntity> p_i50156_1_, double p_i50156_2_, double p_i50156_4_, double p_i50156_6_, World p_i50156_8_) {
        super(p_i50156_1_, p_i50156_2_, p_i50156_4_, p_i50156_6_, p_i50156_8_);
    }

    public InnateCannonballProjectile(EntityType<? extends ProjectileItemEntity> p_i50157_1_, LivingEntity p_i50157_2_, World p_i50157_3_) {
        super(p_i50157_1_, p_i50157_2_, p_i50157_3_);
    }

    public InnateCannonballProjectile(World level, PlayerEntity player) {
        this(Register.INNATECANONBALL.get(), player, level);
    }

    public InnateCannonballProjectile(World p_82499_1_, double x, double y, double z) {
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
    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
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
        this.remove();
    }

    @Override
    protected void onHitBlock(BlockRayTraceResult p_230299_1_) {
        super.onHitBlock(p_230299_1_);

        Random random = new Random();
        int savecheck = random.nextInt(21);
        if(savecheck < 10 && !this.level.isClientSide()){
            this.playSound(SoundEvents.ANVIL_LAND, 1f, 0.5f);
            ItemEntity itemEntity = new ItemEntity(EntityType.ITEM, this.level);
            ItemStack itemStack = new ItemStack(Register.CANNONBALL.get(), 1);
            itemEntity.setItem(itemStack);
            itemEntity.setPos(this.getEntity().getX(), this.getEntity().getY(), this.getEntity().getZ());
            level.addFreshEntity(itemEntity);
        } else if(!this.level.isClientSide()){this.playSound(SoundEvents.ANVIL_DESTROY, 1f, 0.5f);}
        this.remove();
    }
}

package com.cartoonishvillain.villainoussummon.Items;

import com.cartoonishvillain.villainoussummon.Entities.Projectiles.InnateCannonballProjectile;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CannonballItem extends SnowballItem {
    public CannonballItem(Properties p_i48466_1_) {
        super(p_i48466_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (random.nextFloat() * 0.4F + 0.8F));
        if(!level.isClientSide()){
            InnateCannonballProjectile innateCannonballProjectile = new InnateCannonballProjectile(level, player);
            innateCannonballProjectile.shootFromRotation(player, player.xRot, player.yRot, 0.0f, 0.4f, 0.4f);
            level.addFreshEntity(innateCannonballProjectile);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.abilities.instabuild) {
            itemstack.shrink(1);
        }
        player.getCooldowns().addCooldown(this, 2*20);
        player.causeFoodExhaustion(5);


        return ActionResult.sidedSuccess(itemstack, level.isClientSide());
    }

    protected void throwFromHand(World level, PlayerEntity player, ItemStack itemstack){
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (random.nextFloat() * 0.4F + 0.8F));
        if(!level.isClientSide()){
            InnateCannonballProjectile innateCannonballProjectile = new InnateCannonballProjectile(level, player);
            innateCannonballProjectile.shootFromRotation(player, player.xRot, player.yRot, 0.0f, 0.4f, 0.4f);
            level.addFreshEntity(innateCannonballProjectile);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.abilities.instabuild) {
            itemstack.shrink(1);
        }
        player.getCooldowns().addCooldown(this, 2*20);
        player.causeFoodExhaustion(5);
    }

    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> tooltip, ITooltipFlag p_77624_4_) {
        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
        tooltip.add(new StringTextComponent(TextFormatting.BLUE + "Can be used in crafting or thrown short distances"));
        tooltip.add(new StringTextComponent(TextFormatting.RED + "May break on landing. Cannonballs are heavy and it takes some effort to throw."));
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
        if(!player.isCreative()) {
            if (!player.level.isClientSide()) {
                throwFromHand(player.level, player, item);
            }
            return false;
        }
        else{
            return true;
        }


    }
}

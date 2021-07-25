package com.cartoonishvillain.villainoussummon.Items;

import com.cartoonishvillain.villainoussummon.Entities.Projectiles.InnateCannonballProjectile;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class CannonballItem extends SnowballItem {
    public CannonballItem(Properties p_i48466_1_) {
        super(p_i48466_1_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5f, 0.4f / (player.getRandom().nextFloat() * 0.4F + 0.8F));
        if(!level.isClientSide()){
            InnateCannonballProjectile innateCannonballProjectile = new InnateCannonballProjectile(level, player);
            innateCannonballProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 0.4f, 0.4f);
            level.addFreshEntity(innateCannonballProjectile);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }
        player.getCooldowns().addCooldown(this, 2*20);
        player.causeFoodExhaustion(5);


        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

    protected void throwFromHand(Level level, Player player, ItemStack itemstack){
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5f, 0.4f / (player.getRandom().nextFloat() * 0.4F + 0.8F));
        if(!level.isClientSide()){
            InnateCannonballProjectile innateCannonballProjectile = new InnateCannonballProjectile(level, player);
            innateCannonballProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 0.4f, 0.4f);
            level.addFreshEntity(innateCannonballProjectile);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }
        player.getCooldowns().addCooldown(this, 2*20);
        player.causeFoodExhaustion(5);
    }

    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable Level p_77624_2_, List<Component> tooltip, TooltipFlag p_77624_4_) {
        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
        tooltip.add(new TextComponent(ChatFormatting.BLUE + "Can be used in crafting or thrown short distances"));
        tooltip.add(new TextComponent(ChatFormatting.RED + "May break on landing. Cannonballs are heavy and it takes some effort to throw."));
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, Player player) {
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

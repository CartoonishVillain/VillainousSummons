package com.cartoonishvillain.villainoussummon.Items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWithLore extends Item {
    String[] Lore = null;
    int cooldown = 0;
    public ItemWithLore(Properties props, String[] Lore) {
        super(props);
        this.Lore = Lore;
    }

    public ItemWithLore(Properties props, String[] Lore, int cooldown) {
        super(props);
        this.Lore = Lore;
        this.cooldown = cooldown;
    }


    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> tooltip, ITooltipFlag p_77624_4_) {
        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
        if(Lore != null) {
            for (String loreBit : Lore) {
                tooltip.add(new StringTextComponent(loreBit));
            }
        }
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        if(cooldown != 0){
        p_77659_2_.getCooldowns().addCooldown(this, cooldown*20);}
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }
}

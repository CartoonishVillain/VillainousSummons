package com.cartoonishvillain.villainoussummon.Items;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

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
    public void appendHoverText(ItemStack p_77624_1_, @Nullable Level p_77624_2_, List<Component> tooltip, TooltipFlag p_77624_4_) {
        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
        if(Lore != null) {
            for (String loreBit : Lore) {
                tooltip.add(new TextComponent(loreBit));
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        if(cooldown != 0){
        p_77659_2_.getCooldowns().addCooldown(this, cooldown*20);}
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }
}

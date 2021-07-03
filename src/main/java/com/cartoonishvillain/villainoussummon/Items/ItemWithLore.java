package com.cartoonishvillain.villainoussummon.Items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWithLore extends Item {
    String[] Lore = null;
    public ItemWithLore(Properties props, String[] Lore) {
        super(props);
        this.Lore = Lore;
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


}

package com.cartoonishvillain.villainoussummon.Items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TurretPlacementItem extends SpawnEggItem {

    protected static final List<TurretPlacementItem> UNADDED_EGGS = new ArrayList<TurretPlacementItem>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;
    String[] Lore = null;

    public TurretPlacementItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int primaryColorIn, final int secondaryColorIn, final Item.Properties properties, @Nullable String[] lore) {
        super(null, primaryColorIn, secondaryColorIn, properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
        Lore = lore;}


    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable Level p_77624_2_, List<Component> tooltip, TooltipFlag p_77624_4_) {
        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
        if(Lore != null) {
            for (String loreBit : Lore) {
                tooltip.add(new TextComponent(loreBit));
            }
        }
    }

    public static void initSpawnEggs() {
        //TODO REMAP
        final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
    }

        @Override
        public EntityType<?> getType(CompoundTag nbt) {
            return this.entityTypeSupplier.get();
        }
}

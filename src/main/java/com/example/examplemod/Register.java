package com.example.examplemod;

import com.example.examplemod.Entities.HorseMount;
import com.example.examplemod.Entities.SlimeMount;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Register {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ExampleMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static void init(){ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus()); ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());}

    public static final RegistryObject<EntityType<SlimeMount>> SLIMEMOUNT = ENTITY_TYPES.register("slimemount", () -> EntityType.Builder.of(SlimeMount::new, EntityClassification.CREATURE).sized(0.6f, 0.6f).build(new ResourceLocation(ExampleMod.MOD_ID, "slimemount").toString()));
    public static final RegistryObject<EntityType<HorseMount>> HORSEMOUNT = ENTITY_TYPES.register("horsemount", () -> EntityType.Builder.of(HorseMount::new, EntityClassification.CREATURE).sized(1.3964844F, 1.6F).build(new ResourceLocation(ExampleMod.MOD_ID, "horsemount").toString()));


    public static final RegistryObject<Item> SLIMESUMMON = ITEMS.register("slimesummon", () -> new ItemWithLore(new Item.Properties().tab(ExampleMod.TAB).stacksTo(1).defaultDurability(30), new String[] {TextFormatting.BLUE + "Summons a large slime to ride around on", TextFormatting.BLUE + "Can bounce on enemies, jump high, and reduces fall damage!"}));
    public static final RegistryObject<Item> HORSESUMMON = ITEMS.register("horsesummon", () -> new ItemWithLore(new Item.Properties().tab(ExampleMod.TAB).stacksTo(1).defaultDurability(50), new String[] {TextFormatting.BLUE + "Summons an average horse to ride around on"}));

}

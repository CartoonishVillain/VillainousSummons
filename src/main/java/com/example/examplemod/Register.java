package com.example.examplemod;

import com.example.examplemod.Entities.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
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
    public static final RegistryObject<EntityType<WolfMinion>> WOLFMINION = ENTITY_TYPES.register("wolfminion", () -> EntityType.Builder.of(WolfMinion::new, EntityClassification.CREATURE).sized(0.6F, 0.85F).build(new ResourceLocation(ExampleMod.MOD_ID, "wolfminion").toString()));
    public static final RegistryObject<EntityType<VexMinion>> VEXMINION = ENTITY_TYPES.register("vexminion", () -> EntityType.Builder.of(VexMinion::new, EntityClassification.CREATURE).sized(0.6F, 0.85F).build(new ResourceLocation(ExampleMod.MOD_ID, "vexminion").toString()));
    public static final RegistryObject<EntityType<BearMinion>> BEARMINION = ENTITY_TYPES.register("bearminion", () -> EntityType.Builder.of(BearMinion::new, EntityClassification.CREATURE).sized(0.6F, 0.85F).build(new ResourceLocation(ExampleMod.MOD_ID, "bearminion").toString()));


    public static final RegistryObject<Item> SLIMESUMMON = ITEMS.register("slimesummon", () -> new ItemWithLore(new Item.Properties().tab(ExampleMod.TAB).stacksTo(1).defaultDurability(30), new String[] {TextFormatting.BLUE + "Summons a large slime to ride around on", TextFormatting.BLUE + "Can bounce on enemies, jump high, and reduces fall damage!"}));
    public static final RegistryObject<Item> HORSESUMMON = ITEMS.register("horsesummon", () -> new ItemWithLore(new Item.Properties().tab(ExampleMod.TAB).stacksTo(1).defaultDurability(50), new String[] {TextFormatting.BLUE + "Summons an average horse to ride around on"}));
    public static final RegistryObject<Item> WOLFSUMMON = ITEMS.register("wolfsummon", () -> new ItemWithLore(new Item.Properties().tab(ExampleMod.TAB).stacksTo(1).defaultDurability(50), new String[] {TextFormatting.BLUE + "Summons an average horse to ride around on"}));
    public static final RegistryObject<Item> VEXSUMMON = ITEMS.register("vexsummon", () -> new ItemWithLore(new Item.Properties().tab(ExampleMod.TAB).stacksTo(1).defaultDurability(50), new String[] {TextFormatting.BLUE + "Summons an average horse to ride around on"}));
    public static final RegistryObject<Item> BEARSUMMON = ITEMS.register("bearsummon", () -> new ItemWithLore(new Item.Properties().tab(ExampleMod.TAB).stacksTo(1).defaultDurability(50), new String[] {TextFormatting.BLUE + "Summons an average horse to ride around on"}));


}

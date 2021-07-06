package com.cartoonishvillain.villainoussummon;

import com.cartoonishvillain.villainoussummon.Entities.Minions.BearMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.VexMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.WolfMinion;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.HorseMount;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.cartoonishvillain.villainoussummon.Entities.Projectiles.SlimeballProjectile;
import com.cartoonishvillain.villainoussummon.Entities.Projectiles.TurretArrow;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.ArrowTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.FireTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.SlimeTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.*;
import com.cartoonishvillain.villainoussummon.Items.ItemWithLore;
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
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, VillainousSummon.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VillainousSummon.MOD_ID);

    public static void init(){ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus()); ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());}

    public static final RegistryObject<EntityType<SlimeMount>> SLIMEMOUNT = ENTITY_TYPES.register("slimemount", () -> EntityType.Builder.of(SlimeMount::new, EntityClassification.CREATURE).sized(0.6f, 0.6f).build(new ResourceLocation(VillainousSummon.MOD_ID, "slimemount").toString()));
    public static final RegistryObject<EntityType<HorseMount>> HORSEMOUNT = ENTITY_TYPES.register("horsemount", () -> EntityType.Builder.of(HorseMount::new, EntityClassification.CREATURE).sized(1.3964844F, 1.6F).build(new ResourceLocation(VillainousSummon.MOD_ID, "horsemount").toString()));
    public static final RegistryObject<EntityType<WolfMinion>> WOLFMINION = ENTITY_TYPES.register("wolfminion", () -> EntityType.Builder.of(WolfMinion::new, EntityClassification.CREATURE).sized(0.6F, 0.85F).build(new ResourceLocation(VillainousSummon.MOD_ID, "wolfminion").toString()));
    public static final RegistryObject<EntityType<VexMinion>> VEXMINION = ENTITY_TYPES.register("vexminion", () -> EntityType.Builder.of(VexMinion::new, EntityClassification.CREATURE).sized(0.6F, 0.85F).build(new ResourceLocation(VillainousSummon.MOD_ID, "vexminion").toString()));
    public static final RegistryObject<EntityType<BearMinion>> BEARMINION = ENTITY_TYPES.register("bearminion", () -> EntityType.Builder.of(BearMinion::new, EntityClassification.CREATURE).sized(0.6F, 0.85F).build(new ResourceLocation(VillainousSummon.MOD_ID, "bearminion").toString()));

    public static final RegistryObject<EntityType<ArrowTurretMk1>> ARROWTURRETMK1 = ENTITY_TYPES.register("arrowturretmk1", () -> EntityType.Builder.of(ArrowTurretMk1::new, EntityClassification.MISC).sized(1f, 2f).build(new ResourceLocation(VillainousSummon.MOD_ID, "arrowturretmk1").toString()));
    public static final RegistryObject<EntityType<FireTurretMk1>> FIRETURRETMK1 = ENTITY_TYPES.register("fireturretmk1", () -> EntityType.Builder.of(FireTurretMk1::new, EntityClassification.MISC).sized(1f, 2f).build(new ResourceLocation(VillainousSummon.MOD_ID, "fireturretmk1").toString()));
    public static final RegistryObject<EntityType<SlimeTurretMk1>> SLIMETURRETMK1 = ENTITY_TYPES.register("slimeturretmk1", () -> EntityType.Builder.of(SlimeTurretMk1::new, EntityClassification.MISC).sized(1f, 2f).build(new ResourceLocation(VillainousSummon.MOD_ID, "slimeturretmk1").toString()));

    public static final RegistryObject<EntityType<ArrowTurretMk2>> ARROWTURRETMK2 = ENTITY_TYPES.register("arrowturretmk2", () -> EntityType.Builder.of(ArrowTurretMk2::new, EntityClassification.MISC).sized(1f, 2.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "arrowturretmk2").toString()));
    public static final RegistryObject<EntityType<ScoutTurretMK2>> SCOUTTURRETMK2 = ENTITY_TYPES.register("scoutturretmk2", () -> EntityType.Builder.of(ScoutTurretMK2::new, EntityClassification.MISC).sized(1f, 2.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "scoutturretmk2").toString()));
    public static final RegistryObject<EntityType<FireTurretMk2>> FIRETURRETMK2 = ENTITY_TYPES.register("fireturretmk2", () -> EntityType.Builder.of(FireTurretMk2::new, EntityClassification.MISC).sized(1f, 2.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "fireturretmk2").toString()));
    public static final RegistryObject<EntityType<FireArrowTurretMk2>> FIREARROWTURRETMK2 = ENTITY_TYPES.register("firearrowturretmk2", () -> EntityType.Builder.of(FireArrowTurretMk2::new, EntityClassification.MISC).sized(1f, 2.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "firearrowturretmk2").toString()));
    public static final RegistryObject<EntityType<PotionArrowTurretMk2>> POTIONARROWTURRETMK2 = ENTITY_TYPES.register("potionarrowturretmk2", () -> EntityType.Builder.of(PotionArrowTurretMk2::new, EntityClassification.MISC).sized(1f, 2.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "potionarrowturretmk2").toString()));





    public static final RegistryObject<EntityType<TurretArrow>> TURRETARROW = ENTITY_TYPES.register("turretarrow", () -> EntityType.Builder.<TurretArrow>of(TurretArrow::new, EntityClassification.MISC).sized(0.5F, 1.975F).build(new ResourceLocation(VillainousSummon.MOD_ID, "turretarrow").toString()));
    public static final RegistryObject<EntityType<SlimeballProjectile>> SLIMEPROJECTILE = ENTITY_TYPES.register("slimeprojectile", () -> EntityType.Builder.<SlimeballProjectile>of(SlimeballProjectile::new, EntityClassification.MISC).sized(0.25f, 0.25f).build(new ResourceLocation(VillainousSummon.MOD_ID, "slimeprojectile").toString()));


    public static final RegistryObject<Item> SLIMESUMMON = ITEMS.register("slimesummon", () -> new ItemWithLore(new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1).defaultDurability(30), new String[] {TextFormatting.BLUE + "Summons a large slime to ride around on!", TextFormatting.BLUE + "Can bounce on enemies, jump high, and reduces fall damage!"}, 5));
    public static final RegistryObject<Item> HORSESUMMON = ITEMS.register("horsesummon", () -> new ItemWithLore(new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1).defaultDurability(50), new String[] {TextFormatting.BLUE + "Summons an average horse to ride around on!"}, 5));
    public static final RegistryObject<Item> WOLFSUMMON = ITEMS.register("wolfsummon", () -> new ItemWithLore(new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1).defaultDurability(50), new String[] {TextFormatting.BLUE + "Summons a temporary, but loyal pack of wolves to protect you!"}, 120));
    public static final RegistryObject<Item> VEXSUMMON = ITEMS.register("vexsummon", () -> new ItemWithLore(new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1).defaultDurability(50), new String[] {TextFormatting.BLUE + "Summons a temporary swarm of vex to attack monsters!", TextFormatting.RED + "Golems and some other mobs may not be very happy about this."}, 60));
    public static final RegistryObject<Item> BEARSUMMON = ITEMS.register("bearsummon", () -> new ItemWithLore(new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1).defaultDurability(50), new String[] {TextFormatting.BLUE + "Summons a temporary polar bear to attack monsters!"}, 90));


}

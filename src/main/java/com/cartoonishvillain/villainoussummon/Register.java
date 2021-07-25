package com.cartoonishvillain.villainoussummon;

import com.cartoonishvillain.villainoussummon.Entities.Minions.BearMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.VexMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.WolfMinion;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.HorseMount;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.cartoonishvillain.villainoussummon.Entities.Projectiles.*;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.ArrowTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.FireTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.SlimeTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.*;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.ArcaneTurretMk3;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.BallistaTurretMk3;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.CannonTurretMk3;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier4.RapidArrowTurretMk4;
import com.cartoonishvillain.villainoussummon.Items.CannonballItem;
import com.cartoonishvillain.villainoussummon.Items.ItemWithLore;
import com.cartoonishvillain.villainoussummon.Items.TurretPlacementItem;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.ChatFormatting;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.rmi.registry.Registry;

public class Register {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, VillainousSummon.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VillainousSummon.MOD_ID);

    public static void init(){ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus()); ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());}

    public static final RegistryObject<EntityType<SlimeMount>> SLIMEMOUNT = ENTITY_TYPES.register("slimemount", () -> EntityType.Builder.of(SlimeMount::new, MobCategory.CREATURE).sized(1, 1).build(new ResourceLocation(VillainousSummon.MOD_ID, "slimemount").toString()));
    public static final RegistryObject<EntityType<HorseMount>> HORSEMOUNT = ENTITY_TYPES.register("horsemount", () -> EntityType.Builder.of(HorseMount::new, MobCategory.CREATURE).sized(1.3964844F, 1.6F).build(new ResourceLocation(VillainousSummon.MOD_ID, "horsemount").toString()));
    public static final RegistryObject<EntityType<WolfMinion>> WOLFMINION = ENTITY_TYPES.register("wolfminion", () -> EntityType.Builder.of(WolfMinion::new, MobCategory.CREATURE).sized(0.6F, 0.85F).build(new ResourceLocation(VillainousSummon.MOD_ID, "wolfminion").toString()));
    public static final RegistryObject<EntityType<VexMinion>> VEXMINION = ENTITY_TYPES.register("vexminion", () -> EntityType.Builder.of(VexMinion::new, MobCategory.CREATURE).sized(0.6F, 0.85F).build(new ResourceLocation(VillainousSummon.MOD_ID, "vexminion").toString()));
    public static final RegistryObject<EntityType<BearMinion>> BEARMINION = ENTITY_TYPES.register("bearminion", () -> EntityType.Builder.of(BearMinion::new, MobCategory.CREATURE).sized(0.6F, 0.85F).build(new ResourceLocation(VillainousSummon.MOD_ID, "bearminion").toString()));

    public static final RegistryObject<EntityType<ArrowTurretMk1>> ARROWTURRETMK1 = ENTITY_TYPES.register("arrowturretmk1", () -> EntityType.Builder.of(ArrowTurretMk1::new, MobCategory.MISC).sized(1f, 2f).build(new ResourceLocation(VillainousSummon.MOD_ID, "arrowturretmk1").toString()));
    public static final RegistryObject<EntityType<FireTurretMk1>> FIRETURRETMK1 = ENTITY_TYPES.register("fireturretmk1", () -> EntityType.Builder.of(FireTurretMk1::new, MobCategory.MISC).sized(1f, 2f).build(new ResourceLocation(VillainousSummon.MOD_ID, "fireturretmk1").toString()));
    public static final RegistryObject<EntityType<SlimeTurretMk1>> SLIMETURRETMK1 = ENTITY_TYPES.register("slimeturretmk1", () -> EntityType.Builder.of(SlimeTurretMk1::new, MobCategory.MISC).sized(1f, 2f).build(new ResourceLocation(VillainousSummon.MOD_ID, "slimeturretmk1").toString()));

    public static final RegistryObject<EntityType<ArrowTurretMk2>> ARROWTURRETMK2 = ENTITY_TYPES.register("arrowturretmk2", () -> EntityType.Builder.of(ArrowTurretMk2::new, MobCategory.MISC).sized(1f, 2.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "arrowturretmk2").toString()));
    public static final RegistryObject<EntityType<ScoutTurretMK2>> SCOUTTURRETMK2 = ENTITY_TYPES.register("scoutturretmk2", () -> EntityType.Builder.of(ScoutTurretMK2::new, MobCategory.MISC).sized(1f, 2.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "scoutturretmk2").toString()));
    public static final RegistryObject<EntityType<FireTurretMk2>> FIRETURRETMK2 = ENTITY_TYPES.register("fireturretmk2", () -> EntityType.Builder.of(FireTurretMk2::new, MobCategory.MISC).sized(1f, 2.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "fireturretmk2").toString()));
    public static final RegistryObject<EntityType<FireArrowTurretMk2>> FIREARROWTURRETMK2 = ENTITY_TYPES.register("firearrowturretmk2", () -> EntityType.Builder.of(FireArrowTurretMk2::new, MobCategory.MISC).sized(1f, 2.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "firearrowturretmk2").toString()));
    public static final RegistryObject<EntityType<PotionArrowTurretMk2>> POTIONARROWTURRETMK2 = ENTITY_TYPES.register("potionarrowturretmk2", () -> EntityType.Builder.of(PotionArrowTurretMk2::new, MobCategory.MISC).sized(1f, 2.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "potionarrowturretmk2").toString()));

    public static final RegistryObject<EntityType<ArcaneTurretMk3>> ARCANETURRETMK3 = ENTITY_TYPES.register("arcaneturretmk3", () -> EntityType.Builder.of(ArcaneTurretMk3::new, MobCategory.MISC).sized(1.25f, 3.4375f).build(new ResourceLocation(VillainousSummon.MOD_ID, "arcaneturretmk3").toString()));
    public static final RegistryObject<EntityType<BallistaTurretMk3>> BALLISTATURRETMK3 = ENTITY_TYPES.register("ballistaturretmk3", () -> EntityType.Builder.of(BallistaTurretMk3::new, MobCategory.MISC).sized(1.25f, 3.4375f).build(new ResourceLocation(VillainousSummon.MOD_ID, "ballistaturretmk3").toString()));
    public static final RegistryObject<EntityType<CannonTurretMk3>> CANNONTURRETMK3 = ENTITY_TYPES.register("cannonturretmk3", () -> EntityType.Builder.of(CannonTurretMk3::new, MobCategory.MISC).sized(1.25f, 3.4375f).build(new ResourceLocation(VillainousSummon.MOD_ID, "cannonturretmk3").toString()));

    public static final RegistryObject<EntityType<RapidArrowTurretMk4>> RAPIDARROWTURRETMK4 = ENTITY_TYPES.register("rapidarrowturretmk4", () -> EntityType.Builder.of(RapidArrowTurretMk4::new, MobCategory.MISC).sized(1.25f, 3.4375f).build(new ResourceLocation(VillainousSummon.MOD_ID, "rapidarrowturretmk4").toString()));


    public static final RegistryObject<EntityType<TurretArrow>> TURRETARROW = ENTITY_TYPES.register("turretarrow", () -> EntityType.Builder.<TurretArrow>of(TurretArrow::new, MobCategory.MISC).sized(0.5F, 0.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "turretarrow").toString()));
    public static final RegistryObject<EntityType<BallistaArrow>> BALLISTAARROW = ENTITY_TYPES.register("ballistaarrow", () -> EntityType.Builder.<BallistaArrow>of(BallistaArrow::new, MobCategory.MISC).sized(0.5F, 0.5f).build(new ResourceLocation(VillainousSummon.MOD_ID, "ballistaarrow").toString()));
    public static final RegistryObject<EntityType<SlimeballProjectile>> SLIMEPROJECTILE = ENTITY_TYPES.register("slimeprojectile", () -> EntityType.Builder.<SlimeballProjectile>of(SlimeballProjectile::new, MobCategory.MISC).sized(0.25f, 0.25f).build(new ResourceLocation(VillainousSummon.MOD_ID, "slimeprojectile").toString()));
    public static final RegistryObject<EntityType<InnateCannonballProjectile>> INNATECANONBALL = ENTITY_TYPES.register("innatecannonballprojectile", () -> EntityType.Builder.<InnateCannonballProjectile>of(InnateCannonballProjectile::new, MobCategory.MISC).sized(0.25f, 0.25f).build(new ResourceLocation(VillainousSummon.MOD_ID, "innatecannonballprojectile").toString()));
    public static final RegistryObject<EntityType<CannonballProjectile>> CANNONBALLPROJECTILE = ENTITY_TYPES.register("cannonballprojectile", () -> EntityType.Builder.<CannonballProjectile>of(CannonballProjectile::new, MobCategory.MISC).sized(0.25f, 0.25f).build(new ResourceLocation(VillainousSummon.MOD_ID, "cannonballprojectile").toString()));




    public static final RegistryObject<Item> SLIMESUMMON = ITEMS.register("slimyapple", () -> new ItemWithLore(new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1).defaultDurability(30), new String[] {ChatFormatting.BLUE + "Summons a large slime to ride around on!", ChatFormatting.BLUE + "Can bounce on enemies, jump high, and reduces fall damage!", ChatFormatting.RED + "Prone to kicks for flying if flying is not enabled!"}, 5));
    public static final RegistryObject<Item> HORSESUMMON = ITEMS.register("enchantedapple", () -> new ItemWithLore(new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1).defaultDurability(50), new String[] {ChatFormatting.BLUE + "Summons an average horse to ride around on!"}, 5));
    public static final RegistryObject<Item> WOLFSUMMON = ITEMS.register("fetchstick", () -> new ItemWithLore(new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1).defaultDurability(50), new String[] {ChatFormatting.BLUE + "Summons a temporary, but loyal pack of wolves to protect you!"}, 120));
    public static final RegistryObject<Item> VEXSUMMON = ITEMS.register("emfreader", () -> new ItemWithLore(new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1).defaultDurability(50), new String[] {ChatFormatting.BLUE + "Summons a temporary swarm of vex to attack monsters!", ChatFormatting.RED + "Golems and some other mobs may not be very happy about this."}, 60));
    public static final RegistryObject<Item> BEARSUMMON = ITEMS.register("magicalsugarwater", () -> new ItemWithLore(new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1).defaultDurability(50), new String[] {ChatFormatting.BLUE + "Summons a temporary polar bear to attack monsters!"}, 90));

    public static final RegistryObject<Item> ARROWTURRETMK1SUMMON = ITEMS.register("arrowturretmk1summon", () -> new TurretPlacementItem(Register.ARROWTURRETMK1, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.BLUE + "Shoots arrows at nearby enemies to help keep them off your lawn."}));
    public static final RegistryObject<Item> FIRETURRETMK1SUMMON = ITEMS.register("fireturretmk1summon", () -> new TurretPlacementItem(Register.FIRETURRETMK1, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.BLUE + "Shoots fireballs at nearby enemies to burn them. May cause accidental forest fires."}));
    public static final RegistryObject<Item> SLIMETURRETMK1SUMMON = ITEMS.register("slimeturretmk1summon", () -> new TurretPlacementItem(Register.SLIMETURRETMK1, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.BLUE + "Shoots slimeballs at nearby enemies to slow them down"}));

    public static final RegistryObject<Item> ARROWTURRETMK2SUMMON = ITEMS.register("arrowturretmk2summon", () -> new TurretPlacementItem(Register.ARROWTURRETMK2, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.GREEN + "Shoots arrows at a faster rate from their tier 1 counterpart, with the bonuses of an upgraded shell"}));
    public static final RegistryObject<Item> SCOUTTURRETMK2SUMMON = ITEMS.register("scoutturretmk2summon", () -> new TurretPlacementItem(Register.SCOUTTURRETMK2, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.GREEN + "Spots nearby enemies and gives them the glowing effect"}));
    public static final RegistryObject<Item> FIRETURRETMK2SUMMON = ITEMS.register("fireturretmk2summon", () -> new TurretPlacementItem(Register.FIRETURRETMK2, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.GREEN + "Shoots fireballs at a faster rate from their tier 1 counterpart, with the bonuses of an upgraded shell"}));
    public static final RegistryObject<Item> FIREARROWTURRETMK2SUMMON = ITEMS.register("firearrowturretmk2summon", () -> new TurretPlacementItem(Register.FIREARROWTURRETMK2, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.GREEN + "Fires flaming arrows at enemies.", ChatFormatting.RED + "Some design compromises were made to support flaming arrows."}));
    public static final RegistryObject<Item> POTIONARROWTURRETMK2SUMMON = ITEMS.register("potionarrowturretmk2summon", () -> new TurretPlacementItem(Register.POTIONARROWTURRETMK2, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.GREEN + "Fires potion tipped arrows at enemies.", ChatFormatting.RED + "Some design compromises were made to support potions."}));

    public static final RegistryObject<Item> ARCANETURRETMK3SUMMON = ITEMS.register("arcaneturretmk3summon", () -> new TurretPlacementItem(Register.ARCANETURRETMK3, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.RED + "Casts lightning down on it's targets with debuffs, including potentially severe ones."}));
    public static final RegistryObject<Item> BALLISTATURRETMK3SUMMON = ITEMS.register("ballistaturretmk3summon", () -> new TurretPlacementItem(Register.BALLISTATURRETMK3, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.RED + "Fires a high power bolt that pierces through enemies at a slow rate"}));
    public static final RegistryObject<Item> CANNONTURRETMK3SUMMON = ITEMS.register("cannonturretmk3summon", () -> new TurretPlacementItem(Register.CANNONTURRETMK3, 1, 1, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.RED +"Fires highly explosive munitions at targets", ChatFormatting.RED + "May accidentally hit friendlies"}));

    public static final RegistryObject<Item> RAPIDARROWTURRETMK4SUMMON = ITEMS.register("rapidarrowturretmk4summon", () -> new TurretPlacementItem(Register.RAPIDARROWTURRETMK4, 16777215, 16777215, new Item.Properties().tab(VillainousSummon.TAB).stacksTo(1), new String[]{ChatFormatting.LIGHT_PURPLE + "Creative only!", ChatFormatting.LIGHT_PURPLE + "Fires arrows at an alarming rate."}));

    public static final RegistryObject<Item> REDSTONEBRAIN = ITEMS.register("redstonebrain", () -> new Item(new Item.Properties().tab(VillainousSummon.TAB)));
    public static final RegistryObject<Item> EMPTYT1SHELL = ITEMS.register("emptymk1shell", () -> new Item(new Item.Properties().tab(VillainousSummon.TAB)));
    public static final RegistryObject<Item> POUCHOFARROWS = ITEMS.register("pouchofarrows", () -> new Item(new Item.Properties().tab(VillainousSummon.TAB)));
    public static final RegistryObject<Item> POUCHOFFUEL = ITEMS.register("pouchoffuel", () -> new Item(new Item.Properties().tab(VillainousSummon.TAB)));
    public static final RegistryObject<Item> POUCHOFSLIME = ITEMS.register("pouchofslime", () -> new Item(new Item.Properties().tab(VillainousSummon.TAB)));
    public static final RegistryObject<Item> IRONSTAND = ITEMS.register("ironturretstand", () -> new Item(new Item.Properties().tab(VillainousSummon.TAB)));
    public static final RegistryObject<Item> EMPTYT2SHELL = ITEMS.register("emptymk2shell", () -> new Item(new Item.Properties().tab(VillainousSummon.TAB)));
    public static final RegistryObject<Item> DIAMONDSTAND = ITEMS.register("diamondturretstand", () -> new Item(new Item.Properties().tab(VillainousSummon.TAB)));
    public static final RegistryObject<Item> EMPTYT3SHELL = ITEMS.register("emptymk3shell", () -> new Item(new Item.Properties().tab(VillainousSummon.TAB)));
    public static final RegistryObject<Item> CANNONBALL = ITEMS.register("cannonball", () -> new CannonballItem(new Item.Properties().tab(VillainousSummon.TAB)));







}

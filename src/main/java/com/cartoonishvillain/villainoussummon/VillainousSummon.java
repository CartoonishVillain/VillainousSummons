package com.cartoonishvillain.villainoussummon;

import com.cartoonishvillain.villainoussummon.Entities.Minions.BearMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.VexMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.WolfMinion;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.HorseMount;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.ArrowTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.FireTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.SlimeTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.*;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("villainoussummons")

public class VillainousSummon
{

    public static final String MOD_ID = "villainoussummons";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public VillainousSummon() {
        Register.init();
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(Register.SLIMEMOUNT.get(), SlimeMount.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.HORSEMOUNT.get(), HorseMount.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.WOLFMINION.get(), WolfMinion.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.VEXMINION.get(), VexMinion.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.BEARMINION.get(), BearMinion.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.ARROWTURRETMK1.get(), ArrowTurretMk1.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.FIRETURRETMK1.get(), FireTurretMk1.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.SLIMETURRETMK1.get(), SlimeTurretMk1.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.ARROWTURRETMK2.get(), ArrowTurretMk2.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.SCOUTTURRETMK2.get(), ScoutTurretMK2.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.FIRETURRETMK2.get(), FireTurretMk2.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.FIREARROWTURRETMK2.get(), FireArrowTurretMk2.customAttributes().build());
            GlobalEntityTypeAttributes.put(Register.POTIONARROWTURRETMK2.get(), PotionArrowTurretMk2.customAttributes().build());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

    }

    private void processIMC(final InterModProcessEvent event)
    {

    }
//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(FMLServerStartingEvent Event) {
//        // do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }
//
//    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
//    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            // register a new block here
//            LOGGER.info("HELLO from Register Block");
//        }
//    }

    public static final ItemGroup TAB = new ItemGroup("WHATISTHIS") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Register.SLIMESUMMON.get());
        }
    };
}

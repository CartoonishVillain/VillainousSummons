package com.cartoonishvillain.villainoussummon.Events;

import com.cartoonishvillain.villainoussummon.Entities.Minions.BearMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.VexMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.WolfMinion;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.HorseMount;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.ArrowTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.FireTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier1.SlimeTurretMk1;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier2.*;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.ArcaneTurretMk3;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.BallistaTurretMk3;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier3.CannonTurretMk3;
import com.cartoonishvillain.villainoussummon.Entities.Turrets.Tier4.RapidArrowTurretMk4;
import com.cartoonishvillain.villainoussummon.Register;
import com.cartoonishvillain.villainoussummon.VillainousSummon;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VillainousSummon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBus {
    @SubscribeEvent
    public static void attributeAssigner(EntityAttributeCreationEvent event){
              event.put(Register.SLIMEMOUNT.get(), SlimeMount.customAttributes().build());
             event.put(Register.HORSEMOUNT.get(), HorseMount.customAttributes().build());
             event.put(Register.WOLFMINION.get(), WolfMinion.customAttributes().build());
             event.put(Register.VEXMINION.get(), VexMinion.customAttributes().build());
             event.put(Register.BEARMINION.get(), BearMinion.customAttributes().build());
        event.put(Register.ARROWTURRETMK1.get(), ArrowTurretMk1.customAttributes().build());
        event.put(Register.FIRETURRETMK1.get(), FireTurretMk1.customAttributes().build());
        event.put(Register.SLIMETURRETMK1.get(), SlimeTurretMk1.customAttributes().build());
        event.put(Register.ARROWTURRETMK2.get(), ArrowTurretMk2.customAttributes().build());
        event.put(Register.SCOUTTURRETMK2.get(), ScoutTurretMK2.customAttributes().build());
        event.put(Register.FIRETURRETMK2.get(), FireTurretMk2.customAttributes().build());
        event.put(Register.FIREARROWTURRETMK2.get(), FireArrowTurretMk2.customAttributes().build());
        event.put(Register.POTIONARROWTURRETMK2.get(), PotionArrowTurretMk2.customAttributes().build());
        event.put(Register.CANNONTURRETMK3.get(), CannonTurretMk3.customAttributes().build());
        event.put(Register.ARCANETURRETMK3.get(), ArcaneTurretMk3.customAttributes().build());
        event.put(Register.BALLISTATURRETMK3.get(), BallistaTurretMk3.customAttributes().build());
        event.put(Register.RAPIDARROWTURRETMK4.get(), RapidArrowTurretMk4.customAttributes().build());
    }
}

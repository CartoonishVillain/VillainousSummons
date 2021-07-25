package com.cartoonishvillain.villainoussummon.Events;

import com.cartoonishvillain.villainoussummon.Entities.Minions.BearMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.VexMinion;
import com.cartoonishvillain.villainoussummon.Entities.Minions.WolfMinion;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.HorseMount;
import com.cartoonishvillain.villainoussummon.Entities.Mounts.SlimeMount;
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
//            DefaultAttributes.put(Register.ARROWTURRETMK1.get(), ArrowTurretMk1.customAttributes().build());
//            DefaultAttributes.put(Register.FIRETURRETMK1.get(), FireTurretMk1.customAttributes().build());
//            DefaultAttributes.put(Register.SLIMETURRETMK1.get(), SlimeTurretMk1.customAttributes().build());
//            DefaultAttributes.put(Register.ARROWTURRETMK2.get(), ArrowTurretMk2.customAttributes().build());
//            DefaultAttributes.put(Register.SCOUTTURRETMK2.get(), ScoutTurretMK2.customAttributes().build());
//            DefaultAttributes.put(Register.FIRETURRETMK2.get(), FireTurretMk2.customAttributes().build());
//            DefaultAttributes.put(Register.FIREARROWTURRETMK2.get(), FireArrowTurretMk2.customAttributes().build());
//            DefaultAttributes.put(Register.POTIONARROWTURRETMK2.get(), PotionArrowTurretMk2.customAttributes().build());
//            DefaultAttributes.put(Register.CANNONTURRETMK3.get(), CannonTurretMk3.customAttributes().build());
//            DefaultAttributes.put(Register.ARCANETURRETMK3.get(), ArcaneTurretMk3.customAttributes().build());
//            DefaultAttributes.put(Register.BALLISTATURRETMK3.get(), BallistaTurretMk3.customAttributes().build());
//            DefaultAttributes.put(Register.RAPIDARROWTURRETMK4.get(), RapidArrowTurretMk4.customAttributes().build());
    }
}

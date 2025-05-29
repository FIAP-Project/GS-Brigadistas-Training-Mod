package com.cerbon.brigadista_training.neoforge.events;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.cerbon.brigadista_training.neoforge.key_mapping.BDTKeyMappings;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(modid = BrigadistaTraining.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BDTClientEvents {

    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(BDTKeyMappings.OPEN_QUIZ_SCREEN_MAPPING.get());
    }
}

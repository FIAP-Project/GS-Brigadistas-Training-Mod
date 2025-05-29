package com.cerbon.brigadista_training.neoforge.events;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.cerbon.brigadista_training.neoforge.key_mapping.BDTKeyMappings;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = BrigadistaTraining.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class NeoClientEvents {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        BDTKeyMappings.handleKeyPressed();
    }
}

package com.cerbon.brigadista_training.neoforge.events;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.cerbon.brigadista_training.client.screen.APIScreen;
import com.cerbon.brigadista_training.neoforge.key_mapping.BDTKeyMappings;
import com.cerbon.cerbons_api.api.general.event.TimedEvent;
import com.cerbon.cerbons_api.api.static_utilities.CapabilityUtils;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = BrigadistaTraining.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class NeoClientEvents {

    @SubscribeEvent
    public static void onClientJoinWorld(ClientPlayerNetworkEvent.LoggingIn event) {
        //Add delay because the screen was not showing
        //TODO: Prevent screen if API key has already being setup
        CapabilityUtils.getLevelEventScheduler(event.getPlayer().level()).addEvent(
                new TimedEvent(
                        () -> Minecraft.getInstance().setScreen(new APIScreen()),
                        60
                )
        );
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        BDTKeyMappings.handleKeyPressed();
    }
}

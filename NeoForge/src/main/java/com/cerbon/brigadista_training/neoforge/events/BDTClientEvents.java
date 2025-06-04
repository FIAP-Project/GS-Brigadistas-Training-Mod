package com.cerbon.brigadista_training.neoforge.events;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.cerbon.brigadista_training.block_entity.BDTBlockEntities;
import com.cerbon.brigadista_training.block_entity.custom.InfoOverlayBlockEntityRenderer;
import com.cerbon.brigadista_training.client.gui.InfoOverlay;
import com.cerbon.brigadista_training.neoforge.key_mapping.BDTKeyMappings;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@EventBusSubscriber(modid = BrigadistaTraining.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BDTClientEvents {

    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(BDTKeyMappings.OPEN_QUIZ_SCREEN_MAPPING.get());
        event.register(BDTKeyMappings.INFO_OVERLAY_MAPPING.get());
    }

    @SubscribeEvent
    public static void onRegisterOverlays(RegisterGuiLayersEvent event) {
        event.registerBelow(VanillaGuiLayers.DEBUG_OVERLAY, ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "info_overlay"), InfoOverlay.INSTANCE);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BDTBlockEntities.INFO_OVERLAY_BLOCK_ENTITY.get(), ctx -> new InfoOverlayBlockEntityRenderer());
    }
}

package com.cerbon.brigadista_training.fabric;

import com.cerbon.brigadista_training.BrigadistaTraining;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class BrigadistaTrainingFabric implements ModInitializer, ClientModInitializer {

    @Override
    public void onInitialize() {
        BrigadistaTraining.init();
    }

    @Override
    public void onInitializeClient() {}
}
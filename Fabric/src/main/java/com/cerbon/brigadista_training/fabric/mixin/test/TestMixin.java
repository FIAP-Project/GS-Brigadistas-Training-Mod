package com.cerbon.brigadista_training.fabric.mixin.test;

import com.cerbon.brigadista_training.BrigadistaTraining;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Class used to test if fabric only mixins are being applied
@Mixin(Minecraft.class)
public abstract class TestMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void sendMessageIfWorking(GameConfig gameConfig, CallbackInfo ci) {
        BrigadistaTraining.LOGGER.info("Fabric only mixins are working for {}!",  BrigadistaTraining.MOD_NAME);
    }
}
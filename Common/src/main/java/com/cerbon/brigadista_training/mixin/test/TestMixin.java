package com.cerbon.brigadista_training.mixin.test;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.cerbon.cerbons_api.api.static_utilities.MiscUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Class used to test if common mixins are being applied
@Mixin(Minecraft.class)
public abstract class TestMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void sendMessageIfWorking(GameConfig gameConfig, CallbackInfo ci) {
        BrigadistaTraining.LOGGER.info("Common mixins are working for {} on {}!",  BrigadistaTraining.MOD_NAME, MiscUtils.getPlatformName());
    }
}

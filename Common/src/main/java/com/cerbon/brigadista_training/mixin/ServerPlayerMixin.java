package com.cerbon.brigadista_training.mixin;

import com.cerbon.brigadista_training.util.IServerPlayerMixin;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin implements IServerPlayerMixin {
    @Unique private int blocksCollected = 0;
    @Unique private final String blocksCollectedTag = "blocksCollected";

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void saveAdditional(CompoundTag tag, CallbackInfo ci) {
        tag.putInt(blocksCollectedTag, blocksCollected);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void readAdditional(CompoundTag tag, CallbackInfo ci) {
        if (tag.contains(blocksCollectedTag))
            blocksCollected = tag.getInt(blocksCollectedTag);
    }

    @Override
    public void increaseBlocksCollected() {
        blocksCollected++;
    }

    @Override
    public void resetBlocksCollected() {
        blocksCollected = 0;
    }

    @Override
    public int getBlocksCollectedAmount() {
        return blocksCollected;
    }
}

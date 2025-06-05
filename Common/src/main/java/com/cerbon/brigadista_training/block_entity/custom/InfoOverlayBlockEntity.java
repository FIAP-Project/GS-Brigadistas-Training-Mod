package com.cerbon.brigadista_training.block_entity.custom;

import com.cerbon.brigadista_training.block_entity.BDTBlockEntities;
import com.cerbon.brigadista_training.client.gui.InfoOverlay;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class InfoOverlayBlockEntity extends BlockEntity implements GeoBlockEntity {
    private final AABB INFO_BOX = new AABB(this.getBlockPos()).inflate(6.0D);

    private boolean wasInRange = false;
    private String text = "";

    private final AnimatableInstanceCache animationFactory = GeckoLibUtil.createInstanceCache(this);

    public InfoOverlayBlockEntity(BlockPos pos, BlockState blockState) {
        super(BDTBlockEntities.INFO_OVERLAY_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Environment(EnvType.CLIENT)
    public static void clientTick(Level level, BlockPos blockPos, BlockState blockState, InfoOverlayBlockEntity blockEntity) {
        if (!level.isClientSide() || blockEntity.text.isBlank()) return;

        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        boolean inRange = blockEntity.INFO_BOX.contains(player.position());

        if (inRange && !blockEntity.wasInRange)
            InfoOverlay.show(blockEntity.text);

        else if (!inRange && blockEntity.wasInRange)
            InfoOverlay.hide();

        blockEntity.wasInRange = inRange;
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, InfoOverlayBlockEntity blockEntity) {}

    @Override
    public void setRemoved() {
        if (this.level != null && this.level.isClientSide)
            InfoOverlay.hide();

        super.setRemoved();
    }

    public InfoOverlayBlockEntity setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animationFactory;
    }
}

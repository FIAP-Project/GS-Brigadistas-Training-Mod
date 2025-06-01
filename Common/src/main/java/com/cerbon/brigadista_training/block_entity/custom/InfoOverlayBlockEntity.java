package com.cerbon.brigadista_training.block_entity.custom;

import com.cerbon.brigadista_training.block_entity.BDTBlockEntities;
import com.cerbon.brigadista_training.client.gui.InfoOverlay;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class InfoOverlayBlockEntity extends BlockEntity {
    private final AABB INFO_BOX = new AABB(this.getBlockPos()).inflate(6.0D);

    private boolean wasInRange = false;
    private String text = "";

    public InfoOverlayBlockEntity(BlockPos pos, BlockState blockState) {
        super(BDTBlockEntities.INFO_OVERLAY_BLOCK_ENTITY.get(), pos, blockState);
    }

    public static void clientTick(Level level, BlockPos blockPos, BlockState blockState, InfoOverlayBlockEntity blockEntity) {
        if (!level.isClientSide()) return;

        List<Player> players = level.getEntitiesOfClass(Player.class, blockEntity.INFO_BOX);

        for (Player player : players) {
            boolean inRange = blockEntity.INFO_BOX.contains(player.position());

            if (inRange && !blockEntity.wasInRange)
                InfoOverlay.show(blockEntity.text);

            else if (!inRange && blockEntity.wasInRange)
                InfoOverlay.hide();

            blockEntity.wasInRange = inRange;
        }
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
}

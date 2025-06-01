package com.cerbon.brigadista_training.block.custom;

import com.cerbon.brigadista_training.block_entity.BDTBlockEntities;
import com.cerbon.brigadista_training.block_entity.custom.InfoOverlayBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InfoOverlayBlock extends BaseEntityBlock {
    public static final MapCodec<InfoOverlayBlock> CODEC = simpleCodec(InfoOverlayBlock::new);

    private String text = "";

    public InfoOverlayBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new InfoOverlayBlockEntity(pos, state).setText(text);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BDTBlockEntities.INFO_OVERLAY_BLOCK_ENTITY.get(), level.isClientSide ? InfoOverlayBlockEntity::clientTick : InfoOverlayBlockEntity::serverTick);
    }

    public InfoOverlayBlock setText(String text) {
        this.text = text;
        return this;
    }
}

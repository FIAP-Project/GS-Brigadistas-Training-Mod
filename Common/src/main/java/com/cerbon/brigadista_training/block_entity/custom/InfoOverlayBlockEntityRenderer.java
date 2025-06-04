package com.cerbon.brigadista_training.block_entity.custom;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class InfoOverlayBlockEntityRenderer extends GeoBlockRenderer<InfoOverlayBlockEntity> {

    public InfoOverlayBlockEntityRenderer() {
        super(new InfoOverlayBlockEntityModel());
    }

    //Overriding NeoForge method
    public AABB getRenderBoundingBox(BlockEntity blockEntity) {
        return new AABB(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
}

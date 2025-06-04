package com.cerbon.brigadista_training.block_entity.custom;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class InfoOverlayBlockEntityRenderer extends GeoBlockRenderer<InfoOverlayBlockEntity> {

    public InfoOverlayBlockEntityRenderer() {
        super(new InfoOverlayBlockEntityModel());
    }

}

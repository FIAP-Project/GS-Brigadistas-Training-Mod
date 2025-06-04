package com.cerbon.brigadista_training.block_entity.custom;

import com.cerbon.brigadista_training.BrigadistaTraining;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class InfoOverlayBlockEntityModel extends DefaultedBlockGeoModel<InfoOverlayBlockEntity> {

    public InfoOverlayBlockEntityModel() {
        super(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(InfoOverlayBlockEntity animatable) {
        return buildFormattedModelPath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "fogueira_mal_apagada"));
    }

    @Override
    public ResourceLocation getTextureResource(InfoOverlayBlockEntity animatable) {
        return buildFormattedTexturePath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "fogueira_mal_apagada"));
    }

    @Override
    public ResourceLocation getAnimationResource(InfoOverlayBlockEntity animatable) {
        return buildFormattedAnimationPath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "fogueira_mal_apagada"));
    }
}

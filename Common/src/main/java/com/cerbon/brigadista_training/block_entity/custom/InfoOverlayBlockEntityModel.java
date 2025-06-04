package com.cerbon.brigadista_training.block_entity.custom;

import com.cerbon.brigadista_training.BrigadistaTraining;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class InfoOverlayBlockEntityModel extends DefaultedBlockGeoModel<InfoOverlayBlockEntity> {

    public InfoOverlayBlockEntityModel() {
        super(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(InfoOverlayBlockEntity animatable) {
        String blockKey = BuiltInRegistries.BLOCK.getKey(animatable.getBlockState().getBlock()).toString();

        return switch (blockKey) {
            case "brigadista_training:fogueira_mal_apagada" -> buildFormattedModelPath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "fogueira_mal_apagada"));
            case "brigadista_training:poste" -> buildFormattedModelPath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "poste"));
            default -> throw new IllegalStateException("Unexpected value: " + blockKey);
        };
    }

    @Override
    public ResourceLocation getTextureResource(InfoOverlayBlockEntity animatable) {
        String blockKey = BuiltInRegistries.BLOCK.getKey(animatable.getBlockState().getBlock()).toString();

        return switch (blockKey) {
            case "brigadista_training:fogueira_mal_apagada" -> buildFormattedTexturePath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "fogueira_mal_apagada"));
            case "brigadista_training:poste" -> buildFormattedTexturePath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "poste"));
            default -> throw new IllegalStateException("Unexpected value: " + blockKey);
        };
    }

    @Override
    public ResourceLocation getAnimationResource(InfoOverlayBlockEntity animatable) {
        return buildFormattedAnimationPath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "fogueira_mal_apagada"));
    }
}

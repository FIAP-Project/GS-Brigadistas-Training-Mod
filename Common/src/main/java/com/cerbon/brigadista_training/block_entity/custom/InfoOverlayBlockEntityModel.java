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
            case "brigadista_training:garrafas_quebradas" -> buildFormattedModelPath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "garrafas_quebradas"));
            case "brigadista_training:bituca_de_cigarro" -> buildFormattedModelPath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "bituca_de_cigarro"));
            case "brigadista_training:fire_extinguisher" -> buildFormattedModelPath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "fire_extinguisher"));
            case "brigadista_training:balloon" -> buildFormattedModelPath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "balloon"));
            default -> throw new IllegalStateException("Unexpected value: " + blockKey);
        };
    }

    @Override
    public ResourceLocation getTextureResource(InfoOverlayBlockEntity animatable) {
        String blockKey = BuiltInRegistries.BLOCK.getKey(animatable.getBlockState().getBlock()).toString();

        return switch (blockKey) {
            case "brigadista_training:fogueira_mal_apagada" -> buildFormattedTexturePath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "fogueira_mal_apagada"));
            case "brigadista_training:poste" -> buildFormattedTexturePath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "poste"));
            case "brigadista_training:garrafas_quebradas" -> buildFormattedTexturePath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "garrafas_quebradas"));
            case "brigadista_training:bituca_de_cigarro" -> buildFormattedTexturePath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "bituca_de_cigarro"));
            case "brigadista_training:fire_extinguisher" -> buildFormattedTexturePath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "fire_extinguisher"));
            case "brigadista_training:balloon" -> buildFormattedTexturePath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "balloon"));
            default -> throw new IllegalStateException("Unexpected value: " + blockKey);
        };
    }

    @Override
    public ResourceLocation getAnimationResource(InfoOverlayBlockEntity animatable) {
        return buildFormattedAnimationPath(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, ""));
    }
}

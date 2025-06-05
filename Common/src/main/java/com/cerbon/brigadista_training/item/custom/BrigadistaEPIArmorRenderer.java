package com.cerbon.brigadista_training.item.custom;

import com.cerbon.brigadista_training.BrigadistaTraining;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BrigadistaEPIArmorRenderer extends GeoArmorRenderer<BrigadistaEPIArmorItem> {

    public BrigadistaEPIArmorRenderer() {
        super(new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath(BrigadistaTraining.MOD_ID, "armor/brigadista_epi")));
    }
}

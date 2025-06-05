package com.cerbon.brigadista_training.item;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.cerbon.cerbons_api.api.registry.RegistryEntry;
import com.cerbon.cerbons_api.api.registry.ResourcefulRegistries;
import com.cerbon.cerbons_api.api.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.Map;

public class BDTArmorMaterials {
    public static final ResourcefulRegistry<ArmorMaterial> ARMOR_MATERIALS = ResourcefulRegistries.create(
            BuiltInRegistries.ARMOR_MATERIAL,
            BrigadistaTraining.MOD_ID
    );

    public static final RegistryEntry<ArmorMaterial> EPI = ARMOR_MATERIALS.register(
            "epi",
            () -> new ArmorMaterial(
                    Map.of(
                            ArmorItem.Type.BOOTS, 2,
                            ArmorItem.Type.LEGGINGS, 5,
                            ArmorItem.Type.CHESTPLATE, 6,
                            ArmorItem.Type.HELMET, 2,
                            ArmorItem.Type.BODY, 5
                    ),
                    9,
                    SoundEvents.ARMOR_EQUIP_IRON,
                    () -> Ingredient.EMPTY,
                    List.of(),
                    0.0F,
                    0.0F
            )
    );

    public static void register() {
        ARMOR_MATERIALS.register();
    }
}

package com.cerbon.brigadista_training.item;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.cerbon.brigadista_training.item.custom.BrigadistaEPIArmorItem;
import com.cerbon.cerbons_api.api.registry.RegistryEntry;
import com.cerbon.cerbons_api.api.registry.ResourcefulRegistries;
import com.cerbon.cerbons_api.api.registry.ResourcefulRegistry;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BDTItems {
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(
            BuiltInRegistries.ITEM,
            BrigadistaTraining.MOD_ID
    );

    public static Map<ArmorItem.Type, RegistryEntry<ArmorItem>> BRIGADISTA_EPI = registerFullArmorSet(() -> BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(BDTArmorMaterials.EPI.get()), 12);

    // ============ Registration Methods ============
    public static Map<ArmorItem.Type, RegistryEntry<ArmorItem>> registerFullArmorSet(Supplier<Holder<ArmorMaterial>> material, int durabilityFactor) {
        return registerFullArmorSet(
                material,
                List.of(durabilityFactor, durabilityFactor, durabilityFactor, durabilityFactor)
        );
    }

    public static Map<ArmorItem.Type, RegistryEntry<ArmorItem>> registerFullArmorSet(Supplier<Holder<ArmorMaterial>> material, List<Integer> durabilityFactors) {
        return registerFullArmorSet(material, properties -> properties, durabilityFactors);
    }

    public static Map<ArmorItem.Type, RegistryEntry<ArmorItem>> registerFullArmorSet(Supplier<Holder<ArmorMaterial>> material, UnaryOperator<Item.Properties> itemProperties, List<Integer> durabilityFactors) {
        Preconditions.checkArgument(
                durabilityFactors != null && durabilityFactors.size() == 4,
                "Expected durability array of length 4 (helmet, chest, legs, boots)"
        );

        return ImmutableMap.of(
                ArmorItem.Type.HELMET, registerArmor(ArmorItem.Type.HELMET, material, itemProperties, durabilityFactors.get(0)),
                ArmorItem.Type.CHESTPLATE, registerArmor(ArmorItem.Type.CHESTPLATE, material, itemProperties, durabilityFactors.get(1)),
                ArmorItem.Type.LEGGINGS, registerArmor(ArmorItem.Type.LEGGINGS, material, itemProperties, durabilityFactors.get(2)),
                ArmorItem.Type.BOOTS, registerArmor(ArmorItem.Type.BOOTS, material, itemProperties, durabilityFactors.get(3))
        );
    }

    public static RegistryEntry<ArmorItem> registerArmor(ArmorItem.Type armorType, Supplier<Holder<ArmorMaterial>> material, UnaryOperator<Item.Properties> itemProperties, int durabilityFactor) {
        String materialName = "epi";
        return registerItem(() -> new BrigadistaEPIArmorItem(material.get(), armorType, itemProperties.apply(new Item.Properties().durability(armorType.getDurability(durabilityFactor)))), materialName + "_" + armorType.getSerializedName());
    }

    public static RegistryEntry<Item> registerItem(String id) {
        return registerItem(new Item.Properties(), id);
    }

    public static RegistryEntry<Item> registerItem(Item.Properties itemProperties, String id) {
        return registerItem(() -> new Item(itemProperties), id);
    }

    public static<T extends Item> RegistryEntry<T> registerItem(Supplier<T> item, String id) {
        return ITEMS.register(id, item);
    }

    public static void register() {
        ITEMS.register();
    }
}

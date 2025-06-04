package com.cerbon.brigadista_training.block_entity;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.cerbon.brigadista_training.block.BDTBlocks;
import com.cerbon.brigadista_training.block_entity.custom.InfoOverlayBlockEntity;
import com.cerbon.cerbons_api.api.registry.RegistryEntry;
import com.cerbon.cerbons_api.api.registry.ResourcefulRegistries;
import com.cerbon.cerbons_api.api.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BDTBlockEntities {
    public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITIES = ResourcefulRegistries.create(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BrigadistaTraining.MOD_ID
    );

    public static final RegistryEntry<BlockEntityType<InfoOverlayBlockEntity>> INFO_OVERLAY_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "info_overlay_block_entity",
            () -> BlockEntityType.Builder
                    .of(InfoOverlayBlockEntity::new, BDTBlocks.FOGUEIRA_MAL_APAGADA.get())
                    .build(null)
    );

    public static void register() {
        BLOCK_ENTITIES.register();
    }
}

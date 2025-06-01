package com.cerbon.brigadista_training.block;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.cerbon.brigadista_training.block.custom.InfoOverlayBlock;
import com.cerbon.cerbons_api.api.registry.RegistryEntry;
import com.cerbon.cerbons_api.api.registry.ResourcefulRegistries;
import com.cerbon.cerbons_api.api.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BDTBlocks {
    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(
            BuiltInRegistries.BLOCK,
            BrigadistaTraining.MOD_ID
    );

    //TODO: Remove test block
    public static final RegistryEntry<InfoOverlayBlock> TEST_BLOCK = BLOCKS.register(
            "test_block",
            () -> new InfoOverlayBlock(BlockBehaviour.Properties.of()).setText("Teste de mensagem no bloco de teste.")
    );

    public static void register() {
        BLOCKS.register();
    }
}

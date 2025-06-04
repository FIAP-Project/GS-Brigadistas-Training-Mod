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

    public static final RegistryEntry<InfoOverlayBlock> FOGUEIRA_MAL_APAGADA = BLOCKS.register(
            "fogueira_mal_apagada",
            () -> new InfoOverlayBlock(BlockBehaviour.Properties.of().noOcclusion())
                    .setText("Fogueiras que não são completamente extintas podem manter brasas ativas por horas. Com ventos, essas brasas podem se espalhar e iniciar incêndios em áreas próximas.")
    );

    public static final RegistryEntry<InfoOverlayBlock> POSTE = BLOCKS.register(
            "poste",
            () -> new InfoOverlayBlock(BlockBehaviour.Properties.of().noOcclusion())
                    .setText("Cabos de energia que caem ao solo podem gerar faíscas ou curtos-circuitos, especialmente em contato com vegetação seca, iniciando incêndios.")
    );

    public static void register() {
        BLOCKS.register();
    }
}

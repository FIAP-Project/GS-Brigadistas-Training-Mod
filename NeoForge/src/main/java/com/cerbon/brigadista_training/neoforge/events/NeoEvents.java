package com.cerbon.brigadista_training.neoforge.events;

import com.cerbon.brigadista_training.BrigadistaTraining;
import com.cerbon.brigadista_training.block.BDTBlocks;
import com.cerbon.brigadista_training.block.custom.InfoOverlayBlock;
import com.cerbon.brigadista_training.packet.custom.OpenQuizScreenS2CPacket;
import com.cerbon.brigadista_training.util.IServerPlayerMixin;
import com.cerbon.cerbons_api.api.network.Dispatcher;
import com.cerbon.cerbons_api.api.registry.RegistryEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.Map;

@EventBusSubscriber(modid = BrigadistaTraining.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class NeoEvents {
    private static final Map<BlockPos, RegistryEntry<InfoOverlayBlock>> POS_BLOCK_MAP = Map.of(
            new BlockPos(118, 80, -192), BDTBlocks.FOGUEIRA_MAL_APAGADA,
            new BlockPos(197, 79, -225), BDTBlocks.POSTE,
            new BlockPos(155, 80, -282), BDTBlocks.GARRAFAS_QUEBRADAS,
            new BlockPos(96,  97, -295), BDTBlocks.BITUCA_DE_CIGARRO,
            new BlockPos(113, 79, -219), BDTBlocks.BALLOON
    );

    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event) {
        if (!event.getPlayer().isCreative() && BDTBlocks.BLOCKS.stream().noneMatch(blockEntry -> blockEntry.get() == event.getState().getBlock()))
            event.setCanceled(true);

        else if (event.getPlayer() instanceof ServerPlayer serverPlayer && !serverPlayer.isCreative()) {
            IServerPlayerMixin playerMixin = (IServerPlayerMixin) serverPlayer;
            playerMixin.increaseBlocksCollected();

            if (playerMixin.getBlocksCollectedAmount() >= 5) {
                BlockPos spawnPoint = serverPlayer.getRespawnPosition();
                if (spawnPoint == null) return;

                serverPlayer.absMoveTo(spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ());
                serverPlayer.removeTag("inMission");

                Dispatcher.sendToClient(new OpenQuizScreenS2CPacket(), serverPlayer);
            }
        }
    }

    @SubscribeEvent
    public static void onTeleport(EntityTeleportEvent.TeleportCommand event) {
        if (event.getEntity() instanceof Player player && player.getTags().contains("inMission")) {
            BrigadistaTraining.LOGGER.info("Initialized mission!");
            initMission(player.level(), player);
        }
    }

    private static void initMission(Level level, Player player) {
        if (level.isClientSide()) return;

        IServerPlayerMixin playerMixin = (IServerPlayerMixin) player;
        playerMixin.resetBlocksCollected();

        POS_BLOCK_MAP.forEach((pos, block) -> {
            level.setBlock(pos, block.get().defaultBlockState(), InfoOverlayBlock.UPDATE_ALL);
            BrigadistaTraining.LOGGER.info("Placed block {} at {}", block.get(), pos);
        });
    }
}

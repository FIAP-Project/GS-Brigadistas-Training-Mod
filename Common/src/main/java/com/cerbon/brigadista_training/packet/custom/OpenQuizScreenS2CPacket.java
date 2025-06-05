package com.cerbon.brigadista_training.packet.custom;

import com.cerbon.brigadista_training.client.screen.QuizScreen;
import com.cerbon.cerbons_api.api.network.data.PacketContext;
import com.cerbon.cerbons_api.api.network.data.Side;
import com.cerbon.cerbons_api.util.Constants;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public class OpenQuizScreenS2CPacket {
    public static final ResourceLocation CHANNEL = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "open_quiz_screen_s2c_packet");
    public static final StreamCodec<FriendlyByteBuf, OpenQuizScreenS2CPacket> STREAM_CODEC = new StreamCodec<>() {

        @Override
        public OpenQuizScreenS2CPacket decode(FriendlyByteBuf object) {
            return null;
        }

        @Override
        public void encode(FriendlyByteBuf object, OpenQuizScreenS2CPacket object2) {}
    };

    public OpenQuizScreenS2CPacket() {}

    public static void handle(PacketContext<OpenQuizScreenS2CPacket> ctx) {
        if (ctx.side().equals(Side.SERVER)) return;

        Minecraft.getInstance().setScreen(new QuizScreen());
    }

    public static CustomPacketPayload.Type<CustomPacketPayload> type() {
        return new CustomPacketPayload.Type<>(CHANNEL);
    }
}

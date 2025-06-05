package com.cerbon.brigadista_training.packet;

import com.cerbon.brigadista_training.packet.custom.OpenQuizScreenPacket;
import com.cerbon.cerbons_api.api.network.Network;

public class BDTPackets {

    public static void register() {
        Network.registerPacket(OpenQuizScreenPacket.type(), OpenQuizScreenPacket.class, OpenQuizScreenPacket.STREAM_CODEC, OpenQuizScreenPacket::handle);
    }
}

package com.cerbon.brigadista_training.packet;

import com.cerbon.brigadista_training.packet.custom.OpenQuizScreenS2CPacket;
import com.cerbon.cerbons_api.api.network.Network;

public class BDTPackets {

    public static void register() {
        Network.registerPacket(OpenQuizScreenS2CPacket.type(), OpenQuizScreenS2CPacket.class, OpenQuizScreenS2CPacket.STREAM_CODEC, OpenQuizScreenS2CPacket::handle);
    }
}

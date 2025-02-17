package de.kwantux.networksclient.client.communication.handler;

import de.kwantux.networksclient.communication.packets.TestPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;


public class TestPacketHandler implements ClientPlayNetworking.PlayPayloadHandler<TestPacket> {
    @Override
    public void receive(TestPacket myPacket, ClientPlayNetworking.Context context) {
        System.out.println("Received packet");
        System.out.println(myPacket.number());
    }
}

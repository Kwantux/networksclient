package de.kwantux.networksclient.client;

import de.kwantux.networksclient.client.communication.handler.TestPacketHandler;
import de.kwantux.networksclient.communication.packets.TestPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class NetworksClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(TestPacket.TYPE, new TestPacketHandler());
        NetworksClientKeybinds.init();
    }

}


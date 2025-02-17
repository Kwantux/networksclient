package de.kwantux.networksclient.communication.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record TestPacket(
        int number
) implements CustomPacketPayload {
    public static final StreamCodec<FriendlyByteBuf, TestPacket> CODEC = CustomPacketPayload.codec(TestPacket::write, TestPacket::new);
    public static final CustomPacketPayload.Type<TestPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.parse("networks:my_packet"));

    public TestPacket(FriendlyByteBuf buf) {
        this(buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.number);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
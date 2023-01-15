package point.events.impl;

import net.minecraft.network.Packet;
import point.events.Event;

public final class EventRecievePackets extends Event {
    private Packet packet;

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }
}

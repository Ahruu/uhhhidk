package point.events.impl;

import net.minecraft.network.Packet;
import point.events.Event;

public class EventSentPackets extends Event {

    public Packet packets;

    public EventSentPackets(Packet p) {
        this.packets = p;
    }

    public Packet getPackets() {
        return this.packets;
    }

}

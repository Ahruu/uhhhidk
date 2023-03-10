package point.util;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;

public final class PacketUtil {
    private final Minecraft mc = Minecraft.getMinecraft();

    public void sendPacket(final Packet<?> packet) {
        mc.getNetHandler().addToSendQueue(packet);
    }

    public void sendPacketWithoutEvent(final Packet<?> packet) {
        mc.getNetHandler().addToSendQueueSilent(packet);
    }

    public void receivePacket(final Packet<?> packet) {
        mc.getNetHandler().addToReceiveQueue(packet);
    }

    public void receivePacketWithoutEvent(final Packet<?> packet) {
        mc.getNetHandler().addToSendQueueSilent(packet);
    }
}

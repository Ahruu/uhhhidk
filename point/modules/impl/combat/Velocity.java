package point.modules.impl.combat;

import com.google.common.eventbus.Subscribe;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;
import point.events.impl.EventSentPackets;
import point.modules.Category;
import point.modules.Module;

public class Velocity extends Module {

    public Velocity() {
        super("Velocity", "antiKB", Category.COMBAT);
    }

    @Subscribe
    public void onGetPackets(EventSentPackets p) {
        if(p.getPackets() instanceof S12PacketEntityVelocity || p.getPackets() instanceof S27PacketExplosion) {
            p.setCancelled(true);
        }
    }
}

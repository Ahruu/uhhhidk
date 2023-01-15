package point.modules.impl.player;

import com.google.common.eventbus.Subscribe;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.input.Keyboard;
import point.events.impl.EventUpdate;
import point.modules.Category;
import point.modules.Module;

public class NoFall extends Module {

    public NoFall() {
        super("NoFall", "No fall damage", Category.PLAYER);
        setKey(Keyboard.KEY_I);
    }

    @Subscribe
    public void onUpdate(EventUpdate e) {
      if(mc.thePlayer.fallDistance > 2.5) {
          silentSendPacket(new C03PacketPlayer(true));
          mc.thePlayer.fallDistance = 0;
      }
    }
}

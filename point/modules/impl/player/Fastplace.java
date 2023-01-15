package point.modules.impl.player;

import com.google.common.eventbus.Subscribe;
import org.lwjgl.input.Keyboard;
import point.events.impl.EventUpdate;
import point.modules.Category;
import point.modules.Module;

public class Fastplace extends Module {

    public Fastplace() {
        super("Fastplace", "Places blocks faster", Category.PLAYER);
        this.setKey(Keyboard.KEY_Y);
    }

    @Subscribe
    public void onUpdate(EventUpdate e) {
        mc.rightClickDelayTimer = 0;
    }

    @Override
    public void onDisable() {
        mc.rightClickDelayTimer = 6;
        super.onDisable();
    }


}

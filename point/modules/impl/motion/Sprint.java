package point.modules.impl.motion;

import com.google.common.eventbus.Subscribe;
import point.events.impl.EventUpdate;
import point.modules.Category;
import point.modules.Module;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", "Auto Sprint", Category.MOVEMENT);

    }

    @Subscribe
    public void onUpdate(EventUpdate e) {
        if (mc.thePlayer.moveForward > 0 && !mc.thePlayer.isCollidedHorizontally
         || mc.thePlayer.moveStrafing > 0 &&!mc.thePlayer.isCollidedHorizontally) {
            mc.thePlayer.setSprinting(true);
        }
    }

        @Override
        public void onDisable() {
            mc.thePlayer.setSprinting(false);
            super.onDisable();
        }
    }

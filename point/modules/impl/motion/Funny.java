package point.modules.impl.motion;

import com.google.common.eventbus.Subscribe;
import point.events.impl.EventUpdate;
import point.modules.Category;
import point.modules.Module;

public class Funny extends Module {

    public Funny() {
        super("Funny", "Jump", Category.MOVEMENT);
    }

    @Subscribe
    public void onUpdate(EventUpdate e) {
        if (mc.thePlayer.moveForward > 0 || mc.thePlayer.moveStrafing > 0) {
            mc.thePlayer.moveFlying(0, 2f, 0);
            if (mc.thePlayer.movementInput.jump) {
                mc.thePlayer.motionY = 0.5;
            }
            if (mc.thePlayer.movementInput.sneak) {
                mc.thePlayer.motionY = -0.5;
            }
        }
    }

            @Override
            public void onDisable () {
                mc.thePlayer.moveFlying(0, 0, 0);
                super.onDisable();

            }

    }
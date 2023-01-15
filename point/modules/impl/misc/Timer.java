package point.modules.impl.misc;

import point.modules.Category;
import point.modules.Module;

public class Timer extends Module {

    public Timer() {
        super("Timer", "Modifies your game speed", Category.PLAYER);

    }

    @Override
    public void onEnable() {
        mc.timer.timerSpeed = 0.5f;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        mc.timer.timerSpeed = 1;
        super.onDisable();

    }
}

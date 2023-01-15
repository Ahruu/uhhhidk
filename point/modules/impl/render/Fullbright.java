package point.modules.impl.render;

import org.lwjgl.input.Keyboard;
import point.modules.Category;
import point.modules.Module;

public class Fullbright extends Module {

    public float oldGamma;

    public Fullbright() {
        super("Fullbright", "Here comes the sun", Category.RENDER);
        this.setKey(Keyboard.KEY_L);
    }

    @Override
    public void onEnable() {
        oldGamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 1000;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        mc.gameSettings.gammaSetting = oldGamma;
        super.onDisable();
    }

}

package point.modules.impl.hud;

import org.lwjgl.input.Keyboard;
import point.modules.Category;
import point.modules.Module;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", "Renders Clickgui", Category.RENDER);
        this.setKey(Keyboard.KEY_RSHIFT);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        mc.displayGuiScreen(new point.ClickGui.ClickGUI());
    }
}

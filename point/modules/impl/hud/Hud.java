package point.modules.impl.hud;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;
import point.events.impl.Render2DEvent;
import point.hatsune;
import point.modules.Category;
import point.modules.Module;
import point.modules.ModuleManager;

import java.awt.*;
import java.util.Comparator;

public class Hud extends Module {

    public Hud() {
        super("Hud", "Heads up display", Category.RENDER);
    }

    private static int rainbow(int delay) {
        double rainbowState = Math.ceil((System.currentTimeMillis() * 3 + delay / 2) / 10.0);
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.6f, 1f).getRGB();
    }
    private final Comparator<Object> SORT_METHOD = Comparator.comparingDouble(m -> {
        Module module = (Module) m;
        String name = module.name;
        return mc.fontRendererObj.getStringWidth(name);
    }).reversed();

    @Subscribe
    public void on2D(Render2DEvent e) {
        FontRenderer fr = mc.fontRendererObj;
        ScaledResolution sr = new ScaledResolution(mc);

        // NAME
        GL11.glScaled(2, 2, 2);
        fr.drawStringWithShadow(hatsune.INSTANCE.name,5, 5,5636095);
        GL11.glScaled(0.5,0.5,0.5);

        // Version
        fr.drawStringWithShadow("0.0.1",92, 14, -1);

        // FPS
        fr.drawStringWithShadow("fps: " + Minecraft.getDebugFPS(), 5, sr.getScaledHeight() - 10, 5636095);


        // ARRAYLIST
        ModuleManager mods = hatsune.INSTANCE.getModuleManager();
        mods.getModules().sort(SORT_METHOD);


        float index = 0;
        int count = 0;
        for(Module m : mods.getModules()) {
            if(!m.isEnabled()) {
                continue;
            }

            fr.drawStringWithShadow(m.getName(), sr.getScaledWidth() - 3 - fr.getStringWidth(m.getName()), 5 +(fr.FONT_HEIGHT * index), rainbow(1000 * count / 2));
            index += 1.2f;
            count++;
        }

    }
}

package point.ClickGui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import point.hatsune;
import point.modules.Module;

public class ClickGUI extends GuiScreen {

    private GuiButton button1;
    private GuiButton button2;

    public void initGui() {
        this.doesGuiPauseGame();
        buttonList.clear();
        int count = 0;
        for(Module m : hatsune.INSTANCE.getModuleManager().modules) {
            int index = hatsune.INSTANCE.getModuleManager().modules.indexOf(m);
            buttonList.add(new GuiButton(index, width / 2 - 100,  10 + 23 * count, m.getName()));
            count++;
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    protected void actionPerformed(GuiButton button) {
        int count = 0;
        for (GuiButton buttons : buttonList) {
            if(button.id == buttons.id)
            hatsune.INSTANCE.getModuleManager().modules.get(buttons.id).setEnabled(!hatsune.INSTANCE.getModuleManager().modules.get(buttons.id).enabled);
        }
    }
}
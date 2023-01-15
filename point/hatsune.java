package point;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.minecraft.client.Minecraft;
import point.commands.CommandManager;
import point.events.impl.EventKey;
import point.modules.Module;
import point.modules.ModuleManager;

@SuppressWarnings("ALL")
public enum hatsune {

    INSTANCE;
    public Minecraft mc = Minecraft.getMinecraft();

    public String name = "hatsune", version = "v0.01";

    public static CommandManager cmdManager;
    public EventBus bus;
    public ModuleManager manager;


    public void init() {
        bus = new EventBus();
        manager = new ModuleManager();
        cmdManager = new CommandManager();
        bus.register(this);
    }

    public void stop() {
        bus.unregister(this);

    }

    public EventBus getBus() {
        return bus;
    }

    public ModuleManager getModuleManager() {
        return manager;
    }

    @Subscribe
    public void onKey(EventKey e) {
        for (Module m : manager.getModules()) {
            if (m.key == e.getKey()) {
                if(m.isEnabled()) {
                    m.setEnabled(false);
                }else{
                    m.setEnabled(true);
                }

            }
        }

    }
}


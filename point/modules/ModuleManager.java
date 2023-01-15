package point.modules;

import point.modules.impl.combat.*;
import point.modules.impl.misc.*;
import point.modules.impl.motion.*;
import point.modules.impl.player.*;
import point.modules.impl.render.*;
import point.modules.impl.hud.*;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        init();

    }

    public void init() {
        //COMBAT
        add(new Velocity());
        add(new Killaura());

        //MOTION
        add(new Sprint());
        add(new Funny());

        //PLAYER
        add(new Fastplace());
        add(new NoFall());

        //MISC
        add(new Timer());

        //HUD
        add(new Hud());
        add(new ClickGUI());

        //RENDER
        add(new Fullbright());
        add(new ESP());
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public Module getmodule(String name) {
        for (Module module : modules) {
            if (module.getName().equals(name)) {
                return module;
            }
        }
        return null;
    }

    public Module getEnabledModules(String name) {
        for (Module module : modules) {
            if (module.getName().equals(name)) {
                if(module.isEnabled()) {
                    return module;
                }
            }
        }
        return null;
    }

    public void add(Module module) {
        modules.add(module);
    }

}





package point.commands.commands;

import org.lwjgl.input.Keyboard;
import point.commands.Command;
import point.hatsune;
import point.modules.Module;

public class BindCommand extends Command {

    public BindCommand() {
        super("bind");
    }

    @Override
    public void handler(String[] args) {
        System.out.print("fuck");
        for (Module m : hatsune.INSTANCE.getModuleManager().modules) {
            if(m.getName().equalsIgnoreCase(args[1])) {
                final int keyCode = Keyboard.getKeyIndex(args[2].toUpperCase());
                m.setKey(keyCode);
            }
        }
    }
}

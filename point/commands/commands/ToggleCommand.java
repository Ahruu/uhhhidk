package point.commands.commands;

import point.commands.Command;
import point.hatsune;
import point.modules.Module;

public class ToggleCommand extends Command {

    public ToggleCommand() {
        super("t");
    }

    @Override
    public void handler(String[] args) {
        System.out.print("fuck");
        for (Module m : hatsune.INSTANCE.getModuleManager().modules) {
            if(m.getName().equalsIgnoreCase(args[1])) {
                m.setEnabled(!m.enabled);
            }
        }
    }
}

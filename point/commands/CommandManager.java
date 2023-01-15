package point.commands;

import point.commands.commands.BindCommand;
import point.commands.commands.ToggleCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    public List<Command> commandList = new ArrayList<>();

    public CommandManager() {
        this.commandList.add(new BindCommand());
        this.commandList.add(new ToggleCommand());
    }
}

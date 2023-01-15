package point.commands;

public abstract class Command {
    public String prefix;

    public Command(String prefix) {
        this.prefix = prefix;
    }

    public abstract void handler(String[] args);
}

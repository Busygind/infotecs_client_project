package commands;

import client.DataController;

public abstract class AbstractCommand {

    private final String arg;

    public AbstractCommand(String arg) {
        this.arg = arg;
    }

    public AbstractCommand() {
        this.arg = null;
    }

    public abstract void execute(DataController dataController);

    protected String getArg() {
        return arg;
    }
}

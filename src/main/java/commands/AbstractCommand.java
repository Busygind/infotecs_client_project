package commands;

import utils.DataController;

/**
 * Abstract class that is the parent of the command classes
 */
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

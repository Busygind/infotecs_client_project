package commands;

import utils.DataController;

public class ExitCommand extends AbstractCommand {

    @Override
    public void execute(DataController dataController) {
        System.out.println("The work with server is finished. The changed data is saved.");
    }
}

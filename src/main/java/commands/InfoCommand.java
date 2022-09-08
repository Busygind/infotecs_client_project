package commands;

import client.DataController;

public class InfoCommand extends AbstractCommand {

    public InfoCommand(String arg) {
        super(arg);
    }

    @Override
    public void execute(DataController dataController) {
        System.out.println(dataController.getStudentById(Long.parseLong(getArg())));
    }
}

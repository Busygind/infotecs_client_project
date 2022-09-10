package commands;

import utils.DataController;

public class HelpCommand extends AbstractCommand {

    @Override
    public void execute(DataController dataController) {
        System.out.println("List of commands: \n"
                + "* list -- show students list sorted by name \n"
                + "* info <id> -- show info about student by id \n"
                + "* add <name> -- add student with specified name \n"
                + "* delete <id> -- delete student by id \n"
                + "* exit -- finish work with client");
    }
}

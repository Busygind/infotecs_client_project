package commands;

import utils.DataController;

import java.util.NoSuchElementException;

public class DeleteCommand extends AbstractCommand {

    public DeleteCommand(String arg) {
        super(arg);
    }

    @Override
    public void execute(DataController dataController) {
        try {
            dataController.removeStudentById(Long.parseLong(getArg()));
        } catch (NoSuchElementException e) {
            System.out.println("Student with that id not found.");
        }

    }
}

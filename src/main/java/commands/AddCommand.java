package commands;

import utils.DataController;
import entities.Student;

public class AddCommand extends AbstractCommand {

    public AddCommand(String arg) {
        super(arg);
    }

    @Override
    public void execute(DataController dataController) {
        Student student = new Student(dataController.generateId(), getArg());
        dataController.addStudent(student);
    }
}

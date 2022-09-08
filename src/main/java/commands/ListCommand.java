package commands;

import client.DataController;
import entities.Student;

public class ListCommand extends AbstractCommand{

    @Override
    public void execute(DataController dataController) {
        for (Student student : dataController.getStudents()) {
            System.out.println(student);
        }
    }
}

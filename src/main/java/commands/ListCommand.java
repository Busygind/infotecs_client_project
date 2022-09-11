package commands;

import utils.DataController;
import entities.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCommand extends AbstractCommand {

    @Override
    public void execute(DataController dataController) {
        List<Student> sortedListOfStudents = new ArrayList<>(dataController.getStudents());
        Collections.sort(sortedListOfStudents);
        for (Student student : sortedListOfStudents) {
            System.out.println(student);
        }
    }
}

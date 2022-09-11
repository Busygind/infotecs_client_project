package utils;

import entities.Student;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;

public class DataController {

    private final ServerRequestsController serverRequestsController;
    private final HashSet<Student> students;

    public DataController(ServerRequestsController serverRequestsController) throws IOException {
        JSONParser parser = new JSONParser();
        this.serverRequestsController = serverRequestsController;
        this.students = parser.parseData(serverRequestsController.getData());
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public Student getStudentById(Long id) {
        return students.stream().filter(student -> Objects.equals(student.getId(), id)).findFirst().get();
    }

    public void removeStudentById(Long id) {
        students.remove(getStudentById(id));
    }

    public Long generateId() {
        for (long i = 1; i < Long.MAX_VALUE; i++) {
            long finalI = i;
            if (students.stream().noneMatch(student -> Objects.equals(student.getId(), finalI))) {
                return finalI;
            }
        }
        return null;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    protected ServerRequestsController getServerController() {
        return serverRequestsController;
    }
}

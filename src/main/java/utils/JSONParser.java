package utils;

import entities.Student;

import java.util.HashSet;

public class JSONParser {
    public HashSet<Student> parseData(String data) {
        HashSet<Student> students = new HashSet<>();
        data = data.replaceAll("\\s+","");
        int idIndex = data.indexOf("\"id\":");
        int nameIndex;
        int closeBracketIndex;
        while (idIndex != -1) {
            nameIndex = data.indexOf("\"name\":");
            closeBracketIndex = data.indexOf("}");
            Student student = new Student(Long.parseLong(data.substring(idIndex + 5, nameIndex - 1)), data.substring(nameIndex + 8, closeBracketIndex - 1));
            students.add(student);
            data = data.substring(closeBracketIndex + 1);
            idIndex = data.indexOf("\"id\":");
        }

        return students;
    }
}

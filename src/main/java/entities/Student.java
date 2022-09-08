package entities;

public class Student implements Comparable<Student> {

    private final Long id;
    private final String name;

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int compareTo(Student o) {
        int result = this.name.compareTo(o.name);
        if (result == 0) {
            result = this.id.compareTo(o.id);
        }
        return result;
    }

    public String toJSONObject() {
        return "\n{\n"
                + "\"id\": " + id + ",\n"
                + "\"name\": \"" + name + "\"\n"
                + "},";
    }

    @Override
    public String toString() {
        return "-------------------------\n"
                + "name: " + name + "\n"
                + "id: " + id;
    }
}

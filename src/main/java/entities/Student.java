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

    /**
     * @param o object to compare
     * @return comparing result as integer
     */
    @Override
    public int compareTo(Student o) {
        int result = this.name.compareTo(o.name);
        if (result == 0) {
            result = this.id.compareTo(o.id);
        }
        return result;
    }

    /**
     * Method that translate object to JSON string
     * @return JSON object as string
     */
    public String toJSONObject() {
        return "\n{\n"
                + "\"id\": " + id + ",\n"
                + "\"name\": \"" + name + "\"\n"
                + "},";
    }

    /**
     * Method to show students in presentable format
     * @return object representation as a string
     */
    @Override
    public String toString() {
        return "-------------------------\n"
                + "name: " + name + "\n"
                + "id: " + id;
    }
}

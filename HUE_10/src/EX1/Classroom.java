package EX1;

public class Classroom {
    private static final int MAX_STUDENTS = 20;
    private String name;
    private Student[] studentList;

    public Classroom(String name) {
        this.name = name;
        this.studentList = new Student[0];
    }
}

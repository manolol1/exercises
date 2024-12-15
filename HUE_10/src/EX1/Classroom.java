package EX1;

public class Classroom {
    private static final int MAX_STUDENTS = 20;
    private String name;
    private Student[] studentList;

    public Classroom(String name) {
        this.name = name;
        this.studentList = new Student[0];
    }

    /**
     * Add student to classroom
     * @param s new Student
     */
    public void addStudent(Student s) {
        if (studentList.length < MAX_STUDENTS) {
            Student[] newStudentList = new Student[studentList.length + 1];
            System.arraycopy(studentList, 0, newStudentList, 0, studentList.length);
            newStudentList[studentList.length] = s;
            studentList = newStudentList;
        } else {
            throw new IllegalStateException("Classroom is already full");
        }
    }

    /**
     * Print a list of all students
     */
    public void printStudentList() {
        for (Student s : studentList) {
            System.out.println(s.toString());
        }
    }

    /**
     * Sort student list alphabetically
     */
    public void sortListByName() {
        int min;
        Student temp;

        for (int i = 0; i < studentList.length; i++) {
            min = i;
            for (int j = i; j < studentList.length; j++) {
                if (studentList[j].getName().compareTo(studentList[min].getName()) < 0) {
                    min = j;
                }
            }

            temp = studentList[min];
            studentList[min] = studentList[i];
            studentList[i] = temp;
        }
    }

    /**
     * Sort student list by average mark in ascending order
     */
    public void sortListByAverageMark() {
        int min;
        Student temp;

        for (int i = 0; i < studentList.length; i++) {
            min = i;
            for (int j = i; j < studentList.length; j++) {
                if (studentList[j].getAverageMark() < studentList[min].getAverageMark()) {
                    min = j;
                }
            }

            temp = studentList[min];
            studentList[min] = studentList[i];
            studentList[i] = temp;
        }
    }

    /**
     * Sort student list by average mark in ascending order and get best student
     * @return student with the lowest average mark
     */
    public Student getBestStudent() {
        sortListByAverageMark();
        return studentList[0];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Student[] getStudentList() {
        return studentList;
    }
}

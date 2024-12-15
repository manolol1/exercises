package EX1;

public class Student {
    private String name;
    private int age;
    private Examination[] examList;
    private String[] uniqueCourses;

    public Student(String name, int age) {
        this.name = name;
        this.age = Math.abs(age);
        examList = new Examination[0];
        uniqueCourses = new String[0];
    }

    public boolean courseExists(String course) {
        for (String c : uniqueCourses) {
            if (c.equals(course)) return true;
        }
        return false;
    }

    /**
     * Add an exam to the exam list
     * @param exam exam to add (not null!)
     */
    public void addExam(Examination exam) {
        if (exam != null) {
            Examination[] newExamList = new Examination[examList.length + 1];
            System.arraycopy(examList, 0, newExamList, 0, examList.length);
            newExamList[examList.length] = exam;
            examList = newExamList;

            if (!courseExists(exam.getCourse())) {
                String[] newUniqueCourses = new String[uniqueCourses.length + 1];
                System.arraycopy(uniqueCourses, 0, newUniqueCourses, 0, uniqueCourses.length);
                newUniqueCourses[uniqueCourses.length] = exam.getCourse();
                uniqueCourses = newUniqueCourses;
            }
        }
    }

    /**
     * Delete all exams of a specific course
     * @param courseName name of the course to delete
     */
    public void deleteExam(String courseName) {
        Examination[] newExamList = new Examination[examList.length - 1];

        int i = 0;
        int j = 0;

        while (i < examList.length) {
            if (examList[i].getCourse().equals(courseName)) {
                i++;
            } else {
                newExamList[j] = examList[i];
                i++;
                j++;
            }
        }

        examList = newExamList;

        deleteUniqueCourse(courseName);
    }

    public void deleteUniqueCourse(String courseName) {
        String[] newUniqueCourses = new String[uniqueCourses.length - 1];

        int i = 0;
        int j = 0;

        while (i < uniqueCourses.length) {
            if (uniqueCourses[i].equals(courseName)) {
                i++;
            } else {
                newUniqueCourses[j] = uniqueCourses[i];
                i++;
                j++;
            }
        }

        uniqueCourses = newUniqueCourses;
    }

    /**
     * @return total sum of all marks
     */
    public int getMarkSum() {
        int sum = 0;
        for (Examination exam : examList) {
            sum += exam.getMark();
        }
        return sum;
    }

    /**
     * @return total mark sum of a specific course
     */
    public int getMarkSum(String course) {
        int sum = 0;
        for (Examination exam : examList) {
            if (exam.getCourse().equals(course)) {
                sum += exam.getMark();
            }
        }
        return sum;
    }

    /**
     * Count occurrences of a course in the exam list
     * @param course course to count
     * @return number of occurrences of course in examList
     */
    public int countCourseExams(String course) {
        int count = 0;
        for (Examination exam : examList) {
            if (exam.getCourse().equals(course)) count++;
        }
        return count;
    }

    /**
     * @return average mark of all exams
     */
    public double getAverageMark() {
        return (double) getMarkSum() / examList.length;
    }

    /**
     * @param course course average to get
     * @return average mark of a specific course
     */
    public double getAverageMark(String course) {
        return (double) getMarkSum(course) / countCourseExams(course);
    }

    /**
     * @return school report with average grades per subject
     */
    public String getSchoolReport() {
        StringBuilder sb = new StringBuilder();

        sb.append(name).append(System.lineSeparator());

        for (String course : uniqueCourses) {
            sb.append(String.format("%s : %d%n", course, Math.round(getAverageMark(course))));
        }

        return sb.toString();
    }

    /**
     * Print the schoolreport from getSchoolReport()
     */
    public void printSchoolReport() {
        System.out.println(getSchoolReport());
    }

    /**
     * Sort the exam list in alphabetical order
     */
    public void sortExamList() {
        int min;
        Examination temp;

        for (int i = 0; i < examList.length; i++) {
            min = i;
            for (int j = i; j < examList.length; j++) {
                if (examList[j].getCourse().compareTo(examList[min].getCourse()) < 0) {
                    min = j;
                }
            }

            temp = examList[min];
            examList[min] = examList[i];
            examList[i] = temp;
        }

        sortUniqueCourses();
    }

    /**
     * Sort the list of unique courses (automatically done when sorting the examlist)
     */
    public void sortUniqueCourses() {
        int min;
        String temp;

        for (int i = 0; i < examList.length; i++) {
            min = i;
            for (int j = i; j < examList.length; j++) {
                if (uniqueCourses[j].compareTo(uniqueCourses[min]) < 0) {
                    min = j;
                }
            }

            temp = uniqueCourses[min];
            uniqueCourses[min] = uniqueCourses[i];
            uniqueCourses[i] = temp;
        }
    }

    @Override
    public String toString() {
        return String.format("%s : %d : %.2f", name, age, getAverageMark());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Examination[] getExamList() {
        return examList;
    }

    public void setExamList(Examination[] examList) {
        this.examList = examList;
    }
}

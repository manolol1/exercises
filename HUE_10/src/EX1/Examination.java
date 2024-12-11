package EX1;

public class Examination {
    private final String course;
    private final int mark;

    /**
     * Initialize new Exam
     * @param course name of course
     * @param mark mark in range [1, 5]
     */
    public Examination(String course, int mark) {
        this.course = course;

        if (mark < 1) {
            this.mark = 1;
        } else this.mark = Math.min(mark, 5);
    }

    @Override
    public String toString() {
        return String.format("%s: %d", course, mark);
    }

    public String getCourse() {
        return course;
    }

    public int getMark() {
        return mark;
    }
}

package EX1;

public class Main {
    public static void main(String[] args) {
        Classroom c1=new Classroom("2BHIF");
        Examination e1=new Examination("Math",2);
        Examination e2=new Examination("Java",1);
        Examination e3=new Examination("Biology",3);
        Examination e4=new Examination("Linux",3);
        Student s1=new Student("Bart",16);
        s1.addExam(e1);
        s1.addExam(e2);
        s1.addExam(e3);
        s1.addExam(e4);
        System.out.println(s1); // Bart : 16 : 2.25
        s1.printSchoolReport(); // Zeugnis drucken mit allen Fächern
//        s1.sortExamList(); // alphabetisch Sortieren nach den Gegenständen
//        s1.printSchoolReport();
//        e1=new Examination("Math",3);
//        e2=new Examination("Java",1);
//        e3=new Examination("Latin",4);
//        Student s2=new Student("Waylon",36);
//        s2.addExam(e1);
//        s2.addExam(e2);
//        s2.addExam(e3);
//        s2.deleteExam("Latin");
//        s2.printSchoolReport(); // Zeugnis drucken mit allen Fächern
//        e1=new Examination("Java",2);
//        e2=new Examination("Linux",2);
//        e3=new Examination("Biology",1);
//        Student s3=new Student("Lisa",12);
//        s3.addExam(e1);
//        s3.addExam(e2);
//        s3.addExam(e3);
//        s3.printSchoolReport(); // Zeugnis drucken mit allen Fächern
//        e1=new Examination("Java",5);
//        e2=new Examination("Linux",4);
//        e3=new Examination("Biology",4);
//        Student s4=new Student("montgomery",93);
//        s4.addExam(e1);
//        s4.addExam(e2);
//        s4.addExam(e3);
//        s4.printSchoolReport(); // Zeugnis drucken mit allen Fächern
//        c1.addStudent(s1);
//        c1.addStudent(s2);
//        c1.addStudent(s3);
//        c1.addStudent(s4);
//        System.out.println("\nListe");
//        c1.printStudentList();
//        System.out.println("\nSortiert nach Namen");
//        c1.sortListByName();
//        c1.printStudentList();
//        System.out.println("\nSortiert nach Notendurchschnitt");
//        c1.sortListByAverageMark();
//        c1.printStudentList();
//        Student best=c1.getBestStudent();
//        System.out.println("\nBester Student: "+best); // lisa : 12 : 1.6666666666666667
    }
}

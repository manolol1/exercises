package Ex1;

public class Main {
    public static void main(String[] args) {
        MySet s1=new MySet();
        MySet s2=new MySet();

        System.out.println("s1: "+s1); // {}

        s2.add(1);
        s2.add(2);
        s2.add(3);
        s2.add(1);
        System.out.println("s2: "+s2); // {1,2,3}

        //s1.add(s2);
        System.out.println("s1: "+s1); // {1,2,3}
        s1.add(5);
        System.out.println("s1: "+s1); // {1,2,3,5}
        s1.delete(5);
        System.out.println("s1: "+s1); // {1,2,3}
//
//        s1.add(5);
//        s1.add(8);
//        s1.add(3);
//        s1.add(5);
//        System.out.println("s1: "+s1); // {1,2,3,5,8}
//        s1.delete(1);
//        s1.delete(2);
//        s1.delete(3);
//        System.out.println("s1: "+s1); // {5,8}
//
//        s1.union(s2);
//        System.out.println("s1: "+s1); // {1,2,3,5,8}
//
//        s2.delete(3);
//        s1.intersection(s2);
//        System.out.println("s1: "+s1); // {1,2}

    }
}

package EX1;

public class Main {
    public static void main(String[] args) {
        MyTime[] times = new MyTime[5];

        times[0] = new MyTime(2, 40, 20);
        times[1] = new MyTime(-2, 40, 20);

        printArray(times);

        System.out.println(times[0].getTotalSeconds());
    }

    public static void printArray(Object[] ar) {
        for (Object obj : ar) {
            System.out.println(obj);
        }
    }
}
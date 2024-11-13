package EX1;

public class Main {
    public static void main(String[] args) {
        MyTime[] times = new MyTime[6];

        times[0] = new MyTime(2, 40, 20);
        times[1] = new MyTime(-2, 40, 20);
        times[2] = new MyTime(12, 45, 10);
        times[3] = new MyTime(1, 14, 10);
        times[4] = new MyTime(42, 91, 22);
        times[5] = MyTime.difference(times[3], times[2]);

        times[2].add(times[3]);
        times[2].subtract(times[3]);

        printTimesArray(times, true);

        sortTimes(times);
        System.out.println();

        printTimesArray(times, true);

        System.out.println();

        System.out.println(MyTime.now().getGreeting() + ", " + System.getProperty("user.name") + "!");
    }

    /**
     * Print an array of any type of Object (line-by-line)
     * This requires the Object to implement its own toString() method.
     * @param ar Array of Objects
     */
    public static void printArray(Object[] ar) {
        for (Object obj : ar) {
            System.out.println(obj);
        }
    }

    /**
     * Print an Array of MyTimes
     * @param ar Array to print
     * @param printTotalSeconds if true, the total seconds of a time will be printed next to the hh:mm:ss format.
     */
    public static void printTimesArray(MyTime[] ar, boolean printTotalSeconds) {
        for (MyTime t : ar) {
            System.out.println(t.toString(printTotalSeconds));
        }
    }

    /**
     * Sort an array of MyTimes
     * @param ar Array to sort
     */
    public static void sortTimes(MyTime[] ar) {
        MyTime temp;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == null) ar[i] = new MyTime(0, 0, 0);
            int minIndex = i;
            for (int j = i; j < ar.length; j++) {
                if (ar[j].getTotalSeconds() < ar[minIndex].getTotalSeconds()) {
                    minIndex = j;
                }
            }

            temp = ar[i];
            ar[i] = ar[minIndex];
            ar[minIndex] = temp;
        }
    }
}
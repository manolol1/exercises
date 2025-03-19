package EX_1;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Thing[] ar = new Thing[5];
        ar[0] = new Vehicle("Opel", 1999);
        ar[1] = new Person("Anton", 29);
        ar[2] = new Person("Hedwig", 20);
        ar[3] = new Vehicle("Ford", 2015);
        ar[4] = new Person("Anton", 21);

        print(ar);
        sortAge(ar);
        print(ar);
        sortName(ar);
        print(ar);
        sortType(ar);
        print(ar);
        sortNameAge(ar);
        print(ar);

    }

    public static void print(Thing[] ar) {
        for (Thing a : ar) {
            System.out.println(a);
        }
        System.out.println();
    }

    public static void sortAge(Thing[] ar) {
        int minIndex;
        Thing temp;

        for (int i = 0; i < ar.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[j].getAge() < ar[minIndex].getAge()) {
                    minIndex = j;
                }
            }

            temp = ar[i];
            ar[i] = ar[minIndex];
            ar[minIndex] = temp;
        }
    }

    public static void sortName(Thing[] ar) {
        int minIndex;
        Thing temp;

        for (int i = 0; i < ar.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[j].getName().compareTo(ar[minIndex].getName()) < 0) {
                    minIndex = j;
                }
            }

            temp = ar[i];
            ar[i] = ar[minIndex];
            ar[minIndex] = temp;
        }
    }

    public static void sortType(Thing[] ar) {
        int minIndex;
        Thing temp;

        for (int i = 0; i < ar.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[minIndex].getClass().getSimpleName().compareTo(ar[j].getClass().getSimpleName()) < 0) {
                    minIndex = j;
                }
            }

            temp = ar[i];
            ar[i] = ar[minIndex];
            ar[minIndex] = temp;
        }
    }

    public static void sortNameAge(Thing[] ar) {
        Arrays.sort(ar, Comparator.comparing(Thing::getName).thenComparingInt(Thing::getAge));
    }
}

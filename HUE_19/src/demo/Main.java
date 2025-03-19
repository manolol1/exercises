package demo;

public class Main {
    public static void main(String[] args) {
        Age[] ar = new Age[4];
        ar[0] = new Vehicle("Opel", 1999);
        ar[1] = new Person("Anton", 19);
        ar[2] = new Person("Anthony", 20);
        ar[3] = new Vehicle("Ford", 2015);

        for (Age a : ar) {
            System.out.println(a);
        }

        System.out.println();

        sort(ar);

        for (Age a : ar) {
            System.out.println(a);
        }
    }

    public static void sort(Age[] ar) {
        int minIndex;
        Age temp;

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
}

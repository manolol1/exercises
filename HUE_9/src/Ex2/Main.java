package Ex2;

public class Main {
    public static void main(String[] args) {
        Interval a = new Interval(2, 5);
        Interval b = new Interval(4, 6);
        Interval c = new Interval(6, 9);
        Interval d = new Interval(0, 0);
        System.out.println(a.contains(d));
        System.out.println(d.contains(a));
        System.out.println(d.contains(d));
        System.out.println(a.hull(c).contains(b));
        System.out.println(a.intersection(c).isEmpty());
        System.out.println(a.intersection(b).contains(b));
        System.out.println(a.intersection(b));
        System.out.println(a.hull(c));
        System.out.println(a.contains(b));
        System.out.println();
        Interval[] ar=new Interval[4];
        ar[0]=new Interval(2, 5);
        ar[1]=new Interval(1, 2);
        ar[2]=new Interval(8, 15);
        ar[3]=new Interval(7, 9);
        printArray(ar);
        sortArray(ar);
        System.out.println();
        printArray(ar);
    }

    /**
     * Print an array of Objects by calling every Object's toString() method
     * @param ar array of Objects that implement a toString() method
     */
    public static void printArray(Object[] ar) {
        if (ar == null) return;
        for (Object obj : ar) {
            if (obj == null) {
                System.out.println("null");
            } else {
                System.out.println(obj);
            }
        }
    }

    /**
     * Sort an array of intervals by length (in ascending order)
     * @param ar array of intervals
     */
    public static void sortArray(Interval[] ar) {
        int min;
        Interval temp;

        for (int i = 0; i < ar.length; i++) {
            min = i;
            for (int j = i; j < ar.length; j++) {
                if (ar[j].getLength() < ar[min].getLength()) {
                    min = j;
                }
            }

            temp = ar[i];
            ar[i] = ar[min];
            ar[min] = temp;
        }
    }
}

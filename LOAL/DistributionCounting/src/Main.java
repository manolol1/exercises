import java.util.Arrays;
import JavaUtils.*;

public class Main {
    public static void main(String[] args) {
        int[] ar = {5, 3, 2, 1, 4, 5, 7, 6, 8, 9, 0, 2, 3, 4, 5, 6, 7, 8, 9, 1, 6, 4, 6, 12, 4, 5, 9, 11};
        int[] ar2 = {5, 2, 5, 3, 5, 2};
        int[] ar3 = ArrayUtils.randomArray(10000000, 0, 10000);


        sort(ar, 0, 12);
        System.out.println(Arrays.toString(ar));

        sort(ar2, 2, 5);
        System.out.println(Arrays.toString(ar2));

        sort(ar3, 0, 10000);
        System.out.println(Arrays.toString(ar3));
    }

    public static void sort(int[] ar, int min, int max) {
        int[] c = new int[max - min + 1];
        int[] b = new int[ar.length];


        // count
        for (int value : ar) {
            c[value - min]++;
        }

        // sum
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // sort
        for (int i = ar.length - 1; i >= 0; i--) {
            b[c[ar[i] - min] - 1] = ar[i];
            c[ar[i] - min]--;
        }

        // copy
        System.arraycopy(b, 0, ar, 0, ar.length);
    }
}
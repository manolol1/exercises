import JavaUtils.*;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        int[] ar = ArrayUtils.randomArray(10, 0, 20);

        ArrayUtils.printArray(ar);

        int[] p = indexSort(ar);
        ArrayUtils.printArray(p);

        applyIndexField(ar, p);

        ArrayUtils.printArray(ar);
    }

    /**
     * Get an array of indexes of an array sorted by value in ascending order
     * @param ar array to get index-field for
     * @return index-field
     */
    public static int[] indexSort(int[] ar) {
        int[] p = new int[ar.length];

        for (int i = 0; i < ar.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < ar.length; j++) {
                if (ar[j] < ar[minIndex]) {
                    minIndex = j;
                }
            }

            p[i] = minIndex;
        }

        return p;
    }

    /**
     * Apply an index-field to an array
     * @param ar array to apply the index-field to
     * @param p index-field (in correct order)
     */
    public static void applyIndexField(int[] ar, int[]  p) {
        if (ar.length != p.length) {
            throw new RuntimeException("Array and index-field must have the same length!");
        }

        int temp = 0;

        for (int i = 0; i < ar.length; i++) {
            temp = ar[i];
            ar[i] = ar[p[i]];
            ar[p[i]] = temp;
        }
    }
}

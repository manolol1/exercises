import JavaUtils.*;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        int[] ar = ArrayUtils.randomArray(100, 0, 999);
        //int[] ar = {5, 3, 1, 4, 2};

        System.out.print("Original array: ");
        ArrayUtils.printArray(ar);

        int[] p = indexSort(ar);
        System.out.print("Index-field: ");
        ArrayUtils.printArray(p);

        applyIndexField(ar, p);

        System.out.print("Sorted array: ");
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
            p[i] = i;
        }

        for (int i = 0; i < p.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < p.length; j++) {
                if (ar[p[j]] < ar[p[minIndex]]) {
                    minIndex = j;
                }
            }
            int temp = p[minIndex];
            p[minIndex] = p[i];
            p[i] = temp;
        }

        return p;
    }

    /**
     * Apply an index-field to an array
     * @param ar array to apply the index-field to
     * @param p index-field (in correct order)
     */
    public static void applyIndexField(int[] ar, int[] p) {
        if (ar == null || p == null) {
            throw new RuntimeException("Array and index-field must not be null!");
        }
        if (ar.length != p.length) {
            throw new RuntimeException("Array and index-field must have the same length!");
        }

        int[] sortedArray = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            sortedArray[i] = ar[p[i]];
        }

        System.arraycopy(sortedArray, 0, ar, 0, ar.length);
    }
}

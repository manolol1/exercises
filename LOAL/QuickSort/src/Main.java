import JavaUtils.ArrayUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ar1 = {1, 6, 8, 5, 7, 5, 9};
        int[] ar2 = ArrayUtils.randomArray(50000, Integer.MIN_VALUE, Integer.MAX_VALUE);

        sort(ar1);
        System.out.println(Arrays.toString(ar1));

        sort(ar2);
        System.out.println(Arrays.toString(ar2));
    }

    /**
     * Sort an Array using the QuickSort algorithm
     * @param ar array to sort
     */
    public static void sort(int[] ar) {
        if (ar != null) {
            sort(ar, 0, ar.length - 1);
        }
    }


    private static void sort(int[] ar, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(ar, begin, end);

            sort(ar, begin, partitionIndex - 1);
            sort(ar, partitionIndex + 1, end);
        }
    }

    /**
     *
     * @param ar
     * @param begin
     * @param end
     * @return
     */
    private static int partition(int[] ar, int begin, int end) {
        int pivot = ar[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (ar[j] <= pivot) {
                i++;

                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }

        int temp = ar[i+1];
        ar[i+1] = ar[end];
        ar[end] = temp;

        return i+1;
    }
}

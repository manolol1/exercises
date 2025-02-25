import JavaUtils.ArrayUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        //int[] ar1 = {1, 6, 8, 5, 7, 5, 9, 1, 3, 16, 22, 1};
        int[] ar2 = ArrayUtils.randomArray(1_000_000_000, -10000000, 10000000);

        System.out.printf("Array generated in %d ms\n", System.currentTimeMillis() - startTime);

        //sort(ar1);
        //System.out.println(Arrays.toString(ar1));

        startTime = System.currentTimeMillis();
        sort(ar2);

        System.out.printf("Array sorted in %d ms\n", System.currentTimeMillis() - startTime);
        //System.out.println(Arrays.toString(ar2));
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
        if (end - begin + 1 <= 10) { // Use Insertion Sort for small subarrays
            insertionSort(ar, begin, end);
        } else {
            int partitionIndex = partition(ar, begin, end);
            sort(ar, begin, partitionIndex - 1);
            sort(ar, partitionIndex + 1, end);
        }
    }


    private static int partition(int[] ar, int begin, int end) {
        int pivot = findPivot(ar, begin, end);
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (ar[j] <= pivot) {
                i++;

                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }

        int temp = ar[i + 1];
        ar[i + 1] = ar[end];
        ar[end] = temp;

        return i+1;
    }

    /**
     * Find optimal pivot (median-of-three)
     */
    public static int findPivot(int[] ar, int begin, int end) {
        int[] candidates = {ar[begin], ar[end - begin / 2], ar[end]};
        insertionSort(candidates, 0, 2);

        return candidates[1];
    }

    public static void insertionSort(int[] ar, int begin, int end) {
        for (int i = begin + 1; i <= end; i++) {
            int key = ar[i];
            int j = i - 1;

            while (j >= begin && ar[j] > key) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = key;
        }
    }

}

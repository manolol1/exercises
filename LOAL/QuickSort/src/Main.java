import JavaUtils.ArrayUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ar1 = {1, 6, 8, 5, 7, 5, 9, 1, 3, 16, 22, 1};
        int[] ar2 = ArrayUtils.randomArray(100000, -100000, 100000);

        sort(ar1);
        System.out.println(Arrays.toString(ar1));

        sort(ar2);
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
        if (begin < end) {
            int partitionIndex = partition(ar, begin, end);

            if (end - begin >= 5) {
                sort(ar, begin, partitionIndex - 1);
                sort(ar, partitionIndex + 1, end);
            }
        }

        insertionSort(ar);
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
        insertionSort(candidates);

        return candidates[1];
    }

    public static void insertionSort(int[] ar) {
        int n = ar.length;
        int minIndex, temp;

        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i; j < n; j++) {
                if (ar[j] < ar[minIndex]) {
                    minIndex = j;
                }
            }

            temp = ar[i];
            ar[i] = ar[minIndex];
            ar[minIndex] = temp;
        }
    }
}

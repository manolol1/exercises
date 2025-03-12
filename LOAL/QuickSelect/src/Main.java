/* Mario Ebenhofer */

package PACKAGE_NAME;

import JavaUtils.ArrayUtils;

public class Main {
    public static void main(String[] args) {
        int[] ar1 = {8, 6, 8, 5, 7, 5, 9, 1, 3, 16, 22, 54, 1};
        int[] ar2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ar3 = ArrayUtils.randomArray(100_000_000, -10000, 100000000);

        System.out.println(quickSelect(ar1, 5));
        System.out.println(quickSelect(ar2, 10));
        System.out.println(quickSelect(ar3, 10005));
    }

    public static int quickSelect(int[] ar, int k) {
        if (k > ar.length) {
            System.out.println("k > ar.length => finding the largest element in the array");
        }
        return quickSelect(ar, 0, ar.length - 1, k);
    }

    public static int quickSelect(int[] ar, int begin, int end, int k) {
        if (begin == end) return ar[begin];

        int pivot = partition(ar, begin, end);

        if (k == pivot) return ar[pivot];

        if (k < pivot) {
            // continue on the left side
            return quickSelect(ar, begin, pivot - 1, k);
        } else {
            // continue on the right side
            return quickSelect(ar, pivot + 1, end, k);
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
        int[] candidates = {ar[begin], ar[(end - begin) / 2], ar[end]};
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


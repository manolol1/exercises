import JavaUtils.ArrayUtils;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] ar1 = {1, 6, 8, 5, 7, 5, 9, 1, 3, 16, 22, 1};
        int[] ar2 = ArrayUtils.randomArray(10_000_000, -10000000, 10000000);

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
        Stack<int[]> s = new Stack<>();

        s.push(new int[]{begin, end});


        while (!s.empty()) {
            // get last begin and end from Stack
            int b = s.peek()[0];
            int e = s.pop()[1];

            if (e - b < 10) {
                insertionSort(ar, b, e); // use insertion sort for small subarrays
            } else {
                int partitionIndex = partition(ar, b, e);
                if (b < partitionIndex - 1) {
                    s.push(new int[]{b, partitionIndex - 1});
                }
                if (partitionIndex + 1 < e) {
                    s.push(new int[]{partitionIndex + 1, e});
                }
            }
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

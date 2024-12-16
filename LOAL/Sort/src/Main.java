import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ar = {43, 6, 42, 7, -4, 65, 18, 21, 9, 3, 4, 3};
        Stat ss = selectionSort(ar);
        System.out.println(ss);
        System.out.println(Arrays.toString(ar));

        System.out.println();

        int[] ar2 = {43, 6, 42, 7, -4, 65, 18, 21, 9, 3, 4, 3};
        Stat is = insertionSort(ar2);
        System.out.println(is);
        System.out.println(Arrays.toString(ar2));
    }

    /**
     * Selection sort algorithm.
     * @param ar array to sort
     * @return Stat object with comparisons and swaps
     */
    public static Stat selectionSort(int[] ar) {
        int n = ar.length;
        Stat stat = new Stat("SelectionSort", n);
        int minIndex, temp;

        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i; j < n; j++) {
                stat.compare();
                if (ar[j] < ar[minIndex]) {
                    minIndex = j;
                }
            }

            stat.swap();
            temp = ar[i];
            ar[i] = ar[minIndex];
            ar[minIndex] = temp;
        }

        return stat;
    }

    /**
     * Insertion sort algorithm.
     * @param ar array to sort
     * @return Stat object with comparisons and swaps
     */
    public static Stat insertionSort(int[] ar) {
        int n = ar.length;
        Stat stat = new Stat("InsertionSort", n);
        int key, j;

        for (int i = 1; i < n; i++) {
            key = ar[i];
            j = i - 1;

            while (j >= 0) {
                stat.compare();
                if (ar[j] > key) {
                    ar[j + 1] = ar[j];
                    stat.swap();
                    j--;
                } else {
                    break;
                }
            }

            ar[j + 1] = key;
        }

        return stat;
    }
}

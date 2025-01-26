import JavaUtils.ArrayUtils;

public class Main {
    public static void main(String[] args) {
        int[] ar = ArrayUtils.randomArray(20_000_000, 1, 1000000000);

        ArrayUtils.printArray(ar);

        shellSort(ar);

        ArrayUtils.printArray(ar);
    }

    public static void shellSort(int[] ar) {
        int n = ar.length;
        int temp;

        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = 1; i < ar.length; i++) {
                int j = i;

                while (j >= h && ar[j] < ar[j - h]) {
                    temp = ar[j];
                    ar[j] = ar[j - h];
                    ar[j - h] = temp;
                    j -= h;
                }
            }
        }
    }
}
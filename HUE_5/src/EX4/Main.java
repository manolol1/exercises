package EX4;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          23.10. 2024
 * HUE:           05
 * EX:            03
 * Description:   Permutations
 *********************************************/

public class Main {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        permutations(ar);
    }

    public static void permutations(int[] ar) {
        permutations(ar, 0);
    }

    private static void permutations(int[] ar, int index) {
        if (index == ar.length) {
            printArray(ar);
            return; // current iteration done
        }

        for (int i = index; i < ar.length; i++) {
            swap(ar, index, i);

            permutations(ar, index + 1);

            swap(ar, index, i);
        }
    }

    public static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    /** print an array, with the values seperated by a delimiter */
    public static void printArray(int[] ar, String delimiter) {
        System.out.println(arrayToString(ar, delimiter));
    }

    /** print an array, with the values seperated by a space */
    public static void printArray(int[] ar) {
        System.out.println(arrayToString(ar));
    }

    /** format an array as a String, with the values seperated by a space */
    public static String arrayToString(int[] ar) {
        return arrayToString(ar, " ");
    }

    /** format an array as a String, with the values seperated by a delimiter */
    public static String arrayToString(int[] ar, String delimiter) {
        StringBuilder sb = new StringBuilder(ar.length + ar.length * delimiter.length());

        sb.append(ar[0]);

        for (int i = 1; i < ar.length; i++) {
            sb.append(delimiter).append(ar[i]);
        }

        return sb.toString();
    }
}

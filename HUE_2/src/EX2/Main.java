package EX2;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          30.9. 2024
 * HUE:           02
 * EX:            02
 * Description:   Modify arrays
 *********************************************/

public class Main {
    public static void main(String[] args) {
        System.out.println("EX2\n\n");

        int[] ar = {1, 3};
        printArray(ar);

        System.out.println("Append");
        ar = append(ar, 5);
        ar = append(ar, 10);
        printArray(ar);

        System.out.println("\nPrepend");
        ar = prepend(ar, 2);
        printArray(ar);

        System.out.println("\nDelete");
        ar = delete(ar, 1);
        printArray(ar);
    }

    /**
     * Create a new array with a value appended at the end
     * @param ar original array
     * @param value the value that will be appended to the array
     * @return new (ar.length + 1 long) array with the appended value
     */
    public static int[] append(int[] ar, int value) {
        int[] newAr;

        if (ar == null || ar.length == 0) {
            newAr = new int[1];
        } else {
            newAr = new int[ar.length + 1];
            arrayCopy(ar, newAr);
        }

        newAr[newAr.length - 1] = value;

        return newAr;
    }

    /**
     * Create a new array with a value prepended at the beginning
     * @param ar original array
     * @param value the value that will be prepended to the array
     * @return new (ar.length + 1 long) array with the prepended value
     */
    public static int[] prepend(int[] ar, int value) {
        int[] newAr;

        if (ar == null || ar.length == 0) {
            newAr = new int[1];
        } else {
            newAr = new int[ar.length + 1];
            arrayCopy(ar, newAr, 1);
        }

        newAr[0] = value;

        return newAr;
    }

    /**
     * Copy ar1 into ar2
     * @param ar1 original array
     * @param ar2 array to copy into
     */
    public static void arrayCopy(int[] ar1, int[] ar2) {
        arrayCopy(ar1, ar2, 0);
    }

    /**
     * Copy ar2 into ar1 at a specific position
     * @param ar1 original array
     * @param ar2 array to copy into
     * @param startIndex startIndex where at2 starts
     */
    public static void arrayCopy(int[] ar1, int[] ar2, int startIndex) {
        if (ar1 != null) {
            for (int i = startIndex; i < ar1.length + startIndex && i < ar2.length; i++) {
                ar2[i] = ar1[i - startIndex];
            }
        }
    }

    /**
     * Delete a value from an array
     * @param ar array to delete in
     * @param index index of value to delete - if index > ar.length, the last position will be removed.
     * @return new array with the value removed
     */
    public static int[] delete(int[] ar, int index) {
        int[] newAr;

        if (ar == null || ar.length == 0) {
            newAr = new int[1];
        } else {
            newAr = new int[ar.length - 1];

            int indexOld = 0, indexNew = 0;

            while (indexOld < ar.length && indexNew < newAr.length) {
                // skip position that should be deleted
                if (indexOld == index) {
                    indexOld++;
                }

                newAr[indexNew] = ar[indexOld];

                indexOld++;
                indexNew++;
            }
        }

        return newAr;
    }

    /**
     * Print an array with spaces as delimiters.
     * If the array is null, "null" will be printed.
     * @param ar Array that should be printed
     */
    public static void printArray(int[] ar) {
        if (ar != null) {
            for (int n : ar) {
                System.out.print(n + " ");
            }
            System.out.println();
        } else {
            System.out.println("null");
        }
    }
}

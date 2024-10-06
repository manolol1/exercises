package EX1;

import JavaUtils.*;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          30.9. 2024
 * HUE:           02
 * EX:            01
 * Description:   Fill in and sort an array
 * Used Library:  JavaUtils (library for common input and array/matrix operations, I have written mostly in first grade)
 *********************************************/

public class Main {
    public static void main(String[] args) {
        System.out.println("EX1\n\n");

        int[] ar = new int[0];

        System.out.println("Abbruch mit 0");

        for (;;) {
            System.out.println();
            int input = InputUtils.intInput(Integer.MIN_VALUE, Integer.MAX_VALUE, "Eingabe: ");

            // check exit condition
            if (input == 0) System.exit(0);

            ar = ArrayUtils.append(ar, input);
            ArrayUtils.sort(ar);
            ArrayUtils.printArray(ar);
        }
    }
}

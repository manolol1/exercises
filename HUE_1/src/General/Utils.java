package General;

import java.util.Scanner;

public class Utils {
    /** Ask user to input an integer
     * @param s Scanner Object
     * @param text Will be printed before waiting for input (e.g. variable name)
     * @param min Minimum value (inclusive)
     * @param max Maximum value (inclusive)
     * @return User input
     */

    public static int intInput(Scanner s, String text, int min, int max) {
        System.out.printf("%s (%d-%d): ", text, min, max);
        int input = 0;

        // Wait for user input
        try {
            input = s.nextInt();
        } catch (Exception e) {
            System.out.println("An error occurred while parsing your input. Try again!\n");
            return intInput(s, text, min, max);
        }

        // Check if input is inside bounds
        if (input < min || input > max) {
            System.out.printf("Input must be between %d and %d. Try again!\n\n", min, max);
            return intInput(s, text, min, max);
        }

        return input;

    }
}

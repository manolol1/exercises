package General;

import java.util.Scanner;

public class Utils {
    /**
     * Pause the program for a specified time.
      * @param millis Time to sleep for in milliseconds (1s = 1000 ms)
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

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
            s.nextLine();  // Consume the leftover newline
        } catch (Exception e) {
            System.out.println("An error occurred while parsing your input. Make sure to only enter numbers! Try again!\n");
            s.nextLine(); // Consume invalid input
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

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


    }

    public static int intInput(Scanner s, String name, int min, int max) {
        System.out.printf("%s (%d-%d): ", name, min, max);
        int input = 0;

        try {
            input = s.nextInt();
        } catch (Exception e) {
            System.out.println("An error occured while parsing your input. Try again!\n");
        }

        if (input < min || input > max) {
            System.out.printf("Input must be between %d and %d. Try again!\n\n");
            return intInput(s, name, min, max);
        }

        return input;

    }
}
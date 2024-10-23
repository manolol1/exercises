package EX1;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          23.10. 2024
 * HUE:           05
 * EX:            01
 * Description:   Recursive functions
 *********************************************/

public class Main {
    public static void main(String[] args) {
        printNumbers(20);
        System.out.println();
        printNumbersReverse(20);
        System.out.println();
        printDigitReverse(1234);
        System.out.println();

        System.out.printf("Summe: %d\n", sum(10));
        System.out.printf("Produkt: %d\n", product(11, 9));

        char[] text = "Hello World!".toCharArray();
        reverseText(text);
    }

    /**
     * print numbers from 0 to n
     * @param n last number
     */
    public static void printNumbers(int n) {
        if (n <= 0) return;

        printNumbers(n - 1);
        System.out.printf("%d ", n);
    }

    /**
     * print numbers from n to 0
     * @param n first number
     */
    public static void printNumbersReverse(int n) {
        if (n <= 0) return;

        System.out.printf("%d ", n);
        printNumbersReverse(n - 1);
    }

    /**
     * reverse an integer
     * @param n integer to reverse
     */
    public static void printDigitReverse(int n) {
        if (n <= 0) {
            return;
        }

        System.out.printf("%d ", n % 10);
        printDigitReverse(n / 10);
    }

    /**
     * calculate sum of a number
     * @param n number
     * @return result
     */
    public static int sum(int n) {
        if (n <= 0) return 0;

        return sum(n - 1) + n;
    }

    /**
     * calculate product of two numbers recursively
     * @param n factor 1
     * @param m factor 2
     * @return result
     */
    public static int product(int n, int m) {
        if (m <= 0) return 0;

        return product(n, m - 1) + n;
    }

    /**
     * reverse a char[] and print it
     * @param text char[] to reverse
     */
    public static void reverseText(char[] text) {
        if (text.length == 0) return;

        System.out.print(text[text.length - 1]);

        // create new array without last element
        char[] newText = new char[text.length - 1];
        System.arraycopy(text, 0, newText, 0, text.length - 1);

        reverseText(newText);
    }
}

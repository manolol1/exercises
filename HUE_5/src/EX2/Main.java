package EX2;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          23.10. 2024
 * HUE:           05
 * EX:            02
 * Description:   Recursively convert a number from decimal to binary
 *********************************************/

public class Main {
    public static void main(String[] args) {
        decimalToBinary(11);
    }

    /**
     * Print a decimal number in binary
     * @param n decimal number to convert
     */
    public static void decimalToBinary(int n) {
        if (n < 0) {
            System.out.print('-');
            n *= -1;
        }

        if (n == 0) return;

        decimalToBinary(n / 2);
        System.out.print(n % 2);
    }
}

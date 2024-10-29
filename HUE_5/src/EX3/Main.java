package EX3;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          23.10. 2024
 * HUE:           05
 * EX:            03
 * Description:   Calculate the greatest common divider of two
 *                numbers using Euclid's algorithm
 *********************************************/

public class Main {
    public static void main(String[] args) {
        System.out.println(gcdRecursive(10, 15));
        System.out.println(gcdRecursive(210, 45));
        System.out.println(gcdIterative(10, 15));
        System.out.println(gcdIterative(45, 210));
    }

    public static int gcdIterative(int a, int b) {
        int r;

        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int gcdRecursive(int a, int b) {
        if (a == 0) return b;

        return gcdRecursive(b % a, a);
    }
}

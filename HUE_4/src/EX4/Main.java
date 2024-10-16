package EX4;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          16.10. 2024
 * HUE:           04
 * EX:            04
 * Description:   Fibonacci numbers
 *********************************************/

public class Main {
    public static void main(String[] args) {
        System.out.println(fibonacciIterative(4));
        //System.out.println(fibonacciRecursive(4));
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        System.out.println(n);

        return n + fibonacciRecursive(n - 1);
    }

    public static int fibonacciIterative(int n) {
        int curr = 1, prev1 = 0, prev2 = 1;

        for (int i = 0; i < n; i++) {
            int temp = curr;
            curr = prev1 + prev2;
            prev2 = temp;
        }

        return curr;
    }
}

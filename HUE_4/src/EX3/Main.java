package EX3;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          16.10. 2024
 * HUE:           04
 * EX:            03
 * Description:   Calculate factorials and measure time
 *********************************************/

public class Main {
    public static void main(String[] args) {
        int n = 20;

        long result;
        long startTime, endTime, timeTaken;

        startTime = System.nanoTime();
        result = factorialRecursive(n);
        endTime = System.nanoTime();

        timeTaken = endTime - startTime;

        System.out.println("[Recursive]");
        System.out.println("Result: " + result);
        System.out.printf("Time taken %d ns (= %f ms)", timeTaken, (float) timeTaken / 1000000);

        System.out.println("\n");

        startTime = System.nanoTime();
        result = factorialIterative(n);
        endTime = System.nanoTime();

        timeTaken = endTime - startTime;

        System.out.println("[Iterative]");
        System.out.println("Result: " + result);
        System.out.printf("Time taken %d ns (= %f ms)", timeTaken, (float) timeTaken / 1000000);
    }

    /**
     * Calculate factorial of a number (recursively)
     * @param n nth factorial
     * @return result
     */
    public static long factorialRecursive(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorialRecursive(n - 1);
    }

    /**
     * Calculate factorial of a number (iteratively)
     * @param n nth factorial
     * @return result
     */
    public static long factorialIterative(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}

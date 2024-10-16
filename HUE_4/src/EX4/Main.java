package EX4;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          16.10. 2024
 * HUE:           04
 * EX:            04
 * Description:   Fibonacci numbers
 * Result:        The iterative approach is faster than the recursive approach
 *********************************************/

public class Main {
    public static void main(String[] args) {
        int n = 50;

        long result;
        long startTime, endTime, timeTaken;

        startTime = System.nanoTime();
        result = fibonacciRecursive(n);
        endTime = System.nanoTime();

        timeTaken = endTime - startTime;

        System.out.println("[Recursive]");
        System.out.println("Result: " + result);
        System.out.printf("Time taken %d ns (= %f ms)", timeTaken, (float) timeTaken / 1000000);

        System.out.println("\n");

        startTime = System.nanoTime();
        result = fibonacciIterative(n);
        endTime = System.nanoTime();

        timeTaken = endTime - startTime;

        System.out.println("[Iterative]");
        System.out.println("Result: " + result);
        System.out.printf("Time taken %d ns (= %f ms)", timeTaken, (float) timeTaken / 1000000);
    }

    /**
     * Calculate fibonacci number (recursively)
     * @param n nth fibonacci number
     * @return result
     */
    public static long fibonacciRecursive(long n) {
        if (n < 2) return n;

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * Calculate fibonacci number (iteratively)
     * @param n nth fibonacci number
     * @return result
     */
    public static long fibonacciIterative(long n) {
        long n1 = 0, n2 = 1, n3 = 0;

        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        for (long i = 1; i < n; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        return n3;
    }
}

package EX2;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          16.10. 2024
 * HUE:           04
 * EX:            02
 * Description:   Calculate factorials
 *********************************************/

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    /**
     * Calculate factorial of a number
     * @param n nth factorial
     * @return result
     */
    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}

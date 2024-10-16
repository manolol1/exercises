package EX1;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          16.10. 2024
 * HUE:           04
 * EX:            01
 * Description:   Calculate powers
 *********************************************/

public class Main {
    public static void main(String[] args) {
        System.out.println(pow(5, 4));
        System.out.println(powIterative(5, 4));
    }

    /**
     * Calculate power of a number (recursively)
     * @param b base
     * @param e exponent
     * @return result
     */
    public static int pow(int b, int e) {
        if (e == 1) return b;

        return b * pow(b, e - 1);
    }

    /**
     * Calculate power of a number (iteratively)
     * @param b base
     * @param e exponent
     * @return result
     */
    public static int powIterative(int b, int e) {
        int res = b;

        for (int i = 1; i < e; i++) {
            res *= b;
        }

        return res;
    }

}

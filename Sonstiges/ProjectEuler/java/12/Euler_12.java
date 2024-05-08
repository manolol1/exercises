// projecteuler.net
// Problem 12
// Highly Divisible Triangular Number

// too slow

public class Euler_12 {
   public static void main(String[] args) {
      int n = 0;
      
      for (int i = 10000; countDivisors(n) <= 500; i++) {
         n = triangular(i);
         System.out.println(n + ", " + countDivisors(n));
      }
      System.out.println(n + ", " + countDivisors(n));
   }
   
   private static int triangular(int n) {
      int res = 0;
      
      for (int i = 1; i <= n; i++) {
         res += i;
      }
      
      return res;
   }
   
   private static int countDivisors(int n) {
      int divs = 1;

      for (int i = 1; i <= n / 2; i++) {
         if (n % i == 0) {
            divs++;
         }
      }
      return divs;
   }
}
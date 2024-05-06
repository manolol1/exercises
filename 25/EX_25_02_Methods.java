/********************************************
* Name:          Mario Ebenhofer
* Date:          06.05. 2024
* HUE:           25
* EX:            02
* Description:   Methods
*********************************************/

import java.math.BigInteger;

public class EX_25_02_Methods {
   public static void main(String[] args){
      System.out.println(countDivider(121));
      printDivider(243);
      System.out.println(ggt(45, 63));
      System.out.println(kgv(12, 5));
      System.out.println(isPrime(7));
      System.out.println(nextPrime(5));
      System.out.println(calcFact(5));
      System.out.println(factorial(1234));
      System.out.println(calcPow(5, 3));
      printFactor(1232143);
      System.out.println(digitSum(125));
   }
   
   private static int countDivider(int n) {
      int divs = 1; // counting n as a divisor, too
      if (n < 1) {
         return 0; // assuming that negative divisors shouldn't be counted
      }
      
      for (int i = 1; i <= n / 2; i++) {
         if (n % i == 0) {
            divs++;
         }
      }
      return divs;
   }
   
   private static void printDivider(int n) {
      if (n < 1) {
         return; // assuming that negative divisors shouldn't be printed
      }
      System.out.print(1);
      for (int i = 2; i <= n / 2; i++) {
         if (n % i == 0) {
            System.out.print(" " + i);
         }
      }
      System.out.println();
   }
   
   private static int ggt(int a, int b) {
      while (b != 0) {
         int temp = b;
         b = a % b;
         a = temp;
      }
      return a;
   }
   
   private static int kgv(int a, int b) {
      return (a * b) / ggt(a, b);
   }
   
   private static boolean isPrime(int n) {
      if (n % 2 == 0) {
         return false;
      }
      
      for (int i = 2; i <= Math.sqrt(n); i++) {
         if (n % i == 0) {
            return false;
         }
      }
      return true;
   }
   
   private static int nextPrime(int n) {
      for (int i = n + 1; true; i++) {
         if (isPrime(i)) {
            return i;
         }
      }
   }
   
   private static int calcFact(int n) {
      int res = 1;
      
      for (int i = 2; i <= n; i++) {
         res *= i;
      }
      return res;
   }
   
   private static BigInteger factorial(int n) {
      BigInteger result = new BigInteger("1");
      
      for (int i = 2; i <= n; i++) {
         result = result.multiply(new BigInteger(String.valueOf(i)));
      }
      
      return result;
   }
   
   private static int calcPow(int n, int p) {
      int res = 1;
      for (int i = 0; i < p; i++) {
         res *= n;
      }
      return res;
   }
   
   private static void printFactor(int n) {
      int prime = 2;
      boolean first = true;
      while (n >= 2) {
         if (n % prime == 0) {
            if (!first) {
               System.out.print(" * ");
            }
            first = false;
            System.out.print(prime);
            n /= prime;
         } else {
            prime = nextPrime(prime);
         }
      }
      System.out.println();
   }
   
   private static int digitSum(int n) {
      int sum = 0;
      while (n > 0) {
         sum += n % 10;
         n /= 10;
      }
      return sum;
   }
}

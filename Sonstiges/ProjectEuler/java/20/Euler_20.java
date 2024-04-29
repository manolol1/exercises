// projecteuler.net
// Problem 20
// Factorial Digit Sum

import java.math.BigInteger;

public class Euler_20 {
   public static void main(String[] args) {
      System.out.println(digitSum(factorial(100)).toString());
   }
   
   private static BigInteger factorial(int n) {
      BigInteger result = new BigInteger("1");
      
      for (int i = 2; i <= n; i++) {
         result = result.multiply(new BigInteger(String.valueOf(i)));
      }
      
      return result;
   }
   
   private static BigInteger digitSum(BigInteger n) {
      BigInteger result = new BigInteger("0");
      
      String nStr = n.toString();
      
      for (int i = 0; i < nStr.length(); i++) {
         result = result.add(new BigInteger(String.valueOf(nStr.charAt(i))));
      }
      
      return result;
   }
}
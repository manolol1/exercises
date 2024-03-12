// projecteuler.net
// Problem 2
// Even Fibonacci Numbers

public class Euler_02 {
   public static void main(String[] args) {
      int currNum = 1;
      int previous = 1;
      int tempPrevious = 0;
      int sum = 0;
      int ub = 4000000; // 4 million
       
      while (currNum < ub) {
         tempPrevious = currNum;
         currNum = currNum + previous;
         previous = tempPrevious;
         if (currNum % 2 == 0) {
            sum += currNum;
         }
      }
      System.out.println(sum);
   }
}
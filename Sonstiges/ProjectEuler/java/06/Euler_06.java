// projecteuler.net
// Problem 6
// Sum Square Difference

public class Euler_06 {
   public static void main(String[] args) {
      int lb = 1;
      int ub = 100;
      int sumOfSquares = 0;
      int squareOfSum = 0;
      int tempSum = 0;
      int ctr = lb;
      int difference;
      
      // sum of squares
      while (ctr <= ub) {
         sumOfSquares += (ctr*ctr);
         ctr++;
      }
      
      ctr = lb;
      
      // square of sum
      while (ctr <= ub) {
         tempSum += ctr;
         ctr++;
      }
      
      squareOfSum = tempSum * tempSum;
      
      difference = squareOfSum - sumOfSquares;
      
      System.out.println("Sum of Squares: " + sumOfSquares);
      System.out.println("Square of Sum: " + squareOfSum);
      System.out.println("Difference: " + difference);
      
   }
}
// projecteuler.net
// Problem 5
// Smallest Multiple

public class Euler_05 {
   public static void main(String[] args) {
      int currNum = 20;
      int dividerRangeMin = 1;
      int dividerRangeMax = 20;
      boolean solutionFound = false;
      
      int dividerCtr = dividerRangeMin;
      boolean continueCheckingThisNumber = true;
      
      while (!solutionFound) {
         continueCheckingThisNumber = true;
         dividerCtr = dividerRangeMin;
         while (dividerCtr <= dividerRangeMax && continueCheckingThisNumber) {
            if (currNum % dividerCtr == 0) {
               dividerCtr++;
            } else {
               continueCheckingThisNumber = false;
            }
            if (dividerCtr == 20) {
               System.out.println(currNum);
               solutionFound = true;
            }
         }
         currNum++;
      }
   } 
}
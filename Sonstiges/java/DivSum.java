// Output the sum of all real dividers of n in both decimal and binary representation.
// Also output the total number of dividers as decimal.

public class DivSum {
   public static void main(String[] args) {
      int n = 12;
      
      int sumOfDividers = 0;
      int numOfDividers = 0;
      
      String sumBin = "";
      
      // Calculate number and sum of real dividers
      for (int i = 2; i <= n/2; i++) {
         if (n % i == 0) {
            numOfDividers++;
            sumOfDividers += i;
         }
      }
      
      // create binary representation of sum
      int sumCopy = sumOfDividers;
      
      while(sumCopy > 0) {
         sumBin = sumCopy % 2 + sumBin;
         sumCopy /= 2;
      }

      // Output
      if (numOfDividers == 0) {
         System.out.println(n + " is a prime number.");
      } else {
         System.out.println(n + " has " + numOfDividers + " dividers.");
         System.out.println("Sum Decimal: " + sumOfDividers);
         System.out.println("Sum Binary: " + sumBin);
      }
   }
}
import java.util.Scanner;

public class PrimeInputCheck {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int attemptCtr = 0;
      
      boolean primeFound = false;
      int currInput = 0;
      
      boolean tempIsPrime = true;
      int tempDiv = 2;
      
      while (!primeFound) {
         attemptCtr++;
         System.out.print("Input: ");
         currInput = s.nextInt();
         
         tempIsPrime = true;
         tempDiv = 2;
         
         if (currInput < 2) {
            System.out.println("The number can't be smaller than 2.");
            tempIsPrime = false;
         } else {
            while (tempIsPrime && tempDiv <= Math.sqrt(currInput)) {
               if (currInput % tempDiv == 0) tempIsPrime = false;
               tempDiv += 2;
            }
         }
         
         if (tempIsPrime) {
            primeFound = true;
         } else {
            System.out.println("That's not a prime number. Try again!\n");
         }
      }
      
      System.out.println(currInput + " is a prime number. Well done!");
      System.out.println("Attempts: " + attemptCtr);
   }
}
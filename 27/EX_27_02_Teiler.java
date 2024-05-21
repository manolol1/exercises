/********************************************
* Name:          Mario Ebenhofer
* Date:          21.05. 2024
* HUE:           27
* EX:            02
* Description:   Find numbers with exactly n divisors
*********************************************/

import java.util.Scanner;

public class EX_27_02_Teiler {

   public static void main(String[] args) {
      final int UB = userInput(0, Integer.MAX_VALUE, "Upperbound: ");
      final int n = userInput(Integer.MIN_VALUE, Integer.MAX_VALUE, "n: ");
      
      boolean first = true;
      
      for (int i = 0; i <= UB; i++) {
         if (countDivisors(i) == n) {
            if (!first) {
               System.out.print(", ");
            }
            first = false;
            
            System.out.print(i);
         }
      }
   }
   
   private static int userInput(int lb, int ub, String message) {
      Scanner s = new Scanner(System.in);
      return userInput(s, lb, ub, message);
   }
   
   private static int userInput(Scanner s, int lb, int ub, String message) {
      int input;
      
      System.out.print(message);
      
      try {
         input = s.nextInt();
      } catch (Exception e) {
         System.out.println("Couldn't parse input. Try again!");
         System.out.println("Exception: " + e);
         s.next();
         return userInput(s, lb, ub, message);
      }
      
      if (input < lb || input > ub) {
         System.out.printf("Number must be in range %d - %d. Try again!\n", lb, ub);
         return userInput(s, lb, ub, message);
      }
      return input;
   }
   
   private static int countDivisors(int n) {
      int count = 0;
      
      for (int i = 1; i <= n; i++) {
         if (n % i == 0) {
            count++;
         }
      }
      
      return count;
   }
}

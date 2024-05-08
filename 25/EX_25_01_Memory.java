/********************************************
* Name:          Mario Ebenhofer
* Date:          06.05. 2024
* HUE:           25
* EX:            01
* Description:   Memory Game
*********************************************/

import java.util.Scanner;

public class EX_25_01_Memory {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final int WIN_CONDITION = 12;
      final int LB = 1, UB = 20;
      
      int[] numbers = new int[WIN_CONDITION];
      
      for (int i = 0; i < WIN_CONDITION; i++) {
         clear();
         // get new number
         numbers[i] = random(LB, UB);
         System.out.printf("%-6s Zahl: %6d\n\n", i + 1 + ".", numbers[i]);
      
         // ask user to repeat all numbers
         for (int j = 0; j <= i; j++) {
            System.out.printf("%-6s Eingabe: \t", j + 1 + ".");
            if (s.nextInt() != numbers[j]) {

               System.out.printf("\nFehler! Du hast nur %d Zahlen richtig wiedergegeben.\n", i);
               System.exit(0);
            }
         }
         
         System.out.println();
      }
      System.out.println("Juhu, du hast gewonnen.");
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1)) + lb;
   }
   
   private static void clear() {
      System.out.print("\n".repeat(30));
   }
}

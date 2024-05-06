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
      
      int[] numbers = new int[WIN_CONDITION];
      
      for (int i = 0; i < WIN_CONDITION; i++) {
         // get new number
         System.out.printf("%-6sZahl:\t\t", i + 1 + ".");
         numbers[i] = s.nextInt();
         
         System.out.println();
      
         // ask user to repeat all numbers
         for (int j = 0; j <= i; j++) {
            System.out.printf("%-6sEingabe:\t", j + 1 + ".");
            if (s.nextInt() != numbers[j]) {

               System.out.printf("\nFehler! Du hast nur %d Zahlen richtig wiedergegeben.\n", i);
               System.exit(0);
            }
         }
         
         System.out.println();
      }
      System.out.println("Juhu, du hast gewonnen.");
   }
}

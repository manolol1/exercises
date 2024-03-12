/********************************************
* Name:           Mario Ebenhofer
* Datum:          24.01. 2024
* HUE:            15
* Bsp:            02
* Beschreibung:   Russische Multiplikation
*********************************************/

import java.util.Scanner;

public class EX_15_02_RussMult {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      boolean inputPositive = false;
      
      int factor1 = -1;
      int factor2 = -1;
      
      int result = 0;
      
      while (!inputPositive) {
         inputPositive = true;
         
         System.out.print("Factor 1: ");
         factor1 = s.nextInt();
         
         System.out.print("Factor 2: ");
         factor2 = s.nextInt();
         
         if (factor1 < 1 || factor2 < 1) {
            inputPositive = false;
            System.out.println("Eingaben muessen groesser als 0 sein.");
         }
      }
      
      while (factor1 > 0) {
         if (factor1 % 2 == 1) {
            result += factor2;
         }
         
         factor1 /= 2;
         factor2 *= 2;
      }
      
      System.out.println(result);
   }
}
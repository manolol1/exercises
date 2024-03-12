/********************************************
* Name:           Mario Ebenhofer
* Datum:          28.11.2023
* HUE:            09
* Bsp:            05
* Beschreibung:   Perfekte Zahlen bis zu einer
*                 Obergrenze finden
*********************************************/

import java.util.Scanner;

public class EX_09_05_PerfectNumber {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int ub = 0;
      int tempSum = 0;
      
      System.out.print("Upper Bound: ");
      ub = s.nextInt();
      
      for (int i = 2; i <= ub; i++) {
         tempSum = 0;
         
         // Calculate sum of dividers
         for (int j = 1; j < i; j++) {
            if (i % j == 0) {
               tempSum += j;
            }
         }
         
         if (tempSum == i) {
            System.out.println(i);
         }
      }
   }
}
/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          08.11.2023
* HUE:            07
* Bsp:            02
* Beschreibung:   Anzahl der echten Teiler einer Zahl ausgeben
************************************************************/

import java.util.Scanner;

public class Ex_07_02_Divider {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int num;
      int ctr = 1;
      int sumOfDividers = 0;
      
      // Input
      System.out.print("Zahl eingeben: ");
      num = s.nextInt();
      
      // calculate number of dividers
      while (ctr <= num / 2) {
         if (num % ctr == 0) {
            sumOfDividers++;
         }
         ctr++;
      }
      
      // Output (with correct number formatting)
      if (sumOfDividers == 0) {
         System.out.println("Die Zahl " + num + " hat keine echten Teiler.");
      }
      else if (sumOfDividers == 1) {
         System.out.println("Die Zahl " + num + " hat einen echten Teiler.");
      } else {
         System.out.println("Die Zahl " + num + " hat " + sumOfDividers + " echte Teiler.");
      }
   }
}
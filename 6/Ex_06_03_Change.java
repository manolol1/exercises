/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          25.10.2023
* HUE:            06
* Bsp:            03
* Beschreibung:   Aufsteigende Sortierung
************************************************************/

import java.util.Scanner;

public class Ex_06_03_Change {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int min;
      int max;
      int temp;
      
      System.out.print("min: ");
      min = s.nextInt();
      System.out.print("max: ");
      max = s.nextInt();
      
      if (min > max) {
         temp = min;
         min = max;
         max = temp;
      }
      
      System.out.println("Minimum: " + min);
      System.out.println("Maximum: " + max);
   }
}
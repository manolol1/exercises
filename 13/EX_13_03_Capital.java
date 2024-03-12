/********************************************
* Name:           Mario Ebenhofer
* Datum:          10.01. 2024
* HUE:            13
* Bsp:            03
* Beschreibung:   Zinsen und Kapital berechnen
*********************************************/

import java.util.Scanner;

public class EX_13_03_Capital {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
            
      double capital = 0.0;
      double percentage = 0.0;
      double interest = 0.0;
      int runtime = 0;
      
      boolean inputFinished = false;
      
      // Input
      while (!inputFinished) {
         System.out.print("Startkapital (0 Euro - 1000000 Euro):\t");
         capital = s.nextDouble();
         
         System.out.print("Zinssatz (0% - 7%):\t\t\t\t\t\t\t");
         percentage = s.nextDouble();
         
         System.out.print("Laufzeit (0 Jahre - 60 Jahre):\t\t\t");
         runtime = s.nextInt();
         
         // Check if input numbers are in bounds
         if (capital >= 0 && capital <= 1000000 && percentage >= 0 && percentage <= 7 && runtime >= 0 && runtime <= 60) {
            inputFinished = true;
         } else {
            System.out.println("\nUngueltige Eingabe!\n");
         }
      }
      
      System.out.println("\nJahr\t\tKapitalwert\t\t\tZinssatz\t\tZinsertrag\t\tGesamtkapital");
      
      for (int i = 0; i <= runtime; i++) {
         System.out.printf("%-8d\t", i);
         System.out.printf("%-16.2f\t", capital);
         System.out.printf("%-10.1f\t", percentage);
         
         // (re)-calculate interest and capital
         interest = capital * (percentage / 100);
         capital *= 1 + (percentage / 100);
         
         System.out.printf("%-12.2f\t", interest);
         System.out.printf("%-8.2f\n", capital);
      }
   }
}
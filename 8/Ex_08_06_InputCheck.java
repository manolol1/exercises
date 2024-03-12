/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          15.11.2023
* HUE:            08
* Bsp:            06
* Beschreibung:   Überprüfen, ob Eingabe positiv, gerade und dreistellig ist
************************************************************/

import java.util.Scanner;

public class Ex_08_06_InputCheck {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int lb = 100;
      int ub = 999;
      int userInput = 0;
      int attempts = 0;
      boolean inputPending = true;
     
      while (inputPending) {
         attempts++;
         // User Input
         System.out.print("Zahl eingeben: ");
         userInput = s.nextInt();
         
         // Processing
         if (userInput < lb) {
            System.out.println("Zahl ist zu klein");
         }
         else if (userInput > ub) {
            System.out.println("Zahl ist zu gross");
         }
         else if (userInput % 2 == 1) {
            System.out.println("Bereich ist korrekt, aber die Zahl ist ungerade");
         } else {
            inputPending = false;
            
            // Output
            if (attempts == 1) {
               System.out.println("Die Zahl ist korrekt. Du hast einen Versuch benoetigt.");
            } else {
               System.out.println("Die Zahl ist korrekt. Du hast " + attempts + " Versuche benoetigt.");
            }
         }
      }
   }
}
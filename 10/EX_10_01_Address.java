/********************************************
* Name:           Mario Ebenhofer
* Datum:          06.12.2023
* HUE:            10
* Bsp:            01
* Beschreibung:   Anrede Formulieren
*********************************************/

import java.util.Scanner;

public class EX_10_01_Address {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int hour = 100;
      String sex = "";
      String name = "";
      boolean inputPending = true;
      
      // User Input //
      
      while (inputPending) {
         
         // Only request daytime input, if it isn't valid already.
         // Might be skipped if only gender was invalid.
         if (hour < 0 || hour > 23) {
            System.out.print("Tageszeit: ");
            hour = s.nextInt();
            
            s.nextLine(); // clear scanner
            
            // Check if input is valid
            if (hour >= 0 && hour <= 23) {
               inputPending = false;
            } else {
               inputPending = true;
               System.out.println("Ungueltige Eingabe. Tageszeit muss zwischen 0 und 23 liegen.");
               continue;
            }
         }
         
         // Check if input is valid
         System.out.print("Geschlecht: ");
         sex = s.nextLine();
         
         if (sex.equalsIgnoreCase("m") || sex.equalsIgnoreCase("w") || sex.equalsIgnoreCase("d")) {
            inputPending = false;
         } else {
            inputPending = true;
            System.out.println("Ungueltige Eingabe. Geschlecht muss m, w oder d sein.");
            continue;
         }
         
         System.out.print("Vorname und Nachname: ");
         name = s.nextLine();
      }
      
      System.out.println();
      
      
      // Output //
      
      System.out.print("Guten ");
      
      // Daytime
      if (hour >= 0 && hour <= 10) System.out.print("Morgen ");
      if (hour >= 11 && hour <= 17) System.out.print("Tag ");
      if (hour >= 18 && hour <= 23) System.out.print("Abend ");
      
      // Sex
      if (sex.equalsIgnoreCase("m")) System.out.print("Herr ");
      if (sex.equalsIgnoreCase("w")) System.out.print("Frau ");
      
      System.out.println(name + "!");
   }
}
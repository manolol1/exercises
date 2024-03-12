/********************************************
* Name:           Mario Ebenhofer
* Datum:          10.01. 2024
* HUE:            13
* Bsp:            02-4
* Beschreibung:   Note fuer entsprechende Punktezahl ausgeben
*********************************************/

// Vorteile:
// Nachteile: Bei hoeheren Punktezahlen sehr viel Arbeit zu schreiben

import java.util.Scanner;

public class EX_13_02_Mark_4 {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int points = 0;
      
      System.out.print("Punkte: ");
      points = s.nextInt();
      
      System.out.print("Ausgabe: ");
      
      if (points < 0 || points > 20) {
         System.out.println("Diese Punktezahl ist ungueltig.");
         System.exit(0);
      }
      
      switch (points) {
         case 20: case 19:
            System.out.println(points + " Punkte ergeben ein Sehr Gut");
            break;
         case 18: case 17: case 16:
            System.out.println(points + " Punkte ergeben ein Gut");
            break;
         case 15: case 14: case 13:
            System.out.println(points + " Punkte ergeben ein Befriedigend");
            break;
         case 12: case 11: case 10:
            System.out.println(points + " Punkte ergeben ein Genuegend");
            break;
         default:
            System.out.println(points + " Punkte ergeben ein Nicht Genuegend");
      }
   }
}
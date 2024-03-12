/********************************************
* Name:           Mario Ebenhofer
* Datum:          10.01. 2024
* HUE:            13
* Bsp:            02-3
* Beschreibung:   Note fuer entsprechende Punktezahl ausgeben
*********************************************/

// Vorteile: gut lesbar
// Nachteile: nicht ganz so effizient wie Variante 2

import java.util.Scanner;

public class EX_13_02_Mark_3 {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int points = 0;
      
      System.out.print("Punkte: ");
      points = s.nextInt();
      
      System.out.print("Ausgabe: ");
      if (points > 100 || points < 0) {
         System.out.println("Diese Punktezahl ist ungueltig.");
         System.exit(0);
      }  
      if (points < 50) {
         System.out.println(points + " Punkte ergeben ein Nicht Genuegend");
         System.exit(0);
      }  
      if (points < 63) {
         System.out.println(points + " Punkte ergeben ein Genuegend");
         System.exit(0);
      } 
      if (points < 76) {
         System.out.println(points + " Punkte ergeben ein Befriedigend");
         System.exit(0);
      } 
      if (points < 89) {
         System.out.println(points + " Punkte ergeben ein Gut");
         System.exit(0);
      } 
      if (points > 100) {
         System.out.println(points + " Punkte ergeben ein Sehr Gut");
         System.exit(0);
      }
   }
}
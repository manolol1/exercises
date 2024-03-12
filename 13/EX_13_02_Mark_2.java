/********************************************
* Name:           Mario Ebenhofer
* Datum:          10.01. 2024
* HUE:            13
* Bsp:            02-2
* Beschreibung:   Note fuer entsprechende Punktezahl ausgeben
*********************************************/

// Vorteile: gut lesbar, effizient
// Nachteile: 

import java.util.Scanner;

public class EX_13_02_Mark_2 {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int points = 0;
      
      System.out.print("Punkte: ");
      points = s.nextInt();
      
      System.out.print("Ausgabe: ");
      if (points > 100 || points < 0) {
         System.out.println("Diese Punktezahl ist ungueltig.");
      } else if (points < 50) {
         System.out.println(points + " Punkte ergeben ein Nicht Genuegend");
      } else if (points < 63) {
         System.out.println(points + " Punkte ergeben ein Genuegend");
      } else if (points < 76) {
         System.out.println(points + " Punkte ergeben ein Befriedigend");
      } else if (points < 89) {
         System.out.println(points + " Punkte ergeben ein Gut");
      } else {
         System.out.println(points + " Punkte ergeben ein Sehr Gut");
      } 
   }
}
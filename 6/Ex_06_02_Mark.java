/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          25.10.2023
* HUE:            06
* Bsp:            02
* Beschreibung:   Note fuer Punktezahl ausgeben.
************************************************************/

import java.util.Scanner;

public class Ex_06_02_Mark {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int points;
      
      System.out.print("Eingabe: ");
      points = s.nextInt();
      
      if (points < 0 || points > 100) {
         System.out.println("Ungueltige Punktezahl");
      }
      else if (points >= 89) {
         System.out.println(points + " Punkte ergeben ein Sehr Gut.");
      }
      else if (points >= 76) {
         System.out.println(points + " Punkte ergeben ein Gut.");
      }
      else if (points >= 63) {
         System.out.println(points + " Punkte ergeben ein Befriedigend.");
      }
      else if (points >= 50) {
         System.out.println(points + " Punkte ergeben ein Genuegend.");
      }
      else {
         System.out.println(points + " Punkte ergeben ein Nicht Genuegend.");
      }
   }
}
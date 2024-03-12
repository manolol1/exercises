/********************************************
* Name:           Mario Ebenhofer
* Datum:          06.03. 2024
* HUE:            18
* Bsp:            05
* Beschreibung:   Zeitratespiel
*********************************************/

import java.util.Scanner;

public class EX_18_05_TimeEstimate {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final int LB = 10, UB = 20; // seconds
      final int MAX_DEVIATION = 1; // seconds
      
      boolean done = false;
      
      while (!done) {
         int randomTime = (int) (Math.random() * (UB - LB + 1)) + LB;
         long start, stop;
         long measuredTime, deviation;
         
         System.out.println("Bitte warten Sie moeglichst genau " + timeStringS(randomTime)
            + " Sekunden zwischen Ihren naechsten beiden Eingaben!");
         
         // time measurment
         System.out.print("Enter, um die Zeitnahme zu starten...");
         s.nextLine();
         System.out.println("Duecken Sie in " + timeStringS(randomTime) + " erneut die Entertaste!");
         start = System.currentTimeMillis();
         System.out.print("Enter, um die Zeitnahme zu stoppen...");
         s.nextLine();
         stop = System.currentTimeMillis();
         
         // calculate time and deviation
         measuredTime = stop - start;
         deviation = Math.abs(measuredTime - randomTime * 1000);
         
         System.out.println("Erwartete Zeit: " + timeStringS(randomTime));
         System.out.println("Ihre Zeit: " + timeStringMs(measuredTime));
         System.out.println("Erlaubte Abweichung = " + timeStringS(MAX_DEVIATION));
         System.out.println("Ihre Abweichung: " + timeStringMs(deviation));
      
         if (deviation < MAX_DEVIATION * 1000) {
            System.out.println("Ziel erreicht: Glueckwunsch");
            done = true;
         } else {
            System.out.println("Das war nicht genau genug: Bitte wiederholen!");
            System.out.println();
         }
      }
      
      s.close();
   }
   
   private static String timeStringMs(long ms) {
      return ms / 1000 + (ms / 1000 == 1 ? " Sekunde" : " Sekunden")
            + " plus " + ms % 1000 + " Millisekunden";
   }
   
   private static String timeStringS(int s) {
      return s + (s == 1 ? " Sekunde" : " Sekunden");
   }
}
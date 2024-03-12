/********************************************
* Name:           Mario Ebenhofer
* Datum:          27.11.2023
* HUE:            09
* Bsp:            02
* Beschreibung:   Kabelverleger Abrechnung
*********************************************/

import java.util.Scanner;

public class EX_09_02_Cable {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      // Settings
      int metersOnRoll = 500;
      int fullRollPricePerMeter = 2;
      int startedRollPricePerMeter = 3;
      int salaryPerHour = 50;
      int overTimeLimit = 40;
      
      // User Input
      System.out.print("Verlegte Kabelmeter: ");
      int cableMeters = s.nextInt();
      System.out.print("Arbeitszeit in Std.: ");
      int totalWorkTime = s.nextInt();
      
      // Things that need to be calculated
      int normalWorkTime = 0;
      int overTime = 0;
      int fullRolls = 0;
      int startedRollMeters = 0;
      int fullRollsCost = 0;
      int startedRollCost = 0;
      int normalTimeCost = 0;
      int overTimeCost = 0;
      int totalCost = 0;
      
      
      /* Calculating... */
      // Time
      if (totalWorkTime > overTimeLimit) {
         overTime = totalWorkTime - overTimeLimit;
      }
      normalWorkTime = totalWorkTime - overTime;
      
      // Rolls
      fullRolls = cableMeters / metersOnRoll;
      startedRollMeters = cableMeters % metersOnRoll;
      
      // Cost
      fullRollsCost = fullRolls * metersOnRoll * fullRollPricePerMeter;
      startedRollCost = startedRollMeters * startedRollPricePerMeter;
      normalTimeCost = normalWorkTime * salaryPerHour;
      overTimeCost = overTime * salaryPerHour * 2;
      totalCost = fullRollsCost + startedRollCost + normalTimeCost + overTimeCost;
      
      
      // Output
      System.out.println("Kosten: ");
      System.out.println("  " + fullRolls + " ganze Rollen: " + fullRollsCost);
      System.out.println("  " + startedRollMeters + " angefangene Meter: " + startedRollCost);
      System.out.println("  Arbeitszeit: " + normalTimeCost);
      System.out.println("  Ueberstunden: " + overTimeCost);
      System.out.println("  Gesamtkosten: " + totalCost);
   }
}
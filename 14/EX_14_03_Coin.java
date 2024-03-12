/********************************************
* Name:           Mario Ebenhofer
* Datum:          17.01. 2024
* HUE:            14
* Bsp:            03
* Beschreibung:   Muenzen werfen
*********************************************/

public class EX_14_03_Coin {
   public static void main(String[] args){
      final int TOTAL_ROLLS = 100;
   
      int longestRun = 0;
      int longestRunNumber = -1;
      int longestSeries = 0;
      int currentRun = 0;
      int currentSeries = 0;
      int currentNumber = -1;
      
      int lastNumber;
      
      for (int i = 0; i < TOTAL_ROLLS; i++) {
         lastNumber = currentNumber;
         currentNumber = (int) Math.round(Math.random());
         System.out.print(currentNumber == 1 ? "K" : "Z");
         
         if (currentNumber == lastNumber) {
            currentRun++;
         } else {
            currentRun = 1;
         }
         
         if (currentRun >= longestRun) {
            longestRun = currentRun;
            longestRunNumber = currentNumber;
         
            if (currentNumber != lastNumber) {
               currentSeries++;
            } else {
               if (currentSeries > longestSeries) longestSeries = currentSeries;
               currentSeries = 0;
            }
         }
      }
      
      System.out.print("\nLaengster Run:\t\t");
      
      switch (longestRunNumber) {
         case 1: System.out.print("Kopf"); 
            break;
         case 0: System.out.print("Zahl"); 
      }
      
      System.out.println(" (" + longestRun + "x)");
      System.out.println("Laengste Serie:\t" + longestSeries + "x");
      System.out.println("Gesamtwuerfe:\t\t" + TOTAL_ROLLS);
   }
}
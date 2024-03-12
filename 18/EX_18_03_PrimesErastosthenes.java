/********************************************
* Name:           Mario Ebenhofer
* Datum:          06.03. 2024
* HUE:            18
* Bsp:            03
* Beschreibung:   Primzahlenbestimmung mittels Sieb des Eratosthenes
*********************************************/

public class EX_18_03_PrimesErastosthenes {
   public static void main(String[] args){
      final int UB = 100_000, NUMBERS_PER_LINE = 15, NUM_SPACING = 3;
      boolean[] isPrime = new boolean[UB];
      
      int numsInLine;
      int maxNumLength = String.valueOf(UB).length();
   
      for (int i = 2; i < UB; i++) {
         isPrime[i] = true;
      }
      
      // set all multiples of numbers to false
      for (int i = 2; i < Math.sqrt(UB) + 1; i++) {
         for (int j = 2; j < UB; j++) {
            if (j % i == 0 && j != i) isPrime[j] = false;
         }
      }
      
      // output
      numsInLine = 0;
      for (int i = 2; i < UB; i++) {
         if (isPrime[i]) {
            if (numsInLine >= NUMBERS_PER_LINE) {
               System.out.println();
               numsInLine = 0;
            }
            numsInLine++;
            System.out.printf("%-" + (maxNumLength + NUM_SPACING) + "d", i);
         }
      }
   }
}
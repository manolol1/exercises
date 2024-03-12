/********************************************
* Name:           Mario Ebenhofer
* Datum:          28.02. 2024
* HUE:            17
* Bsp:            05
* Beschreibung:   Duplikate in Array mit 0 ersetzen
*********************************************/

public class EX_17_05_Duplicate {
   public static void main(String[] args){
      final int LENGTH = 100, LB = 1, UB = 100;
      final int NUMBERS_PER_LINE = 10;
      int[] ar = randomArray(LENGTH, LB, UB);
      boolean[] seen = new boolean[UB - LB + 1];
      
      System.out.println("Original Array:");
      System.out.println(arrayAsString(ar, NUMBERS_PER_LINE, String.valueOf(UB).length()));
      
      // replace duplicates with 0
      for (int i = 0; i < LENGTH; i++) {
         if (seen[ar[i] - LB]) {
            ar[i] = 0;
         } else {
            seen[ar[i] - LB] = true;
         }
      }
      
      System.out.println("\nAfter replacing duplicates with 0:");
      System.out.println(arrayAsString(ar, NUMBERS_PER_LINE, String.valueOf(UB).length()));
   }
   
   private static int[] randomArray(int length, int lb, int ub) {
      int[] ar = new int[length];
   
      for (int i = 0; i < length; i++) {
         ar[i] = (int) (Math.random() * (ub - lb + 1)) + lb;
      }
      
      return ar;
   }
   
   private static String arrayAsString(int[] ar, int numbersPerLine, int maxNumLength) {
      StringBuilder str = new StringBuilder(ar.length * maxNumLength);
      
      str.append(String.format("%" + maxNumLength + "d", ar[0]));
      
      for (int i = 1; i < ar.length; i++) {
         if (i % numbersPerLine == 0) {
            str.append("\n");
         } else {
            str.append("  ");
         }
         
         str.append(String.format("%" + maxNumLength + "d", ar[i]));
         // numbers are aligned to the right side to make it look better with negative numbers
      }
      
      return str.toString();
   }
}
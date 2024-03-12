/********************************************
* Name:           Mario Ebenhofer
* Datum:          28.02. 2024
* HUE:            17
* Bsp:            02
* Beschreibung:   Zahlen zaehlen
*********************************************/

import java.util.*;

public class EX_17_02_ArrayII {
   public static void main(String[] args){
      final int LENGTH = 20, LB = 1, UB = 8;
      int[] ar = randomArray(LENGTH, LB, UB);
      int[] count = new int[UB - LB + 1];
      ArrayList<Integer> missingNums = new ArrayList<>();
      
      int mostCommonNum = LB;
      
      for (int i = 0; i < LENGTH; i++) {
         count[ar[i] - LB]++;
      }
   
      for (int i = 0; i <= UB - LB; i++) {
         if (count[mostCommonNum - LB] <= count[i]) mostCommonNum = i + LB;
         if (count[i] < 1) missingNums.add(i + LB);
      }
      
      // DEBUG: print count[]
      /*for (int i = 0; i < count.length; i++) {
         System.out.println(i + LB + ": " + count[i]);
      }*/
      
      // Output
      System.out.println("Array: " + arrayAsString(ar));
      System.out.println("Haeufigste Zahl: " + mostCommonNum + " (wenn mehrere Zahlen gleich haeufig sind, wird die groesste davon ausgegeben)");
      System.out.println("Fehlende Zahlen: " + arrayAsString(missingNums, "keine"));
   }
   
   private static int[] randomArray(int length, int lb, int ub) {
      int[] ar = new int[length];
   
      for (int i = 0; i < length; i++) {
         ar[i] = (int) (Math.random() * (ub - lb + 1)) + lb;
      }
      
      return ar;
   }
   
   private static String arrayAsString(int[] ar) {
      String str = "" + ar[0];
      
      for (int i = 1; i < ar.length; i++) {
         str += (", " + ar[i]);
      }
      
      return str;
   }
   
   private static String arrayAsString(ArrayList<Integer> ar, String emptyString) {
      if (ar.isEmpty()) 
         return emptyString;
      
      String str = "" + ar.get(0);
      
      for (int i = 1; i < ar.size(); i++) {
         str += (", " + ar.get(i));
      }
      
      return str;
   }
}
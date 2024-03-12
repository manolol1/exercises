/********************************************
* Name:           Mario Ebenhofer
* Datum:          06.03. 2024
* HUE:            18
* Bsp:            02
* Beschreibung:   Hauefigkeit von Zahlen in Zufallszahlenarray ausgeben.
*********************************************/

import java.util.*;

public class EX_18_02_Frequency {
   public static void main(String[] args){
      final int LENGTH = 20, LB = 10, UB = 100;
      int[] ar = randomArray(LENGTH, LB, UB);
      int[] count = new int[UB - LB + 1];
      
      int mostCommonNum = LB;
      
      for (int i = 0; i < LENGTH; i++) {
         count[ar[i] - LB]++;
      }
   
      for (int i = 0; i <= UB - LB; i++) {
         if (count[mostCommonNum - LB] <= count[i]) mostCommonNum = i + LB;
      }
      
      //System.out.println(Arrays.toString(ar));
      
      // Output
      System.out.println("Hauefigkeiten:");
      for (int i = 0; i < count.length - 1; i++) {
         if (count[i] != 0) {
            System.out.println(i + LB + ": " + count[i]);
         }
      }
      
      System.out.println("\n\nHauefigste Zahl:\t" + mostCommonNum + "  kommt " + count[mostCommonNum - LB] + "x vor");
   }
   
   private static int[] randomArray(int length, int lb, int ub) {
      int[] ar = new int[length];
   
      for (int i = 0; i < length; i++) {
         ar[i] = (int) (Math.random() * (ub - lb + 1)) + lb;
      }
      
      return ar;
   }
}
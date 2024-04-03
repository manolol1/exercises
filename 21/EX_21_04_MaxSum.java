/********************************************
* Name:           Mario Ebenhofer
* Datum:          03.04. 2024
* HUE:            21
* Bsp:            04
* Beschreibung:   
*********************************************/

import java.util.Scanner;

public class EX_21_04_MaxSum {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final int LENGTH = 10;
      final int LB = -10, UB = 10;
      
      int[] ar = randomArray(LENGTH, LB, UB);
   }
   
   private static int[] randomArray(int length, int lb, int ub) {
      int[] ar = new int[length];
      
      for (int i = 0; i < length; i++) {
         ar[i] = (int) (Math.random() * (ub - lb + 1) + lb);
      }
      
      return ar;
   }

}
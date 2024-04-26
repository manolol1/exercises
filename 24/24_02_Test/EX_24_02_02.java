/********************************************
* Name:          Mario Ebenhofer
* Date:          24.04 2024
* HUE:           24_02
* EX:            02
* Description:   Test (1AHIF)
*********************************************/

import java.util.Scanner;

public class EX_24_02_02 {
   public static void main(String[] args){
      int[] arr1 = {1,3,5,7,8,10,12,14,16};
      int[] arr2 = {3,10,17,24,31,38,45,52};
      int[] arr3 = {-10, -5, 0, 5, 10, 15};
      
      printSequenceCheck(arr1);
      System.out.println();
      
      printSequenceCheck(arr2);
      System.out.println();
      
      printSequenceCheck(arr3);
   }
   
   private static boolean isSequence(int[] ar) {
      final int FIRST_DIFFERENCE = ar[1] - ar[0];
      
      for (int i = 2; i < ar.length - 1; i++) {
         if (ar[i + 1] - ar[i] != FIRST_DIFFERENCE) {
            return false;
         }
      }
      
      return true;
   }
   
   private static void printArray(int[] ar) {
      System.out.print(ar[0]);
      
      for (int i = 1; i < ar.length; i++) {
         System.out.print(" " + ar[i]);
      }
      
      System.out.println();
   }
   
   private static void printSequenceCheck(int[] ar) {
      System.out.println("Array");
      printArray(ar);
      System.out.println("Der Abstand ist" + (isSequence(ar) ? "" : " nicht") + " immer gleich.");
   }
}
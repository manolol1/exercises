/********************************************
* Name:          Mario Ebenhofer
* Date:          11.01. 2024
* HUE:           00
* EX:            01
*********************************************/

public class EX_00_01_Arraypruefung {
   public static void main(String[] args) {
      int[] arr1 = {1, 5, 14, 27, 60};
      int[] arr2 = {1, 10, 100, 1000, 10000, 20000};
      
      System.out.printf("arr1: %b\n", checkArray(arr1));
      System.out.printf("arr2: %b\n", checkArray(arr2));
   }
   
   public static boolean checkArray(int[] ar) {
      int temp = Integer.MIN_VALUE;
      for (int n : ar) {
         if (n <= 2 * temp) return false;
         temp = n;
      }
      return true;
   }
}
/********************************************
* Name:          Mario Ebenhofer
* Date:          11.01. 2024
* HUE:           00
* EX:            03
*********************************************/

public class EX_00_03_Patternmatching {
   public static void main(String[] args) {
      int[] ar1 = {12, 12, 54, 77, 23, 98};
      int[] ar2 = {12, 12, 54, 77, 23, 98};
      int[] ar3 = {12, 12, 53, 77, 23, 98};
      int[] ar4 = {54, 12, 54, 77, 77, 98, 23, 54};
      
      System.out.printf("[Test 1 - arraysEqual(ar1, ar2)] Expected: true, Actual result: %b\n", arraysEqual(ar1, ar2));
      System.out.printf("[Test 2 - arraysEqual(ar1, ar3)] Expected: false, Actual result: %b\n\n", arraysEqual(ar1, ar3));
      
      System.out.printf("[Test 3 - arrayContains(ar1, 12)] Expected: true, Actual result: %b\n", arrayContains(ar1, 12));
      System.out.printf("[Test 4 - arrayContains(ar1, 13)] Expected: false, Actual result: %b\n\n", arrayContains(ar1, 13));
      
      System.out.printf("[Test 5 - arraysContainSameValues(ar1, ar4)] Expected: true, Actual result: %b\n", arraysContainSameValues(ar1, ar4));
      System.out.printf("[Test 6 - arraysContainSameValues(ar1, ar3)] Expected: false, Actual result: %b\n", arraysContainSameValues(ar1, ar3));
   }
   
   /** Check if two arrays are equal */
   public static boolean arraysEqual(int[] ar1, int[] ar2) {
      if (ar1.length != ar2.length) return false; // arrays must be the same length
      
      for (int i = 0; i < ar1.length; i++) {
         if (ar1[i] != ar2[i]) return false;
      }
      
      return true;
   }
   
   /** Check if two arrays contain the same values at least once */
   public static boolean arraysContainSameValues(int[] ar1, int[] ar2) {
      // check if ar2 contains every value in ar1
      for (int i = 0; i < ar1.length; i++) {
         if (!arrayContains(ar2, ar1[i])) return false;
      }
      
      // check if ar1 contains every value in ar2
      for (int i = 0; i < ar2.length; i++) {
         if (!arrayContains(ar1, ar2[i])) return false;
      }
      
      return true;
   }
   
   /** Check if an array contains a value */
   public static boolean arrayContains(int[] ar, int value) {
      for (int n : ar) {
         if (n == value) return true;
      }
      return false;
   }
}
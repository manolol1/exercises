/********************************************
* Name:           Mario Ebenhofer
* Datum:          12.02. 2024
* HUE:            16
* Bsp:            0
* Beschreibung:   
*********************************************/

public class EX_16_03_ArrayShift {
   public static void main(String[] args){
      final int SHIFTS_R = 1;
      final int SHIFTS_L = 1;
      final int SIZE = 5;
      final int LB = 1;
      final int UB = 9;
      
      int[] ar = new int[SIZE];
      
      // fill array with random numbers
      for (int i = 0; i < ar.length; i++) {
         ar[i] = (int) (Math.random() * (UB - LB + 1)) + LB;
      }
      
      // print array
      System.out.print("Ausgabe\t\t\t");
      printArray(ar);
      
      // shift right and print
      for (int i = 0; i < SHIFTS_R; i++) {
         ar = shiftRight(ar);
      }
      System.out.print("\nNach rechts\t\t");
      printArray(ar);
      
      // shift left and print
      for (int i = 0; i < SHIFTS_L; i++) {
         ar = shiftLeft(ar);
      }
      System.out.print("\nNach links\t\t");
      printArray(ar);
   }
   
   private static void printArray(int[] ar) {
      System.out.print(ar[0]);
      for (int i = 1; i < ar.length; i++) {
         System.out.print(" " + ar[i]);
      }
   }
   
   private static int[] shiftRight(int[] ar) {
      int lastElement = ar[ar.length - 1];
   
      for (int i = ar.length - 1; i > 0; i--) {
         ar[i] = ar[i - 1];
      }
   
      ar[0] = lastElement;
      
      return ar;
   }
   
   private static int[] shiftLeft(int[] ar) {
      int firstElement = ar[0];
   
      for (int i = 0; i < ar.length - 1; i++) {
         ar[i] = ar[i + 1];
      }
      
      ar[ar.length - 1] = firstElement;
      
      return ar;
   }
   
}
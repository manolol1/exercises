/********************************************
* Name:           Mario Ebenhofer
* Datum:          12.02. 2024
* HUE:            16
* Bsp:            02
* Beschreibung:   Min und Max von Array
*********************************************/

public class EX_16_02_ArrayMinMax {
   public static void main(String[] args){
      final int SIZE = 10;
      final int LB = 1;
      final int UB = 100;
      
      int[] ar = new int[SIZE];
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      
      // fill array with random numbers
      for (int i = 0; i < ar.length; i++) {
         ar[i] = (int) (Math.random() * (UB - LB + 1)) + LB;
      }
      
      // print array
      System.out.print("Ausgabe:\t" + ar[0]);
      for (int i = 1; i < ar.length; i++) {
         System.out.print(", " + ar[i]);
      }
      
      // find min and max
      for (int i : ar) {
         if (i < min) min = i;
         if (i > max) max = i;
      }
      
      // print min and max
      System.out.println("\nMinimum:\t" + min);
      System.out.println("Maximum:\t" + max);
   }
}
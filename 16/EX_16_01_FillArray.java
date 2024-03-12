/********************************************
* Name:           Mario Ebenhofer
* Datum:          12.02. 2024
* HUE:            16
* Bsp:            01
* Beschreibung:   Array füllen
*********************************************/

public class EX_16_01_FillArray {
   public static void main(String[] args){
      int sum = 0;
      int[] ar = new int[5];
      ar[0] = 10;
      ar[1] = 20;
      ar[2] = 30;
      ar[3] = 40;
      ar[4] = 50;
      
      System.out.print("Array:");
      for (int i : ar) {
         System.out.print("   " + i);
         sum += i;
      }
      
      System.out.println("\nSumme:   " + sum);
   }
}
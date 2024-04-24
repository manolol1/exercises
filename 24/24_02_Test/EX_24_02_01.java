/********************************************
* Name:          Mario Ebenhofer
* Date:          24.04 2024
* HUE:           24_02
* EX:            01
* Description:   Test (1AHIF)
*********************************************/

public class EX_24_02_01 {
   public static void main(String[] args){
      int[] ar = new int[20];
      
      fillArray(ar, -20, 20);
      
      printArray(ar, 4);
      
      System.out.println("\nMax: " + max(ar));
      
      shiftLeft(ar); 
      printArray(ar, 4);
   }
   
   private static void fillArray(int[] ar, int lb, int ub) {
      for (int i = 0; i < ar.length; i++) {
         ar[i] = random(lb, ub);
      }
   }
   
   private static void printArray(int[] ar, int valuesPerLine) {
      for (int i = 0; i < ar.length; i++) {
         if (i % valuesPerLine == 0) {
            System.out.println();
         }
         
         System.out.print(ar[i] + "  ");
      }
      System.out.println();
   }
   
   private static int max(int[] ar) {
      int max = ar[0];
      for (int n : ar) {
         if (n > max) {
            max = n;
         }
      }
      return max;
   }
   
   private static void shiftLeft(int[] ar) {
      while (ar[0] < 0) {
         shiftLeft(ar);
      }
   }
   
   private static void shiftLeftOnce(int[] ar) {
      int temp = ar[0];
      
      for (int i = 0; i < ar.length - 1; i++) {
         ar[i] = ar[i + 1];
      }
      ar[ar.length - 1] = temp;
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1)) + lb;
   }
}
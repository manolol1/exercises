/********************************************
* Name:           Mario Ebenhofer
* Datum:          28.02. 2024
* HUE:            17
* Bsp:            01
* Beschreibung:   Zufaelliges Array: Doppelte Zahlen?
*********************************************/

public class EX_17_01_Array {
   public static void main(String[] args){
      final int LENGTH = 10, LB = 1, UB = 50;
      int[] ar = randomArray(LENGTH, LB, UB);
      boolean[] seen = new boolean[UB - LB + 1];
      boolean allUnique = true;
      
      for (int i = 0; i < LENGTH && allUnique; i++) {
         if (seen[ar[i] - LB]) allUnique = false;
         seen[ar[i] - LB] = true;
      }
      
      System.out.print(arrayAsString(ar) + "\t");
      System.out.println(allUnique ? "Alle Zahlen sind einzigartig" : "Es gibt Doppelte");
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
}
/********************************************
* Name:           Mario Ebenhofer
* Datum:          28.02. 2024
* HUE:            17
* Bsp:            03
* Beschreibung:   Lottozahlen
*********************************************/

public class EX_17_03_Lotto {
   public static void main(String[] args){
      final int LENGTH = 6, LB = 1, UB = 45;
      int[] numbers = randomUniqueArray(LENGTH, LB, UB);
      
      System.out.println(arrayAsString(numbers));
   }
   
   private static int[] randomUniqueArray(int length, int lb, int ub) {
      int[] ar = new int[length];
      boolean[] seen = new boolean[ub - lb + 1];
   
      for (int i = 0; i < length; i++) {
         boolean unique = false;
         while (!unique) {
            int random = (int) (Math.random() * (ub - lb + 1)) + lb;
            if (!seen[random - lb]) {
               seen[random - lb] = true;
               unique = true;
               ar[i] = random;
            }
         }
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
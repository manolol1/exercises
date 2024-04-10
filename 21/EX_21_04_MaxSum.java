/********************************************
* Name:           Mario Ebenhofer
* Datum:          03.04. 2024
* HUE:            21
* Bsp:            04
* Beschreibung:   Groesste Teilsumme in Array finden
*********************************************/

public class EX_21_04_MaxSum {
   public static void main(String[] args){
      final int LENGTH = 10;
      final int LB = -10, UB = 10;
      
      int[] ar = randomArray(LENGTH, LB, UB);
      //int[] ar = {5, -7, 3, 6, 4, -5, 4, 2, -8, 4};
      
      int startIndex = 0, endIndex = 0, maxSum = ar[0];
      int tempStart = 0, tempSum = 0;
      
      System.out.println(arrayToString(ar));
      
      for (int i = 0; i < ar.length; i++) {
         tempSum += ar[i];
         if (tempSum > maxSum) {
            maxSum = tempSum;
            startIndex = tempStart;
            endIndex = i;
         }
         
         if (tempSum < 0) {
            tempSum = 0;
            tempStart = i + 1;
         }
      }
      
      System.out.printf("Die groesste Teilsumme betraegt %d und reicht von Position %d bis Position %d.\n", maxSum, startIndex, endIndex);
   }
   
   private static int[] randomArray(int length, int lb, int ub) {
      int[] ar = new int[length];
      
      for (int i = 0; i < length; i++) {
         ar[i] = (int) (Math.random() * (ub - lb + 1) + lb);
      }
      
      return ar;
   }
   
   private static String arrayToString(int[] ar) {
      String result = "" + ar[0];
      
      for (int i = 1; i < ar.length; i++) {
         result += " " + ar[i];
      }
      
      return result;
   }

}
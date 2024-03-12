/********************************************
* Name:           Mario Ebenhofer
* Datum:          06.03. 2024
* HUE:            18
* Bsp:            04
* Beschreibung:   2 sortierte Arrays -> 1 sortiertes Array
*********************************************/

import java.util.Arrays;

public class EX_18_04_MergeSort {
   public static void main(String[] args){
      int[] ar1 = {1, 5, 7, 13, 25, 36, 67, 78, 92, 103, 128, 169, 231};
      int[] ar2 = {3, 5, 10, 60, 97, 118, 400, 410};
      int[] result = new int[ar1.length + ar2.length];
      
      int ctr1 = 0, ctr2 = 0;
      
      for (int i = 0; i < result.length; i++) {
         if (ctr1 < ar1.length && ctr2 < ar2.length) {
            if (ar1[ctr1] < ar2[ctr2]) {
               result[i] = ar1[ctr1];
               ctr1++;
            } else {
               result[i] = ar2[ctr2];
               ctr2++;
            }
         } else {
            if (ctr1 < ar1.length) {
               result[i] = ar1[ctr1];
               ctr1++;
            } else {
               result[i] = ar2[ctr2];
               ctr2++;
            }
         }
      }
      
      System.out.println(Arrays.toString(result));
   }
}
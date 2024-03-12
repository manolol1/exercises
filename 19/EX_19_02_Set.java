/***************************************************************************
* Name:           Mario Ebenhofer
* Datum:          12.03. 2024
* HUE:            19
* Bsp:            02
* Beschreibung:   Mengen
***************************************************************************/

public class EX_19_02_Set {
   public static void main(String[] args){
      // NOTE: Integer.MIN_VALUE cannot be used in both arrays.
      int[] set1 = {1, 10, 3, 10, 128, 10, 7, 9};
      int[] set2 = {10, 9, 87, 55, 1, 76, 76, 4, 5, 10};
      
      System.out.println("Menge 1: " + arrayAsString(set1, set1.length));
      System.out.println("Menge 2: " + arrayAsString(set2, set2.length));
      
      int set1Length = duplicateCheck(set1, "Menge 1");
      int set2Length = duplicateCheck(set2, "Menge 2");
      
      System.out.println("Menge 1: " + arrayAsString(set1, set1Length));
      System.out.println("Menge 2: " + arrayAsString(set2, set2Length));
   }
   
   private static int duplicateCheck(int[] ar, String setName) {
      boolean duplicatesFound = false;
      int newLength = ar.length;
      // find duplicates and mark them with Integer.MIN_VALUE
      for (int i = 0; i < ar.length; i++) {
         for (int j = i + 1; j < ar.length; j++) {
            if (ar[i] == ar[j]) {
               ar[j] = Integer.MIN_VALUE;
               duplicatesFound = true;
            }
         }
      }
         
      if (duplicatesFound) {
         System.out.println(setName + " enthaelt mehrfach vorkommende Zahlen! - Duplikate wurden entfernt.");
         
         // move all duplicates to the end of the array and update length
         for (int i = 0; i < newLength; i++) {
            if (ar[i] == Integer.MIN_VALUE) {
               for (int j = i; j < newLength - 1; j++) {
                  ar[j] = ar[j + 1];
               }
               newLength--;
            }
         }
      }
      
      return newLength;
   }

   private static String arrayAsString(int[] ar, int length) {
      String str = "{" + ar[0];
      
      for (int i = 1; i < length; i++) {
         str += (", " + ar[i]);
      }
      
      str += "}";
      
      return str;
   }
}
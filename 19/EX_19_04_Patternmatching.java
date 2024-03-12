/***************************************************************************
* Name:           Mario Ebenhofer
* Datum:          12.03. 2024
* HUE:            19
* Bsp:            04
* Beschreibung:   Feststellen ob Muster auftaucht
***************************************************************************/

public class EX_19_04_Patternmatching {
   public static void main(String[] args){
      int[] ar = {5, 3, 8, 4, 6, 2, 2, 7, 8, 3, 8, 5, 5, 9, 4, 3, 5};
      int[] pattern = {3, 8, 5};
      
      int firstMatchIndex = -1;
      
      for (int i = 0; i < ar.length - pattern.length && firstMatchIndex == -1; i++) {
         boolean matchPossible = true;
         for (int j = 0; j < pattern.length && matchPossible; j++) {
            if (ar[i + j] != pattern[j]) {
               matchPossible = false;
            }
         }
         if (matchPossible) {
            firstMatchIndex = i;
         }
      }
      
      // output
      if (firstMatchIndex == -1) {
         System.out.println("Kuerzeres Array kommt nicht vor.");
      } else {
         System.out.println("Kuerzeres Array kommt ab Position " + firstMatchIndex + " vor.");
      }
   }
}
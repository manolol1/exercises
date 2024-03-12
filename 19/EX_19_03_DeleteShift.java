/***************************************************************************
* Name:           Mario Ebenhofer
* Datum:          12.03. 2024
* HUE:            19
* Bsp:            03
* Beschreibung:   Zahlen, die mehrmals vorkommen durch 0 ersetzen und ans Ende verschieben
***************************************************************************/

public class EX_19_03_DeleteShift {
   public static void main(String[] args){
      int[] ar = {14, 56, 23, 18, 14, 36, 14, 77, 66, 56, 23, 11, 11};
      
      int newLength = ar.length;
      
      System.out.println("Normale Ausgabe: " + arrayAsString(ar));
      
      // find duplicates and replace them with 0
      for (int i = 0; i < ar.length; i++) {
         boolean isDuplicate = false;
         for (int j = i + 1; j < ar.length; j++) {
            if (ar[i] == ar[j]) {
               ar[j] = 0;
               isDuplicate = true;
            }
         }
         if (isDuplicate) {
            ar[i] = 0;
         }
      }
      
      System.out.println("Ersetzen durch 0: " + arrayAsString(ar));
   
      // move all 0s to the end of the array
      int numZeros = 0;
      for (int i = 0; i < ar.length - numZeros; i++) {
         if (ar[i] == 0) {
            numZeros++;
            for (int j = i; j < ar.length - numZeros; j++) {
               ar[j] = ar[j + 1];
            }
            i--; // check again for that index, in case the next value is also 0
         }
      }
   
      System.out.println("Nachschieben: " + arrayAsString(ar));
   }
   
   private static String arrayAsString(int[] ar) {
      String str = "" + ar[0];
      
      for (int i = 1; i < ar.length; i++) {
         str += (", " + ar[i]);
      }
      
      return str;
   }

}
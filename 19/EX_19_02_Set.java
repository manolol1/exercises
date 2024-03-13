/***************************************************************************
* Name:           Mario Ebenhofer
* Datum:          12.03. 2024
* HUE:            19
* Bsp:            02
* Beschreibung:   Mengen (Durchschnitt, Vereinigung, ...)
***************************************************************************/

public class EX_19_02_Set {
   public static void main(String[] args){
      // NOTE: Integer.MIN_VALUE cannot be used in both arrays.
      int[] set1 = {1, 10, 3, 10, 128, 10, 7, 9};
      int[] set2 = {10, 9, 87, 55, 1, 76, 76, 4, 5, 10};
      
      final int MIN_LENGTH = (set1.length > set2.length) ? set2.length : set1.length;
      
      int[] intersection = new int[MIN_LENGTH];
      int intersectionLength;
      
      int[] combined = new int[set1.length + set2.length];
      int combinedLength;
      
      int[] only1 = new int[set1.length];
      int only1Length;
      
      int[] only2 = new int[set2.length];
      int only2Length;
      
      int set1Length = duplicateCheck(set1, "Menge 1");
      int set2Length = duplicateCheck(set2, "Menge 2");
      
      System.out.println("Menge 1: " + arrayAsString(set1, set1Length));
      System.out.println("Menge 2: " + arrayAsString(set2, set2Length));
      System.out.println();
      
      // intersection
      if (set1Length < set2Length) {
         intersectionLength = findIntersection(set1, set2, intersection, set1Length, set2Length);
      } else {
         intersectionLength = findIntersection(set2, set1, intersection, set2Length, set1Length);
      }
      System.out.println("Durchschnitt: " + arrayAsString(intersection, intersectionLength));
      
      // combined
      for (int i = 0; i < set1Length; i++) {
         combined[i] = set1[i];
      }
      combinedLength = set1Length - 1;
      
      for (int i = 0; i < set2Length; i++) {
         boolean alreadyContained = false;
         for (int j = 0; j < combinedLength && !alreadyContained; j++) {
            if (combined[j] == set2[i]) {
               alreadyContained = true;
            }
         }
         if (!alreadyContained) {
            combined[combinedLength] = set2[i];
            combinedLength++;
         }
      }
      
      System.out.println("Vereinigung: " + arrayAsString(combined, combinedLength));
      
      
      // only set1
      only1Length = 0;
      for (int i = 0; i < set1Length; i++) {
         boolean exclusive = true;
         for (int j = 0; j < set2Length && exclusive; j++) {
            if (set1[i] == set2[j]) {
               exclusive = false;
            }
         }
         if (exclusive) {
            only1[only1Length] = set1[i];
            only1Length++;
         }
      }
      System.out.println("Menge 1 ohne Menge 2: " + arrayAsString(only1, only1Length));
      
      // only set2
      only2Length = 0;
      for (int i = 0; i < set2Length; i++) {
         boolean exclusive = true;
         for (int j = 0; j < set1Length && exclusive; j++) {
            if (set2[i] == set1[j]) {
               exclusive = false;
            }
         }
         if (exclusive) {
            only2[only2Length] = set2[i];
            only2Length++;
         }
      }
      System.out.println("Menge 2 ohne Menge 1: " + arrayAsString(only2, only2Length));

   }
   
   // "removes" duplicates in an array and returns new length
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
               i--; // check again for that index, in case the next value is also Integer.MIN_VALUE
            }
         }
      }
      
      return newLength;
   }
   
   private static int findIntersection(int[] shorter, int[] longer, int[] intersection, int longerLength, int shorterLength) {
      int intersectionLength = 0;
      
      for (int i = 0; i < longerLength; i++) {
         for (int j = 0; j < shorterLength; j++) {
            if (longer[i] == shorter[j]) {
               intersection[intersectionLength] = longer[i];
               intersectionLength++;
               break;
            }
         }
      }
      
      return intersectionLength;
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
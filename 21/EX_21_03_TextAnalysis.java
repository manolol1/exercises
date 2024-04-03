/********************************************
* Name:           Mario Ebenhofer
* Datum:          03.04. 2024
* HUE:            21
* Bsp:            03
* Beschreibung:   Haufigkeit von Buchstaben in String auswerten.
*********************************************/

import java.util.Scanner;

public class EX_21_03_TextAnalysis {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int[] count = new int[26]; // A = 0; B = 1; ...
      
      final String INPUT;
      
      System.out.print("Eingabe: ");
      INPUT = s.nextLine().toUpperCase();
      
      // count letters
      for (int i = 0; i < INPUT.length(); i++) {
         for (int j = 0; j < 26; j++) {
            if (INPUT.charAt(i) == 65 + j) {
               count[j]++;
            }
         }
      }
      
      // print statistic
      System.out.println("Statistik:");
      for (int i = 0; i < count.length; i++) {
         System.out.print((char) (65 + i) + ":");
         System.out.printf("%6d x", count[i]);
         System.out.println("\t\t" + graphicalNum(count[i]));
      }
   }
   
   private static String graphicalNum(int n) {
      StringBuilder result = new StringBuilder(n + n/5);
      
      for (int i = 0; i < n; i++) {
         if (i % 5 == 0 && i != 0) {
            result.append(" ");
         }
         result.append("|");
      }
      
      return result.toString();
   }
}
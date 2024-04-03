/********************************************
* Name:           Mario Ebenhofer
* Datum:          03.04. 2024
* HUE:            21
* Bsp:            02
* Beschreibung:   Normale Sprache mit B-Sprache "verschluesseln"
*********************************************/

import java.util.Scanner;

public class EX_21_02_B_Code {
   static final char REPLACEMENT = 'B';
   
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final String INPUT;
      
      System.out.print("Eingabe: ");
      INPUT = s.nextLine();
      
      System.out.print(REPLACEMENT + "-Sprache: ");
      System.out.println(encrypt(INPUT));
   }
   
   private static String encrypt(String in) {
      StringBuilder result = new StringBuilder(in.length() * 3);
      
      for (char ch : in.toCharArray()) {
         result.append(ch); // always add character once
         
         if (isVocal(ch)) {
            // append correct replacement, depending on case
            if (Character.isUpperCase(ch)) {
               result.append(REPLACEMENT);
            } else {
               result.append(Character.toLowerCase(REPLACEMENT));
            }
            
            result.append(ch);
         }
      }
      
      return result.toString();
   }
   
   private static String decrypt(String in) {
      StringBuilder result = new StringBuilder(in.length());
      
      char firstVocal;
      for (int i = 0; i < in.length() - 3; i++) {
         // find beginning vocal
         if (isVocal(in.charAt(i))) {
            firstVocal = in.charAt(i);
         } else {
            result.append(in.charAt[i]);
            continue;
         }
         
         if (in.charAt(i + 1) == REPLACEMENT) {
            if (in.charAt(i + 2) == firstVocal) {
               
            }
         }
      }
      
       return result.toString();
   }
   
   private static boolean isVocal(char ch) {
      final char[] VOCALS = {'A', 'I', 'U', 'E', 'O'};
      
      for (int i = 0; i < VOCALS.length; i++) {
         if (Character.toUpperCase(ch) == VOCALS[i]) {
            return true;
         }
      }
      
      return false;
   }
}
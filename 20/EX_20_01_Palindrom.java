/********************************************
* Name:           Mario Ebenhofer
* Datum:          20.03. 2024
* HUE:            20
* Bsp:            01
* Beschreibung:   Feststellen, ob Wort ein Palindrom ist.
*********************************************/

import java.util.Scanner;

public class EX_20_01_Palindrom {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      String word = "";
      
      System.out.print("Wort eingeben: ");
      word = s.nextLine();
      
      if (reverseString(word).equalsIgnoreCase(word)) {
         System.out.println(word + " ist ein Palindrom");
      } else {
         System.out.println(word + " ist kein Palindrom");
      }
   }
   
   private static String reverseString(String str) {
      StringBuilder reversed = new StringBuilder(str.length());
      
      for (int i = str.length() - 1; i >= 0; i--) {
         reversed.append(str.charAt(i));
      }
      
      return reversed.toString();
   }
}
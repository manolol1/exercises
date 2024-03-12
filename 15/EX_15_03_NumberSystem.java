/********************************************
* Name:           Mario Ebenhofer
* Datum:          24.01. 2024
* HUE:            15
* Bsp:            03
* Beschreibung:   Zahlensysteme umrechnen
*********************************************/

import java.util.Scanner;

public class EX_15_03_NumberSystem {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final String DIGITS = "0123456789ABCDEF";
      
      int dec = -1;
      int decCopy = dec;
      int base = -1;
      String result = "";
      
      System.out.println("Umwandlung in Zahlensysteme (Abbruch mit 0)\n");
      
      for (;;) {
         result = "";
         
         System.out.print("Zahl (1 - 10000000): ");
         dec = s.nextInt();
         if (dec < 1 || dec > 10000000) {
            System.out.println("Falsche Zahleneingabe");
            continue;
         }
         
         System.out.print("Basis (2 - 9 oder 16): ");
         base = s.nextInt();
         if ((base < 2 || base > 9) && base != 16) {
            System.out.println("Falsche Baseneingabe");
            continue;
         }
         
         decCopy = dec;
         
         while (dec > 0) {
            result = DIGITS.charAt(dec % base) + result;
            dec /= base;
         }
         
         System.out.printf("Die Zahl %d lautet zur Basis %d: %s\n\n", decCopy, base, result);
      }
   }
}
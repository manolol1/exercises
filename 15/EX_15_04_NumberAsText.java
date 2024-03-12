/********************************************
* Name:           Mario Ebenhofer
* Datum:          24.01. 2024
* HUE:            15
* Bsp:            04
* Beschreibung:   Zahl als Text ausgeben.
*********************************************/

import java.util.Scanner;

public class EX_15_04_NumberAsText {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int num = -1;
      String result = "";
      
      final String[] ONES = {
         "null", "ein", "zwei", "drei", "vier", "fuenf",
         "sechs", "sieben", "acht", "neun"
         };
      
      final String[] TENS = {
         "", "zehn", "zwanzig", "dreissig", "vierzig", "fuenfzig",
         "sechzig", "siebzig", "achtzig", "neunzig"
         };
      
      boolean numValid = false;
      
      while (!numValid) {
         System.out.print("Zahl: ");
         num = s.nextInt();
         
         if (num >= 0 && num <= 99) {
            numValid = true;
         } else {
            System.out.println("Zahl muss zwischen 0 und 99 liegen!");
         }
      }
   
      // special numbers
      switch (num) {
         case 1:
            result = "eins"; 
            break;
         case 11:
            result = "elf"; 
            break;
         case 12:
            result = "zwoelf"; 
            break;
         case 16:
            result = "sechzehn"; 
            break;
         case 17:
            result = "siebzehn"; 
            break;
            
         default:
         // single-digit numbers
            if (num < 10) {
               result = ONES[num];
            }
            // dividable by 10
            else if (num % 10 == 0) {
               result = TENS[num / 10];
            }
            // numbers with "zehn"
            else if (num < 20) {
               result = ONES[num % 10] + TENS[num / 10];
            }
            // other numbers
            else {
               result = ONES[num % 10] + "und" + TENS[num / 10];
            }
      }
      
      System.out.println(num + ":\t" + result);
   }
}
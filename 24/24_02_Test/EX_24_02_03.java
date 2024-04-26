/********************************************
* Name:          Mario Ebenhofer
* Date:          24.04 2024
* HUE:           24_02
* EX:            03
* Description:   Test (1AHIF)
*********************************************/

import java.util.Scanner;

public class EX_24_02_03 {
   public static void main(String[] args){
      String[] names = {"Eren", "Tabea", "Alex", "Maha", "Kaya", "Mate", "Reka", "Junis", "Kazuya", "Riko", "Rico", "Flynn"};
      boolean[] isFemale = {false, true, true, true, false, false, true, false, false, true, false, false};
      
      if (isFemale.length < names.length) {
         System.out.println("Error: not enough boolean values.");
         System.exit(1);
      }
      
      if (isFemale.length != names.length) {
         System.out.println("Warning: names and boolean arrays have different lengths.\n");
      }
      
      System.out.println("Female students:");
      for (int i = 0; i < names.length; i++) {
         if (isFemale[i]) {
            System.out.println(names[i]);
         }
      }
   }
}
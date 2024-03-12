/********************************************
* Name:           Mario Ebenhofer
* Datum:          13.12.2023
* HUE:            11
* Bsp:            02
* Beschreibung:   Muster Ausgeben
*********************************************/

import java.util.Scanner;

public class EX_11_02_Pattern1 {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int inputLb = 4;
      int inputUb = 20;
      int width;
      int hashtags;
      int pluses;
      
      System.out.print("Breite eingeben (4-20): ");
      width = s.nextInt();
      
      if (width < 4 || width > 20) {
         System.out.println("Ungueltiger Wert!!!");
         System.exit(0);
      }
      
      hashtags = width;
      pluses = 0;
      
      for (int i = 0; i <= width; i++) {
         for (int j = 0; j < hashtags; j++) {
            System.out.print("#");
         }
         for (int j = 0; j < pluses; j++) {
            System.out.print("+");
         }
         
         System.out.println();
         
         hashtags--;
         pluses++;
      }
   }
}
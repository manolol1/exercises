/********************************************
* Name:           Mario Ebenhofer
* Datum:          16.12.2023
* HUE:            11
* Bsp:            03
* Beschreibung:   Wuerfeln und Statistik ausgeben
*                 Zusatz: Mit Array
*********************************************/

import java.util.Scanner;

public class EX_11_03_Dice_Arrays {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final int maxRollsPerLine = 20;
      final int lb = 1;
      final int ub = 6;
      
      int amountOfRolls;
      int[] counter = {0, 0, 0, 0, 0, 0};
      int currRollsInLine = 0;
      int random;
      boolean newLine = true;
      
      System.out.print("Gesamtwuerfe: ");
      amountOfRolls = s.nextInt();
      
      if (amountOfRolls <= 0) {
         System.out.println("Ungueltige Eingabe. Gesamtwuerfe muss groesser als 0 sein!");
         System.exit(0);
      }
      
      for (int i = 0; i < amountOfRolls; i++) {
         random = (int) (Math.random() * (ub - lb + 1) + lb);
         
         if (!newLine) System.out.print(" ");
         System.out.print(random);
         
         newLine = false;
         currRollsInLine++;
         
         if (currRollsInLine >= maxRollsPerLine) {
            System.out.println();
            currRollsInLine = 0;
            newLine = true;
         }
         
         counter[random - 1]++;
      }
      
      System.out.println("\nStatistik:");
      
      for (int i = 0; i < counter.length; i++) {
         System.out.print((i + 1) + ":\t\t\t");
         System.out.print(counter[i] + " x\t");
         
         for (int j = 0; j < counter[i]; j++) {
            if (j % 5 == 0) System.out.print(" ");
            System.out.print("|");
         }
         System.out.println();
      }
   }
}
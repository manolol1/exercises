/********************************************
* Name:           Mario Ebenhofer
* Datum:          28.11.2023
* HUE:            09
* Bsp:            03
* Beschreibung:   Einer, Zehner und Hunderter von 3stelliger
*                 Zahl in bestimmtem Format Ausgeben
*********************************************/

public class EX_09_03_PrintHTO {
   public static void main(String[] args) {
      int lb = 274;
      int ub = 356;
      int temp = 0;
      
      for (int i = lb; i < ub; i++) {
         int j;

         System.out.print("\n" + i + ": ");
         
         temp = i / 100;
         for (j = 0; j < temp; j++) {
            System.out.print('H');
         }
         
         temp = i / 10 % 10;
         for (j = 0; j < temp; j++) {
            System.out.print('Z');
         }
         
         temp = i % 10;
         for (j = 0; j < temp; j++) {
            System.out.print('E');
         }
      }
   }
}
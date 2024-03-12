/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          25.10.2023
* HUE:            06
* Bsp:            01
* Beschreibung:   Ungerade Zahlen zwischen 1 und 100 ausgeben
*                 Immer 8 Zahlen pro Zeile
*                 Anschließend Summe der geraden u. ungeraden Zahlen ausgeben
************************************************************/


public class Ex_06_01_Numbers {
   public static void main(String[] args) {
      int lb = 1;
      int ub = 100;
      int numbersPerLine = 8;
      
      int currPerLine = 0;
      int sumOdd = 0;
      int sumEven = 0;
      int ctr = lb;
      
      // Output numbers and calculate sum of odd numbers
      while (ctr <= ub) {
         System.out.print(ctr + "\t");
         sumOdd += ctr;
         ctr += 2;
         currPerLine++;
         if (currPerLine == numbersPerLine) {
            currPerLine = 0;
            System.out.println();
         }
      }
      
      // calculate sum of even numbers
      ctr = lb - 1;
      while (ctr <= ub) {
         sumEven += ctr;
         ctr += 2;
      }
      
      System.out.println("\n");
      System.out.println("Summe der geraden Zahlen: " + sumEven);
      System.out.println("Summe der ungeraden Zahlen: " + sumOdd);
   }
}
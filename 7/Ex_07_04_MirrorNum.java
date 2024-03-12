/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          08.11.2023
* HUE:            07
* Bsp:            04
* Beschreibung:   Dreiziffrige Spiegelzahlen ausgeben.
*                 8 Zahlen pro Zeile
************************************************************/

import java.util.Scanner;

public class Ex_07_04_MirrorNum {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int maxNumbersPerLine = 0;
      int lb = 0;
      int ub = 0;
      
      boolean inputPending = true;
      
      int ctr;
      int tempNum;
      int tempNumReversed;
      int tempUnitDigit;
      int currNumbersPerLine = 0;
      
      // User Input
      while (inputPending) {
         System.out.print("lowerBound: ");
         lb = s.nextInt();
         System.out.print("upperBound: ");
         ub = s.nextInt();
         System.out.print("numbers per line: ");
         maxNumbersPerLine = s.nextInt();
         
         if (ub <= lb) {
            System.out.println("lowerBound must be greater than upperBound!");
            System.out.println("Please try again.\n");
         } else if (maxNumbersPerLine <= 0) {
            System.out.println("numbersPerLine must be greater than 0!");
            System.out.println("Please try again.\n");
         } else {
            inputPending = false;
         }
      }
      
      ctr = lb;
      
      while (ctr <= ub) {
         tempNum = ctr;
         tempNumReversed = 0;
         
         // reverse current number
         while (tempNum != 0) {
            tempUnitDigit = tempNum % 10;
            tempNumReversed = tempNumReversed * 10 + tempUnitDigit;
            tempNum /= 10;
         }
         
         // output current number if reversed number is the same
         if (tempNumReversed == ctr) {
            System.out.print(ctr + "  ");
            currNumbersPerLine++;
         }
         
         // enter a new line if limit of numbers per line is reached
         if (currNumbersPerLine >= maxNumbersPerLine) {
            System.out.println();
            currNumbersPerLine = 0;
         }
         
         ctr++;
      }
   }
}
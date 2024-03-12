/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          08.11.2023
* HUE:            07
* Bsp:            03
* Beschreibung:   Teiler fuer Zahlen in einem Bereich ausgeben
************************************************************/

import java.util.Scanner;

public class Ex_07_03_DividerII {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int lb = 0;
      int ub = 0;
      int outerCtr = 1;
      int calculatingCtr = 1;
      int tempSumOfDividers = 0;
      boolean inputPending = true;
      
      // User Input
      while (inputPending) {
         System.out.print("lowerBound: ");
         lb = s.nextInt();
         System.out.print("upperBound: ");
         ub = s.nextInt();
         
         if (ub <= lb) {
            System.out.println("lowerBound must be greater than upperBound!");
            System.out.println("Please try again.\n");
         }
         else if (lb < 0) {
            System.out.println("This program doesn't work with negative numbers.");
            System.out.println("Please try again.\n");
         } else {
            inputPending = false;
         }
      }
      
      outerCtr = lb;
      
      // outer loop
      while (outerCtr <= ub) {
         // calculate number of dividers
         while (calculatingCtr <= outerCtr / 2) {
            if (outerCtr % calculatingCtr == 0) {
               tempSumOfDividers++;
            }
            calculatingCtr++;
         }
         System.out.println("Die Zahl " + outerCtr + " hat " + tempSumOfDividers + " echte Teiler.");
         // reset variables for inner loop
         tempSumOfDividers = 0;
         calculatingCtr = 1;
         // proceed to next number
         outerCtr++;
      } 
   }
}
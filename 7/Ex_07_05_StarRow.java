/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          08.11.2023
* HUE:            07
* Bsp:            05
* Beschreibung:   Output stars and spaces according to user input
************************************************************/

import java.util.Scanner;

public class Ex_07_05_StarRow {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int totalAmountOfStars = 0;
      int starsPerGroup = 0;
      
      boolean inputPending = true;
      
      int currStarsPrinted = 0;
      int currStarsInGroup = 0;
      
      // User Input
      while (inputPending) {
         System.out.print("total amount of stars: ");
         totalAmountOfStars = s.nextInt();
         System.out.print("stars per group ");
         starsPerGroup = s.nextInt();
         
         if (totalAmountOfStars < 1 || starsPerGroup < 1) {
            System.out.println("totalAmountOfStars and starsPerGroup must be greater than 0.");
            System.out.println("Please try again.\n");
         } else {
            inputPending = false;
         }
      }
      while (currStarsPrinted < totalAmountOfStars) {
         System.out.print("*");
         currStarsPrinted++;
         currStarsInGroup++;
         if (currStarsInGroup >= starsPerGroup) {
            System.out.print(" ");
            currStarsInGroup = 0;
         }
      }
   }
}
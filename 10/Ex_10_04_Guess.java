/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          25.10.2023
* HUE:            06
* Bsp:            05
* Beschreibung:   Zahlen-Ratespiel
************************************************************/

import java.util.Scanner;
import java.lang.Math;

public class Ex_10_04_Guess {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int maxAttempts = 7;
      int currAttempts = 0;
      int lb = 1;
      int ub = 100;
      int guess;
      int randomNum = (int) (Math.random() * (ub - lb + 1) + lb);
      boolean gameWon = false;
      
      System.out.println("Errate eine Zufaellige Zahl zwischen " + lb + " und " + ub + "!");
      
      while (currAttempts < maxAttempts && !gameWon) {
         currAttempts++;
         System.out.print(currAttempts + ". Tipp: ");
         guess = s.nextInt();
         
         if (guess == randomNum) {
            gameWon = true;
         }
         else if (randomNum < guess) {
            System.out.println("Die gesuchte Zahl ist kleiner.");
         } else {
            System.out.println("Die gesuchte Zahl ist groesser.");
         }
      }
      
      if (gameWon) {
         if (currAttempts == 1) {
            System.out.println("Gratuliere, du hast die Zahl mit nur einem Versuch erraten!");
         } else {
            System.out.println("Gratuliere, du hast die Zahl mit " + currAttempts + " Versuchen erraten!");
         }
      } else {
         System.out.println("Leider auch beim " + maxAttempts + ". Versuch falsch. Die gesuchte Zahl waere " + randomNum + " gewesen.");
      }
   }
}
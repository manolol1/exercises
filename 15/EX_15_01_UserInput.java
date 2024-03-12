/********************************************
* Name:           Mario Ebenhofer
* Datum:          24.01. 2024
* HUE:            15
* Bsp:            01
* Beschreibung:   Benutzereingabe
*********************************************/

import java.util.Scanner;

public class EX_15_01_UserInput {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      boolean inputCorrect = false;
      int attempts = 0;
      
      int numOfNumbers = 0;
      boolean[] numbers;
      
      int num = 0;
      int digits = 0;
      
      while (numOfNumbers < 1) {
         System.out.print("Anzahl der Zahlen: ");
         numOfNumbers = s.nextInt();
      }
      
      numbers = new boolean[numOfNumbers];
      
      while (!inputCorrect) {
         inputCorrect = true;
         attempts++;
         for (int i = 1; i <= numOfNumbers; i++) {
            digits = 0;
            System.out.printf("Zahl%d: ", i);
            num = s.nextInt();
            
            while (num != 0) {
               num /= 10;
               digits++;
            }
            
            if (digits > numOfNumbers) {
               inputCorrect = false;
               break;
            } else {
               numbers[digits - 1] = true;
            }
         }
         
         for (boolean i : numbers) {
            if (i == false) {
               inputCorrect = false;
               break;
            }
         }
         
         if (!inputCorrect) System.out.println("\nNicht korrekt.\n");
      }
      System.out.printf("Korrekt. Beim %d. Versuch", attempts);
   }
}
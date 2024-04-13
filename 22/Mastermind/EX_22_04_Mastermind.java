/********************************************
* Name:                Mario Ebenhofer
* Date:                10.04. 2024
* HUE:                 22
* EX:                  04
* Description:         Mastermind (game)
* Additional classes:  Attempt
*********************************************/

import java.util.*;

public class EX_22_04_Mastermind {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final int LENGTH = 4, LB = 1, UB = 6; // (UB - LB) must be >= LENGTH!
      final int MAX_ATTEMPTS = 9;
      
      int[] correct = randomUniqueArray(LENGTH, LB, UB);
      Attempt[] attempts = new Attempt[MAX_ATTEMPTS];
      
      System.out.printf("Try to guess the correct order of %d random numbers between %d and %d!\n", LENGTH, LB, UB);
      System.out.println("You have " + MAX_ATTEMPTS + " attempts.");
      System.out.println("Individual numbers should be seperated by a space.");
      System.out.println("Example: 1 4 6 2\n");
      
      System.out.println("Press Enter to start!");
      s.nextLine();
      
      for (int i = 0; i < MAX_ATTEMPTS; i++) {
         clearScreen();
         
         for (int j = 0; j < i; j++) {
            attempts[j].print();
         }
         System.out.println();
         
         int[] currAttempt = getAttempt(s, LENGTH, i + 1);
         int white = 0, red = 0;
         
         // count pins
         boolean[] redChecked = new boolean[LENGTH];
         boolean[] whiteChecked = new boolean[LENGTH];
      
         // check if number is in currect position
         for (int j = 0; j < LENGTH; j++) {
            if (currAttempt[j] == correct[j]) {
               red++;
               redChecked[j] = true;
               whiteChecked[j] = true;
            }
         }
         
         // check if number exists in correct[]
         for (int j = 0; j < LENGTH; j++) {
            if (!whiteChecked[j]) {
               for (int k = 0; k < LENGTH; k++) {
                  if (!redChecked[k] && currAttempt[j] == correct[k]) {
                     white++;
                     redChecked[k] = true;
                     break;
                  }
               }
            }
         }
         attempts[i] = new Attempt(currAttempt, red, white);
         
         // check winning condition
         if (red == LENGTH) {
            clearScreen();
            for (int j = 0; j <= i; j++) {
               attempts[j].print();
            }
            
            System.out.println("\nYOU WON!");
            System.out.println("Attempts: " + (i + 1));
            System.exit(0);
         }
         
         System.out.println();
      }
      
      System.out.println("\nYOU LOST!");
      System.out.print("The correct combination was:");
      for (int i = 0; i < LENGTH; i++) {
         System.out.print(" " + correct[i]);
      }
   }
   
   private static int[] randomUniqueArray(int length, int lb, int ub) {
      // check, if generating that array is even possible (avoid infinite loop)
      if ((ub - lb + 1) < length) {
         System.out.println("ERROR: Could not generate unique array - not enough possible numbers!");
         System.exit(1);
      }
      
      int[] ar = new int[length];
      int random = 0;
      boolean unique;
      
      for (int i = 0; i < length; i++) {
         unique = false;
         
         while (!unique) {
            random = random(lb, ub);
            unique = true;
            
            for (int j = 0; j < i; j++) {
               if (ar[j] == random) {
                  unique = false;
                  break;
               }
               unique = true;
            }
         }
         ar[i] = random;
      }
      return ar;
   }
   
   private static int[] getAttempt(Scanner s, int length, int attempt) {
      int[] result = new int[length];
      int index = 0;
      String input;
      String num = "";
      
      System.out.println(attempt + ". Attempt: ");
      input = s.nextLine();
      
      String[] strings = input.split(" ");
      //System.out.println(Arrays.toString(strings));
      
      try {
         for (int i = 0; i < length; i++) {
            result[i] = Integer.parseInt(strings[i]);
         }
      } catch (Exception e) {
         System.out.println("Couldn't parse input. Make sure, that your input is formatted correctly!\n");
         return getAttempt(s, length, attempt);
      }
      
      return result;
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
   
   private static void clearScreen() {
      System.out.println("\n".repeat(100));
   }
}

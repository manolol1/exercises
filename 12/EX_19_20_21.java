// Hausübung 12
// Aufgaben 19 bis 21
// Mario Ebenhofer

import java.util.Arrays;

public class EX_19_20_21 {

   static boolean isPrime(int num) {
      boolean isPrime = true;
      
      if (num <= 1) 
         return false;
      
      for (int i = 2; i <= Math.sqrt(num) && isPrime; i++) {
         if (num % i == 0) isPrime = false;
      }
      
      return isPrime;
   }
   
   static int nextPrime(int startNum) {
      int currNum = startNum + 1;
      
      while (!isPrime(currNum)) {
         currNum++;
      }
      
      return currNum;
   }
   
   
   public static void main(String[] args) {
      
      /* Aufgabe 19 */
      // Formatierung leider nicht ganz Korrekt:
      // Eine Leerzeile zu viel nach den "Middle Lines"
      {
         final int TOTAL_ROLLS = 100;
         
         int[] count = {0, 0, 0, 0, 0, 0};
         int[] countCopy;
         boolean middlePrintFinished = false;
         
         // Roll Dice and count numbers
         for (int i = 0; i < TOTAL_ROLLS; i++) {
            count[(int) (Math.random() * 6)]++;
         }
         
         countCopy = Arrays.copyOf(count, 6);
         
         System.out.println("Gesamtwuerfe: " + TOTAL_ROLLS);
         
         // Top Line
         for (int i = 0; i < 6; i++) {
            if (countCopy[i] % 5 == 0) {
               System.out.print("|||||");
               countCopy[i] -= 5;
            } else {
               for (int j = 0; j < 5; j++) {
                  if (countCopy[i] % 5 > 0) {
                     System.out.print("|");
                     countCopy[i]--;
                  } else {
                     System.out.print(" ");
                  }
               }
            }
            System.out.print("\t\t");
         }
         
         System.out.println();
         
         // Middle Lines
         while (!middlePrintFinished) {
            middlePrintFinished = true;
            for (int i = 0; i < 6; i++) {
               if (countCopy[i] >= 5) {
                  System.out.print("|||||");
                  countCopy[i] -= 5;
                  middlePrintFinished = false;
               } else {
                  if (i < 5) {
                     System.out.print("\t");
                  }
               }
               System.out.print("\t\t");
            }
            System.out.println();
         }
         
         // Bottom Line
         for (int i = 0; i < 6; i++) {
            System.out.print((i + 1) + ": " + count[i] + "x\t");
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 20 */
      {
         final int NUM_OF_TWINS = 20;
         int num1 = 3;
         int num2 = 5;
         int twinsFound = 0;
         
         while (twinsFound < NUM_OF_TWINS) {
            if (num2 - num1 == 2) {
               System.out.println(num1 + " und " + num2);
               twinsFound++;
            }
            
            num1 = nextPrime(num1);
            num2 = nextPrime(num2);
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 21 */
      {
         final int HEIGHT = 5;
         int spacesBefore = HEIGHT - 1;
         int spacesMiddle = 1;
         
         // first line
         for (int i = 1; i <= spacesBefore; i++) {
            System.out.print(" ");
         }
         System.out.println("*");
         spacesBefore--;
         
         // middle lines
         while (spacesBefore > 0) {
            for (int i = 0; i < spacesBefore; i++) {
               System.out.print(" ");
            }
            spacesBefore--;
            
            System.out.print("*");
            
            for (int i = 1; i <= spacesMiddle; i++) {
               System.out.print(" ");
            }
            spacesMiddle += 2;
            
            System.out.println("*");
         }
         
         
         // last line
         for (int i = 1; i < HEIGHT * 2; i++) {
            System.out.print("*");
         }
      }
   }
}
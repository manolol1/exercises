// Hausübung 12
// Aufgaben 1 bis 5
// Mario Ebenhofer

public class EX_1_2_3_4_5 {

   // Method that returns a random number between lb and ub
   static int getRandom(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
   
   
   public static void main(String[] args) {
      
      /* Aufgabe 1 */
      {
         final int SIZE = 10;
         int currNum = 1;
         
         for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= i; j++) {
               System.out.print(currNum);
               if (currNum == 9) currNum = -1;
               currNum++;
            }
            System.out.println();
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 2 */
      {
         final int LB = 1;
         final int UB = 150;
         final int MAX_NUMBERS_PER_LINE = 8;
         
         int currNumbersInLine = 0;
         
         for (int i = LB; i <= UB; i++) {
            if ((i % 3 == 0 || i % 4 == 0 || i % 5 == 0) && !(i % 12 == 0 || i % 15 == 0 || i % 20 == 0)) {
               System.out.print(i);
               if (i < 10) {
                  System.out.print("     ");
               } else if (i < 100) {
                  System.out.print("    ");
               } else if (i < 1000) {
                  System.out.print("   ");
               } else if (i < 10000) {
                  System.out.print("  ");
               } else {
                  System.out.print(" ");
               }
               
               currNumbersInLine++;
               
               if (currNumbersInLine >= MAX_NUMBERS_PER_LINE) {
                  System.out.println();
                  currNumbersInLine = 0;
               }
            }
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 3 */
      {
         final int AMOUNT_OF_NUMBERS = 10;
         final int LB = 1;
         final int UB = 100;
         
         int[] numbers = new int[AMOUNT_OF_NUMBERS];
         int min = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;
         int sum = 0;
         double average;
         
         System.out.print("Zufallszahlen: ");
         
         for (int i = 0; i < numbers.length; i++) {
            numbers[i] = getRandom(LB, UB);
            
            if (i > 0) System.out.print(" ");
            System.out.print(numbers[i]);
            
            if (numbers[i] < min) min = numbers[i];
            if (numbers[i] > max) max = numbers[i];
            
            sum += numbers[i];
         }
         
         average = (double) sum / AMOUNT_OF_NUMBERS;
         
         System.out.println("\nMinimum: \t" + min);
         System.out.println("Maximum: \t" + max);
         System.out.println("Durchschnitt: \t" + average);
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 4 */
      {
         final int LB = 1;
         final int UB = 100;
         
         int random;
         int max = Integer.MIN_VALUE;
         int ctr = 0;
         boolean stillBigger = true;
         
         while (stillBigger) {
            random = getRandom(LB, UB);
            if (ctr != 0) System.out.print(" ");
            System.out.print(random);
            
            if (random > max) {
               max = random;
               ctr++;
            } else {
               stillBigger = false;
            }
         }
         
         if (ctr == 1) {
            System.out.println("\nEs wurde genau " + ctr + " aufsteigende Zahl erzeugt.");
         } else {
            System.out.println("\nEs wurden genau " + ctr + " aufsteigende Zahlen erzeugt.");
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 5 */
      {
         final int SIZE = 50000;
         
         int spaces = SIZE - 1;
         int stars = 1;
         
         for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < spaces; j++) {
               System.out.print(" ");
            }
            
            for (int j = 0; j < stars; j++) {
               System.out.print("*");
            }
            
            System.out.println();
            spaces--;
            stars++;
         }
      }
   }
}
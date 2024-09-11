/********************************************
* Name:          Mario Ebenhofer
* Date:          11.01. 2024
* HUE:           00
* EX:            02
* Description:   Basic methods for 2D-Arrays
*********************************************/

public class EX_00_02_Zweidimensionale_Arrays {
   public static void main(String[] args) {
      int[][] twoDim = new int[10][10];
      int lower = 1;
      int upper = 50;
      
      fillTwoDim(twoDim, lower, upper);
      
      System.out.println("Zweidimensionales Array");
      outTwoDim(twoDim);
      
      shiftLeft(twoDim);
      
      System.out.println("\nErste Spalte wurde zur letzten");
      outTwoDim(twoDim);
      
      int count = deletePrim(twoDim);
      
      System.out.println("\nArray ohne Primzahlen");
      outTwoDim(twoDim);
   }
   
   /** Fill a 2D-Array with random numbers */
   public static void fillTwoDim(int[][] twoDim, int lower, int upper) {
      for (int i = 0; i < twoDim.length; i++) {
         for (int j = 0; j < twoDim[i].length; j++) {
            twoDim[i][j] = random(lower, upper);
         }
      }
   }
   
   /** Print a 2D-Array as a table */
   public static void outTwoDim(int[][] twoDim) {
      for (int i = 0; i < twoDim.length; i++) {
         System.out.print(twoDim[i][0]);
         for (int j = 1; j < twoDim[i].length; j++) {
            System.out.print(" " + twoDim[i][j]);
         }
         System.out.println();
      }
   }
   
   /** Shift a 2D-Array to the left */
   public static void shiftLeft(int[][] twoDim) {
      for (int i = 0; i < twoDim.length; i++) {
         // shift line
         int temp = twoDim[i][0];
         for (int j = 1; j < twoDim[i].length; j++) {
            twoDim[i][j - 1] = twoDim[i][j];
         }
         twoDim[i][twoDim[i].length - 1] = temp;
      }
   }
   
   /** Set prime numbers in a 2D-Array to 0 */
   public static int deletePrim(int[][] twoDim) {
      int count = 0;
      
      for (int i = 0; i < twoDim.length; i++) {
         for (int j = 0; j < twoDim[i].length; j++) {
            if (isPrime(twoDim[i][j])) {
               count++;
               twoDim[i][j] = 0;
            }
         }
      }
      
      return count;
   }
   
   /** check if n is a prime number */
   public static boolean isPrime(int n) {
      if (n < 0) return false;
      for (int i = 2; i <= Math.sqrt(n); i++) {
         if (n % i == 0) return false;
      }
      return true;
   }
   
   public static int random(int lower, int upper) {
      return (int) (Math.random() * (upper - lower + 1) + lower);
   }
}
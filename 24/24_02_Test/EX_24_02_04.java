/********************************************
* Name:          Mario Ebenhofer
* Date:          24.04 2024
* HUE:           24_02
* EX:            04
* Description:   Test (1AHIF)
*********************************************/

import java.util.Scanner;

public class EX_24_02_04 {
   public static void main(String[] args){
      int[] solution = eratosthenes(userInput(10, 1000));
      
      printArray(solution, 1000);
   }
   
   private static int[] eratosthenes(int ub) {
      int[] ar = new int[ub - 1];
      
      for (int i = 0; i < ar.length; i++) {
         ar[i] = i + 2;
      }
      
      return removeZeroes(ar);
   }
   
   private static int[] removeZeroes(int[] ar) {
      int count = 0;
      int[] result;
      
      // find length of the resulting array by counting all non-zero elements
      for (int j = 0; j < ar.length; j++) {
         if (ar[j] != 0) {
            count++;
         }
      }
   
      // copy all non-zero values to a new array
      result = new int[count];
      int i = 0;
      for (int j = 0; j < ar.length; j++) {
         if (ar[j] != 0) {
            result[i] = ar[j];
            i++;
         }
      }
   
      return result;
   }
   
   private static int userInput(Scanner s, int lb, int ub) {
      System.out.printf("Enter a number (%d-%d): ", lb, ub);
      int n = s.nextInt();
      
      if (n >= lb && n <= ub) {
         s.close();
         return n;
      } else {
         System.out.println("Invalid input. Retry!\n");
         return userInput(s, lb, ub);
      }
   }

   private static int userInput(int lb, int ub) {
      Scanner s = new Scanner(System.in);
      return userInput(s, lb, ub);
   }
   
   private static void printArray(int[] ar, int valuesPerLine) {
      for (int i = 0; i < ar.length; i++) {
         if (i % valuesPerLine == 0 && i != 0) {
            System.out.println();
         }
         
         System.out.print(ar[i] + "  ");
      }
      System.out.println();
   }
   
}
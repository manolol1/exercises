/********************************************
* Name:          Mario Ebenhofer
* Date:          24.04 2024
* HUE:           24_02
* EX:            01
* Description:   Test (1AHIF)
*********************************************/

import java.util.Scanner;

public class EX_24_02_01 {
   public static void main(String[] args){
      int[] ar = new int[20];
      
      fillArray(ar, -20, 20);
      
      System.out.println("filling:");
      printArray(ar, 4);
      System.out.println();
      
      System.out.println("Max: " + max(ar));
      System.out.println();
      
      System.out.println("shift left:");
      shiftLeft(ar); 
      printArray(ar, 4);
      System.out.println();
      
      int n = userInput(0, 20);
      System.out.println();
      
      System.out.println("absolute values above " + n + ":");
      arPrintMinValue(ar, n);
      System.out.println();
      
      System.out.println("sorting:");
      sort(ar);
      printArray(ar, 5);
      System.out.println();
      
      System.out.println("cumulating:");
      printArray(cumulate(ar), 5);
   }
   
   private static void fillArray(int[] ar, int lb, int ub) {
      for (int i = 0; i < ar.length; i++) {
         ar[i] = random(lb, ub);
      }
   }
   
   private static void printArray(int[] ar, int valuesPerLine) {
      // calculate reqired spacing, so that all values are nicely alligned
      int digitSpacing = String.valueOf(max(ar)).length();
      // also account for the - in negative numbers
      if (min(ar) < 0) {
         digitSpacing++;
      }
      
      for (int i = 0; i < ar.length; i++) {
         if (i % valuesPerLine == 0 && i != 0) {
            System.out.println();
         }
         
         System.out.printf("%" + (digitSpacing) + "d ", ar[i]);
      }
      System.out.println();
   }
   
   private static int max(int[] ar) {
      int max = ar[0];
      for (int n : ar) {
         if (n > max) {
            max = n;
         }
      }
      return max;
   }
   
   private static int min(int[] ar) {
      int min = ar[0];
      for (int n : ar) {
         if (n < min) {
            min = n;
         }
      }
      return min;
   }
   
   private static void shiftLeft(int[] ar) {
      while (ar[0] < 0) {
         shiftLeftOnce(ar);
      }
   }
   
   private static void shiftLeftOnce(int[] ar) {
      int temp = ar[0];
      
      for (int i = 0; i < ar.length - 1; i++) {
         ar[i] = ar[i + 1];
      }
      ar[ar.length - 1] = temp;
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
   
   private static void arPrintMinValue(int[] ar, int minValue) {
      minValue = Math.abs(minValue);
      for (int i = 0; i < ar.length; i++) {
         if (Math.abs(ar[i]) > minValue) {
            System.out.print(ar[i] + "  "); // assuming that actual value should be printed (not the absolute one)
         }
      }
      System.out.println();
   }
   
   // sort an array using SelectionSort
   private static void sort(int[] ar) {
      for (int i = 0; i < ar.length; i++) {
         int min = i;
         
         for (int j = i + 1; j < ar.length; j++) {
            if (ar[j] < ar[min]) {
               min = j;
            }
         }
         
         // swap
         int temp = ar[i];
         ar[i] = ar[min];
         ar[min] = temp;
      }
   }
   
   private static int[] cumulate(int[] ar) {
      int[] solution = new int[ar.length];
      
      int sum = 0;
      
      for (int i = 0; i < ar.length; i++) {
         sum += ar[i];
         solution[i] = sum;
      }
      
      return solution;
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1)) + lb;
   }
}
/********************************************
* Name:           Mario Ebenhofer
* Datum:          13.12.2023
* HUE:            11
* Bsp:            01-1
* Beschreibung:   komplizierte Primfaktorenzerlegung
*********************************************/


import java.util.Scanner;

public class EX_11_01_PrimeFactor {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int num;
      int temp;
      int currPrime = 2;
      int factors = 0;
      
      System.out.print("Number: ");
      num = s.nextInt();
      temp = num;
      
      if (num <= 1) {
         System.out.println("Invalid Input. Number must be greater than 1.");
         System.exit(0);
      }
      
      long start = System.nanoTime();
      
      System.out.print(num + " = ");
      
      while (temp >= 2) {
         if (temp % currPrime == 0) {
            if (factors > 0) {
               System.out.print(" * ");
            }
            System.out.print(currPrime);
            temp /= currPrime;
            factors++;
         } else {
            currPrime = getNextPrime(currPrime);
         }
      }
      
      long finish = System.nanoTime();
      long time = finish - start;
      System.out.println("\n\nTime: " + time + "ns");
   }
   
   static boolean isPrime(int num) {
      boolean isPrime = true;
      int divider = 2;
      
      // Only calculate square root once to improve performance
      int squareRoot = (int) Math.sqrt(num);
      
      while (isPrime && divider <= squareRoot) {
         if (num % divider == 0) {
            isPrime = false;
         }
         divider+= 2;
      }
      return isPrime;
   }
   
   static int getNextPrime(int currPrime) {
      int currNum = currPrime + 1;
      boolean nextPrimeFound = false;
      while (!nextPrimeFound) {
         if (isPrime(currNum)) {
            nextPrimeFound = true;
         } else {
            currNum++;
         }
      }
      return currNum;
   }
}
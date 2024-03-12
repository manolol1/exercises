/********************************************
* Name:           Mario Ebenhofer
* Datum:          13.12.2023
* HUE:            11
* Bsp:            01-2
* Beschreibung:   einfache Primfaktorzerlegung
*********************************************/

import java.util.Scanner;

public class EX_11_01_PrimeFactor_2 {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
   
      int num, temp;
      int factor = 2;
      int factors = 0;
      
      System.out.print("Number: ");
      num = s.nextInt();
      
      if (num <= 1) {
         System.out.println("Invalid Input. Number must be greater than 1.");
         System.exit(0);
      }
      
      long start = System.nanoTime();
      
      temp = num;
      
      System.out.print(num + " = ");
      
      while (temp >= 2) {
         if (temp % factor == 0) {
            temp /= factor;
            
            if (factors > 0) {
               System.out.print(" * ");
            }
            System.out.print(factor);
            
            factors++;
         } else {
            factor++;
         }
      }
      
      long finish = System.nanoTime();
      long time = finish - start;
      System.out.println("\n\nTime: " + time + "ns");
   }
}
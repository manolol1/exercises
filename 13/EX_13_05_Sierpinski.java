/********************************************
* Name:           Mario Ebenhofer
* Datum:          10.01. 2024
* HUE:            13
* Bsp:            05
* Beschreibung:   Teppich ausgeben
*********************************************/

import java.util.Scanner;

public class EX_13_05_Sierpinski {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int n = 0;
      int nThird;
      
      System.out.print("n: ");
      n = s.nextInt();
      
      if (n % 3 != 0) {
         System.out.println("n muss durch 3 teilbar sein!");
         System.exit(1);
      }
      
      nThird = n / 3;
      
      // Top
      for (int i = 0; i < nThird; i ++) {
         for (int j = 0; j < n; j++) {
            System.out.print("*");
         }
         System.out.println();
      }
      
      // Middle
      for (int i = 0; i < nThird; i++) {
         for (int j = 0; j < nThird; j++) {
            System.out.print("*");
         } 
         
         for (int j = 0; j < nThird; j++) {
            System.out.print(" ");
         }
         
         for (int j = 0; j < nThird; j++) {
            System.out.print("*");
         }
         
         System.out.println();
      }
      
      // Bottom
      for (int i = 0; i < nThird; i ++) {
         for (int j = 0; j < n; j++) {
            System.out.print("*");
         }
         System.out.println();
      }
   }
}
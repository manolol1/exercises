/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          15.11.2023
* HUE:            08
* Bsp:            04
* Beschreibung:   Maximum von 4 Zahlen bestimmen
************************************************************/

import java.util.Scanner;

public class Ex_08_04_Maximum {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int a, b, c, d;
      int max = Integer.MIN_VALUE;
      int secondMax = Integer.MIN_VALUE;
      
      // Input
      System.out.print("Zahl 1: ");
      a = s.nextInt();
      System.out.print("Zahl 2: ");
      b = s.nextInt();
      System.out.print("Zahl 3: ");
      c = s.nextInt();
      System.out.print("Zahl 4: ");
      d = s.nextInt();
      
      
      
      // Determine largest and 2nd largest number
      // by comparing them to the current max and secondMax values
      if (a > max) {
         secondMax = max;
         max = a;
      } else if (b > secondMax) {
         secondMax = a;
      }
      
      if (b > max) {
         secondMax = max;
         max = b;
      } else if (b > secondMax) {
         secondMax = b;
      }
   
      if (c > max) {
         secondMax = max;
         max = c;
      } else if (c > secondMax) {
         secondMax = c;
      }
   
      if (d > max) {
         secondMax = max;
         max = d;
      } else if (d > secondMax) {
         secondMax = d;
      }
      
      System.out.println("Das Maximum der Zahlen " + a + ", " + b + ", " + c + " und " + d + " lautet: " + max);
      System.out.println("Die zweitgroesste Zahl ist " + secondMax + ".");
   }
}
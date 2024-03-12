/*************************************************
* Name:           Mario Ebenhofer
* Datum:          18.10.2023
* HUE:            05
* Bsp:            02
* Beschreibung:   Kleinste von 3 Zahlen berechnen
*                 und ausgeben.
**************************************************/

import java.util.Scanner;

public class EX_05_02_Min{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int num1;
      int num2;
      int num3;
      int min;
      
      System.out.print("Erste Zahl: ");
      num1 = s.nextInt();
      System.out.print("Zweite Zahl: ");
      num2 = s.nextInt();
      System.out.print("Dritte Zahl: ");
      num3 = s.nextInt();
      
      if(num1 <= num2 && num1 < num3){
         min = num1;
      }
      else if(num2 <= num3 && num2 < num1){
         min = num2;
      } else{
         min = num3;
      }
      
      System.out.println("Minimum von den Zahlen " + num1 + ", " + num2 + " und " + num3 + " ist " + min);
   }
}